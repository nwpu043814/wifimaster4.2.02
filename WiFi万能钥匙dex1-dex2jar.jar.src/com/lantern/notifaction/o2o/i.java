package com.lantern.notifaction.o2o;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.t;

public class i
  extends com.lantern.notifaction.a
{
  private static i c;
  com.bluefay.b.a b = new j(this);
  private e d;
  private WifiManager e;
  
  private i(Application paramApplication)
  {
    super(paramApplication);
    h.a("new o2o notification manager instance", new Object[0]);
    this.e = ((WifiManager)this.a.getSystemService("wifi"));
    this.d = new e(this.a);
    if (this.e.isWifiEnabled())
    {
      paramApplication = ((ConnectivityManager)this.a.getSystemService("connectivity")).getNetworkInfo(1);
      if ((paramApplication != null) && (paramApplication.isConnected())) {
        this.d.a(e.a.d);
      }
    }
    for (;;)
    {
      return;
      this.d.a(e.a.b);
      continue;
      this.d.a(e.a.a);
    }
  }
  
  private static String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = paramString;
    }
    for (;;)
    {
      return str;
      int i = paramString.length();
      str = paramString;
      if (i > 1)
      {
        str = paramString;
        if (paramString.charAt(0) == '"')
        {
          str = paramString;
          if (paramString.charAt(i - 1) == '"') {
            str = paramString.substring(1, i - 1);
          }
        }
      }
    }
  }
  
  public static i b(Application paramApplication)
  {
    if (c == null) {}
    try
    {
      if (c == null)
      {
        i locali = new com/lantern/notifaction/o2o/i;
        locali.<init>(paramApplication);
        c = locali;
      }
      return c;
    }
    finally {}
  }
  
  public final void a()
  {
    if (this.d.c() == e.a.f) {}
    for (;;)
    {
      return;
      this.d.a(e.a.f);
      String str = a(this.e.getConnectionInfo().getSSID());
      this.d.a(str);
      this.d.b(this.a.getString(2131363321, new Object[] { str }));
      d();
      if (t.d(this.a))
      {
        h.a("---doGetO2OServices---", new Object[0]);
        new com.lantern.launcher.task.a(this.b).execute(new Void[0]);
      }
    }
  }
  
  protected final void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      d();
      return;
      this.d.a("");
      this.d.a(e.a.b);
      continue;
      this.d.a("");
      this.d.a(e.a.a);
    }
  }
  
  protected final void a(NetworkInfo.DetailedState paramDetailedState)
  {
    int i = 0;
    int j = 1;
    h.a("state:%s", new Object[] { paramDetailedState });
    if ((paramDetailedState == NetworkInfo.DetailedState.FAILED) || (paramDetailedState == NetworkInfo.DetailedState.DISCONNECTED))
    {
      this.d.a("");
      this.d.a(e.a.b);
      i = 1;
    }
    WifiInfo localWifiInfo = this.e.getConnectionInfo();
    if (NetworkInfo.DetailedState.CONNECTED == paramDetailedState)
    {
      this.d.a(a(localWifiInfo.getSSID()));
      this.d.a(e.a.d);
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        d();
      }
      return;
    }
  }
  
  protected final void b()
  {
    h.a("recheck network", new Object[0]);
    Object localObject;
    if (this.e.isWifiEnabled())
    {
      localObject = ((ConnectivityManager)this.a.getSystemService("connectivity")).getNetworkInfo(1);
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
      {
        this.d.a(e.a.d);
        localObject = this.e.getConnectionInfo();
        if (localObject != null)
        {
          localObject = a(((WifiInfo)localObject).getSSID());
          this.d.a((String)localObject);
        }
        localObject = com.lantern.core.g.j.a(this.a);
        if (localObject != null) {}
      }
    }
    for (;;)
    {
      return;
      if (com.lantern.core.g.j.b(com.lantern.core.g.j.a().a((WkAccessPoint)localObject)))
      {
        this.d.a(e.a.f);
        continue;
        this.d.a(e.a.b);
        this.d.a(null);
        continue;
        this.d.a(e.a.a);
        this.d.a(null);
      }
    }
  }
  
  public final void c()
  {
    this.d.a(this.a.getString(2131363320));
    this.d.a(e.a.e);
    d();
  }
  
  public final void d()
  {
    if (t.d(this.a)) {
      this.d.a();
    }
    for (;;)
    {
      return;
      this.d.b();
    }
  }
  
  public final void f()
  {
    this.d.b();
    this.d.b(null);
  }
  
  final e g()
  {
    return this.d;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/notifaction/o2o/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */