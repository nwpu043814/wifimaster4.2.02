package com.lantern.browser.comment.ui;

import android.view.View;
import com.bluefay.b.a;
import com.lantern.browser.comment.d.m;
import java.util.List;

final class ak
  implements a
{
  ak(WkCommentSetUserInfoGuideActivity paramWkCommentSetUserInfoGuideActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      WkCommentSetUserInfoGuideActivity.a(this.a, (m)paramObject);
      if ((WkCommentSetUserInfoGuideActivity.a(this.a)) && (WkCommentSetUserInfoGuideActivity.b(this.a).b() != null) && (!WkCommentSetUserInfoGuideActivity.b(this.a).b().isEmpty())) {
        WkCommentSetUserInfoGuideActivity.c(this.a).setVisibility(0);
      }
      if ((WkCommentSetUserInfoGuideActivity.d(this.a)) && (WkCommentSetUserInfoGuideActivity.b(this.a).a() != null) && (!WkCommentSetUserInfoGuideActivity.b(this.a).a().isEmpty()))
      {
        WkCommentSetUserInfoGuideActivity.e(this.a).setVisibility(0);
        WkCommentSetUserInfoGuideActivity.f(this.a).setVisibility(0);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */