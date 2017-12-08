package com.wifi.connect.e;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.TextSwitcher;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.wifi.connect.model.h.a;
import java.util.ArrayList;
import java.util.HashSet;

final class f
  implements Handler.Callback
{
  f(c paramc) {}
  
  public final boolean handleMessage(Message arg1)
  {
    if ((???.what == 1) && (c.d(this.a))) {
      c.e(this.a).setVisibility(0);
    }
    for (;;)
    {
      synchronized (c.f(this.a))
      {
        c.g(this.a);
        if (c.h(this.a) >= c.i(this.a).size()) {
          c.j(this.a);
        }
        c.a(this.a, (h.a)c.i(this.a).get(c.h(this.a)));
        h.a("current trumpet,title:[%s],url:[%s]", new Object[] { c.b(this.a).b, c.b(this.a).e });
        c.k(this.a).setText(c.b(this.a).b);
        c.m(this.a).sendEmptyMessageDelayed(1, c.l(this.a));
        if (!c.n(this.a).contains(c.b(this.a).a))
        {
          a locala = a.e();
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("barshow_");
          locala.onEvent(c.b(this.a).a);
          c.n(this.a).add(c.b(this.a).a);
        }
        return true;
      }
      if (???.what == 2) {
        c.e(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */