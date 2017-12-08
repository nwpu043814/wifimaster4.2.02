package com.lantern.launcher.ui;

import android.os.Handler.Callback;
import android.os.Message;
import com.lantern.analytics.a;

final class m
  implements Handler.Callback
{
  m(UserGuideFragment paramUserGuideFragment) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (paramMessage.what == 1) {
      UserGuideFragment.a(this.a);
    }
    for (;;)
    {
      return bool;
      if (paramMessage.what == 2)
      {
        a.e().onEvent("regtmot");
        UserGuideFragment.a(this.a);
      }
      else
      {
        bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */