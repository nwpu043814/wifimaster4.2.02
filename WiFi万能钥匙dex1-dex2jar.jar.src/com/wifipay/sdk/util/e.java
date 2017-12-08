package com.wifipay.sdk.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.wifipay.sdk.a.a.d;
import com.wifipay.sdk.modelpay.PayResp;
import com.wifipay.sdk.openapi.b;
import com.wifipay.wallet.WifiPayFactory;
import com.wifipay.wallet.pay.SPayResp;
import com.wifipay.wallet.pay.WifiPayApi;
import com.wifipay.wallet.prod.pay.WifiPayReq;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  public static SPayResp a(String paramString, Activity paramActivity)
  {
    return a(paramString, paramActivity, false, false);
  }
  
  public static SPayResp a(String paramString, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    c.a("kyo", "SPayResp sPay = ");
    if (!a(paramActivity, paramString))
    {
      paramString = null;
      return paramString;
    }
    String[] arrayOfString = paramString.split("&");
    WifiPayReq localWifiPayReq = new WifiPayReq();
    label408:
    for (;;)
    {
      try
      {
        paramString = new java/lang/StringBuilder;
        paramString.<init>("array = ");
        c.a("kyo", arrayOfString.length);
        localWifiPayReq.merchantOrderNo = arrayOfString[0];
        localWifiPayReq.merchantNo = arrayOfString[1];
        localWifiPayReq.goodsName = arrayOfString[2];
        paramString = arrayOfString[3];
        if ((paramString == null) || (paramString.length() == 0)) {
          break label408;
        }
        Object localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        paramString = Float.valueOf(paramString).floatValue() / 100.0F;
        if (arrayOfString.length <= 7) {
          continue;
        }
        String str2 = arrayOfString[6];
        String str1 = arrayOfString[7];
        Object localObject2 = str1;
        localObject1 = str2;
        if (!com.a.a.a.a.e.a(str2))
        {
          localObject2 = str1;
          localObject1 = str2;
          if (!com.a.a.a.a.e.a(str1))
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            localObject1 = Float.valueOf(str2).floatValue() / 100.0F;
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localObject2 = Float.valueOf(str1).floatValue() / 100.0F;
          }
        }
        localWifiPayReq.orderAmountOld = paramString;
        localWifiPayReq.orderAmount = ((String)localObject1);
        localWifiPayReq.orderAmountFavourable = ((String)localObject2);
        localWifiPayReq.notifyUrl = arrayOfString[4];
        localWifiPayReq.merchantName = arrayOfString[5];
        if (paramBoolean1)
        {
          localWifiPayReq.isActivity = paramBoolean1;
          localWifiPayReq.isLogin = paramBoolean2;
        }
        paramString = paramActivity.getIntent().getExtras();
        if (paramString != null)
        {
          localWifiPayReq.wifi_token = paramString.getString("_wifipay_wifi_token");
          localWifiPayReq.uhId = paramString.getString("_wifipay_uhId");
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        continue;
        paramString = paramString.sendReq(localWifiPayReq);
      }
      paramString = WifiPayFactory.createWifiPayAPI(paramActivity);
      c.a("kyo", "payApi = " + paramString);
      if (paramBoolean1)
      {
        paramString = paramString.sendReqAct(localWifiPayReq);
        break;
        localWifiPayReq.orderAmount = paramString;
        continue;
      }
      break;
    }
  }
  
  private static void a(Activity paramActivity, PayResp paramPayResp)
  {
    com.wifipay.sdk.openapi.a.a(paramActivity, paramPayResp);
    paramActivity.finish();
  }
  
  public static void a(Activity paramActivity, SPayResp paramSPayResp, String paramString)
  {
    c.a("kyo", "sendResp  ");
    HashMap localHashMap = new HashMap();
    localHashMap.put("merchantOrderNo", paramString);
    if (paramSPayResp != null)
    {
      localHashMap.put("wifiResultCode", paramSPayResp.resultCode);
      localHashMap.put("wifiResultMessage", paramSPayResp.resultMessage);
    }
    a.a(paramActivity, "activity", localHashMap);
    if (paramSPayResp == null)
    {
      a(paramActivity, b.a());
      return;
    }
    paramString = new PayResp();
    int i = Integer.valueOf(paramSPayResp.resultCode).intValue();
    c.a("kyo", "resultCode = " + i);
    if (i == 0)
    {
      paramString.errCode = 0;
      paramString.errMsg = a.d.u;
      a(paramString, paramSPayResp.telNo, paramSPayResp.merchantOrederNo);
    }
    for (;;)
    {
      a(paramActivity, paramString);
      break;
      if (i == -2)
      {
        paramString.errCode = -2;
        paramString.errMsg = a.d.v;
      }
      else if (i == -3)
      {
        paramString.errCode = -3;
        paramString.errMsg = a.d.w;
      }
      else if (i == -1)
      {
        paramString.errCode = -1;
        paramString.errMsg = a.d.x;
      }
    }
  }
  
  public static void a(PayResp paramPayResp, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!com.a.a.a.a.e.a(paramString1)) {
        localJSONObject.put("telNo", paramString1);
      }
      if (!com.a.a.a.a.e.a(paramString2)) {
        localJSONObject.put("merchantOrderNo", paramString2);
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    paramPayResp.ext = localJSONObject.toString();
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    if (!d.a(paramString, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCigSSLnWRyc+aGRzN9Rzp8XIjYk8rcAfbBhTS6zOSIf7S8YP7SCQI/346JkYuyyhrxcej50X/i1QnXG7GO1jq96Fd0/szYBb/K0yhmof46Na0z4f1M9ZCQxYYeGY5Vi+mQKMam1ku+rd8KzfdkXTxOI28QCvN4tDJihgVtSB9tlwIDAQAB"))
    {
      paramString = new PayResp();
      paramString.errCode = -2;
      paramString.errMsg = a.d.t;
      a(paramActivity, paramString);
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      if (localJSONObject.has("loginWifi"))
      {
        bool = localJSONObject.getBoolean("loginWifi");
        return bool;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        boolean bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */