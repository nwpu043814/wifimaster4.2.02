package com.wifipay.common.a;

import java.util.Random;

public class e
{
  private static char[] a = { 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48 };
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    for (int i = 0; i < paramInt; i++)
    {
      int j = localRandom.nextInt(a.length);
      localStringBuilder.append(a[Integer.valueOf(j).intValue()]);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */