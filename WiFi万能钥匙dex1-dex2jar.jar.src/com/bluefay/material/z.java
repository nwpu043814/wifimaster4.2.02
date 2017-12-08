package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class z
  extends Animation
{
  z(SwipeRefreshLayoutL paramSwipeRefreshLayoutL) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = SwipeRefreshLayoutL.d(this.a);
    float f2 = SwipeRefreshLayoutL.d(this.a);
    SwipeRefreshLayoutL.e(this.a).a(f1 + (0.0F - f2) * paramFloat);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */