package com.wifipay.sdk.b.a;

import android.text.TextUtils;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.wifipay.sdk.a.a.a;
import com.wifipay.sdk.a.a.d;
import com.wifipay.sdk.a.b;
import com.wifipay.sdk.c.g;
import com.wifipay.sdk.modelpay.PayResp;
import com.wifipay.sdk.modelrpc.QueryOrderInfo;
import com.wifipay.sdk.rpc.RpcClient;
import com.wifipay.sdk.util.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class f
  implements Runnable
{
  f(e parame, String paramString) {}
  
  public void run()
  {
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("requestPayTime", com.wifipay.sdk.util.f.a(System.currentTimeMillis()));
    Object localObject1 = RpcClient.queryOrderInfo(e.a(this.b).d, this.a);
    ((Map)localObject2).put("resposePayTime", com.wifipay.sdk.util.f.a(System.currentTimeMillis()));
    ((Map)localObject2).put("orderResposeCode", ((QueryOrderInfo)localObject1).resultCode);
    ((Map)localObject2).put("orderResposeMessage", ((QueryOrderInfo)localObject1).resultMessage);
    ((Map)localObject2).put("merchantOrderNo", e.b(this.b));
    ((Map)localObject2).put("payMethod", "wechat");
    com.wifipay.sdk.util.a.a(e.c(this.b).a, "wechat", (Map)localObject2);
    if ((e.d(this.b) == null) || (e.e(this.b).e())) {}
    for (;;)
    {
      return;
      if (((QueryOrderInfo)localObject1).resultCode.equals(b.d.a()))
      {
        e.f(this.b).a();
        localObject2 = ((QueryOrderInfo)localObject1).resultObject;
        c.a("kyo", "wxpay result = " + (String)localObject2);
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label337;
          }
          localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>((String)localObject2);
          localObject2 = new com/tencent/mm/sdk/modelpay/PayReq;
          ((PayReq)localObject2).<init>();
          ((PayReq)localObject2).appId = ((JSONObject)localObject1).getString("appid");
          ((PayReq)localObject2).partnerId = ((JSONObject)localObject1).getString("partnerid");
          ((PayReq)localObject2).prepayId = ((JSONObject)localObject1).getString("prepayid");
          ((PayReq)localObject2).nonceStr = ((JSONObject)localObject1).getString("noncestr");
          ((PayReq)localObject2).timeStamp = ((JSONObject)localObject1).getString("timestamp");
          ((PayReq)localObject2).packageValue = ((JSONObject)localObject1).getString("package");
          ((PayReq)localObject2).sign = ((JSONObject)localObject1).getString("sign");
          ((PayReq)localObject2).extData = a.a.e;
          e.g(this.b).sendReq((BaseReq)localObject2);
        }
        catch (JSONException localJSONException)
        {
          e.j(this.b).b();
          localJSONException.printStackTrace();
        }
        continue;
        label337:
        e.i(this.b).b();
      }
      else
      {
        if ((!localJSONException.resultCode.equals(b.a.a())) && (!localJSONException.resultCode.equals(b.b.a()))) {
          break;
        }
        e.k(this.b).b.b(localJSONException.resultMessage);
      }
    }
    e.l(this.b).b();
    localObject2 = new PayResp();
    ((PayResp)localObject2).errCode = -2;
    if (localJSONException.resultCode.equals(b.h.a()))
    {
      e.m(this.b).b.b(a.d.o);
      ((PayResp)localObject2).errMsg = a.d.o;
    }
    for (;;)
    {
      this.b.a((PayResp)localObject2, e.n(this.b));
      break;
      if ((localJSONException.resultCode.equals(b.f.a())) || (localJSONException.resultCode.equals(b.l.a())) || (localJSONException.resultCode.equals(b.e.a())) || (localJSONException.resultCode.equals(b.i.a()))) {
        ((PayResp)localObject2).errMsg = a.d.s;
      } else {
        ((PayResp)localObject2).errMsg = a.d.t;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/b/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */