package com.lantern.settings.ui;

import android.view.View;
import android.view.View.OnLongClickListener;

final class c
  implements View.OnLongClickListener
{
  c(AvatarViewFragment paramAvatarViewFragment) {}
  
  public final boolean onLongClick(View paramView)
  {
    paramView = new com.lantern.settings.widget.c(AvatarViewFragment.a(this.a));
    paramView.a(AvatarViewFragment.b(this.a));
    paramView.show();
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */