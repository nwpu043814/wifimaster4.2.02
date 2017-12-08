package com.lantern.core.favorite;

import org.json.JSONObject;

public class SendMessageToWk
{
  public static class Req
  {
    public WkSceneFavorite mData;
    
    public String toString()
    {
      return this.mData.getJSONObject().toString();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/favorite/SendMessageToWk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */