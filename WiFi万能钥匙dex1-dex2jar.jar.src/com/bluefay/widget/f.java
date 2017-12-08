package com.bluefay.widget;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

final class f
  implements View.OnClickListener
{
  f(ContextMenuView paramContextMenuView) {}
  
  public final void onClick(View paramView)
  {
    paramView = (MenuItem)paramView.getTag();
    if ((ContextMenuView.a(this.a) != null) && (paramView != null)) {
      ContextMenuView.a(this.a).a(paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */