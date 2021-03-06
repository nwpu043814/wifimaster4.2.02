package com.wifipay.wallet.prod.paypassword;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class ResetPPSmsResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/prod/paypassword/ResetPPSmsResp$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("requestNo")) {
          this.resultObject.requestNo = paramJSONObject.getString("requestNo");
        }
        if (paramJSONObject.has("bindMobile")) {
          this.resultObject.bindMobile = paramJSONObject.getString("bindMobile");
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
    public String bindMobile;
    public String requestNo;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/paypassword/ResetPPSmsResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */