package cm.pass.sdk.net;

import a.a.a.c.c;
import cm.pass.sdk.utils.g;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class f
  extends a
{
  private String f;
  private String g;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x = "0";
  private String y;
  
  public f(c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    super(paramc);
    this.f = paramString1;
    this.g = paramString2;
    this.o = paramString4;
    this.p = paramString5;
    this.q = paramString6;
    this.r = paramString7;
    this.s = paramString8;
    this.t = paramString9;
    this.u = paramString10;
    this.v = paramString11;
    this.w = paramString12;
    this.y = paramString3;
    c();
  }
  
  protected void c()
  {
    try
    {
      this.e.append("&func=UAGetOAuthTokenByKs");
      this.e.append("&passid=");
      this.e.append(this.f);
      this.e.append("&token=");
      this.e.append(URLEncoder.encode(this.g, "utf-8"));
      this.e.append("&token_nonce=");
      this.e.append(this.o);
      this.e.append("&token_timestamp=");
      this.e.append(this.p);
      this.e.append("&login_type=");
      this.e.append(this.y);
      this.e.append("&imei=");
      this.e.append(this.t);
      this.e.append("&imsi=");
      this.e.append(this.u);
      this.e.append("&clientid=");
      this.e.append(this.q);
      this.e.append("&clientsecret=");
      String str = g.a("12345678", this.r);
      this.e.append(URLEncoder.encode(str, "utf-8"));
      this.e.append("&redirecturi=");
      this.e.append(URLEncoder.encode(this.s, "utf-8"));
      this.e.append("&clienttype=");
      this.e.append(this.x);
      this.e.append("&appname=");
      this.e.append(this.v);
      this.e.append("&appsign=");
      this.e.append(this.w);
      this.e.append("&code=");
      StringBuffer localStringBuffer = this.e;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuffer.append(a.a.a.a.a.a(this.b + this.c + this.a + this.f + this.g + this.o + this.p + this.y + this.t + this.u + this.q + str + this.s + this.x + this.v + this.w + this.d + "12345678").toUpperCase());
      this.h = this.e.toString();
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */