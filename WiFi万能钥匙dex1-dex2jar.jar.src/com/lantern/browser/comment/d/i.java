package com.lantern.browser.comment.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
{
  private String a;
  private List<j> b;
  private int c = 0;
  
  public final j a(int paramInt)
  {
    if ((paramInt >= 0) && (!this.b.isEmpty()) && (this.b.size() - 1 >= paramInt)) {}
    for (j localj = (j)this.b.get(paramInt);; localj = null) {
      return localj;
    }
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final void a(List<j> paramList)
  {
    this.b = paramList;
  }
  
  public final List<j> b()
  {
    return this.b;
  }
  
  public final void c()
  {
    this.c = 2;
  }
  
  public final int d()
  {
    return this.c;
  }
  
  public final j e()
  {
    if (this.b != null) {}
    for (j localj = a(this.b.size() - 1);; localj = null) {
      return localj;
    }
  }
  
  public final i f()
  {
    i locali = new i();
    if (this.b != null)
    {
      locali.b = new ArrayList();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        j localj = ((j)localIterator.next()).q();
        localj.c(0);
        locali.b.add(localj);
      }
    }
    locali.c = 0;
    return locali;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */