package com.lantern.browser.comment.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Handler;
import com.lantern.core.c;

final class h
  implements DialogInterface.OnClickListener
{
  h(e parame, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.d(this.b.a, this.a);
    if (a.k(this.b.a) == null) {
      a.a(this.b.a, new i(this, new int[] { 128202 }));
    }
    c.addListener(a.k(this.b.a));
    paramDialogInterface = new Intent("wifi.intent.action.ADD_ACCOUNT_MAIN");
    paramDialogInterface.addFlags(268435456);
    paramDialogInterface.setPackage(c.getAppContext().getPackageName());
    paramDialogInterface.putExtra("fromSource", "news_comment");
    c.getAppContext().startActivity(paramDialogInterface);
    a.m(this.b.a).postDelayed(new j(this), 300L);
    com.lantern.analytics.a.e().onEvent("cmtskip");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */