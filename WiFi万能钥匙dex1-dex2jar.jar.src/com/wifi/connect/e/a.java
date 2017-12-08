package com.wifi.connect.e;

import android.content.Context;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.connect.R.string;
import com.lantern.core.c;
import com.lantern.core.g.r.a;

public final class a
{
  public static void a(int paramInt, String paramString, Object paramObject)
  {
    int i = 0;
    h.a("retcode:%s retmsg:%s data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    paramString = c.getAppContext();
    if (paramInt == 1)
    {
      i = R.string.tips_connect_success;
      if (i <= 0) {
        break label189;
      }
    }
    label189:
    for (paramString = paramString.getString(i);; paramString = null)
    {
      if (paramString != null) {
        e.a(paramString);
      }
      return;
      if (paramInt != 0) {
        break;
      }
      paramInt = R.string.tips_connect_failed;
      i = paramInt;
      if (!(paramObject instanceof r.a)) {
        break;
      }
      switch (((r.a)paramObject).a)
      {
      default: 
        i = paramInt;
        break;
      case 10002: 
        i = R.string.tips_connect_failed_no_password;
        break;
      case 10003: 
        i = R.string.tips_connect_failed;
        break;
      case 10004: 
        i = R.string.tips_connect_failed_mac_limit;
        break;
      case 10005: 
        i = R.string.tips_connect_failed_connection_limit;
        break;
      case 10006: 
        i = R.string.tips_connect_failed_poor_signal;
        break;
      case 10007: 
        i = R.string.tips_connect_failed;
        break;
      case 10008: 
        i = R.string.tips_connect_failed_wifi_abnormal;
        break;
      case 10009: 
        i = R.string.tips_connect_failed_canceled;
        break;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */