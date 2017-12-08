package com.wifi.backup.c;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private List<com.wifi.backup.c.a.a> b;
  private Context c;
  private WifiManager d;
  
  public c(Context paramContext, WifiManager paramWifiManager, com.bluefay.b.a parama)
  {
    this.a = parama;
    this.b = new ArrayList();
    this.c = paramContext;
    this.d = paramWifiManager;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */