package com.wifipay.wallet.prod.bandcard.dto;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class BindCardDoSignResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/prod/bandcard/dto/BindCardDoSignResp$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("agreementNo")) {
          this.resultObject.agreementNo = paramJSONObject.getString("agreementNo");
        }
        if (paramJSONObject.has("bankAccountId")) {
          this.resultObject.bankAccountId = paramJSONObject.getString("bankAccountId");
        }
        if (paramJSONObject.has("setPayPwdRequestNo")) {
          this.resultObject.setPayPwdRequestNo = paramJSONObject.getString("setPayPwdRequestNo");
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
    public String agreementNo;
    public String bankAccountId;
    public String setPayPwdRequestNo;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/bandcard/dto/BindCardDoSignResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */