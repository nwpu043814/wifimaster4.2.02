package com.lantern.settings;

import android.os.Handler;
import android.widget.Toast;
import bluefay.app.l;
import com.lantern.core.c;
import com.lantern.core.q;

public class SettingsApp
  extends l
{
  public final void a()
  {
    if (com.lantern.settings.diagnose.a.a())
    {
      c.getShareValue().a(true);
      if (com.lantern.settings.diagnose.a.b()) {
        Toast.makeText(this.a, "已启用诊断模式!", 1).show();
      }
      new Handler().postDelayed(new a(this), 600000L);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/SettingsApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */