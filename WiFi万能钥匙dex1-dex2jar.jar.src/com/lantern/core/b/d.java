package com.lantern.core.b;

import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

final class d
  implements Runnable
{
  d(c paramc) {}
  
  public final void run()
  {
    int j = 0;
    File[] arrayOfFile = c.a(this.a).listFiles();
    if (arrayOfFile != null)
    {
      int m = arrayOfFile.length;
      int k = 0;
      int i = 0;
      while (j < m)
      {
        File localFile = arrayOfFile[j];
        i = (int)(i + localFile.length());
        k++;
        c.b(this.a).put(localFile, Long.valueOf(localFile.lastModified()));
        j++;
      }
      c.c(this.a).set(i);
      c.d(this.a).set(k);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */