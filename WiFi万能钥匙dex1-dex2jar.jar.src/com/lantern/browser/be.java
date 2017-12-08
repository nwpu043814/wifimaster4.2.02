package com.lantern.browser;

import android.widget.ProgressBar;

final class be
  extends Thread
{
  public final void run()
  {
    bd.c();
    int i = 0;
    for (;;)
    {
      if ((!bd.d()) && (i < 90) && (bd.e() <= 60)) {}
      try
      {
        sleep(50L);
        bd.f();
        int j = (int)(90.0D * Math.sin(0.02617993877991494D * bd.e()) + 0.5D);
        i = j;
        if (bd.g() == null) {
          continue;
        }
        i = j;
        if (bd.h() == null) {
          continue;
        }
        try
        {
          ProgressBar localProgressBar = bd.h();
          bf localbf = new com/lantern/browser/bf;
          localbf.<init>(this, j);
          localProgressBar.post(localbf);
          bd.g().a(j);
          i = j;
        }
        catch (Exception localException)
        {
          i = j;
        }
        continue;
        bd.i();
        bd.j();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */