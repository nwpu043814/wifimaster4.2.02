package com.wifipay.wallet.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.wifipay.wallet.pay.activity.WifiPayEntryActivity;
import java.util.HashMap;
import java.util.Map;

public class a
{
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, WifiPayEntryActivity.class);
    localIntent.putExtra("enter_type", paramInt1);
    paramActivity.startActivityForResult(localIntent, paramInt2);
    com.wifipay.common.a.a.a(paramActivity, paramActivity.getClass().getSimpleName(), paramString, "null");
  }
  
  public static void a(Context paramContext, WalletParams paramWalletParams, ActionType paramActionType)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      Object localObject = new HashMap();
      ((Map)localObject).put("buttonType", paramActionType.getAction());
      com.wifipay.wallet.common.utils.a.a(paramContext, "wifiPersonalButton", (Map)localObject);
      localObject = new Intent(paramContext, WifiPayEntryActivity.class);
      ((Intent)localObject).putExtra("intent_action", paramActionType.getAction());
      ((Intent)localObject).putExtra("wifiParam", paramWalletParams);
      ((Intent)localObject).putExtra("enter_type", 2);
      paramContext.startActivity((Intent)localObject);
      try
      {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/openapi/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */