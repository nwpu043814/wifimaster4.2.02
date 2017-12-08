package com.lantern.wifiseccheck;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.lantern.wifiseccheck.protocol.NearbyAp;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class WifiUtils
{
  private static String[] SECURITY = { "无", "WEP", "WPAPSK_WPA2PSK" };
  static final int SECURITY_EAP = 3;
  static final int SECURITY_INVALID = -1;
  static final int SECURITY_NONE = 0;
  static final int SECURITY_PSK = 2;
  static final int SECURITY_WEP = 1;
  private static final String TAG = "WifiUtils";
  private static int networkPrefixLength;
  
  public static int fixLengthToInt(int paramInt)
  {
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      i += (1 << 31 - j);
      j++;
    }
    return swabInt(i);
  }
  
  public static final String getAPMacAddress(Context paramContext)
  {
    paramContext = getConnectionInfo(paramContext);
    if (paramContext != null) {}
    for (paramContext = paramContext.getBSSID();; paramContext = "") {
      return paramContext;
    }
  }
  
  public static WifiInfo getConnectionInfo(Context paramContext)
  {
    return getWifiManager(paramContext).getConnectionInfo();
  }
  
  public static final ConnectivityManager getConnectivityManager(Context paramContext)
  {
    return (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  public static Integer[] getDNSArray(Context paramContext)
  {
    int i = getDhcpInfo(paramContext).dns1;
    int j = getDhcpInfo(paramContext).dns2;
    paramContext = null;
    if ((i != 0) && (j != 0))
    {
      paramContext = new Integer[2];
      paramContext[0] = Integer.valueOf(i);
      paramContext[1] = Integer.valueOf(j);
    }
    for (;;)
    {
      return paramContext;
      if (i != 0)
      {
        paramContext = new Integer[1];
        paramContext[0] = Integer.valueOf(i);
      }
      else if (j != 0)
      {
        paramContext = new Integer[1];
        paramContext[0] = Integer.valueOf(j);
      }
    }
  }
  
  public static DhcpInfo getDhcpInfo(Context paramContext)
  {
    return ((WifiManager)paramContext.getSystemService("wifi")).getDhcpInfo();
  }
  
  public static int getIpAddress(Context paramContext)
  {
    paramContext = getConnectionInfo(paramContext);
    if (paramContext != null) {}
    for (int i = paramContext.getIpAddress();; i = 0) {
      return i;
    }
  }
  
  public static final String getLocalMacAddress(Context paramContext)
  {
    paramContext = getConnectionInfo(paramContext);
    if (paramContext != null) {}
    for (paramContext = paramContext.getMacAddress();; paramContext = "") {
      return paramContext;
    }
  }
  
  public static NearbyAp[] getNearbyAps(Context paramContext)
  {
    ArrayList localArrayList = (ArrayList)getWifiManager(paramContext).getScanResults();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      paramContext = new NearbyAp[localArrayList.size()];
      for (int i = 0; i < localArrayList.size(); i++)
      {
        ScanResult localScanResult = (ScanResult)localArrayList.get(i);
        NearbyAp localNearbyAp = new NearbyAp();
        localNearbyAp.setBssid(localScanResult.BSSID);
        localNearbyAp.setSsid(localScanResult.SSID);
        paramContext[i] = localNearbyAp;
      }
    }
    for (;;)
    {
      return paramContext;
      paramContext = null;
    }
  }
  
  public static int getNetmark(Context paramContext)
  {
    String str = intToIp(((WifiManager)paramContext.getSystemService("wifi")).getDhcpInfo().ipAddress);
    for (;;)
    {
      try
      {
        paramContext = NetworkInterface.getNetworkInterfaces();
        continue;
        if (!paramContext.hasMoreElements()) {
          continue;
        }
        Object localObject1 = (NetworkInterface)paramContext.nextElement();
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("networkInterface.name===");
        LogUtils.d("WifiUtils", ((NetworkInterface)localObject1).getName());
        if (!"wlan0".equals(((NetworkInterface)localObject1).getName())) {
          continue;
        }
        localObject1 = ((NetworkInterface)localObject1).getInterfaceAddresses();
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("interfaceAddresses =");
        LogUtils.d("WifiUtils", localObject1);
        if (localObject1 != null)
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("interfaceAddresses size ");
          LogUtils.d("WifiUtils", ((List)localObject1).size());
        }
        localObject2 = ((List)localObject1).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        localObject1 = (InterfaceAddress)((Iterator)localObject2).next();
        networkPrefixLength = ((InterfaceAddress)localObject1).getNetworkPrefixLength();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("networkPrefixLength===");
        LogUtils.d("WifiUtils", networkPrefixLength);
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("interfaceAddress.getAddress()===");
        LogUtils.d("WifiUtils", ((InterfaceAddress)localObject1).getAddress());
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("ip===/");
        LogUtils.d("WifiUtils", str);
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("HostName");
        LogUtils.d("WifiUtils", ((InterfaceAddress)localObject1).getAddress().getHostName());
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("HostAddress");
        LogUtils.d("WifiUtils", ((InterfaceAddress)localObject1).getAddress().getHostAddress());
        if (!(((InterfaceAddress)localObject1).getAddress() instanceof Inet4Address)) {
          continue;
        }
        i = fixLengthToInt(networkPrefixLength);
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>("networkPrefixLength===");
        LogUtils.d("WifiUtils", networkPrefixLength + "===" + i);
      }
      catch (SocketException paramContext)
      {
        paramContext.printStackTrace();
        int i = 0;
        continue;
      }
      return i;
      i = 0;
    }
  }
  
  public static int getNetmask(Context paramContext)
  {
    int j = getDhcpInfo(paramContext).netmask;
    LogUtils.d("WifiUtils", "getNetmask1 " + j);
    int i;
    if (j != 0)
    {
      i = j;
      if (-1 != j) {}
    }
    else
    {
      i = j;
      if (Build.VERSION.SDK_INT > 8)
      {
        i = getNetmark(paramContext);
        LogUtils.d("WifiUtils", "getNetmask2 " + i);
      }
    }
    if (i != 0)
    {
      j = i;
      if (-1 != i) {}
    }
    else
    {
      j = 16777215;
      LogUtils.d("WifiUtils", "getNetmask3 16777215");
    }
    LogUtils.d("WifiUtils", "getNetmask4 " + j);
    return j;
  }
  
  public static String getPhoneImei(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        StringBuilder localStringBuilder;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("imei:");
          LogUtils.d("Utils", paramContext);
          return paramContext;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
        localException1 = localException1;
        paramContext = null;
      }
      LogUtils.d("Utils", "get imei exception:" + localException1.getMessage());
    }
  }
  
  public static int getSecurity(WifiConfiguration paramWifiConfiguration)
  {
    int j = 2;
    int i;
    if (paramWifiConfiguration == null)
    {
      LogUtils.d("WifiUtils", "can not get WifiConfiguration in getSecurity...");
      i = -1;
    }
    for (;;)
    {
      return i;
      i = j;
      if (!paramWifiConfiguration.allowedKeyManagement.get(1))
      {
        i = j;
        if (!paramWifiConfiguration.allowedKeyManagement.get(2))
        {
          i = j;
          if (!paramWifiConfiguration.allowedKeyManagement.get(3)) {
            if (paramWifiConfiguration.wepKeys[0] != null) {
              i = 1;
            } else {
              i = 0;
            }
          }
        }
      }
    }
  }
  
  public static int getSecurityLevel(Context paramContext)
  {
    return getSecurity(getWifiConfiguration(paramContext));
  }
  
  public static WifiConfiguration getWifiConfiguration(Context paramContext)
  {
    paramContext = getWifiManager(paramContext);
    WifiInfo localWifiInfo = paramContext.getConnectionInfo();
    if (localWifiInfo != null)
    {
      paramContext = paramContext.getConfiguredNetworks();
      if (paramContext != null)
      {
        Iterator localIterator = paramContext.iterator();
        String str1;
        String str2;
        do
        {
          do
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              paramContext = (WifiConfiguration)localIterator.next();
            } while (paramContext == null);
            str1 = paramContext.SSID;
          } while (str1 == null);
          str1 = str1.replace("\"", "");
          str2 = localWifiInfo.getSSID();
        } while ((str2 == null) || (!str2.replace("\"", "").equals(str1)) || (localWifiInfo.getNetworkId() != paramContext.networkId));
      }
    }
    for (;;)
    {
      return paramContext;
      paramContext = null;
    }
  }
  
  public static WifiManager getWifiManager(Context paramContext)
  {
    return (WifiManager)paramContext.getSystemService("wifi");
  }
  
  public static final String getWifiName(Context paramContext)
  {
    paramContext = getConnectionInfo(paramContext);
    String str;
    if (paramContext != null)
    {
      str = paramContext.getSSID();
      paramContext = str;
      if (!TextUtils.isEmpty(str))
      {
        paramContext = str;
        if (str.startsWith("\""))
        {
          paramContext = str;
          if (!str.endsWith("\"")) {}
        }
      }
    }
    for (paramContext = str.substring(1, str.length() - 1);; paramContext = "") {
      return paramContext;
    }
  }
  
  public static String getWifiSecurity(Context paramContext)
  {
    return SECURITY[getSecurity(getWifiConfiguration(paramContext))];
  }
  
  public static int intToFixLength(int paramInt)
  {
    int k = 0;
    int i = 1;
    while (i != 0)
    {
      int j = k;
      if ((paramInt & i) != 0) {
        j = k + 1;
      }
      i <<= 1;
      k = j;
    }
    return k;
  }
  
  public static String intToIp(int paramInt)
  {
    return (paramInt & 0xFF) + '.' + (paramInt >> 8 & 0xFF) + '.' + (paramInt >> 16 & 0xFF) + '.' + (paramInt >> 24 & 0xFF);
  }
  
  public static boolean isTheSameSSID(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return bool;
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!paramString1.equals(paramString2))) {
        bool = false;
      }
    }
  }
  
  public static boolean isTheSameWifi(String paramString1, String paramString2, Context paramContext)
  {
    return getWifiName(paramContext).equals(paramString2);
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    return getConnectivityManager(paramContext).getNetworkInfo(1).isConnected();
  }
  
  public static String long2ip(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.valueOf((int)(paramLong & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 8 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 16 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 24 & 0xFF)));
    return localStringBuffer.toString();
  }
  
  public static String ssidCheck(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new char[paramString.length()];
      int i = 0;
      for (;;)
      {
        if (i >= paramString.length()) {
          break label79;
        }
        char c = paramString.charAt(i);
        if (c <= 'ÿ') {}
        try
        {
          localObject[i] = com.lantern.wifiseccheck.preferences.CharTypes.replaceChars[c];
          localStringBuffer.append(c);
          i++;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      label79:
      localObject = localStringBuffer.toString();
    }
    return (String)localObject;
  }
  
  public static final int swabInt(int paramInt)
  {
    return paramInt >>> 24 | paramInt << 24 | paramInt << 8 & 0xFF0000 | paramInt >> 8 & 0xFF00;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */