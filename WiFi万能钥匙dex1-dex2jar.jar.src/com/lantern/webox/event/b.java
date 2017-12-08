package com.lantern.webox.event;

import com.lantern.webox.b.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class b
{
  protected e a = new e(getClass());
  private Collection<c> b = new CopyOnWriteArrayList();
  
  public final void a(WebEvent paramWebEvent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      try
      {
        localc.onWebEvent(paramWebEvent);
      }
      catch (Exception localException) {}
    }
  }
  
  public final void a(c paramc)
  {
    this.b.add(paramc);
  }
  
  public final void b(c paramc)
  {
    this.b.remove(paramc);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/event/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */