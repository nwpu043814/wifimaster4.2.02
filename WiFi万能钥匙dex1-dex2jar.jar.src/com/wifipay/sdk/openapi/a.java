package com.wifipay.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.wifipay.sdk.modelpay.PayResp;

public class a
{
  public static PayResp a()
  {
    return a(null);
  }
  
  public static PayResp a(String paramString)
  {
    PayResp localPayResp = new PayResp();
    localPayResp.errCode = -2;
    if (paramString != null) {}
    for (;;)
    {
      localPayResp.errMsg = paramString;
      return localPayResp;
      paramString = "unknown error";
    }
  }
  
  private static String a(Context paramContext)
  {
    try
    {
      paramContext = ((Activity)paramContext).getIntent().getExtras().getString("_wifipay_third_pkg");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "";
      }
    }
  }
  
  public static void a(Context paramContext, PayResp paramPayResp)
  {
    PayResp localPayResp = paramPayResp;
    if (paramPayResp == null) {
      localPayResp = a();
    }
    localPayResp.third_pkg = a(paramContext);
    Object localObject = paramContext.getPackageName();
    paramPayResp = new Intent();
    paramPayResp.setClassName((String)localObject, (String)localObject + ".wifiapi.WifiPayResultActivity");
    localObject = new Bundle();
    localPayResp.toBundle((Bundle)localObject);
    paramPayResp.putExtras((Bundle)localObject);
    paramContext.startActivity(paramPayResp);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/openapi/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */