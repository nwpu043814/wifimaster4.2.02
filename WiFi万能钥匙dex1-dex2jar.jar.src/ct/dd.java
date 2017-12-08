package ct;

import java.io.FilenameFilter;
import java.util.concurrent.CountDownLatch;

public final class dd
{
  private static final FilenameFilter a = new dd.1();
  private static boolean b;
  
  public static CountDownLatch a(bi parambi, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      CountDownLatch localCountDownLatch = new java/util/concurrent/CountDownLatch;
      localCountDownLatch.<init>(1);
      dd.2 local2 = new ct/dd$2;
      local2.<init>(parambi, paramString1, paramString3, paramString2, localCountDownLatch);
      local2.start();
      return localCountDownLatch;
    }
    finally
    {
      parambi = finally;
      throw parambi;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */