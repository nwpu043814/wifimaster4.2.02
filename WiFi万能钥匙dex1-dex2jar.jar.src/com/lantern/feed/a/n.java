package com.lantern.feed.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Message;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.feed.b.g;

final class n
  implements Handler.Callback
{
  n(m paramm) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if ((m.s() == null) && (paramMessage.what != 3)) {
      h.a("mThreadHandler is destroyed " + paramMessage.what, new Object[0]);
    }
    for (;;)
    {
      return false;
      switch (paramMessage.what)
      {
      case 6: 
      case 7: 
      case 12: 
      case 18: 
      case 21: 
      case 25: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 40: 
      default: 
        break;
      case 0: 
        m.b(this.a);
        break;
      case 19: 
        m.a(this.a);
        break;
      case 2: 
        m.c(this.a);
        break;
      case 4: 
        m.d(this.a);
        break;
      case 5: 
        m.e(this.a);
        break;
      case 16: 
        m.f(this.a);
        break;
      case 17: 
        m.g(this.a);
        break;
      case 8: 
        m.a(this.a, (com.lantern.feed.b.n)paramMessage.obj);
        break;
      case 9: 
        m.b(this.a, (com.lantern.feed.b.n)paramMessage.obj);
        break;
      case 10: 
        m.c(this.a, (com.lantern.feed.b.n)paramMessage.obj);
        break;
      case 11: 
        m.d(this.a, (com.lantern.feed.b.n)paramMessage.obj);
        break;
      case 1: 
        paramMessage = (String)paramMessage.obj;
        h.a("saveTabToCacheInner", new Object[0]);
        c.getAppContext().getSharedPreferences("wkfeed", 0).edit().putString("tab", paramMessage).apply();
        break;
      case 28: 
        paramMessage = (String)paramMessage.obj;
        h.a("saveTagToCacheInner", new Object[0]);
        c.getAppContext().getSharedPreferences("wkfeed", 0).edit().putString("tag", paramMessage).apply();
        break;
      case 13: 
        m.h(this.a);
        m.i(this.a);
        break;
      case 3: 
        m.h(this.a);
        m.i(this.a);
        break;
      case 23: 
        m.a(this.a, paramMessage.arg1, (Uri)paramMessage.obj);
        break;
      case 24: 
        m.a(this.a, (String)paramMessage.obj);
        break;
      case 26: 
        m.j(this.a);
        break;
      case 27: 
        m.e(this.a, (com.lantern.feed.b.n)paramMessage.obj);
        break;
      case 29: 
        m.k(this.a);
        break;
      case 30: 
        m.f(this.a, (com.lantern.feed.b.n)paramMessage.obj);
        break;
      case 15: 
        m.l(this.a);
        break;
      case 36: 
        m.a(this.a, (g)paramMessage.obj);
        break;
      case 37: 
        m.a(this.a, ((Long)paramMessage.obj).longValue());
        break;
      case 38: 
        m.b(this.a, ((Long)paramMessage.obj).longValue());
        break;
      case 39: 
        m.c(this.a, ((Long)paramMessage.obj).longValue());
        break;
      case 14: 
        m.g(this.a, (com.lantern.feed.b.n)paramMessage.obj);
        break;
      case 41: 
        m.h(this.a, (com.lantern.feed.b.n)paramMessage.obj);
        break;
      case 20: 
        m.m(this.a);
        break;
      case 22: 
        m.n(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */