package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class c
  implements Animation.AnimationListener
{
  c(MaterialProgressBar paramMaterialProgressBar) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    MaterialProgressBar.a(this.a).stop();
    MaterialProgressBar.b(this.a);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */