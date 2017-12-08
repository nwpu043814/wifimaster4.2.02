package com.lantern.browser.comment.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.lantern.analytics.a;

final class k
  implements DialogInterface.OnCancelListener
{
  k(e parame) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    a.e().onEvent("cmtcancel");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */