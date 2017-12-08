package com.lantern.browser.search.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class k
  implements View.OnClickListener
{
  k(WkSearchTitleBar paramWkSearchTitleBar) {}
  
  public final void onClick(View paramView)
  {
    WkSearchTitleBar.f(this.a).setText("");
    WkSearchTitleBar.f(this.a).requestFocus();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */