package com.alipay.c.a.a.a.a;

import java.lang.reflect.Method;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class c
{
  private static String a = new String("idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#");
  
  public static String a()
  {
    String str = new String();
    for (int i = 0; i < a.length() - 1; i += 4) {
      str = str + a.charAt(i);
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a(a(paramString1.getBytes()), paramString2.getBytes());
      if (paramString1 == null)
      {
        paramString1 = "";
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1 = null;
        continue;
        paramString2 = new StringBuffer(paramString1.length * 2);
        for (int i = 0; i < paramString1.length; i++)
        {
          int j = paramString1[i];
          paramString2.append("0123456789ABCDEF".charAt(j >> 4 & 0xF)).append("0123456789ABCDEF".charAt(j & 0xF));
        }
        paramString1 = paramString2.toString();
      }
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    Class localClass = Class.forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
    Object localObject = localClass.getMethod("getInstance", new Class[] { String.class, String.class }).invoke(null, new Object[] { "SHA1PRNG", "Crypto" });
    Method localMethod = localClass.getMethod("setSeed", new Class[] { paramArrayOfByte.getClass() });
    localMethod.setAccessible(true);
    localMethod.invoke(localObject, new Object[] { paramArrayOfByte });
    KeyGenerator.class.getMethod("init", new Class[] { Integer.TYPE, localClass }).invoke(localKeyGenerator, new Object[] { Integer.valueOf(128), localObject });
    return localKeyGenerator.generateKey().getEncoded();
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localSecretKeySpec.<init>(paramArrayOfByte1, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      paramArrayOfByte1 = new javax/crypto/spec/IvParameterSpec;
      paramArrayOfByte1.<init>(new byte[localCipher.getBlockSize()]);
      localCipher.init(1, localSecretKeySpec, paramArrayOfByte1);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (Throwable paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1 = null;
      }
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = a(paramString1.getBytes());
      int j = paramString2.length() / 2;
      paramString1 = new byte[j];
      for (int i = 0; i < j; i++) {
        paramString1[i] = Integer.valueOf(paramString2.substring(i * 2, i * 2 + 2), 16).byteValue();
      }
      paramString2 = new javax/crypto/spec/SecretKeySpec;
      paramString2.<init>((byte[])localObject, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localObject = new javax/crypto/spec/IvParameterSpec;
      ((IvParameterSpec)localObject).<init>(new byte[localCipher.getBlockSize()]);
      localCipher.init(2, paramString2, (AlgorithmParameterSpec)localObject);
      paramString1 = new String(localCipher.doFinal(paramString1));
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1 = null;
      }
    }
    return paramString1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */