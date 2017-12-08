package com.lantern.push.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;
import com.lantern.push.utils.e;

final class b
  implements DialogInterface.OnClickListener
{
  b(MessageFragment paramMessageFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new e(MessageFragment.a(this.a), MessageFragment.b(this.a), 0);
    a.e().onEvent("msgrd1");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */