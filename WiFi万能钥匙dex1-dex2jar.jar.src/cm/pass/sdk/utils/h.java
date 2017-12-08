package cm.pass.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class h
{
  public static String a(String paramString)
  {
    str = "";
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
      localObject = ((MessageDigest)localObject).digest();
      paramString = new java/lang/StringBuffer;
      paramString.<init>("");
      for (int i = 0; i < localObject.length; i++)
      {
        int k = localObject[i];
        int j = k;
        if (k < 0) {
          j = k + 256;
        }
        if (j < 16) {
          paramString.append("0");
        }
        paramString.append(Integer.toHexString(j));
      }
      paramString = paramString.toString();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = str;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = str;
      }
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      f localf = new cm/pass/sdk/utils/f;
      localf.<init>(paramString1);
      paramString1 = localf.b(paramString2);
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
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    for (paramArrayOfByte = null;; paramArrayOfByte = localStringBuilder.toString())
    {
      return paramArrayOfByte;
      for (int i = 0; i < paramArrayOfByte.length; i++)
      {
        String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        if (str.length() < 2) {
          localStringBuilder.append(0);
        }
        localStringBuilder.append(str);
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    localObject = null;
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localSecretKeySpec.<init>(paramArrayOfByte1, "HmacSHA256");
      localMac.init(localSecretKeySpec);
      paramArrayOfByte1 = localMac.doFinal(paramArrayOfByte2);
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        paramArrayOfByte1 = (byte[])localObject;
      }
    }
    catch (InvalidKeyException paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        paramArrayOfByte1 = (byte[])localObject;
      }
    }
    return paramArrayOfByte1;
  }
  
  public static final String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramString.getBytes());
      paramString = a(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      f localf = new cm/pass/sdk/utils/f;
      localf.<init>(paramString1);
      paramString1 = localf.a(paramString2);
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
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new X509EncodedKeySpec(paramArrayOfByte2);
    PublicKey localPublicKey = KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte2);
    paramArrayOfByte2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    paramArrayOfByte2.init(1, localPublicKey);
    return paramArrayOfByte2.doFinal(paramArrayOfByte1);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */