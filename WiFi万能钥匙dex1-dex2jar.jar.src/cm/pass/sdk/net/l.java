package cm.pass.sdk.net;

import a.a.a.c.c;
import cm.pass.sdk.utils.e;
import cm.pass.sdk.utils.g;
import cm.pass.sdk.utils.j;
import java.net.URLEncoder;

public class l
  extends a
{
  private String f;
  private String g;
  private String o;
  private String p;
  private String q = "0";
  private String r;
  private String s;
  private int t;
  private String u;
  private String v;
  private int w = 1;
  
  public l(c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8)
  {
    super(paramc);
    this.o = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    if (this.g.equals("3")) {
      this.g = "1";
    }
    for (;;)
    {
      this.p = paramString4;
      this.r = paramString5;
      this.s = paramString6;
      this.t = paramInt;
      this.u = paramString7;
      this.v = paramString8;
      c();
      return;
      if (paramString3.equals("4")) {
        this.g = "2";
      } else if (this.g.equals("2")) {
        this.g = "3";
      }
    }
  }
  
  protected void a()
  {
    this.h = e.e;
  }
  
  protected void c()
  {
    try
    {
      this.e.append("&func=UAVerifyLocalMobile");
      this.e.append("&mobile=");
      this.e.append(this.f);
      this.e.append("&authtype=");
      this.e.append(this.g);
      this.e.append("&clientid=");
      this.e.append(this.o);
      this.e.append("&clientsecret=");
      String str = g.a("12345678", this.p);
      this.e.append(URLEncoder.encode(str, "utf-8"));
      this.e.append("&clienttype=");
      this.e.append(this.q);
      this.e.append("&appname=");
      this.e.append(this.r);
      this.e.append("&appsign=");
      this.e.append(this.s);
      this.e.append("&networktype=");
      this.e.append(this.t);
      this.e.append("&imei=");
      this.e.append(this.u);
      this.e.append("&imsi=");
      this.e.append(this.v);
      this.e.append("&times=");
      this.e.append(this.w);
      this.e.append("&code=");
      StringBuffer localStringBuffer = this.e;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuffer.append(a.a.a.a.a.a(this.b + this.c + this.a + this.f + this.g + this.o + str + this.q + this.r + this.s + this.t + this.u + this.v + this.w + this.d + "12345678").toUpperCase());
      this.h = this.e.toString();
      j.a("verifymobileUrl", this.h);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */