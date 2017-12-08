package com.lantern.browser.comment.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;
import com.lantern.browser.comment.d.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class w
  implements View.OnClickListener
{
  w(WkCommentFloorView paramWkCommentFloorView) {}
  
  public final void onClick(View paramView)
  {
    paramView = new HashMap();
    paramView.put("newsId", WkCommentFloorView.a(this.a).a());
    a.e().onEvent("cmthflcli", new JSONObject(paramView).toString());
    WkCommentFloorView.a(this.a).c();
    WkCommentFloorView.b(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */