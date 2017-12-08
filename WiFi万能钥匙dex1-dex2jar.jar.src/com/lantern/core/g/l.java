package com.lantern.core.g;

import android.os.Handler.Callback;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

final class l
  implements Handler.Callback
{
  l(k paramk) {}
  
  public final boolean handleMessage(Message arg1)
  {
    if (???.what == 1)
    {
      k.b localb = (k.b)???.obj;
      synchronized (k.a(this.a))
      {
        if ((k.a(this.a) != null) && (!k.a(this.a).isEmpty()))
        {
          Iterator localIterator = k.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            k.a locala = (k.a)localIterator.next();
            if (locala != null) {
              locala.a(localb);
            }
          }
        }
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */