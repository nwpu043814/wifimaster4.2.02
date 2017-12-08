package com.lantern.webox.handler;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class h
  implements DialogInterface.OnClickListener
{
  h(WebViewClientHandler paramWebViewClientHandler, SslErrorHandler paramSslErrorHandler) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.proceed();
    WebViewClientHandler.access$002(this.b, false);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/handler/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */