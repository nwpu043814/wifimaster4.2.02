package com.lantern.core;

import android.text.TextUtils;
import com.lantern.core.config.CommonConf;
import com.lantern.core.config.d;
import org.json.JSONObject;

public final class j
{
  private static j a;
  
  public static int a(String paramString)
  {
    JSONObject localJSONObject = b();
    if ((!TextUtils.isEmpty(paramString)) && (localJSONObject != null) && (localJSONObject.has(paramString))) {}
    for (int i = Integer.parseInt(localJSONObject.optString(paramString));; i = 0) {
      return i;
    }
  }
  
  public static j a()
  {
    if (a == null) {
      a = new j();
    }
    return a;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = b();
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      str = paramString2;
      if (localJSONObject != null)
      {
        str = paramString2;
        if (localJSONObject.has(paramString1)) {
          str = localJSONObject.optString(paramString1);
        }
      }
    }
    return str;
  }
  
  private static JSONObject b()
  {
    return ((CommonConf)d.a(c.getAppContext()).a(CommonConf.class)).d();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */