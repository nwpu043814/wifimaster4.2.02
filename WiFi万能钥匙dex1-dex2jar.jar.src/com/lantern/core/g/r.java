package com.lantern.core.g;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Message;
import android.text.TextUtils;
import com.bluefay.b.a;
import com.bluefay.b.h;
import com.bluefay.d.b;
import com.lantern.core.c;
import com.lantern.core.model.WkAccessPoint;
import com.wifimaster.TanPsw;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class r
{
  private final int a = 1;
  private final int b = 2;
  private final int c = 100;
  private final int d = 101;
  private final int e = 102;
  private boolean f = false;
  private final int[] g = { 128005, 128001, 128004 };
  private b h = new s(this, this.g);
  private a i;
  private a j;
  private a k;
  private WifiConfiguration l;
  private boolean m;
  private Context n;
  private WifiManager o;
  private String p;
  private volatile boolean q;
  private WkAccessPoint r;
  
  public r(Context paramContext)
  {
    this.n = paramContext;
    this.o = ((WifiManager)this.n.getSystemService("wifi"));
  }
  
  private a a(int paramInt)
  {
    return new a(paramInt, this.l);
  }
  
  private void a(long paramLong, int paramInt)
  {
    Message localMessage = this.h.obtainMessage(100, paramInt, 0);
    this.h.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(WifiConfiguration paramWifiConfiguration, a parama, long paramLong)
  {
    this.l = paramWifiConfiguration;
    this.i = parama;
    this.q = false;
    if (paramWifiConfiguration == null) {
      this.h.sendEmptyMessage(102);
    }
    for (;;)
    {
      return;
      this.h.removeCallbacksAndMessages(null);
      c.addListener(this.h);
      h.a("-----start a connect,ssid:%s", new Object[] { paramWifiConfiguration.SSID });
      new Thread(new t(this, paramLong)).start();
    }
  }
  
  private boolean a(Method paramMethod, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject = this.o.getClass().getDeclaredField("mService");
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(this.o);
        if (paramMethod == null) {
          continue;
        }
        paramMethod.setAccessible(true);
        bool = ((Boolean)paramMethod.invoke(localObject, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(true) })).booleanValue();
      }
      catch (NoSuchFieldException paramMethod)
      {
        paramMethod.printStackTrace();
        boolean bool = false;
        continue;
      }
      catch (Exception paramMethod)
      {
        paramMethod.printStackTrace();
        continue;
      }
      return bool;
      bool = false;
    }
  }
  
  private Method c()
  {
    for (;;)
    {
      try
      {
        localField = this.o.getClass().getDeclaredField("mService");
        localField.setAccessible(true);
        Method[] arrayOfMethod = localField.get(this.o).getClass().getDeclaredMethods();
        int i2 = arrayOfMethod.length;
        i1 = 0;
        if (i1 >= i2) {
          continue;
        }
        localField = arrayOfMethod[i1];
        boolean bool = localField.getName().equalsIgnoreCase("enableNetwork");
        if (!bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Field localField;
        int i1;
        h.a(localException);
        Object localObject = null;
        continue;
      }
      return localField;
      i1++;
      continue;
      localField = null;
    }
  }
  
  public final WifiConfiguration a(WkAccessPoint paramWkAccessPoint, String paramString, a parama, long paramLong)
  {
    this.r = new WkAccessPoint(paramWkAccessPoint);
    Context localContext = this.n;
    TanPsw.Password(localContext, paramString);
    paramWkAccessPoint = u.a(localContext, paramWkAccessPoint, paramString);
    if ((paramWkAccessPoint.networkId != -1) && (paramString != null) && (paramString.length() > 0)) {}
    for (this.m = true;; this.m = false)
    {
      h.a("need update pwd:" + this.m);
      a(paramWkAccessPoint, parama, paramLong);
      return paramWkAccessPoint;
    }
  }
  
  public final WifiConfiguration a(WkAccessPoint paramWkAccessPoint, boolean paramBoolean, WifiConfiguration paramWifiConfiguration, a parama)
  {
    this.r = paramWkAccessPoint;
    this.m = paramBoolean;
    h.a("need update pwd:" + this.m);
    a(paramWifiConfiguration, parama, 15000L);
    return paramWifiConfiguration;
  }
  
  public final void a()
  {
    this.f = true;
  }
  
  public final void a(WifiConfiguration paramWifiConfiguration, a parama)
  {
    this.l = paramWifiConfiguration;
    this.j = parama;
    if (paramWifiConfiguration == null) {
      this.h.sendEmptyMessage(102);
    }
    for (;;)
    {
      return;
      c.addListener(this.h);
      a(10000L, 2);
      if ((paramWifiConfiguration != null) && (paramWifiConfiguration.networkId != -1))
      {
        boolean bool = this.o.disableNetwork(paramWifiConfiguration.networkId);
        this.o.saveConfiguration();
        if ((bool) && (this.o.disconnect())) {}
      }
      else
      {
        this.h.sendEmptyMessage(102);
      }
    }
  }
  
  public final void b()
  {
    this.q = true;
    if (!TextUtils.isEmpty(this.p))
    {
      WifiConfiguration localWifiConfiguration = u.a(this.n, this.p);
      if (localWifiConfiguration != null)
      {
        this.o.disableNetwork(localWifiConfiguration.networkId);
        this.o.saveConfiguration();
      }
    }
    c.removeListener(this.h);
    if (this.i != null)
    {
      this.i.a(2, "CANCEL", a(10009));
      this.i = null;
    }
  }
  
  public final void b(WifiConfiguration paramWifiConfiguration, a parama)
  {
    String str;
    if (paramWifiConfiguration == null)
    {
      str = "null";
      h.a("config:%s", new Object[] { str });
      this.l = paramWifiConfiguration;
      this.k = parama;
      if (paramWifiConfiguration != null) {
        break label58;
      }
      this.h.sendEmptyMessage(102);
    }
    for (;;)
    {
      return;
      str = paramWifiConfiguration.toString();
      break;
      label58:
      if ((paramWifiConfiguration != null) && (paramWifiConfiguration.networkId != -1))
      {
        boolean bool = this.o.removeNetwork(paramWifiConfiguration.networkId);
        h.a("forget res:" + bool, new Object[0]);
        if ((bool) && (this.o.saveConfiguration()))
        {
          this.h.sendEmptyMessage(101);
          continue;
        }
      }
      this.h.sendEmptyMessage(102);
    }
  }
  
  public static final class a
  {
    public int a;
    public WifiConfiguration b;
    
    public a(int paramInt, WifiConfiguration paramWifiConfiguration)
    {
      this.a = paramInt;
      this.b = paramWifiConfiguration;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */