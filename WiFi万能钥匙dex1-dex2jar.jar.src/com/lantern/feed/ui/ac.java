package com.lantern.feed.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.feed.a.m;
import com.lantern.feed.channel.a.a;

final class ac
  implements View.OnClickListener
{
  ac(ab paramab) {}
  
  public final void onClick(View paramView)
  {
    if (TextUtils.isEmpty(ab.a(this.a)))
    {
      m.a().onEvent("loadmore", m.a().l() + 1);
      m.a().h();
    }
    for (;;)
    {
      return;
      a.a().onEvent("loadmore", m.a().l() + 1);
      a.a().c();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */