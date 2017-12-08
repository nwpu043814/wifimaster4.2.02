package com.lantern.core.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.bluefay.b.h;
import java.util.HashSet;
import java.util.Hashtable;

public final class b
{
  private static b d = null;
  private Context a;
  private Hashtable<String, HashSet<a>> b;
  private HashSet<a> c;
  private BroadcastReceiver e = new c(this);
  
  private b(Context paramContext)
  {
    this.a = paramContext;
    this.b = new Hashtable();
    this.c = new HashSet();
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.PACKAGE_ADDED");
    paramContext.addAction("android.intent.action.PACKAGE_REMOVED");
    paramContext.addAction("android.intent.action.PACKAGE_REPLACED");
    paramContext.addDataScheme("package");
    this.a.registerReceiver(this.e, paramContext);
  }
  
  public static b a()
  {
    return d;
  }
  
  public static b a(Context paramContext)
  {
    if (d == null) {
      d = new b(paramContext);
    }
    return d;
  }
  
  public final void a(String paramString, a parama)
  {
    String str = paramString.toLowerCase();
    HashSet localHashSet = (HashSet)this.b.get(str);
    paramString = localHashSet;
    if (localHashSet == null)
    {
      paramString = new HashSet();
      this.b.put(str, paramString);
    }
    paramString.add(parama);
    h.a("register an observer for:" + str, new Object[0]);
    this.c.add(parama);
  }
  
  public final void b()
  {
    this.a.unregisterReceiver(this.e);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */