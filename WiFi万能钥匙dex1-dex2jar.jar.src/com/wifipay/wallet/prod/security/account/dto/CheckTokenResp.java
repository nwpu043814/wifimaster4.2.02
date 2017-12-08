package com.wifipay.wallet.prod.security.account.dto;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckTokenResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/prod/security/account/dto/CheckTokenResp$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("loginName")) {
          this.resultObject.loginName = paramJSONObject.getString("loginName");
        }
        if (paramJSONObject.has("memberId")) {
          this.resultObject.memberId = paramJSONObject.getString("memberId");
        }
        if (paramJSONObject.has("operatorId")) {
          this.resultObject.operatorId = paramJSONObject.getString("operatorId");
        }
        if (paramJSONObject.has("accessToken")) {
          this.resultObject.accessToken = paramJSONObject.getString("accessToken");
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
    public String accessToken;
    public String loginName;
    public String memberId;
    public String operatorId;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/security/account/dto/CheckTokenResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */