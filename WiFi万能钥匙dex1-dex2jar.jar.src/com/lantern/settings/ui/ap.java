package com.lantern.settings.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.lantern.analytics.a;

final class ap
  implements DialogInterface.OnCancelListener
{
  ap(MoreFragment paramMoreFragment) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    a.e().onEvent("invcli_4");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */