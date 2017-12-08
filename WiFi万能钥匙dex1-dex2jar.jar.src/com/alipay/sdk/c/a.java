package com.alipay.sdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.j.h;
import org.json.JSONObject;

public final class a
{
  private static a c;
  int a = 3500;
  public String b = "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&";
  
  public static a b()
  {
    a locala;
    String str;
    if (c == null)
    {
      locala = new a();
      c = locala;
      str = h.b(com.alipay.sdk.h.b.a().a, "alipay_cashier_dynamic_config", null);
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(str);
      locala.a = localJSONObject.optInt("timeout", 3500);
      locala.b = localJSONObject.optString("tbreturl", "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&").trim();
      return c;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public final int a()
  {
    if ((this.a < 1000) || (this.a > 20000)) {}
    for (int i = 3500;; i = this.a)
    {
      return i;
      new StringBuilder("DynamicConfig::getJumpTimeout >").append(this.a);
    }
  }
  
  public final void a(Context paramContext)
  {
    new Thread(new b(this, paramContext)).start();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */