package com.lantern.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;

final class e
  implements DialogInterface.OnClickListener
{
  e(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.f(this.a);
    if (!TextUtils.isEmpty(a.j(this.a)))
    {
      com.lantern.analytics.a.e().onEvent(a.j(this.a));
      a.k(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */