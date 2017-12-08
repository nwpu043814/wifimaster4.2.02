package com.wifi.backup.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class d
  implements View.OnClickListener
{
  d(ApBackupFragment paramApBackupFragment) {}
  
  public final void onClick(View paramView)
  {
    ApBackupFragment.g(this.a);
    com.lantern.analytics.a.e().onEvent("restore");
    ApBackupFragment.b(this.a);
    new com.wifi.backup.c.a(new e(this)).execute(new String[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */