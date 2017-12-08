package com.linksure.apservice.ui.common.search;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ProgressBar;

final class q
  implements ValueAnimator.AnimatorUpdateListener
{
  q(o paramo, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f2 = paramValueAnimator.getAnimatedFraction();
    int i = this.a;
    paramValueAnimator = o.a(this.b);
    float f1 = this.a;
    paramValueAnimator.setProgress((int)(f2 * (100 - i) + f1));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/search/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */