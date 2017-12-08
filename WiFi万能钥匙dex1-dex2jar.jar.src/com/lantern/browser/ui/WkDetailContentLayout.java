package com.lantern.browser.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.browser.WkBrowserWebView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class WkDetailContentLayout
  extends FrameLayout
{
  private Context a;
  private WkBrowserWebView b;
  private WkDetailBottomLayout c;
  private float d;
  private int e;
  private int f;
  private int g;
  private Scroller h;
  private VelocityTracker i;
  private boolean j;
  private String k;
  private boolean l;
  private boolean m;
  
  public WkDetailContentLayout(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    d();
  }
  
  public WkDetailContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    d();
  }
  
  public WkDetailContentLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    d();
  }
  
  private int a(int paramInt)
  {
    int n = 0;
    int i1 = Math.abs(paramInt);
    int i2 = getScrollY();
    if (paramInt > 0)
    {
      paramInt = getBottom();
      if (this.c.getVisibility() != 8) {
        paramInt = this.c.getBottom();
      }
      n = Math.min(paramInt - getScrollY() - getBottom(), i1);
    }
    for (;;)
    {
      return n;
      if (paramInt < 0) {
        n = -Math.min(i1, i2);
      }
    }
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getX();
    int n = (int)paramMotionEvent.getY();
    int i2 = getScrollY();
    if ((n >= paramView.getTop() - i2) && (n < paramView.getBottom() - i2) && (i1 >= paramView.getLeft()) && (i1 < paramView.getRight())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void d()
  {
    setOverScrollMode(2);
    this.h = new Scroller(this.a);
    this.e = ViewConfiguration.get(this.a).getScaledTouchSlop();
    this.f = ViewConfiguration.get(this.a).getScaledMinimumFlingVelocity();
    this.g = ViewConfiguration.get(this.a).getScaledMaximumFlingVelocity();
    this.c = new WkDetailBottomLayout(this.a);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    addView(this.c, localLayoutParams);
  }
  
  private void e()
  {
    if (this.i != null)
    {
      this.i.recycle();
      this.i = null;
    }
  }
  
  public final void a()
  {
    if (this.b != null) {
      removeView(this.b);
    }
  }
  
  public final void a(View paramView)
  {
    addView(paramView, 0, new FrameLayout.LayoutParams(-1, -1));
    this.b = ((WkBrowserWebView)paramView);
    this.b.a(new i(this));
  }
  
  public final WkDetailBottomLayout b()
  {
    return this.c;
  }
  
  public final void b(View paramView)
  {
    removeView(paramView);
    this.b = null;
  }
  
  public final void c()
  {
    h.a("onWebViewContentHeightChanged " + this.b.getMeasuredHeight(), new Object[0]);
    if (getScrollY() > 0) {
      this.b.scrollTo(0, (int)(this.b.getContentHeight() * this.b.getScale()));
    }
    if (this.b.getMeasuredHeight() != getHeight()) {
      requestLayout();
    }
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    boolean bool;
    if (paramInt == -1)
    {
      if (getScrollY() <= 0) {
        break label64;
      }
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (paramInt == 1)
      {
        int n = getHeight();
        if (this.c.getVisibility() != 8) {
          n = this.c.getBottom();
        }
        if (getScrollY() + getHeight() < n)
        {
          bool = true;
          continue;
        }
      }
      label64:
      bool = super.canScrollVertically(paramInt);
    }
  }
  
  public void computeScroll()
  {
    if (this.h.computeScrollOffset())
    {
      int i1 = getScrollY();
      int n = this.h.getCurrY();
      if (i1 != n)
      {
        n = a(n - i1);
        if (n == 0) {
          break label56;
        }
        scrollBy(0, n);
      }
    }
    for (;;)
    {
      awakenScrollBars();
      super.computeScroll();
      return;
      label56:
      this.h.forceFinished(true);
    }
  }
  
  protected int computeVerticalScrollRange()
  {
    int n = getHeight();
    if (this.c.getVisibility() != 8) {
      n = this.c.getBottom();
    }
    return n - getHeight();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (getChildCount() < 2) {}
    boolean bool4;
    boolean bool3;
    do
    {
      return bool1;
      bool4 = a(this.b, paramMotionEvent);
      bool3 = a(this.c, paramMotionEvent);
    } while ((!bool4) && (!bool3));
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool1 = this.j;
      break;
      this.d = ((int)paramMotionEvent.getY());
      if (!this.h.isFinished()) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.j = bool1;
        break;
      }
      int i1 = (int)paramMotionEvent.getY();
      int n = (int)(i1 - this.d);
      if (Math.abs(n) > this.e) {
        if (n < 0)
        {
          if (bool4)
          {
            if ((!this.b.canScrollVertically(1)) && (canScrollVertically(1)))
            {
              this.d = ((int)paramMotionEvent.getY());
              this.j = true;
            }
          }
          else if (bool3)
          {
            if (canScrollVertically(1)) {
              this.j = true;
            }
          }
          else
          {
            this.j = false;
            this.d = i1;
          }
        }
        else if (n > 0) {
          if (bool4)
          {
            if (canScrollVertically(-1)) {
              this.j = true;
            }
          }
          else if (bool3)
          {
            if ((!this.c.canScrollVertically(-1)) && (canScrollVertically(-1)))
            {
              this.d = i1;
              this.j = true;
            }
          }
          else
          {
            this.j = false;
            continue;
            this.j = false;
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int n = getChildCount();
    for (paramInt3 = 0; paramInt3 < n; paramInt3++)
    {
      View localView = getChildAt(paramInt3);
      int i1 = localView.getMeasuredWidth();
      paramInt4 = localView.getMeasuredHeight();
      if (paramInt3 == 0) {
        paramInt4 = getHeight();
      }
      localView.layout(paramInt1, paramInt2, i1 + paramInt1, paramInt2 + paramInt4);
      paramInt2 += paramInt4;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (getChildCount() < 2) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool1;
      if (this.i == null) {
        this.i = VelocityTracker.obtain();
      }
      this.i.addMovement(paramMotionEvent);
      int n = paramMotionEvent.getAction();
      float f1 = paramMotionEvent.getY();
      switch (n)
      {
      default: 
        bool1 = bool2;
        break;
      case 0: 
        if (!this.h.isFinished()) {
          bool1 = true;
        }
        this.j = bool1;
        if (!this.h.isFinished()) {
          this.h.abortAnimation();
        }
        this.d = f1;
        bool1 = bool2;
        break;
      case 2: 
        bool1 = bool2;
        if (this.j)
        {
          if ((this.c.c()) && (!this.m))
          {
            this.m = true;
            paramMotionEvent = new HashMap();
            paramMotionEvent.put("newsId", this.k);
            a.e().onEvent("brelashow", new JSONObject(paramMotionEvent).toString());
          }
          if ((this.c.d()) && (!this.l))
          {
            this.l = true;
            paramMotionEvent = new HashMap();
            paramMotionEvent.put("newsId", this.k);
            a.e().onEvent("ddhshow", new JSONObject(paramMotionEvent).toString());
          }
          this.b.c();
          n = a(-(int)(f1 - this.d));
          if (n != 0) {
            scrollBy(0, n);
          }
          for (;;)
          {
            this.d = f1;
            bool1 = bool2;
            break;
            if (!this.h.isFinished()) {
              this.h.abortAnimation();
            }
          }
        }
        break;
      case 1: 
        int i1;
        if (this.j)
        {
          this.i.computeCurrentVelocity(1000, this.g);
          n = (int)this.i.getYVelocity();
          if (Math.abs(n) > this.f)
          {
            i1 = -n;
            if (i1 <= 0) {
              break label434;
            }
          }
        }
        for (n = computeVerticalScrollRange();; n = getScrollY())
        {
          this.h.fling(0, getScrollY(), 0, i1, 0, 0, 0, n);
          postInvalidate();
          e();
          bool1 = bool2;
          break;
        }
      case 3: 
        label434:
        e();
        bool1 = bool2;
      }
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (this.c.getVisibility() == 8) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    for (;;)
    {
      return;
      if (paramBoolean) {
        e();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/WkDetailContentLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */