package com.wifipay.sdk.b.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.wifipay.sdk.a.a.d;
import com.wifipay.sdk.app.g;
import com.wifipay.sdk.modelpay.PayResp;
import com.wifipay.sdk.openapi.b;
import com.wifipay.sdk.util.e;
import com.wifipay.wallet.pay.SPayResp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends com.wifipay.sdk.b.a
{
  private String b;
  
  public c(com.wifipay.sdk.app.a parama)
  {
    super(parama);
    this.b = parama.a.getIntent().getExtras().getString("_wifipay_merchantOrderNo");
  }
  
  private void a(String paramString)
  {
    if ((this.a == null) || (this.a.e())) {}
    for (;;)
    {
      return;
      this.a.h().execute(new d(this, paramString));
    }
  }
  
  private void b(String paramString)
  {
    a(e.a(paramString, this.a.a));
  }
  
  public String a()
  {
    return "wifi";
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = paramObject;
    this.a.c.a(localMessage);
  }
  
  public boolean a(Message paramMessage)
  {
    Object localObject;
    boolean bool;
    if (paramMessage.what == 3)
    {
      com.wifipay.sdk.util.c.a("kyo", "shengpay result = " + paramMessage.obj);
      paramMessage = (SPayResp)paramMessage.obj;
      localObject = new HashMap();
      ((Map)localObject).put("merchantOrderNo", this.b);
      if (paramMessage != null)
      {
        ((Map)localObject).put("wifiResultCode", paramMessage.resultCode);
        ((Map)localObject).put("wifiResultMessage", paramMessage.resultMessage);
      }
      com.wifipay.sdk.util.a.a(this.a.a, "wifi", (Map)localObject);
      if (paramMessage == null)
      {
        a(b.a(), true);
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      localObject = new PayResp();
      int i = Integer.valueOf(paramMessage.resultCode).intValue();
      com.wifipay.sdk.util.c.a("kyo", "resultCode = " + i);
      if (i == 0)
      {
        ((PayResp)localObject).errCode = 0;
        ((PayResp)localObject).errMsg = a.d.u;
        e.a((PayResp)localObject, paramMessage.telNo, paramMessage.merchantOrederNo);
      }
      for (;;)
      {
        a((PayResp)localObject, true);
        bool = true;
        break;
        if (i == -2)
        {
          ((PayResp)localObject).errCode = -2;
          ((PayResp)localObject).errMsg = a.d.v;
        }
        else if (i == -3)
        {
          ((PayResp)localObject).errCode = -3;
          ((PayResp)localObject).errMsg = a.d.w;
        }
        else if (i == -1)
        {
          ((PayResp)localObject).errCode = -1;
          ((PayResp)localObject).errMsg = a.d.x;
        }
      }
      bool = false;
    }
  }
  
  public boolean a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      a(paramJSONObject.getString("paymentType"));
      bool = true;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        boolean bool = false;
      }
    }
    return bool;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */