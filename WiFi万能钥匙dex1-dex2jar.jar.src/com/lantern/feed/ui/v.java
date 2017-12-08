package com.lantern.feed.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.lantern.feed.a.m;

final class v
  extends AnimatorListenerAdapter
{
  v(WkFeedFragment paramWkFeedFragment) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    WkFeedFragment.k(this.a).setEnabled(true);
    m.a().k();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */