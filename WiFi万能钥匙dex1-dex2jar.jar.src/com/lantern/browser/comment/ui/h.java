package com.lantern.browser.comment.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class h
  implements View.OnClickListener
{
  h(WkCommentDetailFragment paramWkCommentDetailFragment) {}
  
  public final void onClick(View paramView)
  {
    if (WkCommentDetailFragment.d(this.a).getCount() > 0) {
      WkCommentDetailFragment.d(this.a).setSelection(0);
    }
    paramView = new HashMap();
    paramView.put("newsId", WkCommentDetailFragment.e(this.a));
    a.e().onEvent("cmttitcli", new JSONObject(paramView).toString());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */