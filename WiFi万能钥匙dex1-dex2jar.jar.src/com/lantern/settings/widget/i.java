package com.lantern.settings.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

final class i
  implements View.OnClickListener
{
  i(e.a parama, View paramView, Runnable paramRunnable) {}
  
  public final void onClick(View paramView)
  {
    this.a.removeCallbacks(this.b);
    e.a.b(this.c).removeView(this.c);
    if (e.a.c(this.c) != null) {
      e.a.c(this.c).a();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */