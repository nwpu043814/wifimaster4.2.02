package com.lantern.wifiseccheck.vpn.server;

import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.protocol.AuthProtocolRequest;
import com.lantern.wifiseccheck.protocol.AuthProtocolResult;
import com.lantern.wifiseccheck.protocol.AuthProtocolResult.AuthResult;
import java.util.ArrayList;

class SafeAuthServerImpl$1
  extends Thread
{
  SafeAuthServerImpl$1(SafeAuthServerImpl paramSafeAuthServerImpl, AuthProtocolRequest paramAuthProtocolRequest) {}
  
  public void run()
  {
    Object localObject1 = new AuthProtocolResult();
    ((AuthProtocolResult)localObject1).setResult(AuthProtocolResult.AuthResult.AUTH_RESULT_NETWORK_FAILED);
    this.this$0.domainNameResolution(SafeAuthServerImpl.access$000(this.this$0));
    if ((SafeAuthServerImpl.access$100(this.this$0) != null) && (!SafeAuthServerImpl.access$100(this.this$0).isEmpty()))
    {
      LogUtils.d("safe", "startTask inetAddressList != null");
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        if ((((AuthProtocolResult)localObject1).getResult() != AuthProtocolResult.AuthResult.AUTH_RESULT_OK) && (SafeAuthServerImpl.access$100(this.this$0) != null) && (!SafeAuthServerImpl.access$100(this.this$0).isEmpty()))
        {
          LogUtils.d("safe", "startTask result.getResult()");
          Object localObject2 = (String)SafeAuthServerImpl.access$100(this.this$0).remove(0);
          LogUtils.d("safe", "startTask getAuthProtocolRequest");
          localObject2 = SafeAuthServerImpl.access$200(this.this$0, (String)localObject2, (AuthProtocolResult)localObject1, this.val$request);
          localObject1 = localObject2;
          break;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        LogUtils.d("safe", "startTask getAuthProtocolRequest Exception");
        LogUtils.d("safe", "startTask requestCb");
        this.this$0.requestCb((AuthProtocolResult)localObject1);
        continue;
      }
      finally
      {
        LogUtils.d("safe", "startTask requestCb");
        this.this$0.requestCb((AuthProtocolResult)localObject1);
      }
      LogUtils.d("safe", "domainNameResolution inetAddressList is null");
      this.this$0.requestCb((AuthProtocolResult)localObject1);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/server/SafeAuthServerImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */