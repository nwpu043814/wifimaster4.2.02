package com.wifi.connect.plugin.magickey.database;

import com.lantern.core.model.WkAccessPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private HashMap<String, WkAccessPoint> a = new HashMap();
  
  public final List<WkAccessPoint> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((WkAccessPoint)localIterator.next());
    }
    return localArrayList;
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint)
  {
    try
    {
      this.a.put(paramWkAccessPoint.a, paramWkAccessPoint);
      return;
    }
    finally {}
  }
  
  public final void b(WkAccessPoint paramWkAccessPoint)
  {
    try
    {
      this.a.remove(paramWkAccessPoint.a);
      return;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/database/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */