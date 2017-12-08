package com.lantern.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.lantern.feed.b.g;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

final class b
  implements View.OnClickListener
{
  b(a parama) {}
  
  public final void onClick(View paramView)
  {
    if ((this.a.k.W() == null) || (this.a.k.W().size() == 0)) {
      this.a.g.setVisibility(8);
    }
    for (;;)
    {
      return;
      if (a.a(this.a) == null)
      {
        a.a(this.a, new PopupWindow(-1, -1));
        a.a(this.a).setFocusable(true);
        a.a(this.a).setOnDismissListener(new c(this));
      }
      a.a(this.a, new i(this.a.d, a.a(this.a)));
      a.b(this.a).a(this.a.k, paramView);
      a.a(this.a).setContentView(a.b(this.a));
      a.a(this.a).showAtLocation(paramView, 0, 0, 0);
      paramView = new HashMap();
      paramView.put("id", this.a.k.r());
      com.lantern.analytics.a.e().onEvent("ddlkcli_" + this.a.k.b(), new JSONObject(paramView).toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */