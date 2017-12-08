package com.b.a;

import java.lang.reflect.Type;

final class aw
{
  final Type a;
  private Object b;
  private final boolean c;
  
  aw(Object paramObject, Type paramType, boolean paramBoolean)
  {
    this.b = paramObject;
    this.a = paramType;
    this.c = paramBoolean;
  }
  
  private static Type a(Type paramType, Class<?> paramClass)
  {
    Object localObject2 = paramType;
    if ((paramType instanceof Class))
    {
      Object localObject1 = paramType;
      if (((Class)paramType).isAssignableFrom(paramClass)) {
        localObject1 = paramClass;
      }
      localObject2 = localObject1;
      if (localObject1 == Object.class) {
        localObject2 = paramClass;
      }
    }
    return (Type)localObject2;
  }
  
  final <HANDLER> ax<HANDLER, aw> a(ay<HANDLER> paramay)
  {
    Object localObject1;
    if ((!this.c) && (this.b != null)) {
      if ((this.c) || (this.b == null))
      {
        localObject1 = this;
        Object localObject2 = paramay.a(((aw)localObject1).a);
        if (localObject2 == null) {
          break label103;
        }
        paramay = new ax(localObject2, localObject1);
      }
    }
    for (;;)
    {
      return paramay;
      localObject1 = a(this.a, this.b.getClass());
      if (localObject1 == this.a)
      {
        localObject1 = this;
        break;
      }
      localObject1 = new aw(this.b, (Type)localObject1, this.c);
      break;
      label103:
      paramay = paramay.a(this.a);
      if (paramay == null) {
        paramay = null;
      } else {
        paramay = new ax(paramay, this);
      }
    }
  }
  
  final Object a()
  {
    return this.b;
  }
  
  final void a(Object paramObject)
  {
    this.b = paramObject;
  }
  
  final Type b()
  {
    if ((this.c) || (this.b == null)) {}
    for (Type localType = this.a;; localType = a(this.a, this.b.getClass())) {
      return localType;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if (paramObject == null)
      {
        bool = false;
      }
      else if (getClass() != paramObject.getClass())
      {
        bool = false;
      }
      else
      {
        paramObject = (aw)paramObject;
        if (this.b == null)
        {
          if (((aw)paramObject).b != null) {
            bool = false;
          }
        }
        else if (this.b != ((aw)paramObject).b)
        {
          bool = false;
          continue;
        }
        if (this.a == null)
        {
          if (((aw)paramObject).a != null) {
            bool = false;
          }
        }
        else if (!this.a.equals(((aw)paramObject).a))
        {
          bool = false;
          continue;
        }
        if (this.c != ((aw)paramObject).c) {
          bool = false;
        }
      }
    }
  }
  
  public final int hashCode()
  {
    if (this.b == null) {}
    for (int i = 31;; i = this.b.hashCode()) {
      return i;
    }
  }
  
  public final String toString()
  {
    return String.format("preserveType: %b, type: %s, obj: %s", new Object[] { Boolean.valueOf(this.c), this.a, this.b });
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */