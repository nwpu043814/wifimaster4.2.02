package com.wifipay.wallet.prod.user;

import com.wifipay.common.net.entitybase.BaseResp;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      ResultObject localResultObject = new com/wifipay/wallet/prod/user/UploadResp$ResultObject;
      localResultObject.<init>();
      this.resultObject = localResultObject;
      paramJSONObject = paramJSONObject.getJSONObject("resultObject");
      if (paramJSONObject.has("mobile")) {
        this.resultObject.mobile = paramJSONObject.getString("mobile");
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
    public String mobile;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/user/UploadResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */