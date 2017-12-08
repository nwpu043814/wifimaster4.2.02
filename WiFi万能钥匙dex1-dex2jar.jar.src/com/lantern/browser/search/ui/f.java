package com.lantern.browser.search.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class f
  implements DialogInterface.OnClickListener
{
  f(WkSearchHistoryListView paramWkSearchHistoryListView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    com.lantern.browser.search.a.a.a().c();
    com.lantern.analytics.a.e().onEvent("shisdel1");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */