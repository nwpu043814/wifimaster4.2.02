package com.bluefay.widget;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

final class e
  implements View.OnClickListener
{
  e(CompactMenuView paramCompactMenuView) {}
  
  public final void onClick(View paramView)
  {
    paramView = (MenuItem)paramView.getTag();
    if ((CompactMenuView.a(this.a) != null) && (paramView != null)) {
      CompactMenuView.a(this.a).a(paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */