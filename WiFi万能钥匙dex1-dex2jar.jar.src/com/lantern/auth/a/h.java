package com.lantern.auth.a;

import cm.pass.sdk.auth.TokenListener;
import org.json.JSONObject;

final class h
  implements TokenListener
{
  h(a parama) {}
  
  public final void onGetTokenComplete(JSONObject paramJSONObject)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("oAuthListener onGetTokenComplete ");
        com.bluefay.b.h.a(paramJSONObject, new Object[0]);
        a.a(this.a, "3");
        if ((paramJSONObject != null) && ("000".equals(paramJSONObject.optString("resultcode"))))
        {
          com.lantern.analytics.a.e().onEvent("umcoasuc");
          a.p(this.a);
          a.a(this.a, paramJSONObject.optString("uniqueid"), paramJSONObject.optString("accessToken"));
          return;
        }
        if ((paramJSONObject != null) && ("102121".equals(paramJSONObject.optString("resultcode"))))
        {
          com.lantern.analytics.a.e().onEvent("umcoacal");
          a.a(this.a, 2, null, null, a.d(this.a));
        }
      }
      com.lantern.analytics.a.e().onEvent("umcoafa");
      a.a(this.a, 0, null, null, a.d(this.a));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */