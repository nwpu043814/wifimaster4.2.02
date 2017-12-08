package com.lantern.feed.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import java.util.List;

public final class k
{
  private String a;
  private long b;
  private boolean c;
  private int d;
  private int e;
  private long f;
  private String g;
  private String h;
  private Bitmap i;
  private SparseArray<List<b>> j = new SparseArray();
  
  public final List<b> a(int paramInt)
  {
    if (this.j != null) {}
    for (List localList = (List)this.j.get(paramInt);; localList = null) {
      return localList;
    }
  }
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void a(Bitmap paramBitmap)
  {
    this.i = paramBitmap;
  }
  
  public final void a(SparseArray<List<b>> paramSparseArray)
  {
    int k;
    if ((this.j != null) && (this.j.size() > 0)) {
      k = 0;
    }
    while (k < paramSparseArray.size())
    {
      int m = paramSparseArray.keyAt(k);
      List localList2 = (List)paramSparseArray.get(m);
      List localList1 = (List)this.j.get(m);
      if ((localList1 != null) && (localList1.size() > 0)) {
        localList2.addAll(localList1);
      }
      this.j.put(m, localList2);
      k++;
      continue;
      this.j = paramSparseArray;
    }
  }
  
  public final void a(String paramString)
  {
    this.g = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.c;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void b(long paramLong)
  {
    this.f = paramLong;
  }
  
  public final void b(String paramString)
  {
    this.h = paramString;
  }
  
  public final int c()
  {
    return this.e;
  }
  
  public final void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void c(String paramString)
  {
    this.a = paramString;
  }
  
  public final String d()
  {
    return this.g;
  }
  
  public final long e()
  {
    return this.f;
  }
  
  public final String f()
  {
    return this.h;
  }
  
  public final int g()
  {
    return this.d;
  }
  
  public final Bitmap h()
  {
    return this.i;
  }
  
  public final String i()
  {
    return this.a;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */