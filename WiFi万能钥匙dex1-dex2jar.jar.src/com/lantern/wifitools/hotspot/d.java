package com.lantern.wifitools.hotspot;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.lantern.wifitools.R.string;

final class d
  implements DialogInterface.OnClickListener
{
  d(HotspotFragment paramHotspotFragment, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.getText().toString().length() <= 0) {
      Toast.makeText(HotspotFragment.e(this.c), R.string.connect_hotspot_fragment_wifi_nossid, 1).show();
    }
    for (;;)
    {
      return;
      if (this.a.getText().toString().length() > 10)
      {
        Toast.makeText(HotspotFragment.f(this.c), R.string.connect_hotspot_fragment_wifi_ssid, 1).show();
      }
      else
      {
        if ((this.b.getText().toString().length() >= 8) && (this.b.getText().toString().length() <= 20)) {
          break;
        }
        Toast.makeText(HotspotFragment.g(this.c), R.string.credentials_password_too_short, 1).show();
      }
    }
    HotspotFragment.a(this.c, HotspotFragment.a(this.a, this.b));
    if (HotspotFragment.h(this.c) != null)
    {
      if (!HotspotFragment.i(this.c).d()) {
        break label245;
      }
      HotspotFragment.i(this.c).a(null, false);
      HotspotFragment.i(this.c).a(HotspotFragment.h(this.c), true);
    }
    for (;;)
    {
      HotspotFragment.j(this.c).setText(this.a.getText().toString());
      HotspotFragment.k(this.c).setText(this.b.getText().toString());
      break;
      label245:
      HotspotFragment.i(this.c).a(HotspotFragment.h(this.c));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/hotspot/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */