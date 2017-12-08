package com.lantern.wifiseccheck.vpn;

import android.content.Context;
import com.lantern.safecommand.security.a.a;
import com.lantern.wifiseccheck.protocol.appconf.AppConfRes;
import com.lantern.wifiseccheck.protocol.appconf.AppConfRes.ReturnCode;
import com.lantern.wifiseccheck.vpn.utils.VpnUtils;

class WifiSecCheckVpnManager$1
  implements Runnable
{
  WifiSecCheckVpnManager$1(WifiSecCheckVpnManager paramWifiSecCheckVpnManager, Context paramContext) {}
  
  public void run()
  {
    if (VpnUtils.getInstance().getAppConfRes() == null)
    {
      AppConfRes localAppConfRes = a.a(this.val$context);
      if ((localAppConfRes != null) && (localAppConfRes.getReturnCode() == AppConfRes.ReturnCode.SUCC)) {
        VpnUtils.getInstance().setAppConfRes(localAppConfRes);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/WifiSecCheckVpnManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */