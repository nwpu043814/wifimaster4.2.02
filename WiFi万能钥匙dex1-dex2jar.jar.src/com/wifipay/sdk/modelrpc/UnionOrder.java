package com.wifipay.sdk.modelrpc;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class UnionOrder
  extends BaseResp
{
  public boolean activity;
  public boolean loginWifi;
  public String payString;
  public String resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("resultObject")) {
          this.resultObject = paramJSONObject.getString("resultObject");
        }
        if (paramJSONObject.has("activity"))
        {
          this.activity = paramJSONObject.getBoolean("activity");
          if (paramJSONObject.has("payString")) {
            this.payString = paramJSONObject.getString("payString");
          }
          if (paramJSONObject.has("loginWifi")) {
            this.loginWifi = paramJSONObject.getBoolean("loginWifi");
          }
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        continue;
      }
      this.activity = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/modelrpc/UnionOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */