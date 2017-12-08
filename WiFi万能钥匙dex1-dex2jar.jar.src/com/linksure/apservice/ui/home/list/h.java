package com.linksure.apservice.ui.home.list;

import android.widget.ListView;

final class h
  implements Runnable
{
  h(MessageListFragment paramMessageListFragment) {}
  
  public final void run()
  {
    if ((MessageListFragment.d(this.a) != null) && (MessageListFragment.c(this.a) != null) && (MessageListFragment.c(this.a).getCount() > 0)) {
      MessageListFragment.d(this.a).smoothScrollToPosition(MessageListFragment.c(this.a).getCount());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/list/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */