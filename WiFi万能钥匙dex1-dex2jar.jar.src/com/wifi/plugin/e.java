package com.wifi.plugin;

import java.util.Collection;
import java.util.Iterator;

public abstract class e<E>
{
  public e(Collection<E> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0)) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        a(paramCollection.next());
      }
    }
  }
  
  public abstract void a(E paramE);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */