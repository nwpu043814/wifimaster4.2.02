package com.linksure.apservice.ui.common.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ProgressBar;

final class r
  extends AnimatorListenerAdapter
{
  r(o paramo) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    o.a(this.a).setProgress(0);
    o.a(this.a).setVisibility(8);
    o.b(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/search/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */