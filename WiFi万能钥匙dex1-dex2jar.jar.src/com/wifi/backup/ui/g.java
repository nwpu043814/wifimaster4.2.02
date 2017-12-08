package com.wifi.backup.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class g
  implements View.OnClickListener
{
  g(ApBackupFragment paramApBackupFragment) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a.getActivity(), ApBackupRestoreActivity.class);
    paramView.putExtra("TYPE", 2);
    this.a.startActivity(paramView);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */