package com.alipay.sdk.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class e
  implements DialogInterface.OnClickListener
{
  e(d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AuthActivity.a(this.a.b.a, true);
    this.a.a.proceed();
    paramDialogInterface.dismiss();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/auth/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */