package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class m
  implements Animation.AnimationListener
{
  m(i parami, i.b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation) {}
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    this.a.l();
    this.a.c();
    this.a.b(this.a.i());
    i.a(this.b, (i.c(this.b) + 1.0F) % 5.0F);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    i.a(this.b, 0.0F);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */