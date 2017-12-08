package com.lantern.browser;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final class br
  implements DialogInterface.OnClickListener
{
  br(String paramString1, String paramString2, WkBrowserWebView paramWkBrowserWebView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("smsto:" + this.a));
    paramDialogInterface.putExtra("sms_body", this.b);
    this.c.getContext().startActivity(paramDialogInterface);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */