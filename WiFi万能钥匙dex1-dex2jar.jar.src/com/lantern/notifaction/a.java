package com.lantern.notifaction;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Handler;
import android.os.Looper;
import com.bluefay.b.h;
import com.lantern.core.g.j;
import com.lantern.notifaction.o2o.i;

public abstract class a
{
  private static a b;
  protected Application a;
  private final int[] c = { 128005, 128001, 128030, 128100, 128031, 128032, 128201 };
  private com.bluefay.d.b d = new b(this, this.c);
  
  protected a(Application paramApplication)
  {
    h.a("new instance", new Object[0]);
    this.a = paramApplication;
    com.lantern.core.c.addListener(this.d);
  }
  
  public static a a(Application paramApplication)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = i.b(paramApplication);
      }
      return b;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(1);
    if (paramContext == null) {}
    for (boolean bool = false;; bool = paramContext.isConnected()) {
      return bool;
    }
  }
  
  public abstract void a();
  
  protected abstract void a(int paramInt);
  
  protected abstract void a(NetworkInfo.DetailedState paramDetailedState);
  
  protected abstract void b();
  
  public void c() {}
  
  public abstract void d();
  
  public final void e()
  {
    if (a(this.a))
    {
      Handler localHandler = new Handler(Looper.getMainLooper());
      j.a().a(new c(this, localHandler));
    }
  }
  
  public abstract void f();
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/notifaction/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */