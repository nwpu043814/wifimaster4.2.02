package com.wifipay.wallet;

import android.content.Context;
import com.wifipay.wallet.pay.WifiPayApi;
import com.wifipay.wallet.pay.WifiPayApiImpl;

public class WifiPayFactory
{
  public static WifiPayApi createWifiPayAPI(Context paramContext)
  {
    return createWifiPayAPI(paramContext, false);
  }
  
  public static WifiPayApi createWifiPayAPI(Context paramContext, boolean paramBoolean)
  {
    return new WifiPayApiImpl(paramContext, paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/WifiPayFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */