package com.alipay.sdk.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class g
  implements DialogInterface.OnClickListener
{
  g(e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.cancel();
    c.a(this.a.b, false);
    j.a = j.a();
    c.a(this.a.b).finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/app/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */