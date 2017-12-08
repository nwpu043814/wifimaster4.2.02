package com.wifipay.sdk.modelpay;

import android.os.Bundle;

public class PayReq
{
  public String appId;
  public String appName;
  public String ext;
  public String goodsDesc;
  public String goodsName;
  public String jSessionID;
  public String merchantNo;
  public String merchantOrderNo;
  public String notifyUrl;
  public String openId;
  public String orderAmount;
  public String sign;
  public String telNo;
  public String third_pkg;
  public String uhId;
  public String wifi_pub_channel;
  public String wifi_token;
  public String wifi_version;
  
  public boolean checkArgs()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.appId != null)
    {
      if (this.appId.length() != 0) {
        break label25;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label25:
      bool1 = bool2;
      if (this.appName != null)
      {
        bool1 = bool2;
        if (this.appName.length() != 0)
        {
          bool1 = bool2;
          if (this.merchantOrderNo != null)
          {
            bool1 = bool2;
            if (this.merchantOrderNo.length() != 0)
            {
              bool1 = bool2;
              if (this.orderAmount != null)
              {
                bool1 = bool2;
                if (this.orderAmount.length() != 0)
                {
                  bool1 = bool2;
                  if (this.goodsName != null)
                  {
                    bool1 = bool2;
                    if (this.goodsName.length() != 0)
                    {
                      bool1 = bool2;
                      if (this.notifyUrl != null)
                      {
                        bool1 = bool2;
                        if (this.notifyUrl.length() != 0)
                        {
                          bool1 = bool2;
                          if (this.merchantNo != null)
                          {
                            bool1 = bool2;
                            if (this.merchantNo.length() != 0)
                            {
                              bool1 = bool2;
                              if (this.sign != null)
                              {
                                bool1 = bool2;
                                if (this.sign.length() != 0) {
                                  bool1 = true;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    this.appId = paramBundle.getString("_wifipay_appId");
    this.appName = paramBundle.getString("_wifipay_appName");
    this.openId = paramBundle.getString("_wifipay_openId");
    this.uhId = paramBundle.getString("_wifipay_uhId");
    this.telNo = paramBundle.getString("_wifipay_telNo");
    this.merchantNo = paramBundle.getString("_wifipay_merchantNo");
    this.merchantOrderNo = paramBundle.getString("_wifipay_merchantOrderNo");
    this.goodsName = paramBundle.getString("_wifipay_goodsName");
    this.goodsDesc = paramBundle.getString("_wifipay_goodsDesc");
    this.orderAmount = paramBundle.getString("_wifipay_orderAmount");
    this.notifyUrl = paramBundle.getString("_wifipay_notifyUrl");
    this.sign = paramBundle.getString("_wifipay_sign");
    this.wifi_version = paramBundle.getString("_wifipay_wifi_version");
    this.wifi_pub_channel = paramBundle.getString("_wifipay_wifi_pub_channel");
    this.wifi_token = paramBundle.getString("_wifipay_wifi_token");
    this.third_pkg = paramBundle.getString("_wifipay_third_pkg");
    this.ext = paramBundle.getString("_wifipay_ext");
    this.jSessionID = paramBundle.getString("_wifipay_jsession_id");
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("_wifipay_appId", this.appId);
    paramBundle.putString("_wifipay_appName", this.appName);
    paramBundle.putString("_wifipay_openId", this.openId);
    paramBundle.putString("_wifipay_uhId", this.uhId);
    paramBundle.putString("_wifipay_telNo", this.telNo);
    paramBundle.putString("_wifipay_merchantNo", this.merchantNo);
    paramBundle.putString("_wifipay_merchantOrderNo", this.merchantOrderNo);
    paramBundle.putString("_wifipay_goodsName", this.goodsName);
    paramBundle.putString("_wifipay_goodsDesc", this.goodsDesc);
    paramBundle.putString("_wifipay_orderAmount", this.orderAmount);
    paramBundle.putString("_wifipay_notifyUrl", this.notifyUrl);
    paramBundle.putString("_wifipay_sign", this.sign);
    paramBundle.putString("_wifipay_wifi_version", this.wifi_version);
    paramBundle.putString("_wifipay_wifi_pub_channel", this.wifi_pub_channel);
    paramBundle.putString("_wifipay_wifi_token", this.wifi_token);
    paramBundle.putString("_wifipay_third_pkg", this.third_pkg);
    paramBundle.putString("_wifipay_ext", this.ext);
    paramBundle.putString("_wifipay_jsession_id", this.jSessionID);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/modelpay/PayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */