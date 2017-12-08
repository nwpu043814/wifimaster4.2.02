package com.lantern.sdk.pay;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.k;
import com.lantern.core.o;
import com.lantern.core.p;
import com.lantern.sdk.stub.b;
import com.wifipay.sdk.modelpay.PayReq;
import com.wifipay.sdk.modelpay.PayResp;
import com.wifipay.sdk.openapi.APIFactory;
import com.wifipay.sdk.openapi.PayAPI;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    a(paramActivity, com.lantern.sdk.stub.a.a(paramIntent));
  }
  
  public static void a(Activity paramActivity, com.lantern.sdk.stub.a parama)
  {
    PayAPI localPayAPI = APIFactory.createAPI(paramActivity);
    PayReq localPayReq = new PayReq();
    for (;;)
    {
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(parama.d);
        str5 = ((JSONObject)localObject1).getString("appName");
        str1 = ((JSONObject)localObject1).getString("openId");
        str7 = ((JSONObject)localObject1).getString("goodsName");
        str4 = ((JSONObject)localObject1).getString("orderAmount");
        str8 = ((JSONObject)localObject1).getString("merchantNo");
        str3 = ((JSONObject)localObject1).getString("merchantOrderNo");
        str2 = ((JSONObject)localObject1).getString("sign");
        str6 = ((JSONObject)localObject1).getString("notifyUrl");
        localObject3 = ((JSONObject)localObject1).optString("ext");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        String str5;
        String str1;
        String str7;
        String str4;
        String str8;
        String str3;
        String str2;
        String str6;
        Object localObject3;
        Object localObject2;
        localException.printStackTrace();
        continue;
      }
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>((String)localObject3);
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = new org/json/JSONObject;
          ((JSONObject)localObject3).<init>();
        }
        ((JSONObject)localObject3).put("dhid", c.getServer().g());
        ((JSONObject)localObject3).put("imei", k.c(c.getInstance()));
        ((JSONObject)localObject3).put("mac", k.e(c.getInstance()));
        ((JSONObject)localObject3).put("androidid", k.g(c.getInstance()));
        ((JSONObject)localObject3).put("pkgname", parama.c);
        ((JSONObject)localObject3).put("wifiversion", k.b(c.getInstance()));
        localObject1 = ((JSONObject)localObject3).toString();
        localPayReq.merchantNo = str8;
        localPayReq.merchantOrderNo = str3;
        localPayReq.goodsName = str7;
        localPayReq.orderAmount = str4;
        localPayReq.appName = str5;
        localPayReq.openId = str1;
        localPayReq.sign = str2;
        localPayReq.notifyUrl = str6;
        localPayReq.wifi_version = c.getVersionName();
        localPayReq.wifi_pub_channel = c.getServer().b();
        localPayReq.wifi_token = p.f(c.getInstance());
        localPayReq.third_pkg = parama.c;
        localPayReq.ext = ((String)localObject1);
        localPayReq.appId = parama.b;
        if (c.getServer().q())
        {
          localPayReq.uhId = p.c("");
          localPayReq.telNo = p.c(paramActivity);
        }
        if (!localPayAPI.sendReq(localPayReq))
        {
          h.c("Payment failed");
          localObject3 = new b("pay");
          localObject1 = new PayResp();
          ((PayResp)localObject1).errCode = -2;
          ((PayResp)localObject1).errMsg = "pay failed";
          ((PayResp)localObject1).ext = localPayReq.ext;
          ((b)localObject3).d = JSON.toJSONString(localObject1);
          ((b)localObject3).b = ((PayResp)localObject1).errCode;
          ((b)localObject3).c = ((PayResp)localObject1).errMsg;
          b.a(paramActivity, parama.c, (b)localObject3);
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      localObject2 = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/sdk/pay/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */