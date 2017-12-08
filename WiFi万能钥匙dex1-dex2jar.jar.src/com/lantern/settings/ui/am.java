package com.lantern.settings.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;

final class am
  implements DialogInterface.OnClickListener
{
  am(MoreFragment paramMoreFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.e().onEvent("exit_cancel");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */