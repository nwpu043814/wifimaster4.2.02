package com.lantern.browser.comment.ui;

import android.os.Message;
import android.text.TextUtils;
import com.bluefay.d.b;
import com.lantern.analytics.a;
import com.lantern.core.c;

final class t
  extends b
{
  t(s params, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(WkCommentDetailFragment.r(this.a.b.a)))
      {
        c.removeListener(this);
        a.e().onEvent("cmtskip1");
        this.a.b.a.a(WkCommentDetailFragment.r(this.a.b.a));
        WkCommentDetailFragment.b(this.a.b.a, null);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */