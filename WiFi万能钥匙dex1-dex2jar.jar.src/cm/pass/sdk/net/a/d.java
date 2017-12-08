package cm.pass.sdk.net.a;

import a.a.a.c.b;
import cm.pass.sdk.interfaces.i;
import org.json.JSONObject;

public class d
  extends h
{
  private i f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  
  public d(i parami)
  {
    this.f = parami;
  }
  
  public void a(b paramb)
  {
    super.a(paramb);
    try
    {
      if (this.e.has("gatewayauth_cm")) {
        this.g = this.e.optString("gatewayauth_cm");
      }
      if (this.e.has("gatewayauth_cu")) {
        this.h = this.e.optString("gatewayauth_cu");
      }
      if (this.e.has("gatewayauth_ct")) {
        this.i = this.e.optString("gatewayauth_ct");
      }
      if (this.e.has("smsup_cm")) {
        this.j = this.e.optString("smsup_cm");
      }
      if (this.e.has("smsup_cu")) {
        this.k = this.e.optString("smsup_cu");
      }
      if (this.e.has("smsup_ct")) {
        this.l = this.e.optString("smsup_ct");
      }
      if (this.e.has("logindelay_cm")) {
        this.m = this.e.optString("logindelay_cm");
      }
      if (this.e.has("logindelay_cu")) {
        this.n = this.e.optString("logindelay_cu");
      }
      if (this.e.has("logindelay_ct")) {
        this.o = this.e.optString("logindelay_ct");
      }
      if (this.e.has("expandparams")) {
        this.p = this.e.optString("expandparams");
      }
      if (this.e.has("code")) {
        this.q = this.e.optString("code");
      }
      int i3 = Integer.parseInt(this.m);
      int i2 = Integer.parseInt(this.n);
      int i1 = Integer.parseInt(this.o);
      this.f.a(this.a, this.b, this.c, this.g, this.h, this.i, this.j, this.k, this.l, i3, i2, i1, this.p, this.q);
      return;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        this.f.a(this.a, this.b, this.c, this.g, this.h, this.i, this.j, this.k, this.l, 5, 8, 8, this.p, this.q);
        paramb.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */