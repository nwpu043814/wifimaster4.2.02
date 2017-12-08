package com.b.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class k<FieldDescriptorType extends a<FieldDescriptorType>>
{
  private static final k d = new k((byte)0);
  private final z<FieldDescriptorType, Object> a;
  private boolean b;
  private boolean c = false;
  
  private k()
  {
    this.a = z.a(16);
  }
  
  private k(byte paramByte)
  {
    this.a = z.a(0);
    if (!this.b)
    {
      this.a.a();
      this.b = true;
    }
  }
  
  static int a(ak.a parama, int paramInt, Object paramObject)
  {
    paramInt = h.g(paramInt);
    int i = paramInt;
    if (parama == ak.a.j) {
      i = paramInt * 2;
    }
    switch (l.b[parama.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1: 
      ((Double)paramObject).doubleValue();
      paramInt = h.f();
    }
    for (;;)
    {
      return i + paramInt;
      ((Float)paramObject).floatValue();
      paramInt = h.e();
      continue;
      paramInt = h.c(((Long)paramObject).longValue());
      continue;
      paramInt = h.d(((Long)paramObject).longValue());
      continue;
      paramInt = h.h(((Integer)paramObject).intValue());
      continue;
      ((Long)paramObject).longValue();
      paramInt = h.c();
      continue;
      ((Integer)paramObject).intValue();
      paramInt = h.a();
      continue;
      ((Boolean)paramObject).booleanValue();
      paramInt = h.g();
      continue;
      paramInt = h.c((u)paramObject);
      continue;
      if ((paramObject instanceof e))
      {
        paramInt = h.b((e)paramObject);
      }
      else
      {
        paramInt = h.b((byte[])paramObject);
        continue;
        if ((paramObject instanceof e))
        {
          paramInt = h.b((e)paramObject);
        }
        else
        {
          paramInt = h.b((String)paramObject);
          continue;
          paramInt = h.i(((Integer)paramObject).intValue());
          continue;
          ((Integer)paramObject).intValue();
          paramInt = h.b();
          continue;
          ((Long)paramObject).longValue();
          paramInt = h.d();
          continue;
          paramInt = h.j(((Integer)paramObject).intValue());
          continue;
          paramInt = h.e(((Long)paramObject).longValue());
          continue;
          if ((paramObject instanceof p))
          {
            paramInt = h.a((p)paramObject);
          }
          else
          {
            paramInt = h.b((u)paramObject);
            continue;
            if ((paramObject instanceof n.a)) {
              paramInt = h.k(((n.a)paramObject).a());
            } else {
              paramInt = h.k(((Integer)paramObject).intValue());
            }
          }
        }
      }
    }
  }
  
  public static <T extends a<T>> k<T> a()
  {
    return new k();
  }
  
  public static Object a(g paramg, ak.a parama)
  {
    return ak.a(paramg, parama, ak.c.b);
  }
  
  private static void a(ak.a parama, Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null) {
      throw new NullPointerException();
    }
    switch (l.a[parama.a().ordinal()])
    {
    }
    while (!bool)
    {
      throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      bool = paramObject instanceof Integer;
      continue;
      bool = paramObject instanceof Long;
      continue;
      bool = paramObject instanceof Float;
      continue;
      bool = paramObject instanceof Double;
      continue;
      bool = paramObject instanceof Boolean;
      continue;
      bool = paramObject instanceof String;
      continue;
      if (((paramObject instanceof e)) || ((paramObject instanceof byte[])))
      {
        bool = true;
        continue;
        if (((paramObject instanceof Integer)) || ((paramObject instanceof n.a)))
        {
          bool = true;
          continue;
          if (((paramObject instanceof u)) || ((paramObject instanceof p))) {
            bool = true;
          }
        }
      }
    }
  }
  
  static void a(h paramh, ak.a parama, int paramInt, Object paramObject)
  {
    if (parama == ak.a.j)
    {
      parama = (u)paramObject;
      paramh.a(paramInt, 3);
      parama.a(paramh);
      paramh.a(paramInt, 4);
    }
    for (;;)
    {
      return;
      paramh.a(paramInt, parama.b());
      switch (l.b[parama.ordinal()])
      {
      default: 
        break;
      case 1: 
        paramh.b(Double.doubleToRawLongBits(((Double)paramObject).doubleValue()));
        break;
      case 2: 
        paramh.d(Float.floatToRawIntBits(((Float)paramObject).floatValue()));
        break;
      case 3: 
        paramh.a(((Long)paramObject).longValue());
        break;
      case 4: 
        paramh.a(((Long)paramObject).longValue());
        break;
      case 5: 
        paramh.b(((Integer)paramObject).intValue());
        break;
      case 6: 
        paramh.b(((Long)paramObject).longValue());
        break;
      case 7: 
        paramh.d(((Integer)paramObject).intValue());
        break;
      case 8: 
        if (((Boolean)paramObject).booleanValue()) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramh.a((byte)paramInt);
          break;
        }
      case 9: 
        ((u)paramObject).a(paramh);
        break;
      case 10: 
        paramh.a((u)paramObject);
        break;
      case 11: 
        if ((paramObject instanceof e)) {
          paramh.a((e)paramObject);
        } else {
          paramh.a((String)paramObject);
        }
        break;
      case 12: 
        if ((paramObject instanceof e))
        {
          paramh.a((e)paramObject);
        }
        else
        {
          parama = (byte[])paramObject;
          paramh.a(parama, parama.length);
        }
        break;
      case 13: 
        paramh.c(((Integer)paramObject).intValue());
        break;
      case 14: 
        paramh.d(((Integer)paramObject).intValue());
        break;
      case 15: 
        paramh.b(((Long)paramObject).longValue());
        break;
      case 16: 
        paramh.c(h.m(((Integer)paramObject).intValue()));
        break;
      case 17: 
        paramh.a(h.f(((Long)paramObject).longValue()));
        break;
      case 18: 
        if ((paramObject instanceof n.a)) {
          paramh.b(((n.a)paramObject).a());
        } else {
          paramh.b(((Integer)paramObject).intValue());
        }
        break;
      }
    }
  }
  
  private void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.b())
    {
      if (!(paramObject instanceof List)) {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((List)paramObject);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        paramObject = localIterator.next();
        a(paramFieldDescriptorType.a(), paramObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      if ((paramObject instanceof p)) {
        this.c = true;
      }
      this.a.a(paramFieldDescriptorType, paramObject);
      return;
      a(paramFieldDescriptorType.a(), paramObject);
    }
  }
  
  public final Iterator<Map.Entry<FieldDescriptorType, Object>> b()
  {
    if (this.c) {}
    for (Object localObject = new p.b(this.a.entrySet().iterator());; localObject = this.a.entrySet().iterator()) {
      return (Iterator<Map.Entry<FieldDescriptorType, Object>>)localObject;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof k))
      {
        bool = false;
      }
      else
      {
        paramObject = (k)paramObject;
        bool = this.a.equals(((k)paramObject).a);
      }
    }
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public static abstract interface a<T extends a<T>>
    extends Comparable<T>
  {
    public abstract ak.a a();
    
    public abstract boolean b();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */