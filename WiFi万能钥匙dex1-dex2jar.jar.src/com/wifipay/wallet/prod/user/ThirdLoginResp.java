package com.wifipay.wallet.prod.user;

import com.wifipay.common.net.entitybase.BaseResp;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class ThirdLoginResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      ResultObject localResultObject = new com/wifipay/wallet/prod/user/ThirdLoginResp$ResultObject;
      localResultObject.<init>();
      this.resultObject = localResultObject;
      if (!paramJSONObject.has("resultObject")) {}
      for (;;)
      {
        return;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("loginName")) {
          this.resultObject.loginName = paramJSONObject.getString("loginName");
        }
        if (paramJSONObject.has("memberId")) {
          this.resultObject.memberId = paramJSONObject.getString("memberId");
        }
        if (paramJSONObject.has("thirdToken")) {
          this.resultObject.thirdToken = paramJSONObject.getString("thirdToken");
        }
      }
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
    public String loginName;
    public String memberId;
    public String thirdToken;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/user/ThirdLoginResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */