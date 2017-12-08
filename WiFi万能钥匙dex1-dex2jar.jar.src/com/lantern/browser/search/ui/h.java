package com.lantern.browser.search.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;

final class h
  implements TextWatcher
{
  h(WkSearchTitleBar paramWkSearchTitleBar) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().trim().length() > 0)
    {
      WkSearchTitleBar.a(this.a).setVisibility(0);
      if (!WkSearchTitleBar.b(this.a)) {
        WkSearchTitleBar.c(this.a).setTextColor(-1);
      }
    }
    for (;;)
    {
      return;
      WkSearchTitleBar.a(this.a).setVisibility(8);
      if (!WkSearchTitleBar.b(this.a)) {
        WkSearchTitleBar.c(this.a).setTextColor(-8796930);
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */