package com.lantern.browser.comment.d;

import java.util.ArrayList;
import java.util.List;

public final class h
{
  private String a;
  private int b;
  private List<i> c = new ArrayList();
  private List<i> d = new ArrayList();
  private List<i> e = new ArrayList();
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final void a(List<i> paramList)
  {
    this.c = paramList;
  }
  
  public final List<i> b()
  {
    return this.c;
  }
  
  public final void b(List<i> paramList)
  {
    this.d = paramList;
  }
  
  public final List<i> c()
  {
    return this.d;
  }
  
  public final void c(List<i> paramList)
  {
    this.e = paramList;
  }
  
  public final List<i> d()
  {
    return this.e;
  }
  
  public final int e()
  {
    int k = 0;
    int i;
    if (this.c != null)
    {
      i = this.c.size();
      if (this.e == null) {
        break label64;
      }
    }
    label64:
    for (int j = this.e.size();; j = 0)
    {
      if (this.d != null) {
        k = this.d.size();
      }
      return i + j + k;
      i = 0;
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */