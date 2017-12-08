package com.lantern.wifiseccheck;

import android.os.Handler;
import com.alibaba.fastjson.JSON;
import com.lantern.wifiseccheck.protocol.ApInfoFromClient;
import com.lantern.wifiseccheck.protocol.ApNeighbourReq;
import com.lantern.wifiseccheck.protocol.ApNeighbourRes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class WifiSecCheckImpl$6
  implements Runnable
{
  WifiSecCheckImpl$6(WifiSecCheckImpl paramWifiSecCheckImpl) {}
  
  public void run()
  {
    long l2 = System.currentTimeMillis();
    Object localObject;
    long l1;
    if (WifiSecCheckImpl.access$000(this.this$0) != WifiSecCheckImpl.access$100(this.this$0))
    {
      localObject = new ApNeighbourReq();
      ((ApNeighbourReq)localObject).setBaseAttr(Utils.getAppBaseAttr(WifiSecCheckImpl.access$000(this.this$0), WifiSecCheckImpl.access$2100(this.this$0)));
      ((ApNeighbourReq)localObject).setGpsCoordinate(WifiSecCheckImpl.access$000(this.this$0).getLocation());
      ((ApNeighbourReq)localObject).setMacList(WifiSecCheckImpl.access$200(this.this$0));
      ((ApNeighbourReq)localObject).setProtocolVer(ApInfoFromClient.PROTOCOL_VER);
      l1 = System.currentTimeMillis();
      this.this$0.apNeighbourRes = SecCheckHttpApi.getApNeighbourResult(JSON.toJSONString(localObject));
      LogUtils.d("WifiSecCheckImpl", "spend time get getApNeighbourResult " + (System.currentTimeMillis() - l2));
      if ((WifiSecCheckImpl.access$1600(this.this$0)) && (WifiSecCheckImpl.access$000(this.this$0) != WifiSecCheckImpl.access$100(this.this$0))) {
        break label285;
      }
      LogUtils.d("WifiSecCheckImpl", "is not checking or checkListener is " + WifiSecCheckImpl.access$000(this.this$0));
    }
    for (;;)
    {
      if ((this.this$0.apNeighbourRes != null) && (this.this$0.apNeighbourRes.getNetState() != 4))
      {
        localObject = new HashMap();
        ((Map)localObject).put("UNKNOWN_DEVICE", new ArrayList(WifiSecCheckImpl.access$200(this.this$0)));
        this.this$0.apNeighbourRes.setVendorMap((Map)localObject);
      }
      if (WifiSecCheckImpl.access$400(this.this$0) != null)
      {
        LogUtils.d("WifiSecCheckImpl", "send apNeighbourRes ok");
        WifiSecCheckImpl.access$400(this.this$0).sendEmptyMessage(12);
      }
      return;
      label285:
      if ((this.this$0.apNeighbourRes.getNetState() > 1) || (!WifiUtils.isWifiConnected(WifiSecCheckImpl.access$2100(this.this$0)))) {
        LogUtils.d("WifiSecCheckImpl", "get apNeighbourRes ok");
      } else {
        if (System.currentTimeMillis() - l1 < 25000L) {
          break;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiSecCheckImpl$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */