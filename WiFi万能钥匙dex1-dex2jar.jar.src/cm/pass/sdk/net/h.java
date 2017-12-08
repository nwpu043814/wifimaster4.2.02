package cm.pass.sdk.net;

import a.a.a.c.c;
import android.content.Context;
import cm.pass.sdk.utils.e;
import cm.pass.sdk.utils.r;

public class h
  extends a
{
  private String f;
  private String g;
  private String o;
  private String p;
  
  public h(Context paramContext, String paramString1, String paramString2, String paramString3, c paramc)
  {
    super(paramc);
    this.f = paramString1;
    this.g = paramString2;
    this.o = paramString3;
    this.p = r.b(paramContext);
    this.g = "1";
    c();
  }
  
  protected void a()
  {
    this.h = e.c;
  }
  
  protected void c()
  {
    this.e.append("&func=UAGetPubKey");
    this.e.append("&account=");
    this.e.append(this.f);
    this.e.append("&authtype=");
    this.e.append(this.g);
    this.e.append("&clientid=");
    this.e.append(this.o);
    this.e.append("&networktype=");
    this.e.append(this.p);
    this.e.append("&code=");
    this.e.append(a.a.a.a.a.a(this.b + this.c + this.a + this.f + this.g + this.o + this.p + this.d + "12345678").toUpperCase());
    this.h = this.e.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */