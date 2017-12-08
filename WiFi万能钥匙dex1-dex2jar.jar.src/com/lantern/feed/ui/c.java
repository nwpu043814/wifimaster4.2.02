package com.lantern.feed.ui;

import android.text.TextUtils;
import android.widget.PopupWindow.OnDismissListener;
import com.lantern.feed.a.m;
import com.lantern.feed.b.d;
import com.lantern.feed.b.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

final class c
  implements PopupWindow.OnDismissListener
{
  c(b paramb) {}
  
  public final void onDismiss()
  {
    Object localObject;
    if (a.b(this.a.a).b())
    {
      HashMap localHashMap;
      Iterator localIterator;
      if (TextUtils.isEmpty(this.a.a.l))
      {
        m.a().b(this.a.a.k);
        localHashMap = new HashMap();
        localHashMap.put("id", this.a.a.k.r());
        localIterator = a.b(this.a.a).a().iterator();
        localObject = "";
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label186;
        }
        d locald = (d)localIterator.next();
        if (((String)localObject).equals(""))
        {
          localObject = locald.b();
          continue;
          com.lantern.feed.channel.a.a.a().b(this.a.a.k);
          break;
        }
        localObject = (String)localObject + "_" + locald.b();
      }
      label186:
      if (!((String)localObject).equals("")) {
        localHashMap.put("reason", localObject);
      }
      com.lantern.analytics.a.e().onEvent("ddlkcom_" + this.a.a.k.b(), new JSONObject(localHashMap).toString());
    }
    if (a.b(this.a.a).a().size() > 0)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("id", this.a.a.k.r());
      com.lantern.analytics.a.e().onEvent("ddlksel_" + this.a.a.k.b(), new JSONObject((Map)localObject).toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */