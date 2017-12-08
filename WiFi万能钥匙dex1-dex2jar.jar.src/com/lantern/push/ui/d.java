package com.lantern.push.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.push.utils.c;

final class d
  implements DialogInterface.OnClickListener
{
  d(MessageFragment paramMessageFragment, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a > 0) {
      new c(MessageFragment.c(this.b), MessageFragment.b(this.b), this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */