package com.lantern.settings.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ah
  implements DialogInterface.OnClickListener
{
  ah(MoreFragment paramMoreFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MoreFragment.x(this.a);
    new af(this.a).start();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */