package c.a.a;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  private a a = new a();
  private int b = -1;
  private int c = -1;
  private int d = 1;
  
  private static int a(int paramInt, boolean paramBoolean)
  {
    int i = 4;
    if (paramInt == 1) {
      if (paramBoolean) {
        paramInt = i;
      }
    }
    for (;;)
    {
      return paramInt;
      paramInt = 3;
      continue;
      if (paramInt == 2)
      {
        paramInt = i;
        if (!paramBoolean) {
          paramInt = 3;
        }
      }
      else
      {
        if (paramInt != 3) {
          break;
        }
        paramInt = 1;
      }
    }
    throw new IllegalArgumentException("getCred: invalid section");
  }
  
  /* Error */
  private c a(bg parambg, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 56	c/a/a/i:a	(Lc/a/a/bg;)Ljava/lang/Object;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnonnull +9 -> 18
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: aload_3
    //   21: iload_2
    //   22: iconst_0
    //   23: invokespecial 59	c/a/a/i:a	(Lc/a/a/bg;Ljava/lang/Object;II)Lc/a/a/i$c;
    //   26: astore_1
    //   27: goto -13 -> 14
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	i
    //   0	35	1	parambg	bg
    //   0	35	2	paramInt	int
    //   7	14	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	30	finally
    //   18	27	30	finally
  }
  
  private c a(bg parambg, Object paramObject, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 255) {
      try
      {
        parambg = new java/lang/IllegalArgumentException;
        parambg.<init>("oneElement(ANY)");
        throw parambg;
      }
      finally {}
    }
    int i;
    if ((paramObject instanceof List))
    {
      List localList = (List)paramObject;
      i = 0;
      if (i < localList.size())
      {
        paramObject = (c)localList.get(i);
        int j = ((c)paramObject).b();
        if (j != paramInt1) {}
      }
    }
    for (;;)
    {
      label81:
      if (paramObject == null) {
        paramObject = null;
      }
      for (;;)
      {
        return (c)paramObject;
        i++;
        break;
        paramObject = null;
        break label81;
        paramObject = (c)paramObject;
        if (((c)paramObject).b() != paramInt1) {
          break label158;
        }
        break label81;
        if (((c)paramObject).a())
        {
          b(parambg, paramInt1);
          paramObject = null;
        }
        else
        {
          paramInt1 = ((c)paramObject).a(paramInt2);
          if (paramInt1 < 0) {
            paramObject = null;
          }
        }
      }
      label158:
      paramObject = null;
    }
  }
  
  private Object a(bg parambg)
  {
    try
    {
      parambg = this.a.get(parambg);
      return parambg;
    }
    finally
    {
      parambg = finally;
      throw parambg;
    }
  }
  
  private void a(bg parambg, int paramInt1, cb paramcb, int paramInt2)
  {
    if (paramcb != null) {}
    for (;;)
    {
      try
      {
        long l = paramcb.j();
        c localc = a(parambg, paramInt1);
        if (l == 0L)
        {
          if ((localc != null) && (localc.a(paramInt2) <= 0)) {
            b(parambg, paramInt1);
          }
          return;
        }
        Object localObject = localc;
        if (localc != null)
        {
          localObject = localc;
          if (localc.a(paramInt2) <= 0) {
            localObject = null;
          }
        }
        if (localObject == null)
        {
          localObject = new c/a/a/i$d;
          ((d)localObject).<init>(parambg, paramInt1, paramcb, paramInt2, this.b);
          a(parambg, (c)localObject);
          continue;
          l = 0L;
        }
      }
      finally {}
    }
  }
  
  private void a(bg parambg, c paramc)
  {
    for (;;)
    {
      Object localObject;
      int j;
      try
      {
        localObject = this.a.get(parambg);
        if (localObject == null)
        {
          this.a.put(parambg, paramc);
          return;
        }
        j = paramc.b();
        if (!(localObject instanceof List)) {
          break label118;
        }
        parambg = (List)localObject;
        int i = 0;
        if (i >= parambg.size()) {
          break label107;
        }
        if (((c)parambg.get(i)).b() == j)
        {
          parambg.set(i, paramc);
          continue;
        }
        i++;
      }
      finally {}
      continue;
      label107:
      parambg.add(paramc);
      continue;
      label118:
      c localc = (c)localObject;
      if (localc.b() == j)
      {
        this.a.put(parambg, paramc);
      }
      else
      {
        localObject = new java/util/LinkedList;
        ((LinkedList)localObject).<init>();
        ((LinkedList)localObject).add(localc);
        ((LinkedList)localObject).add(paramc);
        this.a.put(parambg, localObject);
      }
    }
  }
  
  private void a(bq parambq, int paramInt)
  {
    for (;;)
    {
      try
      {
        long l = parambq.d();
        bg localbg = parambq.e().f();
        int i = parambq.e().h();
        c localc2 = a(localbg, i);
        if (l == 0L)
        {
          if ((localc2 != null) && (localc2.a(paramInt) <= 0)) {
            b(localbg, i);
          }
          return;
        }
        c localc1 = localc2;
        if (localc2 != null)
        {
          localc1 = localc2;
          if (localc2.a(paramInt) <= 0) {
            localc1 = null;
          }
        }
        if (localc1 == null) {
          if ((parambq instanceof b))
          {
            parambq = (b)parambq;
            a(localbg, parambq);
          }
          else
          {
            parambq = new b(parambq, paramInt, this.c);
          }
        }
      }
      finally {}
    }
  }
  
  private static void a(bq parambq, Set paramSet)
  {
    if (parambq.e().c() == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = parambq.c();
      while (localIterator.hasNext())
      {
        parambq = ((bt)localIterator.next()).c();
        if (parambq != null) {
          paramSet.add(parambq);
        }
      }
    }
  }
  
  /* Error */
  private c[] a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: instanceof 63
    //   6: ifeq +31 -> 37
    //   9: aload_1
    //   10: checkcast 63	java/util/List
    //   13: astore_1
    //   14: aload_1
    //   15: aload_1
    //   16: invokeinterface 67 1 0
    //   21: anewarray 12	c/a/a/i$c
    //   24: invokeinterface 159 2 0
    //   29: checkcast 161	[Lc/a/a/i$c;
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aload_1
    //   38: checkcast 12	c/a/a/i$c
    //   41: astore_2
    //   42: iconst_1
    //   43: anewarray 12	c/a/a/i$c
    //   46: astore_1
    //   47: aload_1
    //   48: iconst_0
    //   49: aload_2
    //   50: aastore
    //   51: goto -18 -> 33
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	i
    //   0	59	1	paramObject	Object
    //   41	9	2	localc	c
    // Exception table:
    //   from	to	target	type
    //   2	33	54	finally
    //   37	47	54	finally
  }
  
  private cg b(bg parambg, int paramInt1, int paramInt2)
  {
    label348:
    label391:
    label459:
    label465:
    label473:
    for (;;)
    {
      int j;
      int k;
      bg localbg;
      Object localObject2;
      try
      {
        int n = parambg.c();
        j = n;
        if (j <= 0) {
          break label465;
        }
        int i;
        c localc;
        if (j == 1)
        {
          i = 1;
          if (j == n)
          {
            k = 1;
            if (i == 0) {
              continue;
            }
            localbg = bg.a;
            localObject2 = this.a.get(localbg);
            if (localObject2 == null) {
              break label459;
            }
            if ((k == 0) || (paramInt1 != 255)) {
              continue;
            }
            localObject1 = new c/a/a/cg;
            ((cg)localObject1).<init>(6);
            c[] arrayOfc = a(localObject2);
            i = 0;
            int m = 0;
            if (m >= arrayOfc.length) {
              continue;
            }
            localc = arrayOfc[m];
            if (!localc.a()) {
              continue;
            }
            b(localbg, localc.b());
            m++;
            continue;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        k = 0;
        continue;
        if (k != 0)
        {
          localbg = parambg;
          continue;
        }
        localbg = new bg(parambg, n - j);
        continue;
        if ((!(localc instanceof b)) || (localc.a(paramInt2) < 0)) {
          break label473;
        }
        ((cg)localObject1).a((b)localc);
        i++;
        continue;
        if (i <= 0) {
          break label391;
        }
        parambg = (bg)localObject1;
        return parambg;
        if (k == 0) {
          break label348;
        }
        localObject1 = a(localbg, localObject2, paramInt1, paramInt2);
        if ((localObject1 != null) && ((localObject1 instanceof b)))
        {
          parambg = new c/a/a/cg;
          parambg.<init>(6);
          parambg.a((b)localObject1);
          continue;
        }
        if (localObject1 != null)
        {
          parambg = new cg(2);
          continue;
        }
        localObject1 = a(localbg, localObject2, 5, paramInt2);
      }
      finally {}
      if ((localObject1 != null) && ((localObject1 instanceof b)))
      {
        parambg = new cg(4, (b)localObject1);
        continue;
        localObject1 = a(localbg, localObject2, 39, paramInt2);
        if ((localObject1 != null) && ((localObject1 instanceof b)))
        {
          parambg = new cg(5, (b)localObject1);
          continue;
        }
      }
      Object localObject1 = a(localbg, localObject2, 2, paramInt2);
      if ((localObject1 != null) && ((localObject1 instanceof b)))
      {
        parambg = new cg(3, (b)localObject1);
      }
      else if ((k != 0) && (a(localbg, localObject2, 0, paramInt2) != null))
      {
        parambg = cg.a(1);
      }
      else
      {
        j--;
        continue;
        parambg = cg.a(0);
      }
    }
  }
  
  private void b(bg parambg, int paramInt)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = this.a.get(parambg);
        if (localObject == null) {
          return;
        }
        if (!(localObject instanceof List)) {
          break label110;
        }
        localObject = (List)localObject;
        int i = 0;
        if (i >= ((List)localObject).size()) {
          continue;
        }
        if (((c)((List)localObject).get(i)).b() == paramInt)
        {
          ((List)localObject).remove(i);
          if (((List)localObject).size() != 0) {
            continue;
          }
          this.a.remove(parambg);
          continue;
        }
        i++;
      }
      finally {}
      continue;
      label110:
      if (((c)localObject).b() == paramInt) {
        this.a.remove(parambg);
      }
    }
  }
  
  public final cg a(au paramau)
  {
    boolean bool2 = paramau.a().b(5);
    Object localObject1 = paramau.b();
    int m = paramau.a().c();
    int i = 0;
    boolean bool1 = bk.a("verbosecache");
    if (((m != 0) && (m != 3)) || (localObject1 == null))
    {
      paramau = null;
      return paramau;
    }
    Object localObject5 = ((bt)localObject1).f();
    int k = ((bt)localObject1).g();
    int n = ((bt)localObject1).i();
    HashSet localHashSet = new HashSet();
    Object localObject6 = paramau.b(1);
    int j = 0;
    Object localObject2 = localObject5;
    localObject1 = null;
    label248:
    label313:
    label387:
    Object localObject4;
    if (j < localObject6.length) {
      if (localObject6[j].e().i() == n)
      {
        int i2 = localObject6[j].e().h();
        Object localObject3 = localObject6[j].e().f();
        int i1 = a(1, bool2);
        if (((i2 == k) || (k == 255)) && (((bg)localObject3).equals(localObject2)))
        {
          a(localObject6[j], i1);
          i = 1;
          localObject3 = localObject1;
          if (localObject2 == localObject5)
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = new cg(6);
            }
            ((cg)localObject3).a(localObject6[j]);
          }
          a(localObject6[j], localHashSet);
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        for (;;)
        {
          j++;
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          break;
          if ((i2 == 5) && (((bg)localObject3).equals(localObject2)))
          {
            a(localObject6[j], i1);
            if (localObject2 == localObject5)
            {
              localObject1 = new cg(4, localObject6[j]);
              localObject3 = ((h)localObject6[j].e()).x_();
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
          }
          else if ((i2 == 39) && (((bg)localObject2).a((bg)localObject3)))
          {
            a(localObject6[j], i1);
            if (localObject2 == localObject5)
            {
              localObject1 = new cg(5, localObject6[j]);
              localObject3 = (p)localObject6[j].e();
              try
              {
                localObject3 = ((bg)localObject2).a((p)localObject3);
                localObject2 = localObject1;
                localObject1 = localObject3;
              }
              catch (bh localbh)
              {
                localObject4 = localObject1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      bq[] arrayOfbq = paramau.b(2);
      localObject5 = null;
      localObject1 = null;
      j = 0;
      if (j < arrayOfbq.length)
      {
        Object localObject7;
        if ((arrayOfbq[j].e().h() == 6) && (((bg)localObject2).a(arrayOfbq[j].e().f())))
        {
          localObject6 = arrayOfbq[j];
          localObject7 = localObject5;
        }
        for (;;)
        {
          j++;
          localObject5 = localObject7;
          localObject1 = localObject6;
          break;
          localObject7 = localObject5;
          localObject6 = localObject1;
          if (arrayOfbq[j].e().h() == 2)
          {
            localObject7 = localObject5;
            localObject6 = localObject1;
            if (((bg)localObject2).a(arrayOfbq[j].e().f()))
            {
              localObject7 = arrayOfbq[j];
              localObject6 = localObject1;
            }
          }
        }
      }
      if (i == 0) {
        if (m == 3)
        {
          i = 0;
          if ((m != 3) && (localObject1 == null) && (localObject5 != null)) {
            break label741;
          }
          j = a(2, bool2);
          localObject5 = null;
          if (localObject1 != null) {
            localObject5 = (cb)((bq)localObject1).e();
          }
          a((bg)localObject2, i, (cb)localObject5, j);
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            if (m != 3) {
              break label736;
            }
            i = 1;
            label645:
            localObject1 = cg.a(i);
          }
        }
      }
      for (;;)
      {
        paramau = paramau.b(3);
        for (i = 0; i < paramau.length; i++)
        {
          j = paramau[i].e().h();
          if (((j == 1) || (j == 28) || (j == 38)) && (localHashSet.contains(paramau[i].e().f())))
          {
            j = a(3, bool2);
            a(paramau[i], j);
          }
        }
        i = k;
        break;
        label736:
        i = 2;
        break label645;
        label741:
        a((bq)localObject5, a(2, bool2));
        a((bq)localObject5, localHashSet);
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new cg(3, (bq)localObject5);
          continue;
          localObject1 = localObject4;
          if (m == 0)
          {
            localObject1 = localObject4;
            if (localObject5 != null)
            {
              a((bq)localObject5, a(2, bool2));
              a((bq)localObject5, localHashSet);
              localObject1 = localObject4;
            }
          }
        }
      }
      paramau = (au)localObject1;
      if (!bool1) {
        break;
      }
      System.out.println("addMessage: " + localObject1);
      paramau = (au)localObject1;
      break;
      break label387;
      localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      break label248;
      break label313;
      localObject4 = localObject1;
    }
  }
  
  public final cg a(bg parambg, int paramInt1, int paramInt2)
  {
    return b(parambg, paramInt1, paramInt2);
  }
  
  public final void a()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      Iterator localIterator = this.a.values().iterator();
      while (localIterator.hasNext())
      {
        c[] arrayOfc = a(localIterator.next());
        for (int i = 0; i < arrayOfc.length; i++)
        {
          localStringBuffer.append(arrayOfc[i]);
          localStringBuffer.append("\n");
        }
      }
      return localStringBuffer.toString();
    }
    finally {}
  }
  
  private static final class a
    extends LinkedHashMap
  {
    private int a = -1;
    
    a()
    {
      super(0.75F, true);
    }
    
    protected final boolean removeEldestEntry(Map.Entry paramEntry)
    {
      if ((this.a >= 0) && (size() > this.a)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  private static final class b
    extends bq
    implements i.c
  {
    int a;
    int b;
    
    public b(bq parambq, int paramInt, long paramLong)
    {
      super();
      this.a = paramInt;
      this.b = i.a(parambq.d(), paramLong);
    }
    
    public final int a(int paramInt)
    {
      return this.a - paramInt;
    }
    
    public final boolean a()
    {
      if ((int)(System.currentTimeMillis() / 1000L) >= this.b) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(super.toString());
      localStringBuffer.append(" cl = ");
      localStringBuffer.append(this.a);
      return localStringBuffer.toString();
    }
  }
  
  private static abstract interface c
  {
    public abstract int a(int paramInt);
    
    public abstract boolean a();
    
    public abstract int b();
  }
  
  private static final class d
    implements i.c
  {
    int a;
    bg b;
    int c;
    int d;
    
    public d(bg parambg, int paramInt1, cb paramcb, int paramInt2, long paramLong)
    {
      this.b = parambg;
      this.a = paramInt1;
      long l = 0L;
      if (paramcb != null) {
        l = paramcb.e();
      }
      this.c = paramInt2;
      this.d = i.a(l, paramLong);
    }
    
    public final int a(int paramInt)
    {
      return this.c - paramInt;
    }
    
    public final boolean a()
    {
      if ((int)(System.currentTimeMillis() / 1000L) >= this.d) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final int b()
    {
      return this.a;
    }
    
    public final String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (this.a == 0) {
        localStringBuffer.append("NXDOMAIN " + this.b);
      }
      for (;;)
      {
        localStringBuffer.append(" cl = ");
        localStringBuffer.append(this.c);
        return localStringBuffer.toString();
        localStringBuffer.append("NXRRSET " + this.b + " " + ct.b(this.a));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */