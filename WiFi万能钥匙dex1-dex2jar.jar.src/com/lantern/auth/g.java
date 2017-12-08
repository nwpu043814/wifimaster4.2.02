package com.lantern.auth;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.core.c;
import com.lantern.core.k;
import java.util.HashMap;
import org.json.JSONObject;

public final class g
{
  public static String a(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("netModel", k.n(paramContext));
    localHashMap.put("netOperator", k.f(paramContext));
    return new JSONObject(localHashMap).toString();
  }
  
  public static String a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null) {
      localHashMap.put("3RD_APPID", paramString);
    }
    return new JSONObject(localHashMap).toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    if (paramString3 != null) {
      localHashMap.put("3RD_APPID", paramString3);
    }
    if (paramString1 != null) {
      localHashMap.put("loginType", paramString1);
    }
    localHashMap.put("ret", paramString2);
    return new JSONObject(localHashMap).toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      localHashMap.put("FromSource", paramString1);
      str = "empty";
    }
    localHashMap.put("FromSource", str);
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("LoginPath", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("ReturnCode", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHashMap.put("APPID", paramString4);
    }
    localHashMap.put("netModel", k.n(c.getInstance()));
    localHashMap.put("netOperator", k.f(c.getInstance()));
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */