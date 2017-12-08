package com.bluefay.material;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.bluefay.b.a;

public class MaterialProgressBarNew
  extends LinearLayout
{
  private ae a;
  private i b;
  private Animation c;
  private a d;
  private Animation.AnimationListener e = new d(this);
  
  public MaterialProgressBarNew(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MaterialProgressBarNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public MaterialProgressBarNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new ae(getContext());
    this.b = new i(getContext(), this.a);
    this.b.a();
    this.a.setImageDrawable(this.b);
    addView(this.a);
  }
  
  private void a(int paramInt)
  {
    this.b.setAlpha(paramInt);
  }
  
  public final void a(a parama)
  {
    this.d = parama;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b.setAlpha(255);
      this.b.start();
    }
    for (;;)
    {
      return;
      Animation.AnimationListener localAnimationListener = this.e;
      this.c = new e(this);
      this.c.setDuration(150L);
      this.a.a(localAnimationListener);
      this.a.clearAnimation();
      this.a.startAnimation(this.c);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/MaterialProgressBarNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */