package com.b.b;

import java.util.Iterator;
import java.util.Map.Entry;

public final class p
  extends q
{
  private final u b;
  
  public final u a()
  {
    return a(this.b);
  }
  
  public final boolean equals(Object paramObject)
  {
    return a().equals(paramObject);
  }
  
  public final int hashCode()
  {
    return a().hashCode();
  }
  
  public final String toString()
  {
    return a().toString();
  }
  
  static final class a<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, p> a;
    
    private a(Map.Entry<K, p> paramEntry)
    {
      this.a = paramEntry;
    }
    
    public final K getKey()
    {
      return (K)this.a.getKey();
    }
    
    public final Object getValue()
    {
      Object localObject = (p)this.a.getValue();
      if (localObject == null) {}
      for (localObject = null;; localObject = ((p)localObject).a()) {
        return localObject;
      }
    }
    
    public final Object setValue(Object paramObject)
    {
      if (!(paramObject instanceof u)) {
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
      }
      return ((p)this.a.getValue()).b((u)paramObject);
    }
  }
  
  static final class b<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> a;
    
    public b(Iterator<Map.Entry<K, Object>> paramIterator)
    {
      this.a = paramIterator;
    }
    
    public final boolean hasNext()
    {
      return this.a.hasNext();
    }
    
    public final void remove()
    {
      this.a.remove();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */