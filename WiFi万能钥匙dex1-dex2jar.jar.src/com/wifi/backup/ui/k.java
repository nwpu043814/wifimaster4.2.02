package com.wifi.backup.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;
import com.wifi.backup.c.b;

final class k
  implements View.OnClickListener
{
  k(ApBackupRestoreFragment paramApBackupRestoreFragment) {}
  
  public final void onClick(View paramView)
  {
    a.e().onEvent("backup");
    ApBackupRestoreFragment.i(this.a);
    new b(ApBackupRestoreFragment.j(this.a), true, ApBackupRestoreFragment.b(this.a), ApBackupRestoreFragment.k(this.a), new l(this)).execute(new String[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */