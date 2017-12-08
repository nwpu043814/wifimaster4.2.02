package com.lantern.feed.ui;

import android.os.Handler;
import android.os.Message;
import com.lantern.feed.a.m.a;
import com.lantern.feed.b.a;
import com.lantern.feed.b.g;
import com.lantern.feed.b.k;
import com.lantern.feed.b.m;
import com.lantern.feed.b.u;
import java.util.List;

final class s
  implements m.a
{
  s(WkFeedFragment paramWkFeedFragment) {}
  
  public final void a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    WkFeedFragment.d(this.a).sendMessage(localMessage);
  }
  
  public final void a(int paramInt1, int paramInt2, List<g> paramList)
  {
    Message localMessage = new Message();
    localMessage.what = 5;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramList;
    WkFeedFragment.d(this.a).sendMessage(localMessage);
  }
  
  public final void a(a parama)
  {
    Message localMessage = new Message();
    localMessage.what = 7;
    localMessage.obj = parama;
    WkFeedFragment.d(this.a).sendMessage(localMessage);
  }
  
  public final void a(g paramg)
  {
    Message localMessage = new Message();
    localMessage.what = 9;
    localMessage.obj = paramg;
    WkFeedFragment.d(this.a).sendMessage(localMessage);
  }
  
  public final void a(k paramk)
  {
    Message localMessage = new Message();
    localMessage.what = 11;
    localMessage.obj = paramk;
    WkFeedFragment.d(this.a).sendMessage(localMessage);
  }
  
  public final void a(m paramm)
  {
    Message localMessage = new Message();
    localMessage.what = 8;
    localMessage.obj = paramm;
    WkFeedFragment.d(this.a).sendMessage(localMessage);
  }
  
  public final void a(u paramu)
  {
    Message localMessage = new Message();
    localMessage.what = 13;
    localMessage.obj = paramu;
    WkFeedFragment.d(this.a).sendMessage(localMessage);
  }
  
  public final void a(List<String> paramList)
  {
    Message localMessage = new Message();
    localMessage.what = 10;
    localMessage.obj = paramList;
    WkFeedFragment.d(this.a).sendMessage(localMessage);
  }
  
  public final void b(g paramg)
  {
    Message localMessage = new Message();
    localMessage.what = 12;
    localMessage.obj = paramg;
    WkFeedFragment.d(this.a).sendMessage(localMessage);
  }
  
  public final void b(u paramu)
  {
    Message localMessage = new Message();
    localMessage.what = 14;
    localMessage.obj = paramu;
    WkFeedFragment.d(this.a).sendMessage(localMessage);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */