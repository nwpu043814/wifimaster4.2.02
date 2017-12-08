package com.lantern.favorite.flowlayout;

import android.view.View;
import java.util.HashSet;
import java.util.List;

public abstract class a<T>
{
  private List<T> a;
  private a b;
  private HashSet<Integer> c = new HashSet();
  
  public a(List<T> paramList)
  {
    this.a = paramList;
  }
  
  public abstract View a(FlowLayout paramFlowLayout, int paramInt, T paramT);
  
  public final T a(int paramInt)
  {
    return (T)this.a.get(paramInt);
  }
  
  final HashSet<Integer> a()
  {
    return this.c;
  }
  
  final void a(a parama)
  {
    this.b = parama;
  }
  
  public final int b()
  {
    if (this.a == null) {}
    for (int i = 0;; i = this.a.size()) {
      return i;
    }
  }
  
  public final void c()
  {
    this.b.a();
  }
  
  static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/flowlayout/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */