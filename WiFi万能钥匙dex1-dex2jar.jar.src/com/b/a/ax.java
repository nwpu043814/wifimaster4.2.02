package com.b.a;

final class ax<FIRST, SECOND>
{
  public final FIRST a;
  public final SECOND b;
  
  public ax(FIRST paramFIRST, SECOND paramSECOND)
  {
    this.a = paramFIRST;
    this.b = paramSECOND;
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramObject instanceof ax)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramObject = (ax)paramObject;
      bool1 = bool2;
      if (a(this.a, ((ax)paramObject).a))
      {
        bool1 = bool2;
        if (a(this.b, ((ax)paramObject).b)) {
          bool1 = true;
        }
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (this.a != null) {}
    for (int i = this.a.hashCode();; i = 0)
    {
      if (this.b != null) {
        j = this.b.hashCode();
      }
      return i * 17 + j * 17;
    }
  }
  
  public final String toString()
  {
    return String.format("{%s,%s}", new Object[] { this.a, this.b });
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */