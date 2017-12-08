package com.lantern.auth.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class n
  implements DialogInterface.OnCancelListener
{
  n(AuthPromptAct paramAuthPromptAct, String paramString) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AuthPromptAct.a(this.a, "lndgneg");
    this.b.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */