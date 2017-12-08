package com.lantern.mailbox;

import android.view.View;
import com.bluefay.material.SwipeRefreshLayout;
import com.bluefay.material.SwipeRefreshLayout.a;
import java.util.concurrent.Executors;

final class c
  implements SwipeRefreshLayout.a
{
  c(MailboxFragment paramMailboxFragment, SwipeRefreshLayout paramSwipeRefreshLayout, View paramView) {}
  
  public final void a()
  {
    new MailboxFragment.a(this.c, null, this.a, this.b).executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
  }
  
  public final void b() {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */