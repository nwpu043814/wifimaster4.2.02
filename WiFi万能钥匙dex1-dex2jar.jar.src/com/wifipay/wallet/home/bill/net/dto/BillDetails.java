package com.wifipay.wallet.home.bill.net.dto;

import com.wifipay.common.net.entitybase.BaseResp;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BillDetails
  extends BaseResp
  implements Serializable
{
  private static final long serialVersionUID = -1098966235058186524L;
  public ArrayList<Bills> resultObject;
  
  private Bills parseBills(JSONObject paramJSONObject)
  {
    Bills localBills = new Bills();
    try
    {
      if (paramJSONObject.has("bizCode")) {
        localBills.bizCode = paramJSONObject.getString("bizCode");
      }
      if (paramJSONObject.has("bizDesc")) {
        localBills.bizDesc = paramJSONObject.getString("bizDesc");
      }
      if (paramJSONObject.has("orderId")) {
        localBills.orderId = paramJSONObject.getString("orderId");
      }
      if (paramJSONObject.has("amount")) {
        localBills.amount = paramJSONObject.getString("amount");
      }
      if (paramJSONObject.has("party")) {
        localBills.party = paramJSONObject.getString("party");
      }
      if (paramJSONObject.has("partyName")) {
        localBills.partyName = paramJSONObject.getString("partyName");
      }
      if (paramJSONObject.has("cardNo")) {
        localBills.cardNo = paramJSONObject.getString("cardNo");
      }
      if (paramJSONObject.has("status")) {
        localBills.status = paramJSONObject.getString("status");
      }
      if (paramJSONObject.has("statusDesc")) {
        localBills.statusDesc = paramJSONObject.getString("statusDesc");
      }
      if (paramJSONObject.has("tradeTime")) {
        localBills.tradeTime = paramJSONObject.getString("tradeTime");
      }
      if (paramJSONObject.has("direction")) {
        localBills.direction = paramJSONObject.getString("direction");
      }
      if (paramJSONObject.has("transType")) {
        localBills.transType = paramJSONObject.getString("transType");
      }
      if (paramJSONObject.has("detailUrl")) {
        localBills.detailUrl = paramJSONObject.getString("detailUrl");
      }
      if (paramJSONObject.has("leavingFund")) {
        localBills.leavingFund = paramJSONObject.getString("leavingFund");
      }
      if (paramJSONObject.has("memo")) {
        localBills.memo = paramJSONObject.getString("memo");
      }
      if (paramJSONObject.has("goodsInfo")) {
        localBills.goodsInfo = paramJSONObject.getString("goodsInfo");
      }
      if (paramJSONObject.has("merchantOrderNo")) {
        localBills.merchantOrderNo = paramJSONObject.getString("merchantOrderNo");
      }
      if (paramJSONObject.has("reductionAmount")) {
        localBills.merchantOrderNo = paramJSONObject.getString("reductionAmount");
      }
      if (paramJSONObject.has("feeAmount")) {
        localBills.merchantOrderNo = paramJSONObject.getString("feeAmount");
      }
      if (paramJSONObject.has("ext"))
      {
        localBills.ext = paramJSONObject.getString("ext");
        paramJSONObject = new org/json/JSONObject;
        paramJSONObject.<init>(localBills.ext);
        if (paramJSONObject.has("isOncentActivity")) {
          localBills.isOncentActivity = paramJSONObject.getString("isOncentActivity");
        }
        if (paramJSONObject.has("cardNo")) {
          localBills.oncentCardNo = paramJSONObject.getString("cardNo");
        }
        if (paramJSONObject.has("passwd")) {
          localBills.oncentPasswd = paramJSONObject.getString("passwd");
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
    return localBills;
  }
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>();
        this.resultObject = localArrayList;
        paramJSONObject = paramJSONObject.getJSONArray("resultObject");
        for (int i = 0; i < paramJSONObject.length(); i++) {
          this.resultObject.add(parseBills(paramJSONObject.getJSONObject(i)));
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static class Bills
    implements Serializable
  {
    private static final long serialVersionUID = -4270152409002995614L;
    public String amount;
    public String bizCode;
    public String bizDesc;
    public String cardNo;
    public String detailUrl;
    public String direction;
    public String ext;
    public String feeAmount;
    public String goodsInfo;
    public String isOncentActivity;
    public String leavingFund;
    public String memo;
    public String merchantOrderNo;
    public String oncentCardNo;
    public String oncentPasswd;
    public String orderId;
    public String party;
    public String partyName;
    public String reductionAmount;
    public String status;
    public String statusDesc;
    public String tradeTime;
    public String transType;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/net/dto/BillDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */