package com.wifipay.common.net.b;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class g
{
  private static final char[] a = "0123456789ABCDEF".toCharArray();
  
  public static String a(String paramString)
  {
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      paramString = paramString.getBytes("UTF-8");
      localMessageDigest.update(paramString, 0, paramString.length);
      paramString = a(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = (String)localObject;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = (String)localObject;
      }
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = a[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
    }
    return new String(arrayOfChar);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */