package com.wifipay.wallet.prod.deposit;

import com.wifipay.common.net.entitybase.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

public class DepositOrderCreateResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/prod/deposit/DepositOrderCreateResp$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("depositId")) {
          this.resultObject.depositId = paramJSONObject.getString("depositId");
        }
        if (paramJSONObject.has("cardNo")) {
          this.resultObject.cardNo = paramJSONObject.getString("cardNo");
        }
        if (paramJSONObject.has("bankName")) {
          this.resultObject.bankName = paramJSONObject.getString("bankName");
        }
        if (paramJSONObject.has("bankCode")) {
          this.resultObject.bankCode = paramJSONObject.getString("bankCode");
        }
        if (paramJSONObject.has("agreementNo")) {
          this.resultObject.agreementNo = paramJSONObject.getString("agreementNo");
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
    public String bankCode;
    public String bankName;
    public String cardNo;
    public String depositId;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/deposit/DepositOrderCreateResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */