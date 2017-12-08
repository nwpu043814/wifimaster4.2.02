package com.lantern.browser.comment.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.lantern.browser.R.drawable;

final class ai
  implements Animation.AnimationListener
{
  ai(WkCommentLikeButton paramWkCommentLikeButton) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    WkCommentLikeButton.b(this.a).setImageResource(R.drawable.browser_comment_zan_on);
    WkCommentLikeButton.b(this.a).startAnimation(WkCommentLikeButton.c(this.a));
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */