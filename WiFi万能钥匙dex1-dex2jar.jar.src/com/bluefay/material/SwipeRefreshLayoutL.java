package com.bluefay.material;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
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

public class SwipeRefreshLayoutL
  extends ViewGroup
{
  private static final int[] r = { 16842766 };
  private p a;
  private View b;
  private int c;
  private MotionEvent d;
  private int e;
  private boolean f = false;
  private int g;
  private float h = -1.0F;
  private float i;
  private int j;
  private float k = 0.0F;
  private float l = 0.0F;
  private int m;
  private int n;
  private boolean o;
  private final DecelerateInterpolator p;
  private final AccelerateInterpolator q;
  private final Animation s = new y(this);
  private Animation t = new z(this);
  private final Animation.AnimationListener u = new aa(this);
  private final Animation.AnimationListener v = new ab(this);
  private final Runnable w = new ac(this);
  private final Runnable x = new ad(this);
  
  public SwipeRefreshLayoutL(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.j = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.a = new p(this);
    this.m = ((int)(getResources().getDisplayMetrics().density * 4.0F));
    this.p = new DecelerateInterpolator(2.0F);
    this.q = new AccelerateInterpolator(1.5F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, r);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void a()
  {
    if (this.b == null)
    {
      if ((getChildCount() > 1) && (!isInEditMode())) {
        throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
      }
      this.b = getChildAt(0);
      this.c = (this.b.getTop() + getPaddingTop());
    }
    if ((this.h == -1.0F) && (getParent() != null) && (((View)getParent()).getHeight() > 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.h = ((int)Math.min(((View)getParent()).getHeight() * 0.6F, localDisplayMetrics.density * 120.0F));
    }
  }
  
  private void a(int paramInt)
  {
    this.b.offsetTopAndBottom(paramInt);
    this.n = this.b.getTop();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.a.a(paramCanvas);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    removeCallbacks(this.x);
    removeCallbacks(this.w);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.w);
    removeCallbacks(this.x);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    a();
    if ((this.o) && (paramMotionEvent.getAction() == 0)) {
      this.o = false;
    }
    if ((isEnabled()) && (!this.o)) {
      if (Build.VERSION.SDK_INT < 14) {
        if ((this.b instanceof AbsListView))
        {
          AbsListView localAbsListView = (AbsListView)this.b;
          if ((localAbsListView.getChildCount() > 0) && ((localAbsListView.getFirstVisiblePosition() > 0) || (localAbsListView.getChildAt(0).getTop() < localAbsListView.getPaddingTop())))
          {
            bool1 = true;
            if (bool1) {
              break label160;
            }
          }
        }
      }
    }
    label160:
    for (boolean bool1 = onTouchEvent(paramMotionEvent);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      }
      return bool2;
      bool1 = false;
      break;
      if (this.b.getScrollY() > 0)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      bool1 = this.b.canScrollVertically(-1);
      break;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getMeasuredWidth();
    paramInt1 = getMeasuredHeight();
    this.a.a(paramInt2, this.m);
    if (getChildCount() == 0) {}
    for (;;)
    {
      return;
      View localView = getChildAt(0);
      paramInt4 = getPaddingLeft();
      paramInt3 = this.n + getPaddingTop();
      localView.layout(paramInt4, paramInt3, paramInt2 - getPaddingLeft() - getPaddingRight() + paramInt4, paramInt1 - getPaddingTop() - getPaddingBottom() + paramInt3);
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
    boolean bool2 = false;
    boolean bool1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      this.l = 0.0F;
      this.d = MotionEvent.obtain(paramMotionEvent);
      this.i = this.d.getY();
      bool1 = bool2;
      continue;
      bool1 = bool2;
      if (this.d != null)
      {
        bool1 = bool2;
        if (!this.o)
        {
          float f3 = paramMotionEvent.getY();
          float f2 = f3 - this.d.getY();
          bool1 = bool2;
          if (f2 > this.g)
          {
            if (f2 > this.h)
            {
              removeCallbacks(this.x);
              this.w.run();
              if (this.f != true)
              {
                a();
                this.l = 0.0F;
                this.f = true;
                if (!this.f) {
                  break label196;
                }
                this.a.a();
              }
              for (;;)
              {
                bool1 = true;
                break;
                label196:
                this.a.b();
              }
            }
            float f1 = this.q.getInterpolation(f2 / this.h);
            label231:
            int i2;
            int i1;
            if (f1 == 0.0F)
            {
              this.l = 0.0F;
              f1 = f2;
              if (this.i > f3) {
                f1 = f2 - this.g;
              }
              i2 = (int)f1;
              int i3 = this.b.getTop();
              if (i2 <= this.h) {
                break label354;
              }
              i1 = (int)this.h;
              label282:
              a(i1 - i3);
              if ((this.i <= f3) || (this.b.getTop() >= this.g)) {
                break label369;
              }
              removeCallbacks(this.x);
            }
            for (;;)
            {
              this.i = paramMotionEvent.getY();
              bool1 = true;
              break;
              this.l = f1;
              this.a.a(f1);
              break label231;
              label354:
              i1 = i2;
              if (i2 >= 0) {
                break label282;
              }
              i1 = 0;
              break label282;
              label369:
              removeCallbacks(this.x);
              postDelayed(this.x, 300L);
            }
            bool1 = bool2;
            if (this.d != null)
            {
              this.d.recycle();
              this.d = null;
              bool1 = bool2;
            }
          }
        }
      }
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  private class a
    implements Animation.AnimationListener
  {
    private a() {}
    
    public void onAnimationEnd(Animation paramAnimation) {}
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/SwipeRefreshLayoutL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */