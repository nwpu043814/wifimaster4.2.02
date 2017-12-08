package com.a.a.a.a;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  public static byte[] a = { 48, 48, 49, 55, 68, 67, 49, 66, 69, 50, 50, 53, 56, 53, 53, 52, 67, 70, 48, 50, 67, 53, 55, 66, 55, 56, 69, 55, 52, 48, 65, 53 };
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    try
    {
      paramString1.getBytes();
      Object localObject2 = a();
      paramString1 = paramString2.getBytes();
      paramString2 = new javax/crypto/spec/SecretKeySpec;
      paramString2.<init>((byte[])localObject2, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localObject2 = new javax/crypto/spec/IvParameterSpec;
      ((IvParameterSpec)localObject2).<init>(new byte[localCipher.getBlockSize()]);
      localCipher.init(1, paramString2, (AlgorithmParameterSpec)localObject2);
      paramString1 = localCipher.doFinal(paramString1);
      paramString2 = (String)localObject1;
      if (paramString1 != null) {
        paramString2 = a(paramString1);
      }
      return paramString2;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1 = null;
      }
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = "";
      return paramArrayOfByte;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfByte.length)
      {
        paramArrayOfByte = localStringBuffer.toString();
        break;
      }
      int j = paramArrayOfByte[i];
      localStringBuffer.append("0123456789ABCDEF".charAt(j >> 4 & 0xF)).append("0123456789ABCDEF".charAt(j & 0xF));
    }
  }
  
  private static byte[] a()
  {
    return a(new String(a, 0, 32));
  }
  
  private static byte[] a(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return arrayOfByte;
      }
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1.getBytes();
      Object localObject = a();
      paramString1 = a(paramString2);
      paramString2 = new javax/crypto/spec/SecretKeySpec;
      paramString2.<init>((byte[])localObject, "AES");
      localObject = Cipher.getInstance("AES/CBC/PKCS5Padding");
      IvParameterSpec localIvParameterSpec = new javax/crypto/spec/IvParameterSpec;
      localIvParameterSpec.<init>(new byte[((Cipher)localObject).getBlockSize()]);
      ((Cipher)localObject).init(2, paramString2, localIvParameterSpec);
      paramString2 = ((Cipher)localObject).doFinal(paramString1);
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
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */