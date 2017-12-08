package com.lantern.browser.search.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.lantern.browser.search.a.a;

final class m
  implements View.OnClickListener
{
  m(WkSearchTitleBar paramWkSearchTitleBar) {}
  
  public final void onClick(View paramView)
  {
    String str = WkSearchTitleBar.f(this.a).getText().toString().trim();
    paramView = str;
    if (TextUtils.isEmpty(str))
    {
      paramView = str;
      if (WkSearchTitleBar.b(this.a)) {
        paramView = WkSearchTitleBar.f(this.a).getHint().toString().trim();
      }
    }
    if (paramView.length() > 0) {
      a.a().a(paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */