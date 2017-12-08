package com.lantern.settings.ui;

import android.os.Handler;

final class ba
  extends Thread
{
  ba(UrlTestActivity paramUrlTestActivity) {}
  
  public final void run()
  {
    for (int i = 0;; i = j) {
      for (;;)
      {
        try
        {
          Thread.sleep(1000L);
          boolean bool = UrlTestActivity.b(this.a);
          if (bool) {
            return;
          }
          j = i + 1;
          if (i > 1000)
          {
            try
            {
              Handler localHandler = UrlTestActivity.e(this.a);
              localObject = new com/lantern/settings/ui/bb;
              ((bb)localObject).<init>(this);
              localHandler.post((Runnable)localObject);
            }
            catch (InterruptedException localInterruptedException1)
            {
              i = j;
            }
            continue;
          }
        }
        catch (InterruptedException localInterruptedException2)
        {
          int j;
          Object localObject;
          bc localbc;
          continue;
        }
        if (UrlTestActivity.f(this.a) > 0) {
          continue;
        }
        localObject = UrlTestActivity.e(this.a);
        localbc = new com/lantern/settings/ui/bc;
        localbc.<init>(this);
        ((Handler)localObject).post(localbc);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */