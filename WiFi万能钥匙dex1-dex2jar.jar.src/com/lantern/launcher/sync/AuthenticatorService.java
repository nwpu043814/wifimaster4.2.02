package com.lantern.launcher.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.qihoo.util.StubApp1053578832;

public class AuthenticatorService
  extends Service
{
  private a a;
  
  static
  {
    StubApp1053578832.interface11(26);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a.getIBinder();
  }
  
  public void onCreate()
  {
    this.a = new a(this);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/sync/AuthenticatorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */