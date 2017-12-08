package com.b.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class m<MessageType extends m<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
  extends a<MessageType, BuilderType>
{
  protected ag b = ag.a();
  protected int c = -1;
  
  static <T extends m<T, ?>> T a(T paramT, g paramg, j paramj)
  {
    paramT = (m)paramT.a(i.e, null, null);
    try
    {
      paramT.a(i.c, paramg, paramj);
      paramT.e();
      return paramT;
    }
    catch (RuntimeException paramT)
    {
      if ((paramT.getCause() instanceof o)) {
        throw ((o)paramT.getCause());
      }
      throw paramT;
    }
  }
  
  protected static <T extends m<T, ?>> T a(T paramT, byte[] paramArrayOfByte)
  {
    paramT = a(paramT, paramArrayOfByte, j.a());
    if ((paramT != null) && (!paramT.f())) {
      throw new af().a().a(paramT);
    }
    return paramT;
  }
  
  /* Error */
  private static <T extends m<T, ?>> T a(T paramT, byte[] paramArrayOfByte, j paramj)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 99	com/b/b/g:a	([B)Lcom/b/b/g;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokestatic 101	com/b/b/m:a	(Lcom/b/b/m;Lcom/b/b/g;Lcom/b/b/j;)Lcom/b/b/m;
    //   11: astore_0
    //   12: aload_1
    //   13: iconst_0
    //   14: invokevirtual 104	com/b/b/g:a	(I)V
    //   17: aload_0
    //   18: areturn
    //   19: astore_1
    //   20: aload_1
    //   21: aload_0
    //   22: invokevirtual 93	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
    //   25: athrow
    //   26: astore_0
    //   27: aload_0
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	paramT	T
    //   0	29	1	paramArrayOfByte	byte[]
    //   0	29	2	paramj	j
    // Exception table:
    //   from	to	target	type
    //   12	17	19	com/b/b/o
    //   0	12	26	com/b/b/o
    //   20	26	26	com/b/b/o
  }
  
  protected static <E> n.b<E> a(n.b<E> paramb)
  {
    int i = paramb.size();
    if (i == 0) {
      i = 10;
    }
    for (;;)
    {
      return paramb.a(i);
      i *= 2;
    }
  }
  
  static Object a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if ((paramMethod instanceof RuntimeException)) {
        throw ((RuntimeException)paramMethod);
      }
      if ((paramMethod instanceof Error)) {
        throw ((Error)paramMethod);
      }
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
    }
  }
  
  protected static final <T extends m<T, ?>> boolean a(T paramT)
  {
    boolean bool = false;
    if (paramT.a(i.a, Boolean.valueOf(false), null) != null) {
      bool = true;
    }
    return bool;
  }
  
  protected static <E> n.b<E> h()
  {
    return y.d();
  }
  
  private MessageType l()
  {
    return (m)a(i.g, null, null);
  }
  
  protected final Object a(int paramInt)
  {
    return a(paramInt, null, null);
  }
  
  protected abstract Object a(int paramInt, Object paramObject1, Object paramObject2);
  
  final void a(j paramj, MessageType paramMessageType)
  {
    a(i.b, paramj, paramMessageType);
    this.b = paramj.a(this.b, paramMessageType.b);
  }
  
  public final x<MessageType> c()
  {
    return (x)a(i.h, null, null);
  }
  
  public final BuilderType d()
  {
    return (a)a(i.f, null, null);
  }
  
  protected final void e()
  {
    a(i.d, null, null);
    this.b.b();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if (!l().getClass().isInstance(paramObject)) {
        bool = false;
      } else {
        try
        {
          a(c.a, (m)paramObject);
        }
        catch (m.c.a paramObject)
        {
          bool = false;
        }
      }
    }
  }
  
  public final boolean f()
  {
    if (a(i.a, Boolean.TRUE, null) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final BuilderType g()
  {
    a locala = (a)a(i.f, null, null);
    locala.a(this);
    return locala;
  }
  
  public int hashCode()
  {
    if (this.a == 0)
    {
      g localg = new g((byte)0);
      a(localg, this);
      this.a = g.a(localg);
    }
    return this.a;
  }
  
  public String toString()
  {
    return w.a(this, super.toString());
  }
  
  public static abstract class a<MessageType extends m<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
    extends a.a<MessageType, BuilderType>
  {
    protected MessageType a;
    protected boolean b;
    private final MessageType c;
    
    protected a(MessageType paramMessageType)
    {
      this.c = paramMessageType;
      this.a = ((m)paramMessageType.a(m.i.e));
      this.b = false;
    }
    
    private BuilderType c(g paramg, j paramj)
    {
      b();
      try
      {
        this.a.a(m.i.c, paramg, paramj);
        return this;
      }
      catch (RuntimeException paramg)
      {
        if ((paramg.getCause() instanceof IOException)) {
          throw ((IOException)paramg.getCause());
        }
        throw paramg;
      }
    }
    
    private BuilderType e()
    {
      a locala = this.c.d();
      locala.a(g());
      return locala;
    }
    
    private MessageType g()
    {
      if (this.b) {}
      for (m localm = this.a;; localm = this.a)
      {
        return localm;
        this.a.e();
        this.b = true;
      }
    }
    
    public final BuilderType a(MessageType paramMessageType)
    {
      b();
      this.a.a(m.h.a, paramMessageType);
      return this;
    }
    
    protected final void b()
    {
      if (this.b)
      {
        m localm = (m)this.a.a(m.i.e);
        localm.a(m.h.a, this.a);
        this.a = localm;
        this.b = false;
      }
    }
    
    public final MessageType c()
    {
      m localm = g();
      if (!localm.f()) {
        throw new af();
      }
      return localm;
    }
    
    public final boolean f()
    {
      return m.a(this.a);
    }
  }
  
  protected static final class b<T extends m<T, ?>>
    extends b<T>
  {
    private T a;
    
    public b(T paramT)
    {
      this.a = paramT;
    }
  }
  
  static final class c
    implements m.j
  {
    static final c a = new c();
    static final a b = new a();
    
    public final int a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
    {
      if ((paramBoolean1 != paramBoolean2) || (paramInt1 != paramInt2)) {
        throw b;
      }
      return paramInt1;
    }
    
    public final ag a(ag paramag1, ag paramag2)
    {
      if (!paramag1.equals(paramag2)) {
        throw b;
      }
      return paramag1;
    }
    
    public final <T> n.b<T> a(n.b<T> paramb1, n.b<T> paramb2)
    {
      if (!paramb1.equals(paramb2)) {
        throw b;
      }
      return paramb1;
    }
    
    public final <K, V> t<K, V> a(t<K, V> paramt1, t<K, V> paramt2)
    {
      if (!paramt1.equals(paramt2)) {
        throw b;
      }
      return paramt1;
    }
    
    public final String a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
    {
      if ((paramBoolean1 != paramBoolean2) || (!paramString1.equals(paramString2))) {
        throw b;
      }
      return paramString1;
    }
    
    public final boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      if ((paramBoolean1 != paramBoolean3) || (paramBoolean2 != paramBoolean4)) {
        throw b;
      }
      return paramBoolean2;
    }
    
    static final class a
      extends RuntimeException
    {}
  }
  
  public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>>
    extends m<MessageType, BuilderType>
    implements m.e<MessageType, BuilderType>
  {
    protected k<m.f> d = k.a();
  }
  
  public static abstract interface e
    extends v
  {}
  
  static final class f
    implements k.a<f>
  {
    final int a;
    final ak.a b;
    final boolean c;
    
    public final ak.a a()
    {
      return this.b;
    }
    
    public final boolean b()
    {
      return this.c;
    }
  }
  
  private static final class g
    implements m.j
  {
    private int a = 0;
    
    public final int a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
    {
      this.a = (this.a * 53 + paramInt1);
      return paramInt1;
    }
    
    public final ag a(ag paramag1, ag paramag2)
    {
      this.a = (this.a * 53 + paramag1.hashCode());
      return paramag1;
    }
    
    public final <T> n.b<T> a(n.b<T> paramb1, n.b<T> paramb2)
    {
      this.a = (this.a * 53 + paramb1.hashCode());
      return paramb1;
    }
    
    public final <K, V> t<K, V> a(t<K, V> paramt1, t<K, V> paramt2)
    {
      this.a = (this.a * 53 + paramt1.hashCode());
      return paramt1;
    }
    
    public final String a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
    {
      this.a = (this.a * 53 + paramString1.hashCode());
      return paramString1;
    }
    
    public final boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.a = (this.a * 53 + n.a(paramBoolean2));
      return paramBoolean2;
    }
  }
  
  protected static final class h
    implements m.j
  {
    public static final h a = new h();
    
    public final int a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
    {
      if (paramBoolean2) {}
      for (;;)
      {
        return paramInt2;
        paramInt2 = paramInt1;
      }
    }
    
    public final ag a(ag paramag1, ag paramag2)
    {
      if (paramag2 == ag.a()) {}
      for (;;)
      {
        return paramag1;
        paramag1 = ag.a(paramag1, paramag2);
      }
    }
    
    public final <T> n.b<T> a(n.b<T> paramb1, n.b<T> paramb2)
    {
      int i = paramb1.size();
      int j = paramb2.size();
      Object localObject = paramb1;
      if (i > 0)
      {
        localObject = paramb1;
        if (j > 0)
        {
          localObject = paramb1;
          if (!paramb1.a()) {
            localObject = paramb1.a(j + i);
          }
          ((n.b)localObject).addAll(paramb2);
        }
      }
      if (i > 0) {
        paramb2 = (n.b<T>)localObject;
      }
      return paramb2;
    }
    
    public final <K, V> t<K, V> a(t<K, V> paramt1, t<K, V> paramt2)
    {
      Object localObject = paramt1;
      if (!paramt2.isEmpty())
      {
        localObject = paramt1;
        if (!paramt1.d()) {
          localObject = paramt1.b();
        }
        ((t)localObject).a(paramt2);
      }
      return (t<K, V>)localObject;
    }
    
    public final String a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
    {
      if (paramBoolean2) {}
      for (;;)
      {
        return paramString2;
        paramString2 = paramString1;
      }
    }
    
    public final boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      if (paramBoolean3) {
        paramBoolean2 = paramBoolean4;
      }
      for (;;)
      {
        return paramBoolean2;
      }
    }
  }
  
  public static enum i
  {
    public static int[] a()
    {
      return (int[])i.clone();
    }
  }
  
  protected static abstract interface j
  {
    public abstract int a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2);
    
    public abstract ag a(ag paramag1, ag paramag2);
    
    public abstract <T> n.b<T> a(n.b<T> paramb1, n.b<T> paramb2);
    
    public abstract <K, V> t<K, V> a(t<K, V> paramt1, t<K, V> paramt2);
    
    public abstract String a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2);
    
    public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */