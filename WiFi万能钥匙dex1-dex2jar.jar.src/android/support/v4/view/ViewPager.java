package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager
  extends ViewGroup
{
  private static final int CLOSE_ENOUGH = 2;
  private static final Comparator<ItemInfo> COMPARATOR = new ViewPager.1();
  private static final boolean DEBUG = false;
  private static final int DEFAULT_GUTTER_SIZE = 16;
  private static final int DEFAULT_OFFSCREEN_PAGES = 1;
  private static final int DRAW_ORDER_DEFAULT = 0;
  private static final int DRAW_ORDER_FORWARD = 1;
  private static final int DRAW_ORDER_REVERSE = 2;
  private static final int INVALID_POINTER = -1;
  private static final int[] LAYOUT_ATTRS = { 16842931 };
  private static final int MAX_SETTLE_DURATION = 600;
  private static final int MIN_DISTANCE_FOR_FLING = 25;
  private static final int MIN_FLING_VELOCITY = 400;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  private static final String TAG = "ViewPager";
  private static final boolean USE_CACHE = false;
  private static final Interpolator sInterpolator = new ViewPager.2();
  private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
  private int mActivePointerId = -1;
  private PagerAdapter mAdapter;
  private OnAdapterChangeListener mAdapterChangeListener;
  private int mBottomPageBounds;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  private int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private final Runnable mEndScrollRunnable = new ViewPager.3(this);
  private int mExpectedAdapterCount;
  private long mFakeDragBeginTime;
  private boolean mFakeDragging;
  private boolean mFirstLayout = true;
  private float mFirstOffset = -3.4028235E38F;
  private int mFlingDistance;
  private int mGutterSize;
  private boolean mIgnoreGutter;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private OnPageChangeListener mInternalPageChangeListener;
  private boolean mIsBeingDragged;
  private boolean mIsUnableToDrag;
  private final ArrayList<ItemInfo> mItems = new ArrayList();
  private float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset = Float.MAX_VALUE;
  private EdgeEffectCompat mLeftEdge;
  private Drawable mMarginDrawable;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private boolean mNeedCalculatePageOffsets = false;
  private PagerObserver mObserver;
  private int mOffscreenPageLimit = 1;
  private OnPageChangeListener mOnPageChangeListener;
  private int mPageMargin;
  private PageTransformer mPageTransformer;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState = null;
  private ClassLoader mRestoredClassLoader = null;
  private int mRestoredCurItem = -1;
  private EdgeEffectCompat mRightEdge;
  private int mScrollState = 0;
  private Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private Method mSetChildrenDrawingOrderEnabled;
  private final ItemInfo mTempItem = new ItemInfo();
  private final Rect mTempRect = new Rect();
  private int mTopPageBounds;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public ViewPager(Context paramContext)
  {
    super(paramContext);
    initViewPager();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private void calculatePageOffsets(ItemInfo paramItemInfo1, int paramInt, ItemInfo paramItemInfo2)
  {
    int k = this.mAdapter.getCount();
    int i = getClientWidth();
    if (i > 0) {}
    float f1;
    int j;
    for (float f2 = this.mPageMargin / i;; f2 = 0.0F)
    {
      if (paramItemInfo2 == null) {
        break label362;
      }
      i = paramItemInfo2.position;
      if (i >= paramItemInfo1.position) {
        break;
      }
      f1 = paramItemInfo2.offset + paramItemInfo2.widthFactor + f2;
      j = 0;
      i++;
      if ((i > paramItemInfo1.position) || (j >= this.mItems.size())) {
        break label362;
      }
      for (paramItemInfo2 = (ItemInfo)this.mItems.get(j); (i > paramItemInfo2.position) && (j < this.mItems.size() - 1); paramItemInfo2 = (ItemInfo)this.mItems.get(j)) {
        j++;
      }
    }
    for (;;)
    {
      float f3;
      if (i < paramItemInfo2.position)
      {
        f3 = this.mAdapter.getPageWidth(i);
        i++;
        f1 = f3 + f2 + f1;
      }
      else
      {
        paramItemInfo2.offset = f1;
        f1 += paramItemInfo2.widthFactor + f2;
        i++;
        break;
        if (i > paramItemInfo1.position)
        {
          j = this.mItems.size();
          f1 = paramItemInfo2.offset;
          j--;
          i--;
          if ((i >= paramItemInfo1.position) && (j >= 0)) {
            for (paramItemInfo2 = (ItemInfo)this.mItems.get(j); (i < paramItemInfo2.position) && (j > 0); paramItemInfo2 = (ItemInfo)this.mItems.get(j)) {
              j--;
            }
          }
        }
        for (;;)
        {
          if (i > paramItemInfo2.position)
          {
            f3 = this.mAdapter.getPageWidth(i);
            i--;
            f1 -= f3 + f2;
          }
          else
          {
            f1 -= paramItemInfo2.widthFactor + f2;
            paramItemInfo2.offset = f1;
            i--;
            break;
            label362:
            int m = this.mItems.size();
            f3 = paramItemInfo1.offset;
            i = paramItemInfo1.position - 1;
            if (paramItemInfo1.position == 0)
            {
              f1 = paramItemInfo1.offset;
              this.mFirstOffset = f1;
              if (paramItemInfo1.position != k - 1) {
                break label500;
              }
              f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor - 1.0F;
              label428:
              this.mLastOffset = f1;
              j = paramInt - 1;
              f1 = f3;
            }
            for (;;)
            {
              if (j < 0) {
                break label547;
              }
              paramItemInfo2 = (ItemInfo)this.mItems.get(j);
              for (;;)
              {
                if (i > paramItemInfo2.position)
                {
                  f1 -= this.mAdapter.getPageWidth(i) + f2;
                  i--;
                  continue;
                  f1 = -3.4028235E38F;
                  break;
                  label500:
                  f1 = Float.MAX_VALUE;
                  break label428;
                }
              }
              f1 -= paramItemInfo2.widthFactor + f2;
              paramItemInfo2.offset = f1;
              if (paramItemInfo2.position == 0) {
                this.mFirstOffset = f1;
              }
              i--;
              j--;
            }
            label547:
            f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor + f2;
            j = paramItemInfo1.position + 1;
            i = paramInt + 1;
            paramInt = j;
            while (i < m)
            {
              paramItemInfo1 = (ItemInfo)this.mItems.get(i);
              while (paramInt < paramItemInfo1.position)
              {
                f1 += this.mAdapter.getPageWidth(paramInt) + f2;
                paramInt++;
              }
              if (paramItemInfo1.position == k - 1) {
                this.mLastOffset = (paramItemInfo1.widthFactor + f1 - 1.0F);
              }
              paramItemInfo1.offset = f1;
              f1 += paramItemInfo1.widthFactor + f2;
              paramInt++;
              i++;
            }
            this.mNeedCalculatePageOffsets = false;
            return;
          }
        }
      }
    }
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    if (this.mScrollState == 2) {}
    int j;
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        this.mScroller.abortAnimation();
        int m = getScrollX();
        k = getScrollY();
        j = this.mScroller.getCurrX();
        int n = this.mScroller.getCurrY();
        if ((m != j) || (k != n)) {
          scrollTo(j, n);
        }
      }
      this.mPopulatePending = false;
      int k = 0;
      j = i;
      for (i = k; i < this.mItems.size(); i++)
      {
        ItemInfo localItemInfo = (ItemInfo)this.mItems.get(i);
        if (localItemInfo.scrolling)
        {
          localItemInfo.scrolling = false;
          j = 1;
        }
      }
    }
    if (j != 0)
    {
      if (!paramBoolean) {
        break label156;
      }
      ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
    }
    for (;;)
    {
      return;
      label156:
      this.mEndScrollRunnable.run();
    }
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.mItems.size() > 0)
        {
          ItemInfo localItemInfo1 = (ItemInfo)this.mItems.get(0);
          ItemInfo localItemInfo2 = (ItemInfo)this.mItems.get(this.mItems.size() - 1);
          paramInt2 = Math.max(localItemInfo1.position, Math.min(paramInt1, localItemInfo2.position));
        }
        return paramInt2;
        paramInt1++;
      }
    }
    if (paramInt1 >= this.mCurItem) {}
    for (float f = 0.4F;; f = 0.6F)
    {
      paramInt1 = (int)(f + (paramInt1 + paramFloat));
      break;
    }
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    int k = getChildCount();
    int i = 0;
    if (i < k)
    {
      if (paramBoolean) {}
      for (int j = 2;; j = 0)
      {
        ViewCompat.setLayerType(getChildAt(i), j, null);
        i++;
        break;
      }
    }
  }
  
  private void endDrag()
  {
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null) {
        paramRect.set(0, 0, 0, 0);
      }
      for (;;)
      {
        return paramRect;
        paramRect.left = paramView.getLeft();
        paramRect.right = paramView.getRight();
        paramRect.top = paramView.getTop();
        paramRect.bottom = paramView.getBottom();
        for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
        {
          paramView = (ViewGroup)paramView;
          paramRect.left += paramView.getLeft();
          paramRect.right += paramView.getRight();
          paramRect.top += paramView.getTop();
          paramRect.bottom += paramView.getBottom();
        }
      }
    }
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private ItemInfo infoForCurrentScrollPosition()
  {
    int i = getClientWidth();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int k;
    int j;
    Object localObject1;
    label53:
    Object localObject2;
    ItemInfo localItemInfo;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i <= 0) {
        break label211;
      }
      f2 = this.mPageMargin / i;
      f4 = 0.0F;
      f3 = 0.0F;
      k = -1;
      i = 0;
      j = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i < this.mItems.size())
      {
        localItemInfo = (ItemInfo)this.mItems.get(i);
        if ((j != 0) || (localItemInfo.position == k + 1)) {
          break label243;
        }
        localItemInfo = this.mTempItem;
        localItemInfo.offset = (f4 + f3 + f2);
        localItemInfo.position = (k + 1);
        localItemInfo.widthFactor = this.mAdapter.getPageWidth(localItemInfo.position);
        i--;
      }
    }
    label211:
    label216:
    label243:
    for (;;)
    {
      f3 = localItemInfo.offset;
      f4 = localItemInfo.widthFactor;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i != this.mItems.size() - 1)) {
          break label216;
        }
        localObject2 = localItemInfo;
      }
      return (ItemInfo)localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      k = localItemInfo.position;
      f4 = localItemInfo.widthFactor;
      j = 0;
      i++;
      localObject1 = localItemInfo;
      break label53;
    }
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    if (((paramFloat1 < this.mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.mGutterSize) && (paramFloat2 < 0.0F))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mActivePointerId) {
      if (i != 0) {
        break label56;
      }
    }
    label56:
    for (i = 1;; i = 0)
    {
      this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      return;
    }
  }
  
  private boolean pageScrolled(int paramInt)
  {
    boolean bool = false;
    if (this.mItems.size() == 0)
    {
      this.mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      ItemInfo localItemInfo = infoForCurrentScrollPosition();
      int j = getClientWidth();
      int k = this.mPageMargin;
      float f = this.mPageMargin / j;
      int i = localItemInfo.position;
      f = (paramInt / j - localItemInfo.offset) / (localItemInfo.widthFactor + f);
      paramInt = (int)((k + j) * f);
      this.mCalledSuper = false;
      onPageScrolled(i, f, paramInt);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private boolean performDrag(float paramFloat)
  {
    int j = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = getClientWidth();
    paramFloat = k * this.mFirstOffset;
    f1 = k;
    float f3 = this.mLastOffset;
    ItemInfo localItemInfo2 = (ItemInfo)this.mItems.get(0);
    ItemInfo localItemInfo1 = (ItemInfo)this.mItems.get(this.mItems.size() - 1);
    if (localItemInfo2.position != 0) {
      paramFloat = localItemInfo2.offset * k;
    }
    for (int i = 0;; i = 1)
    {
      if (localItemInfo1.position != this.mAdapter.getCount() - 1)
      {
        f1 = localItemInfo1.offset * k;
        j = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          f1 = paramFloat;
          if (i != 0)
          {
            bool1 = this.mLeftEdge.onPull(Math.abs(paramFloat - f2) / k);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          this.mLastMotionX += f1 - (int)f1;
          scrollTo((int)f1, getScrollY());
          pageScrolled((int)f1);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (j != 0) {
              bool1 = this.mRightEdge.onPull(Math.abs(f2 - f1) / k);
            }
          }
          else
          {
            f1 = f2;
          }
        }
        f1 *= f3;
      }
    }
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int m = getPaddingLeft();
      int k = getPaddingRight();
      f = getScrollX() / (paramInt2 - m - k + paramInt4);
      paramInt3 = (int)((paramInt1 - i - j + paramInt3) * f);
      scrollTo(paramInt3, getScrollY());
      if (!this.mScroller.isFinished())
      {
        paramInt4 = this.mScroller.getDuration();
        paramInt2 = this.mScroller.timePassed();
        localItemInfo = infoForPosition(this.mCurItem);
        this.mScroller.startScroll(paramInt3, 0, (int)(localItemInfo.offset * paramInt1), 0, paramInt4 - paramInt2);
      }
      return;
    }
    ItemInfo localItemInfo = infoForPosition(this.mCurItem);
    if (localItemInfo != null) {}
    for (float f = Math.min(localItemInfo.offset, this.mLastOffset);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      completeScroll(false);
      scrollTo(paramInt1, getScrollY());
      break;
    }
  }
  
  private void removeNonDecorViews()
  {
    int j;
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (!((LayoutParams)getChildAt(i).getLayoutParams()).isDecor)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
  }
  
  private void requestParentDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    ItemInfo localItemInfo = infoForPosition(paramInt1);
    float f;
    if (localItemInfo != null) {
      f = getClientWidth();
    }
    for (int i = (int)(Math.max(this.mFirstOffset, Math.min(localItemInfo.offset, this.mLastOffset)) * f);; i = 0)
    {
      if (paramBoolean1)
      {
        smoothScrollTo(i, 0, paramInt2);
        if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
          this.mOnPageChangeListener.onPageSelected(paramInt1);
        }
        if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
          this.mInternalPageChangeListener.onPageSelected(paramInt1);
        }
      }
      for (;;)
      {
        return;
        if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
          this.mOnPageChangeListener.onPageSelected(paramInt1);
        }
        if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
          this.mInternalPageChangeListener.onPageSelected(paramInt1);
        }
        completeScroll(false);
        scrollTo(i, 0);
        pageScrolled(i);
      }
    }
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    if (this.mPageTransformer != null) {
      if (paramInt == 0) {
        break label52;
      }
    }
    label52:
    for (boolean bool = true;; bool = false)
    {
      enableLayers(bool);
      if (this.mOnPageChangeListener == null) {
        break;
      }
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt);
      break;
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrder()
  {
    if (this.mDrawingOrder != 0)
    {
      if (this.mDrawingOrderedChildren == null) {
        this.mDrawingOrderedChildren = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        for (int i = 0; i < j; i++)
        {
          View localView = getChildAt(i);
          this.mDrawingOrderedChildren.add(localView);
        }
        this.mDrawingOrderedChildren.clear();
      }
      Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int k = paramArrayList.size();
    int j = getDescendantFocusability();
    if (j != 393216) {
      for (int i = 0; i < getChildCount(); i++)
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          ItemInfo localItemInfo = infoForChild(localView);
          if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
      }
    }
    if (((j == 262144) && (k != paramArrayList.size())) || (!isFocusable())) {}
    for (;;)
    {
      return;
      if ((((paramInt2 & 0x1) != 1) || (!isInTouchMode()) || (isFocusableInTouchMode())) && (paramArrayList != null)) {
        paramArrayList.add(this);
      }
    }
  }
  
  ItemInfo addNewItem(int paramInt1, int paramInt2)
  {
    ItemInfo localItemInfo = new ItemInfo();
    localItemInfo.position = paramInt1;
    localItemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    localItemInfo.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.mItems.size())) {
      this.mItems.add(localItemInfo);
    }
    for (;;)
    {
      return localItemInfo;
      this.mItems.add(paramInt2, localItemInfo);
    }
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      LayoutParams localLayoutParams = (LayoutParams)paramLayoutParams;
      localLayoutParams.isDecor |= paramView instanceof Decor;
      if (this.mInLayout)
      {
        if ((localLayoutParams != null) && (localLayoutParams.isDecor)) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.needsMeasure = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
      }
      for (;;)
      {
        return;
        super.addView(paramView, paramInt, paramLayoutParams);
      }
    }
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int j;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label316;
      }
      if (paramInt != 17) {
        break label262;
      }
      j = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
      i = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
      if ((localObject != null) && (j >= i))
      {
        bool = pageLeft();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label362;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label369;
      }
      if (localObject != this) {}
    }
    label262:
    label316:
    label356:
    label362:
    label369:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label89;
        if (paramInt == 66)
        {
          j = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
          i = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
          if ((localObject == null) || (j > i))
          {
            bool = localView.requestFocus();
            break label89;
            if ((paramInt == 17) || (paramInt == 1))
            {
              bool = pageLeft();
              break label89;
            }
            if ((paramInt != 66) && (paramInt != 2)) {
              break label356;
            }
          }
          bool = pageRight();
          break label89;
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  public boolean beginFakeDrag()
  {
    boolean bool = false;
    if (this.mIsBeingDragged) {
      return bool;
    }
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionX = 0.0F;
    this.mInitialMotionX = 0.0F;
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    for (;;)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.mVelocityTracker.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.mFakeDragBeginTime = l;
      bool = true;
      break;
      this.mVelocityTracker.clear();
    }
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
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
        if ((paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {
          paramBoolean = bool;
        }
      }
    }
    for (;;)
    {
      return paramBoolean;
      i--;
      break;
      if (paramBoolean)
      {
        paramBoolean = bool;
        if (ViewCompat.canScrollHorizontally(paramView, -paramInt1)) {}
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.mAdapter == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      int j = getClientWidth();
      int i = getScrollX();
      if (paramInt < 0)
      {
        bool1 = bool2;
        if (i > (int)(j * this.mFirstOffset)) {
          bool1 = true;
        }
      }
      else
      {
        bool1 = bool2;
        if (paramInt > 0)
        {
          bool1 = bool2;
          if (i < (int)(j * this.mLastOffset)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void computeScroll()
  {
    if ((!this.mScroller.isFinished()) && (this.mScroller.computeScrollOffset()))
    {
      int k = getScrollX();
      int j = getScrollY();
      int i = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      if ((k != i) || (j != m))
      {
        scrollTo(i, m);
        if (!pageScrolled(i))
        {
          this.mScroller.abortAnimation();
          scrollTo(0, m);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
    for (;;)
    {
      return;
      completeScroll(true);
    }
  }
  
  void dataSetChanged()
  {
    int i2 = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i2;
    int i;
    int j;
    int k;
    int n;
    int m;
    label67:
    Object localObject;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < i2))
    {
      i = 1;
      j = this.mCurItem;
      k = 0;
      n = 0;
      m = i;
      i = j;
      j = k;
      k = n;
      if (k >= this.mItems.size()) {
        break label278;
      }
      localObject = (ItemInfo)this.mItems.get(k);
      n = this.mAdapter.getItemPosition(((ItemInfo)localObject).object);
      if (n == -1) {
        break label362;
      }
      if (n != -2) {
        break label226;
      }
      this.mItems.remove(k);
      m = k - 1;
      k = j;
      if (j == 0)
      {
        this.mAdapter.startUpdate(this);
        k = 1;
      }
      this.mAdapter.destroyItem(this, ((ItemInfo)localObject).position, ((ItemInfo)localObject).object);
      if (this.mCurItem != ((ItemInfo)localObject).position) {
        break label383;
      }
      j = Math.max(0, Math.min(this.mCurItem, i2 - 1));
      i = k;
      k = 1;
    }
    for (;;)
    {
      n = k;
      int i1 = j;
      k = m + 1;
      j = i;
      i = i1;
      m = n;
      break label67;
      i = 0;
      break;
      label226:
      if (((ItemInfo)localObject).position != n)
      {
        if (((ItemInfo)localObject).position == this.mCurItem) {
          i = n;
        }
        ((ItemInfo)localObject).position = n;
        n = j;
        j = i;
        i1 = 1;
        m = k;
        i = n;
        k = i1;
        continue;
        label278:
        if (j != 0) {
          this.mAdapter.finishUpdate(this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (m != 0)
        {
          k = getChildCount();
          for (j = 0; j < k; j++)
          {
            localObject = (LayoutParams)getChildAt(j).getLayoutParams();
            if (!((LayoutParams)localObject).isDecor) {
              ((LayoutParams)localObject).widthFactor = 0.0F;
            }
          }
          setCurrentItemInternal(i, false, true);
          requestLayout();
        }
      }
      else
      {
        label362:
        i1 = i;
        n = m;
        m = k;
        i = j;
        j = i1;
        k = n;
        continue;
        label383:
        j = i;
        n = 1;
        i = k;
        k = n;
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int j = getChildCount();
    for (int i = 0;; i++)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent)))
        {
          bool1 = true;
          break;
        }
      }
    }
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = ViewCompat.getOverScrollMode(this);
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.mAdapter != null) && (this.mAdapter.getCount() > 1)))
    {
      int j;
      if (!this.mLeftEdge.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.mFirstOffset * m);
        this.mLeftEdge.setSize(i, m);
        j = this.mLeftEdge.draw(paramCanvas) | false;
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.mRightEdge.isFinished())
      {
        m = paramCanvas.save();
        int n = getWidth();
        int i2 = getHeight();
        int i1 = getPaddingTop();
        k = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.mLastOffset + 1.0F) * n);
        this.mRightEdge.setSize(i2 - i1 - k, n);
        bool = j | this.mRightEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      this.mLeftEdge.finish();
      this.mRightEdge.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void endFakeDrag()
  {
    if (!this.mFakeDragging) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    Object localObject = this.mVelocityTracker;
    ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
    int k = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.mActivePointerId);
    this.mPopulatePending = true;
    int j = getClientWidth();
    int i = getScrollX();
    localObject = infoForCurrentScrollPosition();
    setCurrentItemInternal(determineTargetPage(((ItemInfo)localObject).position, (i / j - ((ItemInfo)localObject).offset) / ((ItemInfo)localObject).widthFactor, k, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, k);
    endDrag();
    this.mFakeDragging = false;
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = arrowScroll(17);
      continue;
      bool1 = arrowScroll(66);
      continue;
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 11) {
        if (KeyEventCompat.hasNoModifiers(paramKeyEvent))
        {
          bool1 = arrowScroll(2);
        }
        else
        {
          bool1 = bool2;
          if (KeyEventCompat.hasModifiers(paramKeyEvent, 1)) {
            bool1 = arrowScroll(1);
          }
        }
      }
    }
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (!this.mFakeDragging) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    this.mLastMotionX += paramFloat;
    float f2 = getScrollX() - paramFloat;
    int i = getClientWidth();
    paramFloat = i;
    float f4 = this.mFirstOffset;
    float f3 = i;
    float f1 = this.mLastOffset;
    ItemInfo localItemInfo = (ItemInfo)this.mItems.get(0);
    Object localObject = (ItemInfo)this.mItems.get(this.mItems.size() - 1);
    if (localItemInfo.position != 0) {}
    for (paramFloat = localItemInfo.offset * i;; paramFloat *= f4)
    {
      if (((ItemInfo)localObject).position != this.mAdapter.getCount() - 1) {}
      for (f1 = ((ItemInfo)localObject).offset * i;; f1 = f3 * f1)
      {
        if (f2 < paramFloat) {}
        for (;;)
        {
          this.mLastMotionX += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          pageScrolled((int)paramFloat);
          long l = SystemClock.uptimeMillis();
          localObject = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
          this.mVelocityTracker.addMovement((MotionEvent)localObject);
          ((MotionEvent)localObject).recycle();
          return;
          if (f2 > f1) {
            paramFloat = f1;
          } else {
            paramFloat = f2;
          }
        }
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.mDrawingOrder == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return ((LayoutParams)((View)this.mDrawingOrderedChildren.get(i)).getLayoutParams()).childIndex;
  }
  
  public int getCurrentItem()
  {
    return this.mCurItem;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.mOffscreenPageLimit;
  }
  
  public int getPageMargin()
  {
    return this.mPageMargin;
  }
  
  ItemInfo infoForAnyChild(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent != this) {
      if ((localViewParent != null) && ((localViewParent instanceof View))) {}
    }
    for (paramView = null;; paramView = infoForChild(paramView))
    {
      return paramView;
      paramView = (View)localViewParent;
      break;
    }
  }
  
  ItemInfo infoForChild(View paramView)
  {
    int i = 0;
    ItemInfo localItemInfo;
    if (i < this.mItems.size())
    {
      localItemInfo = (ItemInfo)this.mItems.get(i);
      if (!this.mAdapter.isViewFromObject(paramView, localItemInfo.object)) {}
    }
    for (paramView = localItemInfo;; paramView = null)
    {
      return paramView;
      i++;
      break;
    }
  }
  
  ItemInfo infoForPosition(int paramInt)
  {
    int i = 0;
    ItemInfo localItemInfo;
    if (i < this.mItems.size())
    {
      localItemInfo = (ItemInfo)this.mItems.get(i);
      if (localItemInfo.position != paramInt) {}
    }
    for (;;)
    {
      return localItemInfo;
      i++;
      break;
      localItemInfo = null;
    }
  }
  
  void initViewPager()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.mScroller = new Scroller(localContext, sInterpolator);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = localContext.getResources().getDisplayMetrics().density;
    this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.mMinimumVelocity = ((int)(400.0F * f));
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new EdgeEffectCompat(localContext);
    this.mRightEdge = new EdgeEffectCompat(localContext);
    this.mFlingDistance = ((int)(25.0F * f));
    this.mCloseEnough = ((int)(2.0F * f));
    this.mDefaultGutterSize = ((int)(16.0F * f));
    ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  public boolean isFakeDragging()
  {
    return this.mFakeDragging;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.mEndScrollRunnable);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      int m = getScrollX();
      int i1 = getWidth();
      float f3 = this.mPageMargin / i1;
      Object localObject = (ItemInfo)this.mItems.get(0);
      float f1 = ((ItemInfo)localObject).offset;
      int k = this.mItems.size();
      int i = ((ItemInfo)localObject).position;
      int n = ((ItemInfo)this.mItems.get(k - 1)).position;
      int j = 0;
      if (i < n)
      {
        while ((i > ((ItemInfo)localObject).position) && (j < k))
        {
          localObject = this.mItems;
          j++;
          localObject = (ItemInfo)((ArrayList)localObject).get(j);
        }
        float f2;
        if (i == ((ItemInfo)localObject).position) {
          f2 = (((ItemInfo)localObject).offset + ((ItemInfo)localObject).widthFactor) * i1;
        }
        float f4;
        for (f1 = ((ItemInfo)localObject).offset + ((ItemInfo)localObject).widthFactor + f3;; f1 += f4 + f3)
        {
          if (this.mPageMargin + f2 > m)
          {
            this.mMarginDrawable.setBounds((int)f2, this.mTopPageBounds, (int)(this.mPageMargin + f2 + 0.5F), this.mBottomPageBounds);
            this.mMarginDrawable.draw(paramCanvas);
          }
          if (f2 > m + i1) {
            return;
          }
          i++;
          break;
          f4 = this.mAdapter.getPageWidth(i);
          f2 = (f1 + f4) * i1;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = paramMotionEvent.getAction() & 0xFF;
    boolean bool1;
    if ((i == 3) || (i == 1))
    {
      this.mIsBeingDragged = false;
      this.mIsUnableToDrag = false;
      this.mActivePointerId = -1;
      bool1 = bool2;
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        bool1 = bool2;
      }
    }
    do
    {
      for (;;)
      {
        return bool1;
        if (i == 0) {
          break label99;
        }
        if (!this.mIsBeingDragged) {
          break;
        }
        bool1 = true;
      }
      bool1 = bool2;
    } while (this.mIsUnableToDrag);
    label99:
    switch (i)
    {
    }
    for (;;)
    {
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      bool1 = this.mIsBeingDragged;
      break;
      i = this.mActivePointerId;
      if (i != -1)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
        float f3 = MotionEventCompat.getX(paramMotionEvent, i);
        float f1 = f3 - this.mLastMotionX;
        float f4 = Math.abs(f1);
        float f2 = MotionEventCompat.getY(paramMotionEvent, i);
        float f5 = Math.abs(f2 - this.mInitialMotionY);
        if ((f1 != 0.0F) && (!isGutterDrag(this.mLastMotionX, f1)) && (canScroll(this, false, (int)f1, (int)f3, (int)f2)))
        {
          this.mLastMotionX = f3;
          this.mLastMotionY = f2;
          this.mIsUnableToDrag = true;
          bool1 = bool2;
          break;
        }
        if ((f4 > this.mTouchSlop) && (0.5F * f4 > f5))
        {
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.mInitialMotionX + this.mTouchSlop;
            label339:
            this.mLastMotionX = f1;
            this.mLastMotionY = f2;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.mIsBeingDragged) && (performDrag(f3)))
        {
          ViewCompat.postInvalidateOnAnimation(this);
          break;
          f1 = this.mInitialMotionX - this.mTouchSlop;
          break label339;
          if (f5 > this.mTouchSlop) {
            this.mIsUnableToDrag = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        this.mInitialMotionY = f1;
        this.mLastMotionY = f1;
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.mIsUnableToDrag = false;
        this.mScroller.computeScrollOffset();
        if ((this.mScrollState == 2) && (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough))
        {
          this.mScroller.abortAnimation();
          this.mPopulatePending = false;
          populate();
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
        }
        else
        {
          completeScroll(false);
          this.mIsBeingDragged = false;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i3 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i4 = getScrollX();
    int j = 0;
    int m = 0;
    View localView;
    LayoutParams localLayoutParams;
    int n;
    int k;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label658;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.isDecor) {
        break label658;
      }
      paramInt4 = localLayoutParams.gravity;
      n = localLayoutParams.gravity;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt2;
        k = paramInt2;
        label154:
        switch (n & 0x70)
        {
        default: 
          n = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = n;
          label204:
          paramInt4 += i4;
          localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
          j++;
          paramInt4 = i;
          paramInt3 = k;
          i = paramInt1;
          paramInt1 = j;
        }
        break;
      }
    }
    for (;;)
    {
      m++;
      k = paramInt3;
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i;
      i = paramInt4;
      paramInt2 = k;
      break;
      k = localView.getMeasuredWidth();
      paramInt4 = paramInt2;
      k += paramInt2;
      break label154;
      paramInt4 = Math.max((i3 - localView.getMeasuredWidth()) / 2, paramInt2);
      k = paramInt2;
      break label154;
      paramInt4 = localView.getMeasuredWidth();
      k = i + localView.getMeasuredWidth();
      paramInt4 = i3 - i - paramInt4;
      i = k;
      k = paramInt2;
      break label154;
      n = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      n += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = n;
      break label204;
      n = Math.max((i2 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = n;
      break label204;
      n = i2 - paramInt3 - localView.getMeasuredHeight();
      int i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i5;
      paramInt3 = n;
      break label204;
      i = i3 - paramInt2 - i;
      for (paramInt4 = 0; paramInt4 < i1; paramInt4++)
      {
        localView = getChildAt(paramInt4);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.isDecor)
          {
            ItemInfo localItemInfo = infoForChild(localView);
            if (localItemInfo != null)
            {
              float f = i;
              k = (int)(localItemInfo.offset * f) + paramInt2;
              if (localLayoutParams.needsMeasure)
              {
                localLayoutParams.needsMeasure = false;
                f = i;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.widthFactor * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - paramInt1 - paramInt3, 1073741824));
              }
              localView.layout(k, paramInt1, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
      }
      this.mTopPageBounds = paramInt1;
      this.mBottomPageBounds = (i2 - paramInt3);
      this.mDecorChildCount = j;
      if (this.mFirstLayout) {
        scrollToItem(this.mCurItem, false, 0, false);
      }
      this.mFirstLayout = false;
      return;
      label658:
      paramInt4 = j;
      j = paramInt1;
      k = paramInt2;
      paramInt1 = paramInt4;
      paramInt4 = i;
      i = paramInt3;
      paramInt2 = j;
      paramInt3 = k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.mGutterSize = Math.min(paramInt1 / 10, this.mDefaultGutterSize);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int k = 0;
    View localView;
    int j;
    int i;
    LayoutParams localLayoutParams;
    int m;
    int i1;
    label183:
    int n;
    if (k < i4)
    {
      localView = getChildAt(k);
      j = paramInt1;
      i = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        j = paramInt1;
        i = paramInt2;
        if (localLayoutParams != null)
        {
          j = paramInt1;
          i = paramInt2;
          if (localLayoutParams.isDecor)
          {
            i = localLayoutParams.gravity & 0x7;
            m = localLayoutParams.gravity & 0x70;
            i1 = Integer.MIN_VALUE;
            j = Integer.MIN_VALUE;
            if ((m != 48) && (m != 80)) {
              break label330;
            }
            m = 1;
            if ((i != 3) && (i != 5)) {
              break label336;
            }
            n = 1;
            label198:
            if (m == 0) {
              break label342;
            }
            i = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label524;
            }
            i1 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label518;
            }
            i = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i3;
      if (localLayoutParams.height != -2)
      {
        i2 = 1073741824;
        j = i2;
        if (localLayoutParams.height != -1)
        {
          i3 = localLayoutParams.height;
          j = i2;
        }
      }
      for (int i2 = i3;; i2 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, i1), View.MeasureSpec.makeMeasureSpec(i2, j));
        if (m != 0)
        {
          i = paramInt2 - localView.getMeasuredHeight();
          j = paramInt1;
        }
        for (;;)
        {
          k++;
          paramInt1 = j;
          paramInt2 = i;
          break;
          label330:
          m = 0;
          break label183;
          label336:
          n = 0;
          break label198;
          label342:
          i = i1;
          if (n == 0) {
            break label208;
          }
          j = 1073741824;
          i = i1;
          break label208;
          j = paramInt1;
          i = paramInt2;
          if (n != 0)
          {
            j = paramInt1 - localView.getMeasuredWidth();
            i = paramInt2;
          }
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        i = getChildCount();
        for (paramInt2 = 0; paramInt2 < i; paramInt2++)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.isDecor))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.widthFactor * f), 1073741824), this.mChildHeightMeasureSpec);
            }
          }
        }
        return;
      }
      label518:
      i = paramInt1;
      continue;
      label524:
      i1 = i;
      i = paramInt1;
    }
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i;
    int j;
    int i3;
    int n;
    View localView;
    Object localObject;
    int k;
    int m;
    label132:
    int i4;
    if (this.mDecorChildCount > 0)
    {
      int i2 = getScrollX();
      i = getPaddingLeft();
      j = getPaddingRight();
      i3 = getWidth();
      int i1 = getChildCount();
      n = 0;
      if (n < i1)
      {
        localView = getChildAt(n);
        localObject = (LayoutParams)localView.getLayoutParams();
        if (!((LayoutParams)localObject).isDecor) {
          break label410;
        }
        switch (((LayoutParams)localObject).gravity & 0x7)
        {
        case 2: 
        case 4: 
        default: 
          k = i;
          m = i;
          i = j;
          j = m;
          i4 = k + i2 - localView.getLeft();
          k = i;
          m = j;
          if (i4 != 0)
          {
            localView.offsetLeftAndRight(i4);
            m = j;
            k = i;
          }
          break;
        }
      }
    }
    for (;;)
    {
      n++;
      i = m;
      j = k;
      break;
      k = localView.getWidth();
      m = k + i;
      k = i;
      i = j;
      j = m;
      break label132;
      k = Math.max((i3 - localView.getMeasuredWidth()) / 2, i);
      m = i;
      i = j;
      j = m;
      break label132;
      k = i3 - j - localView.getMeasuredWidth();
      i4 = localView.getMeasuredWidth();
      m = i;
      i = j + i4;
      j = m;
      break label132;
      if (this.mOnPageChangeListener != null) {
        this.mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      if (this.mInternalPageChangeListener != null) {
        this.mInternalPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      if (this.mPageTransformer != null)
      {
        paramInt2 = getScrollX();
        i = getChildCount();
        for (paramInt1 = 0; paramInt1 < i; paramInt1++)
        {
          localObject = getChildAt(paramInt1);
          if (!((LayoutParams)((View)localObject).getLayoutParams()).isDecor)
          {
            paramFloat = (((View)localObject).getLeft() - paramInt2) / getClientWidth();
            this.mPageTransformer.transformPage((View)localObject, paramFloat);
          }
        }
      }
      this.mCalledSuper = true;
      return;
      label410:
      k = j;
      m = i;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    boolean bool = true;
    int j = -1;
    int k = getChildCount();
    int i;
    if ((paramInt & 0x2) != 0)
    {
      j = 1;
      i = 0;
      if (i == k) {
        break label101;
      }
      View localView = getChildAt(i);
      if (localView.getVisibility() != 0) {
        break label93;
      }
      ItemInfo localItemInfo = infoForChild(localView);
      if ((localItemInfo == null) || (localItemInfo.position != this.mCurItem) || (!localView.requestFocus(paramInt, paramRect))) {
        break label93;
      }
    }
    for (;;)
    {
      return bool;
      i = k - 1;
      k = -1;
      break;
      label93:
      i += j;
      break;
      label101:
      bool = false;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      if (this.mAdapter != null)
      {
        this.mAdapter.restoreState(paramParcelable.adapterState, paramParcelable.loader);
        setCurrentItemInternal(paramParcelable.position, false, true);
      }
      else
      {
        this.mRestoredCurItem = paramParcelable.position;
        this.mRestoredAdapterState = paramParcelable.adapterState;
        this.mRestoredClassLoader = paramParcelable.loader;
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    if (this.mAdapter != null) {
      localSavedState.adapterState = this.mAdapter.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      recomputeScrollPosition(paramInt1, paramInt3, this.mPageMargin, this.mPageMargin);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = 0;
    boolean bool3;
    if (this.mFakeDragging) {
      bool3 = true;
    }
    for (;;)
    {
      return bool3;
      if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
      {
        bool3 = false;
      }
      else
      {
        if ((this.mAdapter != null) && (this.mAdapter.getCount() != 0)) {
          break;
        }
        bool3 = false;
      }
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = m;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = m;
    }
    for (;;)
    {
      if (i != 0) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      bool3 = true;
      break;
      this.mScroller.abortAnimation();
      this.mPopulatePending = false;
      populate();
      float f1 = paramMotionEvent.getX();
      this.mInitialMotionX = f1;
      this.mLastMotionX = f1;
      f1 = paramMotionEvent.getY();
      this.mInitialMotionY = f1;
      this.mLastMotionY = f1;
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      i = m;
      continue;
      float f2;
      if (!this.mIsBeingDragged)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
        float f4 = MotionEventCompat.getX(paramMotionEvent, i);
        float f3 = Math.abs(f4 - this.mLastMotionX);
        f2 = MotionEventCompat.getY(paramMotionEvent, i);
        f1 = Math.abs(f2 - this.mLastMotionY);
        if ((f3 > this.mTouchSlop) && (f3 > f1))
        {
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          if (f4 - this.mInitialMotionX <= 0.0F) {
            break label395;
          }
        }
      }
      Object localObject;
      label395:
      for (f1 = this.mInitialMotionX + this.mTouchSlop;; f1 = this.mInitialMotionX - this.mTouchSlop)
      {
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        i = m;
        if (!this.mIsBeingDragged) {
          break;
        }
        bool1 = performDrag(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId))) | false;
        break;
      }
      boolean bool1 = m;
      if (this.mIsBeingDragged)
      {
        localObject = this.mVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
        int n = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.mActivePointerId);
        this.mPopulatePending = true;
        m = getClientWidth();
        int j = getScrollX();
        localObject = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(((ItemInfo)localObject).position, (j / m - ((ItemInfo)localObject).offset) / ((ItemInfo)localObject).widthFactor, n, (int)(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)) - this.mInitialMotionX)), true, true, n);
        this.mActivePointerId = -1;
        endDrag();
        bool3 = this.mLeftEdge.onRelease();
        boolean bool2 = this.mRightEdge.onRelease() | bool3;
        continue;
        bool2 = m;
        if (this.mIsBeingDragged)
        {
          scrollToItem(this.mCurItem, true, 0, false);
          this.mActivePointerId = -1;
          endDrag();
          bool3 = this.mLeftEdge.onRelease();
          bool2 = this.mRightEdge.onRelease() | bool3;
          continue;
          int k = MotionEventCompat.getActionIndex(paramMotionEvent);
          this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, k);
          this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, k);
          k = m;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
          this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId));
          k = m;
        }
      }
    }
  }
  
  boolean pageLeft()
  {
    boolean bool = true;
    if (this.mCurItem > 0) {
      setCurrentItem(this.mCurItem - 1, true);
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  boolean pageRight()
  {
    boolean bool = true;
    if ((this.mAdapter != null) && (this.mCurItem < this.mAdapter.getCount() - 1)) {
      setCurrentItem(this.mCurItem + 1, true);
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  void populate()
  {
    populate(this.mCurItem);
  }
  
  void populate(int paramInt)
  {
    int i;
    Object localObject2;
    if (this.mCurItem != paramInt) {
      if (this.mCurItem < paramInt)
      {
        i = 66;
        localObject2 = infoForPosition(this.mCurItem);
        this.mCurItem = paramInt;
      }
    }
    for (int j = i;; j = 2)
    {
      if (this.mAdapter == null) {
        sortChildDrawingOrder();
      }
      label72:
      do
      {
        for (;;)
        {
          return;
          i = 17;
          break;
          if (!this.mPopulatePending) {
            break label72;
          }
          sortChildDrawingOrder();
        }
      } while (getWindowToken() == null);
      this.mAdapter.startUpdate(this);
      paramInt = this.mOffscreenPageLimit;
      int i3 = Math.max(0, this.mCurItem - paramInt);
      int i1 = this.mAdapter.getCount();
      int i2 = Math.min(i1 - 1, paramInt + this.mCurItem);
      Object localObject1;
      if (i1 != this.mExpectedAdapterCount) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + i1 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      if (paramInt < this.mItems.size())
      {
        localObject1 = (ItemInfo)this.mItems.get(paramInt);
        if (((ItemInfo)localObject1).position >= this.mCurItem) {
          if (((ItemInfo)localObject1).position != this.mCurItem) {
            break label1258;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i1 > 0)) {}
        for (Object localObject3 = addNewItem(this.mCurItem, paramInt);; localObject3 = localObject1)
        {
          label343:
          int i4;
          float f2;
          label356:
          float f3;
          int k;
          label378:
          float f1;
          if (localObject3 != null)
          {
            int n = paramInt - 1;
            int m;
            Object localObject4;
            if (n >= 0)
            {
              localObject1 = (ItemInfo)this.mItems.get(n);
              i4 = getClientWidth();
              if (i4 > 0) {
                break label536;
              }
              f2 = 0.0F;
              i = this.mCurItem;
              f3 = 0.0F;
              m = i - 1;
              k = paramInt;
              localObject4 = localObject1;
              if (m < 0) {
                break label686;
              }
              if ((f3 < f2) || (m >= i3)) {
                break label566;
              }
              if (localObject4 == null) {
                break label686;
              }
              localObject1 = localObject4;
              paramInt = n;
              f1 = f3;
              i = k;
              if (m == ((ItemInfo)localObject4).position)
              {
                localObject1 = localObject4;
                paramInt = n;
                f1 = f3;
                i = k;
                if (!((ItemInfo)localObject4).scrolling)
                {
                  this.mItems.remove(n);
                  this.mAdapter.destroyItem(this, m, ((ItemInfo)localObject4).object);
                  paramInt = n - 1;
                  i = k - 1;
                  if (paramInt < 0) {
                    break label557;
                  }
                  localObject1 = (ItemInfo)this.mItems.get(paramInt);
                  f1 = f3;
                }
              }
            }
            for (;;)
            {
              m--;
              localObject4 = localObject1;
              n = paramInt;
              f3 = f1;
              k = i;
              break label378;
              paramInt++;
              break;
              localObject1 = null;
              break label343;
              label536:
              f2 = 2.0F - ((ItemInfo)localObject3).widthFactor + getPaddingLeft() / i4;
              break label356;
              label557:
              localObject1 = null;
              f1 = f3;
              continue;
              label566:
              if ((localObject4 != null) && (m == ((ItemInfo)localObject4).position))
              {
                f1 = f3 + ((ItemInfo)localObject4).widthFactor;
                paramInt = n - 1;
                if (paramInt >= 0)
                {
                  localObject1 = (ItemInfo)this.mItems.get(paramInt);
                  i = k;
                }
                else
                {
                  localObject1 = null;
                  i = k;
                }
              }
              else
              {
                f1 = f3 + addNewItem(m, n + 1).widthFactor;
                i = k + 1;
                if (n >= 0)
                {
                  localObject1 = (ItemInfo)this.mItems.get(n);
                  paramInt = n;
                }
                else
                {
                  localObject1 = null;
                  paramInt = n;
                }
              }
            }
            label686:
            f1 = ((ItemInfo)localObject3).widthFactor;
            paramInt = k + 1;
            if (f1 < 2.0F) {
              if (paramInt < this.mItems.size())
              {
                localObject1 = (ItemInfo)this.mItems.get(paramInt);
                label727:
                if (i4 > 0) {
                  break label846;
                }
                f2 = 0.0F;
                label734:
                i = this.mCurItem;
                i++;
                label743:
                if (i >= i1) {
                  break label987;
                }
                if ((f1 < f2) || (i <= i2)) {
                  break label867;
                }
                if (localObject1 == null) {
                  break label987;
                }
                if ((i != ((ItemInfo)localObject1).position) || (((ItemInfo)localObject1).scrolling)) {
                  break label1248;
                }
                this.mItems.remove(paramInt);
                this.mAdapter.destroyItem(this, i, ((ItemInfo)localObject1).object);
                if (paramInt >= this.mItems.size()) {
                  break label861;
                }
                localObject1 = (ItemInfo)this.mItems.get(paramInt);
              }
            }
          }
          label846:
          label861:
          label867:
          label987:
          label1240:
          label1246:
          label1248:
          for (;;)
          {
            i++;
            break label743;
            localObject1 = null;
            break label727;
            f2 = getPaddingRight() / i4 + 2.0F;
            break label734;
            localObject1 = null;
            continue;
            if ((localObject1 != null) && (i == ((ItemInfo)localObject1).position))
            {
              f3 = ((ItemInfo)localObject1).widthFactor;
              paramInt++;
              if (paramInt < this.mItems.size()) {}
              for (localObject1 = (ItemInfo)this.mItems.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
            }
            localObject1 = addNewItem(i, paramInt);
            paramInt++;
            f3 = ((ItemInfo)localObject1).widthFactor;
            if (paramInt < this.mItems.size()) {}
            for (localObject1 = (ItemInfo)this.mItems.get(paramInt);; localObject1 = null)
            {
              f1 += f3;
              break;
            }
            calculatePageOffsets((ItemInfo)localObject3, k, (ItemInfo)localObject2);
            localObject2 = this.mAdapter;
            paramInt = this.mCurItem;
            if (localObject3 != null) {}
            for (localObject1 = ((ItemInfo)localObject3).object;; localObject1 = null)
            {
              ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
              this.mAdapter.finishUpdate(this);
              i = getChildCount();
              for (paramInt = 0; paramInt < i; paramInt++)
              {
                localObject2 = getChildAt(paramInt);
                localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
                ((LayoutParams)localObject1).childIndex = paramInt;
                if ((!((LayoutParams)localObject1).isDecor) && (((LayoutParams)localObject1).widthFactor == 0.0F))
                {
                  localObject2 = infoForChild((View)localObject2);
                  if (localObject2 != null)
                  {
                    ((LayoutParams)localObject1).widthFactor = ((ItemInfo)localObject2).widthFactor;
                    ((LayoutParams)localObject1).position = ((ItemInfo)localObject2).position;
                  }
                }
              }
            }
            sortChildDrawingOrder();
            if (!hasFocus()) {
              break;
            }
            localObject1 = findFocus();
            if (localObject1 != null) {}
            for (localObject1 = infoForAnyChild((View)localObject1);; localObject1 = null)
            {
              if ((localObject1 != null) && (((ItemInfo)localObject1).position == this.mCurItem)) {
                break label1246;
              }
              for (paramInt = 0;; paramInt++)
              {
                if (paramInt >= getChildCount()) {
                  break label1240;
                }
                localObject1 = getChildAt(paramInt);
                localObject2 = infoForChild((View)localObject1);
                if ((localObject2 != null) && (((ItemInfo)localObject2).position == this.mCurItem) && (((View)localObject1).requestFocus(j))) {
                  break;
                }
              }
              break;
            }
            break;
          }
        }
        label1258:
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.mInLayout) {
      removeViewInLayout(paramView);
    }
    for (;;)
    {
      return;
      super.removeView(paramView);
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterDataSetObserver(this.mObserver);
      this.mAdapter.startUpdate(this);
      for (int i = 0; i < this.mItems.size(); i++)
      {
        localObject = (ItemInfo)this.mItems.get(i);
        this.mAdapter.destroyItem(this, ((ItemInfo)localObject).position, ((ItemInfo)localObject).object);
      }
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.mAdapter;
    this.mAdapter = paramPagerAdapter;
    this.mExpectedAdapterCount = 0;
    boolean bool;
    if (this.mAdapter != null)
    {
      if (this.mObserver == null) {
        this.mObserver = new PagerObserver(null);
      }
      this.mAdapter.registerDataSetObserver(this.mObserver);
      this.mPopulatePending = false;
      bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem < 0) {
        break label259;
      }
      this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
      setCurrentItemInternal(this.mRestoredCurItem, false, true);
      this.mRestoredCurItem = -1;
      this.mRestoredAdapterState = null;
      this.mRestoredClassLoader = null;
    }
    for (;;)
    {
      if ((this.mAdapterChangeListener != null) && (localObject != paramPagerAdapter)) {
        this.mAdapterChangeListener.onAdapterChanged((PagerAdapter)localObject, paramPagerAdapter);
      }
      return;
      label259:
      if (!bool) {
        populate();
      } else {
        requestLayout();
      }
    }
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.mSetChildrenDrawingOrderEnabled == null)) {}
    try
    {
      this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        for (;;)
        {
          this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
          localNoSuchMethodException = localNoSuchMethodException;
          Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("ViewPager", "Error changing children drawing order", localException);
        }
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.mPopulatePending = false;
    if (!this.mFirstLayout) {}
    for (boolean bool = true;; bool = false)
    {
      setCurrentItemInternal(paramInt, bool, false);
      return;
    }
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.mAdapter == null) || (this.mAdapter.getCount() <= 0)) {
      setScrollingCacheEnabled(false);
    }
    for (;;)
    {
      return;
      if ((!paramBoolean2) && (this.mCurItem == paramInt1) && (this.mItems.size() != 0))
      {
        setScrollingCacheEnabled(false);
      }
      else
      {
        int i;
        if (paramInt1 < 0) {
          i = 0;
        }
        for (;;)
        {
          paramInt1 = this.mOffscreenPageLimit;
          if ((i <= this.mCurItem + paramInt1) && (i >= this.mCurItem - paramInt1)) {
            break;
          }
          for (paramInt1 = 0; paramInt1 < this.mItems.size(); paramInt1++) {
            ((ItemInfo)this.mItems.get(paramInt1)).scrolling = true;
          }
          i = paramInt1;
          if (paramInt1 >= this.mAdapter.getCount()) {
            i = this.mAdapter.getCount() - 1;
          }
        }
        paramBoolean2 = bool;
        if (this.mCurItem != i) {
          paramBoolean2 = true;
        }
        if (this.mFirstLayout)
        {
          this.mCurItem = i;
          if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
            this.mOnPageChangeListener.onPageSelected(i);
          }
          if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
            this.mInternalPageChangeListener.onPageSelected(i);
          }
          requestLayout();
        }
        else
        {
          populate(i);
          scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
        }
      }
    }
  }
  
  OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    OnPageChangeListener localOnPageChangeListener = this.mInternalPageChangeListener;
    this.mInternalPageChangeListener = paramOnPageChangeListener;
    return localOnPageChangeListener;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to 1");
      i = 1;
    }
    if (i != this.mOffscreenPageLimit)
    {
      this.mOffscreenPageLimit = i;
      populate();
    }
  }
  
  void setOnAdapterChangeListener(OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    this.mAdapterChangeListener = paramOnAdapterChangeListener;
  }
  
  public void setOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int j = this.mPageMargin;
    this.mPageMargin = paramInt;
    int i = getWidth();
    recomputeScrollPosition(i, i, paramInt, j);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  public void setPageTransformer(boolean paramBoolean, PageTransformer paramPageTransformer)
  {
    int j = 1;
    boolean bool1;
    boolean bool2;
    label28:
    int i;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramPageTransformer == null) {
        break label75;
      }
      bool1 = true;
      if (this.mPageTransformer == null) {
        break label81;
      }
      bool2 = true;
      if (bool1 == bool2) {
        break label87;
      }
      i = 1;
      label37:
      this.mPageTransformer = paramPageTransformer;
      setChildrenDrawingOrderEnabledCompat(bool1);
      if (!bool1) {
        break label92;
      }
      if (paramBoolean) {
        j = 2;
      }
    }
    label75:
    label81:
    label87:
    label92:
    for (this.mDrawingOrder = j;; this.mDrawingOrder = 0)
    {
      if (i != 0) {
        populate();
      }
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label28;
      i = 0;
      break label37;
    }
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollTo(paramInt1, paramInt2, 0);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0) {
      setScrollingCacheEnabled(false);
    }
    int j;
    int i;
    int k;
    for (;;)
    {
      return;
      j = getScrollX();
      i = getScrollY();
      k = paramInt1 - j;
      paramInt2 -= i;
      if ((k != 0) || (paramInt2 != 0)) {
        break;
      }
      completeScroll(false);
      populate();
      setScrollState(0);
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int m = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(k) * 1.0F / paramInt1);
    float f1 = m;
    float f2 = m;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;; paramInt1 = (int)((Math.abs(k) / (f1 * f2 + this.mPageMargin) + 1.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.mScroller.startScroll(j, i, k, paramInt2, paramInt1);
      ViewCompat.postInvalidateOnAnimation(this);
      break;
      f1 = paramInt1;
      f2 = this.mAdapter.getPageWidth(this.mCurItem);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mMarginDrawable)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static abstract interface Decor {}
  
  static class ItemInfo
  {
    Object object;
    float offset;
    int position;
    boolean scrolling;
    float widthFactor;
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    int childIndex;
    public int gravity;
    public boolean isDecor;
    boolean needsMeasure;
    int position;
    float widthFactor = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.LAYOUT_ATTRS);
      this.gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  class MyAccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    MyAccessibilityDelegate() {}
    
    private boolean canScroll()
    {
      boolean bool = true;
      if ((ViewPager.this.mAdapter != null) && (ViewPager.this.mAdapter.getCount() > 1)) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ViewPager.class.getName());
      paramView = AccessibilityRecordCompat.obtain();
      paramView.setScrollable(canScroll());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (ViewPager.this.mAdapter != null))
      {
        paramView.setItemCount(ViewPager.this.mAdapter.getCount());
        paramView.setFromIndex(ViewPager.this.mCurItem);
        paramView.setToIndex(ViewPager.this.mCurItem);
      }
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
      paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
      if (ViewPager.this.canScrollHorizontally(1)) {
        paramAccessibilityNodeInfoCompat.addAction(4096);
      }
      if (ViewPager.this.canScrollHorizontally(-1)) {
        paramAccessibilityNodeInfoCompat.addAction(8192);
      }
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      boolean bool = true;
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {}
      for (;;)
      {
        return bool;
        switch (paramInt)
        {
        default: 
          bool = false;
          break;
        case 4096: 
          if (ViewPager.this.canScrollHorizontally(1)) {
            ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + 1);
          } else {
            bool = false;
          }
          break;
        case 8192: 
          if (ViewPager.this.canScrollHorizontally(-1)) {
            ViewPager.this.setCurrentItem(ViewPager.this.mCurItem - 1);
          } else {
            bool = false;
          }
          break;
        }
      }
    }
  }
  
  static abstract interface OnAdapterChangeListener
  {
    public abstract void onAdapterChanged(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2);
  }
  
  public static abstract interface OnPageChangeListener
  {
    public abstract void onPageScrollStateChanged(int paramInt);
    
    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
  
  public static abstract interface PageTransformer
  {
    public abstract void transformPage(View paramView, float paramFloat);
  }
  
  private class PagerObserver
    extends DataSetObserver
  {
    private PagerObserver() {}
    
    public void onChanged()
    {
      ViewPager.this.dataSetChanged();
    }
    
    public void onInvalidated()
    {
      ViewPager.this.dataSetChanged();
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ViewPager.SavedState.1());
    Parcelable adapterState;
    ClassLoader loader;
    int position;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.adapterState = paramParcel.readParcelable(localClassLoader);
      this.loader = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.adapterState, paramInt);
    }
  }
  
  public static class SimpleOnPageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt) {}
  }
  
  static class ViewPositionComparator
    implements Comparator<View>
  {
    public int compare(View paramView1, View paramView2)
    {
      paramView1 = (ViewPager.LayoutParams)paramView1.getLayoutParams();
      paramView2 = (ViewPager.LayoutParams)paramView2.getLayoutParams();
      int i;
      if (paramView1.isDecor != paramView2.isDecor) {
        if (paramView1.isDecor) {
          i = 1;
        }
      }
      for (;;)
      {
        return i;
        i = -1;
        continue;
        i = paramView1.position - paramView2.position;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/view/ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */