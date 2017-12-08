package com.lantern.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;
import com.lantern.feed.d.d;

final class ca
  implements View.OnClickListener
{
  ca(WkFeedTabLabel paramWkFeedTabLabel) {}
  
  public final void onClick(View paramView)
  {
    d.b();
    a.e().onEvent("dscicli");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */