package com.lantern.browser.comment.c;

import android.os.Handler.Callback;
import android.os.Message;
import com.lantern.browser.comment.d.k;
import com.lantern.browser.comment.ui.WkCommentToolBar;
import com.lantern.browser.ui.WkDetailBottomLayout;
import com.lantern.core.p;
import java.util.List;

final class c
  implements Handler.Callback
{
  c(a parama) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (a.a(paramMessage).equals(a.a(this.a)))
      {
        a.a(this.a, (k)paramMessage.obj);
        continue;
        a.a(this.a, paramMessage.arg1);
        if (a.a(paramMessage).equals(a.a(this.a))) {
          if (a.b(this.a) >= 0)
          {
            if (a.c(this.a) != null)
            {
              a.c(this.a).setVisibility(0);
              a.c(this.a).a(a.b(this.a));
              if (p.c(a.d(this.a)).length() > 0) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label202;
                }
                a.c(this.a).b(0);
                break;
              }
              label202:
              a.c(this.a).b(8);
            }
          }
          else if (a.c(this.a) != null)
          {
            a.c(this.a).setVisibility(8);
            a.c(this.a).a(0);
            continue;
            a.e(this.a);
            continue;
            if (a.a(paramMessage).equals(a.a(this.a)))
            {
              paramMessage = (List)paramMessage.obj;
              if (a.f(this.a) != null)
              {
                a.f(this.a).a(a.a(this.a), paramMessage);
                continue;
                if (a.a(paramMessage).equals(a.a(this.a))) {
                  a.g(this.a);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */