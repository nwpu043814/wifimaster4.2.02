package com.lantern.mailbox;

import com.lantern.mailbox.view.LoadMoreListView;
import com.lantern.mailbox.view.LoadMoreListView.a;

final class d
  implements LoadMoreListView.a
{
  d(MailboxFragment paramMailboxFragment) {}
  
  public final void a()
  {
    if ("-1".equals(MailboxFragment.b(this.a))) {
      MailboxFragment.c(this.a).a(true);
    }
    for (;;)
    {
      return;
      new Thread(new e(this)).start();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */