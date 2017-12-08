package com.lantern.browser.comment.ui;

import com.lantern.browser.comment.d.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

final class j
  implements com.bluefay.b.a
{
  j(i parami) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramString = new HashMap();
      paramString.put("newsId", WkCommentDetailFragment.e(this.a.a));
      com.lantern.analytics.a.e().onEvent("cmtbol_s", new JSONObject(paramString).toString());
      paramString = (List)paramObject;
      if ((paramString == null) || (paramString.isEmpty())) {
        if (WkCommentDetailFragment.f(this.a.a).c(2)) {
          WkCommentDetailFragment.g(this.a.a).notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      return;
      WkCommentDetailFragment.f(this.a.a).b(paramString);
      WkCommentDetailFragment.g(this.a.a).notifyDataSetChanged();
      continue;
      paramString = new HashMap();
      paramString.put("newsId", WkCommentDetailFragment.e(this.a.a));
      com.lantern.analytics.a.e().onEvent("cmtbol_f", new JSONObject(paramString).toString());
      if (WkCommentDetailFragment.f(this.a.a).c(3)) {
        WkCommentDetailFragment.g(this.a.a).notifyDataSetChanged();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */