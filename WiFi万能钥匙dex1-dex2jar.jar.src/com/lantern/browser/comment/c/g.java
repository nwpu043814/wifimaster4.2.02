package com.lantern.browser.comment.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;

final class g
  implements DialogInterface.OnClickListener
{
  g(e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.e().onEvent("cmtcancel");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */