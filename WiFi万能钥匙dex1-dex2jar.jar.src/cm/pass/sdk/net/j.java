package cm.pass.sdk.net;

import a.a.a.c.c;
import android.os.Build;
import android.os.Build.VERSION;
import cm.pass.sdk.utils.e;
import java.net.URLEncoder;

public class j
  extends a
{
  private cm.pass.sdk.b.a f;
  private String g = Build.BRAND;
  private String o = Build.MODEL;
  private String p = "android" + Build.VERSION.RELEASE;
  private String q = "0";
  
  public j(c paramc, cm.pass.sdk.b.a parama)
  {
    super(paramc);
    this.f = parama;
    c();
  }
  
  protected void a()
  {
    this.h = e.m;
  }
  
  protected void c()
  {
    try
    {
      this.e.append("&imsi=");
      this.e.append(this.f.a());
      this.e.append("&imei=");
      this.e.append(this.f.b());
      this.e.append("&operactiontype=");
      this.e.append(this.f.c());
      this.e.append("&sdkrequestid=");
      this.e.append(this.f.d());
      this.e.append("&logintype=");
      this.e.append(this.f.e());
      this.e.append("&authtype=");
      this.e.append(this.f.f());
      this.e.append("&networktype=");
      this.e.append(this.f.g());
      this.e.append("&account=");
      this.e.append(this.f.h());
      this.e.append("&clientid=");
      this.e.append(this.f.i());
      this.e.append("&mobilebrand=");
      this.e.append(URLEncoder.encode(this.g, "utf-8"));
      this.e.append("&mobilemodel=");
      this.e.append(URLEncoder.encode(this.o, "utf-8"));
      this.e.append("&mobilesystem=");
      this.e.append(this.p);
      this.e.append("&clienttype=");
      this.e.append(this.q);
      this.e.append("&authstarttime=");
      this.e.append(this.f.j());
      this.e.append("&authendtime=");
      this.e.append(this.f.k());
      this.e.append("&serviceid=");
      this.e.append(this.f.l());
      this.e.append("&servertime=");
      this.e.append(this.f.m());
      this.e.append("&times=");
      this.e.append(this.f.n());
      this.e.append("&resultcode=");
      this.e.append(this.f.o());
      this.e.append("&opdesc=");
      this.e.append(URLEncoder.encode(this.f.p(), "utf-8"));
      this.e.append("&operatortype=");
      this.e.append(this.f.q());
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("描述：");
      cm.pass.sdk.utils.j.e("SendLoginfoEntity", this.f.p());
      this.e.append("&code=");
      localObject = this.e;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      ((StringBuffer)localObject).append(a.a.a.a.a.a(this.b + this.c + this.a + this.f.a() + this.f.b() + this.f.c() + this.f.d() + this.f.e() + this.f.f() + this.f.g() + this.f.h() + this.f.i() + this.g + this.o + this.p + this.q + this.f.j() + this.f.k() + this.f.l() + this.f.m() + this.f.n() + this.f.o() + this.f.p() + this.f.q() + this.d + "12345678").toUpperCase());
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */