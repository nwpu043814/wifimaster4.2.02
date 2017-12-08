package com.lantern.feed.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.feed.a.m;
import com.lantern.feed.b.g;
import java.util.HashMap;
import org.json.JSONObject;

final class az
  implements View.OnClickListener
{
  az(aw paramaw) {}
  
  public final void onClick(View paramView)
  {
    if (!this.a.k.R())
    {
      this.a.k.b(true);
      aw.b(this.a);
      aw.a(this.a);
      this.a.requestLayout();
      if (TextUtils.isEmpty(this.a.l))
      {
        m.a().a(3, this.a.k);
        paramView = new HashMap();
        paramView.put("dataType", String.valueOf(this.a.k.b()));
        paramView.put("id", this.a.k.r());
        paramView.put("pageNo", String.valueOf(this.a.k.o()));
        paramView.put("pos", String.valueOf(this.a.k.p()));
        paramView.put("template", String.valueOf(this.a.k.c()));
        paramView.put("fv", "1018");
        com.lantern.analytics.a.e().onEvent("doafocli", new JSONObject(paramView).toString());
      }
    }
    for (;;)
    {
      return;
      com.lantern.feed.channel.a.a.a().a(3, this.a.k);
      break;
      this.a.onClick(paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */