package com.wifipay.sdk.b.a;

import com.wifipay.sdk.a.a.d;
import com.wifipay.sdk.a.b;
import com.wifipay.sdk.c.g;
import com.wifipay.sdk.modelpay.PayResp;
import com.wifipay.sdk.modelrpc.QueryOrderInfo;
import com.wifipay.sdk.rpc.RpcClient;
import com.wifipay.sdk.util.f;
import java.util.HashMap;
import java.util.Map;

class d
  implements Runnable
{
  d(c paramc, String paramString) {}
  
  public void run()
  {
    c.a(this.b).b.a();
    Object localObject = new HashMap();
    ((Map)localObject).put("requestPayTime", f.a(System.currentTimeMillis()));
    QueryOrderInfo localQueryOrderInfo = RpcClient.queryOrderInfo(c.b(this.b).d, this.a);
    ((Map)localObject).put("resposePayTime", f.a(System.currentTimeMillis()));
    ((Map)localObject).put("orderResposeCode", localQueryOrderInfo.resultCode);
    ((Map)localObject).put("orderResposeMessage", localQueryOrderInfo.resultMessage);
    ((Map)localObject).put("merchantOrderNo", c.c(this.b));
    ((Map)localObject).put("payMethod", "wifi");
    com.wifipay.sdk.util.a.a(c.d(this.b).a, "wifi", (Map)localObject);
    com.wifipay.sdk.util.c.a("kyo", "SPay  orderInfo = " + localQueryOrderInfo);
    if ((c.e(this.b) == null) || (c.f(this.b).e())) {}
    for (;;)
    {
      return;
      com.wifipay.sdk.util.c.a("kyo", "SPay  resultCode = " + localQueryOrderInfo.resultCode);
      if (localQueryOrderInfo.resultCode.equals(b.d.a()))
      {
        c.g(this.b).a();
        com.wifipay.sdk.util.c.a("kyo", "SPay  resultObject = " + localQueryOrderInfo.resultObject);
        c.a(this.b, localQueryOrderInfo.resultObject);
      }
      else
      {
        if ((!localQueryOrderInfo.resultCode.equals(b.a.a())) && (!localQueryOrderInfo.resultCode.equals(b.b.a()))) {
          break;
        }
        c.h(this.b).b.b(localQueryOrderInfo.resultMessage);
      }
    }
    c.i(this.b).b();
    localObject = new PayResp();
    ((PayResp)localObject).errCode = -2;
    if (localQueryOrderInfo.resultCode.equals(b.h.a()))
    {
      c.j(this.b).b.b(a.d.o);
      ((PayResp)localObject).errMsg = a.d.o;
    }
    for (;;)
    {
      this.b.a((PayResp)localObject, true);
      break;
      if ((localQueryOrderInfo.resultCode.equals(b.f.a())) || (localQueryOrderInfo.resultCode.equals(b.l.a())) || (localQueryOrderInfo.resultCode.equals(b.e.a())) || (localQueryOrderInfo.resultCode.equals(b.i.a()))) {
        ((PayResp)localObject).errMsg = a.d.s;
      } else {
        ((PayResp)localObject).errMsg = a.d.t;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */