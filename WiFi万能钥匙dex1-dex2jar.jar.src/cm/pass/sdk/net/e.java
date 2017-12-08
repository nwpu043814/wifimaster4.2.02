package cm.pass.sdk.net;

import a.a.a.c.c;
import cm.pass.sdk.utils.g;
import java.net.URLEncoder;

public class e
  extends a
{
  private String f;
  private String g;
  private String o;
  private String p;
  private String q;
  private String r = "1";
  private String s = "0";
  private String t;
  private String u;
  private int v;
  private String w;
  private String x;
  private String y;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, String paramString8, String paramString9, String paramString10, c paramc)
  {
    super(paramc);
    this.f = paramString1;
    this.g = paramString2;
    this.o = paramString3;
    this.p = paramString4;
    this.q = paramString5;
    this.t = paramString6;
    this.u = paramString7;
    this.v = paramInt;
    this.w = paramString8;
    this.x = paramString9;
    this.y = paramString10;
    c();
  }
  
  protected void a()
  {
    super.a();
  }
  
  protected void c()
  {
    try
    {
      this.e.append("&func=UAOAuthAndGetToken");
      this.e.append("&passid=");
      this.e.append(this.f);
      this.e.append("&clientid=");
      this.e.append(this.g);
      this.e.append("&clientsecret=");
      String str = g.a("12345678", this.y);
      this.e.append(URLEncoder.encode(str, "utf-8"));
      this.e.append("&redirecturi=");
      this.e.append(this.o);
      this.e.append("&relaystate=");
      this.e.append(this.p);
      this.e.append("&capaids=");
      this.e.append(this.q);
      this.e.append("&apptype=");
      this.e.append(this.r);
      this.e.append("&clienttype=");
      this.e.append(this.s);
      this.e.append("&appname=");
      this.e.append(this.t);
      this.e.append("&appsign=");
      this.e.append(this.u);
      this.e.append("&networktype=");
      this.e.append(this.v);
      this.e.append("&imei=");
      this.e.append(this.w);
      this.e.append("&imsi=");
      this.e.append(this.x);
      this.e.append("&code=");
      StringBuffer localStringBuffer = this.e;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuffer.append(a.a.a.a.a.a(this.b + this.c + this.a + this.f + this.g + str + this.o + this.p + this.q + this.r + this.s + this.t + this.u + this.v + this.w + this.x + this.d + "12345678").toUpperCase());
      this.h = this.e.toString();
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */