package a.a.a.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class a
{
  public static final String a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      paramString = new java/lang/StringBuffer;
      paramString.<init>();
      int i = 0;
      if (i < arrayOfByte.length)
      {
        if (Integer.toHexString(arrayOfByte[i] & 0xFF).length() == 1) {
          paramString.append("0").append(Integer.toHexString(arrayOfByte[i] & 0xFF));
        }
        for (;;)
        {
          i++;
          break;
          paramString.append(Integer.toHexString(arrayOfByte[i] & 0xFF));
        }
        return paramString;
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    for (;;)
    {
      paramString = paramString.toString();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */