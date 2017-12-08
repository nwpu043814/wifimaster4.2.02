package com.b.a;

import com.b.a.b.b;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

final class ay<T>
{
  private static final Logger a = Logger.getLogger(ay.class.getName());
  private final Map<Type, T> b = new HashMap();
  private final List<ax<Class<?>, T>> c = new ArrayList();
  private boolean d = true;
  
  private int a(Class<?> paramClass)
  {
    int i = this.c.size() - 1;
    if (i >= 0) {
      if (!paramClass.isAssignableFrom((Class)((ax)this.c.get(i)).a)) {}
    }
    for (;;)
    {
      return i;
      i--;
      break;
      i = -1;
    }
  }
  
  private void a(ax<Class<?>, T> paramax)
  {
    try
    {
      if (!this.d)
      {
        paramax = new java/lang/IllegalStateException;
        paramax.<init>("Attempted to modify an unmodifiable map.");
        throw paramax;
      }
    }
    finally {}
    int i = b((Class)paramax.a);
    if (i >= 0)
    {
      a.log(Level.WARNING, "Overriding the existing type handler for {0}", paramax.a);
      this.c.remove(i);
    }
    i = a((Class)paramax.a);
    if (i >= 0)
    {
      IllegalArgumentException localIllegalArgumentException = new java/lang/IllegalArgumentException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("The specified type handler for type ");
      localIllegalArgumentException.<init>(paramax.a + " hides the previously registered type hierarchy handler for " + ((ax)this.c.get(i)).a + ". Gson does not allow this.");
      throw localIllegalArgumentException;
    }
    this.c.add(0, paramax);
  }
  
  /* Error */
  private int b(Class<?> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/b/a/ay:c	Ljava/util/List;
    //   6: invokeinterface 54 1 0
    //   11: iconst_1
    //   12: isub
    //   13: istore_2
    //   14: iload_2
    //   15: iflt +38 -> 53
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 45	com/b/a/ay:c	Ljava/util/List;
    //   23: iload_2
    //   24: invokeinterface 58 2 0
    //   29: checkcast 60	com/b/a/ax
    //   32: getfield 63	com/b/a/ax:a	Ljava/lang/Object;
    //   35: invokevirtual 127	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   38: istore_3
    //   39: iload_3
    //   40: ifeq +7 -> 47
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: iinc 2 -1
    //   50: goto -36 -> 14
    //   53: iconst_m1
    //   54: istore_2
    //   55: goto -12 -> 43
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	ay
    //   0	63	1	paramClass	Class<?>
    //   13	42	2	i	int
    //   38	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	58	finally
    //   18	39	58	finally
  }
  
  /* Error */
  public final T a(Type paramType)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/b/a/ay:b	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 133 2 0
    //   12: astore_3
    //   13: aload_3
    //   14: astore_2
    //   15: aload_3
    //   16: ifnonnull +77 -> 93
    //   19: aload_1
    //   20: invokestatic 138	com/b/a/b/b:b	(Ljava/lang/reflect/Type;)Ljava/lang/Class;
    //   23: astore 4
    //   25: aload 4
    //   27: aload_1
    //   28: if_acmpeq +10 -> 38
    //   31: aload_0
    //   32: aload 4
    //   34: invokevirtual 140	com/b/a/ay:a	(Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   37: astore_3
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: ifnonnull +52 -> 93
    //   44: aload_0
    //   45: getfield 45	com/b/a/ay:c	Ljava/util/List;
    //   48: invokeinterface 144 1 0
    //   53: astore_1
    //   54: aload_1
    //   55: invokeinterface 150 1 0
    //   60: ifeq +37 -> 97
    //   63: aload_1
    //   64: invokeinterface 154 1 0
    //   69: checkcast 60	com/b/a/ax
    //   72: astore_2
    //   73: aload_2
    //   74: getfield 63	com/b/a/ax:a	Ljava/lang/Object;
    //   77: checkcast 19	java/lang/Class
    //   80: aload 4
    //   82: invokevirtual 67	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   85: ifeq -31 -> 54
    //   88: aload_2
    //   89: getfield 156	com/b/a/ax:b	Ljava/lang/Object;
    //   92: astore_2
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_2
    //   96: areturn
    //   97: aconst_null
    //   98: astore_2
    //   99: goto -6 -> 93
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	ay
    //   0	107	1	paramType	Type
    //   14	85	2	localObject1	Object
    //   12	29	3	localObject2	Object
    //   23	58	4	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   2	13	102	finally
    //   19	25	102	finally
    //   31	38	102	finally
    //   44	54	102	finally
    //   54	93	102	finally
  }
  
  public final void a()
  {
    try
    {
      this.d = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(ay<T> paramay)
  {
    try
    {
      if (!this.d)
      {
        paramay = new java/lang/IllegalStateException;
        paramay.<init>("Attempted to modify an unmodifiable map.");
        throw paramay;
      }
    }
    finally {}
    Object localObject = paramay.b.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (!this.b.containsKey(localEntry.getKey())) {
        a((Type)localEntry.getKey(), localEntry.getValue());
      }
    }
    for (int i = paramay.c.size() - 1; i >= 0; i--)
    {
      localObject = (ax)paramay.c.get(i);
      if (b((Class)((ax)localObject).a) < 0) {
        a((ax)localObject);
      }
    }
  }
  
  public final void a(Class<?> paramClass, T paramT)
  {
    try
    {
      ax localax = new com/b/a/ax;
      localax.<init>(paramClass, paramT);
      a(localax);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public final void a(Type paramType, T paramT)
  {
    try
    {
      if (!this.d)
      {
        paramType = new java/lang/IllegalStateException;
        paramType.<init>("Attempted to modify an unmodifiable map.");
        throw paramType;
      }
    }
    finally {}
    if (b(paramType)) {
      a.log(Level.WARNING, "Overriding the existing type handler for {0}", paramType);
    }
    this.b.put(paramType, paramT);
  }
  
  public final ay<T> b()
  {
    try
    {
      ay localay = new com/b/a/ay;
      localay.<init>();
      localay.b.putAll(this.b);
      localay.c.addAll(this.c);
      return localay;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b(ay<T> paramay)
  {
    try
    {
      if (!this.d)
      {
        paramay = new java/lang/IllegalStateException;
        paramay.<init>("Attempted to modify an unmodifiable map.");
        throw paramay;
      }
    }
    finally {}
    Iterator localIterator = paramay.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a((Type)localEntry.getKey(), localEntry.getValue());
    }
    for (int i = paramay.c.size() - 1; i >= 0; i--) {
      a((ax)paramay.c.get(i));
    }
  }
  
  public final void b(Type paramType, T paramT)
  {
    try
    {
      if (!this.d)
      {
        paramType = new java/lang/IllegalStateException;
        paramType.<init>("Attempted to modify an unmodifiable map.");
        throw paramType;
      }
    }
    finally {}
    if (!this.b.containsKey(paramType)) {
      a(paramType, paramT);
    }
  }
  
  public final boolean b(Type paramType)
  {
    try
    {
      boolean bool = this.b.containsKey(paramType);
      return bool;
    }
    finally
    {
      paramType = finally;
      throw paramType;
    }
  }
  
  public final String toString()
  {
    int j = 1;
    StringBuilder localStringBuilder = new StringBuilder("{mapForTypeHierarchy:{");
    Iterator localIterator = this.c.iterator();
    int i = 1;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (ax)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(b.b((Type)((ax)localObject).a).getSimpleName()).append(':');
        localStringBuilder.append(((ax)localObject).b);
        break;
        localStringBuilder.append(',');
      }
    }
    localStringBuilder.append("},map:{");
    localIterator = this.b.entrySet().iterator();
    i = j;
    if (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(b.b((Type)((Map.Entry)localObject).getKey()).getSimpleName()).append(':');
        localStringBuilder.append(((Map.Entry)localObject).getValue());
        break;
        localStringBuilder.append(',');
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */