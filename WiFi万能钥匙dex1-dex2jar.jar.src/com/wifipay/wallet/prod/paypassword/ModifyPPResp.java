package com.wifipay.wallet.prod.paypassword;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class ModifyPPResp
  extends BaseResp
{
  public String resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject")) {
        this.resultObject = paramJSONObject.getString("resultObject");
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
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/paypassword/ModifyPPResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */