package com.lantern.feed.channel.a;

import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Message;
import com.bluefay.b.h;
import com.lantern.feed.b.g;
import com.lantern.feed.b.n;

final class b
  implements Handler.Callback
{
  b(a parama) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if ((a.g() == null) && (paramMessage.what != 3)) {
      h.a("mThreadHandler is destroyed " + paramMessage.what, new Object[0]);
    }
    for (;;)
    {
      return false;
      switch (paramMessage.what)
      {
      default: 
        break;
      case 3: 
        a.e(this.a);
        break;
      case 19: 
        a.a(this.a);
        break;
      case 5: 
        a.b(this.a);
        break;
      case 16: 
        a.c(this.a);
        break;
      case 17: 
        a.d(this.a);
        break;
      case 9: 
        a.a(this.a, (n)paramMessage.obj);
        break;
      case 10: 
        a.b(this.a, (n)paramMessage.obj);
        break;
      case 11: 
        a.c(this.a, (n)paramMessage.obj);
        break;
      case 23: 
        a.a(this.a, paramMessage.arg1, (Uri)paramMessage.obj);
        break;
      case 24: 
        a.a(this.a, (String)paramMessage.obj);
        break;
      case 36: 
        a.a(this.a, (g)paramMessage.obj);
        break;
      case 37: 
        a.a(this.a, ((Long)paramMessage.obj).longValue());
        break;
      case 38: 
        a.b(this.a, ((Long)paramMessage.obj).longValue());
        break;
      case 39: 
        a.c(this.a, ((Long)paramMessage.obj).longValue());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/channel/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */