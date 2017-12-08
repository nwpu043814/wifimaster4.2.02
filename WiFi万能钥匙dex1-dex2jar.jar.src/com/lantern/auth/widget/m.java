package com.lantern.auth.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class m
  implements DialogInterface.OnClickListener
{
  m(WkRegsView.WebViewClientHandler paramWebViewClientHandler, SslErrorHandler paramSslErrorHandler) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.proceed();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/widget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */