package com.lantern.browser.comment.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class al
  implements View.OnClickListener
{
  al(WkCommentSetUserInfoGuideActivity paramWkCommentSetUserInfoGuideActivity) {}
  
  public final void onClick(View paramView)
  {
    if (paramView == WkCommentSetUserInfoGuideActivity.g(this.a)) {
      WkCommentSetUserInfoGuideActivity.a(this.a, WkCommentSetUserInfoGuideActivity.h(this.a).getText().toString());
    }
    for (;;)
    {
      return;
      if (paramView == WkCommentSetUserInfoGuideActivity.e(this.a))
      {
        if (WkCommentSetUserInfoGuideActivity.i(this.a)) {
          WkCommentSetUserInfoGuideActivity.a(this.a, 2, 3);
        } else {
          WkCommentSetUserInfoGuideActivity.j(this.a);
        }
      }
      else if (paramView == WkCommentSetUserInfoGuideActivity.k(this.a))
      {
        WkCommentSetUserInfoGuideActivity.a(this.a, 2, 1);
      }
      else if (paramView == WkCommentSetUserInfoGuideActivity.l(this.a))
      {
        WkCommentSetUserInfoGuideActivity.a(this.a, 3, 1);
      }
      else if (paramView == WkCommentSetUserInfoGuideActivity.c(this.a))
      {
        paramView = this.a.a(WkCommentSetUserInfoGuideActivity.h(this.a).getText().toString());
        WkCommentSetUserInfoGuideActivity.h(this.a).setText(paramView);
        if (paramView != null) {
          WkCommentSetUserInfoGuideActivity.h(this.a).setSelection(WkCommentSetUserInfoGuideActivity.h(this.a).length());
        }
      }
      else if ((paramView == WkCommentSetUserInfoGuideActivity.m(this.a)) || (paramView == WkCommentSetUserInfoGuideActivity.n(this.a)))
      {
        WkCommentSetUserInfoGuideActivity.a(this.a, 1000);
      }
      else if (paramView == WkCommentSetUserInfoGuideActivity.o(this.a))
      {
        WkCommentSetUserInfoGuideActivity.a(this.a, 1001);
      }
      else if (paramView == WkCommentSetUserInfoGuideActivity.p(this.a))
      {
        WkCommentSetUserInfoGuideActivity.q(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */