package com.wifi.connect.ui;

import com.bluefay.b.a;
import com.lantern.connect.R.string;

final class t
  implements a
{
  t(ConnectFragment paramConnectFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (((paramObject instanceof com.lantern.core.model.e)) && (((com.lantern.core.model.e)paramObject).c())) {
      com.bluefay.a.e.a(R.string.act_wifilist_toast_report_phishing_succeeded);
    }
    for (;;)
    {
      return;
      com.bluefay.a.e.a(R.string.act_wifilist_toast_report_phishing_failed);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */