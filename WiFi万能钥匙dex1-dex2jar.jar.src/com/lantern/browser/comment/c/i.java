package com.lantern.browser.comment.c;

import android.os.Message;
import android.text.TextUtils;
import com.bluefay.d.b;
import com.lantern.core.c;

final class i
  extends b
{
  i(h paramh, int[] paramArrayOfInt)
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
      if (!TextUtils.isEmpty(a.l(this.a.b.a)))
      {
        c.removeListener(this);
        com.lantern.analytics.a.e().onEvent("cmtskip1");
        this.a.b.a.b(a.l(this.a.b.a));
        a.d(this.a.b.a, null);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */