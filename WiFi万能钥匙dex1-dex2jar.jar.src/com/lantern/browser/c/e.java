package com.lantern.browser.c;

import android.os.AsyncTask.Status;
import android.os.Handler;
import android.os.Looper;
import com.bluefay.b.h;

final class e
  implements Runnable
{
  e(d paramd, Handler paramHandler) {}
  
  public final void run()
  {
    if ((this.b.a != null) && (this.b.a.getStatus() != AsyncTask.Status.FINISHED))
    {
      h.a("cancel this task", new Object[0]);
      c.a(this.b.a, new Integer[] { Integer.valueOf(-1) });
      this.b.a.cancel(true);
    }
    this.a.removeCallbacks(this);
    Looper.myLooper().quit();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */