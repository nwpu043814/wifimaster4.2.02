package com.tencent.wxop.stat.b;

import java.io.File;

final class p
{
  private static int aI = -1;
  
  public static boolean a()
  {
    boolean bool = true;
    if (aI == 1) {}
    for (;;)
    {
      return bool;
      if (aI != 0) {
        break;
      }
      bool = false;
    }
    for (int i = 0;; i++)
    {
      if (i < 6) {
        try
        {
          File localFile = new java/io/File;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localFile.<init>(new String[] { "/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/" }[i] + "su");
          if (!localFile.exists()) {
            continue;
          }
          aI = 1;
        }
        catch (Exception localException) {}
      }
      aI = 0;
      bool = false;
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */