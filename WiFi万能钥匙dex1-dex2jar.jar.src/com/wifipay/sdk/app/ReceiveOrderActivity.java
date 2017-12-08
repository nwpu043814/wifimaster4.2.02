package com.wifipay.sdk.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.analysis.analytics.ALInterface;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.sdk.a.a.d;
import com.wifipay.sdk.a.b;
import com.wifipay.sdk.c.g;
import com.wifipay.sdk.modelpay.PayReq;
import com.wifipay.sdk.modelpay.PayResp;
import com.wifipay.sdk.modelrpc.UnionOrder;
import com.wifipay.sdk.rpc.RpcClient;
import com.wifipay.sdk.util.e;
import com.wifipay.sdk.util.f;
import java.util.HashMap;
import java.util.Map;

public class ReceiveOrderActivity
  extends Activity
{
  public g a;
  private String b;
  
  static
  {
    StubApp1053578832.interface11(99);
  }
  
  private void a()
  {
    Object localObject = getIntent().getExtras();
    if (localObject == null) {
      finish();
    }
    for (;;)
    {
      return;
      PayReq localPayReq = new PayReq();
      localPayReq.fromBundle((Bundle)localObject);
      HashMap localHashMap = new HashMap();
      localHashMap.put("appId", localPayReq.appId);
      localHashMap.put("merchantOrderNo", localPayReq.merchantOrderNo);
      localHashMap.put("appName", localPayReq.appName);
      localHashMap.put("goodsDesc", localPayReq.goodsDesc);
      localHashMap.put("goodsName", localPayReq.goodsName);
      localHashMap.put("merchantNo", localPayReq.merchantNo);
      localHashMap.put("notifyUrl", localPayReq.notifyUrl);
      localHashMap.put("openId", localPayReq.openId);
      localHashMap.put("orderAmount", localPayReq.orderAmount);
      localHashMap.put("sign", localPayReq.sign);
      localHashMap.put("telNo", localPayReq.telNo);
      localHashMap.put("uhId", localPayReq.uhId);
      localHashMap.put("wifi_token", localPayReq.wifi_token);
      localHashMap.put("wifi_pub_channel", localPayReq.wifi_pub_channel);
      localHashMap.put("wifi_version", localPayReq.wifi_version);
      this.b = ((Bundle)localObject).getString("pn");
      localObject = localPayReq.ext;
      localHashMap.put("ext", localObject);
      com.wifipay.sdk.util.a.a(getApplicationContext(), "merchantData", localHashMap);
      ALInterface.onSignIn(getApplicationContext(), localPayReq.telNo);
      this.a.a(a.d.b);
      new Thread(new c(this, localPayReq, (String)localObject)).start();
    }
  }
  
  private void a(PayReq paramPayReq)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(this.b, this.b + ".wxapi.WXPayEntryActivity"));
    Bundle localBundle = new Bundle();
    paramPayReq.toBundle(localBundle);
    localIntent.putExtras(localBundle);
    localIntent.setFlags(268435456);
    startActivity(localIntent);
    finish();
  }
  
  private void a(PayReq paramPayReq, String paramString)
  {
    com.wifipay.sdk.util.c.a("kyo", "orderNo = " + paramPayReq.merchantOrderNo);
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderRequestTime", f.a(System.currentTimeMillis()));
    UnionOrder localUnionOrder = RpcClient.unionOrder(paramPayReq);
    localHashMap.put("orderResposeTime", f.a(System.currentTimeMillis()));
    localHashMap.put("orderResposeCode", localUnionOrder.resultCode);
    localHashMap.put("orderResposeMessage", localUnionOrder.resultMessage);
    localHashMap.put("merchantOrderNo", paramPayReq.merchantOrderNo);
    String str;
    if (localUnionOrder.activity)
    {
      str = "true";
      localHashMap.put("activity", str);
      com.wifipay.sdk.util.a.a(getApplicationContext(), "receiveOrder", localHashMap);
      this.a.a();
      com.wifipay.sdk.util.c.a("kyo", "order.resultCode. = " + localUnionOrder.resultCode);
      if (!localUnionOrder.resultCode.equals(b.d.a())) {
        break label315;
      }
      com.wifipay.sdk.util.c.a("kyo", "order.activity. = " + localUnionOrder.activity);
      com.wifipay.sdk.util.c.a("kyo", "order.resultObject. = " + localUnionOrder.resultObject);
      if (!localUnionOrder.activity) {
        break label298;
      }
      com.wifipay.sdk.util.c.a("kyo", "ext = " + paramString);
      a(localUnionOrder, paramString);
    }
    for (;;)
    {
      return;
      str = "false";
      break;
      label298:
      paramPayReq.jSessionID = localUnionOrder.resultObject;
      a(paramPayReq);
    }
    label315:
    paramPayReq = new PayResp();
    paramPayReq.errCode = -2;
    if (localUnionOrder.resultCode.equals(b.j.a())) {
      paramPayReq.errMsg = a.d.j;
    }
    for (;;)
    {
      com.wifipay.sdk.util.c.a("kyo", "resp.errMsg = " + paramPayReq.errMsg);
      com.wifipay.sdk.openapi.a.a(this, paramPayReq);
      finish();
      break;
      if (localUnionOrder.resultCode.equals(b.k.a())) {
        paramPayReq.errMsg = a.d.k;
      } else if ((localUnionOrder.resultCode.equals(b.f.a())) || (localUnionOrder.resultCode.equals(b.l.a())) || (localUnionOrder.resultCode.equals(b.e.a())) || (localUnionOrder.resultCode.equals(b.i.a()))) {
        paramPayReq.errMsg = a.d.s;
      } else if (localUnionOrder.resultCode.equals(b.h.a())) {
        paramPayReq.errMsg = a.d.o;
      } else if ((localUnionOrder.resultCode.equals(b.a.a())) || (localUnionOrder.resultCode.equals(b.b.a()))) {
        paramPayReq.errMsg = localUnionOrder.resultMessage;
      } else {
        paramPayReq.errMsg = a.d.t;
      }
    }
  }
  
  private void a(UnionOrder paramUnionOrder, String paramString)
  {
    e.a(this, e.a(paramUnionOrder.payString, this, true, e.a(paramString)), getIntent().getExtras().getString("_wifipay_merchantOrderNo"));
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.wifipay.sdk.util.c.a("kyo", " ReceiveOrderActivity onDestroy ");
  }
  
  protected void onPause()
  {
    super.onPause();
    ALInterface.onPause(this, "ReceiveOrderActivity");
  }
  
  protected void onResume()
  {
    super.onResume();
    ALInterface.onResume(this, "ReceiveOrderActivity");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/app/ReceiveOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */