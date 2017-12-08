package com.lantern.browser.search.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;

final class g
  implements DialogInterface.OnClickListener
{
  g(WkSearchHistoryListView paramWkSearchHistoryListView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    a.e().onEvent("shisdel0");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */