package com.lantern.feed.a;

import android.os.Handler.Callback;
import android.os.Message;
import com.bluefay.b.h;
import com.lantern.feed.b.a;
import com.lantern.feed.b.g;
import com.lantern.feed.b.i;
import java.util.List;

final class r
  implements Handler.Callback
{
  r(m paramm) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (m.s() == null) {
      h.a("mUiHandler is destroyed " + paramMessage.what, new Object[0]);
    }
    for (;;)
    {
      return false;
      switch (paramMessage.what)
      {
      default: 
        break;
      case 6: 
        m.a(this.a, (a)paramMessage.obj);
        break;
      case 7: 
        m.a(this.a, paramMessage.arg1, paramMessage.arg2, (i)paramMessage.obj);
        break;
      case 33: 
        m.a(this.a, (List)paramMessage.obj);
        break;
      case 34: 
        m.b(this.a, (List)paramMessage.obj);
        break;
      case 35: 
        m.a(this.a, (com.lantern.feed.b.m)paramMessage.obj);
        break;
      case 40: 
        m.a(this.a, paramMessage.arg1, (g)paramMessage.obj);
        break;
      case 42: 
        m.o(this.a);
        break;
      case 25: 
        m.b(this.a, (g)paramMessage.obj);
        break;
      case 21: 
        m.p(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */