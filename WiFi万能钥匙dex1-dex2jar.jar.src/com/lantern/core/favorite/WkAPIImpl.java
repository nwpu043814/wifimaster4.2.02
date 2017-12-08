package com.lantern.core.favorite;

import android.content.Context;
import android.content.Intent;
import com.bluefay.a.e;

public class WkAPIImpl
  implements IWkAPI
{
  private Context mContext;
  
  WkAPIImpl(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void cancle(SendMessageToWk.Req paramReq)
  {
    Intent localIntent = new Intent("wifi.intent.action.FAVORITEREQUEST");
    localIntent.setPackage(this.mContext.getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("what", "cancle");
    localIntent.putExtra("data", paramReq.toString());
    e.a(this.mContext, localIntent);
  }
  
  public void query(SendMessageToWk.Req paramReq)
  {
    Intent localIntent = new Intent("wifi.intent.action.FAVORITEREQUEST");
    localIntent.setPackage(this.mContext.getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("what", "query");
    localIntent.putExtra("data", paramReq.toString());
    e.a(this.mContext, localIntent);
  }
  
  public void sendReq(SendMessageToWk.Req paramReq)
  {
    Intent localIntent = new Intent("wifi.intent.action.FAVORITEREQUEST");
    localIntent.setPackage(this.mContext.getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("what", "insert");
    localIntent.putExtra("data", paramReq.toString());
    e.a(this.mContext, localIntent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/favorite/WkAPIImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */