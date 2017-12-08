package cm.pass.sdk.utils;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class g
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = b.b(a(paramString2.getBytes(), paramString1.getBytes()), 2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        paramString1 = "";
      }
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    SecureRandom localSecureRandom = new SecureRandom();
    paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
    paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
    Cipher localCipher = Cipher.getInstance("DES");
    localCipher.init(1, paramArrayOfByte2, localSecureRandom);
    return localCipher.doFinal(paramArrayOfByte1);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */