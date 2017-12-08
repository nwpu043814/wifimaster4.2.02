package com.wifi.connect.a;

import com.bluefay.b.h;
import com.lantern.core.b.e;
import com.wifi.connect.model.AccessPointKey;
import com.wifi.connect.model.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static b b;
  private com.lantern.core.b.a a;
  private ConcurrentHashMap<d, com.wifi.connect.model.a> c;
  
  public b()
  {
    if (this.a == null)
    {
      com.lantern.core.c.getInstance();
      this.a = com.lantern.core.b.a.a(com.lantern.core.c.getAppContext(), "APCACHE_NOTICE_CURR");
    }
    this.c = ((ConcurrentHashMap)this.a.a(e.a));
    if (this.c == null)
    {
      h.a("CacheApMap is null", new Object[0]);
      this.c = new ConcurrentHashMap();
    }
  }
  
  public static b b()
  {
    if (b == null) {
      b = new b();
    }
    return b;
  }
  
  public final ArrayList<d> a()
  {
    int i = this.c.size();
    Object localObject1 = this.c.keySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d)((Iterator)localObject1).next();
      localObject2 = (com.wifi.connect.model.a)this.c.get(localObject2);
      if (((com.wifi.connect.model.a)localObject2).c())
      {
        h.a("CacheApMap remove cache ap ssid " + ((com.wifi.connect.model.a)localObject2).a(), new Object[0]);
        ((Iterator)localObject1).remove();
      }
    }
    if (i > this.c.size()) {
      this.a.a(e.a, this.c);
    }
    localObject1 = new ArrayList();
    if ((this.c == null) || (this.c.size() == 0)) {}
    for (;;)
    {
      return (ArrayList<d>)localObject1;
      localObject2 = new ArrayList(this.c.entrySet());
      try
      {
        c localc = new com/wifi/connect/a/c;
        localc.<init>(this);
        Collections.sort((List)localObject2, localc);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(((Map.Entry)((Iterator)localObject2).next()).getKey());
        }
      }
      catch (Exception localException)
      {
        h.a(localException);
      }
    }
  }
  
  public final void a(String paramString, AccessPointKey paramAccessPointKey)
  {
    try
    {
      ConcurrentHashMap localConcurrentHashMap = this.c;
      d locald = new com/wifi/connect/model/d;
      locald.<init>(paramString, paramAccessPointKey.b());
      paramString = new com/wifi/connect/model/a;
      paramString.<init>(paramAccessPointKey);
      localConcurrentHashMap.put(locald, paramString);
      this.a.a(e.a, this.c);
      return;
    }
    finally {}
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      ConcurrentHashMap localConcurrentHashMap = this.c;
      d locald = new com/wifi/connect/model/d;
      locald.<init>(paramString1, paramString2);
      localConcurrentHashMap.remove(locald);
      this.a.a(e.a, this.c);
      return;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */