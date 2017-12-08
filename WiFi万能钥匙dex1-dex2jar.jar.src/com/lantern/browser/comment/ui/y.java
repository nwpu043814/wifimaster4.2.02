package com.lantern.browser.comment.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.lantern.analytics.a;
import com.lantern.browser.comment.d.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class y
  implements View.OnClickListener
{
  y(WkCommentFloorView paramWkCommentFloorView, PopupWindow paramPopupWindow, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    paramView = new HashMap();
    paramView.put("newsId", WkCommentFloorView.a(this.c).a());
    a.e().onEvent("cmtrepcli", new JSONObject(paramView).toString());
    if (this.a != null) {
      this.a.dismiss();
    }
    if (WkCommentFloorView.c(this.c) != null) {
      WkCommentFloorView.c(this.c).a(WkCommentFloorView.a(this.c), this.b);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */