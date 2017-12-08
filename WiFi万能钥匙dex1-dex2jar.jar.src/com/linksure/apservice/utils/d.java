package com.linksure.apservice.utils;

import com.linksure.apservice.a.d.a.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static Map<Object, a> a = new HashMap();
  
  public static void a(Object paramObject)
  {
    a.remove(paramObject);
  }
  
  public static void a(Object paramObject, a parama)
  {
    a.put(paramObject, parama);
  }
  
  public static boolean a(b paramb)
  {
    if (paramb.a() == 3009)
    {
      paramb = a.entrySet().iterator();
      while (paramb.hasNext()) {
        ((a)((Map.Entry)paramb.next()).getValue()).onEvent(1);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onEvent(int paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */