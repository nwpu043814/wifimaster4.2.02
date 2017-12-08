package com.b.a;

import com.b.a.b.a;
import com.b.a.b.b;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

final class aj
  implements av.a
{
  private final av a;
  private final m b;
  private final ay<ak<?>> c;
  private final boolean d;
  private final ah e;
  private final ar f;
  private z g;
  
  aj(av paramav, m paramm, boolean paramBoolean, ay<ak<?>> paramay, ah paramah, ar paramar)
  {
    this.a = paramav;
    this.b = paramm;
    this.d = paramBoolean;
    this.c = paramay;
    this.e = paramah;
    this.f = paramar;
  }
  
  private void a(l paraml, aw paramaw)
  {
    a(paraml, d(paramaw));
  }
  
  private void a(l paraml, z paramz)
  {
    this.g.o().a(this.b.a(paraml), paramz);
  }
  
  private void a(z paramz)
  {
    this.g = ((z)a.a(paramz));
  }
  
  private static boolean a(l paraml, Object paramObject)
  {
    if (b(paraml, paramObject) == null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static Object b(l paraml, Object paramObject)
  {
    try
    {
      paraml = paraml.a(paramObject);
      return paraml;
    }
    catch (IllegalAccessException paraml)
    {
      throw new RuntimeException(paraml);
    }
  }
  
  private z d(aw paramaw)
  {
    aj localaj = new aj(this.a, this.b, this.d, this.c, this.e, this.f);
    this.a.a(paramaw, localaj);
    return localaj.g;
  }
  
  private z e(aw paramaw)
  {
    Object localObject = paramaw.a(this.c);
    if (localObject == null) {
      paramaw = null;
    }
    for (;;)
    {
      return paramaw;
      paramaw = (ak)((ax)localObject).a;
      aw localaw = (aw)((ax)localObject).b;
      a(localaw);
      try
      {
        localObject = paramaw.a(localaw.a(), localaw.a, this.e);
        paramaw = (aw)localObject;
        if (localObject == null) {
          paramaw = ab.a();
        }
        b(localaw);
      }
      finally
      {
        b(localaw);
      }
    }
  }
  
  public final z a()
  {
    return this.g;
  }
  
  public final void a(aw paramaw)
  {
    if (paramaw == null) {}
    for (;;)
    {
      return;
      if (this.f.b(paramaw)) {
        throw new d(paramaw);
      }
      this.f.a(paramaw);
    }
  }
  
  /* Error */
  public final void a(l paraml, Type paramType, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_3
    //   2: invokestatic 143	com/b/a/aj:a	(Lcom/b/a/l;Ljava/lang/Object;)Z
    //   5: ifeq +19 -> 24
    //   8: aload_0
    //   9: getfield 32	com/b/a/aj:d	Z
    //   12: ifeq +11 -> 23
    //   15: aload_0
    //   16: aload_1
    //   17: invokestatic 124	com/b/a/ab:a	()Lcom/b/a/ab;
    //   20: invokespecial 48	com/b/a/aj:a	(Lcom/b/a/l;Lcom/b/a/z;)V
    //   23: return
    //   24: aload_1
    //   25: aload_3
    //   26: invokestatic 76	com/b/a/aj:b	(Lcom/b/a/l;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: astore 4
    //   31: new 95	com/b/a/aw
    //   34: astore_3
    //   35: aload_3
    //   36: aload 4
    //   38: aload_2
    //   39: iconst_0
    //   40: invokespecial 146	com/b/a/aw:<init>	(Ljava/lang/Object;Ljava/lang/reflect/Type;Z)V
    //   43: aload_0
    //   44: aload_1
    //   45: aload_3
    //   46: invokespecial 148	com/b/a/aj:a	(Lcom/b/a/l;Lcom/b/a/aw;)V
    //   49: goto -26 -> 23
    //   52: astore_2
    //   53: aload_2
    //   54: aload_1
    //   55: invokevirtual 151	com/b/a/d:a	(Lcom/b/a/l;)Ljava/lang/IllegalStateException;
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	aj
    //   0	59	1	paraml	l
    //   0	59	2	paramType	Type
    //   0	59	3	paramObject	Object
    //   29	8	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	23	52	com/b/a/d
    //   24	49	52	com/b/a/d
  }
  
  public final void a(Object paramObject)
  {
    a(new ac());
  }
  
  public final void a(Object paramObject, Type paramType)
  {
    a(new s());
    int j = Array.getLength(paramObject);
    paramType = b.e(paramType);
    int i = 0;
    if (i < j)
    {
      Object localObject = new aw(Array.get(paramObject, i), paramType, false);
      if (((aw)localObject).a() == null) {
        this.g.p().a(ab.a());
      }
      for (;;)
      {
        i++;
        break;
        localObject = d((aw)localObject);
        this.g.p().a((z)localObject);
      }
    }
  }
  
  public final Object b()
  {
    return null;
  }
  
  public final void b(aw paramaw)
  {
    if (paramaw != null) {
      this.f.a();
    }
  }
  
  /* Error */
  public final void b(l paraml, Type paramType, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_3
    //   2: invokestatic 143	com/b/a/aj:a	(Lcom/b/a/l;Ljava/lang/Object;)Z
    //   5: ifeq +19 -> 24
    //   8: aload_0
    //   9: getfield 32	com/b/a/aj:d	Z
    //   12: ifeq +11 -> 23
    //   15: aload_0
    //   16: aload_1
    //   17: invokestatic 124	com/b/a/ab:a	()Lcom/b/a/ab;
    //   20: invokespecial 48	com/b/a/aj:a	(Lcom/b/a/l;Lcom/b/a/z;)V
    //   23: return
    //   24: aload_1
    //   25: aload_3
    //   26: invokestatic 76	com/b/a/aj:b	(Lcom/b/a/l;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: astore 4
    //   31: new 95	com/b/a/aw
    //   34: astore_3
    //   35: aload_3
    //   36: aload 4
    //   38: aload_2
    //   39: iconst_0
    //   40: invokespecial 146	com/b/a/aw:<init>	(Ljava/lang/Object;Ljava/lang/reflect/Type;Z)V
    //   43: aload_0
    //   44: aload_1
    //   45: aload_3
    //   46: invokespecial 148	com/b/a/aj:a	(Lcom/b/a/l;Lcom/b/a/aw;)V
    //   49: goto -26 -> 23
    //   52: astore_2
    //   53: aload_2
    //   54: aload_1
    //   55: invokevirtual 151	com/b/a/d:a	(Lcom/b/a/l;)Ljava/lang/IllegalStateException;
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	aj
    //   0	59	1	paraml	l
    //   0	59	2	paramType	Type
    //   0	59	3	paramObject	Object
    //   29	8	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	23	52	com/b/a/d
    //   24	49	52	com/b/a/d
  }
  
  public final void b(Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = ab.a();; paramObject = new ag(paramObject))
    {
      a((z)paramObject);
      return;
    }
  }
  
  public final boolean c(aw paramaw)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        boolean bool1;
        if (paramaw.a() == null)
        {
          bool1 = bool2;
          if (this.d)
          {
            a(ab.a());
            bool1 = bool2;
          }
          return bool1;
        }
        paramaw = e(paramaw);
        if (paramaw != null)
        {
          a(paramaw);
          bool1 = bool2;
        }
        else
        {
          bool1 = false;
        }
      }
      catch (d paramaw)
      {
        throw paramaw.a(null);
      }
    }
  }
  
  public final boolean c(l paraml, Type paramType, Object paramObject)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (!(this.g instanceof ac))
        {
          paramType = new java/lang/IllegalStateException;
          paramType.<init>();
          throw paramType;
        }
      }
      catch (IllegalAccessException paraml)
      {
        throw new RuntimeException();
        paramObject = paraml.a(paramObject);
        if (paramObject == null)
        {
          bool1 = bool2;
          if (this.d)
          {
            a(paraml, ab.a());
            bool1 = bool2;
          }
          return bool1;
        }
        aw localaw = new com/b/a/aw;
        localaw.<init>(paramObject, paramType, false);
        paramType = e(localaw);
        if (paramType != null)
        {
          a(paraml, paramType);
          bool1 = bool2;
          continue;
        }
      }
      catch (d paramType)
      {
        throw paramType.a(paraml);
      }
      boolean bool1 = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */