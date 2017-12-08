package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class j
  extends Animation
{
  j(i parami, i.b paramb) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = (float)(Math.floor(this.a.k() / 0.8F) + 1.0D);
    float f3 = this.a.g();
    float f4 = this.a.h();
    float f2 = this.a.g();
    this.a.b(f3 + (f4 - f2) * paramFloat);
    f2 = this.a.k();
    f3 = this.a.k();
    this.a.d((f1 - f3) * paramFloat + f2);
    this.a.e(1.0F - paramFloat);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */