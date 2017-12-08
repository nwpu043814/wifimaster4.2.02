package cm.pass.sdk.net.a;

import a.a.a.c.b;
import cm.pass.sdk.interfaces.f;
import org.json.JSONObject;

public class e
  extends h
{
  private static String f = e.class.getSimpleName();
  private f g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p = "";
  private String q = "";
  
  public e(f paramf)
  {
    this.g = paramf;
  }
  
  public void a(b paramb)
  {
    super.a(paramb);
    try
    {
      if (this.e != null)
      {
        if (this.e.has("serviceid")) {
          this.p = this.e.optString("serviceid");
        }
        if (this.e.has("servertime")) {
          this.q = this.e.optString("servertime");
        }
        this.h = this.e.optString("sourceid");
        this.i = this.e.optString("appid");
        this.j = this.e.optString("unikey");
        this.k = this.e.optString("mobilekey");
        this.l = this.e.optString("state");
        this.m = this.e.optString("securityphone");
        this.n = this.e.optString("expandparams");
        this.o = this.e.optString("code");
        if ("".equals(this.k)) {
          this.k = this.e.optString("phone");
        }
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        paramb.printStackTrace();
      }
    }
    this.g.a(this.a, this.b, this.c, this.h, this.i, this.p, this.q, this.j, this.k, this.m, this.l, this.n, this.o, "1");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */