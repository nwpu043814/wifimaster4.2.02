package com.alipay.b.g;

import android.content.Context;
import com.alipay.b.f.d;
import com.alipay.b.f.g;
import com.alipay.b.f.h;
import com.alipay.b.f.i;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static a a;
  private static Object c = new Object();
  private Context b;
  
  private a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {}
    synchronized (c)
    {
      if (a == null)
      {
        a locala = new com/alipay/b/g/a;
        locala.<init>(paramContext);
        a = locala;
      }
      return a;
    }
  }
  
  /* Error */
  public final b a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 9	com/alipay/b/g/a$b
    //   5: astore_1
    //   6: aload_1
    //   7: aload_0
    //   8: invokespecial 37	com/alipay/b/g/a$b:<init>	(Lcom/alipay/b/g/a;)V
    //   11: aload_1
    //   12: aload_0
    //   13: getfield 25	com/alipay/b/g/a:b	Landroid/content/Context;
    //   16: ldc 39
    //   18: invokestatic 44	com/alipay/b/a/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   21: putfield 47	com/alipay/b/g/a$b:a	Ljava/lang/String;
    //   24: aload_1
    //   25: aload_0
    //   26: getfield 25	com/alipay/b/g/a:b	Landroid/content/Context;
    //   29: invokestatic 53	com/alipay/b/f/h:f	(Landroid/content/Context;)Ljava/lang/String;
    //   32: putfield 55	com/alipay/b/g/a$b:b	Ljava/lang/String;
    //   35: aload_1
    //   36: aload_0
    //   37: getfield 25	com/alipay/b/g/a:b	Landroid/content/Context;
    //   40: invokestatic 57	com/alipay/b/a/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   43: putfield 59	com/alipay/b/g/a$b:c	Ljava/lang/String;
    //   46: aload_1
    //   47: invokestatic 64	com/alipay/b/e/a:a	()Ljava/lang/String;
    //   50: putfield 67	com/alipay/b/g/a$b:d	Ljava/lang/String;
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: astore_2
    //   63: goto -10 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	a
    //   5	51	1	localb	b
    //   57	4	1	localObject	Object
    //   62	1	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	11	57	finally
    //   11	53	57	finally
    //   11	53	62	java/lang/Throwable
  }
  
  public final void a(Map paramMap)
  {
    com.alipay.b.b.a.a().c();
    Object localObject = h.c(this.b);
    String str1 = com.alipay.b.b.a.a().d();
    if ((com.alipay.c.a.a.a.a.b((String)localObject)) && (!com.alipay.c.a.a.a.a.a((String)localObject, str1)))
    {
      com.alipay.b.f.a.a(this.b);
      d.a(this.b);
      g.a(this.b);
      i.h();
    }
    if (!com.alipay.c.a.a.a.a.a((String)localObject, str1)) {
      h.c(this.b, str1);
    }
    localObject = com.alipay.c.a.a.a.a.a(paramMap, "utdid", "");
    str1 = com.alipay.c.a.a.a.a.a(paramMap, "tid", "");
    String str2 = com.alipay.c.a.a.a.a.a(paramMap, "userId", "");
    paramMap = (Map)localObject;
    if (com.alipay.c.a.a.a.a.a((String)localObject)) {
      paramMap = "";
    }
    localObject = new HashMap();
    ((Map)localObject).put("utdid", paramMap);
    ((Map)localObject).put("tid", str1);
    ((Map)localObject).put("userId", str2);
    ((Map)localObject).put("appName", "");
    ((Map)localObject).put("appKeyClient", "");
    ((Map)localObject).put("appchannel", "");
    com.alipay.b.h.b.a().a(new b(this, (Map)localObject));
  }
  
  public static abstract interface a {}
  
  public final class b
  {
    public String a;
    public String b;
    public String c;
    public String d;
    
    public b() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */