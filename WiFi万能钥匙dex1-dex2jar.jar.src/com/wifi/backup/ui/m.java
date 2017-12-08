package com.wifi.backup.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class m
  implements View.OnClickListener
{
  m(ApBackupRestoreFragment paramApBackupRestoreFragment) {}
  
  public final void onClick(View paramView)
  {
    ApBackupRestoreFragment.l(this.a);
    com.lantern.analytics.a.e().onEvent("restore");
    ApBackupRestoreFragment.i(this.a);
    new com.wifi.backup.c.a(new n(this)).execute(new String[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */