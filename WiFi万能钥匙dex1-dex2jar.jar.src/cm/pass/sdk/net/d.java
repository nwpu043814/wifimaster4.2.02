package cm.pass.sdk.net;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import cm.pass.sdk.net.a.h;
import cm.pass.sdk.utils.e;
import cm.pass.sdk.utils.l;
import cm.pass.sdk.utils.r;
import cm.pass.sdk.utils.t;
import java.net.URLEncoder;

public class d
  extends m
{
  private String A;
  private String B;
  private String C = Build.BRAND;
  private String D = Build.MODEL;
  private String E = "android" + Build.VERSION.RELEASE;
  private Context o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private String y;
  private String z;
  
  public d(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, h paramh)
  {
    super(paramContext, paramh);
    this.o = paramContext;
    this.p = paramString1;
    this.A = paramString2;
    this.B = paramString3;
    this.q = l.a(this.o).d();
    this.r = cm.pass.sdk.utils.m.a(paramContext).a();
    this.s = cm.pass.sdk.utils.m.a(paramContext).b();
    this.t = "0";
    this.u = r.d(this.o);
    this.v = paramString4;
    this.w = paramString5;
    this.x = "";
    this.y = paramString6;
    this.z = t.b();
    b();
  }
  
  protected void a()
  {
    this.h = e.d;
  }
  
  protected void b()
  {
    try
    {
      this.f.append("ver=");
      this.f.append(this.c);
      this.f.append("&sourceid=");
      this.f.append(this.d);
      this.f.append("&appid=");
      this.f.append(this.p);
      this.f.append("&clientver=");
      this.f.append(this.q);
      this.f.append("&sdkver=");
      this.f.append(this.b);
      this.f.append("&authtype=");
      this.f.append(this.A);
      this.f.append("&smskey=");
      String str = cm.pass.sdk.utils.a.a(this.B, "vy7580");
      this.f.append(URLEncoder.encode(str, "UTF-8"));
      this.f.append("&imsi=");
      this.f.append(this.r);
      this.f.append("&imei=");
      this.f.append(this.s);
      this.f.append("&mobilebrand=");
      this.f.append(URLEncoder.encode(this.C, "UTF-8"));
      this.f.append("&mobilemodel=");
      this.f.append(URLEncoder.encode(this.D, "UTF-8"));
      this.f.append("&mobilesystem=");
      this.f.append(URLEncoder.encode(this.E, "UTF-8"));
      this.f.append("&clienttype=");
      this.f.append(this.t);
      this.f.append("&operatortype=");
      this.f.append(this.u);
      this.f.append("&unikey=");
      this.f.append(this.v);
      this.f.append("&redirecturl=");
      this.f.append(URLEncoder.encode(this.w, "UTF-8"));
      this.f.append("&state=");
      this.f.append(this.x);
      this.f.append("&expandparams=");
      this.f.append(this.y);
      this.f.append("&timestamp=");
      this.f.append(this.z);
      this.f.append("&code=");
      StringBuffer localStringBuffer = this.f;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuffer.append(a.a.a.a.a.a(this.c + this.d + this.p + this.q + this.b + this.A + str + this.r + this.s + this.C + this.D + this.E + this.t + this.u + this.v + this.w + this.x + this.y + this.z + "12345678").toUpperCase());
      this.h = this.f.toString();
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */