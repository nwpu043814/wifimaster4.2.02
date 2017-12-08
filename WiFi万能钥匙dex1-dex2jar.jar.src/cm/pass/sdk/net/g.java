package cm.pass.sdk.net;

import a.a.a.c.c;
import cm.pass.sdk.utils.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class g
  extends a
{
  private String A;
  private String f;
  private String g;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private int u = 1;
  private String v = "1";
  private String w = "0";
  private String x;
  private String y;
  private int z;
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt, String paramString11, c paramc)
  {
    super(paramc);
    this.f = paramString1;
    this.g = paramString2;
    this.o = paramString3;
    if (this.o.equals("3")) {
      this.o = "1";
    }
    for (;;)
    {
      this.p = paramString4;
      this.q = paramString5;
      this.r = paramString6;
      this.s = paramString7;
      this.t = paramString8;
      this.x = paramString9;
      this.y = paramString10;
      this.z = paramInt;
      this.A = paramString11;
      c();
      return;
      if (this.o.equals("4")) {
        this.o = "2";
      } else if (this.o.equals("2")) {
        this.o = "3";
      }
    }
  }
  
  protected void a()
  {
    this.h = e.c;
  }
  
  protected void c()
  {
    try
    {
      this.e.append("&func=UAGetOAuthTokenByQA");
      this.e.append("&account=");
      this.e.append(this.f);
      this.e.append("&passwd=");
      String str2 = cm.pass.sdk.utils.g.a("12345678", this.g);
      this.e.append(URLEncoder.encode(str2, "utf-8"));
      this.e.append("&authtype=");
      this.e.append(this.o);
      this.e.append("&clientid=");
      this.e.append(this.p);
      this.e.append("&clientsecret=");
      String str1 = cm.pass.sdk.utils.g.a("12345678", this.q);
      this.e.append(URLEncoder.encode(str1, "utf-8"));
      this.e.append("&apptype=");
      this.e.append(this.v);
      this.e.append("&clienttype=");
      this.e.append(this.w);
      this.e.append("&appname=");
      this.e.append(this.x);
      this.e.append("&appsign=");
      this.e.append(this.y);
      this.e.append("&redirecturi=");
      this.e.append(URLEncoder.encode(this.r, "utf-8"));
      this.e.append("&relaystate=");
      this.e.append(this.s);
      this.e.append("&capaids=");
      this.e.append(this.t);
      this.e.append("&networktype=");
      this.e.append(this.z);
      this.e.append("&imei=");
      this.e.append(this.A);
      this.e.append("&times=");
      this.e.append(this.u);
      this.e.append("&code=");
      StringBuffer localStringBuffer = this.e;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuffer.append(a.a.a.a.a.a(this.b + this.c + this.a + this.f + str2 + this.o + this.p + str1 + this.r + this.s + this.t + this.v + this.w + this.x + this.y + this.z + this.A + this.u + this.d + "12345678").toUpperCase());
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */