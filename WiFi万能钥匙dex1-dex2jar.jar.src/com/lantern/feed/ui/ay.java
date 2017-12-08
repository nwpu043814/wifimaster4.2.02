package com.lantern.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;
import com.lantern.feed.b.g;
import java.util.HashMap;
import org.json.JSONObject;

final class ay
  implements View.OnClickListener
{
  ay(aw paramaw) {}
  
  public final void onClick(View paramView)
  {
    aw.b(this.a);
    paramView = new HashMap();
    paramView.put("dataType", String.valueOf(this.a.k.b()));
    paramView.put("id", this.a.k.r());
    paramView.put("pageNo", String.valueOf(this.a.k.o()));
    paramView.put("pos", String.valueOf(this.a.k.p()));
    paramView.put("template", String.valueOf(this.a.k.c()));
    paramView.put("fv", "1018");
    a.e().onEvent("doadccli", new JSONObject(paramView).toString());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */