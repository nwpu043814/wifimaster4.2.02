package com.b.b;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class t<K, V>
  extends LinkedHashMap<K, V>
{
  private static final t b;
  private boolean a = true;
  
  static
  {
    t localt = new t(Collections.emptyMap());
    b = localt;
    localt.a = false;
  }
  
  private t() {}
  
  private t(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  private static int a(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {}
    for (int i = n.a((byte[])paramObject);; i = paramObject.hashCode())
    {
      return i;
      if ((paramObject instanceof n.a)) {
        throw new UnsupportedOperationException();
      }
    }
  }
  
  public static <K, V> t<K, V> a()
  {
    return b;
  }
  
  private void e()
  {
    if (!this.a) {
      throw new UnsupportedOperationException();
    }
  }
  
  public final void a(t<K, V> paramt)
  {
    e();
    if (!paramt.isEmpty()) {
      putAll(paramt);
    }
  }
  
  public final t<K, V> b()
  {
    if (isEmpty()) {}
    for (t localt = new t();; localt = new t(this)) {
      return localt;
    }
  }
  
  public final void c()
  {
    this.a = false;
  }
  
  public final void clear()
  {
    for (;;)
    {
      e();
    }
  }
  
  public final boolean d()
  {
    return this.a;
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    if (isEmpty()) {}
    for (Set localSet = Collections.emptySet();; localSet = super.entrySet()) {
      return localSet;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    Map localMap;
    int i;
    if ((paramObject instanceof Map))
    {
      localMap = (Map)paramObject;
      if (this != localMap) {
        if (size() != localMap.size())
        {
          i = 0;
          if (i == 0) {
            break label178;
          }
        }
      }
    }
    label171:
    label173:
    label178:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      Iterator localIterator = entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label173;
        }
        Object localObject = (Map.Entry)localIterator.next();
        if (!localMap.containsKey(((Map.Entry)localObject).getKey()))
        {
          i = 0;
          break;
        }
        paramObject = ((Map.Entry)localObject).getValue();
        localObject = localMap.get(((Map.Entry)localObject).getKey());
        if (((paramObject instanceof byte[])) && ((localObject instanceof byte[]))) {}
        for (bool = Arrays.equals((byte[])paramObject, (byte[])localObject);; bool = paramObject.equals(localObject))
        {
          if (bool) {
            break label171;
          }
          i = 0;
          break;
        }
      }
      i = 1;
      break;
    }
  }
  
  public final int hashCode()
  {
    Iterator localIterator = entrySet().iterator();
    Map.Entry localEntry;
    int j;
    for (int i = 0; localIterator.hasNext(); i = (a(localEntry.getValue()) ^ j) + i)
    {
      localEntry = (Map.Entry)localIterator.next();
      j = a(localEntry.getKey());
    }
    return i;
  }
  
  public final V put(K paramK, V paramV)
  {
    e();
    return (V)super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    e();
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject)
  {
    e();
    return (V)super.remove(paramObject);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */