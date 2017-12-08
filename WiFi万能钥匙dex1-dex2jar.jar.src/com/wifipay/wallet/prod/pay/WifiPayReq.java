package com.wifipay.wallet.prod.pay;

import android.os.Bundle;

public class WifiPayReq
{
  public String goodsName;
  public boolean isActivity;
  public boolean isLogin;
  public String merchantName;
  public String merchantNo;
  public String merchantOrderNo;
  public String notifyUrl;
  public String orderAmount;
  public String orderAmountFavourable;
  public String orderAmountOld;
  public String uhId;
  public String wifi_token;
  
  public void fromBundle(Bundle paramBundle)
  {
    this.merchantName = paramBundle.getString("wifipay_merchantName");
    this.merchantNo = paramBundle.getString("wifipay_merchantNo");
    this.merchantOrderNo = paramBundle.getString("wifipay_merchantOrderNo");
    this.goodsName = paramBundle.getString("wifipay_goodsName");
    this.orderAmount = paramBundle.getString("wifipay_orderAmount");
    this.wifi_token = paramBundle.getString("wifipay_wifi_token");
    this.uhId = paramBundle.getString("wifipay_uhId");
    this.orderAmountOld = paramBundle.getString("wifipay_orderAmountOld");
    this.orderAmountFavourable = paramBundle.getString("wifipay_orderAmountFavourable");
    this.notifyUrl = paramBundle.getString("wifipay_notifyUrl");
    this.isActivity = paramBundle.getBoolean("wifipay_isActivity");
    this.isLogin = paramBundle.getBoolean("wifipay_isLogin");
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("wifipay_merchantName", this.merchantName);
    paramBundle.putString("wifipay_merchantNo", this.merchantNo);
    paramBundle.putString("wifipay_merchantOrderNo", this.merchantOrderNo);
    paramBundle.putString("wifipay_orderAmount", this.orderAmount);
    paramBundle.putString("wifipay_goodsName", this.goodsName);
    paramBundle.putString("wifipay_wifi_token", this.wifi_token);
    paramBundle.putString("wifipay_uhId", this.uhId);
    paramBundle.putString("wifipay_orderAmountOld", this.orderAmountOld);
    paramBundle.putString("wifipay_orderAmountFavourable", this.orderAmountFavourable);
    paramBundle.putString("wifipay_notifyUrl", this.notifyUrl);
    paramBundle.putBoolean("wifipay_isActivity", this.isActivity);
    paramBundle.putBoolean("wifipay_isLogin", this.isLogin);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/pay/WifiPayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */