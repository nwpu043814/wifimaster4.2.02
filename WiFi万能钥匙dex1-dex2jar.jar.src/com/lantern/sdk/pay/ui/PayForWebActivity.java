package com.lantern.sdk.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import bluefay.app.b;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.qihoo.util.StubApp1053578832;
import org.json.JSONException;
import org.json.JSONObject;

public class PayForWebActivity
  extends b
{
  private String e;
  
  static
  {
    StubApp1053578832.interface11(45);
  }
  
  private void a(Intent paramIntent)
  {
    h.a("intent action " + paramIntent.getAction(), new Object[0]);
    Object localObject1;
    String str;
    Object localObject2;
    if ("wifi.intent.action.SDK_RESULT".equals(paramIntent.getAction()))
    {
      localObject1 = paramIntent.getStringExtra("data");
      str = this.e;
      h.a("send pay finish msg payResp " + (String)localObject1 + " callback--> " + str, new Object[0]);
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 128801;
      paramIntent = new Bundle();
      paramIntent.putString("data", (String)localObject1);
      paramIntent.putString("callback", str);
      ((Message)localObject2).obj = paramIntent;
      c.dispatch((Message)localObject2);
      finish();
    }
    for (;;)
    {
      return;
      if (!"wifi.intent.action.SEND_PAY_REQ".equals(paramIntent.getAction())) {
        continue;
      }
      str = paramIntent.getStringExtra("ext");
      this.e = paramIntent.getStringExtra("callback");
      h.a("pay ext ****" + str, new Object[0]);
      h.a("pay callback ****" + this.e, new Object[0]);
      paramIntent = new JSONObject();
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(str);
        paramIntent = (Intent)localObject1;
        localObject2 = paramIntent.optString("appId");
        str = paramIntent.optString("openId");
        localObject1 = str;
        if (TextUtils.isEmpty(str)) {
          localObject1 = "";
        }
      }
      catch (JSONException localJSONException)
      {
        try
        {
          paramIntent.put("openId", localObject1);
          localObject1 = new com.lantern.sdk.stub.a("pay");
          ((com.lantern.sdk.stub.a)localObject1).b = ((String)localObject2);
          ((com.lantern.sdk.stub.a)localObject1).c = getPackageName();
          ((com.lantern.sdk.stub.a)localObject1).d = paramIntent.toString();
          h.a("req is params " + ((com.lantern.sdk.stub.a)localObject1).d, new Object[0]);
          com.lantern.sdk.pay.a.a(this, (com.lantern.sdk.stub.a)localObject1);
          continue;
          localJSONException = localJSONException;
          localJSONException.printStackTrace();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/sdk/pay/ui/PayForWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */