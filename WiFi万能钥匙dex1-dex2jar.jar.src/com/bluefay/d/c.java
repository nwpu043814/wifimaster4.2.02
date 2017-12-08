package com.bluefay.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bluefay.b.h;
import java.util.HashSet;
import java.util.Iterator;

public final class c
{
  private HashSet<b> a = new HashSet();
  private a b;
  
  public c()
  {
    HandlerThread localHandlerThread = new HandlerThread("MsgObseverThread");
    localHandlerThread.start();
    this.b = new a(localHandlerThread.getLooper());
  }
  
  public final void a(Message paramMessage)
  {
    int i = paramMessage.what;
    try
    {
      paramMessage = this.a.iterator();
      while (paramMessage.hasNext()) {
        ((b)paramMessage.next()).a(i);
      }
    }
    finally {}
  }
  
  public final void a(Message paramMessage, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.copyFrom(paramMessage);
    this.b.sendMessageDelayed(localMessage, paramLong);
  }
  
  public final void a(b paramb)
  {
    if (paramb != null) {}
    try
    {
      this.a.add(paramb);
      h.b("size:%d", new Object[] { Integer.valueOf(this.a.size()) });
      return;
    }
    finally {}
  }
  
  public final void b(Message paramMessage, long paramLong)
  {
    int i = paramMessage.what;
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.a(i))
        {
          Message localMessage = Message.obtain();
          localMessage.copyFrom(paramMessage);
          localb.sendMessageDelayed(localMessage, paramLong);
        }
      }
    }
    finally {}
  }
  
  public final void b(b paramb)
  {
    if (paramb != null) {}
    try
    {
      this.a.remove(paramb);
      h.b("size:%d", new Object[] { Integer.valueOf(this.a.size()) });
      return;
    }
    finally {}
  }
  
  private final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      a.getObsever().a(paramMessage);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */