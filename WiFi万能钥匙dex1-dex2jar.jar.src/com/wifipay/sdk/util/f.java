package com.wifipay.sdk.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import org.apache.http.conn.util.InetAddressUtils;

public final class f
{
  public static int a(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {}
    for (paramContext = Resources.getSystem();; paramContext = paramContext.getResources()) {
      return (int)(paramContext.getDisplayMetrics().density * paramFloat);
    }
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getResources().getIdentifier(paramString1, paramString2, paramContext.getPackageName());
  }
  
  public static String a()
  {
    try
    {
      do
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration2;
        while (!localEnumeration2.hasMoreElements())
        {
          if (!localEnumeration1.hasMoreElements()) {
            break;
          }
          localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        }
        localObject = (InetAddress)localEnumeration2.nextElement();
      } while ((((InetAddress)localObject).isLoopbackAddress()) || (!InetAddressUtils.isIPv4Address(((InetAddress)localObject).getHostAddress())));
      localObject = ((InetAddress)localObject).getHostAddress();
    }
    catch (SocketException localSocketException)
    {
      for (;;)
      {
        Object localObject;
        localSocketException.printStackTrace();
        String str = "192.168.1.0";
      }
    }
    return (String)localObject;
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, "yyyy-MM-dd HH:mm:ss:SSS");
  }
  
  public static String a(long paramLong, String paramString)
  {
    Date localDate = new Date();
    paramString = new SimpleDateFormat(paramString);
    long l = paramLong;
    if (paramLong < 1000000000000L) {
      l = paramLong * 1000L;
    }
    localDate.setTime(l);
    return paramString.format(localDate);
  }
  
  public static String a(String paramString)
  {
    return new String(b.a(paramString));
  }
  
  public static String b(String paramString)
  {
    int i = 0;
    char[] arrayOfChar = new char[16];
    char[] tmp10_8 = arrayOfChar;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 97;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 98;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 99;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 100;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 101;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 102;
    tmp94_88;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
      paramString = ((MessageDigest)localObject).digest();
      int k = paramString.length;
      localObject = new char[k * 2];
      int j = 0;
      while (i < k)
      {
        int m = paramString[i];
        int n = j + 1;
        localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
        j = n + 1;
        localObject[n] = arrayOfChar[(m & 0xF)];
        i++;
      }
      paramString = new java/lang/String;
      paramString.<init>((char[])localObject);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
    return paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */