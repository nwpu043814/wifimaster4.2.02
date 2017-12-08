package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class f
  implements DialogInterface.OnClickListener
{
  f(e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    c.a(this.a.b, true);
    this.a.a.proceed();
    paramDialogInterface.dismiss();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/app/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */