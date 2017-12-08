package com.lantern.settings.ui;

import android.content.Context;
import android.content.Intent;
import com.lantern.settings.widget.e;

final class ak
  implements Runnable
{
  ak(MoreFragment paramMoreFragment) {}
  
  public final void run()
  {
    if (MoreFragment.k(this.a) != null)
    {
      Intent localIntent = new Intent("follow_our_weixin");
      localIntent.putExtra("showcb", false);
      MoreFragment.l(this.a).sendBroadcast(localIntent);
      e.a().b();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */