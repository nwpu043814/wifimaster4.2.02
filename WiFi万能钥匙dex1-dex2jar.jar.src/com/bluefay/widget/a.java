package com.bluefay.widget;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

final class a
  implements View.OnClickListener
{
  a(ActionBottomBarView paramActionBottomBarView) {}
  
  public final void onClick(View paramView)
  {
    paramView = (MenuItem)paramView.getTag();
    if ((ActionBottomBarView.a(this.a) != null) && (paramView != null)) {
      ActionBottomBarView.a(this.a).a(paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */