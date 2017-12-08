package com.lantern.wifilocating.push.g.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.lantern.wifilocating.push.util.j;
import java.net.URLDecoder;
import org.json.JSONObject;

public class e
  extends c
{
  public final void b(JSONObject paramJSONObject)
  {
    j.k(com.lantern.wifilocating.push.c.a());
    Object localObject = paramJSONObject.optString("taction");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = new Intent((String)localObject);
    }
    for (;;)
    {
      ((Intent)localObject).setPackage(com.lantern.wifilocating.push.c.a().getPackageName());
      String str = paramJSONObject.optString("content");
      paramJSONObject = str;
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        paramJSONObject = URLDecoder.decode(str, "UTF-8");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          ((Intent)localObject).putExtra("push_msg", paramJSONObject);
          j.a(com.lantern.wifilocating.push.c.a(), (Intent)localObject, 2);
        }
        return;
        localObject = new Intent("com.lantern.wifilocating.push.action.TRANSFER");
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
          paramJSONObject = str;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/g/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */