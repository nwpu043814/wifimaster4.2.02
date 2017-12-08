package com.lantern.browser.comment.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.bluefay.a.e;
import com.lantern.analytics.a;
import com.lantern.core.p;

final class at
  implements View.OnClickListener
{
  at(WkCommentToolBar paramWkCommentToolBar) {}
  
  public final void onClick(View paramView)
  {
    if (!p.a()) {}
    for (;;)
    {
      return;
      paramView = new Intent("wifi.intent.action.SETTINGS_USER_INFO");
      paramView.setPackage(WkCommentToolBar.a(this.a).getPackageName());
      paramView.putExtra("from", 1);
      e.a(WkCommentToolBar.a(this.a), paramView);
      a.e().onEvent("cmtavtcli");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */