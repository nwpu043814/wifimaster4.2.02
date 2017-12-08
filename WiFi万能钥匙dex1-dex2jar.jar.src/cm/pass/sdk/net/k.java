package cm.pass.sdk.net;

import a.a.a.c.c;
import cm.pass.sdk.utils.e;

public class k
  extends a
{
  private String f;
  private String g;
  private String o;
  private String p;
  private String q;
  
  public k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, c paramc)
  {
    super(paramc);
    this.g = paramString1;
    this.f = paramString2;
    this.o = paramString3;
    this.p = paramString4;
    this.q = paramString5;
    c();
  }
  
  protected void a()
  {
    this.h = e.c;
  }
  
  protected void c()
  {
    this.e.append("&func=UAVerifyClientId");
    this.e.append("&clientid=");
    this.e.append(this.g);
    this.e.append("&redirecturi=");
    this.e.append(this.f);
    this.e.append("&account=");
    this.e.append(this.o);
    this.e.append("&imei=");
    this.e.append(this.p);
    this.e.append("&imsi=");
    this.e.append(this.q);
    this.e.append("&code=");
    this.e.append(a.a.a.a.a.a(this.b + this.c + this.a + this.g + this.f + this.o + this.p + this.q + this.d + "12345678").toUpperCase());
    this.h = this.e.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */