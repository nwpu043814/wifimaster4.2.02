package com.lantern.feed.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout.LayoutParams;

final class w
  implements ValueAnimator.AnimatorUpdateListener
{
  w(WkFeedFragment paramWkFeedFragment, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = (FrameLayout.LayoutParams)WkFeedFragment.k(this.b).getLayoutParams();
    int i = (int)(f * this.a);
    if (i != paramValueAnimator.topMargin)
    {
      paramValueAnimator.topMargin = i;
      WkFeedFragment.k(this.b).requestLayout();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */