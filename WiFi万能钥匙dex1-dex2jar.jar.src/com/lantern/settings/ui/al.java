package com.lantern.settings.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.lantern.analytics.a;
import java.util.concurrent.Executors;

final class al
  implements DialogInterface.OnClickListener
{
  al(MoreFragment paramMoreFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new MoreFragment.a(this.a, (byte)0).executeOnExecutor(Executors.newCachedThreadPool(), new View[0]);
    a.e().onEvent("exit_confirm");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */