package com.linksure.apservice.a.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  implements a
{
  private List<b> a = new ArrayList();
  
  public final void a(b paramb)
  {
    this.a.add(paramb);
  }
  
  public final void b(b paramb)
  {
    this.a.remove(paramb);
  }
  
  public final void d(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */