package com.wifipay.wallet.prod.wifiactivity;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class WifiActivityCheckResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      ResultObject localResultObject = new com/wifipay/wallet/prod/wifiactivity/WifiActivityCheckResp$ResultObject;
      localResultObject.<init>();
      this.resultObject = localResultObject;
      paramJSONObject = paramJSONObject.getJSONObject("resultObject");
      if (paramJSONObject.has("requestNo")) {
        this.resultObject.requestNo = paramJSONObject.getString("requestNo");
      }
      if (paramJSONObject.has("memberId")) {
        this.resultObject.memberId = paramJSONObject.getString("memberId");
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
    public String memberId;
    public String requestNo;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/wifiactivity/WifiActivityCheckResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */