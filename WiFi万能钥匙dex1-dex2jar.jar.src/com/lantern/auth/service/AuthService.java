package com.lantern.auth.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.lantern.auth.i;
import com.qihoo.util.StubApp1053578832;
import org.json.JSONObject;

public class AuthService
  extends Service
{
  private String a = "";
  private com.bluefay.b.a b = new a(this);
  
  static
  {
    StubApp1053578832.interface11(2);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      stopSelf();
    }
    for (;;)
    {
      return 2;
      Object localObject = paramIntent.getStringExtra("auto_reg");
      String str = paramIntent.getStringExtra("fromSource");
      try
      {
        paramIntent = new org/json/JSONObject;
        paramIntent.<init>((String)localObject);
        localObject = new com/lantern/auth/i;
        ((i)localObject).<init>(this, str);
        ((i)localObject).a(this.b);
        ((i)localObject).a(paramIntent.optString("phone"), paramIntent.optString("content"));
        this.a = paramIntent.optString("callback");
      }
      catch (Exception paramIntent)
      {
        this.b.a(0, null, null);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/service/AuthService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */