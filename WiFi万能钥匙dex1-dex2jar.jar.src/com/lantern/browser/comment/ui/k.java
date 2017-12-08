package com.lantern.browser.comment.ui;

import com.lantern.browser.comment.d.g;
import java.util.List;

final class k
  implements com.bluefay.b.a
{
  k(i parami) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramString = (List)paramObject;
      WkCommentDetailFragment.f(this.a.a).b(false);
      WkCommentDetailFragment.f(this.a.a).a(true);
      if ((paramString != null) && (!paramString.isEmpty())) {
        WkCommentDetailFragment.f(this.a.a).a(paramString);
      }
      WkCommentDetailFragment.g(this.a.a).notifyDataSetChanged();
      WkCommentDetailFragment.d(this.a.a).setSelection(0);
    }
    for (;;)
    {
      return;
      if (WkCommentDetailFragment.f(this.a.a).d(2)) {
        WkCommentDetailFragment.g(this.a.a).notifyDataSetChanged();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */