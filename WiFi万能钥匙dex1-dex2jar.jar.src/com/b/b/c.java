package com.b.b;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class c<E>
  extends AbstractList<E>
  implements n.b<E>
{
  private boolean a = true;
  
  public final boolean a()
  {
    return this.a;
  }
  
  public void add(int paramInt, E paramE)
  {
    c();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    c();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    c();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    c();
    return super.addAll(paramCollection);
  }
  
  public final void b()
  {
    this.a = false;
  }
  
  protected final void c()
  {
    if (!this.a) {
      throw new UnsupportedOperationException();
    }
  }
  
  public void clear()
  {
    c();
    super.clear();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramObject == this) {
      bool1 = bool2;
    }
    int j;
    for (;;)
    {
      return bool1;
      if (!(paramObject instanceof List))
      {
        bool1 = false;
      }
      else if (!(paramObject instanceof RandomAccess))
      {
        bool1 = super.equals(paramObject);
      }
      else
      {
        paramObject = (List)paramObject;
        j = size();
        if (j == ((List)paramObject).size()) {
          break;
        }
        bool1 = false;
      }
    }
    for (int i = 0;; i++)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      if (!get(i).equals(((List)paramObject).get(i)))
      {
        bool1 = false;
        break;
      }
    }
  }
  
  public int hashCode()
  {
    int k = size();
    int j = 1;
    for (int i = 0; i < k; i++) {
      j = j * 31 + get(i).hashCode();
    }
    return j;
  }
  
  public E remove(int paramInt)
  {
    c();
    return (E)super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    c();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    c();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    c();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE)
  {
    c();
    return (E)super.set(paramInt, paramE);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */