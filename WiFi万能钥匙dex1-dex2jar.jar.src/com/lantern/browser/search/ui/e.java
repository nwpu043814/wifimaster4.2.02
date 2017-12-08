package com.lantern.browser.search.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;

final class e
  implements View.OnClickListener
{
  e(WkSearchHistoryListView paramWkSearchHistoryListView) {}
  
  public final void onClick(View paramView)
  {
    WkSearchHistoryListView.b(this.a);
    a.e().onEvent("shisdel");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */