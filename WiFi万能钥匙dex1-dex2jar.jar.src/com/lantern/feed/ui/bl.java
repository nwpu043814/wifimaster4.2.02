package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;
import com.lantern.feed.b.k;
import java.util.HashMap;
import org.json.JSONObject;

final class bl
  implements View.OnClickListener
{
  bl(bi parambi) {}
  
  public final void onClick(View paramView)
  {
    if (bi.c(this.a) != null) {
      bi.c(this.a).cancel();
    }
    this.a.dismiss();
    paramView = new HashMap();
    paramView.put("id", bi.b(this.a).i());
    paramView.put("type", "manual");
    a.e().onEvent("nfw1_ad", new JSONObject(paramView).toString());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */