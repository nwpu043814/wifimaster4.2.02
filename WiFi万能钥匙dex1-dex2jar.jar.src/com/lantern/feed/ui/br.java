package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;
import com.lantern.feed.b.m;
import java.util.HashMap;
import org.json.JSONObject;

final class br
  implements View.OnClickListener
{
  br(bm parambm) {}
  
  public final void onClick(View paramView)
  {
    if (bm.c(this.a) != null) {
      bm.c(this.a).cancel();
    }
    this.a.dismiss();
    paramView = new HashMap();
    paramView.put("id", String.valueOf(bm.b(this.a).a()));
    paramView.put("type", "manual");
    a.e().onEvent("nfw1", new JSONObject(paramView).toString());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */