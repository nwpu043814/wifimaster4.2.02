package com.lantern.wifitools.examination;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;
import com.lantern.core.c;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;

final class h
  implements View.OnClickListener
{
  h(ExamResultFragment paramExamResultFragment) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = u.b(c.getInstance());
    Object localObject2;
    if ((localObject1 != null) && (((WifiConfiguration)localObject1).allowedKeyManagement != null))
    {
      paramView = this.a.getActivity();
      localObject2 = new WkAccessPoint((WifiConfiguration)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("what", "connect");
      ((Bundle)localObject1).putString("ssid", ((WkAccessPoint)localObject2).a);
      ((Bundle)localObject1).putString("bssid", ((WkAccessPoint)localObject2).b);
      ((Bundle)localObject1).putInt("security", ((WkAccessPoint)localObject2).c);
      ((Bundle)localObject1).putInt("rssi", ((WkAccessPoint)localObject2).d);
      ((Bundle)localObject1).putString("dhid", c.getServer().g());
      ((Bundle)localObject1).putString("uhid", c.getServer().h());
      localObject2 = new Intent();
      ((Intent)localObject2).setClassName(paramView, "com.lantern.webox.authz.AuthzActivity");
      ((Intent)localObject2).putExtras((Bundle)localObject1);
    }
    try
    {
      paramView.startActivity((Intent)localObject2);
      a.e().onEvent("gowebauth");
      this.a.getActivity().finish();
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramView);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */