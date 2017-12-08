package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class t
  extends Animation
{
  t(SwipeRefreshLayout paramSwipeRefreshLayout, int paramInt1, int paramInt2) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    SwipeRefreshLayout.b(this.c).setAlpha((int)(this.a + (this.b - this.a) * paramFloat));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */