package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class h
  implements Animation.AnimationListener
{
  h(f paramf) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    f.b(this.a).stop();
    f.c(this.a).setVisibility(8);
    f.d(this.a);
    f.e(this.a);
    f.f(this.a);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */