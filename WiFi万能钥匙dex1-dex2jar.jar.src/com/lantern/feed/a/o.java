package com.lantern.feed.a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bluefay.b.h;
import java.util.HashMap;
import org.json.JSONObject;

final class o
  implements com.bluefay.b.a
{
  o(m paramm) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramString = (String)paramObject;
      if (TextUtils.isEmpty(paramString))
      {
        h.a("onReqPopSuccess get html invalid", new Object[0]);
        paramString = new HashMap();
        paramString.put("id", String.valueOf(m.q(this.a).a()));
        paramString.put("reason", "html");
        com.lantern.analytics.a.e().onEvent("nfwdshow", new JSONObject(paramString).toString());
      }
    }
    for (;;)
    {
      return;
      m.q(this.a).h(paramString);
      m.r(this.a).obtainMessage(35, m.q(this.a)).sendToTarget();
      continue;
      h.a("onReqPopSuccess get html failed", new Object[0]);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */