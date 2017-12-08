package com.lantern.browser.comment.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.bluefay.a.e;
import com.lantern.analytics.a;
import com.lantern.core.p;

final class d
  implements View.OnClickListener
{
  d(b paramb) {}
  
  public final void onClick(View paramView)
  {
    if (!p.a()) {}
    for (;;)
    {
      return;
      a.e().onEvent("cmtpficli");
      paramView = this.a.getContext();
      Intent localIntent = new Intent("wifi.intent.action.SETTINGS_USER_INFO");
      localIntent.setPackage(paramView.getPackageName());
      localIntent.putExtra("from", 2);
      e.a(paramView, localIntent);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */