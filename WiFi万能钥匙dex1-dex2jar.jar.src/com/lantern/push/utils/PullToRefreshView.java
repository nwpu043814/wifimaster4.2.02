package com.lantern.push.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.lantern.settings.R.anim;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;

public class PullToRefreshView
  extends LinearLayout
{
  private boolean a = true;
  private int b;
  private int c;
  private int d;
  private int e;
  private ImageView f;
  private TextView g;
  private ImageView h;
  private AdapterView<?> i;
  private LayoutInflater j;
  private View k;
  private View l;
  private View m;
  private Animation n = AnimationUtils.loadAnimation(getContext(), R.anim.settings_refresh_reverse);
  private Animation o = AnimationUtils.loadAnimation(getContext(), R.anim.settings_refresh_rotating);
  
  public PullToRefreshView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new LinearInterpolator();
    this.n.setInterpolator(paramContext);
    this.o.setInterpolator(paramContext);
    this.j = LayoutInflater.from(getContext());
    this.k = this.j.inflate(R.layout.settings_refresh_footer, this, false);
    a(this.k);
    this.d = this.k.getMeasuredHeight();
    paramContext = new LinearLayout.LayoutParams(-1, this.d);
    paramContext.topMargin = (-this.d);
    ((ImageView)this.k.findViewById(R.id.pull_to_load_image)).setVisibility(8);
    ((TextView)this.k.findViewById(R.id.pull_to_load_text)).setVisibility(8);
    addView(this.k, paramContext);
    this.l = this.j.inflate(R.layout.settings_refresh_center, this, false);
    this.l.setVisibility(8);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    addView(this.l, paramContext);
  }
  
  private void a()
  {
    int i2 = getChildCount();
    if (i2 < 3) {
      throw new IllegalArgumentException("initContentAdapterView");
    }
    for (int i1 = 0; i1 < i2 - 1; i1++)
    {
      View localView = getChildAt(i1);
      if ((localView instanceof AdapterView)) {
        this.i = ((AdapterView)localView);
      }
    }
    if (this.i == null) {
      throw new IllegalArgumentException("must be AdapterView");
    }
  }
  
  private void a(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.k.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.k.setLayoutParams(localLayoutParams);
    invalidate();
  }
  
  private static void a(View paramView)
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
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.m = this.j.inflate(R.layout.settings_refresh_footer, this, false);
    this.f = ((ImageView)this.m.findViewById(R.id.pull_to_load_image));
    this.g = ((TextView)this.m.findViewById(R.id.pull_to_load_text));
    this.h = ((ImageView)this.m.findViewById(R.id.pull_to_load_progress));
    a(this.m);
    this.e = this.m.getMeasuredHeight();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.e);
    addView(this.m, localLayoutParams);
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i1 = (int)paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    }
    label150:
    for (;;)
    {
      bool = false;
      return bool;
      this.b = i1;
      continue;
      int i2 = this.b;
      if ((this.c != 3) && (this.i != null) && (i1 - i2 < 0) && (this.a))
      {
        paramMotionEvent = this.i.getChildAt(this.i.getChildCount() - 1);
        if ((paramMotionEvent == null) || (paramMotionEvent.getBottom() > getHeight()) || (this.i.getLastVisiblePosition() != this.i.getCount() - 1)) {}
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label150;
        }
        break;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = (int)paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      int i1 = i2 - this.b;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.k.getLayoutParams();
      float f2 = localLayoutParams.topMargin;
      float f1 = i1;
      if ((i1 > 0) && (Math.abs(localLayoutParams.topMargin) <= this.d))
      {
        i1 = localLayoutParams.topMargin;
        label105:
        if ((Math.abs(i1) < this.d + this.e) || (this.c == 2)) {
          break label208;
        }
        this.g.setText(R.string.pull_to_refresh_footer_release_label);
        this.f.clearAnimation();
        this.f.startAnimation(this.n);
        this.c = 2;
      }
      for (;;)
      {
        this.b = i2;
        break;
        localLayoutParams.topMargin = ((int)(f2 + f1 * 0.4F));
        this.k.setLayoutParams(localLayoutParams);
        invalidate();
        i1 = localLayoutParams.topMargin;
        break label105;
        label208:
        if (Math.abs(i1) < this.d + this.e)
        {
          this.f.clearAnimation();
          this.f.startAnimation(this.n);
          this.g.setText(R.string.pull_to_refresh_footer_pull_label);
          this.c = 1;
        }
      }
      if (Math.abs(((LinearLayout.LayoutParams)this.k.getLayoutParams()).topMargin) >= this.d + this.e)
      {
        this.c = 3;
        a(-(this.d + this.e));
        this.f.setVisibility(8);
        this.f.clearAnimation();
        this.f.setImageDrawable(null);
        this.h.setVisibility(0);
        this.h.startAnimation(this.o);
        this.g.setText(R.string.pull_to_refresh_footer_refreshing_label);
      }
      else
      {
        a(-this.d);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/utils/PullToRefreshView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */