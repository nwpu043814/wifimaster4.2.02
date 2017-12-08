package com.wifi.backup.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.bluefay.b.a;
import com.lantern.connect.R.string;
import java.util.List;

final class j
  implements a
{
  j(ApBackupRestoreFragment paramApBackupRestoreFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (this.a.getActivity() == null) {
      return;
    }
    if (paramInt == 10) {
      if (TextUtils.isEmpty(paramString)) {
        ApBackupRestoreFragment.a(this.a, this.a.getResources().getString(R.string.conn_backup_network_error));
      }
    }
    for (;;)
    {
      ApBackupRestoreFragment.h(this.a);
      break;
      ApBackupRestoreFragment.a(this.a, paramString);
      continue;
      if (paramInt == 1)
      {
        ApBackupRestoreFragment.a(this.a, (List)paramObject);
        if ((ApBackupRestoreFragment.b(this.a) != null) && (ApBackupRestoreFragment.b(this.a).size() > 0))
        {
          ApBackupRestoreFragment.c(this.a).setVisibility(8);
          ApBackupRestoreFragment.d(this.a).setVisibility(0);
          ApBackupRestoreFragment.e(this.a).setVisibility(0);
          ApBackupRestoreFragment.f(this.a).setVisibility(8);
          ApBackupRestoreFragment.e(this.a).setAdapter(new ApBackupRestoreFragment.a(this.a, (byte)0));
        }
        else
        {
          ApBackupRestoreFragment.g(this.a).setText(this.a.getResources().getString(R.string.conn_backup_no_ap_restore));
          ApBackupRestoreFragment.e(this.a).setVisibility(8);
          ApBackupRestoreFragment.f(this.a).setVisibility(0);
          ApBackupRestoreFragment.c(this.a).setVisibility(8);
          ApBackupRestoreFragment.d(this.a).setVisibility(8);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */