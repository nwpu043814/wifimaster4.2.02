package com.lantern.settings.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bluefay.a.e;
import com.lantern.settings.R.string;

final class ag
  extends Handler
{
  ag(MoreFragment paramMoreFragment) {}
  
  public final void handleMessage(Message paramMessage)
  {
    MoreFragment.a(this.a);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      paramMessage = (String)paramMessage.obj;
      e.a(MoreFragment.t(this.a).getString(R.string.cache_clear_suc_hint_front) + paramMessage + MoreFragment.u(this.a).getString(R.string.cache_clear_suc_hint_end));
      MoreFragment.v(this.a);
      continue;
      e.a(MoreFragment.w(this.a).getString(R.string.cache_clear_fail_hint));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */