package com.wifi.backup.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;

final class b
  implements View.OnClickListener
{
  b(ApBackupFragment paramApBackupFragment) {}
  
  public final void onClick(View paramView)
  {
    a.e().onEvent("backup");
    ApBackupFragment.b(this.a);
    new com.wifi.backup.c.b(ApBackupFragment.c(this.a), false, null, ApBackupFragment.d(this.a), new c(this)).execute(new String[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */