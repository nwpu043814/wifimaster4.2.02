package com.wifi.backup.ui;

import android.view.View;
import android.view.View.OnClickListener;
import bluefay.app.k;
import bluefay.app.k.a;
import com.lantern.connect.R.string;
import com.wifi.backup.c.a.a;

final class q
  implements View.OnClickListener
{
  q(ApBackupRestoreFragment.a parama, a parama1) {}
  
  public final void onClick(View paramView)
  {
    paramView = new k.a(this.b.a.getActivity());
    paramView.a(R.string.conn_backup_del_title);
    paramView.b(this.b.a.getString(R.string.conn_backup_del_desc, new Object[] { this.a.i() }));
    paramView.a(R.string.conn_backup_del_sure, new r(this));
    paramView.b(R.string.conn_backup_del_cancle, new t(this));
    paramView.c().show();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */