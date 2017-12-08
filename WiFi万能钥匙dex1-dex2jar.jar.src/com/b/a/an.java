package com.b.a;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class an<K, V>
  extends LinkedHashMap<K, V>
  implements c<K, V>
{
  private final int a;
  
  public an(int paramInt)
  {
    super(paramInt, 0.7F, true);
    this.a = paramInt;
  }
  
  public final V a(K paramK)
  {
    try
    {
      paramK = get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public final void a(K paramK, V paramV)
  {
    try
    {
      put(paramK, paramV);
      return;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  protected final boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    if (size() > this.a) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */