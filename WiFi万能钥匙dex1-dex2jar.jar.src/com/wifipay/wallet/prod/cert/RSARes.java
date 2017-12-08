package com.wifipay.wallet.prod.cert;

import com.wifipay.common.net.entitybase.BaseResp;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class RSARes
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/prod/cert/RSARes$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("cert")) {
          this.resultObject.cert = paramJSONObject.getString("cert");
        }
        if (paramJSONObject.has("certSerialNo")) {
          this.resultObject.certSerialNo = paramJSONObject.getString("certSerialNo");
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
    private static final long serialVersionUID = 4556283330932271542L;
    public String cert;
    public String certSerialNo;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/cert/RSARes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */