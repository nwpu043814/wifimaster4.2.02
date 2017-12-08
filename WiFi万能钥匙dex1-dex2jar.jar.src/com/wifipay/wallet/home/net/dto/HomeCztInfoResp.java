package com.wifipay.wallet.home.net.dto;

import com.wifipay.common.net.entitybase.BaseResp;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeCztInfoResp
  extends BaseResp
  implements Serializable
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/home/net/dto/HomeCztInfoResp$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("isSetDigitPwd")) {
          this.resultObject.isSetDigitPwd = paramJSONObject.getString("isSetDigitPwd");
        }
        if (paramJSONObject.has("availableBalance")) {
          this.resultObject.availableBalance = paramJSONObject.getString("availableBalance");
        }
        if (paramJSONObject.has("certNo")) {
          this.resultObject.certNo = paramJSONObject.getString("certNo");
        }
        if (paramJSONObject.has("frozenBalance")) {
          this.resultObject.frozenBalance = paramJSONObject.getString("frozenBalance");
        }
        if (paramJSONObject.has("trueName")) {
          this.resultObject.trueName = paramJSONObject.getString("trueName");
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
    implements Serializable
  {
    public String availableBalance;
    public String certNo;
    public String frozenBalance;
    public String isSetDigitPwd;
    public String trueName;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/net/dto/HomeCztInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */