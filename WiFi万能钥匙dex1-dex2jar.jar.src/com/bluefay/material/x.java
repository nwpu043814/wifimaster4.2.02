package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class x
  extends Animation
{
  x(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = SwipeRefreshLayout.l(this.a);
    float f2 = -SwipeRefreshLayout.l(this.a);
    SwipeRefreshLayout.a(this.a, f1 + f2 * paramFloat);
    SwipeRefreshLayout.b(this.a, paramFloat);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */