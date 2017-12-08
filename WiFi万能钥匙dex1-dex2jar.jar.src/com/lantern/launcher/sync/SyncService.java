package com.lantern.launcher.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.qihoo.util.StubApp1053578832;

public class SyncService
  extends Service
{
  private static b a = null;
  private static final Object b = new Object();
  
  static
  {
    StubApp1053578832.interface11(27);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return a.getSyncAdapterBinder();
  }
  
  public void onCreate()
  {
    synchronized (b)
    {
      if (a == null)
      {
        b localb = new com/lantern/launcher/sync/b;
        localb.<init>(getApplicationContext());
        a = localb;
      }
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/sync/SyncService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */