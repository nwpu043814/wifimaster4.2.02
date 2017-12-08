package com.lantern.core.imageloader.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

final class ab
  extends Handler
{
  ab(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int j;
    int i;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      throw new AssertionError("Unknown handler message received: " + paramMessage.what);
    case 8: 
      paramMessage = (List)paramMessage.obj;
      j = paramMessage.size();
      i = 0;
    case 3: 
      while (i < j)
      {
        localObject = (c)paramMessage.get(i);
        ((c)localObject).b.a((c)localObject);
        i++;
        continue;
        paramMessage = (a)paramMessage.obj;
        if (paramMessage.a.l) {
          at.a("Main", "canceled", paramMessage.b.a(), "target got garbage collected");
        }
        aa.a(paramMessage.a, paramMessage.c());
      }
    }
    for (;;)
    {
      return;
      paramMessage = (List)paramMessage.obj;
      j = paramMessage.size();
      for (i = 0; i < j; i++)
      {
        localObject = (a)paramMessage.get(i);
        ((a)localObject).a.b((a)localObject);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */