package com.lantern.feed.ui;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import com.lantern.feed.b.a;
import com.lantern.feed.b.g;
import com.lantern.feed.b.k;
import com.lantern.feed.b.m;
import com.lantern.feed.b.u;
import java.util.List;

final class o
  extends Handler
{
  o(WkFeedFragment paramWkFeedFragment) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (!WkFeedFragment.a(this.a)) {}
    for (;;)
    {
      return;
      switch (paramMessage.what)
      {
      case 3: 
      case 4: 
      default: 
        break;
      case 2: 
        WkFeedFragment.a(this.a, paramMessage.arg1);
        break;
      case 5: 
        WkFeedFragment.a(this.a, paramMessage.arg1, paramMessage.arg2, (List)paramMessage.obj);
        break;
      case 6: 
        WkFeedFragment.b(this.a).setVisibility(8);
        break;
      case 7: 
        WkFeedFragment.a(this.a, (a)paramMessage.obj);
        break;
      case 8: 
        if ((WkFeedFragment.c(this.a).getMeasuredWidth() > 0) && (WkFeedFragment.c(this.a).getMeasuredHeight() > 0)) {
          WkFeedFragment.a(this.a, (m)paramMessage.obj);
        } else {
          WkFeedFragment.d(this.a).sendMessageDelayed(paramMessage, 1000L);
        }
        break;
      case 9: 
        WkFeedFragment.a(this.a, (g)paramMessage.obj);
        break;
      case 10: 
        WkFeedFragment.a(this.a, (List)paramMessage.obj);
        break;
      case 11: 
        WkFeedFragment.a(this.a, (k)paramMessage.obj);
        break;
      case 12: 
        WkFeedFragment localWkFeedFragment = this.a;
        paramMessage = paramMessage.obj;
        WkFeedFragment.e(localWkFeedFragment);
        break;
      case 13: 
        WkFeedFragment.a(this.a, (u)paramMessage.obj);
        break;
      case 14: 
        WkFeedFragment.b(this.a, (u)paramMessage.obj);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */