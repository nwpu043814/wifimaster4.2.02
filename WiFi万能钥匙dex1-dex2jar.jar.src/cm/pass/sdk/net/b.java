package cm.pass.sdk.net;

import a.a.a.c.c;
import android.content.Context;
import cm.pass.sdk.utils.q;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class b
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
  private String u = "0";
  private String v;
  
  public b(Context paramContext, c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    super(paramc);
    this.f = paramString1;
    this.g = paramString2;
    this.o = paramString3;
    this.p = paramString4;
    this.q = paramString5;
    this.r = paramString6;
    this.s = q.a(paramContext);
    this.t = paramString8;
    this.v = paramString9;
    c();
  }
  
  protected void c()
  {
    try
    {
      this.e.append("&func=UAGetKsByOAuthToken");
      this.e.append("&accesstoken=");
      this.e.append(URLEncoder.encode(this.f, "utf-8"));
      this.e.append("&uniqueid=");
      this.e.append(URLEncoder.encode(this.g, "utf-8"));
      this.e.append("&clientid=");
      this.e.append(this.o);
      this.e.append("&cnonce=");
      this.e.append(URLEncoder.encode(this.p, "utf-8"));
      this.e.append("&timestamp=");
      this.e.append(this.q);
      this.e.append("&keytoken=");
      this.e.append(this.r);
      this.e.append("&imei=");
      this.e.append(this.s);
      this.e.append("&imsi=");
      this.e.append(this.t);
      this.e.append("&clienttype=");
      this.e.append(this.u);
      this.e.append("&expiresin=");
      this.e.append(this.v);
      this.e.append("&code=");
      StringBuffer localStringBuffer = this.e;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuffer.append(a.a.a.a.a.a(this.b + this.c + this.a + this.f + this.g + this.o + this.p + this.q + this.r + this.s + this.t + this.u + this.v + this.d + "12345678").toUpperCase());
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */