package com.wifipay.wallet.prod.transfer;

import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.wallet.transfer.ContactsDetail;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TransQueryContactsResp
  extends BaseResp
{
  public ResultObject resultObject;
  
  public void parseBody(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject1 = new com/wifipay/wallet/prod/transfer/TransQueryContactsResp$ResultObject;
      ((ResultObject)localObject1).<init>();
      this.resultObject = ((ResultObject)localObject1);
      paramJSONObject = paramJSONObject.getJSONObject("resultObject");
      if (paramJSONObject.has("totalPage")) {
        this.resultObject.totalPage = paramJSONObject.getString("totalPage");
      }
      if (paramJSONObject.has("contactList"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("contactList");
        Object localObject2;
        if (this.resultObject.contactList == null)
        {
          localObject1 = this.resultObject;
          localObject2 = new java/util/ArrayList;
          ((ArrayList)localObject2).<init>();
          ((ResultObject)localObject1).contactList = ((ArrayList)localObject2);
        }
        for (int i = 0; i < paramJSONObject.length(); i++)
        {
          localObject1 = (JSONObject)paramJSONObject.get(i);
          localObject2 = new com/wifipay/wallet/transfer/ContactsDetail;
          ((ContactsDetail)localObject2).<init>();
          if (((JSONObject)localObject1).has("payeeLoginName")) {
            ((ContactsDetail)localObject2).payeeLoginName = ((JSONObject)localObject1).getString("payeeLoginName");
          }
          if (((JSONObject)localObject1).has("payeeName")) {
            ((ContactsDetail)localObject2).payeeName = ((JSONObject)localObject1).getString("payeeName");
          }
          this.resultObject.contactList.add(localObject2);
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static class ResultObject
    implements Serializable
  {
    public ArrayList<ContactsDetail> contactList;
    public String totalPage;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/transfer/TransQueryContactsResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */