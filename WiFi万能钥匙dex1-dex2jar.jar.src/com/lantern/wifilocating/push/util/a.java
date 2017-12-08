package com.lantern.wifilocating.push.util;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
{
  private static final AtomicInteger a = new AtomicInteger();
  
  static
  {
    int i = new Random().nextInt(10000);
    a.set(i);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = 0;
    try
    {
      int j = Integer.parseInt(paramString2);
      i = j;
    }
    catch (Exception paramString2)
    {
      for (;;) {}
    }
    if ("0".equals(paramString1)) {
      i += 10000000;
    }
    for (;;)
    {
      return i;
      if ("1".equals(paramString1)) {
        i += 50000000;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */