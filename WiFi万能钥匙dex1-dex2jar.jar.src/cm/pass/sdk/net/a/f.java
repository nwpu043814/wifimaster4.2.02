package cm.pass.sdk.net.a;

import a.a.a.c.b;
import cm.pass.sdk.interfaces.c;
import org.json.JSONObject;

public class f
  extends i
{
  private c a;
  private String b = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  
  public f(c paramc)
  {
    this.a = paramc;
  }
  
  public void a(b paramb)
  {
    super.a(paramb);
    try
    {
      if (this.g.has("serviceid")) {
        this.i = this.g.optString("serviceid");
      }
      if (this.g.has("servertime")) {
        this.j = this.g.optString("servertime");
      }
      if (this.g.has("successauthtype")) {
        this.k = this.g.optString("successauthtype");
      }
      if (this.c)
      {
        paramb = this.g.getString("uniqueid");
        String str2 = this.g.getString("accesstoken");
        String str1 = this.g.getString("expiresin");
        if (this.g.has("account")) {
          this.b = this.g.getString("account");
        }
        if (this.g.has("passid")) {
          this.h = this.g.optString("passid");
        }
        this.a.a(this.c, this.d, this.e, paramb, str2, str1, this.b, this.h, this.i, this.j, this.k, "", "3");
        return;
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        paramb.printStackTrace();
        this.a.a(false, this.d, this.e, "", "", "", "", null, this.i, this.j, this.k, "", "3");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */