package com.wifipay.framework.widget.wheel;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.wifipay.R.color;
import com.wifipay.R.drawable;
import java.util.Iterator;
import java.util.LinkedList;

public class WPWheelView
  extends View
{
  boolean a = false;
  WheelScroller.ScrollingListener b = new d(this);
  private int[] c = { -269882903, -806753815, 1072294377 };
  private int d = 0;
  private int e = 5;
  private int f = 0;
  private Drawable g;
  private int h = R.drawable.wifipay_wheel_bg;
  private int i = R.drawable.wifipay_wheel_val;
  private GradientDrawable j;
  private GradientDrawable k;
  private boolean l = true;
  private WheelScroller m;
  private boolean n;
  private int o;
  private LinearLayout p;
  private int q;
  private WheelViewAdapter r;
  private f s = new f(this);
  private LinkedList<OnWheelChangedListener> t = new LinkedList();
  private LinkedList<OnWheelScrollListener> u = new LinkedList();
  private LinkedList<OnWheelClickedListener> v = new LinkedList();
  private DataSetObserver w = new e(this);
  
  public WPWheelView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WPWheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WPWheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(LinearLayout paramLinearLayout)
  {
    if ((paramLinearLayout != null) && (paramLinearLayout.getChildAt(0) != null)) {
      this.f = paramLinearLayout.getChildAt(0).getMeasuredHeight();
    }
    return Math.max(this.f * this.e - this.f * 0 / 50, getSuggestedMinimumHeight());
  }
  
  private void a(Context paramContext)
  {
    this.m = new WheelScroller(getContext(), this.b);
  }
  
  private void a(Canvas paramCanvas)
  {
    int i1 = getItemHeight() * 3;
    this.j.setBounds(0, 0, getWidth(), i1);
    this.j.draw(paramCanvas);
    this.k.setBounds(0, getHeight() - i1, getWidth(), getHeight());
    this.k.draw(paramCanvas);
  }
  
  private void b(int paramInt)
  {
    this.o += paramInt;
    int i4 = getItemHeight();
    paramInt = this.o / i4;
    int i1 = this.d - paramInt;
    int i5 = this.r.getItemsCount();
    int i3 = this.o % i4;
    int i2 = i3;
    if (Math.abs(i3) <= i4 / 2) {
      i2 = 0;
    }
    if ((this.a) && (i5 > 0)) {
      if (i2 > 0)
      {
        i2 = i1 - 1;
        i1 = paramInt + 1;
        paramInt = i2;
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        paramInt += i5;
        continue;
        if (i2 < 0)
        {
          i2 = i1 + 1;
          i1 = paramInt - 1;
          paramInt = i2;
        }
      }
      else
      {
        paramInt %= i5;
        for (;;)
        {
          i2 = this.o;
          if (paramInt != this.d) {
            a(paramInt, false);
          }
          for (;;)
          {
            this.o = (i2 - i1 * i4);
            if (this.o > getHeight()) {
              this.o = (this.o % getHeight() + getHeight());
            }
            return;
            if (i1 < 0)
            {
              i1 = this.d;
              paramInt = 0;
              break;
            }
            if (i1 >= i5)
            {
              i1 = this.d - i5 + 1;
              paramInt = i5 - 1;
              break;
            }
            if ((i1 > 0) && (i2 > 0))
            {
              i2 = i1 - 1;
              i1 = paramInt + 1;
              paramInt = i2;
              break;
            }
            if ((i1 >= i5 - 1) || (i2 >= 0)) {
              break label278;
            }
            i2 = i1 + 1;
            i1 = paramInt - 1;
            paramInt = i2;
            break;
            invalidate();
          }
          label278:
          i2 = paramInt;
          paramInt = i1;
          i1 = i2;
        }
      }
      i2 = paramInt;
      paramInt = i1;
      i1 = i2;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(10.0F, -((this.d - this.q) * getItemHeight() + (getItemHeight() - getHeight()) / 2) + this.o);
    this.p.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  private boolean b(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    View localView = d(paramInt);
    if (localView != null)
    {
      if (!paramBoolean) {
        break label32;
      }
      this.p.addView(localView, 0);
    }
    for (;;)
    {
      bool = true;
      return bool;
      label32:
      this.p.addView(localView);
    }
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    d();
    this.p.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.p.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i1 = this.p.getMeasuredWidth();
    if (paramInt2 == 1073741824) {
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      this.p.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 - 20, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
      return paramInt2;
      i1 = Math.max(i1 + 20, getSuggestedMinimumWidth());
      if (paramInt2 == Integer.MIN_VALUE)
      {
        paramInt2 = paramInt1;
        if (paramInt1 < i1) {}
      }
      else
      {
        paramInt2 = i1;
      }
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    int i1 = getHeight() / 2;
    int i2 = (int)(getItemHeight() / 2 * 1.2D);
    Paint localPaint = new Paint();
    localPaint.setColor(getResources().getColor(R.color.wifipay_color_007cd9));
    localPaint.setStrokeWidth(3.0F);
    paramCanvas.drawLine(0.0F, i1 - i2, getWidth(), i1 - i2, localPaint);
    paramCanvas.drawLine(0.0F, i1 + i2, getWidth(), i1 + i2, localPaint);
  }
  
  private boolean c(int paramInt)
  {
    if ((this.r != null) && (this.r.getItemsCount() > 0) && ((this.a) || ((paramInt >= 0) && (paramInt < this.r.getItemsCount())))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private View d(int paramInt)
  {
    View localView;
    if ((this.r == null) || (this.r.getItemsCount() == 0)) {
      localView = null;
    }
    for (;;)
    {
      return localView;
      int i2 = this.r.getItemsCount();
      int i1 = paramInt;
      if (!c(paramInt))
      {
        localView = this.r.getEmptyItem(this.s.b(), this.p);
      }
      else
      {
        while (i1 < 0) {
          i1 += i2;
        }
        localView = this.r.getItem(i1 % i2, this.s.a(), this.p);
      }
    }
  }
  
  private void d()
  {
    if (this.g == null) {
      this.g = getContext().getResources().getDrawable(this.i);
    }
    if (this.j == null) {
      this.j = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.c);
    }
    if (this.k == null) {
      this.k = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.c);
    }
    setBackgroundResource(this.h);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    this.p.layout(0, 0, paramInt1 - 20, paramInt2);
  }
  
  private boolean e()
  {
    c localc = getItemsRange();
    boolean bool2;
    if (this.p != null)
    {
      i1 = this.s.a(this.p, this.q, localc);
      if (this.q != i1)
      {
        bool2 = true;
        this.q = i1;
        label47:
        bool1 = bool2;
        if (!bool2) {
          if ((this.q == localc.a()) && (this.p.getChildCount() == localc.c())) {
            break label162;
          }
        }
      }
    }
    label162:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((this.q <= localc.a()) || (this.q > localc.b())) {
        break label168;
      }
      for (i1 = this.q - 1; (i1 >= localc.a()) && (b(i1, true)); i1--) {
        this.q = i1;
      }
      bool2 = false;
      break;
      g();
      bool2 = true;
      break label47;
    }
    label168:
    this.q = localc.a();
    int i1 = this.q;
    int i2 = this.p.getChildCount();
    while (i2 < localc.c())
    {
      int i3 = i1;
      if (!b(this.q + i2, false))
      {
        i3 = i1;
        if (this.p.getChildCount() == 0) {
          i3 = i1 + 1;
        }
      }
      i2++;
      i1 = i3;
    }
    this.q = i1;
    return bool1;
  }
  
  private void f()
  {
    if (e())
    {
      c(getWidth(), 1073741824);
      d(getWidth(), getHeight());
    }
  }
  
  private void g()
  {
    if (this.p == null)
    {
      this.p = new LinearLayout(getContext());
      this.p.setOrientation(1);
    }
  }
  
  private int getItemHeight()
  {
    int i1;
    if (this.f != 0) {
      i1 = this.f;
    }
    for (;;)
    {
      return i1;
      if ((this.p != null) && (this.p.getChildAt(0) != null))
      {
        this.f = this.p.getChildAt(0).getHeight();
        i1 = this.f;
      }
      else
      {
        i1 = getHeight() / this.e;
      }
    }
  }
  
  private c getItemsRange()
  {
    if (getItemHeight() == 0) {}
    int i4;
    int i3;
    for (c localc = null;; localc = new c(i3, i4))
    {
      return localc;
      int i1 = this.d;
      for (int i2 = 1; getItemHeight() * i2 < getHeight(); i2 += 2) {
        i1--;
      }
      i4 = i2;
      i3 = i1;
      if (this.o != 0)
      {
        i3 = i1;
        if (this.o > 0) {
          i3 = i1 - 1;
        }
        i1 = this.o / getItemHeight();
        i3 -= i1;
        i4 = (int)(i2 + 1 + Math.asin(i1));
      }
    }
  }
  
  private void h()
  {
    if (this.p != null) {
      this.s.a(this.p, this.q, new c());
    }
    for (;;)
    {
      int i2 = this.e / 2;
      for (int i1 = this.d + i2; i1 >= this.d - i2; i1--) {
        if (b(i1, true)) {
          this.q = i1;
        }
      }
      g();
    }
  }
  
  protected void a()
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext()) {
      ((OnWheelScrollListener)localIterator.next()).onScrollingStarted(this);
    }
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext()) {
      ((OnWheelClickedListener)localIterator.next()).onItemClicked(this, paramInt);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext()) {
      ((OnWheelChangedListener)localIterator.next()).onChanged(this, paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.r == null) || (this.r.getItemsCount() == 0)) {}
    int i2;
    int i1;
    do
    {
      do
      {
        return;
        i2 = this.r.getItemsCount();
        if (paramInt >= 0)
        {
          i1 = paramInt;
          if (paramInt < i2) {
            break;
          }
        }
      } while (!this.a);
      while (paramInt < 0) {
        paramInt += i2;
      }
      i1 = paramInt % i2;
    } while (i1 == this.d);
    if (paramBoolean)
    {
      paramInt = i1 - this.d;
      if (!this.a) {
        break label174;
      }
      i1 = i2 + Math.min(i1, this.d) - Math.max(i1, this.d);
      if (i1 >= Math.abs(paramInt)) {
        break label174;
      }
      if (paramInt < 0) {
        paramInt = i1;
      }
    }
    label174:
    for (;;)
    {
      b(paramInt, 0);
      break;
      paramInt = -i1;
      continue;
      this.o = 0;
      paramInt = this.d;
      this.d = i1;
      a(paramInt, this.d);
      invalidate();
      break;
    }
  }
  
  public void a(OnWheelScrollListener paramOnWheelScrollListener)
  {
    this.u.add(paramOnWheelScrollListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.s.c();
      if (this.p != null) {
        this.p.removeAllViews();
      }
      this.o = 0;
    }
    for (;;)
    {
      invalidate();
      return;
      if (this.p != null) {
        this.s.a(this.p, this.q, new c());
      }
    }
  }
  
  protected void b()
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext()) {
      ((OnWheelScrollListener)localIterator.next()).onScrollingFinished(this);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i2 = getItemHeight();
    int i1 = this.o;
    this.m.a(i2 * paramInt1 - i1, paramInt2);
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public int getCurrentItem()
  {
    return this.d;
  }
  
  public WheelViewAdapter getViewAdapter()
  {
    return this.r;
  }
  
  public int getVisibleItems()
  {
    return this.e;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.r != null) && (this.r.getItemsCount() > 0))
    {
      f();
      b(paramCanvas);
      c(paramCanvas);
    }
    if (this.l) {
      a(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    d(paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    h();
    i2 = c(i3, i2);
    if (i1 == 1073741824) {}
    for (;;)
    {
      setMeasuredDimension(i2, paramInt1);
      return;
      paramInt2 = a(this.p);
      if (i1 == Integer.MIN_VALUE) {
        paramInt1 = Math.min(paramInt2, paramInt1);
      } else {
        paramInt1 = paramInt2;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (isEnabled())
    {
      if (getViewAdapter() == null) {
        bool1 = bool2;
      }
    }
    else {
      return bool1;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        bool1 = this.m.a(paramMotionEvent);
        break;
        if (getParent() != null) {
          getParent().requestDisallowInterceptTouchEvent(true);
        }
      }
    } while (this.n);
    int i1 = (int)paramMotionEvent.getY() - getHeight() / 2;
    if (i1 > 0) {
      i1 += getItemHeight() / 2;
    }
    for (;;)
    {
      i1 /= getItemHeight();
      if ((i1 == 0) || (!c(this.d + i1))) {
        break;
      }
      a(i1 + this.d);
      break;
      i1 -= getItemHeight() / 2;
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void setCyclic(boolean paramBoolean)
  {
    this.a = paramBoolean;
    a(false);
  }
  
  public void setDrawShadows(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.m.a(paramInterpolator);
  }
  
  public void setViewAdapter(WheelViewAdapter paramWheelViewAdapter)
  {
    if (this.r != null) {
      this.r.unregisterDataSetObserver(this.w);
    }
    this.r = paramWheelViewAdapter;
    if (this.r != null) {
      this.r.registerDataSetObserver(this.w);
    }
    a(true);
  }
  
  public void setVisibleItems(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setWheelBackground(int paramInt)
  {
    this.h = paramInt;
    setBackgroundResource(this.h);
  }
  
  public void setWheelForeground(int paramInt)
  {
    this.i = paramInt;
    this.g = getContext().getResources().getDrawable(this.i);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/wheel/WPWheelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */