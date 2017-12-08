package c.a.a;

import java.util.Arrays;

public abstract class u
{
  private final int a;
  
  public u(int paramInt)
  {
    this.a = bt.a("code", paramInt);
  }
  
  private byte[] b()
  {
    s locals = new s((byte)0);
    a(locals);
    return locals.b();
  }
  
  abstract String a();
  
  abstract void a(q paramq);
  
  abstract void a(s params);
  
  final void b(s params)
  {
    params.c(this.a);
    int i = params.a();
    params.c(0);
    a(params);
    params.a(params.a() - i - 2, i);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if ((paramObject instanceof u)) {
        break label19;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label19:
      paramObject = (u)paramObject;
      bool1 = bool2;
      if (this.a == ((u)paramObject).a) {
        bool1 = Arrays.equals(b(), ((u)paramObject).b());
      }
    }
  }
  
  public int hashCode()
  {
    int j = 0;
    byte[] arrayOfByte = b();
    int i = 0;
    while (j < arrayOfByte.length)
    {
      i += (i << 3) + (arrayOfByte[j] & 0xFF);
      j++;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append(a.a(this.a));
    localStringBuffer.append(": ");
    localStringBuffer.append(a());
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
  
  public static final class a
  {
    private static av a;
    
    static
    {
      av localav = new av("EDNS Option Codes", 2);
      a = localav;
      localav.b(65535);
      a.a("CODE");
      a.a();
      a.a(3, "NSID");
      a.a(8, "CLIENT_SUBNET");
    }
    
    public static String a(int paramInt)
    {
      return a.d(paramInt);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */