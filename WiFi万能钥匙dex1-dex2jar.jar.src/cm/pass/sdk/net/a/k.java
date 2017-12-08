package cm.pass.sdk.net.a;

import a.a.a.c.c;
import cm.pass.sdk.net.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  implements c
{
  protected boolean a;
  protected String b = "102101";
  protected String c = "";
  private cm.pass.sdk.interfaces.b d;
  
  public k(cm.pass.sdk.interfaces.b paramb)
  {
    this.d = paramb;
  }
  
  public void a(a.a.a.c.b paramb)
  {
    paramb = ((a)paramb).g();
    HashMap localHashMap = new HashMap();
    if (paramb != null) {
      try
      {
        this.b = paramb.getString("resultcode");
        this.a = "401001".equals(this.b);
        Iterator localIterator = paramb.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, paramb.optString(str));
          continue;
          this.d.a(false, this.b, this.c, null);
        }
      }
      catch (JSONException paramb)
      {
        paramb.printStackTrace();
      }
    }
    for (;;)
    {
      return;
      this.d.a(this.a, this.b, this.c, localHashMap);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */