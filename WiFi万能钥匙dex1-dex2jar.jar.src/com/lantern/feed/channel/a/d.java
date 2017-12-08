package com.lantern.feed.channel.a;

import android.os.Handler.Callback;
import android.os.Message;
import java.util.List;

final class d
  implements Handler.Callback
{
  d(a parama) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = ((String)paramMessage.obj).split(";");
      if (paramMessage.length == 2)
      {
        a.a(this.a, paramMessage[0], paramMessage[1]);
        continue;
        paramMessage = ((String)paramMessage.obj).split(";");
        if (paramMessage.length == 2)
        {
          a.b(this.a, paramMessage[0], paramMessage[1]);
          continue;
          new com.lantern.feed.a.a((String)paramMessage.obj).execute(new String[0]);
          continue;
          a.a(this.a, paramMessage.arg1, paramMessage.arg2, (List)paramMessage.obj);
          continue;
          a.a(this.a, paramMessage.arg1, (List)paramMessage.obj);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/channel/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */