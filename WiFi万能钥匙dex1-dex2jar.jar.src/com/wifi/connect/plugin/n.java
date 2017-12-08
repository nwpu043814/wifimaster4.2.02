package com.wifi.connect.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;

public final class n
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Parcelable paramParcelable)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.snda.wifilocating", "com.wifi.connect.service.MsgService");
    Message localMessage = Message.obtain();
    localMessage.what = 128100;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramParcelable;
    paramParcelable = new Bundle();
    paramParcelable.putString("retmsg", paramString1);
    paramParcelable.putString("ssid", paramString2);
    paramParcelable.putString("bssid", paramString3);
    localMessage.setData(paramParcelable);
    localIntent.putExtra("msg", localMessage);
    paramContext.getApplicationContext().startService(localIntent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */