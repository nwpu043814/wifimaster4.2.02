package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class u
  implements Animation.AnimationListener
{
  u(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (!SwipeRefreshLayout.g(this.a)) {
      SwipeRefreshLayout.i(this.a);
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */