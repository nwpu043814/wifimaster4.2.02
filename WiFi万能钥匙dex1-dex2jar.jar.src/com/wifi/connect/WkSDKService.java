package com.wifi.connect;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import com.qihoo.util.StubApp1053578832;
import com.wifi.connect.b.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WkSDKService
  extends Service
{
  private com.bluefay.b.a a = new b(this);
  
  static
  {
    StubApp1053578832.interface11(89);
  }
  
  private static WkAccessPoint a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      paramString = new com/lantern/core/model/WkAccessPoint;
      paramString.<init>(localJSONObject);
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        h.a(paramString);
        paramString = null;
      }
    }
  }
  
  private static ArrayList<WkAccessPoint> b(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>(paramString);
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      int j = localJSONArray.length();
      for (int i = 0;; i++)
      {
        paramString = localArrayList;
        if (i >= j) {
          break;
        }
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        paramString = new com/lantern/core/model/WkAccessPoint;
        paramString.<init>(localJSONObject);
        localArrayList.add(paramString);
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      h.a(paramString);
      paramString = null;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    h.a(Thread.currentThread().getName(), new Object[0]);
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    h.a("onCreate:" + Thread.currentThread().getName(), new Object[0]);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    h.b("intent:%s,flags:%d,startId:%d", new Object[] { paramIntent, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra("what");
      if (!"queryKey".equals(localObject)) {
        break label111;
      }
      localObject = paramIntent.getStringExtra("param");
      paramIntent = paramIntent.getStringExtra("pkg");
      com.lantern.analytics.a.e().onEvent("sdk1_" + paramIntent);
      paramIntent = b((String)localObject);
      new d(this).a(paramIntent, this.a, false);
    }
    for (;;)
    {
      return 2;
      label111:
      if ("connect".equals(localObject))
      {
        localObject = a(paramIntent.getStringExtra("param"));
        if (localObject != null)
        {
          paramIntent = paramIntent.getStringExtra("pkg");
          com.lantern.analytics.a.e().onEvent("sdk2_" + paramIntent);
          paramIntent = new Bundle();
          paramIntent.putString("what", "connectNoUI");
          paramIntent.putString("ssid", ((WkAccessPoint)localObject).a);
          paramIntent.putString("bssid", ((WkAccessPoint)localObject).b);
          paramIntent.putInt("security", ((WkAccessPoint)localObject).c);
          paramIntent.putInt("rssi", ((WkAccessPoint)localObject).d);
          paramIntent.putString("dhid", c.getServer().g());
          paramIntent.putString("uhid", c.getServer().h());
          localObject = new Intent();
          ((Intent)localObject).setClassName(this, "com.wifi.connect.plugin.magickey.ConnectService");
          ((Intent)localObject).putExtras(paramIntent);
          startService((Intent)localObject);
        }
      }
      else if ("cancelConnect".equals(localObject))
      {
        paramIntent = paramIntent.getStringExtra("pkg");
        com.lantern.analytics.a.e().onEvent("sdk3_" + paramIntent);
        localObject = new Bundle();
        ((Bundle)localObject).putString("what", "cancelConnectNoUI");
        paramIntent = new Intent();
        paramIntent.setClassName(this, "com.wifi.connect.plugin.magickey.ConnectService");
        paramIntent.putExtras((Bundle)localObject);
        startService(paramIntent);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/WkSDKService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */