package com.wifi.connect.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class an<K, V>
{
  private final HashMap<K, List<V>> a = new HashMap();
  
  public final List<V> a(K paramK)
  {
    paramK = (List)this.a.get(paramK);
    if (paramK != null) {}
    for (;;)
    {
      return paramK;
      paramK = Collections.emptyList();
    }
  }
  
  public final void a()
  {
    this.a.clear();
  }
  
  public final void a(K paramK, V paramV)
  {
    List localList = (List)this.a.get(paramK);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(3);
      this.a.put(paramK, localObject);
    }
    ((List)localObject).add(paramV);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */