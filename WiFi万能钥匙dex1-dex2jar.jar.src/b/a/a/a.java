package b.a.a;

import java.io.Serializable;

public class a
  implements Serializable
{
  private static final String a = a.class.getSimpleName();
  private String b;
  private String c;
  private String d;
  private long e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  public final String a()
  {
    return this.b;
  }
  
  public final void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public final void a(String paramString)
  {
    this.b = paramString;
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final void b(String paramString)
  {
    this.c = paramString;
  }
  
  public final String c()
  {
    return this.d;
  }
  
  public final void c(String paramString)
  {
    this.d = paramString;
  }
  
  public final long d()
  {
    return this.e;
  }
  
  public final void d(String paramString)
  {
    this.f = paramString;
  }
  
  public final String e()
  {
    return this.g;
  }
  
  public final void e(String paramString)
  {
    this.g = paramString;
  }
  
  public boolean equals(Object paramObject)
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
        paramObject = (a)paramObject;
        if (this.b == null)
        {
          if (((a)paramObject).b != null) {
            bool = false;
          }
        }
        else if (!this.b.equals(((a)paramObject).b))
        {
          bool = false;
          continue;
        }
        if (this.g == null)
        {
          if (((a)paramObject).g != null) {
            bool = false;
          }
        }
        else if (!this.g.equals(((a)paramObject).g)) {
          bool = false;
        }
      }
    }
  }
  
  public final String f()
  {
    return this.i;
  }
  
  public final void f(String paramString)
  {
    this.h = paramString;
  }
  
  public final String g()
  {
    return this.j;
  }
  
  public final void g(String paramString)
  {
    this.i = paramString;
  }
  
  public final String h()
  {
    return this.k;
  }
  
  public final void h(String paramString)
  {
    this.j = paramString;
  }
  
  public int hashCode()
  {
    int n = 0;
    int m;
    if (this.b == null)
    {
      m = 0;
      if (this.g != null) {
        break label39;
      }
    }
    for (;;)
    {
      return (m + 31) * 31 + n;
      m = this.b.hashCode();
      break;
      label39:
      n = this.g.hashCode();
    }
  }
  
  public final void i(String paramString)
  {
    this.k = paramString;
  }
  
  public String toString()
  {
    return "SsoAccount [accountName=" + this.b + ", \nalias=" + this.c + ", \nks=" + this.d + ", \nloginTime=" + this.e + ", \nexpiresTime=" + this.f + ", \npassid=" + this.g + ", \nuid=" + this.h + ", \nimsi=" + this.i + ", \nimei=" + this.j + ", \nauthType=" + this.k + "]";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/b/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */