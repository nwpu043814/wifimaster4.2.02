package com.bluefay.material;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class y
  extends Animation
{
  y(SwipeRefreshLayoutL paramSwipeRefreshLayoutL) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = 0;
    if (SwipeRefreshLayoutL.a(this.a) != SwipeRefreshLayoutL.b(this.a)) {
      i = SwipeRefreshLayoutL.a(this.a) + (int)((SwipeRefreshLayoutL.b(this.a) - SwipeRefreshLayoutL.a(this.a)) * paramFloat);
    }
    int j = i - SwipeRefreshLayoutL.c(this.a).getTop();
    int k = SwipeRefreshLayoutL.c(this.a).getTop();
    i = j;
    if (j + k < 0) {
      i = 0 - k;
    }
    SwipeRefreshLayoutL.a(this.a, i);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */