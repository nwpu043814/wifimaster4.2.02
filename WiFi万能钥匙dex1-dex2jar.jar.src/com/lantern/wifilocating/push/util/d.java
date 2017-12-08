package com.lantern.wifilocating.push.util;

import com.lantern.wifilocating.push.b.c.a.a;
import com.lantern.wifilocating.push.d.f;
import java.util.Vector;

public class d
{
  private static d a;
  private static String d;
  private static String e;
  private static String f;
  private static long g;
  private f b;
  private Vector<String> c = new Vector();
  
  public static d a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        d locald = new com/lantern/wifilocating/push/util/d;
        locald.<init>();
        a = locald;
      }
      return a;
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    g = paramLong;
  }
  
  public static void a(String paramString)
  {
    f = paramString;
  }
  
  public static void b(String paramString)
  {
    e = paramString;
  }
  
  public static String c()
  {
    Object localObject = a().b;
    if (localObject != null) {}
    for (localObject = ((f)localObject).b;; localObject = null) {
      return (String)localObject;
    }
  }
  
  public static void c(String paramString)
  {
    d = paramString;
  }
  
  public static long e()
  {
    return g;
  }
  
  public final void a(f paramf)
  {
    this.b = paramf;
  }
  
  public final boolean a(a parama)
  {
    parama = parama.a + ":" + parama.b;
    return this.c.contains(parama);
  }
  
  public final f b()
  {
    return this.b;
  }
  
  public final void d()
  {
    this.c.clear();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */