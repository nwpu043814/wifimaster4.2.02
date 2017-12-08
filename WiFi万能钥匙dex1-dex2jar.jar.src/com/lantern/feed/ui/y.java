package com.lantern.feed.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.feed.a.m;
import java.util.HashMap;
import org.json.JSONObject;

final class y
  implements View.OnClickListener
{
  y(x paramx) {}
  
  public final void onClick(View paramView)
  {
    if (TextUtils.isEmpty(x.a(this.a)))
    {
      m.a().g();
      com.lantern.analytics.a.e().onEvent("dlrcli");
    }
    for (;;)
    {
      return;
      com.lantern.feed.channel.a.a.a().b();
      paramView = new HashMap();
      paramView.put("tabId", com.lantern.feed.channel.a.a.a().f());
      com.lantern.analytics.a.e().onEvent("dlrcli", new JSONObject(paramView).toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */