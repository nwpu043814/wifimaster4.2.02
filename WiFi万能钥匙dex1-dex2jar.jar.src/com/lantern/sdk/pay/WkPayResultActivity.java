package com.lantern.sdk.pay;

import android.content.Intent;
import android.os.Bundle;
import com.bluefay.b.h;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.sdk.modelpay.PayResp;

public class WkPayResultActivity
  extends bluefay.app.b
{
  static
  {
    StubApp1053578832.interface11(44);
  }
  
  private void a(Intent paramIntent)
  {
    PayResp localPayResp = new PayResp();
    localPayResp.fromBundle(paramIntent.getExtras());
    h.a("handleIntent pay OnResponse " + PayResp.getJSParams(localPayResp), new Object[0]);
    paramIntent = new com.lantern.sdk.stub.b("pay");
    paramIntent.d = PayResp.getJSParams(localPayResp);
    paramIntent.c = localPayResp.errMsg;
    paramIntent.b = localPayResp.errCode;
    com.lantern.sdk.stub.b.a(this, localPayResp.third_pkg, paramIntent);
    finish();
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/sdk/pay/WkPayResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */