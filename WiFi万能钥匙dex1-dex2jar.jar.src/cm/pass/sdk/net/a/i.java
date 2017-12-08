package cm.pass.sdk.net.a;

import a.a.a.c.b;
import a.a.a.c.c;
import cm.pass.sdk.net.a;
import org.json.JSONObject;

public class i
  implements c
{
  protected boolean c;
  protected String d = "102101";
  protected String e = "";
  protected String f;
  public JSONObject g;
  
  public void a(b paramb)
  {
    paramb = ((a)paramb).g();
    this.g = paramb;
    if (paramb != null)
    {
      this.d = paramb.optString("resultcode");
      this.c = "000".equals(this.d);
      this.e = this.g.optString("desc", "网络异常");
      if (paramb.has("expandparams")) {
        this.f = this.g.optString("expandparams");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */