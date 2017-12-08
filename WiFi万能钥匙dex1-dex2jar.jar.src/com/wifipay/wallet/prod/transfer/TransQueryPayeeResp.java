package com.wifipay.wallet.prod.transfer;

import com.wifipay.common.net.entitybase.BaseResp;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class TransQueryPayeeResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      ResultObject localResultObject = new com/wifipay/wallet/prod/transfer/TransQueryPayeeResp$ResultObject;
      localResultObject.<init>();
      this.resultObject = localResultObject;
      paramJSONObject = paramJSONObject.getJSONObject("resultObject");
      if (paramJSONObject.has("trueName")) {
        this.resultObject.trueName = paramJSONObject.getString("trueName");
      }
      if (paramJSONObject.has("payeeMemberId")) {
        this.resultObject.payeeMemberId = paramJSONObject.getString("payeeMemberId");
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
    implements Serializable
  {
    public String payeeMemberId;
    public String trueName;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/transfer/TransQueryPayeeResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */