package com.lantern.wifilocating.push.util;

import android.content.Context;
import android.content.Intent;
import org.json.JSONObject;

final class k
  extends Thread
{
  k(String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext) {}
  
  public final void run()
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      localJSONObject.put("funid", "loc");
      localJSONObject.put("longi", this.a);
      localJSONObject.put("lati", this.b);
      localJSONObject.put("address", this.c);
      localJSONObject.put("mapSP", this.d);
      localJSONObject.put("time", String.valueOf(System.currentTimeMillis()));
      j.k(this.e);
      Intent localIntent = new android/content/Intent;
      localIntent.<init>("com.lantern.wifilocating.push.action.TRANSFER");
      localIntent.setPackage(this.e.getPackageName());
      localIntent.putExtra("push_msg", localJSONObject.toString());
      j.a(this.e, localIntent, 2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */