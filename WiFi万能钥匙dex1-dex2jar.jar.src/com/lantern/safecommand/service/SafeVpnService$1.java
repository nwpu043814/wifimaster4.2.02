package com.lantern.safecommand.service;

import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.protocol.AuthProtocolResult;
import com.lantern.wifiseccheck.protocol.AuthProtocolResult.AuthResult;
import com.lantern.wifiseccheck.vpn.server.SafeAuthServer;

class SafeVpnService$1
  extends SafeAuthServer
{
  SafeVpnService$1(SafeVpnService paramSafeVpnService) {}
  
  protected void requestCb(AuthProtocolResult paramAuthProtocolResult)
  {
    if ((paramAuthProtocolResult != null) && (paramAuthProtocolResult.getResult() == AuthProtocolResult.AuthResult.AUTH_RESULT_OK))
    {
      LogUtils.d("SafeVpnService", "get token from server ==" + paramAuthProtocolResult.getToken());
      SafeVpnService.access$000(this.this$0, paramAuthProtocolResult);
      SafeVpnService.access$102(this.this$0, 0);
    }
    for (;;)
    {
      SafeVpnService.access$300(this.this$0, paramAuthProtocolResult);
      for (;;)
      {
        return;
        LogUtils.e("SafeVpnService", "get token from server failed.");
        if (SafeVpnService.access$100(this.this$0) >= 2) {
          break;
        }
        SafeVpnService.access$200(this.this$0);
      }
      SafeVpnService.access$102(this.this$0, 0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/service/SafeVpnService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */