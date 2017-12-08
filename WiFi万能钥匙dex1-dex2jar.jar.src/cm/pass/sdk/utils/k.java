package cm.pass.sdk.utils;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class k
{
  static char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  private static char a(char paramChar)
  {
    char c;
    if ((paramChar >= '0') && (paramChar <= '9')) {
      c = (char)(paramChar - '0');
    }
    for (;;)
    {
      return c;
      if ((paramChar >= 'a') && (paramChar <= 'f')) {
        c = (char)(paramChar - 'a' + 10);
      } else if ((paramChar >= 'A') && (paramChar <= 'F')) {
        c = (char)(paramChar - 'A' + 10);
      } else {
        c = ' ';
      }
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar = new char[32];
    int j = 0;
    while (i < 16)
    {
      int m = paramArrayOfByte[i];
      int k = j + 1;
      arrayOfChar[j] = a[(m >>> 4 & 0xF)];
      j = k + 1;
      arrayOfChar[k] = a[(m & 0xF)];
      i++;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] a(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {}
    for (paramString = a(paramString.toCharArray());; paramString = null) {
      return paramString;
    }
  }
  
  public static byte[] a(char[] paramArrayOfChar)
  {
    char[] arrayOfChar = new char[2];
    byte[] arrayOfByte = new byte[paramArrayOfChar.length / 2];
    int j = 0;
    for (int i = 0; j + 1 < paramArrayOfChar.length; i++)
    {
      arrayOfChar[0] = paramArrayOfChar[j];
      arrayOfChar[1] = paramArrayOfChar[(j + 1)];
      arrayOfByte[i] = b(arrayOfChar);
      j += 2;
    }
    return arrayOfByte;
  }
  
  private static byte b(char[] paramArrayOfChar)
  {
    char[] arrayOfChar = new char[2];
    arrayOfChar[0] = a(paramArrayOfChar[0]);
    arrayOfChar[1] = a(paramArrayOfChar[1]);
    int i = arrayOfChar[0];
    return (byte)(arrayOfChar[1] | i << 4);
  }
  
  public static String b(String paramString)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramString.getBytes("UTF-8"));
        paramString = a(localMessageDigest.digest());
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString = (String)localObject;
      }
      catch (NoSuchAlgorithmException paramString)
      {
        paramString = (String)localObject;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */