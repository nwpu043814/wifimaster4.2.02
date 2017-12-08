package cm.pass.sdk.net;

import a.a.a.c.b;
import a.a.a.c.c;
import android.content.Context;
import cm.pass.sdk.utils.e;
import cm.pass.sdk.utils.j;
import org.json.JSONObject;

public class m
  extends b
{
  protected String a = "ImpEntity";
  protected String b = "umcsdk_outer_v1.5.0";
  protected String c = "2.0";
  protected String d = "999";
  protected long e = System.currentTimeMillis();
  protected StringBuffer f = new StringBuffer(this.h);
  public boolean g = false;
  private JSONObject o;
  
  public m(Context paramContext, c paramc)
  {
    super(paramc);
  }
  
  protected void a()
  {
    this.h = e.c;
  }
  
  public JSONObject c()
  {
    return this.o;
  }
  
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
      this.g = true;
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(this.m);
      this.o = localJSONObject;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.g = false;
        j.a(this.a, "invalidate json format:" + this.m);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */