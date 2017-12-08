package com.wifipay.wallet.prod.pay;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class NewOrderResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/prod/pay/NewOrderResp$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("payStatus")) {
          this.resultObject.payStatus = paramJSONObject.getString("payStatus");
        }
        if (paramJSONObject.has("payStatusDesc")) {
          this.resultObject.payStatusDesc = paramJSONObject.getString("payStatusDesc");
        }
        if (paramJSONObject.has("payTime")) {
          this.resultObject.payTime = paramJSONObject.getString("payTime");
        }
        if (paramJSONObject.has("orderId")) {
          this.resultObject.orderId = paramJSONObject.getString("orderId");
        }
        if (paramJSONObject.has("needSendSms")) {
          this.resultObject.needSendSms = paramJSONObject.getString("needSendSms");
        }
        if (paramJSONObject.has("needPayPwd")) {
          this.resultObject.needPayPwd = paramJSONObject.getString("needPayPwd");
        }
        if (paramJSONObject.has("merchantOrderNo")) {
          this.resultObject.merchantOrderNo = paramJSONObject.getString("merchantOrderNo");
        }
        if (paramJSONObject.has("mobileNo")) {
          this.resultObject.mobileNo = paramJSONObject.getString("mobileNo");
        }
        if (paramJSONObject.has("bankName")) {
          this.resultObject.bankName = paramJSONObject.getString("bankName");
        }
        if (paramJSONObject.has("cardNo")) {
          this.resultObject.cardNo = paramJSONObject.getString("cardNo");
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public static class ResultObject
  {
    public String bankName;
    public String cardNo;
    public String merchantOrderNo;
    public String mobileNo;
    public String needPayPwd;
    public String needSendSms;
    public String orderId;
    public String payStatus;
    public String payStatusDesc;
    public String payTime;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/pay/NewOrderResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */