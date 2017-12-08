package com.lantern.wifilocating.push.util;

import com.lantern.wifilocating.push.d.a;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class n
{
  private static String a(String paramString)
  {
    int j = paramString.length();
    for (int i = 0; i < 16 - j % 16; i++) {
      paramString = paramString + ' ';
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      localObject = "";
    }
    for (;;)
    {
      return (String)localObject;
      localObject = paramString1;
      if (paramString2 != null)
      {
        localObject = paramString1;
        if (paramString2.length() != 0)
        {
          localObject = paramString1;
          if (paramString3 != null)
          {
            localObject = paramString1;
            if (paramString3.length() != 0)
            {
              paramString3 = new IvParameterSpec(paramString3.getBytes());
              localObject = new SecretKeySpec(paramString2.getBytes(), "AES");
              try
              {
                paramString2 = Cipher.getInstance("AES/CBC/NoPadding");
                paramString2.init(1, (Key)localObject, paramString3);
                localObject = a.a(paramString2.doFinal(a(paramString1).getBytes()));
              }
              catch (Exception paramString2)
              {
                h.a(paramString2);
                localObject = paramString1;
              }
            }
          }
        }
      }
    }
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      paramString1 = "";
    }
    for (;;)
    {
      return paramString1;
      paramString3 = new IvParameterSpec(paramString3.getBytes());
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
      try
      {
        paramString2 = Cipher.getInstance("AES/CBC/NoPadding");
        paramString2.init(2, localSecretKeySpec, paramString3);
        paramString2 = paramString2.doFinal(a.a(paramString1));
        paramString1 = new java/lang/String;
        paramString1.<init>(paramString2);
      }
      catch (Exception paramString1)
      {
        h.a(paramString1);
        paramString1 = "";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */