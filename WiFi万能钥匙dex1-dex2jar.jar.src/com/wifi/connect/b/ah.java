package com.wifi.connect.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.bluefay.b.a;
import com.bluefay.d.b;
import com.lantern.core.c;

public final class ah
{
  private final int[] a = { 128001 };
  private b b = new ai(this, this.a);
  private WifiManager c;
  private a d;
  
  public ah(Context paramContext, a parama)
  {
    this.d = parama;
    this.c = ((WifiManager)paramContext.getSystemService("wifi"));
  }
  
  public final void a()
  {
    c.addListener(this.b);
  }
  
  public final boolean a(boolean paramBoolean)
  {
    return this.c.setWifiEnabled(paramBoolean);
  }
  
  public final void b()
  {
    c.removeListener(this.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */