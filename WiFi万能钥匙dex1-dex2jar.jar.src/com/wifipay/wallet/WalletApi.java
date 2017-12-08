package com.wifipay.wallet;

import android.content.Context;
import com.wifipay.common.a.f;
import com.wifipay.common.logging.Logger;
import com.wifipay.common.net.HttpManager;
import com.wifipay.wallet.common.info.AppInfo;
import com.wifipay.wallet.common.info.DeviceInfo;
import com.wifipay.wallet.openapi.ActionType;
import com.wifipay.wallet.openapi.WalletParams;

public class WalletApi
{
  public static void init(Context paramContext)
  {
    HttpManager.init(paramContext);
    Logger.init("wujun", false);
    DeviceInfo.INSTANCE.init(paramContext);
    f.a(paramContext);
    AppInfo.INSTANCE.init(paramContext);
    com.wifipay.wallet.common.utils.a.a(paramContext);
  }
  
  public static void startAction(Context paramContext, WalletParams paramWalletParams, ActionType paramActionType)
  {
    com.wifipay.wallet.openapi.a.a(paramContext, paramWalletParams, paramActionType);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/WalletApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */