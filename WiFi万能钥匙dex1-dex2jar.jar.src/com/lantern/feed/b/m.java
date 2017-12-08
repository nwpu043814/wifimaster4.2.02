package com.lantern.feed.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.feed.d.c;

public final class m
{
  private int a;
  private int b;
  private String c = "";
  private String d = "";
  private String e;
  private String f;
  private String g = "";
  private String h = "";
  private int i;
  private int j;
  private int k;
  private boolean l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private String r = "";
  private int s;
  private Bitmap t;
  private String u;
  
  public final int a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(Bitmap paramBitmap)
  {
    this.t = paramBitmap;
  }
  
  public final void a(String paramString)
  {
    this.c = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void b(String paramString)
  {
    this.d = paramString;
  }
  
  public final String c()
  {
    return this.c;
  }
  
  public final void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void c(String paramString)
  {
    this.e = paramString;
  }
  
  public final String d()
  {
    return this.d;
  }
  
  public final void d(int paramInt)
  {
    this.j = paramInt;
  }
  
  public final void d(String paramString)
  {
    this.f = paramString;
  }
  
  public final String e()
  {
    return this.e;
  }
  
  public final void e(int paramInt)
  {
    this.k = paramInt;
  }
  
  public final void e(String paramString)
  {
    this.g = paramString;
  }
  
  public final String f()
  {
    return this.f;
  }
  
  public final void f(int paramInt)
  {
    this.m = paramInt;
  }
  
  public final void f(String paramString)
  {
    this.h = paramString;
  }
  
  public final String g()
  {
    return this.g;
  }
  
  public final void g(int paramInt)
  {
    this.n = paramInt;
  }
  
  public final void g(String paramString)
  {
    this.r = paramString;
  }
  
  public final String h()
  {
    return this.h;
  }
  
  public final void h(int paramInt)
  {
    this.o = paramInt;
  }
  
  public final void h(String paramString)
  {
    this.u = paramString;
  }
  
  public final int i()
  {
    return this.i;
  }
  
  public final void i(int paramInt)
  {
    this.p = paramInt;
  }
  
  public final int j()
  {
    return this.j;
  }
  
  public final void j(int paramInt)
  {
    this.q = paramInt;
  }
  
  public final int k()
  {
    return this.k;
  }
  
  public final void k(int paramInt)
  {
    this.s = paramInt;
  }
  
  public final boolean l()
  {
    return this.l;
  }
  
  public final int m()
  {
    return this.m;
  }
  
  public final int n()
  {
    return this.n;
  }
  
  public final int o()
  {
    return this.o;
  }
  
  public final String p()
  {
    return this.r;
  }
  
  public final int q()
  {
    return this.p;
  }
  
  public final int r()
  {
    return this.q;
  }
  
  public final int s()
  {
    return this.s;
  }
  
  public final Bitmap t()
  {
    return this.t;
  }
  
  public final String u()
  {
    return this.u;
  }
  
  public final void v()
  {
    this.q += 1;
    String str = c.b(System.currentTimeMillis());
    if (!str.equals(this.r)) {
      this.r = str;
    }
    for (this.s = 1;; this.s += 1)
    {
      h.a("onShowPopView mLastDate:" + this.r + " mCurCountForDays:" + this.s + " mCurTotalCount:" + this.q, new Object[0]);
      return;
    }
  }
  
  public final boolean w()
  {
    boolean bool = false;
    if (this.a == 0) {}
    for (;;)
    {
      return bool;
      long l1 = System.currentTimeMillis();
      if ((l1 < c.a(this.e)) || (l1 > c.a(this.f)))
      {
        h.a("isShowPopView date wrong", new Object[0]);
      }
      else
      {
        String str = c.b(l1);
        long l2;
        if (!TextUtils.isEmpty(this.g))
        {
          l2 = c.a(str + " " + this.g);
          if ((l2 != 0L) && (l1 < l2))
          {
            h.a("isShowPopView start time wrong", new Object[0]);
            continue;
          }
        }
        if (!TextUtils.isEmpty(this.h))
        {
          l2 = c.a(str + " " + this.h);
          if ((l2 != 0L) && (l1 > l2))
          {
            h.a("isShowPopView end time wrong", new Object[0]);
            continue;
          }
        }
        if (this.q >= this.m)
        {
          h.a("isShowPopView mCurTotalCount wrong", new Object[0]);
        }
        else
        {
          if (str.equals(this.r))
          {
            if (this.s >= this.p) {
              h.a("isShowPopView mCurCountForDays wrong", new Object[0]);
            }
          }
          else if (!TextUtils.isEmpty(this.r))
          {
            h.a("isShowPopView mLastDate:" + this.r, new Object[0]);
            if (l1 < c.a(this.r) * (this.n + 1) * 86400000L)
            {
              h.a("isShowPopView mDays wrong", new Object[0]);
              continue;
            }
          }
          h.a("isShowPopView should show", new Object[0]);
          bool = true;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */