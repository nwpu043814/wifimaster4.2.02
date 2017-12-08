package com.alipay.sdk.d;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class b
{
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
        localSecretKeySpec.<init>(paramString2.getBytes(), "DES");
        paramString2 = Cipher.getInstance("DES");
        paramString2.init(paramInt, localSecretKeySpec);
        if (paramInt != 2) {
          continue;
        }
        paramString1 = a.a(paramString1);
        paramString2 = paramString2.doFinal(paramString1);
        if (paramInt != 2) {
          continue;
        }
        paramString1 = new java/lang/String;
        paramString1.<init>(paramString2);
      }
      catch (Exception paramString1)
      {
        paramString1 = null;
        continue;
      }
      return paramString1;
      paramString1 = paramString1.getBytes("UTF-8");
      continue;
      paramString1 = a.a(paramString2);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */