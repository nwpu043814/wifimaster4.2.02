package com.wifipay.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.wifipay.sdk.app.ReceiveOrderActivity;
import com.wifipay.sdk.modelpay.PayReq;
import com.wifipay.sdk.util.c;

public class PayAPI
{
  static final Object a = b.class;
  private Context b;
  
  PayAPI(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public String getVersion()
  {
    return "1.0.3";
  }
  
  public final boolean sendReq(PayReq paramPayReq)
  {
    c.a("kyo", "--sendReq--");
    if (!paramPayReq.checkArgs()) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      Intent localIntent = new Intent();
      String str = this.b.getPackageName();
      localIntent.setClass(this.b, ReceiveOrderActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putString("pn", str);
      paramPayReq.toBundle(localBundle);
      localIntent.putExtras(localBundle);
      localIntent.setFlags(268435456);
      this.b.startActivity(localIntent);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/openapi/PayAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */