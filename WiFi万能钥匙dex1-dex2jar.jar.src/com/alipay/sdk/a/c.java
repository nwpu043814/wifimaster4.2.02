package com.alipay.sdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONObject;

public final class c
{
  b a;
  Context b;
  
  public c(Context paramContext, b paramb)
  {
    this.b = paramContext;
    this.a = paramb;
  }
  
  public final void a(a parama)
  {
    if (TextUtils.isEmpty(parama.c)) {
      a(parama.a, a.a.c);
    }
    for (;;)
    {
      return;
      parama = new d(this, parama);
      if (Looper.getMainLooper() == Looper.myLooper()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label61;
        }
        parama.run();
        break;
      }
      label61:
      new Handler(Looper.getMainLooper()).post(parama);
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("error", paramInt - 1);
      a locala = new a("callback");
      locala.e = localJSONObject;
      locala.a = paramString;
      this.a.a(locala);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */