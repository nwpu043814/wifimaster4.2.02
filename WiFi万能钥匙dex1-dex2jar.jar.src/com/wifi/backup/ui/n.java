package com.wifi.backup.ui;

import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.widget.ListView;
import com.bluefay.b.a;
import com.lantern.connect.R.string;
import java.util.List;

final class n
  implements a
{
  n(m paramm) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (this.a.a.getActivity() == null) {
      return;
    }
    if (paramInt == 10) {
      ApBackupRestoreFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_network_error));
    }
    for (;;)
    {
      ApBackupRestoreFragment.h(this.a.a);
      break;
      if (paramInt == 1)
      {
        if (this.a.a.getActivity() == null) {
          continue;
        }
        if (!ApBackupRestoreFragment.k(this.a.a).isWifiEnabled())
        {
          ApBackupRestoreFragment.a(this.a.a, this.a.a.getResources().getString(R.string.act_wifi_cloud_sync_restore_error_when_wifi_disabled));
          ApBackupRestoreFragment.h(this.a.a);
          break;
        }
        ApBackupRestoreFragment.a(this.a.a, (List)paramObject);
        if ((ApBackupRestoreFragment.b(this.a.a) != null) && (ApBackupRestoreFragment.b(this.a.a).size() > 0))
        {
          ApBackupRestoreFragment.e(this.a.a).setAdapter(new ApBackupRestoreFragment.a(this.a.a, (byte)0));
          ApBackupRestoreFragment.m(this.a.a);
        }
        if (!TextUtils.isEmpty(paramString))
        {
          ApBackupRestoreFragment.a(this.a.a, paramString);
          continue;
        }
        if (ApBackupRestoreFragment.n(this.a.a) >= 0)
        {
          ApBackupRestoreFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_restore_success_tip));
          continue;
        }
        ApBackupRestoreFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_restore_failed_tip));
        continue;
      }
      if ((this.a.a.getActivity() != null) && (!TextUtils.isEmpty(paramString))) {
        ApBackupRestoreFragment.a(this.a.a, paramString);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */