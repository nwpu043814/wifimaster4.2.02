package com.lantern.browser.comment.ui;

import android.content.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.bluefay.a.e;
import com.lantern.analytics.a;
import com.lantern.browser.R.string;
import com.lantern.browser.comment.d.i;
import com.lantern.browser.comment.d.j;
import com.lantern.core.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class x
  implements View.OnClickListener
{
  x(WkCommentFloorView paramWkCommentFloorView, PopupWindow paramPopupWindow, j paramj) {}
  
  public final void onClick(View paramView)
  {
    paramView = new HashMap();
    paramView.put("newsId", WkCommentFloorView.a(this.c).a());
    a.e().onEvent("cmtdupcli", new JSONObject(paramView).toString());
    if (this.a != null) {
      this.a.dismiss();
    }
    if (this.b != null)
    {
      paramView = this.b.b();
      if (!TextUtils.isEmpty(paramView))
      {
        ((ClipboardManager)c.getInstance().getSystemService("clipboard")).setText(paramView);
        e.a(R.string.comment_copy_success);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */