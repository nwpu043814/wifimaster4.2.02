package ct;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class ao
{
  private Cipher a;
  private Cipher b;
  
  public ao(byte[] paramArrayOfByte)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localSecretKeySpec.<init>(paramArrayOfByte, "AES");
      this.a = Cipher.getInstance("AES/ECB/PKCS5Padding");
      this.a.init(1, localSecretKeySpec);
      this.b = Cipher.getInstance("AES/ECB/PKCS5Padding");
      this.b.init(2, localSecretKeySpec);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = this.a.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */