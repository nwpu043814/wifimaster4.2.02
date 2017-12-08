package com.lantern.mailbox;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class a
  implements DialogInterface.OnClickListener
{
  a(MailboxFragment paramMailboxFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (MailboxFragment.a(this.a) != null) {
      MailboxFragment.a(this.a).a();
    }
    new Thread(new b(this)).start();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */