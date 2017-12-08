package com.wifi.backup.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.lantern.connect.R.string;
import java.text.SimpleDateFormat;
import java.util.Date;

final class c
  implements com.bluefay.b.a
{
  c(b paramb) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (this.a.a.getActivity() == null) {}
    for (;;)
    {
      return;
      ApBackupFragment.e(this.a.a);
      if (paramInt == -1)
      {
        ApBackupFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_no_ap_backup));
      }
      else if (paramInt == 10)
      {
        ApBackupFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_network_error));
      }
      else
      {
        if (paramInt == 1)
        {
          if (!TextUtils.isEmpty(paramString)) {
            ApBackupFragment.a(this.a.a, paramString);
          }
          for (;;)
          {
            new com.wifi.backup.b.a(ApBackupFragment.f(this.a.a)).a(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date(System.currentTimeMillis())));
            break;
            ApBackupFragment.a(this.a.a, this.a.a.getResources().getString(R.string.conn_backup_backup_success_tip));
          }
        }
        if (!TextUtils.isEmpty(paramString)) {
          ApBackupFragment.a(this.a.a, paramString);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */