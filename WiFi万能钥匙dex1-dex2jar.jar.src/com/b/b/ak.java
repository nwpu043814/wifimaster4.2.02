package com.b.b;

public final class ak
{
  static final int a = 11;
  static final int b = 12;
  static final int c = 16;
  static final int d = 26;
  
  public static int a(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  static Object a(g paramg, a parama, c paramc)
  {
    switch (al.a[parama.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1: 
      paramg = Double.valueOf(paramg.b());
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
      for (;;)
      {
        return paramg;
        paramg = Float.valueOf(paramg.c());
        continue;
        paramg = Long.valueOf(paramg.e());
        continue;
        paramg = Long.valueOf(paramg.d());
        continue;
        paramg = Integer.valueOf(paramg.f());
        continue;
        paramg = Long.valueOf(paramg.g());
        continue;
        paramg = Integer.valueOf(paramg.h());
        continue;
        paramg = Boolean.valueOf(paramg.i());
        continue;
        paramg = paramg.l();
        continue;
        paramg = Integer.valueOf(paramg.m());
        continue;
        paramg = Integer.valueOf(paramg.o());
        continue;
        paramg = Long.valueOf(paramg.p());
        continue;
        paramg = Integer.valueOf(paramg.q());
        continue;
        paramg = Long.valueOf(paramg.r());
        continue;
        paramg = paramc.a(paramg);
      }
    case 16: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case 17: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    }
    throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
  }
  
  public static int b(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  public static enum a
  {
    private final ak.b s;
    private final int t;
    
    private a(ak.b paramb, int paramInt)
    {
      this.s = paramb;
      this.t = paramInt;
    }
    
    public final ak.b a()
    {
      return this.s;
    }
    
    public final int b()
    {
      return this.t;
    }
  }
  
  public static enum b
  {
    private final Object j;
    
    private b(Object paramObject)
    {
      this.j = paramObject;
    }
  }
  
  static abstract enum c
  {
    private c() {}
    
    abstract Object a(g paramg);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */