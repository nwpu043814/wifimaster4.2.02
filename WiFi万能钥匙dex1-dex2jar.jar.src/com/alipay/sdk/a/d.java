package com.alipay.sdk.a;

import android.widget.Toast;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

final class d
  implements Runnable
{
  d(c paramc, a parama) {}
  
  public final void run()
  {
    c localc = this.b;
    a locala = this.a;
    if ((locala != null) && ("toast".equals(locala.c)))
    {
      JSONObject localJSONObject = locala.e;
      String str = localJSONObject.optString("content");
      int j = localJSONObject.optInt("duration");
      i = 1;
      if (j < 2500) {
        i = 0;
      }
      Toast.makeText(localc.b, str, i).show();
      new Timer().schedule(new e(localc, locala), i);
    }
    int i = a.a.a;
    if (i != a.a.a) {}
    try
    {
      this.b.a(this.a.a, i);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */