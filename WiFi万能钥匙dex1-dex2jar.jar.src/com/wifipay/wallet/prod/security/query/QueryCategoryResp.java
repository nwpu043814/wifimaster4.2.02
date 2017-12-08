package com.wifipay.wallet.prod.security.query;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryCategoryResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/prod/security/query/QueryCategoryResp$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("category")) {
          this.resultObject.category = paramJSONObject.getString("category");
        }
        if (paramJSONObject.has("outFlow")) {
          this.resultObject.outFlow = paramJSONObject.getString("outFlow");
        }
        if (paramJSONObject.has("totalOutFlow")) {
          this.resultObject.totalOutFlow = paramJSONObject.getString("totalOutFlow");
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
    public String category;
    public String outFlow;
    public String totalOutFlow;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/security/query/QueryCategoryResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */