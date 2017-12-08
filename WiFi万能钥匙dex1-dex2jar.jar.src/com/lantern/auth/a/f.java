package com.lantern.auth.a;

import android.os.Handler;
import cm.pass.sdk.auth.TokenListener;
import com.bluefay.b.h;
import com.lantern.auth.g;
import org.json.JSONObject;

final class f
  implements TokenListener
{
  f(a parama) {}
  
  public final void onGetTokenComplete(JSONObject paramJSONObject)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("implicitListener onGetTokenComplete ");
        h.a(paramJSONObject, new Object[0]);
        if (a.j(this.a)) {
          return;
        }
        a.l(this.a).removeCallbacks(a.k(this.a));
        a.a(this.a, "2");
        if ((paramJSONObject != null) && ("000".equals(paramJSONObject.optString("resultcode"))))
        {
          com.lantern.analytics.a.e().onEvent("umcimasuc");
          a.a(this.a, paramJSONObject.optString("uniqueid"), paramJSONObject.optString("accessToken"));
        }
      }
      com.lantern.analytics.a.e().onEvent("umcimfa", g.a(a.b(this.a)));
      a.f(this.a);
      a.a(this.a, a.c(this.a));
      if ((a.h(this.a) & 0x2) == 2)
      {
        com.lantern.analytics.a.e().onEvent("LoginOn", g.a(a.c(this.a), a.d(this.a), "2", a.m(this.a)));
        a.i(this.a);
      }
      else
      {
        a.a(this.a, 0, null, null, a.d(this.a));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */