package com.wifipay.common.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.analysis.analytics.ALInterface;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static SharedPreferences a;
  
  private static SharedPreferences a(Context paramContext)
  {
    if (a == null) {
      a = paramContext.getSharedPreferences("wifi_wallet", 0);
    }
    return a;
  }
  
  private static String a(String paramString, SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = paramSharedPreferences.getString(paramString, "null");
    paramString = paramSharedPreferences;
    if (paramSharedPreferences.equals("null")) {
      paramString = "无";
    }
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a(paramContext).edit().putString("page", paramString1).putString("button", paramString2).putString("action", paramString3).apply();
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences localSharedPreferences = a(paramContext);
    HashMap localHashMap = new HashMap();
    if (paramBoolean2)
    {
      str = "yes";
      localHashMap.put("invalid", str);
      if (!paramBoolean1) {
        break label119;
      }
    }
    label119:
    for (String str = "success";; str = "failed")
    {
      localHashMap.put("login_result", str);
      localHashMap.put("page", a("page", localSharedPreferences));
      localHashMap.put("wifi_login", a("action", localSharedPreferences));
      localHashMap.put("button", a("button", localSharedPreferences));
      ALInterface.onEvent(paramContext, "wifiLogin", 100, localHashMap);
      return;
      str = "no";
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */