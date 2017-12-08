package com.wifipay.wallet.prod.security.account.dto;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryRNInfoResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/prod/security/account/dto/QueryRNInfoResp$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("trueName")) {
          this.resultObject.trueName = paramJSONObject.getString("trueName");
        }
        if (paramJSONObject.has("certNo")) {
          this.resultObject.certNo = paramJSONObject.getString("certNo");
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
    public String certNo;
    public String trueName;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/security/account/dto/QueryRNInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */