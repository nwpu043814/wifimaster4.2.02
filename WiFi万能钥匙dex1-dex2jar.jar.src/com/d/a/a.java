package com.d.a;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static WifiConfiguration a(String paramString1, String paramString2, String paramString3)
  {
    WifiConfiguration localWifiConfiguration = new WifiConfiguration();
    localWifiConfiguration.allowedAuthAlgorithms.clear();
    localWifiConfiguration.allowedGroupCiphers.clear();
    localWifiConfiguration.allowedKeyManagement.clear();
    localWifiConfiguration.allowedPairwiseCiphers.clear();
    localWifiConfiguration.allowedProtocols.clear();
    localWifiConfiguration.SSID = ("\"" + paramString1 + "\"");
    localWifiConfiguration.hiddenSSID = true;
    localWifiConfiguration.status = 2;
    localWifiConfiguration.allowedKeyManagement.set(2);
    localWifiConfiguration.allowedKeyManagement.set(3);
    paramString1 = new WifiEnterpriseConfig();
    paramString1.setIdentity(paramString2);
    paramString1.setPassword(paramString3);
    paramString1.setEapMethod(2);
    paramString1.setPhase2Method(1);
    localWifiConfiguration.enterpriseConfig = paramString1;
    return localWifiConfiguration;
  }
  
  private static String a(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      int j = arrayOfByte.length;
      for (int i = 0; i < j; i++)
      {
        StringBuilder localStringBuilder;
        for (paramString = Integer.toHexString(arrayOfByte[i] & 0xFF); paramString.length() < 2; paramString = paramString)
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("0");
        }
        ((StringBuilder)localObject).append(paramString);
      }
      paramString = ((StringBuilder)localObject).toString();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    return paramString;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (!"".equals(paramString1)) {
        break label27;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label27:
      bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (!"".equals(paramString2))
        {
          bool1 = bool2;
          if (paramString2.length() == 17)
          {
            paramString2 = paramString2.toLowerCase();
            paramString1 = a(paramString1);
            Object localObject1 = new LinkedList();
            Object localObject2 = "ssrpva".toCharArray();
            char[] arrayOfChar = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            int k = localObject2.length;
            int i = 0;
            if (i < k)
            {
              int m = localObject2[i];
              for (int j = 0;; j++) {
                if (j < arrayOfChar.length)
                {
                  if (m == arrayOfChar[j]) {
                    ((LinkedList)localObject1).add(Integer.valueOf(j));
                  }
                }
                else
                {
                  i++;
                  break;
                }
              }
            }
            localObject2 = new StringBuilder();
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((StringBuilder)localObject2).append(paramString1.charAt(((Integer)((Iterator)localObject1).next()).intValue()));
            }
            bool1 = paramString2.replace(":", "").substring(2, 8).equals(((StringBuilder)localObject2).toString());
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */