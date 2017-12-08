package com.lantern.browser.comment.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.lantern.core.c;

final class m
  implements DialogInterface.OnDismissListener
{
  m(a parama) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (a.k(this.a) != null) {
      c.removeListener(a.k(this.a));
    }
    a.d(this.a, null);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */