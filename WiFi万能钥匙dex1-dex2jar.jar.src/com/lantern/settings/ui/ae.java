package com.lantern.settings.ui;

import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.core.g.k;
import com.lantern.core.g.k.b;
import com.lantern.core.p;
import com.lantern.settings.R.string;

final class ae
  implements com.bluefay.b.a
{
  ae(MoreFragment paramMoreFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    MoreFragment.a(this.a);
    switch (paramInt)
    {
    }
    for (;;)
    {
      e.a(R.string.settings_version_network_error);
      return;
      k.a().c(k.b.o);
      paramString = (com.lantern.c.a.a)paramObject;
      if (paramString.a)
      {
        h.a("updateInfo size:" + paramString.i);
        h.a("updateInfo version:" + paramString.f);
        h.a("updateInfo md5:" + paramString.h);
        h.a("updateInfo path:" + paramString.g);
        com.lantern.c.a.a(MoreFragment.c(this.a)).a(MoreFragment.b(this.a), paramString, "upsd_y", "upsd_n");
        com.lantern.analytics.a.e().onEvent("upsd");
      }
      for (;;)
      {
        p.g(MoreFragment.d(this.a));
        break;
        h.a("has no update");
        e.a(R.string.settings_version_is_latest);
      }
      h.a("none wifi");
      continue;
      h.a("time out");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */