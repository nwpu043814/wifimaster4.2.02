package com.lantern.wifiseccheck;

import android.net.DhcpInfo;
import com.lantern.wifiseccheck.protocol.WifiSecInfoReq;
import java.util.concurrent.Executors;

class WifiSecLevelImpl$1
  implements Runnable
{
  WifiSecLevelImpl$1(WifiSecLevelImpl paramWifiSecLevelImpl, WifiSecInfoReq paramWifiSecInfoReq, WifiSecCheckManager.BatchWifiSecCheckListener paramBatchWifiSecCheckListener) {}
  
  public void run()
  {
    this.val$req.setNearByAp(WifiUtils.getNearbyAps(WifiSecLevelImpl.access$000(this.this$0)));
    this.val$req.setGateway(Integer.valueOf(WifiUtils.getDhcpInfo(WifiSecLevelImpl.access$000(this.this$0)).gateway));
    this.val$req.setNetmask(Integer.valueOf(WifiUtils.getNetmask(WifiSecLevelImpl.access$000(this.this$0))));
    this.val$req.setDnsArray(WifiUtils.getDNSArray(WifiSecLevelImpl.access$000(this.this$0)));
    this.val$req.setSource(this.val$listener.getSource());
    WifiSecLevelImpl.access$102(this.this$0, new WifiSecLevelImpl.GetSecLevelAsyncTask(this.this$0, this.val$listener));
    WifiSecLevelImpl.access$100(this.this$0).executeOnExecutor(Executors.newSingleThreadExecutor(), new WifiSecInfoReq[] { this.val$req });
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiSecLevelImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */