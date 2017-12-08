package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class v
  extends Animation
{
  v(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (!SwipeRefreshLayout.j(this.a)) {}
    for (int i = (int)(SwipeRefreshLayout.k(this.a) - Math.abs(this.a.b));; i = (int)SwipeRefreshLayout.k(this.a))
    {
      int j = this.a.a;
      i = (int)((i - this.a.a) * paramFloat);
      int k = SwipeRefreshLayout.e(this.a).getTop();
      SwipeRefreshLayout.a(this.a, i + j - k, false);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */