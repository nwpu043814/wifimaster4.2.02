package com.lantern.popup;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;

final class c
  implements View.OnClickListener
{
  c(PopupActivity paramPopupActivity) {}
  
  public final void onClick(View paramView)
  {
    if (paramView == PopupActivity.a(this.a))
    {
      if (PopupActivity.b(this.a) != null) {
        a.e().onEvent("smbs", PopupActivity.b(this.a).a);
      }
      this.a.d();
    }
    for (;;)
    {
      this.a.finish();
      do
      {
        return;
      } while ((paramView != PopupActivity.c(this.a)) && (paramView != PopupActivity.d(this.a)));
      if (PopupActivity.b(this.a) != null) {
        a.e().onEvent("smbe", PopupActivity.b(this.a).a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/popup/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */