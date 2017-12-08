package com.linksure.apservice.b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class h
  implements Serializable
{
  public int a = -1;
  public int b = -1;
  public String c;
  public String d;
  private ArrayList<h> e;
  
  public final List<h> a()
  {
    if (this.e == null) {}
    for (Object localObject = Collections.EMPTY_LIST;; localObject = this.e) {
      return (List<h>)localObject;
    }
  }
  
  public final void a(h paramh)
  {
    if (this.e == null) {
      this.e = new ArrayList();
    }
    this.e.add(paramh);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */