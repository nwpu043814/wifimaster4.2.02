package ct;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class r
  implements q
{
  private static r a = null;
  
  public static r a()
  {
    try
    {
      if (a == null)
      {
        localr = new ct/r;
        localr.<init>();
        a = localr;
      }
      r localr = a;
      return localr;
    }
    finally {}
  }
  
  public static void a(an paraman)
  {
    HashMap localHashMap = j.a(paraman);
    localHashMap.put("B64", paraman.A);
    localHashMap.put("B79", paraman.J);
    if (!TextUtils.isEmpty(paraman.G)) {
      localHashMap.put("B73", paraman.A);
    }
    localHashMap.put("B65", paraman.u);
    localHashMap.put("B66", paraman.y);
    localHashMap.put("B75", paraman.v);
    localHashMap.put("B67", paraman.B);
    localHashMap.put("B70", paraman.F);
    localHashMap.put("B72", paraman.C);
    localHashMap.put("B74", paraman.D);
    localHashMap.put("B68", paraman.E);
    localHashMap.put("B80", paraman.K);
    localHashMap.put("B81", paraman.L);
    localHashMap.put("B77", paraman.H);
    localHashMap.put("B82", paraman.M);
    localHashMap.put("B83", paraman.l);
    localHashMap.put("B84", paraman.f);
    bb.b("AccessSchedulerStatistics", "AppAccessFinished：" + paraman.toString());
    try
    {
      if (aq.k() == null) {
        aq.a(p.a());
      }
      at.a("B_ACSDK_SDKExt_Result", localHashMap);
      return;
    }
    catch (OutOfMemoryError paraman)
    {
      for (;;) {}
    }
    catch (Exception paraman)
    {
      for (;;) {}
    }
  }
  
  public final void a(g paramg)
  {
    bb.b("AccessSchedulerStatistics", "AccessSchedulerStatistics...onAccessSchedulerFinished, do sdk report...");
    an localan = new an();
    localan.a = paramg.b;
    localan.b = paramg.c;
    localan.c = paramg.d;
    localan.d = paramg.a;
    localan.e = paramg.e;
    localan.h = paramg.i;
    if (localan.h == 1) {
      localan.g = ba.a();
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localan.i = paramg.j;
      Object localObject = paramg.h;
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label357;
      }
      localStringBuilder = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append((String)((Iterator)localObject).next());
        localStringBuilder.append("|");
      }
      localan.f = ba.a();
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    localan.j = localStringBuilder.toString();
    localan.k = paramg.n;
    if (paramg.o) {}
    for (int i = 1;; i = 0)
    {
      localan.m = i;
      localan.n = paramg.k;
      localan.o = paramg.l;
      localan.p = paramg.m;
      localan.q = paramg.p;
      localan.s = paramg.r;
      localan.r = paramg.q;
      localan.t = paramg.s;
      localan.w = paramg.t;
      localan.z = paramg.f;
      bb.b("AccessSchedulerStatistics", "AccessSchedulerFinished：" + localan.toString());
      new a(localan).start();
      return;
      label357:
      localan.j = "";
      break;
    }
  }
  
  final class a
    extends Thread
  {
    a() {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc2_w 24
      //   3: invokestatic 29	java/lang/Thread:sleep	(J)V
      //   6: aload_0
      //   7: getfield 15	ct/r$a:a	Lct/an;
      //   10: invokestatic 34	ct/j:a	(Lct/an;)Ljava/util/HashMap;
      //   13: astore_1
      //   14: invokestatic 40	ct/aq:k	()Lct/aq;
      //   17: ifnonnull +9 -> 26
      //   20: invokestatic 45	ct/p:a	()Landroid/content/Context;
      //   23: invokestatic 48	ct/aq:a	(Landroid/content/Context;)V
      //   26: ldc 50
      //   28: aload_1
      //   29: invokestatic 55	ct/at:a	(Ljava/lang/String;Ljava/util/HashMap;)V
      //   32: return
      //   33: astore_1
      //   34: aload_1
      //   35: invokevirtual 58	java/lang/InterruptedException:printStackTrace	()V
      //   38: goto -6 -> 32
      //   41: astore_1
      //   42: goto -10 -> 32
      //   45: astore_1
      //   46: goto -14 -> 32
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	49	0	this	a
      //   13	16	1	localHashMap	HashMap
      //   33	2	1	localInterruptedException	InterruptedException
      //   41	1	1	localOutOfMemoryError	OutOfMemoryError
      //   45	1	1	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   0	14	33	java/lang/InterruptedException
      //   14	26	33	java/lang/InterruptedException
      //   26	32	33	java/lang/InterruptedException
      //   14	26	41	java/lang/OutOfMemoryError
      //   26	32	41	java/lang/OutOfMemoryError
      //   14	26	45	java/lang/Exception
      //   26	32	45	java/lang/Exception
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */