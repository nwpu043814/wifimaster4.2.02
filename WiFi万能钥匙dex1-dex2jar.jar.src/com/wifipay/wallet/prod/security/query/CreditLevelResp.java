package com.wifipay.wallet.prod.security.query;

import com.wifipay.common.net.entitybase.BaseResp;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class CreditLevelResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/prod/security/query/CreditLevelResp$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("creditLevel")) {
          this.resultObject.creditLevel = paramJSONObject.getString("creditLevel");
        }
        if (paramJSONObject.has("limit")) {
          this.resultObject.limit = paramJSONObject.getString("limit");
        }
        if (paramJSONObject.has("dayLimit")) {
          this.resultObject.dayLimit = paramJSONObject.getString("dayLimit");
        }
        if (paramJSONObject.has("monthLimit")) {
          this.resultObject.monthLimit = paramJSONObject.getString("monthLimit");
        }
        if (paramJSONObject.has("dayFlow")) {
          this.resultObject.dayFlow = paramJSONObject.getString("dayFlow");
        }
        if (paramJSONObject.has("monthFlow")) {
          this.resultObject.monthFlow = paramJSONObject.getString("monthFlow");
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
    implements Serializable
  {
    public String creditLevel;
    public String dayFlow;
    public String dayLimit;
    public String limit;
    public String monthFlow;
    public String monthLimit;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/security/query/CreditLevelResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */