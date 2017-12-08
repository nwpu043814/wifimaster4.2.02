package com.bluefay.material;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class k
  implements Animation.AnimationListener
{
  k(i parami, i.b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.a.c();
    this.a.l();
    this.a.a(false);
    i.b(this.b).startAnimation(i.a(this.b));
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */