package cm.pass.sdk.net;

import a.a.a.c.b;
import a.a.a.c.c;
import cm.pass.sdk.utils.e;
import cm.pass.sdk.utils.j;
import org.json.JSONObject;

public abstract class a
  extends b
{
  protected String a = "umcsdk_outer_v1.5.0";
  protected String b = "2.0";
  protected String c = "999";
  protected long d = System.currentTimeMillis();
  protected StringBuffer e;
  private String f = getClass().getName();
  private JSONObject g;
  
  public a(c paramc)
  {
    super(paramc);
    b();
  }
  
  protected void a()
  {
    this.h = e.c;
  }
  
  protected void b()
  {
    this.e = new StringBuffer(this.h);
    this.e.append("ver=");
    this.e.append(this.b);
    this.e.append("&sourceid=");
    this.e.append(this.c);
    this.e.append("&appid=");
    this.e.append(this.a);
    this.e.append("&rnd=");
    this.e.append(this.d);
  }
  
  protected abstract void c();
  
  protected void d() {}
  
  public String e()
  {
    return null;
  }
  
  public void f()
  {
    if (this.m != null) {}
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(this.m);
      this.g = localJSONObject;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        j.a(this.f, "invalidate json format:" + this.m);
      }
    }
  }
  
  public JSONObject g()
  {
    return this.g;
  }
  
  public String toString()
  {
    return "BaseEntity [TAG=" + this.f + ", verNo=" + this.b + ", sourceId=" + this.c + ", rnd=" + this.d + ", urlBuffer=" + this.e + ", result=" + this.g + ", url=" + this.h + ", flag=" + this.i + ", sentStatus=" + this.j + ", http_ResponseCode=" + this.k + ", httpHeaders=" + this.l + ", receiveData=" + this.m + ", receiveHeaders=" + this.n + ", getSendData()=" + e() + ", getResult()=" + g() + "]";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */