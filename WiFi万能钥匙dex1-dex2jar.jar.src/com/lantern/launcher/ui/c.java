package com.lantern.launcher.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.a.a.e;
import com.lantern.analytics.a;

final class c
  implements View.OnClickListener
{
  c(MainActivity paramMainActivity) {}
  
  public final void onClick(View paramView)
  {
    MainActivity.b(this.a).removeMessages(100);
    if ((MainActivity.e(this.a) == null) || (!TextUtils.isEmpty(MainActivity.e(this.a).m())))
    {
      a.e().onEvent("kpAD_cli");
      MainActivity.f(this.a);
      paramView = new Intent("wifi.intent.action.BROWSER");
      paramView.setData(Uri.parse(MainActivity.e(this.a).m()));
      paramView.setPackage(this.a.getPackageName());
      if (MainActivity.c(this.a) != null) {
        MainActivity.c(this.a).d();
      }
      MainActivity.a(this.a, paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */