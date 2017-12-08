package com.lantern.favorite.c;

import java.security.MessageDigest;

public final class b
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(String paramString)
  {
    return b(paramString);
  }
  
  private static String b(String paramString)
  {
    int j = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      int k = paramString.length;
      localObject = new char[k * 2];
      int i = 0;
      while (j < k)
      {
        int n = paramString[j];
        int m = i + 1;
        localObject[i] = a[(n >>> 4 & 0xF)];
        i = m + 1;
        localObject[m] = a[(n & 0xF)];
        j++;
      }
      paramString = new String((char[])localObject);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    return paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */