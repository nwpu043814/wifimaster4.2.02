package com.lantern.favorite.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bluefay.a.e;
import com.lantern.favorite.R.anim;
import com.lantern.favorite.R.id;
import com.lantern.favorite.R.string;

public class PullToRefreshLayout
  extends FrameLayout
{
  private float a = 0.0F;
  private float b = 2.0F;
  private int c = 100;
  private int d = 0;
  private int e = b.a;
  private boolean f = false;
  private boolean g = true;
  private View h;
  private View i;
  private TextView j;
  private WkListView k;
  private RotateAnimation l;
  private RotateAnimation m;
  private Handler n = new h(this, Looper.getMainLooper());
  private a o;
  
  public PullToRefreshLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PullToRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PullToRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.l = ((RotateAnimation)AnimationUtils.loadAnimation(paramContext, R.anim.fav_rev_anim));
    this.m = ((RotateAnimation)AnimationUtils.loadAnimation(paramContext, R.anim.fav_rot_anim));
    paramContext = new LinearInterpolator();
    this.l.setInterpolator(paramContext);
    this.m.setInterpolator(paramContext);
  }
  
  private void b(int paramInt)
  {
    this.e = paramInt;
    switch (1.a[(this.e - 1)])
    {
    }
    for (;;)
    {
      return;
      this.j.setText(getContext().getString(R.string.pullup_to_load));
      this.h.clearAnimation();
      this.h.setVisibility(0);
      continue;
      this.j.setText(getContext().getString(R.string.release_to_load));
      this.h.startAnimation(this.l);
      continue;
      this.h.clearAnimation();
      this.h.setVisibility(8);
      this.j.setText(getContext().getString(R.string.loading));
    }
  }
  
  public final void a()
  {
    this.d = 0;
    b(b.a);
    requestLayout();
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 0) {
      this.i.setVisibility(0);
    }
    for (;;)
    {
      return;
      this.i.setVisibility(8);
    }
  }
  
  public final void a(a parama)
  {
    this.o = parama;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 1;
    switch (paramMotionEvent.getActionMasked())
    {
    }
    label371:
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.a = paramMotionEvent.getY();
      continue;
      if (-this.d > this.c) {
        this.f = false;
      }
      if (this.e == b.b)
      {
        b(b.c);
        this.o.e_();
      }
      this.n.sendEmptyMessage(0);
      continue;
      if (paramMotionEvent.getPointerCount() == 1)
      {
        WkListView localWkListView = this.k;
        if ((localWkListView.getCount() != 0) && (localWkListView.getLastVisiblePosition() == localWkListView.getCount() - 1) && (localWkListView.getChildAt(localWkListView.getLastVisiblePosition() - localWkListView.getFirstVisiblePosition()) != null) && (localWkListView.getChildAt(localWkListView.getLastVisiblePosition() - localWkListView.getFirstVisiblePosition()).getBottom() <= localWkListView.getMeasuredHeight())) {}
        for (;;)
        {
          if ((i1 == 0) || (!this.g)) {
            break label371;
          }
          this.d += (int)((paramMotionEvent.getY() - this.a) / this.b);
          if (this.d > 0) {
            this.d = 0;
          }
          if (this.d < -getMeasuredHeight()) {
            this.d = (-getMeasuredHeight());
          }
          this.a = paramMotionEvent.getY();
          this.b = ((float)(Math.tan(1.5707963267948966D / getMeasuredHeight() * Math.abs(this.d)) * 2.0D + 2.0D));
          if ((-this.d >= this.c) && (this.e == b.a)) {
            b(b.b);
          }
          if ((-this.d <= this.c) && (this.e == b.b)) {
            b(b.a);
          }
          if (Math.abs(this.d) > 8) {
            paramMotionEvent.setAction(3);
          }
          requestLayout();
          break;
          i1 = 0;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      this.i = getChildAt(0);
      paramInt1 = this.i.getMeasuredWidth();
      paramInt2 = this.i.getMeasuredHeight();
      paramInt3 = (paramInt3 - paramInt1) / 2;
      paramInt4 = (paramInt4 - paramInt2) / 2;
      this.i.layout(paramInt3, paramInt4 - e.a(getContext(), 35.0F), paramInt1 + paramInt3, paramInt2 + paramInt4);
      this.k = ((WkListView)getChildAt(1));
      this.k.layout(0, this.d, this.k.getMeasuredWidth(), this.d + this.k.getMeasuredHeight());
      ViewGroup localViewGroup = (ViewGroup)getChildAt(2);
      this.h = localViewGroup.findViewById(R.id.pullup_icon);
      this.j = ((TextView)localViewGroup.findViewById(R.id.loadstate_tv));
      this.c = localViewGroup.getChildAt(0).getMeasuredHeight();
      paramInt3 = this.d;
      paramInt2 = this.k.getMeasuredHeight();
      paramInt1 = localViewGroup.getMeasuredHeight();
      localViewGroup.layout(0, this.d + this.k.getMeasuredHeight(), localViewGroup.getMeasuredWidth(), paramInt3 + paramInt2 + paramInt1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void e_();
  }
  
  private static enum b
  {
    public static int[] a()
    {
      return (int[])d.clone();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/widget/PullToRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */