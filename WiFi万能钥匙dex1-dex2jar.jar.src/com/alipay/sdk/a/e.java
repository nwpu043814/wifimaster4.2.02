package com.alipay.sdk.a;

import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

final class e
  extends TimerTask
{
  e(c paramc, a parama) {}
  
  public final void run()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("toastCallBack", "true");
      a locala = new a("callback");
      locala.a = this.a.a;
      locala.e = localJSONObject;
      this.b.a.a(locala);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */