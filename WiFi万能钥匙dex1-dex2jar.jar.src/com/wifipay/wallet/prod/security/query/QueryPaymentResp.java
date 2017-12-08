package com.wifipay.wallet.prod.security.query;

import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.wallet.prod.core.model.PayCard;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryPaymentResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ResultObject localResultObject = new com/wifipay/wallet/prod/security/query/QueryPaymentResp$ResultObject;
        localResultObject.<init>();
        this.resultObject = localResultObject;
        paramJSONObject = paramJSONObject.getJSONObject("resultObject");
        if (paramJSONObject.has("showType")) {
          this.resultObject.showType = paramJSONObject.getString("showType");
        }
        if (paramJSONObject.has("items"))
        {
          paramJSONObject = paramJSONObject.getJSONArray("items");
          for (int i = 0; i < paramJSONObject.length(); i++) {
            this.resultObject.items.add(parseCard(paramJSONObject.getJSONObject(i)));
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public PayCard parseCard(JSONObject paramJSONObject)
  {
    PayCard localPayCard2 = new PayCard();
    try
    {
      if (paramJSONObject.has("enabled")) {
        localPayCard2.enabled = paramJSONObject.getString("enabled");
      }
      if (paramJSONObject.has("paymentType")) {
        localPayCard2.paymentType = paramJSONObject.getString("paymentType");
      }
      if (paramJSONObject.has("type")) {
        localPayCard2.type = paramJSONObject.getString("type");
      }
      if (paramJSONObject.has("isDefault")) {
        localPayCard2.isDefault = paramJSONObject.getString("isDefault");
      }
      if (paramJSONObject.has("desc")) {
        localPayCard2.desc = paramJSONObject.getString("desc");
      }
      if (paramJSONObject.has("agreementNo")) {
        localPayCard2.agreementNo = paramJSONObject.getString("agreementNo");
      }
      if (paramJSONObject.has("cardType")) {
        localPayCard2.cardType = paramJSONObject.getString("cardType");
      }
      if (paramJSONObject.has("bankCode")) {
        localPayCard2.bankCode = paramJSONObject.getString("bankCode");
      }
      if (paramJSONObject.has("cardNo")) {
        localPayCard2.cardNo = paramJSONObject.getString("cardNo");
      }
      if (paramJSONObject.has("mobile")) {
        localPayCard2.mobile = paramJSONObject.getString("mobile");
      }
      if (paramJSONObject.has("instMobile")) {
        localPayCard2.instMobile = paramJSONObject.getString("instMobile");
      }
      localPayCard1 = localPayCard2;
      if (paramJSONObject.has("seqNum"))
      {
        localPayCard2.seqNum = paramJSONObject.getInt("seqNum");
        localPayCard1 = localPayCard2;
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
        PayCard localPayCard1 = null;
      }
    }
    return localPayCard1;
  }
  
  public static class ResultObject
  {
    public ArrayList<PayCard> items = new ArrayList();
    public String showType;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/security/query/QueryPaymentResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */