package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper
{
  private static final int BASE_SETTLE_DURATION = 256;
  public static final int DIRECTION_ALL = 3;
  public static final int DIRECTION_HORIZONTAL = 1;
  public static final int DIRECTION_VERTICAL = 2;
  public static final int EDGE_ALL = 15;
  public static final int EDGE_BOTTOM = 8;
  public static final int EDGE_LEFT = 1;
  public static final int EDGE_RIGHT = 2;
  private static final int EDGE_SIZE = 20;
  public static final int EDGE_TOP = 4;
  public static final int INVALID_POINTER = -1;
  private static final int MAX_SETTLE_DURATION = 600;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String TAG = "ViewDragHelper";
  private static final Interpolator sInterpolator = new ViewDragHelper.1();
  private int mActivePointerId = -1;
  private final Callback mCallback;
  private View mCapturedView;
  private int mDragState;
  private int[] mEdgeDragsInProgress;
  private int[] mEdgeDragsLocked;
  private int mEdgeSize;
  private int[] mInitialEdgesTouched;
  private float[] mInitialMotionX;
  private float[] mInitialMotionY;
  private float[] mLastMotionX;
  private float[] mLastMotionY;
  private float mMaxVelocity;
  private float mMinVelocity;
  private final ViewGroup mParentView;
  private int mPointersDown;
  private boolean mReleaseInProgress;
  private ScrollerCompat mScroller;
  private final Runnable mSetIdleRunnable = new ViewDragHelper.2(this);
  private int mTouchSlop;
  private int mTrackingEdges;
  private VelocityTracker mVelocityTracker;
  
  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, Callback paramCallback)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (paramCallback == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.mParentView = paramViewGroup;
    this.mCallback = paramCallback;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.mEdgeSize = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.mMaxVelocity = paramViewGroup.getScaledMaximumFlingVelocity();
    this.mMinVelocity = paramViewGroup.getScaledMinimumFlingVelocity();
    this.mScroller = ScrollerCompat.create(paramContext, sInterpolator);
  }
  
  private boolean checkNewEdgeDrag(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    boolean bool1 = bool2;
    if ((this.mInitialEdgesTouched[paramInt1] & paramInt2) == paramInt2)
    {
      bool1 = bool2;
      if ((this.mTrackingEdges & paramInt2) != 0)
      {
        bool1 = bool2;
        if ((this.mEdgeDragsLocked[paramInt1] & paramInt2) != paramInt2)
        {
          bool1 = bool2;
          if ((this.mEdgeDragsInProgress[paramInt1] & paramInt2) != paramInt2)
          {
            if ((paramFloat1 > this.mTouchSlop) || (paramFloat2 > this.mTouchSlop)) {
              break label108;
            }
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      return bool1;
      label108:
      if ((paramFloat1 < paramFloat2 * 0.5F) && (this.mCallback.onEdgeLock(paramInt2)))
      {
        int[] arrayOfInt = this.mEdgeDragsLocked;
        arrayOfInt[paramInt1] |= paramInt2;
        bool1 = bool2;
      }
      else
      {
        bool1 = bool2;
        if ((this.mEdgeDragsInProgress[paramInt1] & paramInt2) == 0)
        {
          bool1 = bool2;
          if (paramFloat1 > this.mTouchSlop) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private boolean checkTouchSlop(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramView == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      int i;
      if (this.mCallback.getViewHorizontalDragRange(paramView) > 0)
      {
        i = 1;
        label28:
        if (this.mCallback.getViewVerticalDragRange(paramView) <= 0) {
          break label89;
        }
      }
      label89:
      for (int j = 1;; j = 0)
      {
        if ((i == 0) || (j == 0)) {
          break label95;
        }
        bool1 = bool2;
        if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= this.mTouchSlop * this.mTouchSlop) {
          break;
        }
        bool1 = true;
        break;
        i = 0;
        break label28;
      }
      label95:
      if (i != 0)
      {
        bool1 = bool2;
        if (Math.abs(paramFloat1) > this.mTouchSlop) {
          bool1 = true;
        }
      }
      else
      {
        bool1 = bool2;
        if (j != 0)
        {
          bool1 = bool2;
          if (Math.abs(paramFloat2) > this.mTouchSlop) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private float clampMag(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    for (;;)
    {
      return paramFloat2;
      if (f > paramFloat3)
      {
        paramFloat2 = paramFloat3;
        if (paramFloat1 <= 0.0F) {
          paramFloat2 = -paramFloat3;
        }
      }
      else
      {
        paramFloat2 = paramFloat1;
      }
    }
  }
  
  private int clampMag(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      paramInt2 = 0;
    }
    for (;;)
    {
      return paramInt2;
      if (i > paramInt3)
      {
        paramInt2 = paramInt3;
        if (paramInt1 <= 0) {
          paramInt2 = -paramInt3;
        }
      }
      else
      {
        paramInt2 = paramInt1;
      }
    }
  }
  
  private void clearMotionHistory()
  {
    if (this.mInitialMotionX == null) {}
    for (;;)
    {
      return;
      Arrays.fill(this.mInitialMotionX, 0.0F);
      Arrays.fill(this.mInitialMotionY, 0.0F);
      Arrays.fill(this.mLastMotionX, 0.0F);
      Arrays.fill(this.mLastMotionY, 0.0F);
      Arrays.fill(this.mInitialEdgesTouched, 0);
      Arrays.fill(this.mEdgeDragsInProgress, 0);
      Arrays.fill(this.mEdgeDragsLocked, 0);
      this.mPointersDown = 0;
    }
  }
  
  private void clearMotionHistory(int paramInt)
  {
    if (this.mInitialMotionX == null) {}
    for (;;)
    {
      return;
      this.mInitialMotionX[paramInt] = 0.0F;
      this.mInitialMotionY[paramInt] = 0.0F;
      this.mLastMotionX[paramInt] = 0.0F;
      this.mLastMotionY[paramInt] = 0.0F;
      this.mInitialEdgesTouched[paramInt] = 0;
      this.mEdgeDragsInProgress[paramInt] = 0;
      this.mEdgeDragsLocked[paramInt] = 0;
      this.mPointersDown &= (1 << paramInt ^ 0xFFFFFFFF);
    }
  }
  
  private int computeAxisDuration(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramInt1 = 0;
      return paramInt1;
    }
    int i = this.mParentView.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f2 = j;
    float f1 = j;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f1 + f2) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      break;
    }
  }
  
  private int computeSettleDuration(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = clampMag(paramInt3, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    paramInt3 = clampMag(paramInt4, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    int n = Math.abs(paramInt1);
    paramInt4 = Math.abs(paramInt2);
    int j = Math.abs(i);
    int m = Math.abs(paramInt3);
    int i1 = j + m;
    int k = n + paramInt4;
    float f1;
    if (i != 0)
    {
      f1 = j / i1;
      if (paramInt3 == 0) {
        break label165;
      }
    }
    label165:
    for (float f2 = m / i1;; f2 = paramInt4 / k)
    {
      paramInt1 = computeAxisDuration(paramInt1, i, this.mCallback.getViewHorizontalDragRange(paramView));
      paramInt2 = computeAxisDuration(paramInt2, paramInt3, this.mCallback.getViewVerticalDragRange(paramView));
      float f3 = paramInt1;
      return (int)(f2 * paramInt2 + f1 * f3);
      f1 = n / k;
      break;
    }
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, float paramFloat, Callback paramCallback)
  {
    paramViewGroup = create(paramViewGroup, paramCallback);
    paramViewGroup.mTouchSlop = ((int)(paramViewGroup.mTouchSlop * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, Callback paramCallback)
  {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }
  
  private void dispatchViewReleased(float paramFloat1, float paramFloat2)
  {
    this.mReleaseInProgress = true;
    this.mCallback.onViewReleased(this.mCapturedView, paramFloat1, paramFloat2);
    this.mReleaseInProgress = false;
    if (this.mDragState == 1) {
      setDragState(0);
    }
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  private void dragTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.mCapturedView.getLeft();
    int j = this.mCapturedView.getTop();
    if (paramInt3 != 0)
    {
      paramInt1 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, paramInt1, paramInt3);
      this.mCapturedView.offsetLeftAndRight(paramInt1 - i);
    }
    for (;;)
    {
      if (paramInt4 != 0)
      {
        paramInt2 = this.mCallback.clampViewPositionVertical(this.mCapturedView, paramInt2, paramInt4);
        this.mCapturedView.offsetTopAndBottom(paramInt2 - j);
      }
      for (;;)
      {
        if ((paramInt3 != 0) || (paramInt4 != 0)) {
          this.mCallback.onViewPositionChanged(this.mCapturedView, paramInt1, paramInt2, paramInt1 - i, paramInt2 - j);
        }
        return;
      }
    }
  }
  
  private void ensureMotionHistorySizeForId(int paramInt)
  {
    if ((this.mInitialMotionX == null) || (this.mInitialMotionX.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      if (this.mInitialMotionX != null)
      {
        System.arraycopy(this.mInitialMotionX, 0, arrayOfFloat1, 0, this.mInitialMotionX.length);
        System.arraycopy(this.mInitialMotionY, 0, arrayOfFloat4, 0, this.mInitialMotionY.length);
        System.arraycopy(this.mLastMotionX, 0, arrayOfFloat3, 0, this.mLastMotionX.length);
        System.arraycopy(this.mLastMotionY, 0, arrayOfFloat2, 0, this.mLastMotionY.length);
        System.arraycopy(this.mInitialEdgesTouched, 0, arrayOfInt3, 0, this.mInitialEdgesTouched.length);
        System.arraycopy(this.mEdgeDragsInProgress, 0, arrayOfInt2, 0, this.mEdgeDragsInProgress.length);
        System.arraycopy(this.mEdgeDragsLocked, 0, arrayOfInt1, 0, this.mEdgeDragsLocked.length);
      }
      this.mInitialMotionX = arrayOfFloat1;
      this.mInitialMotionY = arrayOfFloat4;
      this.mLastMotionX = arrayOfFloat3;
      this.mLastMotionY = arrayOfFloat2;
      this.mInitialEdgesTouched = arrayOfInt3;
      this.mEdgeDragsInProgress = arrayOfInt2;
      this.mEdgeDragsLocked = arrayOfInt1;
    }
  }
  
  private boolean forceSettleCapturedViewAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = false;
    int j = this.mCapturedView.getLeft();
    int i = this.mCapturedView.getTop();
    paramInt1 -= j;
    paramInt2 -= i;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mScroller.abortAnimation();
      setDragState(0);
    }
    for (;;)
    {
      return bool;
      paramInt3 = computeSettleDuration(this.mCapturedView, paramInt1, paramInt2, paramInt3, paramInt4);
      this.mScroller.startScroll(j, i, paramInt1, paramInt2, paramInt3);
      setDragState(2);
      bool = true;
    }
  }
  
  private int getEdgesTouched(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt1 < this.mParentView.getLeft() + this.mEdgeSize) {
      i = 1;
    }
    int j = i;
    if (paramInt2 < this.mParentView.getTop() + this.mEdgeSize) {
      j = i | 0x4;
    }
    i = j;
    if (paramInt1 > this.mParentView.getRight() - this.mEdgeSize) {
      i = j | 0x2;
    }
    paramInt1 = i;
    if (paramInt2 > this.mParentView.getBottom() - this.mEdgeSize) {
      paramInt1 = i | 0x8;
    }
    return paramInt1;
  }
  
  private void releaseViewForPointerUp()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
    dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
  }
  
  private void reportNewEdgeDrags(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 1)) {}
    for (;;)
    {
      int i = j;
      if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 4)) {
        i = j | 0x4;
      }
      j = i;
      if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 2)) {
        j = i | 0x2;
      }
      i = j;
      if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 8)) {
        i = j | 0x8;
      }
      if (i != 0)
      {
        int[] arrayOfInt = this.mEdgeDragsInProgress;
        arrayOfInt[paramInt] |= i;
        this.mCallback.onEdgeDragStarted(i, paramInt);
      }
      return;
      j = 0;
    }
  }
  
  private void saveInitialMotion(float paramFloat1, float paramFloat2, int paramInt)
  {
    ensureMotionHistorySizeForId(paramInt);
    float[] arrayOfFloat = this.mInitialMotionX;
    this.mLastMotionX[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.mInitialMotionY;
    this.mLastMotionY[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.mInitialEdgesTouched[paramInt] = getEdgesTouched((int)paramFloat1, (int)paramFloat2);
    this.mPointersDown |= 1 << paramInt;
  }
  
  private void saveLastMotion(MotionEvent paramMotionEvent)
  {
    int j = MotionEventCompat.getPointerCount(paramMotionEvent);
    for (int i = 0; i < j; i++)
    {
      int k = MotionEventCompat.getPointerId(paramMotionEvent, i);
      float f2 = MotionEventCompat.getX(paramMotionEvent, i);
      float f1 = MotionEventCompat.getY(paramMotionEvent, i);
      this.mLastMotionX[k] = f2;
      this.mLastMotionY[k] = f1;
    }
  }
  
  public void abort()
  {
    cancel();
    if (this.mDragState == 2)
    {
      int j = this.mScroller.getCurrX();
      int i = this.mScroller.getCurrY();
      this.mScroller.abortAnimation();
      int m = this.mScroller.getCurrX();
      int k = this.mScroller.getCurrY();
      this.mCallback.onViewPositionChanged(this.mCapturedView, m, k, m - j, k - i);
    }
    setDragState(0);
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      i = localViewGroup.getChildCount() - 1;
      if (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((paramInt3 + j >= localView.getLeft()) && (paramInt3 + j < localView.getRight()) && (paramInt4 + k >= localView.getTop()) && (paramInt4 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2, paramInt3 + j - localView.getLeft(), paramInt4 + k - localView.getTop()))) {
          paramBoolean = true;
        }
      }
    }
    for (;;)
    {
      return paramBoolean;
      i--;
      break;
      if ((paramBoolean) && ((ViewCompat.canScrollHorizontally(paramView, -paramInt1)) || (ViewCompat.canScrollVertically(paramView, -paramInt2)))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
  }
  
  public void cancel()
  {
    this.mActivePointerId = -1;
    clearMotionHistory();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public void captureChildView(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.mParentView) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }
    this.mCapturedView = paramView;
    this.mActivePointerId = paramInt;
    this.mCallback.onViewCaptured(paramView, paramInt);
    setDragState(1);
  }
  
  public boolean checkTouchSlop(int paramInt)
  {
    boolean bool2 = false;
    int j = this.mInitialMotionX.length;
    for (int i = 0;; i++)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (checkTouchSlop(paramInt, i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
    }
  }
  
  public boolean checkTouchSlop(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!isPointerDown(paramInt2)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      int i;
      if ((paramInt1 & 0x1) == 1)
      {
        i = 1;
        label28:
        if ((paramInt1 & 0x2) != 2) {
          break label114;
        }
      }
      float f2;
      float f1;
      label114:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        f2 = this.mLastMotionX[paramInt2] - this.mInitialMotionX[paramInt2];
        f1 = this.mLastMotionY[paramInt2] - this.mInitialMotionY[paramInt2];
        if ((i == 0) || (paramInt1 == 0)) {
          break label119;
        }
        bool1 = bool2;
        if (f2 * f2 + f1 * f1 <= this.mTouchSlop * this.mTouchSlop) {
          break;
        }
        bool1 = true;
        break;
        i = 0;
        break label28;
      }
      label119:
      if (i != 0)
      {
        bool1 = bool2;
        if (Math.abs(f2) > this.mTouchSlop) {
          bool1 = true;
        }
      }
      else
      {
        bool1 = bool2;
        if (paramInt1 != 0)
        {
          bool1 = bool2;
          if (Math.abs(f1) > this.mTouchSlop) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public boolean continueSettling(boolean paramBoolean)
  {
    boolean bool;
    if (this.mDragState == 2)
    {
      bool = this.mScroller.computeScrollOffset();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      int i = k - this.mCapturedView.getLeft();
      int j = m - this.mCapturedView.getTop();
      if (i != 0) {
        this.mCapturedView.offsetLeftAndRight(i);
      }
      if (j != 0) {
        this.mCapturedView.offsetTopAndBottom(j);
      }
      if ((i != 0) || (j != 0)) {
        this.mCallback.onViewPositionChanged(this.mCapturedView, k, m, i, j);
      }
      if ((!bool) || (k != this.mScroller.getFinalX()) || (m != this.mScroller.getFinalY())) {
        break label197;
      }
      this.mScroller.abortAnimation();
      bool = this.mScroller.isFinished();
    }
    label192:
    label197:
    for (;;)
    {
      if (!bool)
      {
        if (paramBoolean) {
          this.mParentView.post(this.mSetIdleRunnable);
        }
      }
      else {
        if (this.mDragState != 2) {
          break label192;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        return paramBoolean;
        setDragState(0);
        break;
      }
    }
  }
  
  public View findTopChildUnder(int paramInt1, int paramInt2)
  {
    int i = this.mParentView.getChildCount() - 1;
    View localView;
    if (i >= 0)
    {
      localView = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(i));
      if ((paramInt1 < localView.getLeft()) || (paramInt1 >= localView.getRight()) || (paramInt2 < localView.getTop()) || (paramInt2 >= localView.getBottom())) {}
    }
    for (;;)
    {
      return localView;
      i--;
      break;
      localView = null;
    }
  }
  
  public void flingCapturedView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mReleaseInProgress) {
      throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }
    this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), paramInt1, paramInt3, paramInt2, paramInt4);
    setDragState(2);
  }
  
  public int getActivePointerId()
  {
    return this.mActivePointerId;
  }
  
  public View getCapturedView()
  {
    return this.mCapturedView;
  }
  
  public int getEdgeSize()
  {
    return this.mEdgeSize;
  }
  
  public float getMinVelocity()
  {
    return this.mMinVelocity;
  }
  
  public int getTouchSlop()
  {
    return this.mTouchSlop;
  }
  
  public int getViewDragState()
  {
    return this.mDragState;
  }
  
  public boolean isCapturedViewUnder(int paramInt1, int paramInt2)
  {
    return isViewUnder(this.mCapturedView, paramInt1, paramInt2);
  }
  
  public boolean isEdgeTouched(int paramInt)
  {
    boolean bool2 = false;
    int j = this.mInitialEdgesTouched.length;
    for (int i = 0;; i++)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (isEdgeTouched(paramInt, i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
    }
  }
  
  public boolean isEdgeTouched(int paramInt1, int paramInt2)
  {
    if ((isPointerDown(paramInt2)) && ((this.mInitialEdgesTouched[paramInt2] & paramInt1) != 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isPointerDown(int paramInt)
  {
    boolean bool = true;
    if ((this.mPointersDown & 1 << paramInt) != 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean isViewUnder(View paramView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramView == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramInt1 >= paramView.getLeft())
      {
        bool1 = bool2;
        if (paramInt1 < paramView.getRight())
        {
          bool1 = bool2;
          if (paramInt2 >= paramView.getTop())
          {
            bool1 = bool2;
            if (paramInt2 < paramView.getBottom()) {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  public void processTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    int m = MotionEventCompat.getActionMasked(paramMotionEvent);
    int k = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (m == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    float f2;
    float f1;
    switch (m)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
      for (;;)
      {
        return;
        f2 = paramMotionEvent.getX();
        f1 = paramMotionEvent.getY();
        j = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        paramMotionEvent = findTopChildUnder((int)f2, (int)f1);
        saveInitialMotion(f2, f1, j);
        tryCaptureViewForDrag(paramMotionEvent, j);
        i = this.mInitialEdgesTouched[j];
        if ((this.mTrackingEdges & i) != 0)
        {
          this.mCallback.onEdgeTouched(i & this.mTrackingEdges, j);
          continue;
          i = MotionEventCompat.getPointerId(paramMotionEvent, k);
          f2 = MotionEventCompat.getX(paramMotionEvent, k);
          f1 = MotionEventCompat.getY(paramMotionEvent, k);
          saveInitialMotion(f2, f1, i);
          if (this.mDragState == 0)
          {
            tryCaptureViewForDrag(findTopChildUnder((int)f2, (int)f1), i);
            j = this.mInitialEdgesTouched[i];
            if ((this.mTrackingEdges & j) != 0) {
              this.mCallback.onEdgeTouched(j & this.mTrackingEdges, i);
            }
          }
          else if (isCapturedViewUnder((int)f2, (int)f1))
          {
            tryCaptureViewForDrag(this.mCapturedView, i);
            continue;
            if (this.mDragState == 1)
            {
              i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
              f1 = MotionEventCompat.getX(paramMotionEvent, i);
              f2 = MotionEventCompat.getY(paramMotionEvent, i);
              i = (int)(f1 - this.mLastMotionX[this.mActivePointerId]);
              j = (int)(f2 - this.mLastMotionY[this.mActivePointerId]);
              dragTo(this.mCapturedView.getLeft() + i, this.mCapturedView.getTop() + j, i, j);
              saveLastMotion(paramMotionEvent);
            }
            else
            {
              k = MotionEventCompat.getPointerCount(paramMotionEvent);
              for (i = j; i < k; i++)
              {
                j = MotionEventCompat.getPointerId(paramMotionEvent, i);
                f1 = MotionEventCompat.getX(paramMotionEvent, i);
                float f4 = MotionEventCompat.getY(paramMotionEvent, i);
                float f3 = f1 - this.mInitialMotionX[j];
                f2 = f4 - this.mInitialMotionY[j];
                reportNewEdgeDrags(f3, f2, j);
                if (this.mDragState == 1) {
                  break;
                }
                View localView = findTopChildUnder((int)f1, (int)f4);
                if ((checkTouchSlop(localView, f3, f2)) && (tryCaptureViewForDrag(localView, j))) {
                  break;
                }
              }
              saveLastMotion(paramMotionEvent);
            }
          }
        }
      }
    case 6: 
      j = MotionEventCompat.getPointerId(paramMotionEvent, k);
      if ((this.mDragState == 1) && (j == this.mActivePointerId))
      {
        k = MotionEventCompat.getPointerCount(paramMotionEvent);
        label542:
        if (i >= k) {
          break label679;
        }
        m = MotionEventCompat.getPointerId(paramMotionEvent, i);
        if (m == this.mActivePointerId) {
          break label633;
        }
        f1 = MotionEventCompat.getX(paramMotionEvent, i);
        f2 = MotionEventCompat.getY(paramMotionEvent, i);
        if ((findTopChildUnder((int)f1, (int)f2) != this.mCapturedView) || (!tryCaptureViewForDrag(this.mCapturedView, m))) {
          break label633;
        }
      }
      break;
    }
    label633:
    label679:
    for (i = this.mActivePointerId;; i = -1)
    {
      if (i == -1) {
        releaseViewForPointerUp();
      }
      clearMotionHistory(j);
      break;
      i++;
      break label542;
      if (this.mDragState == 1) {
        releaseViewForPointerUp();
      }
      cancel();
      break;
      if (this.mDragState == 1) {
        dispatchViewReleased(0.0F, 0.0F);
      }
      cancel();
      break;
    }
  }
  
  void setDragState(int paramInt)
  {
    if (this.mDragState != paramInt)
    {
      this.mDragState = paramInt;
      this.mCallback.onViewDragStateChanged(paramInt);
      if (paramInt == 0) {
        this.mCapturedView = null;
      }
    }
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.mTrackingEdges = paramInt;
  }
  
  public void setMinVelocity(float paramFloat)
  {
    this.mMinVelocity = paramFloat;
  }
  
  public boolean settleCapturedViewAt(int paramInt1, int paramInt2)
  {
    if (!this.mReleaseInProgress) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return forceSettleCapturedViewAt(paramInt1, paramInt2, (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
  }
  
  public boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int j = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (j == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (j)
    {
    case 4: 
    default: 
      if (this.mDragState != 1) {
        break;
      }
    }
    for (;;)
    {
      return bool;
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      i = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      saveInitialMotion(f2, f1, i);
      paramMotionEvent = findTopChildUnder((int)f2, (int)f1);
      if ((paramMotionEvent == this.mCapturedView) && (this.mDragState == 2)) {
        tryCaptureViewForDrag(paramMotionEvent, i);
      }
      j = this.mInitialEdgesTouched[i];
      if ((this.mTrackingEdges & j) == 0) {
        break;
      }
      this.mCallback.onEdgeTouched(j & this.mTrackingEdges, i);
      break;
      j = MotionEventCompat.getPointerId(paramMotionEvent, i);
      f1 = MotionEventCompat.getX(paramMotionEvent, i);
      f2 = MotionEventCompat.getY(paramMotionEvent, i);
      saveInitialMotion(f1, f2, j);
      if (this.mDragState == 0)
      {
        i = this.mInitialEdgesTouched[j];
        if ((this.mTrackingEdges & i) == 0) {
          break;
        }
        this.mCallback.onEdgeTouched(i & this.mTrackingEdges, j);
        break;
      }
      if (this.mDragState != 2) {
        break;
      }
      paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
      if (paramMotionEvent != this.mCapturedView) {
        break;
      }
      tryCaptureViewForDrag(paramMotionEvent, j);
      break;
      j = MotionEventCompat.getPointerCount(paramMotionEvent);
      for (i = 0; i < j; i++)
      {
        int k = MotionEventCompat.getPointerId(paramMotionEvent, i);
        float f4 = MotionEventCompat.getX(paramMotionEvent, i);
        float f3 = MotionEventCompat.getY(paramMotionEvent, i);
        f2 = f4 - this.mInitialMotionX[k];
        f1 = f3 - this.mInitialMotionY[k];
        reportNewEdgeDrags(f2, f1, k);
        if (this.mDragState == 1) {
          break;
        }
        View localView = findTopChildUnder((int)f4, (int)f3);
        if ((localView != null) && (checkTouchSlop(localView, f2, f1)) && (tryCaptureViewForDrag(localView, k))) {
          break;
        }
      }
      saveLastMotion(paramMotionEvent);
      break;
      clearMotionHistory(MotionEventCompat.getPointerId(paramMotionEvent, i));
      break;
      cancel();
      break;
      bool = false;
    }
  }
  
  public boolean smoothSlideViewTo(View paramView, int paramInt1, int paramInt2)
  {
    this.mCapturedView = paramView;
    this.mActivePointerId = -1;
    return forceSettleCapturedViewAt(paramInt1, paramInt2, 0, 0);
  }
  
  boolean tryCaptureViewForDrag(View paramView, int paramInt)
  {
    boolean bool = true;
    if ((paramView == this.mCapturedView) && (this.mActivePointerId == paramInt)) {}
    for (;;)
    {
      return bool;
      if ((paramView != null) && (this.mCallback.tryCaptureView(paramView, paramInt)))
      {
        this.mActivePointerId = paramInt;
        captureChildView(paramView, paramInt);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public static abstract class Callback
  {
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public int getOrderedChildIndex(int paramInt)
    {
      return paramInt;
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return 0;
    }
    
    public int getViewVerticalDragRange(View paramView)
    {
      return 0;
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2) {}
    
    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }
    
    public void onEdgeTouched(int paramInt1, int paramInt2) {}
    
    public void onViewCaptured(View paramView, int paramInt) {}
    
    public void onViewDragStateChanged(int paramInt) {}
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2) {}
    
    public abstract boolean tryCaptureView(View paramView, int paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/ViewDragHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */