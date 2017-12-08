package com.bluefay.material;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

public class MaterialProgressBar
  extends LinearLayout
{
  private b a;
  private i b;
  private Animation.AnimationListener c = new c(this);
  
  public MaterialProgressBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MaterialProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public MaterialProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new b(getContext());
    this.b = new i(getContext(), this.a);
    this.b.a();
    this.a.setImageDrawable(this.b);
    addView(this.a);
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0)
    {
      super.setVisibility(0);
      this.b.setAlpha(255);
      this.b.start();
    }
    for (;;)
    {
      return;
      super.setVisibility(8);
      this.b.setAlpha(0);
      this.b.stop();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/MaterialProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */