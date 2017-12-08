package com.lantern.browser.comment.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

final class ah
  implements Animation.AnimationListener
{
  ah(WkCommentLikeButton paramWkCommentLikeButton) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    WkCommentLikeButton.a(this.a).setVisibility(4);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    WkCommentLikeButton.a(this.a).setVisibility(0);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */