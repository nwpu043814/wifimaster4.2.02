package com.lantern.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.lantern.core.model.WkAccessPoint;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  private Context a;
  private IntentFilter b;
  private BroadcastReceiver c = new i(this);
  
  public h(Context paramContext)
  {
    this.a = paramContext;
    this.b = new IntentFilter();
    this.b.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    this.b.addAction("android.net.wifi.SCAN_RESULTS");
    this.b.addAction("android.net.wifi.NETWORK_IDS_CHANGED");
    this.b.addAction("android.net.wifi.supplicant.STATE_CHANGE");
    this.b.addAction("android.net.wifi.STATE_CHANGE");
    this.b.addAction("android.net.wifi.RSSI_CHANGED");
    this.b.addAction("android.intent.action.SCREEN_OFF");
    this.b.addAction("android.intent.action.SCREEN_ON");
    this.b.addAction("android.intent.action.USER_PRESENT");
    this.a.registerReceiver(this.c, this.b);
  }
  
  public static void a(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 128030;
    localMessage.arg1 = paramInt;
    c.dispatch(localMessage);
  }
  
  public static void a(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>();
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          ((JSONObject)localObject).put("dotcount", paramInt);
          ((JSONObject)localObject).put("tag", paramString);
          paramString = (String)localObject;
          localObject = Message.obtain();
          ((Message)localObject).what = 128603;
          ((Message)localObject).obj = paramString;
          c.dispatch((Message)localObject);
          return;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            Object localObject;
            paramString = (String)localObject;
          }
        }
        localJSONException1 = localJSONException1;
        paramString = null;
      }
    }
  }
  
  public static void a(WkAccessPoint paramWkAccessPoint)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 128203;
    localMessage.obj = paramWkAccessPoint;
    c.dispatch(localMessage);
  }
  
  public static void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 128035;
    localMessage.obj = paramString;
    c.dispatch(localMessage);
  }
  
  public static void b()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 128202;
    c.dispatch(localMessage);
  }
  
  public static void b(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 128601;
    localMessage.obj = paramString;
    c.dispatch(localMessage);
  }
  
  public final void a()
  {
    this.a.unregisterReceiver(this.c);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */