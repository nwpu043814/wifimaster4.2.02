package com.lantern.core;

import android.util.Base64;
import com.bluefay.b.c;
import com.bluefay.b.h;
import com.lantern.d.a;
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
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnonnull +7 -> 10
    //   6: aload_3
    //   7: astore_2
    //   8: aload_2
    //   9: areturn
    //   10: aload_3
    //   11: astore_2
    //   12: aload_1
    //   13: invokevirtual 12	java/lang/String:length	()I
    //   16: bipush 16
    //   18: if_icmpne -10 -> 8
    //   21: aload_1
    //   22: ldc 35
    //   24: invokevirtual 39	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   27: astore_1
    //   28: new 41	javax/crypto/spec/SecretKeySpec
    //   31: astore_2
    //   32: aload_2
    //   33: aload_1
    //   34: ldc 43
    //   36: invokespecial 46	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   39: ldc 48
    //   41: invokestatic 54	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   44: astore_1
    //   45: aload_1
    //   46: iconst_2
    //   47: aload_2
    //   48: invokevirtual 58	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   51: aload_0
    //   52: iconst_0
    //   53: invokestatic 64	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   56: astore_0
    //   57: aload_1
    //   58: aload_0
    //   59: invokevirtual 68	javax/crypto/Cipher:doFinal	([B)[B
    //   62: astore_0
    //   63: new 8	java/lang/String
    //   66: astore_2
    //   67: aload_2
    //   68: aload_0
    //   69: ldc 35
    //   71: invokespecial 69	java/lang/String:<init>	([BLjava/lang/String;)V
    //   74: goto -66 -> 8
    //   77: astore_0
    //   78: aload_3
    //   79: astore_2
    //   80: goto -72 -> 8
    //   83: astore_0
    //   84: aload_3
    //   85: astore_2
    //   86: goto -78 -> 8
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramString1	String
    //   0	89	1	paramString2	String
    //   7	79	2	localObject1	Object
    //   1	84	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	57	77	java/lang/Exception
    //   57	74	83	java/lang/Exception
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
                localObject = c.a(paramString2.doFinal(a(paramString1).getBytes()));
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
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length % 16 != 0)
    {
      arrayOfByte = new byte[(paramArrayOfByte.length / 16 + 1) * 16];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      localObject = null;
    }
    for (;;)
    {
      return (byte[])localObject;
      localObject = paramArrayOfByte;
      if (paramString1 != null)
      {
        localObject = paramArrayOfByte;
        if (paramString1.length() != 0)
        {
          localObject = paramArrayOfByte;
          if (paramString2 != null)
          {
            localObject = paramArrayOfByte;
            if (paramString2.length() != 0)
            {
              paramString2 = new IvParameterSpec(paramString2.getBytes());
              paramString1 = new SecretKeySpec(paramString1.getBytes(), "AES");
              try
              {
                localObject = Cipher.getInstance("AES/CBC/NoPadding");
                ((Cipher)localObject).init(1, paramString1, paramString2);
                localObject = ((Cipher)localObject).doFinal(a(paramArrayOfByte));
              }
              catch (Exception paramString1)
              {
                h.a(paramString1);
                localObject = paramArrayOfByte;
              }
            }
          }
        }
      }
    }
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
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
                paramString2 = paramString2.doFinal(a(a.a(paramString1.getBytes())));
                localObject = new java/lang/String;
                ((String)localObject).<init>(Base64.encodeToString(paramString2, 0));
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
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length != 0) {
        break label20;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (byte[])localObject1;
      label20:
      paramString2 = new IvParameterSpec(paramString2.getBytes());
      localObject1 = new SecretKeySpec(paramString1.getBytes(), "AES");
      try
      {
        paramString1 = Cipher.getInstance("AES/CBC/NoPadding");
        paramString1.init(2, (Key)localObject1, paramString2);
        localObject1 = paramString1.doFinal(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        h.a(paramArrayOfByte);
        localObject1 = localObject2;
      }
    }
  }
  
  public static String c(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      paramString1 = "";
    }
    for (;;)
    {
      return paramString1;
      paramString3 = new IvParameterSpec(paramString3.getBytes());
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
      try
      {
        Cipher localCipher = Cipher.getInstance("AES/CBC/NoPadding");
        localCipher.init(2, paramString2, paramString3);
        paramString2 = localCipher.doFinal(c.a(paramString1));
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */