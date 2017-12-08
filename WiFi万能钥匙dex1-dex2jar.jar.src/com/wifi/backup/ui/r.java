package com.wifi.backup.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.lantern.connect.R.string;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.backup.c.d;
import java.util.List;

final class r
  implements DialogInterface.OnClickListener
{
  r(q paramq) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ApBackupRestoreFragment.i(this.a.b.a);
    if (ApBackupRestoreFragment.o(this.a.b.a) == 1) {
      if ((ApBackupRestoreFragment.b(this.a.b.a) != null) && (ApBackupRestoreFragment.b(this.a.b.a).size() > 0))
      {
        ApBackupRestoreFragment.b(this.a.b.a).remove(this.a.a);
        com.wifi.backup.a.a.b().a(new WkAccessPoint(this.a.a.i(), this.a.a.j()));
        if (ApBackupRestoreFragment.b(this.a.b.a).size() > 0)
        {
          ApBackupRestoreFragment.e(this.a.b.a).setAdapter(new ApBackupRestoreFragment.a(this.a.b.a, (byte)0));
          ApBackupRestoreFragment.c(this.a.b.a).setVisibility(0);
          ApBackupRestoreFragment.d(this.a.b.a).setVisibility(8);
          ApBackupRestoreFragment.h(this.a.b.a);
        }
      }
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      ApBackupRestoreFragment.g(this.a.b.a).setText(this.a.b.a.getResources().getString(R.string.conn_backup_no_ap_backup));
      ApBackupRestoreFragment.e(this.a.b.a).setVisibility(8);
      ApBackupRestoreFragment.f(this.a.b.a).setVisibility(0);
      ApBackupRestoreFragment.c(this.a.b.a).setVisibility(8);
      ApBackupRestoreFragment.d(this.a.b.a).setVisibility(8);
      break;
      ApBackupRestoreFragment.g(this.a.b.a).setText(this.a.b.a.getResources().getString(R.string.conn_backup_no_ap_backup));
      ApBackupRestoreFragment.e(this.a.b.a).setVisibility(8);
      ApBackupRestoreFragment.f(this.a.b.a).setVisibility(0);
      ApBackupRestoreFragment.c(this.a.b.a).setVisibility(8);
      ApBackupRestoreFragment.d(this.a.b.a).setVisibility(8);
      break;
      new d(this.a.a.i(), new s(this)).execute(new String[0]);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */