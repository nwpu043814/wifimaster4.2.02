package com.wifipay.sdk.modelrpc;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryOrderInfo
  extends BaseResp
{
  public String resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("resultObject"))) {}
    try
    {
      this.resultObject = paramJSONObject.getString("resultObject");
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
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/modelrpc/QueryOrderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */