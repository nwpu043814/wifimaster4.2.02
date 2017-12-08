package com.lantern.browser.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;
import com.lantern.browser.bp;
import com.lantern.browser.comment.d.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class k
  implements View.OnClickListener
{
  k(j paramj, n paramn) {}
  
  public final void onClick(View paramView)
  {
    bp.h(this.a.a());
    paramView = new HashMap();
    paramView.put("newsId", j.a(this.b));
    paramView.put("rnewsId", this.a.a());
    a.e().onEvent("brelacli", new JSONObject(paramView).toString());
    if (j.b(this.b) != null) {
      j.b(this.b).a(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */