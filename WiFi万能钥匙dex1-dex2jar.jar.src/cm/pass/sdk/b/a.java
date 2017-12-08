package cm.pass.sdk.b;

import java.io.Serializable;

public class a
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public void g(String paramString)
  {
    if (paramString.equals("0")) {
      this.g = "CMNET";
    }
    for (;;)
    {
      return;
      if (paramString.equals("1")) {
        this.g = "CMWAP";
      } else if (paramString.equals("2")) {
        this.g = "WIFI";
      } else if (paramString.equals("3")) {
        this.g = "MOBILE";
      } else {
        this.g = "NONE";
      }
    }
  }
  
  public String h()
  {
    return this.h;
  }
  
  public void h(String paramString)
  {
    this.h = paramString;
  }
  
  public String i()
  {
    return this.i;
  }
  
  public void i(String paramString)
  {
    this.i = paramString;
  }
  
  public String j()
  {
    return this.j;
  }
  
  public void j(String paramString)
  {
    this.j = paramString;
  }
  
  public String k()
  {
    return this.k;
  }
  
  public void k(String paramString)
  {
    this.k = paramString;
  }
  
  public String l()
  {
    return this.l;
  }
  
  public void l(String paramString)
  {
    this.l = paramString;
  }
  
  public String m()
  {
    return this.m;
  }
  
  public void m(String paramString)
  {
    this.m = paramString;
  }
  
  public String n()
  {
    return this.n;
  }
  
  public void n(String paramString)
  {
    this.n = paramString;
  }
  
  public String o()
  {
    return this.o;
  }
  
  public void o(String paramString)
  {
    this.o = paramString;
  }
  
  public String p()
  {
    return this.p;
  }
  
  public void p(String paramString)
  {
    this.p = paramString;
  }
  
  public String q()
  {
    return this.q;
  }
  
  public void q(String paramString)
  {
    this.q = paramString;
  }
  
  public String toString()
  {
    return " --------------------- LogInfo ---------------------  \nimsi=" + this.a + ", \nimei=" + this.b + ", \noperactiontype=" + this.c + ", \nsessionId=" + this.d + ", \nloginType=" + this.e + ", \nauthType=" + this.f + ", \nnetworkType=" + this.g + ", \naccount=" + this.h + ", \nclientId=" + this.i + ", \nauthStartTime=" + this.j + ", \nauthEndTime=" + this.k + ", \nserviceId=" + this.l + ", \nserverTime=" + this.m + ", \ntimes=" + this.n + ", \nresultCode=" + this.o + ", \nopdesc=" + this.p + ", \nsimOperator=" + this.q + "\n------------------------------------------------------------ ";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */