package com.linksure.apservice.ui.common.search;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class c
  implements View.OnClickListener
{
  c(SearchFragment paramSearchFragment) {}
  
  public final void onClick(View paramView)
  {
    SearchFragment.b(this.a).getText().clear();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/search/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */