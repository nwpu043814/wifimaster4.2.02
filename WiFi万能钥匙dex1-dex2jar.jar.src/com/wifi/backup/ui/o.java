package com.wifi.backup.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.wifi.backup.c.a.a;
import java.util.List;

final class o
  implements DialogInterface.OnClickListener
{
  o(ApBackupRestoreFragment paramApBackupRestoreFragment, ApBackupRestoreFragment.b paramb, List paramList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    List localList = this.a.a();
    for (paramInt = 0; paramInt < localList.size(); paramInt++) {
      if (((a)localList.get(paramInt)).g()) {
        ApBackupRestoreFragment.a(this.c, (a)this.b.get(paramInt));
      }
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */