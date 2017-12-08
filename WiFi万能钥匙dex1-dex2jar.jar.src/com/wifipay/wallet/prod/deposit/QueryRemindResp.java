package com.wifipay.wallet.prod.deposit;

import com.wifipay.common.net.entitybase.BaseResp;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryRemindResp
  extends BaseResp
  implements Serializable
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      ResultObject localResultObject = new com/wifipay/wallet/prod/deposit/QueryRemindResp$ResultObject;
      localResultObject.<init>();
      this.resultObject = localResultObject;
      paramJSONObject = paramJSONObject.getJSONObject("resultObject");
      if (paramJSONObject.has("trueName")) {
        this.resultObject.trueName = paramJSONObject.getString("trueName");
      }
      if (paramJSONObject.has("certNo")) {
        this.resultObject.certNo = paramJSONObject.getString("certNo");
      }
      if (paramJSONObject.has("identityStatus")) {
        this.resultObject.identityStatus = paramJSONObject.getString("identityStatus");
      }
      if (paramJSONObject.has("errorCode")) {
        this.resultObject.errorCode = paramJSONObject.getString("errorCode");
      }
      if (paramJSONObject.has("errorMessage")) {
        this.resultObject.errorMessage = paramJSONObject.getString("errorMessage");
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
    public String certNo;
    public String errorCode;
    public String errorMessage;
    public String identityStatus;
    public String trueName;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/deposit/QueryRemindResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */