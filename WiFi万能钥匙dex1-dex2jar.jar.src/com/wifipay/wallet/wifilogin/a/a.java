package com.wifipay.wallet.wifilogin.a;

import android.text.TextUtils;
import com.wifipay.common.logging.Logger;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.openapi.WalletParams;

public class a
{
  public static UserInfo a()
  {
    Logger.i("Delete UserInfo == %s", new Object[] { "delete start " });
    UserInfo localUserInfo = b.a().c();
    String str1 = localUserInfo.getCert();
    String str2 = localUserInfo.getCertSerialNo();
    b.a().b();
    localUserInfo = b.a().c();
    localUserInfo.setCert(str1);
    localUserInfo.setCertSerialNo(str2);
    return localUserInfo;
  }
  
  public static void a(WalletParams paramWalletParams)
  {
    Logger.i("Init UserInfo params == %s", new Object[] { String.valueOf(paramWalletParams) });
    UserInfo localUserInfo = a();
    if ((paramWalletParams != null) && (!TextUtils.isEmpty(paramWalletParams.getUserToken())) && (!TextUtils.isEmpty(paramWalletParams.getUhid())))
    {
      Logger.i("Init UserInfo token == %s", new Object[] { paramWalletParams.getUserToken() });
      Logger.i("Init UserInfo uhid == %s", new Object[] { paramWalletParams.getUhid() });
      localUserInfo.setOutToken(paramWalletParams.getUserToken());
      localUserInfo.setUhId(paramWalletParams.getUhid());
      localUserInfo.setLongi(paramWalletParams.getLongi());
      localUserInfo.setLati(paramWalletParams.getLati());
      localUserInfo.setMapSP(paramWalletParams.getMapSP());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/wifilogin/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */