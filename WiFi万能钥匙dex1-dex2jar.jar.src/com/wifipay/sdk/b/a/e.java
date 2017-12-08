package com.wifipay.sdk.b.a;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.wifipay.sdk.a.a.a;
import com.wifipay.sdk.a.a.d;
import com.wifipay.sdk.modelpay.PayResp;
import com.wifipay.sdk.util.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends com.wifipay.sdk.b.a
  implements IWXAPIEventHandler
{
  private String b;
  private IWXAPI c;
  private boolean d = true;
  
  public e(com.wifipay.sdk.app.a parama)
  {
    super(parama);
    this.c = WXAPIFactory.createWXAPI(parama.a, a.a.b);
    this.b = parama.a.getIntent().getExtras().getString("_wifipay_merchantOrderNo");
  }
  
  private void a(String paramString)
  {
    if ((this.a == null) || (this.a.e())) {}
    for (;;)
    {
      return;
      this.a.h().execute(new f(this, paramString));
    }
  }
  
  public String a()
  {
    return "wechat";
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = paramObject;
    this.a.c.a(localMessage);
  }
  
  public boolean a(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (Intent)paramMessage.obj;
      this.d = paramMessage.getBooleanExtra(a.a.h, true);
      this.c.handleIntent(paramMessage, this);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(String paramString, JSONObject paramJSONObject)
  {
    boolean bool = false;
    paramString = new HashMap();
    if ((!this.c.isWXAppInstalled()) && (!b()))
    {
      this.a.b.b(a.d.m);
      paramString.put("merchantOrderNo", this.b);
      paramString.put("wechatResultMessage", a.d.m);
      com.wifipay.sdk.util.a.a(this.a.a, "wechat", paramString);
    }
    for (;;)
    {
      return bool;
      if (!this.c.isWXAppSupportAPI())
      {
        this.a.b.b(a.d.n);
        paramString.put("merchantOrderNo", this.b);
        paramString.put("wechatResultMessage", a.d.n);
        com.wifipay.sdk.util.a.a(this.a.a, "wechat", paramString);
      }
      else
      {
        try
        {
          a(paramJSONObject.getString("paymentType"));
          bool = true;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    List localList = this.a.a.getPackageManager().getInstalledPackages(0);
    boolean bool1 = bool2;
    if (localList != null) {}
    for (int i = 0;; i++)
    {
      bool1 = bool2;
      if (i < localList.size())
      {
        String str = ((PackageInfo)localList.get(i)).packageName;
        c.a("kyo", "isWXInstalled = " + str);
        if (str.contains("com.tencent.mm")) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
    }
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    c.a("kyo", "WX result = " + paramBaseResp.errStr + " ( " + paramBaseResp.errCode + " )");
    Object localObject = new HashMap();
    ((Map)localObject).put("merchantOrderNo", this.b);
    ((Map)localObject).put("wechatResultCode", paramBaseResp.errCode);
    ((Map)localObject).put("wechatResultMessage", paramBaseResp.errStr);
    com.wifipay.sdk.util.a.a(this.a.a, "wechat", (Map)localObject);
    if (paramBaseResp.getType() == 5)
    {
      localObject = new PayResp();
      if (paramBaseResp.errCode != 0) {
        break label161;
      }
      ((PayResp)localObject).errCode = 0;
      ((PayResp)localObject).errMsg = a.d.u;
    }
    for (;;)
    {
      a((PayResp)localObject, this.d);
      return;
      label161:
      if (paramBaseResp.errCode == -1)
      {
        ((PayResp)localObject).errCode = -2;
        ((PayResp)localObject).errMsg = a.d.v;
      }
      else if (paramBaseResp.errCode == -2)
      {
        ((PayResp)localObject).errCode = -3;
        ((PayResp)localObject).errMsg = a.d.w;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */