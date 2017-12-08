package com.lantern.settings.ui;

import android.os.Handler;
import android.os.Message;
import com.lantern.settings.b.d;

final class af
  extends Thread
{
  af(MoreFragment paramMoreFragment) {}
  
  public final void run()
  {
    localMessage = new Message();
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      localMessage.obj = MoreFragment.r(this.a);
      bool1 = bool2;
      bool2 = d.a(this.a.getActivity());
      bool1 = bool2;
      localMessage.what = 1001;
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localMessage.what = 1002;
      }
    }
    if (!bool1)
    {
      localMessage.obj = null;
      localMessage.what = 1002;
    }
    MoreFragment.s(this.a).sendMessage(localMessage);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */