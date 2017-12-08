package com.wifipay.wallet.common.utils;

import android.content.Context;
import com.analysis.analytics.ALInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class a
{
  public static void a(Context paramContext)
  {
    ALInterface.setDebugMode(false);
    ALInterface.onSignIn(paramContext, "wifi_analytics");
    ALInterface.setAppId(paramContext, "ZF1037");
    ALInterface.setVersionName(paramContext, "1.2.0");
  }
  
  public static void a(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("button_name", paramString);
    a(paramContext, "operateHome", localHashMap);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    String str1 = "";
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (((String)paramMap.get(str2)).length() <= 0) {
        break label171;
      }
      str1 = str1 + str2 + "/" + (String)paramMap.get(str2) + ";";
    }
    label171:
    for (;;)
    {
      break;
      paramMap = new HashMap();
      paramMap.put("page", paramString1);
      paramMap.put("click", paramString2);
      paramMap.put("input", str1);
      paramMap.put("result", paramString3);
      a(paramContext, "operateBind", paramMap);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    paramMap.put("version", "1.2.0");
    ALInterface.onEvent(paramContext, paramString, 100, paramMap);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */