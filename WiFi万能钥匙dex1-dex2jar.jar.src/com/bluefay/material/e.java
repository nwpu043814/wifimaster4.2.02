package com.bluefay.material;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class e
  extends Animation
{
  e(MaterialProgressBarNew paramMaterialProgressBarNew) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    MaterialProgressBarNew.a(this.a, 1.0F - paramFloat);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */