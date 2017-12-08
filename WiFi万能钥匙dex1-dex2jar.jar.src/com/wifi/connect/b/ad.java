package com.wifi.connect.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bluefay.b.a;
import com.bluefay.b.h;
import com.bluefay.d.b;
import com.lantern.core.c;
import com.lantern.core.g.u;

public final class ad
{
  public static boolean a = false;
  private Context b;
  private final int c = 138000;
  private final int d = 138001;
  private final int[] e = { 128005, 128201, 128200 };
  private a f = new ae(this);
  private b g = new af(this, this.e);
  
  public ad(Context paramContext)
  {
    this.b = paramContext;
    c.addListener(this.g);
    h.a("StickyManager onCreate");
  }
  
  public final void a()
  {
    h.a("StickyManager onTerminate");
    c.removeListener(this.g);
  }
  
  public final void a(String paramString)
  {
    String str = paramString;
    if (!u.c(paramString)) {
      if ((paramString == null) || (paramString.length() <= 0)) {}
    }
    for (;;)
    {
      return;
      paramString = ((WifiManager)this.b.getSystemService("wifi")).getConnectionInfo();
      h.a("info:" + paramString);
      if ((paramString != null) && (paramString.getSSID() != null))
      {
        str = u.a(paramString.getSSID());
        if ((str != null) && (str.length() != 0))
        {
          paramString = this.g.obtainMessage(138001, 1, 0, str);
          if (this.g.hasMessages(138001)) {
            this.g.removeMessages(138001);
          }
          this.g.sendMessageDelayed(paramString, 1000L);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */