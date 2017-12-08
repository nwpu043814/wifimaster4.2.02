package com.lantern.e.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.lantern.wifiseccheck.LogUtils;

final class i
  implements Animator.AnimatorListener
{
  i(b paramb) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    LogUtils.d("HomeSdkAct", "fadeOutOnVpnClose onAnimationEnd");
    b.k(this.a);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/e/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */