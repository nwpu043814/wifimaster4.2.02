package com.alipay.sdk.d;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class e
{
  private static String a = "DESede/CBC/PKCS5Padding";
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString1 = a.a(a(paramString1, paramString2.getBytes()));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1 = (String)localObject;
      }
    }
  }
  
  public static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localSecretKeySpec.<init>(paramString.getBytes(), "DESede");
      IvParameterSpec localIvParameterSpec = new javax/crypto/spec/IvParameterSpec;
      localIvParameterSpec.<init>(new byte[8]);
      paramString = Cipher.getInstance(a);
      paramString.init(1, localSecretKeySpec, localIvParameterSpec);
      paramString = paramString.doFinal(paramArrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = (String)localObject;
      }
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = b(paramString1, a.a(paramString2));
      paramString1 = new java/lang/String;
      paramString1.<init>(paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1 = null;
      }
    }
  }
  
  public static byte[] b(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localSecretKeySpec.<init>(paramString.getBytes(), "DESede");
      paramString = new javax/crypto/spec/IvParameterSpec;
      paramString.<init>(new byte[8]);
      Cipher localCipher = Cipher.getInstance(a);
      localCipher.init(2, localSecretKeySpec, paramString);
      paramString = localCipher.doFinal(paramArrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = (String)localObject;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */