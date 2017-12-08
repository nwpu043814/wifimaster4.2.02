package com.wifipay.wallet.prod.security.query;

import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.wallet.prod.core.model.WalletCard;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceResp
  extends BaseResp
{
  public WalletCard resultObject = new WalletCard();
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject")) {
        this.resultObject = parseCard(paramJSONObject.getJSONObject("resultObject"));
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
  
  public WalletCard parseCard(JSONObject paramJSONObject)
  {
    WalletCard localWalletCard2 = new WalletCard();
    try
    {
      if (paramJSONObject.has("enabled")) {
        localWalletCard2.enabled = paramJSONObject.getString("enabled");
      }
      if (paramJSONObject.has("paymentType")) {
        localWalletCard2.paymentType = paramJSONObject.getString("paymentType");
      }
      if (paramJSONObject.has("type")) {
        localWalletCard2.type = paramJSONObject.getString("type");
      }
      if (paramJSONObject.has("isDefault")) {
        localWalletCard2.isDefault = paramJSONObject.getString("isDefault");
      }
      if (paramJSONObject.has("state")) {
        localWalletCard2.state = paramJSONObject.getInt("state");
      }
      if (paramJSONObject.has("availableBalance")) {
        localWalletCard2.availableBalance = paramJSONObject.getString("availableBalance");
      }
      if (paramJSONObject.has("frozenBalance")) {
        localWalletCard2.frozenBalance = paramJSONObject.getString("frozenBalance");
      }
      if (paramJSONObject.has("icon")) {
        localWalletCard2.icon = paramJSONObject.getString("icon");
      }
      localWalletCard1 = localWalletCard2;
      if (paramJSONObject.has("name"))
      {
        localWalletCard2.name = paramJSONObject.getString("name");
        localWalletCard1 = localWalletCard2;
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
        WalletCard localWalletCard1 = null;
      }
    }
    return localWalletCard1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/security/query/WalletBalanceResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */