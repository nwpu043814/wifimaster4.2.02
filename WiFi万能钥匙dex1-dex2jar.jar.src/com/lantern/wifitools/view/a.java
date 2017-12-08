package com.lantern.wifitools.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class a
  implements ValueAnimator.AnimatorUpdateListener
{
  a(AnimTextView paramAnimTextView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AnimTextView.a(this.a, Float.parseFloat(paramValueAnimator.getAnimatedValue().toString()));
    this.a.setAlpha(AnimTextView.a(this.a));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */