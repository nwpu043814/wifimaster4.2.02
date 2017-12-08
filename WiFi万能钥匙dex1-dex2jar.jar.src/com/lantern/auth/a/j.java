package com.lantern.auth.a;

import android.app.Activity;
import com.lantern.account.R.string;
import com.lantern.auth.widget.o;

final class j
  implements Runnable
{
  j(a parama, Activity paramActivity) {}
  
  public final void run()
  {
    if (a.q(this.b) == null) {
      a.a(this.b, new o(this.a.getString(R.string.auth_loading_code), this.a));
    }
    a.q(this.b).a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */