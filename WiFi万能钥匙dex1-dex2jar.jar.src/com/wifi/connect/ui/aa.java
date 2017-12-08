package com.wifi.connect.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bluefay.b.h;
import com.wifi.connect.model.AccessPoint;

final class aa
  implements WifiListHeaderView.a
{
  aa(ConnectFragment paramConnectFragment) {}
  
  public final void a()
  {
    ConnectFragment.l(this.a);
  }
  
  public final void b()
  {
    if (ConnectFragment.m(this.a).getVisibility() == 0) {}
    for (;;)
    {
      return;
      Intent localIntent = new Intent("wifi.intent.action.BROWSER");
      localIntent.setPackage(ConnectFragment.n(this.a).getPackageName());
      localIntent.setData(Uri.parse("http://leaflets.lianwifi.com/news/item/641.html"));
      localIntent.addFlags(268435456);
      ConnectFragment.o(this.a).startActivity(localIntent);
      com.lantern.analytics.a.e().onEvent("aqxh_c");
    }
  }
  
  public final void c()
  {
    Object localObject1;
    if (ConnectFragment.d(this.a) != null)
    {
      localObject1 = ConnectFragment.d(this.a).b();
      localObject1 = com.wifi.connect.a.a.a().b((AccessPoint)localObject1);
    }
    try
    {
      Object localObject2 = com.lantern.analytics.a.e();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("sercli_");
      ((com.lantern.analytics.a)localObject2).onEvent((String)localObject1);
      localObject2 = new android/content/Intent;
      ((Intent)localObject2).<init>("com.linksure.aps.action.VIEW");
      ((Intent)localObject2).setPackage(ConnectFragment.p(this.a).getPackageName());
      ((Intent)localObject2).putExtra("refer", "cnnt");
      ((Intent)localObject2).putExtra("aps_id", (String)localObject1);
      ((Intent)localObject2).addFlags(268435456);
      ConnectFragment.q(this.a).startActivity((Intent)localObject2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */