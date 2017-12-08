package com.lantern.browser.comment.d;

import android.content.Context;
import com.lantern.browser.R.string;
import com.lantern.core.c;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  private Object a = new Object();
  private List<i> b;
  private List<i> c;
  private List<i> d;
  private b e;
  private c f;
  private c g;
  private c h;
  private a i;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = 0;
  private boolean n = false;
  private boolean o = false;
  private List<Object> p;
  private boolean q = true;
  private int r = 0;
  private int s = 0;
  
  private void c(List<i> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (i)paramList.get(paramList.size() - 1);
      if (paramList == null) {
        break label77;
      }
      if (paramList == null) {
        break label72;
      }
      paramList = paramList.e();
      label44:
      if ((paramList != null) && (paramList.m() <= 1)) {
        break label77;
      }
    }
    label72:
    label77:
    for (this.r = 0;; this.r = 2)
    {
      return;
      this.r = 2;
      paramList = null;
      break;
      paramList = null;
      break label44;
    }
  }
  
  public final int a()
  {
    synchronized (this.a)
    {
      if (this.p != null)
      {
        i1 = this.p.size();
        return i1;
      }
      int i1 = 0;
    }
  }
  
  public final int a(int paramInt)
  {
    int i1 = 0;
    for (;;)
    {
      synchronized (this.a)
      {
        if ((this.p == null) || (this.p.size() <= paramInt)) {
          break label107;
        }
        Object localObject2 = this.p.get(paramInt);
        if ((localObject2 instanceof b))
        {
          paramInt = i1;
          return paramInt;
        }
        if ((localObject2 instanceof c)) {
          paramInt = 2;
        }
      }
      if ((localObject3 instanceof i)) {
        paramInt = 1;
      } else if ((localObject3 instanceof a)) {
        paramInt = 3;
      } else {
        label107:
        paramInt = i1;
      }
    }
  }
  
  public final void a(h paramh)
  {
    localObject = this.a;
    if (paramh == null) {}
    for (;;)
    {
      try
      {
        this.p = null;
        return;
      }
      finally {}
      this.b = paramh.b();
      this.c = paramh.d();
      this.d = paramh.c();
      c(this.d);
      this.q = false;
    }
  }
  
  /* Error */
  public final void a(i parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/lantern/browser/comment/d/g:a	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_2
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 108	com/lantern/browser/comment/d/g:d	Ljava/util/List;
    //   18: ifnull +41 -> 59
    //   21: aload_0
    //   22: getfield 108	com/lantern/browser/comment/d/g:d	Ljava/util/List;
    //   25: invokeinterface 70 1 0
    //   30: ifne +29 -> 59
    //   33: aload_0
    //   34: getfield 108	com/lantern/browser/comment/d/g:d	Ljava/util/List;
    //   37: iconst_0
    //   38: aload_1
    //   39: invokeinterface 115 3 0
    //   44: aload_0
    //   45: iconst_0
    //   46: putfield 58	com/lantern/browser/comment/d/g:q	Z
    //   49: aload_2
    //   50: monitorexit
    //   51: goto -38 -> 13
    //   54: astore_1
    //   55: aload_2
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    //   59: new 117	java/util/ArrayList
    //   62: astore_3
    //   63: aload_3
    //   64: invokespecial 118	java/util/ArrayList:<init>	()V
    //   67: aload_0
    //   68: aload_3
    //   69: putfield 108	com/lantern/browser/comment/d/g:d	Ljava/util/List;
    //   72: aload_0
    //   73: getfield 108	com/lantern/browser/comment/d/g:d	Ljava/util/List;
    //   76: aload_1
    //   77: invokeinterface 121 2 0
    //   82: pop
    //   83: goto -39 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	g
    //   0	86	1	parami	i
    //   4	52	2	localObject	Object
    //   62	7	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   11	13	54	finally
    //   14	44	54	finally
    //   44	51	54	finally
    //   55	57	54	finally
    //   59	83	54	finally
  }
  
  /* Error */
  public final void a(List<i> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/lantern/browser/comment/d/g:a	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_2
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: putfield 100	com/lantern/browser/comment/d/g:b	Ljava/util/List;
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 58	com/lantern/browser/comment/d/g:q	Z
    //   24: aload_2
    //   25: monitorexit
    //   26: goto -13 -> 13
    //   29: astore_1
    //   30: aload_2
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	g
    //   0	34	1	paramList	List<i>
    //   4	27	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	13	29	finally
    //   14	26	29	finally
    //   30	32	29	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public final Object b(int paramInt)
  {
    synchronized (this.a)
    {
      if (this.p != null)
      {
        localObject1 = this.p.get(paramInt);
        return localObject1;
      }
      Object localObject1 = null;
    }
  }
  
  public final void b()
  {
    if (!this.q)
    {
      this.q = true;
      c localc = c.getInstance();
      if (this.p != null) {
        break label410;
      }
      this.p = new ArrayList();
      if ((this.o) && (this.m > 0))
      {
        if (this.e == null) {
          this.e = new b(this.m);
        }
        this.e.a(this.s);
        this.p.add(this.e);
      }
      if (this.n)
      {
        if ((this.b == null) || (this.b.isEmpty())) {
          break label422;
        }
        if (this.f == null) {
          this.f = new c(0, localc.getString(R.string.comment_replyme));
        }
        this.p.add(this.f);
        this.j = (this.p.size() - 1);
        this.p.addAll(this.b);
      }
      label190:
      if ((this.c == null) || (this.c.isEmpty())) {
        break label430;
      }
      if (this.g == null) {
        this.g = new c(2, localc.getString(R.string.comment_hot));
      }
      this.p.add(this.g);
      this.k = (this.p.size() - 1);
      this.p.addAll(this.c);
      label278:
      if ((this.d == null) || (this.d.isEmpty())) {
        break label438;
      }
      if (this.h == null) {
        this.h = new c(1, localc.getString(R.string.comment_new));
      }
      this.p.add(this.h);
      this.l = (this.p.size() - 1);
      this.p.addAll(this.d);
      if (this.i == null) {
        this.i = new a();
      }
      this.i.a(this.r);
      this.p.add(this.i);
    }
    for (;;)
    {
      return;
      label410:
      this.p.clear();
      break;
      label422:
      this.j = -1;
      break label190;
      label430:
      this.k = -1;
      break label278;
      label438:
      this.l = -1;
    }
  }
  
  /* Error */
  public final void b(List<i> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/lantern/browser/comment/d/g:a	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_2
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 108	com/lantern/browser/comment/d/g:d	Ljava/util/List;
    //   18: ifnull +46 -> 64
    //   21: aload_0
    //   22: getfield 108	com/lantern/browser/comment/d/g:d	Ljava/util/List;
    //   25: invokeinterface 70 1 0
    //   30: ifne +34 -> 64
    //   33: aload_0
    //   34: aload_1
    //   35: invokespecial 110	com/lantern/browser/comment/d/g:c	(Ljava/util/List;)V
    //   38: aload_0
    //   39: getfield 108	com/lantern/browser/comment/d/g:d	Ljava/util/List;
    //   42: aload_1
    //   43: invokeinterface 155 2 0
    //   48: pop
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 58	com/lantern/browser/comment/d/g:q	Z
    //   54: aload_2
    //   55: monitorexit
    //   56: goto -43 -> 13
    //   59: astore_1
    //   60: aload_2
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: aload_0
    //   65: aload_1
    //   66: putfield 108	com/lantern/browser/comment/d/g:d	Ljava/util/List;
    //   69: goto -20 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	g
    //   0	72	1	paramList	List<i>
    //   4	57	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	13	59	finally
    //   14	49	59	finally
    //   49	56	59	finally
    //   60	62	59	finally
    //   64	69	59	finally
  }
  
  public final void b(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public final List<i> c()
  {
    return this.d;
  }
  
  public final boolean c(int paramInt)
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.a)
      {
        if (this.i == null)
        {
          this.r = paramInt;
          this.q = false;
          return bool;
        }
        if (paramInt != this.i.a())
        {
          this.r = paramInt;
          this.i.a(this.r);
        }
      }
    }
  }
  
  public final int d()
  {
    return this.j;
  }
  
  public final boolean d(int paramInt)
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.a)
      {
        if (this.e == null)
        {
          this.s = paramInt;
          this.q = false;
          return bool;
        }
        if (paramInt != this.e.a())
        {
          this.s = paramInt;
          this.e.a(paramInt);
        }
      }
    }
  }
  
  public final int e()
  {
    return this.l;
  }
  
  public final void e(int paramInt)
  {
    this.m = paramInt;
  }
  
  public final int f()
  {
    return this.k;
  }
  
  public final int g()
  {
    return this.m;
  }
  
  public static final class a
  {
    private int a;
    
    public final int a()
    {
      return this.a;
    }
    
    public final void a(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  public static final class b
  {
    private int a;
    private int b;
    
    public b(int paramInt)
    {
      this.b = paramInt;
    }
    
    public final int a()
    {
      return this.a;
    }
    
    public final void a(int paramInt)
    {
      this.a = paramInt;
    }
    
    public final int b()
    {
      return this.b;
    }
  }
  
  public static final class c
  {
    private int a;
    private String b;
    
    public c(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = paramString;
    }
    
    public final String a()
    {
      return this.b;
    }
    
    public final int b()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */