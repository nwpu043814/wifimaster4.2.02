package com.lantern.feed.channel.a;

import android.os.Handler.Callback;
import android.os.Message;
import com.bluefay.b.h;
import com.lantern.feed.b.g;
import com.lantern.feed.b.i;
import java.util.List;

final class c
  implements Handler.Callback
{
  c(a parama) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (a.g() == null) {
      h.a("mUiHandler is destroyed " + paramMessage.what, new Object[0]);
    }
    for (;;)
    {
      return false;
      switch (paramMessage.what)
      {
      default: 
        break;
      case 7: 
        a.a(this.a, paramMessage.arg1, paramMessage.arg2, (i)paramMessage.obj);
        break;
      case 33: 
        a.a(this.a, (List)paramMessage.obj);
        break;
      case 34: 
        a.b(this.a, (List)paramMessage.obj);
        break;
      case 40: 
        a.a(this.a, paramMessage.arg1, (g)paramMessage.obj);
        break;
      case 25: 
        a.b(this.a, (g)paramMessage.obj);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/channel/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */