package com.lantern.wifiseccheck.vpn.connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.lantern.wifiseccheck.LogUtils;

public class NetUtils
{
  public static final int NETTYPE_2G = 2;
  public static final int NETTYPE_3G = 3;
  public static final int NETTYPE_4G = 4;
  public static final int NETTYPE_NO = 0;
  public static final int NETTYPE_UNKOWN = 1;
  public static final String TAG = "NetUtils";
  
  public static int getNetGeneration(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    int i;
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable())) {
      switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
      {
      default: 
        i = 1;
      }
    }
    for (;;)
    {
      return i;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public static int getNetSp(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null) {
      LogUtils.d("NetUtils", "net type =" + paramContext.getType());
    }
    for (int i = paramContext.getType();; i = -1)
    {
      return i;
      LogUtils.d("NetUtils", "net type = -1");
    }
  }
  
  public static String getNetSpDetail(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null) {
      if (paramContext.getType() == 0) {
        paramContext = "g";
      }
    }
    for (;;)
    {
      return paramContext;
      if (paramContext.getType() == 1) {
        paramContext = "w";
      } else {
        paramContext = "";
      }
    }
  }
  
  public static String getNetType(Context paramContext)
  {
    String str = "unknown";
    if (isWIFI(paramContext)) {
      paramContext = "wifi";
    }
    for (;;)
    {
      return paramContext;
      switch (getNetGeneration(paramContext))
      {
      default: 
        paramContext = str;
        break;
      case 0: 
        paramContext = "none";
        break;
      case 2: 
        paramContext = "2G";
        break;
      case 3: 
        paramContext = "3G";
        break;
      case 4: 
        paramContext = "4G";
        break;
      case 1: 
        paramContext = "unknown";
      }
    }
  }
  
  public static String getTelecomOperators(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    String str2 = "";
    String str1 = str2;
    if (localNetworkInfo != null)
    {
      str1 = str2;
      if (localNetworkInfo.isAvailable()) {
        str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      }
    }
    if (!TextUtils.isEmpty(str1)) {
      if ((str1.startsWith("46000")) || (str1.startsWith("46002"))) {
        paramContext = "China_Mobile";
      }
    }
    for (;;)
    {
      return paramContext;
      if (str1.startsWith("46001")) {
        paramContext = "China_Unicom";
      } else if (str1.startsWith("46003")) {
        paramContext = "China_Telecom";
      } else {
        paramContext = "China_Unkown";
      }
    }
  }
  
  public static boolean isWIFI(Context paramContext)
  {
    return "w".equals(getNetSpDetail(paramContext));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/connection/NetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */