package com.lantern.webox.a.a;

import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.webox.a.l;
import com.lantern.webox.a.l.a;
import java.util.HashMap;
import java.util.Map;

public final class u
  implements l
{
  public final void a(l.a parama)
  {
    o localo = c.getServer();
    if (localo != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("latitude", localo.d());
      localHashMap.put("longitude", localo.e());
      localHashMap.put("mapsp", localo.o());
      localHashMap.put("accuracy", "");
      parama.a(localHashMap);
    }
    for (;;)
    {
      return;
      parama.b("");
    }
  }
  
  public final void b(l.a parama)
  {
    o localo = c.getServer();
    if (localo != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("latitude", localo.d());
      localHashMap.put("longitude", localo.e());
      localHashMap.put("mapsp", localo.o());
      localHashMap.put("accuracy", "");
      parama.a(localHashMap);
    }
    for (;;)
    {
      return;
      parama.b("");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */