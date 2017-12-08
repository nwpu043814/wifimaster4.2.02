package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class AddCardToWXCardPackage
{
  public static class Req
    extends BaseReq
  {
    public List<AddCardToWXCardPackage.WXCardItem> cardArrary;
    
    public boolean checkArgs()
    {
      boolean bool;
      if ((this.cardArrary == null) || (this.cardArrary.size() == 0) || (this.cardArrary.size() > 40)) {
        bool = false;
      }
      for (;;)
      {
        return bool;
        Iterator localIterator = this.cardArrary.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            AddCardToWXCardPackage.WXCardItem localWXCardItem = (AddCardToWXCardPackage.WXCardItem)localIterator.next();
            if ((localWXCardItem == null) || (localWXCardItem.cardId == null) || (localWXCardItem.cardId.length() > 1024) || ((localWXCardItem.cardExtMsg != null) && (localWXCardItem.cardExtMsg.length() > 1024)))
            {
              bool = false;
              break;
            }
          }
        }
        bool = true;
      }
    }
    
    public int getType()
    {
      return 9;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      JSONStringer localJSONStringer = new JSONStringer();
      try
      {
        localJSONStringer.object();
        localJSONStringer.key("card_list");
        localJSONStringer.array();
        Iterator localIterator = this.cardArrary.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject = (AddCardToWXCardPackage.WXCardItem)localIterator.next();
            localJSONStringer.object();
            localJSONStringer.key("card_id");
            localJSONStringer.value(((AddCardToWXCardPackage.WXCardItem)localObject).cardId);
            localJSONStringer.key("card_ext");
            if (((AddCardToWXCardPackage.WXCardItem)localObject).cardExtMsg == null)
            {
              localObject = "";
              localJSONStringer.value(localObject);
              localJSONStringer.endObject();
              continue;
              paramBundle.putString("_wxapi_add_card_to_wx_card_list", localJSONStringer.toString());
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      for (;;)
      {
        return;
        String str = localException.cardExtMsg;
        break;
        localJSONStringer.endArray();
        localJSONStringer.endObject();
      }
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public List<AddCardToWXCardPackage.WXCardItem> cardArrary;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      if ((this.cardArrary == null) || (this.cardArrary.size() == 0)) {}
      for (boolean bool = false;; bool = true) {
        return bool;
      }
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      if (this.cardArrary == null) {
        this.cardArrary = new LinkedList();
      }
      Object localObject = paramBundle.getString("_wxapi_add_card_to_wx_card_list");
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        try
        {
          paramBundle = new org/json/JSONTokener;
          paramBundle.<init>((String)localObject);
          JSONArray localJSONArray = ((JSONObject)paramBundle.nextValue()).getJSONArray("card_list");
          for (int i = 0; i < localJSONArray.length(); i++)
          {
            paramBundle = localJSONArray.getJSONObject(i);
            localObject = new com/tencent/mm/sdk/modelbiz/AddCardToWXCardPackage$WXCardItem;
            ((AddCardToWXCardPackage.WXCardItem)localObject).<init>();
            ((AddCardToWXCardPackage.WXCardItem)localObject).cardId = paramBundle.optString("card_id");
            ((AddCardToWXCardPackage.WXCardItem)localObject).cardExtMsg = paramBundle.optString("card_ext");
            ((AddCardToWXCardPackage.WXCardItem)localObject).cardState = paramBundle.optInt("is_succ");
            this.cardArrary.add(localObject);
          }
          return;
        }
        catch (Exception paramBundle) {}
      }
    }
    
    public int getType()
    {
      return 9;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      JSONStringer localJSONStringer = new JSONStringer();
      AddCardToWXCardPackage.WXCardItem localWXCardItem;
      try
      {
        localJSONStringer.object();
        localJSONStringer.key("card_list");
        localJSONStringer.array();
        Iterator localIterator = this.cardArrary.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localWXCardItem = (AddCardToWXCardPackage.WXCardItem)localIterator.next();
            localJSONStringer.object();
            localJSONStringer.key("card_id");
            localJSONStringer.value(localWXCardItem.cardId);
            localJSONStringer.key("card_ext");
            if (localWXCardItem.cardExtMsg == null)
            {
              String str1 = "";
              localJSONStringer.value(str1);
              localJSONStringer.key("is_succ");
              localJSONStringer.value(localWXCardItem.cardState);
              localJSONStringer.endObject();
              continue;
              paramBundle.putString("_wxapi_add_card_to_wx_card_list", localJSONStringer.toString());
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      for (;;)
      {
        return;
        String str2 = localWXCardItem.cardExtMsg;
        break;
        localJSONStringer.endArray();
        localJSONStringer.endObject();
      }
    }
  }
  
  public static final class WXCardItem
  {
    public String cardExtMsg;
    public String cardId;
    public int cardState;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/modelbiz/AddCardToWXCardPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */