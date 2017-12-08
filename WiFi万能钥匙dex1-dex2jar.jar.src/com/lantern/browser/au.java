package com.lantern.browser;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import com.bluefay.b.h;
import com.lantern.browser.ui.WkBrowserFragment;

final class au
  extends Handler
{
  au(at paramat) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      if (at.a(this.a) != null) {
        at.a(this.a).setVisibility(4);
      }
      this.a.c();
      if (!at.b(this.a))
      {
        h.a("MSG_PROGRESS_TIMEOUT showErrorPage", new Object[0]);
        if (at.c(this.a) != null) {
          at.c(this.a).c(at.d(this.a).getString(R.string.browser_loading_error));
        }
        at.a(this.a, this.a.l(), "timeout", at.e(this.a));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */