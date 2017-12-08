package com.analysis.common.upload;

import com.analysis.common.b;
import com.analysis.common.tools.c;
import com.analysis.model.a;
import com.analysis.model.d;
import com.analysis.model.g;
import com.analysis.model.l;
import com.analysis.model.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
  implements Serializable
{
  public a a;
  public List<l> b;
  public List<g> c;
  public List<d> d;
  public List<o> e;
  
  private void a(a parama)
  {
    this.a = parama;
  }
  
  private void a(d paramd)
  {
    if (c.a(this.d)) {
      this.d = new ArrayList();
    }
    this.d.add(paramd);
  }
  
  private void a(g paramg)
  {
    if (c.a(this.c)) {
      this.c = new ArrayList();
    }
    this.c.add(paramg);
  }
  
  private void a(l paraml)
  {
    if (c.a(this.b)) {
      this.b = new ArrayList();
    }
    this.b.add(paraml);
  }
  
  private void a(o paramo)
  {
    if (c.a(this.e)) {
      this.e = new ArrayList();
    }
    this.e.add(paramo);
  }
  
  private void a(List<g> paramList)
  {
    if (c.a(this.c)) {
      this.c = new ArrayList();
    }
    this.c.addAll(paramList);
  }
  
  private void b(List<d> paramList)
  {
    if (c.a(this.d)) {
      this.d = new ArrayList();
    }
    this.d.addAll(paramList);
  }
  
  private void c(List<o> paramList)
  {
    if (c.a(this.e)) {
      this.e = new ArrayList();
    }
    this.e.addAll(paramList);
  }
  
  public final String toString()
  {
    b localb = new b();
    if (this.a == null)
    {
      i = 0;
      if (i != 0)
      {
        localb.a("appInfo:");
        localb.a(this.a + "\n");
      }
      if (this.b != null) {
        break label150;
      }
    }
    Object localObject1;
    Object localObject2;
    label150:
    for (int i = 0;; i = 1)
    {
      if ((i == 0) || (this.b.size() <= 0)) {
        break label155;
      }
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (l)((Iterator)localObject1).next();
        localb.a("session:");
        localb.a(localObject2 + "\n");
      }
      i = 1;
      break;
    }
    label155:
    if (this.c == null) {}
    for (i = 0; (i != 0) && (this.c.size() > 0); i = 1)
    {
      localObject2 = this.c.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (g)((Iterator)localObject2).next();
        localb.a("page:");
        localb.a(localObject1 + "\n");
      }
    }
    if (this.d == null) {}
    for (i = 0; (i != 0) && (this.d.size() > 0); i = 1)
    {
      localObject2 = this.d.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (d)((Iterator)localObject2).next();
        localb.a("event:");
        localb.a(localObject1 + "\n");
      }
    }
    if (this.e == null) {}
    for (i = 0; (i != 0) && (this.e.size() > 0); i = 1)
    {
      localObject1 = this.e.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (o)((Iterator)localObject1).next();
        localb.a("traffic:");
        localb.a(localObject2 + "\n");
      }
    }
    return localb.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */