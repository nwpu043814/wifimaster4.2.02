package com.lantern.launcher.ui;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.bluefay.b.h;
import com.lantern.a.a.e;

final class b
  implements View.OnClickListener
{
  b(MainActivity paramMainActivity) {}
  
  public final void onClick(View paramView)
  {
    if (MainActivity.d(this.a))
    {
      h.a("splash stop!", new Object[0]);
      MainActivity.b(this.a).removeMessages(100);
      if (MainActivity.c(this.a) != null) {
        MainActivity.c(this.a).d();
      }
      MainActivity.a(this.a, null);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */