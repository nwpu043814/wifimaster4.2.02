package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;

public class SwipeRefreshLayout
  extends ViewGroup
{
  private static final float ACCELERATE_INTERPOLATION_FACTOR = 1.5F;
  private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0F;
  private static final int[] LAYOUT_ATTRS = { 16842766 };
  private static final float MAX_SWIPE_DISTANCE_FACTOR = 0.6F;
  private static final float PROGRESS_BAR_HEIGHT = 4.0F;
  private static final int REFRESH_TRIGGER_DISTANCE = 120;
  private static final long RETURN_TO_ORIGINAL_POSITION_TIMEOUT = 300L;
  private final AccelerateInterpolator mAccelerateInterpolator;
  private final Animation mAnimateToStartPosition = new SwipeRefreshLayout.1(this);
  private final Runnable mCancel = new SwipeRefreshLayout.6(this);
  private float mCurrPercentage = 0.0F;
  private int mCurrentTargetOffsetTop;
  private final DecelerateInterpolator mDecelerateInterpolator;
  private float mDistanceToTriggerSync = -1.0F;
  private MotionEvent mDownEvent;
  private int mFrom;
  private float mFromPercentage = 0.0F;
  private OnRefreshListener mListener;
  private int mMediumAnimationDuration;
  private int mOriginalOffsetTop;
  private float mPrevY;
  private SwipeProgressBar mProgressBar;
  private int mProgressBarHeight;
  private boolean mRefreshing = false;
  private final Runnable mReturnToStartPosition = new SwipeRefreshLayout.5(this);
  private final Animation.AnimationListener mReturnToStartPositionListener = new SwipeRefreshLayout.3(this);
  private boolean mReturningToStart;
  private final Animation.AnimationListener mShrinkAnimationListener = new SwipeRefreshLayout.4(this);
  private Animation mShrinkTrigger = new SwipeRefreshLayout.2(this);
  private View mTarget;
  private int mTouchSlop;
  
  public SwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mMediumAnimationDuration = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.mProgressBar = new SwipeProgressBar(this);
    this.mProgressBarHeight = ((int)(getResources().getDisplayMetrics().density * 4.0F));
    this.mDecelerateInterpolator = new DecelerateInterpolator(2.0F);
    this.mAccelerateInterpolator = new AccelerateInterpolator(1.5F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void animateOffsetToStartPosition(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.mAnimateToStartPosition.reset();
    this.mAnimateToStartPosition.setDuration(this.mMediumAnimationDuration);
    this.mAnimateToStartPosition.setAnimationListener(paramAnimationListener);
    this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
    this.mTarget.startAnimation(this.mAnimateToStartPosition);
  }
  
  private void ensureTarget()
  {
    if (this.mTarget == null)
    {
      if ((getChildCount() > 1) && (!isInEditMode())) {
        throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
      }
      this.mTarget = getChildAt(0);
      this.mOriginalOffsetTop = (this.mTarget.getTop() + getPaddingTop());
    }
    if ((this.mDistanceToTriggerSync == -1.0F) && (getParent() != null) && (((View)getParent()).getHeight() > 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.mDistanceToTriggerSync = ((int)Math.min(((View)getParent()).getHeight() * 0.6F, localDisplayMetrics.density * 120.0F));
    }
  }
  
  private void setTargetOffsetTopAndBottom(int paramInt)
  {
    this.mTarget.offsetTopAndBottom(paramInt);
    this.mCurrentTargetOffsetTop = this.mTarget.getTop();
  }
  
  private void setTriggerPercentage(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      this.mCurrPercentage = 0.0F;
    }
    for (;;)
    {
      return;
      this.mCurrPercentage = paramFloat;
      this.mProgressBar.setTriggerPercentage(paramFloat);
    }
  }
  
  private void startRefresh()
  {
    removeCallbacks(this.mCancel);
    this.mReturnToStartPosition.run();
    setRefreshing(true);
    this.mListener.onRefresh();
  }
  
  private void updateContentOffsetTop(int paramInt)
  {
    int j = this.mTarget.getTop();
    int i;
    if (paramInt > this.mDistanceToTriggerSync) {
      i = (int)this.mDistanceToTriggerSync;
    }
    for (;;)
    {
      setTargetOffsetTopAndBottom(i - j);
      return;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
  }
  
  private void updatePositionTimeout()
  {
    removeCallbacks(this.mCancel);
    postDelayed(this.mCancel, 300L);
  }
  
  public boolean canChildScrollUp()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 14) {
      if ((this.mTarget instanceof AbsListView))
      {
        AbsListView localAbsListView = (AbsListView)this.mTarget;
        if ((localAbsListView.getChildCount() > 0) && ((localAbsListView.getFirstVisiblePosition() > 0) || (localAbsListView.getChildAt(0).getTop() < localAbsListView.getPaddingTop()))) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if (this.mTarget.getScrollY() > 0)
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        bool = ViewCompat.canScrollVertically(this.mTarget, -1);
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.mProgressBar.draw(paramCanvas);
  }
  
  public boolean isRefreshing()
  {
    return this.mRefreshing;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    removeCallbacks(this.mCancel);
    removeCallbacks(this.mReturnToStartPosition);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.mReturnToStartPosition);
    removeCallbacks(this.mCancel);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    ensureTarget();
    if ((this.mReturningToStart) && (paramMotionEvent.getAction() == 0)) {
      this.mReturningToStart = false;
    }
    boolean bool1 = bool2;
    if (isEnabled())
    {
      bool1 = bool2;
      if (!this.mReturningToStart)
      {
        bool1 = bool2;
        if (!canChildScrollUp()) {
          bool1 = onTouchEvent(paramMotionEvent);
        }
      }
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    return bool2;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getMeasuredWidth();
    paramInt4 = getMeasuredHeight();
    this.mProgressBar.setBounds(0, 0, paramInt2, this.mProgressBarHeight);
    if (getChildCount() == 0) {}
    for (;;)
    {
      return;
      View localView = getChildAt(0);
      paramInt1 = getPaddingLeft();
      paramInt3 = this.mCurrentTargetOffsetTop + getPaddingTop();
      localView.layout(paramInt1, paramInt3, paramInt2 - getPaddingLeft() - getPaddingRight() + paramInt1, paramInt4 - getPaddingTop() - getPaddingBottom() + paramInt3);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((getChildCount() > 1) && (!isInEditMode())) {
      throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
    }
    if (getChildCount() > 0) {
      getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool2 = false;
    switch (i)
    {
    default: 
      bool1 = bool2;
    case 0: 
    case 2: 
      float f3;
      float f2;
      for (;;)
      {
        return bool1;
        this.mCurrPercentage = 0.0F;
        this.mDownEvent = MotionEvent.obtain(paramMotionEvent);
        this.mPrevY = this.mDownEvent.getY();
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (this.mDownEvent != null)
        {
          bool1 = bool2;
          if (!this.mReturningToStart)
          {
            f3 = paramMotionEvent.getY();
            f2 = f3 - this.mDownEvent.getY();
            if (f2 <= this.mTouchSlop) {
              break label273;
            }
            if (f2 <= this.mDistanceToTriggerSync) {
              break;
            }
            startRefresh();
            bool1 = true;
          }
        }
      }
      setTriggerPercentage(this.mAccelerateInterpolator.getInterpolation(f2 / this.mDistanceToTriggerSync));
      float f1 = f2;
      if (this.mPrevY > f3) {
        f1 = f2 - this.mTouchSlop;
      }
      updateContentOffsetTop((int)f1);
      if ((this.mPrevY > f3) && (this.mTarget.getTop() < this.mTouchSlop))
      {
        removeCallbacks(this.mCancel);
        label222:
        this.mPrevY = paramMotionEvent.getY();
      }
      break;
    }
    label273:
    for (boolean bool1 = true;; bool1 = false)
    {
      break;
      updatePositionTimeout();
      break label222;
      bool1 = bool2;
      if (this.mDownEvent == null) {
        break;
      }
      this.mDownEvent.recycle();
      this.mDownEvent = null;
      bool1 = bool2;
      break;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void setColorScheme(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ensureTarget();
    Resources localResources = getResources();
    paramInt1 = localResources.getColor(paramInt1);
    paramInt2 = localResources.getColor(paramInt2);
    paramInt3 = localResources.getColor(paramInt3);
    paramInt4 = localResources.getColor(paramInt4);
    this.mProgressBar.setColorScheme(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener)
  {
    this.mListener = paramOnRefreshListener;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.mRefreshing != paramBoolean)
    {
      ensureTarget();
      this.mCurrPercentage = 0.0F;
      this.mRefreshing = paramBoolean;
      if (!this.mRefreshing) {
        break label37;
      }
      this.mProgressBar.start();
    }
    for (;;)
    {
      return;
      label37:
      this.mProgressBar.stop();
    }
  }
  
  private class BaseAnimationListener
    implements Animation.AnimationListener
  {
    private BaseAnimationListener() {}
    
    public void onAnimationEnd(Animation paramAnimation) {}
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  public static abstract interface OnRefreshListener
  {
    public abstract void onRefresh();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/SwipeRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */