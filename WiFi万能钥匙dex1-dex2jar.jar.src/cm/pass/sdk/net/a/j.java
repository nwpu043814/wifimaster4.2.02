package cm.pass.sdk.net.a;

import a.a.a.c.b;
import cm.pass.sdk.interfaces.h;
import org.json.JSONObject;

public class j
  extends i
{
  public static boolean a;
  public static String b;
  private h h;
  
  public j(h paramh)
  {
    this.h = paramh;
  }
  
  public void a(b paramb)
  {
    String str = null;
    super.a(paramb);
    try
    {
      if ((this.c) && (this.g != null))
      {
        if (!this.g.has("relayState")) {
          break label156;
        }
        paramb = this.g.getString("relayState");
        if (this.g.has("capaids"))
        {
          str = this.g.getString("capaids");
          b = str;
        }
        if (!this.g.has("isunuseauth")) {
          break label151;
        }
        bool = this.g.getBoolean("isunuseauth");
        a = bool;
        this.h.a(this.c, this.d, this.e, paramb, str, bool);
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        paramb.printStackTrace();
        this.h.a(false, this.d, this.e, "", "", false);
        continue;
        label151:
        boolean bool = false;
        continue;
        label156:
        paramb = null;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */