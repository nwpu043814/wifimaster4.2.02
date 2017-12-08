package com.lantern.browser.comment.ui;

import com.lantern.analytics.a;
import com.lantern.browser.comment.d.i;
import com.lantern.browser.comment.d.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class z
  implements ExpandableTextView.a
{
  z(WkCommentFloorView paramWkCommentFloorView, j paramj) {}
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("newsId", WkCommentFloorView.a(this.b).a());
      a.e().onEvent("cmtunfcli", new JSONObject(localHashMap).toString());
      this.a.c(1);
    }
    for (;;)
    {
      return;
      this.a.c(0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */