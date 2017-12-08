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

final class s
  implements a
{
  s(r paramr) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (this.a.a.b.a.getActivity() == null) {
      return;
    }
    if (paramInt == 10) {
      if (TextUtils.isEmpty(paramString)) {
        ApBackupRestoreFragment.a(this.a.a.b.a, this.a.a.b.a.getResources().getString(R.string.conn_backup_network_error));
      }
    }
    for (;;)
    {
      ApBackupRestoreFragment.h(this.a.a.b.a);
      break;
      ApBackupRestoreFragment.a(this.a.a.b.a, paramString);
      continue;
      if (paramInt == 1)
      {
        if (ApBackupRestoreFragment.b(this.a.a.b.a) != null) {
          ApBackupRestoreFragment.b(this.a.a.b.a).remove(this.a.a.a);
        }
        if ((ApBackupRestoreFragment.b(this.a.a.b.a) != null) && (ApBackupRestoreFragment.b(this.a.a.b.a).size() > 0))
        {
          ApBackupRestoreFragment.e(this.a.a.b.a).setAdapter(new ApBackupRestoreFragment.a(this.a.a.b.a, (byte)0));
          ApBackupRestoreFragment.c(this.a.a.b.a).setVisibility(8);
          ApBackupRestoreFragment.d(this.a.a.b.a).setVisibility(0);
        }
        else
        {
          ApBackupRestoreFragment.g(this.a.a.b.a).setText(this.a.a.b.a.getResources().getString(R.string.conn_backup_no_ap_restore));
          ApBackupRestoreFragment.e(this.a.a.b.a).setVisibility(8);
          ApBackupRestoreFragment.f(this.a.a.b.a).setVisibility(0);
          ApBackupRestoreFragment.c(this.a.a.b.a).setVisibility(8);
          ApBackupRestoreFragment.d(this.a.a.b.a).setVisibility(8);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */