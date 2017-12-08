package com.lantern.feed.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;

final class u
  extends AnimatorListenerAdapter
{
  u(WkFeedFragment paramWkFeedFragment, a parama1, a parama2) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.setVisibility(4);
    this.b.setVisibility(0);
    WkFeedFragment.l(this.c).setRotationX(90.0F);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    WkFeedFragment.k(this.c).setEnabled(false);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */