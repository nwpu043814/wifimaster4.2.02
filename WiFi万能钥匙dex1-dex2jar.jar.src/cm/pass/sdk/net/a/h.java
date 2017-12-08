package cm.pass.sdk.net.a;

import a.a.a.c.b;
import a.a.a.c.c;
import android.text.TextUtils;
import cm.pass.sdk.net.m;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  implements c
{
  protected boolean a;
  protected String b;
  protected String c = "";
  protected String d;
  public JSONObject e;
  
  public void a(b paramb)
  {
    JSONObject localJSONObject = ((m)paramb).c();
    this.e = localJSONObject;
    if (localJSONObject != null) {}
    try
    {
      this.b = localJSONObject.getString("resultcode");
      this.a = "000".equals(this.b);
      if (localJSONObject.has("desc")) {
        this.c = this.e.getString("desc");
      }
      if (localJSONObject.has("expandparams")) {
        this.d = this.e.getString("expandparams");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    if (TextUtils.isEmpty(this.b))
    {
      this.b = "102101";
      this.c = paramb.j;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */