package com.wifi.backup.ui;

import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.bluefay.b.a;
import com.lantern.connect.R.string;
import java.util.List;

final class e
  implements a
{
  e(d paramd) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    ApBackupFragment.e(this.a.a);
    if (this.a.a.getActivity() == null) {}
    for (;;)
    {
      return;
      if (paramInt == 10)
      {
        if (TextUtils.isEmpty(paramString)) {
          ApBackupFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_network_error));
        } else {
          ApBackupFragment.a(this.a.a, paramString);
        }
      }
      else if (paramInt == 1)
      {
        paramObject = (List)paramObject;
        if ((paramObject != null) && (((List)paramObject).size() > 0))
        {
          if (!ApBackupFragment.d(this.a.a).isWifiEnabled())
          {
            ApBackupFragment.a(this.a.a, this.a.a.getResources().getString(R.string.act_wifi_cloud_sync_restore_error_when_wifi_disabled));
          }
          else
          {
            ApBackupFragment.a(this.a.a, (List)paramObject);
            if (!TextUtils.isEmpty(paramString)) {
              ApBackupFragment.a(this.a.a, paramString);
            } else if (ApBackupFragment.h(this.a.a) >= 0) {
              ApBackupFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_restore_success_tip));
            } else {
              ApBackupFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_restore_failed_tip));
            }
          }
        }
        else {
          ApBackupFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_no_ap_restore));
        }
      }
      else if (!TextUtils.isEmpty(paramString))
      {
        ApBackupFragment.a(this.a.a, paramString);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */