package com.linksure.apservice.b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements Serializable
{
  public int a;
  public int b;
  public int c;
  public long d;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  private transient List<h> t;
  
  public final List<h> a()
  {
    return this.t;
  }
  
  public final void a(h paramh)
  {
    if (this.t == null) {
      this.t = new ArrayList();
    }
    this.t.add(paramh);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("{id:").append(this.k).append(",name:").append(this.l).append(",tel:").append(this.p).append(",industry:").append(this.q).append(",desc:").append(this.o).append(",company:").append(this.m).append(",principalInfo:").append(this.r).append(",logo:").append(this.n).append(",follow:").append(this.e).append(",black:").append(this.f).append(",violation:").append(this.g).append(",push:").append(this.h).append(",msg:").append(this.i).append(",unread:").append(this.b).append(",latest:").append(this.j).append(",menus:");
    if (this.t == null) {}
    for (int i1 = 0;; i1 = this.t.size())
    {
      localStringBuilder2.append(i1).append("}");
      return localStringBuilder1.toString();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */