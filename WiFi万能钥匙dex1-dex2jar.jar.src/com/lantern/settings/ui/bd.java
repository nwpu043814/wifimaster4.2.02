package com.lantern.settings.ui;

import android.os.Handler;
import com.bluefay.b.h;
import com.lantern.settings.diagnose.b;
import java.util.HashMap;

final class bd
  extends Thread
{
  bd(UrlTestActivity paramUrlTestActivity, int paramInt1, String paramString, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    if (UrlTestActivity.b(this.e)) {}
    for (;;)
    {
      return;
      Object localObject1 = "\nThread " + this.a + " is beginning ...";
      UrlTestActivity.e(this.e).post(new be(this, (String)localObject1));
      HashMap localHashMap = new HashMap();
      b localb = new b(this.b);
      localObject1 = new StringBuilder();
      int i = 0;
      for (;;)
      {
        if (i < this.c)
        {
          if ((!UrlTestActivity.a()) || (UrlTestActivity.b(this.e)))
          {
            UrlTestActivity.i(this.e);
            h.a("Thread " + this.a + " times:" + i + " return", new Object[0]);
            break;
          }
          h.a(UrlTestActivity.b(this.e), new Object[0]);
          try
          {
            Object localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>("Thread ");
            h.a(this.a + " query times:" + i, new Object[0]);
            localObject2 = localb.a(localHashMap);
            UrlTestActivity.j(this.e);
            h.a((String)localObject2, new Object[0]);
            if (this.d <= 0) {}
          }
          catch (Exception localException)
          {
            try
            {
              Thread.sleep(this.d);
              i++;
              continue;
              localException = localException;
              UrlTestActivity.k(this.e);
              h.c(localException.toString());
              String str = localException.getMessage();
              UrlTestActivity.e(this.e).post(new bf(this, str));
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
        }
      }
      ((StringBuilder)localObject1).append("\nThread " + this.a + " is finished");
      UrlTestActivity.e(this.e).post(new bg(this, (StringBuilder)localObject1));
      UrlTestActivity.i(this.e);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */