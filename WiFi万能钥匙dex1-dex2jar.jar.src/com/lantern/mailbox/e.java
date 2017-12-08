package com.lantern.mailbox;

import android.os.Handler;
import android.os.Looper;
import com.lantern.mailbox.c.a;
import java.util.List;

final class e
  implements Runnable
{
  e(d paramd) {}
  
  public final void run()
  {
    List localList = a.a().a(MailboxFragment.b(this.a.a), false, true);
    new Handler(Looper.getMainLooper()).post(new f(this, localList));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */