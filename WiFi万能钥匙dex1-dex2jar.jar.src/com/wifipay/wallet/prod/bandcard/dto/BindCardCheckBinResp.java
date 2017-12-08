package com.wifipay.wallet.prod.bandcard.dto;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class BindCardCheckBinResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/prod/bandcard/dto/BindCardCheckBinResp$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("bankName")) {
          this.resultObject.bankName = paramJSONObject.getString("bankName");
        }
        if (paramJSONObject.has("bankCode")) {
          this.resultObject.bankCode = paramJSONObject.getString("bankCode");
        }
        if (paramJSONObject.has("cardType")) {
          this.resultObject.cardType = paramJSONObject.getString("cardType");
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
    public String bankCode;
    public String bankName;
    public String cardType;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/bandcard/dto/BindCardCheckBinResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */