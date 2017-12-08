package com.lantern.wifitools.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class d
  implements ValueAnimator.AnimatorUpdateListener
{
  d(CustomTextView paramCustomTextView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    CustomTextView.a(this.a, Integer.parseInt(paramValueAnimator.getAnimatedValue().toString()));
    this.a.setText(paramValueAnimator.getAnimatedValue().toString());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */