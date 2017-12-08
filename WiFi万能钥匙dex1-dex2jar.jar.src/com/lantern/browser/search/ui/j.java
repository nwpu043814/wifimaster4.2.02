package com.lantern.browser.search.ui;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.lantern.browser.search.a.a;

final class j
  implements TextView.OnEditorActionListener
{
  j(WkSearchTitleBar paramWkSearchTitleBar) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 3)
    {
      paramKeyEvent = WkSearchTitleBar.f(this.a).getText().toString().trim();
      paramTextView = paramKeyEvent;
      if (TextUtils.isEmpty(paramKeyEvent))
      {
        paramTextView = paramKeyEvent;
        if (WkSearchTitleBar.b(this.a)) {
          paramTextView = WkSearchTitleBar.f(this.a).getHint().toString().trim();
        }
      }
      if (paramTextView.length() > 0) {
        a.a().a(paramTextView);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */