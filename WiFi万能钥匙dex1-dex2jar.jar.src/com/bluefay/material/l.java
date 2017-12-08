package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

final class l
  extends Animation
{
  l(i parami, i.b paramb) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f4 = (float)Math.toRadians(this.a.e() / (6.283185307179586D * this.a.j()));
    float f3 = this.a.h();
    float f1 = this.a.g();
    float f2 = this.a.k();
    float f5 = i.c().getInterpolation(paramFloat);
    this.a.c((0.8F - f4) * f5 + f3);
    f3 = i.d().getInterpolation(paramFloat);
    this.a.b(f3 * 0.8F + f1);
    this.a.d(0.25F * paramFloat + f2);
    f1 = i.c(this.b) / 5.0F;
    this.b.d(144.0F * paramFloat + 720.0F * f1);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */