package com.b.b;

import java.util.ArrayList;
import java.util.List;

final class y<E>
  extends c<E>
{
  private static final y<Object> a;
  private final List<E> b;
  
  static
  {
    y localy = new y();
    a = localy;
    localy.b();
  }
  
  y()
  {
    this(new ArrayList(10));
  }
  
  private y(List<E> paramList)
  {
    this.b = paramList;
  }
  
  public static <E> y<E> d()
  {
    return a;
  }
  
  public final void add(int paramInt, E paramE)
  {
    c();
    this.b.add(paramInt, paramE);
    this.modCount += 1;
  }
  
  public final E get(int paramInt)
  {
    return (E)this.b.get(paramInt);
  }
  
  public final E remove(int paramInt)
  {
    c();
    Object localObject = this.b.remove(paramInt);
    this.modCount += 1;
    return (E)localObject;
  }
  
  public final E set(int paramInt, E paramE)
  {
    c();
    paramE = this.b.set(paramInt, paramE);
    this.modCount += 1;
    return paramE;
  }
  
  public final int size()
  {
    return this.b.size();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */