package com.wifi.connect.e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;
import com.wifi.connect.model.h.a;

final class e
  implements View.OnClickListener
{
  e(c paramc) {}
  
  public final void onClick(View paramView)
  {
    if ((c.b(this.a) == null) || (TextUtils.isEmpty(c.b(this.a).e))) {}
    for (;;)
    {
      return;
      if ((c.c(this.a) == null) || (c.c(this.a).getVisibility() != 0))
      {
        paramView = new Intent("wifi.intent.action.BROWSER");
        paramView.setPackage(c.a(this.a).getPackageName());
        paramView.setData(Uri.parse(c.b(this.a).e));
        paramView.addFlags(268435456);
        c.a(this.a).startActivity(paramView);
        a.e().onEvent("barcli_" + c.b(this.a).a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */