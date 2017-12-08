package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class s
  extends Animation
{
  s(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    SwipeRefreshLayout.a(this.a, 1.0F - paramFloat);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */