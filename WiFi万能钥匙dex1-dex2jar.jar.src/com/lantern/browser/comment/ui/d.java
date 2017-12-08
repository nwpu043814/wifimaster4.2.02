package com.lantern.browser.comment.ui;

import android.widget.ImageView;
import com.lantern.core.imageloader.b;

final class d
  implements b
{
  d(WkCommentAvatarView paramWkCommentAvatarView) {}
  
  public final void a()
  {
    WkCommentAvatarView.a(this.a, 1);
  }
  
  public final void b()
  {
    WkCommentAvatarView.a(this.a, -1);
    WkCommentAvatarView.a(this.a).setImageDrawable(null);
    WkCommentAvatarView.a(this.a).setBackgroundResource(WkCommentAvatarView.b(this.a));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */