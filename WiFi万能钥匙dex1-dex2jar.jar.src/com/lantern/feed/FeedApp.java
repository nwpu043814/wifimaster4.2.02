package com.lantern.feed;

import bluefay.app.l;
import com.bluefay.b.h;
import com.bluefay.d.b;
import com.lantern.core.c;
import com.lantern.core.config.FeedNativeConf;
import com.lantern.core.f;

public class FeedApp
  extends l
{
  private static b b = new a(new int[] { 128401 });
  
  public final void a()
  {
    super.a();
    h.a("onCreate", new Object[0]);
    FeedNativeConf localFeedNativeConf = (FeedNativeConf)com.lantern.core.config.d.a(c.getAppContext()).a(FeedNativeConf.class);
    if ((f.l()) && (localFeedNativeConf != null) && (localFeedNativeConf.d())) {
      com.lantern.feed.a.d.a();
    }
    c.addListener(b);
  }
  
  public final void b()
  {
    super.b();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/FeedApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */