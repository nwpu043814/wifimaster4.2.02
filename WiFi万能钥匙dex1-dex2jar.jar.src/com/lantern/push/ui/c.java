package com.lantern.push.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;

final class c
  implements DialogInterface.OnClickListener
{
  c(MessageFragment paramMessageFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.e().onEvent("msgrd0");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */