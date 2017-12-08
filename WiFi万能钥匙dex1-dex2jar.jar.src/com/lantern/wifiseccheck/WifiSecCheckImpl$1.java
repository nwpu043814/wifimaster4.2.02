package com.lantern.wifiseccheck;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

class WifiSecCheckImpl$1
  extends Handler
{
  WifiSecCheckImpl$1(WifiSecCheckImpl paramWifiSecCheckImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    LogUtils.d("WifiSecCheckImpl", "sub handler get msg " + ???.what);
    switch (???.what)
    {
    }
    for (;;)
    {
      return;
      synchronized (this.this$0)
      {
        if (WifiSecCheckImpl.access$000(this.this$0) != WifiSecCheckImpl.access$100(this.this$0))
        {
          ExtraInfo localExtraInfo = new com/lantern/wifiseccheck/ExtraInfo;
          localExtraInfo.<init>();
          ArrayList localArrayList = new java/util/ArrayList;
          localArrayList.<init>(WifiSecCheckImpl.access$200(this.this$0));
          localExtraInfo.setNeighbours(localArrayList);
          WifiSecCheckImpl.access$000(this.this$0).onCheckFinish(this.this$0.apMarkResult, localExtraInfo);
        }
        WifiSecCheckImpl.access$300(this.this$0);
      }
      synchronized (this.this$0)
      {
        if (WifiSecCheckImpl.access$000(this.this$0) != WifiSecCheckImpl.access$100(this.this$0)) {
          WifiSecCheckImpl.access$000(this.this$0).onCheckError(???.arg1);
        }
      }
      synchronized (this.this$0)
      {
        if (WifiSecCheckImpl.access$000(this.this$0) != WifiSecCheckImpl.access$100(this.this$0)) {
          WifiSecCheckImpl.access$000(this.this$0).onLoadCallback(this.this$0.apNeighbourRes);
        }
        WifiSecCheckImpl.access$300(this.this$0);
      }
      WifiSecCheckImpl.access$300(this.this$0);
      continue;
      WifiSecCheckImpl.access$300(this.this$0);
      continue;
      synchronized (this.this$0)
      {
        if (WifiSecCheckImpl.access$000(this.this$0) != WifiSecCheckImpl.access$100(this.this$0)) {
          WifiSecCheckImpl.access$000(this.this$0).detectCount(???.arg1, ???.arg2, ((Integer)???.obj).intValue());
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiSecCheckImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */