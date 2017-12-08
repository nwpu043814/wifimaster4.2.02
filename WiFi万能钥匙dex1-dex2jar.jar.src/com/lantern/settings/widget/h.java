package com.lantern.settings.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.lantern.analytics.a;
import com.lantern.settings.R.string;

final class h
  implements View.OnClickListener
{
  h(e.a parama, Context paramContext, View paramView, Runnable paramRunnable) {}
  
  public final void onClick(View paramView)
  {
    paramView = (ClipboardManager)this.a.getSystemService("clipboard");
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setPrimaryClip(ClipData.newPlainText("", this.a.getString(R.string.settings_about_wenxinhao_title)));
    }
    for (;;)
    {
      a.e().onEvent("accountcopy");
      this.b.removeCallbacks(this.c);
      e.a.b(this.d).removeView(this.d);
      if (e.a.c(this.d) != null) {
        e.a.c(this.d).b();
      }
      return;
      paramView.setText(this.a.getString(R.string.settings_about_wenxinhao_title));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */