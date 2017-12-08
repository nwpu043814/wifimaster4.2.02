package com.wifipay.sdk.b.a;

import com.alipay.sdk.app.PayTask;
import com.wifipay.sdk.a.a.d;
import com.wifipay.sdk.c.g;
import com.wifipay.sdk.modelpay.PayResp;
import com.wifipay.sdk.modelrpc.QueryOrderInfo;
import com.wifipay.sdk.rpc.RpcClient;
import com.wifipay.sdk.util.c;
import com.wifipay.sdk.util.f;
import java.util.HashMap;
import java.util.Map;

class b
  implements Runnable
{
  b(a parama, String paramString) {}
  
  public void run()
  {
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("requestPayTime", f.a(System.currentTimeMillis()));
    Object localObject1 = RpcClient.queryOrderInfo(a.a(this.b).d, this.a);
    ((Map)localObject2).put("resposePayTime", f.a(System.currentTimeMillis()));
    ((Map)localObject2).put("orderResposeCode", ((QueryOrderInfo)localObject1).resultCode);
    ((Map)localObject2).put("orderResposeMessage", ((QueryOrderInfo)localObject1).resultMessage);
    ((Map)localObject2).put("merchantOrderNo", a.b(this.b));
    ((Map)localObject2).put("payMethod", "alipay");
    com.wifipay.sdk.util.a.a(a.c(this.b).a, "alipay", (Map)localObject2);
    if ((a.d(this.b) == null) || (a.e(this.b).e())) {}
    for (;;)
    {
      return;
      c.a("kyo", "alipay orderInfo.resultCode = " + ((QueryOrderInfo)localObject1).resultCode);
      if (((QueryOrderInfo)localObject1).resultCode.equals(com.wifipay.sdk.a.b.d.a()))
      {
        a.f(this.b).a();
        localObject2 = ((QueryOrderInfo)localObject1).resultObject;
        c.a("kyo", "alipay orderInfo.resultObject = " + ((QueryOrderInfo)localObject1).resultObject);
        localObject1 = new PayTask(a.g(this.b).a);
        a.h(this.b).b.a();
        localObject1 = ((PayTask)localObject1).pay((String)localObject2, true);
        c.a("kyo", "alipay result = " + (String)localObject1);
        this.b.a(localObject1);
      }
      else
      {
        if ((!((QueryOrderInfo)localObject1).resultCode.equals(com.wifipay.sdk.a.b.a.a())) && (!((QueryOrderInfo)localObject1).resultCode.equals(com.wifipay.sdk.a.b.b.a()))) {
          break;
        }
        a.i(this.b).b.b(((QueryOrderInfo)localObject1).resultMessage);
      }
    }
    a.j(this.b).b();
    localObject2 = new PayResp();
    ((PayResp)localObject2).errCode = -2;
    if (((QueryOrderInfo)localObject1).resultCode.equals(com.wifipay.sdk.a.b.h.a()))
    {
      a.k(this.b).b.b(a.d.o);
      ((PayResp)localObject2).errMsg = a.d.o;
    }
    for (;;)
    {
      this.b.a((PayResp)localObject2, true);
      break;
      if ((((QueryOrderInfo)localObject1).resultCode.equals(com.wifipay.sdk.a.b.f.a())) || (((QueryOrderInfo)localObject1).resultCode.equals(com.wifipay.sdk.a.b.l.a())) || (((QueryOrderInfo)localObject1).resultCode.equals(com.wifipay.sdk.a.b.e.a())) || (((QueryOrderInfo)localObject1).resultCode.equals(com.wifipay.sdk.a.b.i.a()))) {
        ((PayResp)localObject2).errMsg = a.d.s;
      } else {
        ((PayResp)localObject2).errMsg = a.d.t;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */