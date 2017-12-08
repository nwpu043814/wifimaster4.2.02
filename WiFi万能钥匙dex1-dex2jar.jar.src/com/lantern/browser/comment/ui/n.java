package com.lantern.browser.comment.ui;

import com.lantern.browser.comment.d.g;
import com.lantern.browser.comment.d.h;

final class n
  implements com.bluefay.b.a
{
  n(WkCommentDetailFragment paramWkCommentDetailFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if ((paramInt == 1) && ((paramObject instanceof h)))
    {
      paramString = (h)paramObject;
      if (paramString.e() == 0) {
        WkCommentDetailFragment.b(this.a, 2);
      }
    }
    for (;;)
    {
      WkCommentDetailFragment.l(this.a);
      return;
      WkCommentDetailFragment.b(this.a, 0);
      WkCommentDetailFragment.a(this.a, new g());
      WkCommentDetailFragment.f(this.a).e(paramString.a());
      WkCommentDetailFragment.f(this.a).a(WkCommentDetailFragment.j(this.a));
      WkCommentDetailFragment.f(this.a).b(WkCommentDetailFragment.k(this.a));
      WkCommentDetailFragment.f(this.a).a(paramString);
      WkCommentDetailFragment.g(this.a).a(WkCommentDetailFragment.f(this.a));
      WkCommentDetailFragment.g(this.a).notifyDataSetChanged();
      continue;
      WkCommentDetailFragment.b(this.a, 3);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */