package com.lantern.core.favorite;

public abstract interface IWkAPI
{
  public abstract void cancle(SendMessageToWk.Req paramReq);
  
  public abstract void query(SendMessageToWk.Req paramReq);
  
  public abstract void sendReq(SendMessageToWk.Req paramReq);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/favorite/IWkAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */