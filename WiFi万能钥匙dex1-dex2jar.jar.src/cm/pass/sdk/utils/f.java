package cm.pass.sdk.utils;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class f
{
  private static String a = "1111";
  private Cipher b = null;
  private Cipher c = null;
  
  public f()
  {
    this(a);
  }
  
  public f(String paramString)
  {
    paramString = c(paramString.getBytes());
    this.b = Cipher.getInstance("DES");
    this.b.init(1, paramString);
    this.c = Cipher.getInstance("DES");
    this.c.init(2, paramString);
  }
  
  private Key c(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[8];
    for (int i = 0; (i < paramArrayOfByte.length) && (i < 8); i++) {
      arrayOfByte[i] = paramArrayOfByte[i];
    }
    return new SecretKeySpec(arrayOfByte, "DES");
  }
  
  private static byte[] c(String paramString)
  {
    byte[] arrayOfByte2 = paramString.getBytes();
    int j = arrayOfByte2.length;
    byte[] arrayOfByte1 = new byte[j / 2];
    for (int i = 0; i < j; i += 2)
    {
      paramString = new String(arrayOfByte2, i, 2);
      arrayOfByte1[(i / 2)] = ((byte)Integer.parseInt(paramString, 16));
    }
    return arrayOfByte1;
  }
  
  private static String d(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    StringBuffer localStringBuffer = new StringBuffer(k * 2);
    for (int i = 0; i < k; i++)
    {
      for (int j = paramArrayOfByte[i]; j < 0; j += 256) {}
      if (j < 16) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(Integer.toString(j, 16));
    }
    return localStringBuffer.toString();
  }
  
  public String a(String paramString)
  {
    return d(a(paramString.getBytes()));
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    return this.b.doFinal(paramArrayOfByte);
  }
  
  public String b(String paramString)
  {
    return new String(b(c(paramString)));
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    return this.c.doFinal(paramArrayOfByte);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */