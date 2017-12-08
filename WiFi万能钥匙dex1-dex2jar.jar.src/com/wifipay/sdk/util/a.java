package com.wifipay.sdk.util;

import android.content.Context;
import com.analysis.analytics.ALInterface;
import java.util.Map;

public class a
{
  public static void a(Context paramContext)
  {
    ALInterface.setDebugMode(false);
    ALInterface.onSignIn(paramContext, "wifi_analytics");
    ALInterface.setAppId(paramContext, "ZF1016");
    ALInterface.setVersionName(paramContext, "1.0.3");
  }
  
  public static void a(Context paramContext, String paramString, Map paramMap)
  {
    paramMap.put("app_id", "ZF1016");
    paramMap.put("version", "1.0.3");
    ALInterface.onEvent(paramContext, paramString, 100, paramMap);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */