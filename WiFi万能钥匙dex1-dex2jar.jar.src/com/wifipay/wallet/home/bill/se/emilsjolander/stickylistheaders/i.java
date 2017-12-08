package com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.wifipay.R.color;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.wallet.home.bill.CustomView;
import com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders.views.OnRefreshListener;

public class i
  extends ListView
{
  private static final Interpolator i = new LinearInterpolator();
  private LayoutInflater a;
  private LinearLayout b;
  private CustomView c;
  private LinearLayout d;
  private int e;
  private RotateAnimation f;
  private RotateAnimation g;
  private RotateAnimation h;
  private final float j = 2.0F;
  private final int k = 50;
  private float l;
  private float m;
  private int n;
  private int o;
  private boolean p;
  private float q = 0.0F;
  private boolean r;
  private OnRefreshListener s;
  private boolean t;
  
  public i(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setCacheColorHint(paramContext.getResources().getColor(R.color.wifipay_transparent));
    this.a = LayoutInflater.from(paramContext);
    this.b = ((LinearLayout)this.a.inflate(R.layout.wifipay_home_bill_main_header, null));
    this.d = ((LinearLayout)this.b.findViewById(R.id.wifipay_stick_pull_refresh_layout));
    this.c = ((CustomView)this.b.findViewById(R.id.wifipay_stick_pull_refresh_img));
    this.c.setMinimumWidth(50);
    this.c.setMinimumHeight(40);
    a(this.b);
    this.e = this.b.getMeasuredHeight();
    this.b.setPadding(0, this.e * -1, 0, 0);
    this.b.invalidate();
    addHeaderView(this.b, null, false);
    this.f = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.f.setInterpolator(i);
    this.f.setDuration(250L);
    this.f.setFillAfter(true);
    this.g = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.g.setInterpolator(i);
    this.g.setDuration(200L);
    this.g.setFillAfter(true);
    this.h = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.h.setInterpolator(i);
    this.h.setDuration(800L);
    this.h.setRepeatCount(-1);
    this.h.setRepeatMode(1);
    this.o = 3;
    this.t = false;
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int i2 = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams1.width);
    int i1 = localLayoutParams1.height;
    if (i1 > 0) {}
    for (i1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);; i1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i2, i1);
      return;
    }
  }
  
  private void b()
  {
    int i1 = Math.round(Math.min(this.m - this.l, 0.0F) / 2.0F);
    int i2 = this.d.getHeight();
    this.q = (Math.abs(i1 + 50) / i2);
    this.c.setPullScale(this.q);
  }
  
  private void c()
  {
    switch (this.o)
    {
    }
    for (;;)
    {
      return;
      this.c.setVisibility(0);
      this.c.clearAnimation();
      this.c.startAnimation(this.f);
      continue;
      this.c.clearAnimation();
      this.c.setVisibility(0);
      if (this.p)
      {
        this.p = false;
        this.c.clearAnimation();
        this.c.startAnimation(this.g);
        continue;
        this.b.setPadding(0, 0, 0, 0);
        this.c.clearAnimation();
        this.c.startAnimation(this.h);
        continue;
        this.c.setPullScale(0.0F);
        this.c.clearAnimation();
        this.b.setPadding(0, this.e * -1, 0, 0);
      }
    }
  }
  
  private void d()
  {
    if (this.s != null) {
      this.s.onRefresh();
    }
  }
  
  public void a()
  {
    this.o = 3;
    c();
  }
  
  public int getState()
  {
    return this.o;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.t) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    int i1;
    do
    {
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        if (!this.r)
        {
          this.r = true;
          float f1 = paramMotionEvent.getY();
          this.m = f1;
          this.l = f1;
          this.n = ((int)this.l);
          continue;
          if (this.o != 2)
          {
            if (this.o == 1)
            {
              this.o = 3;
              c();
            }
            if (this.o == 0)
            {
              this.o = 2;
              c();
              d();
            }
          }
          this.r = false;
          this.p = false;
        }
      }
      i1 = (int)paramMotionEvent.getY();
      if (!this.r)
      {
        this.r = true;
        this.n = i1;
      }
      this.l = paramMotionEvent.getY();
      b();
    } while ((this.o == 2) || (!this.r));
    if (this.o == 0)
    {
      setSelection(0);
      if (((i1 - this.n) / 3 < this.e) && (i1 - this.n > 0))
      {
        this.o = 1;
        c();
      }
    }
    else
    {
      label234:
      if (this.o == 1)
      {
        setSelection(0);
        if ((i1 - this.n) / 3 < this.e) {
          break label389;
        }
        this.o = 0;
        this.p = true;
        c();
      }
    }
    for (;;)
    {
      if ((this.o == 3) && (i1 - this.n > 0))
      {
        this.o = 1;
        c();
      }
      if (this.o == 1) {
        this.b.setPadding(0, this.e * -1 + (i1 - this.n) / 3, 0, 0);
      }
      if (this.o != 0) {
        break;
      }
      this.b.setPadding(0, (i1 - this.n) / 3 - this.e, 0, 0);
      break;
      if (i1 - this.n > 0) {
        break label234;
      }
      this.o = 3;
      c();
      break label234;
      label389:
      if (i1 - this.n <= 0)
      {
        this.o = 3;
        c();
      }
    }
  }
  
  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener)
  {
    this.s = paramOnRefreshListener;
    this.t = true;
  }
  
  public void setRefreshable(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/se/emilsjolander/stickylistheaders/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */