package com.bluefay.material;

import android.view.animation.Animation;

final class ad
  implements Runnable
{
  ad(SwipeRefreshLayoutL paramSwipeRefreshLayoutL) {}
  
  public final void run()
  {
    SwipeRefreshLayoutL.h(this.a);
    if (SwipeRefreshLayoutL.e(this.a) != null)
    {
      SwipeRefreshLayoutL.a(this.a, SwipeRefreshLayoutL.k(this.a));
      SwipeRefreshLayoutL.m(this.a).setDuration(SwipeRefreshLayoutL.l(this.a));
      SwipeRefreshLayoutL.m(this.a).setAnimationListener(SwipeRefreshLayoutL.n(this.a));
      SwipeRefreshLayoutL.m(this.a).reset();
      SwipeRefreshLayoutL.m(this.a).setInterpolator(SwipeRefreshLayoutL.o(this.a));
      this.a.startAnimation(SwipeRefreshLayoutL.m(this.a));
    }
    SwipeRefreshLayoutL.a(this.a, SwipeRefreshLayoutL.i(this.a) + this.a.getPaddingTop(), SwipeRefreshLayoutL.j(this.a));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */