package com.wifipay.sdk.b;

import android.app.Activity;
import android.os.Message;
import com.wifipay.sdk.modelpay.PayResp;
import org.json.JSONObject;

public abstract class a
{
  protected com.wifipay.sdk.app.a a;
  
  public a(com.wifipay.sdk.app.a parama)
  {
    this.a = parama;
  }
  
  public abstract String a();
  
  public void a(PayResp paramPayResp, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPayResp.errCode == -3)) {
      this.a.g();
    }
    for (;;)
    {
      return;
      com.wifipay.sdk.openapi.a.a(this.a.a, paramPayResp);
      this.a.a.finish();
    }
  }
  
  public void a(Object paramObject)
  {
    this.a.b();
  }
  
  public abstract boolean a(Message paramMessage);
  
  public abstract boolean a(String paramString, JSONObject paramJSONObject);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */