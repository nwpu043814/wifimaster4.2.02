package com.lantern.browser.search.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.lantern.browser.search.a.a;

final class i
  implements View.OnFocusChangeListener
{
  i(WkSearchTitleBar paramWkSearchTitleBar) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a.a().d();
      WkSearchTitleBar.d(this.a);
    }
    for (;;)
    {
      return;
      WkSearchTitleBar.e(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */