package com.lantern.safecommand.service;

import com.lantern.wifiseccheck.protocol.AuthProtocolResult;

class SafeVpnService$2
  implements Runnable
{
  SafeVpnService$2(SafeVpnService paramSafeVpnService) {}
  
  public void run()
  {
    CopyAssets.writeVPNRuleToFile(this.this$0.mParamsResult.getVpnRule(), this.this$0);
    SafeVpnService.access$1000(this.this$0).sendEmptyMessage(23);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/service/SafeVpnService$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */