package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class q
  implements Animation.AnimationListener
{
  q(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (SwipeRefreshLayout.a(this.a))
    {
      SwipeRefreshLayout.b(this.a).setAlpha(255);
      SwipeRefreshLayout.b(this.a).start();
      if ((SwipeRefreshLayout.c(this.a)) && (SwipeRefreshLayout.d(this.a) != null)) {
        SwipeRefreshLayout.d(this.a).a();
      }
    }
    for (;;)
    {
      SwipeRefreshLayout.a(this.a, SwipeRefreshLayout.e(this.a).getTop());
      return;
      SwipeRefreshLayout.b(this.a).stop();
      SwipeRefreshLayout.e(this.a).setVisibility(8);
      SwipeRefreshLayout.f(this.a);
      if (SwipeRefreshLayout.g(this.a)) {
        SwipeRefreshLayout.a(this.a, 0.0F);
      } else {
        SwipeRefreshLayout.a(this.a, this.a.b - SwipeRefreshLayout.h(this.a), true);
      }
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */