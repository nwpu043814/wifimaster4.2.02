package com.analysis.model;

import com.analysis.common.tools.c;
import com.analysis.common.upload.h;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends l
{
  public a f;
  public List<g> g;
  public o h;
  
  private List<g> a()
  {
    return this.g;
  }
  
  private void a(a parama)
  {
    this.f = parama;
  }
  
  private void a(g paramg)
  {
    if (c.a(this.g)) {
      this.g = new ArrayList();
    }
    this.g.add(paramg);
  }
  
  private void a(o paramo)
  {
    this.h = paramo;
  }
  
  private void a(List<g> paramList)
  {
    if (c.a(this.g)) {
      this.g = new ArrayList();
    }
    if (paramList == null) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        this.g.addAll(paramList);
      }
      return;
    }
  }
  
  private o b()
  {
    return this.h;
  }
  
  private a c()
  {
    return this.f;
  }
  
  public final void a(h paramh)
  {
    super.a(paramh);
  }
  
  public final String toString()
  {
    return super.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */