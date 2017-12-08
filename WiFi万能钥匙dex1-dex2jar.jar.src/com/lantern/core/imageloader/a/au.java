package com.lantern.core.imageloader.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class au
  extends Handler
{
  au(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    sendMessageDelayed(obtainMessage(), 1000L);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */