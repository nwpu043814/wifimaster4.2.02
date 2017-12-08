package com.lantern.settings.ui;

import com.bluefay.a.e;
import com.lantern.settings.R.string;

final class as
  implements com.bluefay.b.a
{
  as(SpitslotActivity paramSpitslotActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      e.a(R.string.settings_spitslot_send_ok);
      com.lantern.analytics.a.e().c();
      com.lantern.analytics.a.e().d();
      this.a.finish();
    }
    for (;;)
    {
      return;
      e.a(R.string.settings_spitslot_send_failed);
      SpitslotActivity.a(this.a, false);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */