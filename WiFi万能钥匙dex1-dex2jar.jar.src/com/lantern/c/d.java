package com.lantern.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;

final class d
  implements DialogInterface.OnClickListener
{
  d(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.f(this.a);
    if (!TextUtils.isEmpty(a.g(this.a)))
    {
      com.lantern.analytics.a.e().onEvent(a.g(this.a));
      a.h(this.a);
    }
    this.a.a(a.i(this.a));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */