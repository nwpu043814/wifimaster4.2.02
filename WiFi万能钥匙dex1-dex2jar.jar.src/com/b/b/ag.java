package com.b.b;

import java.util.Arrays;

public final class ag
{
  private static final ag a = new ag(0, new int[0], new Object[0], false);
  private int b;
  private int[] c;
  private Object[] d;
  private int e = -1;
  private boolean f;
  
  private ag()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private ag(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.b = paramInt;
    this.c = paramArrayOfInt;
    this.d = paramArrayOfObject;
    this.f = paramBoolean;
  }
  
  public static ag a()
  {
    return a;
  }
  
  static ag a(ag paramag1, ag paramag2)
  {
    int i = paramag1.b + paramag2.b;
    int[] arrayOfInt = Arrays.copyOf(paramag1.c, i);
    System.arraycopy(paramag2.c, 0, arrayOfInt, paramag1.b, paramag2.b);
    Object[] arrayOfObject = Arrays.copyOf(paramag1.d, i);
    System.arraycopy(paramag2.d, 0, arrayOfObject, paramag1.b, paramag2.b);
    return new ag(i, arrayOfInt, arrayOfObject, true);
  }
  
  final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < this.b; i++) {
      w.a(paramStringBuilder, paramInt, String.valueOf(ak.b(this.c[i])), this.d[i]);
    }
  }
  
  public final void b()
  {
    this.f = false;
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
      else if (!(paramObject instanceof ag))
      {
        bool = false;
      }
      else
      {
        paramObject = (ag)paramObject;
        if ((this.b != ((ag)paramObject).b) || (!Arrays.equals(this.c, ((ag)paramObject).c)) || (!Arrays.deepEquals(this.d, ((ag)paramObject).d))) {
          bool = false;
        }
      }
    }
  }
  
  public final int hashCode()
  {
    return ((this.b + 527) * 31 + Arrays.hashCode(this.c)) * 31 + Arrays.deepHashCode(this.d);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */