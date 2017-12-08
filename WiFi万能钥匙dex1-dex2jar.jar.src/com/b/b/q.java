package com.b.b;

public class q
{
  private static final j b = ;
  protected volatile u a;
  private e c;
  private j d;
  private volatile e e;
  
  private e a()
  {
    e locale1;
    if (this.e != null) {
      locale1 = this.e;
    }
    for (;;)
    {
      return locale1;
      if (this.c != null) {
        locale1 = this.c;
      } else {
        try
        {
          if (this.e != null) {
            locale1 = this.e;
          }
        }
        finally {}
      }
    }
    if (this.a == null) {}
    for (this.e = e.a;; this.e = this.a.a())
    {
      e locale2 = this.e;
      break;
    }
  }
  
  /* Error */
  public final u a(u paramu)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	com/b/b/q:a	Lcom/b/b/u;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 32	com/b/b/q:a	Lcom/b/b/u;
    //   13: ifnull +10 -> 23
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_0
    //   19: getfield 32	com/b/b/q:a	Lcom/b/b/u;
    //   22: areturn
    //   23: aload_0
    //   24: getfield 30	com/b/b/q:c	Lcom/b/b/e;
    //   27: ifnull +47 -> 74
    //   30: aload_0
    //   31: aload_1
    //   32: invokeinterface 46 1 0
    //   37: aload_0
    //   38: getfield 30	com/b/b/q:c	Lcom/b/b/e;
    //   41: aload_0
    //   42: getfield 48	com/b/b/q:d	Lcom/b/b/j;
    //   45: invokeinterface 53 3 0
    //   50: checkcast 38	com/b/b/u
    //   53: putfield 32	com/b/b/q:a	Lcom/b/b/u;
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 30	com/b/b/q:c	Lcom/b/b/e;
    //   61: putfield 28	com/b/b/q:e	Lcom/b/b/e;
    //   64: aload_0
    //   65: monitorexit
    //   66: goto -48 -> 18
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: aload_0
    //   75: aload_1
    //   76: putfield 32	com/b/b/q:a	Lcom/b/b/u;
    //   79: aload_0
    //   80: getstatic 36	com/b/b/e:a	Lcom/b/b/e;
    //   83: putfield 28	com/b/b/q:e	Lcom/b/b/e;
    //   86: goto -22 -> 64
    //   89: astore_2
    //   90: aload_0
    //   91: aload_1
    //   92: putfield 32	com/b/b/q:a	Lcom/b/b/u;
    //   95: aload_0
    //   96: getstatic 36	com/b/b/e:a	Lcom/b/b/e;
    //   99: putfield 28	com/b/b/q:e	Lcom/b/b/e;
    //   102: goto -38 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	q
    //   0	105	1	paramu	u
    //   89	1	2	localo	o
    // Exception table:
    //   from	to	target	type
    //   9	18	69	finally
    //   23	64	69	finally
    //   64	66	69	finally
    //   70	72	69	finally
    //   74	86	69	finally
    //   90	102	69	finally
    //   23	64	89	com/b/b/o
    //   74	86	89	com/b/b/o
  }
  
  public final int b()
  {
    int i;
    if (this.e != null) {
      i = this.e.b();
    }
    for (;;)
    {
      return i;
      if (this.c != null) {
        i = this.c.b();
      } else if (this.a != null) {
        i = this.a.k();
      } else {
        i = 0;
      }
    }
  }
  
  public final u b(u paramu)
  {
    u localu = this.a;
    this.c = null;
    this.e = null;
    this.a = paramu;
    return localu;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof q))
      {
        bool = false;
      }
      else
      {
        paramObject = (q)paramObject;
        u localu1 = this.a;
        u localu2 = ((q)paramObject).a;
        if ((localu1 == null) && (localu2 == null)) {
          bool = a().equals(((q)paramObject).a());
        } else if ((localu1 != null) && (localu2 != null)) {
          bool = localu1.equals(localu2);
        } else if (localu1 != null) {
          bool = localu1.equals(((q)paramObject).a(localu1.j()));
        } else {
          bool = a(localu2.j()).equals(localu2);
        }
      }
    }
  }
  
  public int hashCode()
  {
    return 1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */