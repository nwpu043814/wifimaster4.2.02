package com.wifipay.wallet.prod.security.query;

import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.wallet.prod.core.model.BankCard;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryHpsCardResp
  extends BaseResp
{
  public ArrayList<BankCard> resultObject = new ArrayList();
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("resultObject");
        for (int i = 0; i < paramJSONObject.length(); i++) {
          this.resultObject.add(parseCard(paramJSONObject.getJSONObject(i)));
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public BankCard parseCard(JSONObject paramJSONObject)
  {
    BankCard localBankCard2 = new BankCard();
    try
    {
      if (paramJSONObject.has("enabled")) {
        localBankCard2.enabled = paramJSONObject.getString("enabled");
      }
      if (paramJSONObject.has("paymentType")) {
        localBankCard2.paymentType = paramJSONObject.getString("paymentType");
      }
      if (paramJSONObject.has("type")) {
        localBankCard2.type = paramJSONObject.getString("type");
      }
      if (paramJSONObject.has("isDefault")) {
        localBankCard2.isDefault = paramJSONObject.getString("isDefault");
      }
      if (paramJSONObject.has("agreementNo")) {
        localBankCard2.agreementNo = paramJSONObject.getString("agreementNo");
      }
      if (paramJSONObject.has("cardType")) {
        localBankCard2.cardType = paramJSONObject.getString("cardType");
      }
      if (paramJSONObject.has("bankCode")) {
        localBankCard2.bankCode = paramJSONObject.getString("bankCode");
      }
      if (paramJSONObject.has("cardNo")) {
        localBankCard2.cardNo = paramJSONObject.getString("cardNo");
      }
      if (paramJSONObject.has("mobile")) {
        localBankCard2.mobile = paramJSONObject.getString("mobile");
      }
      if (paramJSONObject.has("bankName")) {
        localBankCard2.bankName = paramJSONObject.getString("bankName");
      }
      localBankCard1 = localBankCard2;
      if (paramJSONObject.has("lastPay"))
      {
        localBankCard2.lastPay = paramJSONObject.getString("lastPay");
        localBankCard1 = localBankCard2;
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
        BankCard localBankCard1 = null;
      }
    }
    return localBankCard1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/security/query/QueryHpsCardResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */