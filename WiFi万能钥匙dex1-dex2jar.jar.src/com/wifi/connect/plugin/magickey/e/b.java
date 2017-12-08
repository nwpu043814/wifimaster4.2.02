package com.wifi.connect.plugin.magickey.e;

import android.content.Context;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.g.r.a;
import com.wifi.connect.plugin.magickey.R.string;

public final class b
{
  public static int a;
  
  public static String a(Context paramContext, int paramInt, String paramString, Object paramObject)
  {
    int i = 0;
    if (paramInt == 1)
    {
      i = R.string.tips_autoconnect_success;
      a = 100;
      if (i <= 0) {
        break label230;
      }
    }
    label230:
    for (paramString = paramContext.getString(i);; paramString = null)
    {
      return paramString;
      if (paramInt != 0) {
        break;
      }
      paramInt = R.string.tips_autoconnect_failed;
      a = 99;
      i = paramInt;
      if (!(paramObject instanceof r.a)) {
        break;
      }
      switch (((r.a)paramObject).a)
      {
      case 10102: 
      default: 
        i = paramInt;
        break;
      case 10002: 
        i = R.string.tips_autoconnect_failed_no_password;
        break;
      case 10003: 
        i = R.string.tips_autoconnect_failed_error_password;
        break;
      case 10004: 
        i = R.string.tips_autoconnect_failed_mac_limit;
        break;
      case 10005: 
        i = R.string.tips_autoconnect_failed_connection_limit;
        break;
      case 10006: 
        i = R.string.tips_autoconnect_failed_poor_signal;
        break;
      case 10007: 
        i = R.string.tips_autoconnect_failed_timeout;
        break;
      case 10008: 
        i = R.string.tips_autoconnect_failed_wifi_abnormal;
        break;
      case 10009: 
        i = R.string.tips_autoconnect_failed_wifi_abnormal;
        break;
      case 10103: 
        i = R.string.tips_autoconnect_failed_network_exception;
        break;
      }
    }
  }
  
  public static void a(int paramInt, String paramString, Object paramObject)
  {
    h.a("retcode:%s retmsg:%s data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    paramString = a(c.getAppContext(), paramInt, paramString, paramObject);
    if (paramString != null) {
      e.a(paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */