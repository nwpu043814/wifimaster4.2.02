package cm.pass.sdk.net.a;

import a.a.a.c.b;
import org.json.JSONObject;

public class a
  extends i
{
  private cm.pass.sdk.interfaces.a a;
  
  public a(cm.pass.sdk.interfaces.a parama)
  {
    this.a = parama;
  }
  
  public void a(b paramb)
  {
    String str2 = null;
    super.a(paramb);
    try
    {
      if (this.c)
      {
        String str4 = this.g.getString("uniqueid");
        String str3 = this.g.getString("accesstoken");
        String str5 = this.g.getString("expiresin");
        if (!this.g.has("serviceid")) {
          break label209;
        }
        paramb = this.g.getString("serviceid");
        if (!this.g.has("servertime")) {
          break label204;
        }
        str1 = this.g.getString("servertime");
        if (this.g.has("account")) {
          str2 = this.g.getString("account");
        }
        if (this.g.has("passid")) {
          this.g.getString("passid");
        }
        this.a.a(this.c, this.d, this.e, str4, str3, str5, str2, paramb, str1);
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        paramb.printStackTrace();
        this.a.a(false, this.d, this.e, "", "", "", "", "", "");
        continue;
        label204:
        String str1 = null;
        continue;
        label209:
        paramb = null;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */