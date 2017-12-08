package com.lantern.wifitools.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import com.bluefay.b.h;

public final class g
  extends Handler
{
  private static g e;
  private Context a;
  private int b = 0;
  private int c = 10000;
  private WifiManager d;
  
  private g(Context paramContext)
  {
    this.a = paramContext;
    this.d = ((WifiManager)this.a.getSystemService("wifi"));
  }
  
  public static g a(Context paramContext)
  {
    if (e == null) {
      e = new g(paramContext);
    }
    return e;
  }
  
  public final void a()
  {
    if (!hasMessages(0)) {
      sendEmptyMessage(0);
    }
  }
  
  public final void b()
  {
    this.b = 0;
    removeMessages(0);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    h.a("handleMessage:startScan", new Object[0]);
    if (this.d.startScan())
    {
      this.b = 0;
      sendEmptyMessageDelayed(0, this.c);
    }
    for (;;)
    {
      return;
      int i = this.b + 1;
      this.b = i;
      if (i < 3) {
        break;
      }
      this.b = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */