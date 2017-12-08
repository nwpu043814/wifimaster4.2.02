package com.bluefay.widget;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

final class c
  implements View.OnClickListener
{
  c(ActionTopBarView paramActionTopBarView) {}
  
  public final void onClick(View paramView)
  {
    paramView = (MenuItem)paramView.getTag();
    if ((ActionTopBarView.a(this.a) != null) && (paramView != null)) {
      ActionTopBarView.a(this.a).a(paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */