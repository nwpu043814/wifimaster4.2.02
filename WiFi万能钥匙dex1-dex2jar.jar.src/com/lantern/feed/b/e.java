package com.lantern.feed.b;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public final class e
{
  private a a = new a();
  private List<g> b = new ArrayList();
  private List<g> c = new ArrayList();
  private List<String> d = new ArrayList();
  private a e;
  private SparseArray<i> f = new SparseArray();
  private HashMap<String, g> g = new HashMap();
  private HashMap<Long, g> h = new HashMap();
  private String i;
  private String j;
  
  public final int a()
  {
    return a.a(this.a);
  }
  
  public final g a(long paramLong)
  {
    return (g)this.h.get(Long.valueOf(paramLong));
  }
  
  public final g a(String paramString)
  {
    return (g)this.g.get(paramString);
  }
  
  public final void a(int paramInt)
  {
    a.a(this.a, paramInt);
  }
  
  public final void a(int paramInt, i parami)
  {
    this.f.put(paramInt, parami);
  }
  
  public final void a(long paramLong, g paramg)
  {
    this.h.put(Long.valueOf(paramLong), paramg);
  }
  
  public final void a(a parama)
  {
    this.e = parama;
  }
  
  public final void a(g paramg)
  {
    this.g.put(paramg.a(), paramg);
  }
  
  public final void a(List<g> paramList)
  {
    this.b = paramList;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    a.a(this.a, paramJSONObject);
  }
  
  public final int b()
  {
    return a.b(this.a);
  }
  
  public final g b(long paramLong)
  {
    return (g)this.h.remove(Long.valueOf(paramLong));
  }
  
  public final void b(int paramInt)
  {
    a.b(this.a, paramInt);
  }
  
  public final void b(String paramString)
  {
    this.i = paramString;
  }
  
  public final void b(List<g> paramList)
  {
    this.c.addAll(paramList);
  }
  
  public final i c(int paramInt)
  {
    return (i)this.f.get(paramInt);
  }
  
  public final JSONObject c()
  {
    return a.c(this.a);
  }
  
  public final void c(String paramString)
  {
    this.j = paramString;
  }
  
  public final List<g> d()
  {
    return this.b;
  }
  
  public final void e()
  {
    this.g.clear();
  }
  
  public final void f()
  {
    this.f.clear();
  }
  
  public final a g()
  {
    return this.e;
  }
  
  public final String h()
  {
    return this.i;
  }
  
  public final String i()
  {
    return this.j;
  }
  
  public final List<g> j()
  {
    return this.c;
  }
  
  final class a
  {
    private int b;
    private int c;
    private JSONObject d;
    
    a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */