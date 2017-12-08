package com.lantern.auth.ui;

import android.view.View;
import com.bluefay.a.e;
import com.bluefay.b.a;
import com.lantern.account.R.string;
import com.lantern.auth.WkParamsConfig;
import com.lantern.auth.widget.WkAuthView;
import com.lantern.core.c;
import com.lantern.core.o;
import java.lang.ref.WeakReference;

final class b
  implements a
{
  b(AuthActivity paramAuthActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    AuthActivity.a(this.a);
    if ((paramInt == 1) && (paramObject != null))
    {
      paramString = (String)paramObject;
      this.a.setTitle(this.a.getString(R.string.auth_login));
      AuthActivity.a(this.a, new WeakReference((WkAuthView)AuthActivity.a(this.a, paramString, AuthActivity.b(this.a).mAppName, AuthActivity.b(this.a).mAppIcon)));
      this.a.setCustomContentView((View)AuthActivity.c(this.a).get());
    }
    for (;;)
    {
      return;
      if (paramInt == 10)
      {
        this.a.setCustomContentView(AuthActivity.d(this.a));
      }
      else
      {
        e.a(this.a, R.string.auth_token_failed);
        c.getServer().p();
        AuthActivity.e(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */