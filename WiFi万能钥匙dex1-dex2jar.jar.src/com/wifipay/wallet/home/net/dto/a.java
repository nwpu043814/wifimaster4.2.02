package com.wifipay.wallet.home.net.dto;

import android.webkit.JavascriptInterface;
import com.wifipay.common.eventbus.EventBus;

public class a
{
  @JavascriptInterface
  public void cardUnbind()
  {
    EventBus.getDefault().post(new com.wifipay.wallet.a.a("unbind_card"));
  }
  
  @JavascriptInterface
  public void closeUnbind()
  {
    EventBus.getDefault().post(new com.wifipay.wallet.a.a("unbind_close"));
  }
  
  @JavascriptInterface
  public void getUserInfo()
  {
    EventBus.getDefault().post(new com.wifipay.wallet.a.a("user_info"));
  }
  
  @JavascriptInterface
  public void verifyIdentity()
  {
    EventBus.getDefault().post(new com.wifipay.wallet.a.a("certification"));
  }
  
  @JavascriptInterface
  public void verifyMoreBankCard()
  {
    EventBus.getDefault().post(new com.wifipay.wallet.a.a("add_card"));
  }
  
  @JavascriptInterface
  public void verifyPhoneNum()
  {
    EventBus.getDefault().post(new com.wifipay.wallet.a.a("authentication_phone"));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/net/dto/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */