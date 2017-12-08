package com.wifi.backup.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.lantern.connect.R.string;
import java.text.SimpleDateFormat;
import java.util.Date;

final class l
  implements com.bluefay.b.a
{
  l(k paramk) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    ApBackupRestoreFragment.h(this.a.a);
    if (this.a.a.getActivity() == null) {}
    for (;;)
    {
      return;
      if (paramInt == 10)
      {
        if (TextUtils.isEmpty(paramString)) {
          ApBackupRestoreFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_network_error));
        } else {
          ApBackupRestoreFragment.a(this.a.a, paramString);
        }
      }
      else if (paramInt == 1)
      {
        new com.wifi.backup.b.a(ApBackupRestoreFragment.j(this.a.a)).a(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date(System.currentTimeMillis())));
        if (this.a.a.getActivity() != null) {
          if (!TextUtils.isEmpty(paramString)) {
            ApBackupRestoreFragment.a(this.a.a, paramString);
          } else {
            ApBackupRestoreFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_backup_success_tip));
          }
        }
      }
      else if ((this.a.a.getActivity() != null) && (!TextUtils.isEmpty(paramString)))
      {
        ApBackupRestoreFragment.a(this.a.a, paramString);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */