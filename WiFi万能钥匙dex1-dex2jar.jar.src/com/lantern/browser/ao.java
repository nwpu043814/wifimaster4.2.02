package com.lantern.browser;

import android.text.TextUtils;
import android.webkit.WebView;
import com.lantern.core.o;
import com.lantern.core.p;
import org.json.JSONObject;

final class ao
  implements com.bluefay.b.a
{
  ao(WebView paramWebView, String paramString1, String paramString2) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramString = new java/lang/StringBuilder;
        paramString.<init>("getAuthDirect   result ");
        com.bluefay.b.h.a(paramObject, new Object[0]);
        paramString = new org/json/JSONObject;
        paramString.<init>(paramObject.toString());
        if ("0".equals(paramString.optString("retCd")))
        {
          p.g(this.a.getContext(), paramString.optString("sessionId"));
          paramObject = new com/lantern/core/model/g;
          ((com.lantern.core.model.g)paramObject).<init>();
          ((com.lantern.core.model.g)paramObject).a = paramString.optString("mobile");
          ((com.lantern.core.model.g)paramObject).b = paramString.optString("uhid");
          ((com.lantern.core.model.g)paramObject).c = com.bluefay.a.c.d(this.a.getContext());
          ((com.lantern.core.model.g)paramObject).d = paramString.optString("nickName");
          ((com.lantern.core.model.g)paramObject).g = paramString.optString("headImgUrl");
          ((com.lantern.core.model.g)paramObject).h = paramString.optString("userToken");
          if ((!TextUtils.isEmpty(((com.lantern.core.model.g)paramObject).a)) && (!TextUtils.isEmpty(((com.lantern.core.model.g)paramObject).b)) && (!TextUtils.isEmpty(((com.lantern.core.model.g)paramObject).h)))
          {
            com.lantern.core.c.getServer().a((com.lantern.core.model.g)paramObject);
            com.lantern.core.h.b();
            com.lantern.analytics.a.e().onEvent("LoginOn", com.lantern.auth.g.a(this.b, "7", "1", com.lantern.core.c.getServer().k()));
            com.lantern.analytics.a.e().onEvent("LoginEnd", com.lantern.auth.g.a(this.b, "7", "1", com.lantern.core.c.getServer().k()));
            if (!TextUtils.isEmpty(this.c)) {
              WkBrowserJsInterface.access$700(this.a, this.c, new String[] { "1" });
            }
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      com.lantern.analytics.a.e().onEvent("LoginOn", com.lantern.auth.g.a(this.b, "7", "2", com.lantern.core.c.getServer().k()));
      com.lantern.analytics.a.e().onEvent("LoginEnd", com.lantern.auth.g.a(this.b, "7", "2", com.lantern.core.c.getServer().k()));
      if (!TextUtils.isEmpty(this.c)) {
        WkBrowserJsInterface.access$700(this.a, this.c, new String[] { "0" });
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */