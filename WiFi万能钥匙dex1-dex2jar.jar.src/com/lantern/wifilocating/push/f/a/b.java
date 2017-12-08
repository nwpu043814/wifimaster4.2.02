package com.lantern.wifilocating.push.f.a;

import com.lantern.wifilocating.push.util.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private List<c> a = new ArrayList();
  private boolean b = true;
  
  public final void a()
  {
    this.b = false;
    if (this.a != null) {
      this.a.clear();
    }
  }
  
  public final void a(a parama)
  {
    if ((this.b) && (!this.a.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(this.a);
      Iterator localIterator = localArrayList.iterator();
      while ((localIterator != null) && (localIterator.hasNext())) {
        try
        {
          ((c)localIterator.next()).onEvent(parama);
        }
        catch (Throwable localThrowable)
        {
          h.a(localThrowable);
        }
      }
      localArrayList.clear();
    }
  }
  
  public final void a(c paramc)
  {
    if ((this.b) && (!this.a.contains(paramc))) {
      this.a.add(paramc);
    }
  }
  
  public final void b(c paramc)
  {
    this.a.remove(paramc);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/f/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */