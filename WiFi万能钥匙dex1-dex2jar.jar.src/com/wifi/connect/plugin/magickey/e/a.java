package com.wifi.connect.plugin.magickey.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class a
  extends Handler
{
  public a() {}
  
  public a(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (1000 == paramMessage.what)
    {
      Runnable localRunnable = (Runnable)paramMessage.obj;
      localRunnable.run();
      int j = paramMessage.arg2 - 1;
      if (j > 0)
      {
        int i = paramMessage.arg1;
        paramMessage = obtainMessage(1000);
        paramMessage.arg1 = i;
        paramMessage.arg2 = j;
        paramMessage.obj = localRunnable;
        sendMessageDelayed(paramMessage, i);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */