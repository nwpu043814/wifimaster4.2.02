package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.bluefay.b.a;

final class d
  implements Animation.AnimationListener
{
  d(MaterialProgressBarNew paramMaterialProgressBarNew) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    MaterialProgressBarNew.a(this.a).stop();
    MaterialProgressBarNew.b(this.a).setVisibility(8);
    MaterialProgressBarNew.c(this.a);
    MaterialProgressBarNew.a(this.a, 0.0F);
    this.a.setVisibility(8);
    if (MaterialProgressBarNew.d(this.a) != null) {
      MaterialProgressBarNew.d(this.a).a(1, "onAnimationEnd", null);
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */