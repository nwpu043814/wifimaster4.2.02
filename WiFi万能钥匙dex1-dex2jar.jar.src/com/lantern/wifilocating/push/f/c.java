package com.lantern.wifilocating.push.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.lantern.wifilocating.push.util.h;

public final class c
  extends Handler
{
  public c(Looper paramLooper)
  {
    super(paramLooper, new d());
  }
  
  public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    try
    {
      bool = super.sendMessageAtTime(paramMessage, paramLong);
      return bool;
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        h.a(paramMessage);
        boolean bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */