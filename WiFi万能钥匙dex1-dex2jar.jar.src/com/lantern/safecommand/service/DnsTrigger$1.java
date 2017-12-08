package com.lantern.safecommand.service;

import c.a.a.f;
import com.lantern.wifiseccheck.LogUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class DnsTrigger$1
  extends TimerTask
{
  DnsTrigger$1(DnsTrigger paramDnsTrigger, Timer paramTimer) {}
  
  public void run()
  {
    String str = (String)DnsTrigger.access$000(this.this$0).get(0);
    DnsTrigger.access$000(this.this$0).remove(0);
    try
    {
      InetAddress localInetAddress = f.a(str);
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("do host ");
      LogUtils.d("DnsTrigger", str + "| addr: " + localInetAddress);
      if (DnsTrigger.access$000(this.this$0).size() == 0) {
        this.val$timer.cancel();
      }
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        localUnknownHostException.printStackTrace();
        DnsTrigger localDnsTrigger = this.this$0;
        localDnsTrigger.failedCount += 1;
        LogUtils.d("DnsTrigger", "get host faild and s ======" + str);
        if (this.this$0.failedCount > 10) {
          this.val$timer.cancel();
        }
        DnsTrigger.access$000(this.this$0).add(str);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/service/DnsTrigger$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */