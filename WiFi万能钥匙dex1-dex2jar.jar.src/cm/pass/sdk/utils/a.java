package cm.pass.sdk.utils;

import android.text.TextUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "";
    }
    for (;;)
    {
      return paramString1;
      paramString2 = k.a(paramString2);
      paramString1 = paramString1.getBytes();
      try
      {
        paramString2 = a(paramString1, paramString2);
        paramString1 = new java/lang/String;
        paramString1.<init>(b.a(paramString2));
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = "";
      }
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte2, "AES");
    paramArrayOfByte2 = Cipher.getInstance("AES/ECB/PKCS5Padding");
    paramArrayOfByte2.init(1, localSecretKeySpec);
    return paramArrayOfByte2.doFinal(paramArrayOfByte1);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "";
    }
    for (;;)
    {
      return paramString1;
      paramString2 = k.a(paramString2);
      byte[] arrayOfByte = b.a(paramString1);
      try
      {
        paramString1 = new java/lang/String;
        paramString1.<init>(b(arrayOfByte, paramString2));
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = "";
      }
    }
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte2, "AES");
    paramArrayOfByte2 = Cipher.getInstance("AES/ECB/PKCS5Padding");
    paramArrayOfByte2.init(2, localSecretKeySpec);
    return paramArrayOfByte2.doFinal(paramArrayOfByte1);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */