package com.wifi.connect.plugin.ssrp.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.util.Base64;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.g.r;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import com.wifi.connect.plugin.ssrp.R.string;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static a h;
  private Context a;
  private String b = "123456";
  private r c;
  private boolean d;
  private WifiConfiguration e;
  private WkAccessPoint f;
  private com.bluefay.b.a g;
  private int i;
  private String j;
  private String k;
  private n l;
  private com.bluefay.b.a m = new b(this);
  
  private a(Context paramContext)
  {
    this.a = paramContext;
    if (this.c == null) {
      this.c = new r(this.a);
    }
  }
  
  public static a a(Context paramContext)
  {
    if (h == null) {
      h = new a(paramContext);
    }
    return h;
  }
  
  private String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("v", String.valueOf(this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode));
      try
      {
        String str1 = c.getServer().r();
        localJSONObject.put("k", "1.1");
        localJSONObject.put("d", this.k);
        localJSONObject.put("t", System.currentTimeMillis());
        if (str1 == null) {
          break label141;
        }
        localJSONObject.put("m", str1);
        localJSONObject.put("r", paramString);
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          String str2;
          h.a(paramString);
        }
      }
      paramString = localJSONObject.toString();
      h.a("ssrp" + paramString, new Object[0]);
      return Base64.encodeToString(paramString.getBytes(), 2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        continue;
        label141:
        str2 = "";
      }
    }
  }
  
  private void a(r paramr, WkAccessPoint paramWkAccessPoint)
  {
    String str = paramWkAccessPoint.a;
    h.a("ssrp ssid = " + str, new Object[0]);
    Object localObject = ((WifiManager)this.a.getSystemService("wifi")).getConfiguredNetworks();
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      int n = 0;
      do
      {
        int i1;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (WifiConfiguration)localIterator.next();
          i1 = n;
          if (((WifiConfiguration)localObject).priority > n) {
            i1 = ((WifiConfiguration)localObject).priority;
          }
          n = i1;
        } while (!str.equals(u.a(((WifiConfiguration)localObject).SSID)));
        n = i1;
      } while (paramWkAccessPoint.c != u.a((WifiConfiguration)localObject));
    }
    for (;;)
    {
      this.b = a(paramWkAccessPoint.b);
      if (localObject == null) {
        this.d = true;
      }
      for (localObject = com.d.a.a.a(paramWkAccessPoint.a, "wifimasterkey", this.b);; localObject = com.d.a.a.a(paramWkAccessPoint.a, "wifimasterkey", this.b))
      {
        this.l.l = this.d;
        h.a(((WifiConfiguration)localObject).toString(), new Object[0]);
        this.e = ((WifiConfiguration)localObject);
        h.a("ssrpconnect+ssrp_start", new Object[0]);
        paramr.a(paramWkAccessPoint, this.d, this.e, this.m);
        return;
        this.d = false;
      }
      localObject = null;
    }
  }
  
  private int c()
  {
    try
    {
      Object localObject1 = ((WifiManager)this.a.getSystemService("wifi")).getScanResults();
      if (localObject1 != null)
      {
        Iterator localIterator = ((List)localObject1).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (ScanResult)localIterator.next();
        } while ((((ScanResult)localObject1).SSID == null) || (((ScanResult)localObject1).SSID.length() == 0) || (((ScanResult)localObject1).capabilities.contains("[IBSS]")) || (((ScanResult)localObject1).SSID.equals("<unknown ssid>")) || (!((ScanResult)localObject1).SSID.equals(this.f.a)));
        n = ((ScanResult)localObject1).level;
        h.a("ssri " + n, new Object[0]);
        return n;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        Object localObject2 = null;
        continue;
        int n = 0;
      }
    }
  }
  
  public final void a()
  {
    if (this.f == null) {}
    for (;;)
    {
      return;
      com.wifi.connect.plugin.ssrp.c.b localb = new com.wifi.connect.plugin.ssrp.c.b();
      localb.b = this.f.a;
      localb.c = this.f.b;
      localb.n = String.valueOf(this.f.c);
      localb.f = "6";
      new Handler().postDelayed(new d(this, localb), 1500L);
    }
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint, String paramString1, String paramString2, com.bluefay.b.a parama)
  {
    this.i = 1;
    this.l = new n();
    this.l.a = System.currentTimeMillis();
    this.l.e = paramWkAccessPoint.d;
    this.l.c = paramWkAccessPoint.a;
    this.l.d = paramWkAccessPoint.b;
    this.l.f = this.i;
    this.f = paramWkAccessPoint;
    this.j = paramString1;
    this.k = paramString2;
    this.g = parama;
    this.g.a(3, this.a.getString(R.string.tips_autoconnect_init_network), Integer.valueOf(10));
    this.g.a(3, this.a.getString(R.string.tips_autoconnect_intit_newwork_success), Integer.valueOf(30));
    this.g.a(3, this.a.getString(R.string.tips_autoconnect_try_connect), Integer.valueOf(50));
    this.g.a(3, this.a.getString(R.string.tips_autoconnect_try_connect_by_lianmeng), Integer.valueOf(96));
    a(this.c, paramWkAccessPoint);
  }
  
  public final void b()
  {
    this.l.b = System.currentTimeMillis();
    this.l.j = 2;
    this.l.e = c();
    try
    {
      this.l.a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */