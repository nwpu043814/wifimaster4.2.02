package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout
  extends ViewGroup
{
  private static final int DEFAULT_FADE_COLOR = -858993460;
  private static final int DEFAULT_OVERHANG_SIZE = 32;
  static final SlidingPanelLayoutImpl IMPL;
  private static final int MIN_FLING_VELOCITY = 400;
  private static final String TAG = "SlidingPaneLayout";
  private boolean mCanSlide;
  private int mCoveredFadeColor;
  private final ViewDragHelper mDragHelper;
  private boolean mFirstLayout = true;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private boolean mIsUnableToDrag;
  private final int mOverhangSize;
  private PanelSlideListener mPanelSlideListener;
  private int mParallaxBy;
  private float mParallaxOffset;
  private final ArrayList<DisableLayerRunnable> mPostedRunnables = new ArrayList();
  private boolean mPreservedOpenState;
  private Drawable mShadowDrawable;
  private float mSlideOffset;
  private int mSlideRange;
  private View mSlideableView;
  private int mSliderFadeColor = -858993460;
  private final Rect mTmpRect = new Rect();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17) {
      IMPL = new SlidingPanelLayoutImplJBMR1();
    }
    for (;;)
    {
      return;
      if (i >= 16) {
        IMPL = new SlidingPanelLayoutImplJB();
      } else {
        IMPL = new SlidingPanelLayoutImplBase();
      }
    }
  }
  
  public SlidingPaneLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mOverhangSize = ((int)(32.0F * f + 0.5F));
    ViewConfiguration.get(paramContext);
    setWillNotDraw(false);
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
    ViewCompat.setImportantForAccessibility(this, 1);
    this.mDragHelper = ViewDragHelper.create(this, 0.5F, new DragHelperCallback(null));
    this.mDragHelper.setEdgeTrackingEnabled(1);
    this.mDragHelper.setMinVelocity(f * 400.0F);
  }
  
  private boolean closePane(View paramView, int paramInt)
  {
    boolean bool = false;
    if ((this.mFirstLayout) || (smoothSlideTo(0.0F, paramInt)))
    {
      this.mPreservedOpenState = false;
      bool = true;
    }
    return bool;
  }
  
  private void dimChildView(View paramView, float paramFloat, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      int i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (localLayoutParams.dimPaint == null) {
        localLayoutParams.dimPaint = new Paint();
      }
      localLayoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (ViewCompat.getLayerType(paramView) != 2) {
        ViewCompat.setLayerType(paramView, 2, localLayoutParams.dimPaint);
      }
      invalidateChildRegion(paramView);
    }
    for (;;)
    {
      return;
      if (ViewCompat.getLayerType(paramView) != 0)
      {
        if (localLayoutParams.dimPaint != null) {
          localLayoutParams.dimPaint.setColorFilter(null);
        }
        paramView = new DisableLayerRunnable(paramView);
        this.mPostedRunnables.add(paramView);
        ViewCompat.postOnAnimation(this, paramView);
      }
    }
  }
  
  private void invalidateChildRegion(View paramView)
  {
    IMPL.invalidateChildRegion(this, paramView);
  }
  
  private void onPanelDragged(int paramInt)
  {
    if (this.mSlideableView == null) {
      this.mSlideOffset = 0.0F;
    }
    for (;;)
    {
      return;
      LayoutParams localLayoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
      this.mSlideOffset = ((paramInt - (getPaddingLeft() + localLayoutParams.leftMargin)) / this.mSlideRange);
      if (this.mParallaxBy != 0) {
        parallaxOtherViews(this.mSlideOffset);
      }
      if (localLayoutParams.dimWhenOffset) {
        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
      }
      dispatchOnPanelSlide(this.mSlideableView);
    }
  }
  
  private boolean openPane(View paramView, int paramInt)
  {
    boolean bool = true;
    if ((this.mFirstLayout) || (smoothSlideTo(1.0F, paramInt))) {
      this.mPreservedOpenState = true;
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void parallaxOtherViews(float paramFloat)
  {
    int j = 0;
    Object localObject = (LayoutParams)this.mSlideableView.getLayoutParams();
    if ((((LayoutParams)localObject).dimWhenOffset) && (((LayoutParams)localObject).leftMargin <= 0)) {}
    for (int i = 1;; i = 0)
    {
      int k = getChildCount();
      while (j < k)
      {
        localObject = getChildAt(j);
        if (localObject != this.mSlideableView)
        {
          int m = (int)((1.0F - this.mParallaxOffset) * this.mParallaxBy);
          this.mParallaxOffset = paramFloat;
          ((View)localObject).offsetLeftAndRight(m - (int)((1.0F - paramFloat) * this.mParallaxBy));
          if (i != 0) {
            dimChildView((View)localObject, 1.0F - this.mParallaxOffset, this.mCoveredFadeColor);
          }
        }
        j++;
      }
    }
  }
  
  private static boolean viewIsOpaque(View paramView)
  {
    boolean bool = true;
    if (ViewCompat.isOpaque(paramView)) {}
    for (;;)
    {
      return bool;
      if (Build.VERSION.SDK_INT >= 18)
      {
        bool = false;
      }
      else
      {
        paramView = paramView.getBackground();
        if (paramView != null)
        {
          if (paramView.getOpacity() != -1) {
            bool = false;
          }
        }
        else {
          bool = false;
        }
      }
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
  
  @Deprecated
  public boolean canSlide()
  {
    return this.mCanSlide;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean closePane()
  {
    return closePane(this.mSlideableView, 0);
  }
  
  public void computeScroll()
  {
    if (this.mDragHelper.continueSettling(true))
    {
      if (this.mCanSlide) {
        break label26;
      }
      this.mDragHelper.abort();
    }
    for (;;)
    {
      return;
      label26:
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void dispatchOnPanelClosed(View paramView)
  {
    if (this.mPanelSlideListener != null) {
      this.mPanelSlideListener.onPanelClosed(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelOpened(View paramView)
  {
    if (this.mPanelSlideListener != null) {
      this.mPanelSlideListener.onPanelOpened(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelSlide(View paramView)
  {
    if (this.mPanelSlideListener != null) {
      this.mPanelSlideListener.onPanelSlide(paramView, this.mSlideOffset);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    View localView;
    if (getChildCount() > 1)
    {
      localView = getChildAt(1);
      if ((localView != null) && (this.mShadowDrawable != null)) {
        break label39;
      }
    }
    for (;;)
    {
      return;
      localView = null;
      break;
      label39:
      int m = this.mShadowDrawable.getIntrinsicWidth();
      int k = localView.getLeft();
      int i = localView.getTop();
      int j = localView.getBottom();
      this.mShadowDrawable.setBounds(k - m, i, k, j);
      this.mShadowDrawable.draw(paramCanvas);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save(2);
    if ((this.mCanSlide) && (!localLayoutParams.slideable) && (this.mSlideableView != null))
    {
      paramCanvas.getClipBounds(this.mTmpRect);
      this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
      paramCanvas.clipRect(this.mTmpRect);
    }
    boolean bool;
    if (Build.VERSION.SDK_INT < 11)
    {
      if ((!localLayoutParams.dimWhenOffset) || (this.mSlideOffset <= 0.0F)) {
        break label202;
      }
      if (!paramView.isDrawingCacheEnabled()) {
        paramView.setDrawingCacheEnabled(true);
      }
      Bitmap localBitmap = paramView.getDrawingCache();
      if (localBitmap != null)
      {
        paramCanvas.drawBitmap(localBitmap, paramView.getLeft(), paramView.getTop(), localLayoutParams.dimPaint);
        bool = false;
        paramCanvas.restoreToCount(i);
        return bool;
      }
      Log.e("SlidingPaneLayout", "drawChild: child view " + paramView + " returned null drawing cache");
    }
    for (;;)
    {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      break;
      label202:
      if (paramView.isDrawingCacheEnabled()) {
        paramView.setDrawingCacheEnabled(false);
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
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {}
    for (paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);; paramLayoutParams = new LayoutParams(paramLayoutParams)) {
      return paramLayoutParams;
    }
  }
  
  public int getCoveredFadeColor()
  {
    return this.mCoveredFadeColor;
  }
  
  public int getParallaxDistance()
  {
    return this.mParallaxBy;
  }
  
  public int getSliderFadeColor()
  {
    return this.mSliderFadeColor;
  }
  
  boolean isDimmed(View paramView)
  {
    boolean bool;
    if (paramView == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      paramView = (LayoutParams)paramView.getLayoutParams();
      if ((this.mCanSlide) && (paramView.dimWhenOffset) && (this.mSlideOffset > 0.0F)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public boolean isOpen()
  {
    if ((!this.mCanSlide) || (this.mSlideOffset == 1.0F)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isSlideable()
  {
    return this.mCanSlide;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    int j = this.mPostedRunnables.size();
    for (int i = 0; i < j; i++) {
      ((DisableLayerRunnable)this.mPostedRunnables.get(i)).run();
    }
    this.mPostedRunnables.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    boolean bool1;
    if ((!this.mCanSlide) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null)
      {
        if (this.mDragHelper.isViewUnder(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label108;
        }
        bool1 = true;
        this.mPreservedOpenState = bool1;
      }
    }
    if ((!this.mCanSlide) || ((this.mIsUnableToDrag) && (i != 0)))
    {
      this.mDragHelper.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool1;
      label108:
      bool1 = false;
      break;
      if ((i == 3) || (i == 1))
      {
        this.mDragHelper.cancel();
        bool1 = bool2;
      }
      else
      {
        switch (i)
        {
        }
        label168:
        float f1;
        float f2;
        do
        {
          for (i = 0;; i = 1)
          {
            if (!this.mDragHelper.shouldInterceptTouchEvent(paramMotionEvent))
            {
              bool1 = bool2;
              if (i == 0) {
                break;
              }
            }
            bool1 = true;
            break;
            this.mIsUnableToDrag = false;
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            this.mInitialMotionX = f1;
            this.mInitialMotionY = f2;
            if ((!this.mDragHelper.isViewUnder(this.mSlideableView, (int)f1, (int)f2)) || (!isDimmed(this.mSlideableView))) {
              break label168;
            }
          }
          f2 = paramMotionEvent.getX();
          f1 = paramMotionEvent.getY();
          f2 = Math.abs(f2 - this.mInitialMotionX);
          f1 = Math.abs(f1 - this.mInitialMotionY);
        } while ((f2 <= this.mDragHelper.getTouchSlop()) || (f1 <= f2));
        this.mDragHelper.cancel();
        this.mIsUnableToDrag = true;
        bool1 = bool2;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = paramInt3 - paramInt1;
    paramInt2 = getPaddingLeft();
    int m = getPaddingRight();
    int j = getPaddingTop();
    int i = getChildCount();
    float f;
    if (this.mFirstLayout)
    {
      if ((this.mCanSlide) && (this.mPreservedOpenState))
      {
        f = 1.0F;
        this.mSlideOffset = f;
      }
    }
    else
    {
      paramInt3 = 0;
      paramInt1 = paramInt2;
      label64:
      if (paramInt3 >= i) {
        break label316;
      }
      View localView = getChildAt(paramInt3);
      if (localView.getVisibility() == 8) {
        break label424;
      }
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredWidth();
      paramInt4 = 0;
      if (!localLayoutParams.slideable) {
        break label280;
      }
      int i2 = localLayoutParams.leftMargin;
      int i1 = localLayoutParams.rightMargin;
      i1 = Math.min(paramInt1, k - m - this.mOverhangSize) - paramInt2 - (i2 + i1);
      this.mSlideRange = i1;
      if (localLayoutParams.leftMargin + paramInt2 + i1 + n / 2 <= k - m) {
        break label275;
      }
      paramBoolean = true;
      label186:
      localLayoutParams.dimWhenOffset = paramBoolean;
      i1 = (int)(i1 * this.mSlideOffset);
      paramInt2 = localLayoutParams.leftMargin + i1 + paramInt2;
      this.mSlideOffset = (i1 / this.mSlideRange);
      paramInt4 = paramInt2 - paramInt4;
      localView.layout(paramInt4, j, paramInt4 + n, localView.getMeasuredHeight() + j);
      paramInt1 += localView.getWidth();
    }
    label275:
    label280:
    label316:
    label391:
    label424:
    for (;;)
    {
      paramInt3++;
      break label64;
      f = 0.0F;
      break;
      paramBoolean = false;
      break label186;
      if ((this.mCanSlide) && (this.mParallaxBy != 0)) {}
      for (paramInt2 = (int)((1.0F - this.mSlideOffset) * this.mParallaxBy);; paramInt2 = 0)
      {
        paramInt4 = paramInt2;
        paramInt2 = paramInt1;
        break;
        if (this.mFirstLayout)
        {
          if (!this.mCanSlide) {
            break label391;
          }
          if (this.mParallaxBy != 0) {
            parallaxOtherViews(this.mSlideOffset);
          }
          if (((LayoutParams)this.mSlideableView.getLayoutParams()).dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
          }
        }
        for (;;)
        {
          updateObscuredViewsVisibility(this.mSlideableView);
          this.mFirstLayout = false;
          return;
          for (paramInt1 = 0; paramInt1 < i; paramInt1++) {
            dimChildView(getChildAt(paramInt1), 0.0F, this.mSliderFadeColor);
          }
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (k != 1073741824) {
      if (isInEditMode())
      {
        if ((k == Integer.MIN_VALUE) || (k != 0)) {
          break label1063;
        }
        i = j;
        j = 300;
      }
    }
    for (;;)
    {
      label93:
      boolean bool1;
      int i2;
      int i1;
      float f1;
      label140:
      Object localObject1;
      Object localObject2;
      int m;
      switch (i)
      {
      default: 
        paramInt1 = 0;
        k = -1;
        bool1 = false;
        paramInt2 = j - getPaddingLeft() - getPaddingRight();
        i2 = getChildCount();
        if (i2 > 2) {
          Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        i1 = 0;
        f1 = 0.0F;
        if (i1 < i2)
        {
          localObject1 = getChildAt(i1);
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          if (((View)localObject1).getVisibility() == 8)
          {
            ((LayoutParams)localObject2).dimWhenOffset = false;
            m = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = m;
          }
        }
        break;
      }
      for (;;)
      {
        i1++;
        m = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = m;
        break label140;
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        if (j != 0) {
          break label1063;
        }
        if (isInEditMode())
        {
          if (j != 0) {
            break label1063;
          }
          paramInt2 = Integer.MIN_VALUE;
          j = i;
          paramInt1 = 300;
          i = paramInt2;
          break;
        }
        throw new IllegalStateException("Height must not be UNSPECIFIED");
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        k = paramInt1;
        break label93;
        m = getPaddingTop();
        k = getPaddingBottom();
        paramInt2 = 0;
        k = paramInt1 - m - k;
        paramInt1 = paramInt2;
        break label93;
        float f2 = f1;
        if (((LayoutParams)localObject2).weight > 0.0F)
        {
          f1 += ((LayoutParams)localObject2).weight;
          if (((LayoutParams)localObject2).width != 0) {
            f2 = f1;
          }
        }
        else
        {
          m = ((LayoutParams)localObject2).leftMargin + ((LayoutParams)localObject2).rightMargin;
          label374:
          int n;
          label394:
          int i3;
          if (((LayoutParams)localObject2).width == -2)
          {
            m = View.MeasureSpec.makeMeasureSpec(j - m, Integer.MIN_VALUE);
            if (((LayoutParams)localObject2).height != -2) {
              break label536;
            }
            n = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
            ((View)localObject1).measure(m, n);
            n = ((View)localObject1).getMeasuredWidth();
            i3 = ((View)localObject1).getMeasuredHeight();
            m = paramInt1;
            if (i == Integer.MIN_VALUE)
            {
              m = paramInt1;
              if (i3 > paramInt1) {
                m = Math.min(i3, k);
              }
            }
            paramInt1 = paramInt2 - n;
            if (paramInt1 >= 0) {
              break label574;
            }
          }
          label536:
          label574:
          for (boolean bool2 = true;; bool2 = false)
          {
            ((LayoutParams)localObject2).slideable = bool2;
            if (((LayoutParams)localObject2).slideable) {
              this.mSlideableView = ((View)localObject1);
            }
            f1 = f2;
            bool1 = bool2 | bool1;
            paramInt2 = m;
            break;
            if (((LayoutParams)localObject2).width == -1)
            {
              m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);
              break label374;
            }
            m = View.MeasureSpec.makeMeasureSpec(((LayoutParams)localObject2).width, 1073741824);
            break label374;
            if (((LayoutParams)localObject2).height == -1)
            {
              n = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
              break label394;
            }
            n = View.MeasureSpec.makeMeasureSpec(((LayoutParams)localObject2).height, 1073741824);
            break label394;
          }
          if ((bool1) || (f1 > 0.0F))
          {
            i1 = j - this.mOverhangSize;
            m = 0;
            if (m < i2)
            {
              localObject2 = getChildAt(m);
              if (((View)localObject2).getVisibility() != 8)
              {
                localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
                if (((View)localObject2).getVisibility() != 8)
                {
                  if ((((LayoutParams)localObject1).width != 0) || (((LayoutParams)localObject1).weight <= 0.0F)) {
                    break label762;
                  }
                  i = 1;
                  label669:
                  if (i == 0) {
                    break label768;
                  }
                  n = 0;
                  label677:
                  if ((!bool1) || (localObject2 == this.mSlideableView)) {
                    break label832;
                  }
                  if ((((LayoutParams)localObject1).width < 0) && ((n > i1) || (((LayoutParams)localObject1).weight > 0.0F)))
                  {
                    if (i == 0) {
                      break label816;
                    }
                    if (((LayoutParams)localObject1).height != -2) {
                      break label778;
                    }
                    i = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
                    label741:
                    ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), i);
                  }
                }
              }
              for (;;)
              {
                m++;
                break;
                label762:
                i = 0;
                break label669;
                label768:
                n = ((View)localObject2).getMeasuredWidth();
                break label677;
                label778:
                if (((LayoutParams)localObject1).height == -1)
                {
                  i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                  break label741;
                }
                i = View.MeasureSpec.makeMeasureSpec(((LayoutParams)localObject1).height, 1073741824);
                break label741;
                label816:
                i = View.MeasureSpec.makeMeasureSpec(((View)localObject2).getMeasuredHeight(), 1073741824);
                break label741;
                label832:
                if (((LayoutParams)localObject1).weight > 0.0F)
                {
                  if (((LayoutParams)localObject1).width == 0) {
                    if (((LayoutParams)localObject1).height == -2) {
                      i = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
                    }
                  }
                  for (;;)
                  {
                    if (!bool1) {
                      break label978;
                    }
                    i3 = ((LayoutParams)localObject1).leftMargin;
                    int i4 = j - (((LayoutParams)localObject1).rightMargin + i3);
                    i3 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                    if (n == i4) {
                      break;
                    }
                    ((View)localObject2).measure(i3, i);
                    break;
                    if (((LayoutParams)localObject1).height == -1)
                    {
                      i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                    }
                    else
                    {
                      i = View.MeasureSpec.makeMeasureSpec(((LayoutParams)localObject1).height, 1073741824);
                      continue;
                      i = View.MeasureSpec.makeMeasureSpec(((View)localObject2).getMeasuredHeight(), 1073741824);
                    }
                  }
                  label978:
                  i3 = Math.max(0, paramInt2);
                  ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec((int)(((LayoutParams)localObject1).weight * i3 / f1) + n, 1073741824), i);
                }
              }
            }
          }
          setMeasuredDimension(j, paramInt1);
          this.mCanSlide = bool1;
          if ((this.mDragHelper.getViewDragState() != 0) && (!bool1)) {
            this.mDragHelper.abort();
          }
          return;
        }
        m = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = m;
      }
      label1063:
      paramInt2 = j;
      j = i;
      i = paramInt2;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.isOpen) {
      openPane();
    }
    for (;;)
    {
      this.mPreservedOpenState = paramParcelable.isOpen;
      return;
      closePane();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (isSlideable()) {}
    for (boolean bool = isOpen();; bool = this.mPreservedOpenState)
    {
      localSavedState.isOpen = bool;
      return localSavedState;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.mFirstLayout = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (!this.mCanSlide)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    this.mDragHelper.processTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      bool = true;
      break;
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      this.mInitialMotionX = f2;
      this.mInitialMotionY = f1;
      continue;
      if (isDimmed(this.mSlideableView))
      {
        float f3 = paramMotionEvent.getX();
        float f4 = paramMotionEvent.getY();
        f2 = f3 - this.mInitialMotionX;
        f1 = f4 - this.mInitialMotionY;
        int i = this.mDragHelper.getTouchSlop();
        if ((f2 * f2 + f1 * f1 < i * i) && (this.mDragHelper.isViewUnder(this.mSlideableView, (int)f3, (int)f4))) {
          closePane(this.mSlideableView, 0);
        }
      }
    }
  }
  
  public boolean openPane()
  {
    return openPane(this.mSlideableView, 0);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.mCanSlide)) {
      if (paramView1 != this.mSlideableView) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.mPreservedOpenState = bool;
      return;
    }
  }
  
  void setAllChildrenVisible()
  {
    int j = getChildCount();
    for (int i = 0; i < j; i++)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    this.mCoveredFadeColor = paramInt;
  }
  
  public void setPanelSlideListener(PanelSlideListener paramPanelSlideListener)
  {
    this.mPanelSlideListener = paramPanelSlideListener;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    this.mParallaxBy = paramInt;
    requestLayout();
  }
  
  public void setShadowDrawable(Drawable paramDrawable)
  {
    this.mShadowDrawable = paramDrawable;
  }
  
  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setSliderFadeColor(int paramInt)
  {
    this.mSliderFadeColor = paramInt;
  }
  
  @Deprecated
  public void smoothSlideClosed()
  {
    closePane();
  }
  
  @Deprecated
  public void smoothSlideOpen()
  {
    openPane();
  }
  
  boolean smoothSlideTo(float paramFloat, int paramInt)
  {
    boolean bool;
    if (!this.mCanSlide) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      LayoutParams localLayoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
      paramInt = getPaddingLeft();
      paramInt = (int)(localLayoutParams.leftMargin + paramInt + this.mSlideRange * paramFloat);
      if (this.mDragHelper.smoothSlideViewTo(this.mSlideableView, paramInt, this.mSlideableView.getTop()))
      {
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  void updateObscuredViewsVisibility(View paramView)
  {
    int i5 = getPaddingLeft();
    int i7 = getWidth();
    int i2 = getPaddingRight();
    int i6 = getPaddingTop();
    int i4 = getHeight();
    int i3 = getPaddingBottom();
    int j;
    int k;
    int i;
    int m;
    int n;
    label78:
    View localView;
    if ((paramView != null) && (viewIsOpaque(paramView)))
    {
      j = paramView.getLeft();
      k = paramView.getRight();
      i = paramView.getTop();
      m = paramView.getBottom();
      int i8 = getChildCount();
      n = 0;
      if (n >= i8) {
        return;
      }
      localView = getChildAt(n);
      if (localView == paramView) {
        return;
      }
      int i10 = Math.max(i5, localView.getLeft());
      int i11 = Math.max(i6, localView.getTop());
      int i9 = Math.min(i7 - i2, localView.getRight());
      i1 = Math.min(i4 - i3, localView.getBottom());
      if ((i10 < j) || (i11 < i) || (i9 > k) || (i1 > m)) {
        break label208;
      }
    }
    label208:
    for (int i1 = 4;; i1 = 0)
    {
      localView.setVisibility(i1);
      n++;
      break label78;
      m = 0;
      i = 0;
      k = 0;
      j = 0;
      break;
    }
  }
  
  class AccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    private final Rect mTmpRect = new Rect();
    
    AccessibilityDelegate() {}
    
    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2)
    {
      Rect localRect = this.mTmpRect;
      paramAccessibilityNodeInfoCompat2.getBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
      paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
      paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
      paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
      paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
      paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
      paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
      paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
      paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
      paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
      paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
      paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
      paramAccessibilityNodeInfoCompat1.setMovementGranularities(paramAccessibilityNodeInfoCompat2.getMovementGranularities());
    }
    
    public boolean filter(View paramView)
    {
      return SlidingPaneLayout.this.isDimmed(paramView);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
      super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
      copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
      localAccessibilityNodeInfoCompat.recycle();
      paramAccessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
      paramAccessibilityNodeInfoCompat.setSource(paramView);
      paramView = ViewCompat.getParentForAccessibility(paramView);
      if ((paramView instanceof View)) {
        paramAccessibilityNodeInfoCompat.setParent((View)paramView);
      }
      int j = SlidingPaneLayout.this.getChildCount();
      for (int i = 0; i < j; i++)
      {
        paramView = SlidingPaneLayout.this.getChildAt(i);
        if ((!filter(paramView)) && (paramView.getVisibility() == 0))
        {
          ViewCompat.setImportantForAccessibility(paramView, 1);
          paramAccessibilityNodeInfoCompat.addChild(paramView);
        }
      }
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!filter(paramView)) {}
      for (boolean bool = super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);; bool = false) {
        return bool;
      }
    }
  }
  
  private class DisableLayerRunnable
    implements Runnable
  {
    final View mChildView;
    
    DisableLayerRunnable(View paramView)
    {
      this.mChildView = paramView;
    }
    
    public void run()
    {
      if (this.mChildView.getParent() == SlidingPaneLayout.this)
      {
        ViewCompat.setLayerType(this.mChildView, 0, null);
        SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
      }
      SlidingPaneLayout.this.mPostedRunnables.remove(this);
    }
  }
  
  private class DragHelperCallback
    extends ViewDragHelper.Callback
  {
    private DragHelperCallback() {}
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.mSlideableView.getLayoutParams();
      paramInt2 = SlidingPaneLayout.this.getPaddingLeft();
      paramInt2 = paramView.leftMargin + paramInt2;
      int i = SlidingPaneLayout.this.mSlideRange;
      return Math.min(Math.max(paramInt1, paramInt2), i + paramInt2);
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return SlidingPaneLayout.this.mSlideRange;
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, paramInt2);
    }
    
    public void onViewCaptured(View paramView, int paramInt)
    {
      SlidingPaneLayout.this.setAllChildrenVisible();
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0)
      {
        if (SlidingPaneLayout.this.mSlideOffset != 0.0F) {
          break label63;
        }
        SlidingPaneLayout.this.updateObscuredViewsVisibility(SlidingPaneLayout.this.mSlideableView);
        SlidingPaneLayout.this.dispatchOnPanelClosed(SlidingPaneLayout.this.mSlideableView);
        SlidingPaneLayout.access$502(SlidingPaneLayout.this, false);
      }
      for (;;)
      {
        return;
        label63:
        SlidingPaneLayout.this.dispatchOnPanelOpened(SlidingPaneLayout.this.mSlideableView);
        SlidingPaneLayout.access$502(SlidingPaneLayout.this, true);
      }
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      SlidingPaneLayout.this.onPanelDragged(paramInt1);
      SlidingPaneLayout.this.invalidate();
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int i = SlidingPaneLayout.this.getPaddingLeft();
      int j = localLayoutParams.leftMargin + i;
      if (paramFloat1 <= 0.0F)
      {
        i = j;
        if (paramFloat1 == 0.0F)
        {
          i = j;
          if (SlidingPaneLayout.this.mSlideOffset <= 0.5F) {}
        }
      }
      else
      {
        i = j + SlidingPaneLayout.this.mSlideRange;
      }
      SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(i, paramView.getTop());
      SlidingPaneLayout.this.invalidate();
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      if (SlidingPaneLayout.this.mIsUnableToDrag) {}
      for (boolean bool = false;; bool = ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).slideable) {
        return bool;
      }
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] ATTRS = { 16843137 };
    Paint dimPaint;
    boolean dimWhenOffset;
    boolean slideable;
    public float weight = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
      this.weight = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.weight = paramLayoutParams.weight;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface PanelSlideListener
  {
    public abstract void onPanelClosed(View paramView);
    
    public abstract void onPanelOpened(View paramView);
    
    public abstract void onPanelSlide(View paramView, float paramFloat);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new SlidingPaneLayout.SavedState.1();
    boolean isOpen;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.isOpen = bool;
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.isOpen) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  public static class SimplePanelSlideListener
    implements SlidingPaneLayout.PanelSlideListener
  {
    public void onPanelClosed(View paramView) {}
    
    public void onPanelOpened(View paramView) {}
    
    public void onPanelSlide(View paramView, float paramFloat) {}
  }
  
  static abstract interface SlidingPanelLayoutImpl
  {
    public abstract void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView);
  }
  
  static class SlidingPanelLayoutImplBase
    implements SlidingPaneLayout.SlidingPanelLayoutImpl
  {
    public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      ViewCompat.postInvalidateOnAnimation(paramSlidingPaneLayout, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    }
  }
  
  static class SlidingPanelLayoutImplJB
    extends SlidingPaneLayout.SlidingPanelLayoutImplBase
  {
    private Method mGetDisplayList;
    private Field mRecreateDisplayList;
    
    SlidingPanelLayoutImplJB()
    {
      try
      {
        this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", null);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          for (;;)
          {
            this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
            this.mRecreateDisplayList.setAccessible(true);
            return;
            localNoSuchMethodException = localNoSuchMethodException;
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", localNoSuchMethodException);
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          for (;;)
          {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", localNoSuchFieldException);
          }
        }
      }
    }
    
    public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      if ((this.mGetDisplayList != null) && (this.mRecreateDisplayList != null)) {}
      for (;;)
      {
        try
        {
          this.mRecreateDisplayList.setBoolean(paramView, true);
          this.mGetDisplayList.invoke(paramView, null);
          super.invalidateChildRegion(paramSlidingPaneLayout, paramView);
          return;
        }
        catch (Exception localException)
        {
          Log.e("SlidingPaneLayout", "Error refreshing display list state", localException);
          continue;
        }
        paramView.invalidate();
      }
    }
  }
  
  static class SlidingPanelLayoutImplJBMR1
    extends SlidingPaneLayout.SlidingPanelLayoutImplBase
  {
    public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      ViewCompat.setLayerPaint(paramView, ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).dimPaint);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/SlidingPaneLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */