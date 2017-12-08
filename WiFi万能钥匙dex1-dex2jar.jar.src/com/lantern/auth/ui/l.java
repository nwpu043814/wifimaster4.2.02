package com.lantern.auth.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bluefay.a.e;
import com.lantern.account.R.string;

final class l
  implements DialogInterface.OnClickListener
{
  l(AuthPromptAct paramAuthPromptAct, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AuthPromptAct.a(this.a, "lndgpos");
    if (!e.c(this.b))
    {
      e.a(R.string.auth_failed_no_network);
      this.b.finish();
    }
    for (;;)
    {
      return;
      AuthPromptAct.a(this.b, this.a);
      this.b.finish();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */