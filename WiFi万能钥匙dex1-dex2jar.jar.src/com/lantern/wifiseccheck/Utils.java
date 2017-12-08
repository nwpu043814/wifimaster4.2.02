package com.lantern.wifiseccheck;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.lantern.wifiseccheck.protocol.AppBaseAttr;
import com.lantern.wifiseccheck.vpn.utils.VpnUtils;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class Utils
{
  public static int bytesToInt(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[3] << 24 & 0xFF000000;
  }
  
  public static AppBaseAttr getAppBaseAttr(WifiSecCheckManager.CheckListener paramCheckListener, Context paramContext)
  {
    AppBaseAttr localAppBaseAttr = new AppBaseAttr();
    localAppBaseAttr.setManuf(Build.MANUFACTURER);
    localAppBaseAttr.setModel(Build.MODEL);
    localAppBaseAttr.setOsVer(Build.VERSION.RELEASE);
    localAppBaseAttr.setOsVerCode(String.valueOf(Build.VERSION.SDK_INT));
    Object localObject = WifiUtils.getLocalMacAddress(paramContext);
    LogUtils.d("Utils", "localMacAddress:" + (String)localObject);
    localAppBaseAttr.setBssid(WifiUtils.getLocalMacAddress(paramContext));
    localObject = WifiUtils.getPhoneImei(paramContext);
    LogUtils.d("Utils", "imei:" + (String)localObject);
    localAppBaseAttr.setImei((String)localObject);
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo != null)
      {
        localAppBaseAttr.setChannel(paramCheckListener.getConnChanid());
        if (TextUtils.isEmpty(localAppBaseAttr.getChannel()))
        {
          String str = localApplicationInfo.metaData.getString("OS_CHANNEL");
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = localApplicationInfo.metaData.getString("conn_chanid");
          }
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label330;
          }
          localAppBaseAttr.setChannel((String)localObject);
        }
        localAppBaseAttr.setAppID(paramCheckListener.getAppId());
        if (TextUtils.isEmpty(localAppBaseAttr.getAppID()))
        {
          localObject = localApplicationInfo.metaData.getString("WK_APP_ID");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label350;
          }
          localAppBaseAttr.setAppID((String)localObject);
        }
      }
      VpnUtils.getInstance().setAppId(localAppBaseAttr.getAppID());
      VpnUtils.getInstance().setAppId(localAppBaseAttr.getChannel());
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
      NullPointerException localNullPointerException = new java/lang/NullPointerException;
      localNullPointerException.<init>("please set app id in AndroidManifest.xml with the key WK_APP_ID!");
      throw localNullPointerException;
    }
    localAppBaseAttr.setDhid(paramCheckListener.getDhid());
    localAppBaseAttr.setMac(WifiUtils.getAPMacAddress(paramContext));
    localAppBaseAttr.setSsid(WifiUtils.ssidCheck(WifiUtils.getWifiName(paramContext)));
    localAppBaseAttr.setVersionCode(getLocalAppVersionCode(paramContext));
    localAppBaseAttr.setVersionName(getLocalAppVersionName(paramContext));
    localAppBaseAttr.setLang(paramCheckListener.getLang());
    return localAppBaseAttr;
    label330:
    localObject = new java/lang/NullPointerException;
    ((NullPointerException)localObject).<init>("please set channel id in AndroidManifest.xml with the key OS_CHANNEL!");
    throw ((Throwable)localObject);
  }
  
  public static int getLocalAppVersionCode(Context paramContext)
  {
    try
    {
      i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.e("Utils", "Error while getting the local app version code.", paramContext);
        int i = -1;
      }
    }
  }
  
  public static String getLocalAppVersionName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.e("Utils", "Error while getting the local app version name.", paramContext);
        paramContext = "";
      }
    }
  }
  
  public static int getPxfromDip(int paramInt, Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  public static String intToIp(int paramInt)
  {
    return (paramInt & 0xFF) + '.' + (paramInt >> 8 & 0xFF) + '.' + (paramInt >> 16 & 0xFF) + '.' + (paramInt >> 24 & 0xFF);
  }
  
  public static List<String> intToIp(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfInt.length;
    for (int i = 0; i < j; i++)
    {
      int k = paramArrayOfInt[i];
      localArrayList.add((k & 0xFF) + '.' + (k >> 8 & 0xFF) + '.' + (k >> 16 & 0xFF) + '.' + (k >> 24 & 0xFF));
    }
    return localArrayList;
  }
  
  public static byte[] ipToBytesByInet(String paramString)
  {
    try
    {
      byte[] arrayOfByte = InetAddress.getByName(paramString).getAddress();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException(paramString + " is invalid IP");
    }
  }
  
  public static int ipToInt(String paramString)
  {
    try
    {
      int i = bytesToInt(ipToBytesByInet(paramString));
      return i;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException(paramString + " is invalid IP");
    }
  }
  
  public static String resolve(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = InetAddress.getByName(paramString).getHostAddress();
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = (String)localObject;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */