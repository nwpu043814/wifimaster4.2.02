package com.b.b;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class z<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  private final int a;
  private List<z<K, V>.b> b;
  private Map<K, V> c;
  private boolean d;
  private volatile z<K, V>.d e;
  
  private z(int paramInt)
  {
    this.a = paramInt;
    this.b = Collections.emptyList();
    this.c = Collections.emptyMap();
  }
  
  private int a(K paramK)
  {
    int i = this.b.size() - 1;
    int j;
    if (i >= 0)
    {
      j = paramK.compareTo(((b)this.b.get(i)).a());
      if (j > 0) {
        i = -(i + 2);
      }
      for (;;)
      {
        return i;
        if (j != 0) {
          break;
        }
      }
    }
    for (;;)
    {
      if (j <= i)
      {
        int k = (j + i) / 2;
        int m = paramK.compareTo(((b)this.b.get(k)).a());
        if (m < 0)
        {
          i = k - 1;
          continue;
        }
        if (m > 0)
        {
          j = k + 1;
          continue;
        }
        i = k;
        break;
      }
      i = -(j + 1);
      break;
      j = 0;
    }
  }
  
  static <FieldDescriptorType extends k.a<FieldDescriptorType>> z<FieldDescriptorType, Object> a(int paramInt)
  {
    return new aa(paramInt);
  }
  
  private V c(int paramInt)
  {
    e();
    Object localObject = ((b)this.b.remove(paramInt)).getValue();
    if (!this.c.isEmpty())
    {
      Iterator localIterator = f().entrySet().iterator();
      this.b.add(new b((Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    return (V)localObject;
  }
  
  private void e()
  {
    if (this.d) {
      throw new UnsupportedOperationException();
    }
  }
  
  private SortedMap<K, V> f()
  {
    e();
    if ((this.c.isEmpty()) && (!(this.c instanceof TreeMap))) {
      this.c = new TreeMap();
    }
    return (SortedMap)this.c;
  }
  
  public final V a(K paramK, V paramV)
  {
    e();
    int i = a(paramK);
    if (i >= 0) {
      paramK = ((b)this.b.get(i)).setValue(paramV);
    }
    for (;;)
    {
      return paramK;
      e();
      if ((this.b.isEmpty()) && (!(this.b instanceof ArrayList))) {
        this.b = new ArrayList(this.a);
      }
      i = -(i + 1);
      if (i >= this.a)
      {
        paramK = f().put(paramK, paramV);
      }
      else
      {
        if (this.b.size() == this.a)
        {
          b localb = (b)this.b.remove(this.a - 1);
          f().put(localb.a(), localb.getValue());
        }
        this.b.add(i, new b(paramK, paramV));
        paramK = null;
      }
    }
  }
  
  public void a()
  {
    if (!this.d) {
      if (!this.c.isEmpty()) {
        break label34;
      }
    }
    label34:
    for (Map localMap = Collections.emptyMap();; localMap = Collections.unmodifiableMap(this.c))
    {
      this.c = localMap;
      this.d = true;
      return;
    }
  }
  
  public final Map.Entry<K, V> b(int paramInt)
  {
    return (Map.Entry)this.b.get(paramInt);
  }
  
  public final boolean b()
  {
    return this.d;
  }
  
  public final int c()
  {
    return this.b.size();
  }
  
  public void clear()
  {
    e();
    if (!this.b.isEmpty()) {
      this.b.clear();
    }
    if (!this.c.isEmpty()) {
      this.c.clear();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    if ((a((Comparable)paramObject) >= 0) || (this.c.containsKey(paramObject))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final Iterable<Map.Entry<K, V>> d()
  {
    if (this.c.isEmpty()) {}
    for (Object localObject = a.a();; localObject = this.c.entrySet()) {
      return (Iterable<Map.Entry<K, V>>)localObject;
    }
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    if (this.e == null) {
      this.e = new d((byte)0);
    }
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof z))
      {
        bool = super.equals(paramObject);
      }
      else
      {
        paramObject = (z)paramObject;
        int j = size();
        if (j != ((z)paramObject).size())
        {
          bool = false;
        }
        else
        {
          int k = c();
          if (k != ((z)paramObject).c())
          {
            bool = entrySet().equals(((z)paramObject).entrySet());
          }
          else
          {
            for (int i = 0;; i++)
            {
              if (i >= k) {
                break label123;
              }
              if (!b(i).equals(((z)paramObject).b(i)))
              {
                bool = false;
                break;
              }
            }
            label123:
            if (k != j) {
              bool = this.c.equals(((z)paramObject).c);
            }
          }
        }
      }
    }
  }
  
  public V get(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    int i = a((Comparable)paramObject);
    if (i >= 0) {}
    for (paramObject = ((b)this.b.get(i)).getValue();; paramObject = this.c.get(paramObject)) {
      return (V)paramObject;
    }
  }
  
  public int hashCode()
  {
    int k = c();
    int j = 0;
    int i = 0;
    while (j < k)
    {
      i += ((b)this.b.get(j)).hashCode();
      j++;
    }
    if (this.c.size() > 0) {
      i = this.c.hashCode() + i;
    }
    for (;;)
    {
      return i;
    }
  }
  
  public V remove(Object paramObject)
  {
    e();
    paramObject = (Comparable)paramObject;
    int i = a((Comparable)paramObject);
    if (i >= 0) {
      paramObject = c(i);
    }
    for (;;)
    {
      return (V)paramObject;
      if (this.c.isEmpty()) {
        paramObject = null;
      } else {
        paramObject = this.c.remove(paramObject);
      }
    }
  }
  
  public int size()
  {
    return this.b.size() + this.c.size();
  }
  
  private static final class a
  {
    private static final Iterator<Object> a = new ab();
    private static final Iterable<Object> b = new ac();
    
    static <T> Iterable<T> a()
    {
      return b;
    }
  }
  
  private final class b
    implements Comparable<z<K, V>.b>, Map.Entry<K, V>
  {
    private final K b;
    private V c;
    
    b(V paramV)
    {
      this.b = paramV;
      Object localObject;
      this.c = localObject;
    }
    
    b()
    {
      this((Comparable)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
    }
    
    private static boolean a(Object paramObject1, Object paramObject2)
    {
      boolean bool;
      if (paramObject1 == null) {
        if (paramObject2 == null) {
          bool = true;
        }
      }
      for (;;)
      {
        return bool;
        bool = false;
        continue;
        bool = paramObject1.equals(paramObject2);
      }
    }
    
    public final K a()
    {
      return this.b;
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (paramObject == this) {}
      for (;;)
      {
        return bool;
        if (!(paramObject instanceof Map.Entry))
        {
          bool = false;
        }
        else
        {
          paramObject = (Map.Entry)paramObject;
          if ((!a(this.b, ((Map.Entry)paramObject).getKey())) || (!a(this.c, ((Map.Entry)paramObject).getValue()))) {
            bool = false;
          }
        }
      }
    }
    
    public final V getValue()
    {
      return (V)this.c;
    }
    
    public final int hashCode()
    {
      int j = 0;
      int i;
      if (this.b == null)
      {
        i = 0;
        if (this.c != null) {
          break label33;
        }
      }
      for (;;)
      {
        return i ^ j;
        i = this.b.hashCode();
        break;
        label33:
        j = this.c.hashCode();
      }
    }
    
    public final V setValue(V paramV)
    {
      z.a(z.this);
      Object localObject = this.c;
      this.c = paramV;
      return (V)localObject;
    }
    
    public final String toString()
    {
      return this.b + "=" + this.c;
    }
  }
  
  private final class c
    implements Iterator<Map.Entry<K, V>>
  {
    private int b = -1;
    private boolean c;
    private Iterator<Map.Entry<K, V>> d;
    
    private c() {}
    
    private Iterator<Map.Entry<K, V>> a()
    {
      if (this.d == null) {
        this.d = z.c(z.this).entrySet().iterator();
      }
      return this.d;
    }
    
    public final boolean hasNext()
    {
      if ((this.b + 1 < z.b(z.this).size()) || (a().hasNext())) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final void remove()
    {
      if (!this.c) {
        throw new IllegalStateException("remove() was called before next()");
      }
      this.c = false;
      z.a(z.this);
      if (this.b < z.b(z.this).size())
      {
        z localz = z.this;
        int i = this.b;
        this.b = (i - 1);
        z.a(localz, i);
      }
      for (;;)
      {
        return;
        a().remove();
      }
    }
  }
  
  private final class d
    extends AbstractSet<Map.Entry<K, V>>
  {
    private d() {}
    
    public final void clear()
    {
      z.this.clear();
    }
    
    public final boolean contains(Object paramObject)
    {
      Object localObject = (Map.Entry)paramObject;
      paramObject = z.this.get(((Map.Entry)localObject).getKey());
      localObject = ((Map.Entry)localObject).getValue();
      if ((paramObject == localObject) || ((paramObject != null) && (paramObject.equals(localObject)))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final Iterator<Map.Entry<K, V>> iterator()
    {
      return new z.c(z.this, (byte)0);
    }
    
    public final boolean remove(Object paramObject)
    {
      paramObject = (Map.Entry)paramObject;
      if (contains(paramObject)) {
        z.this.remove(((Map.Entry)paramObject).getKey());
      }
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final int size()
    {
      return z.this.size();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */