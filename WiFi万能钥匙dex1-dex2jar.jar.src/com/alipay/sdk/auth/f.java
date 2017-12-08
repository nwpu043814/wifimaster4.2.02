package com.alipay.sdk.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class f
  implements DialogInterface.OnClickListener
{
  f(d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.cancel();
    AuthActivity.a(this.a.b.a, false);
    paramDialogInterface = AuthActivity.c(this.a.b.a) + "?resultCode=150";
    g.a(this.a.b.a, paramDialogInterface);
    this.a.b.a.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/auth/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */