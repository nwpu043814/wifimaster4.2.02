package com.lantern.auth.ui;

import android.text.TextUtils;
import com.bluefay.a.e;
import com.lantern.account.R.string;
import com.lantern.auth.g;
import com.lantern.core.c;
import com.lantern.core.config.AuthConfig;
import com.lantern.core.o;
import com.lantern.core.p;
import org.json.JSONObject;

final class a
  implements com.bluefay.b.a
{
  a(AddAccountActivity paramAddAccountActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (JSONObject)paramObject;
      AddAccountActivity.a(this.a, ((JSONObject)paramObject).optString("lastPath"));
    }
    if (paramInt != 1)
    {
      com.lantern.analytics.a.e().onEvent("login_cmcc", g.a(null, "failed", null));
      if ((AddAccountActivity.a(this.a).g() == 1) || (paramInt == 13)) {
        AddAccountActivity.b(this.a);
      }
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        e.a(paramString);
      }
      else if (paramInt != 2)
      {
        e.a(this.a.getString(R.string.auth_loading_failed));
        continue;
        com.lantern.analytics.a.e().onEvent("login_cmcc", g.a(null, "success", null));
        com.lantern.analytics.a.e().onEvent("LoginEnd", g.a(AddAccountActivity.c(this.a), AddAccountActivity.d(this.a), "1", c.getServer().k()));
        if (AddAccountActivity.e(this.a)) {
          AddAccountActivity.a(this.a, p.c(""), p.f(this.a));
        } else {
          this.a.finish();
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */