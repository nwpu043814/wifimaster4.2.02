package com.lantern.wifilocating.push.g.a;

import android.app.NotificationManager;
import android.content.Context;
import android.text.TextUtils;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.util.h;
import com.lantern.wifilocating.push.util.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
{
  private static a a;
  private ConcurrentHashMap<String, JSONObject> b = new ConcurrentHashMap();
  private Object c = new Object();
  private Object d = new Object();
  private AtomicBoolean e = new AtomicBoolean(false);
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a locala = new com/lantern/wifilocating/push/g/a/a;
        locala.<init>();
        a = locala;
      }
      return a;
    }
    finally {}
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.b.remove(paramString) != null)) {
      this.e.set(true);
    }
  }
  
  private void c()
  {
    if (this.e.get()) {
      new b((byte)0).start();
    }
  }
  
  public final void a(Context paramContext)
  {
    for (;;)
    {
      Object localObject4;
      synchronized (this.c)
      {
        if ((this.b == null) || (this.b.isEmpty())) {
          break label342;
        }
        if (paramContext == null) {
          break label346;
        }
        paramContext = (NotificationManager)paramContext.getSystemService("notification");
        Object localObject2 = new java/util/HashMap;
        ((HashMap)localObject2).<init>(this.b);
        if (((Map)localObject2).isEmpty()) {
          break label338;
        }
        localObject2 = ((Map)localObject2).entrySet().iterator();
        boolean bool = ((Iterator)localObject2).hasNext();
        if (!bool) {
          break label338;
        }
        Object localObject3;
        try
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          String str1 = (String)((Map.Entry)localObject3).getKey();
          localObject4 = (JSONObject)((Map.Entry)localObject3).getValue();
          if (localObject4 != null) {
            continue;
          }
          b(str1);
        }
        catch (Exception localException) {}
        continue;
        if (((JSONObject)localObject4).optLong("exp") < System.currentTimeMillis())
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          b(localException);
          if (paramContext == null) {
            continue;
          }
          localObject3 = ((JSONObject)localObject4).optString("sequence");
          String str3 = ((JSONObject)localObject4).optString("sequenceType");
          String str2 = ((JSONObject)localObject4).optString("requestId");
          i = ((JSONObject)localObject4).optInt("status");
          int j = ((JSONObject)localObject4).optInt("syt");
          int k = ((JSONObject)localObject4).optInt("_flag", 0);
          paramContext.cancel(com.lantern.wifilocating.push.util.a.a(str3, (String)localObject3));
          localObject4 = new com/lantern/wifilocating/push/a/b/a;
          ((com.lantern.wifilocating.push.a.b.a)localObject4).<init>();
          ((com.lantern.wifilocating.push.a.b.a)localObject4).a(str3);
          ((com.lantern.wifilocating.push.a.b.a)localObject4).b((String)localObject3);
          ((com.lantern.wifilocating.push.a.b.a)localObject4).c(str2);
          ((com.lantern.wifilocating.push.a.b.a)localObject4).c(i);
          ((com.lantern.wifilocating.push.a.b.a)localObject4).d(4);
          ((com.lantern.wifilocating.push.a.b.a)localObject4).f(j);
          if (k != 1) {
            break label329;
          }
          ((com.lantern.wifilocating.push.a.b.a)localObject4).e(2);
          com.lantern.wifilocating.push.a.a.c().b("012003", ((com.lantern.wifilocating.push.a.b.a)localObject4).a());
        }
      }
      int i = 0;
      continue;
      label329:
      ((com.lantern.wifilocating.push.a.b.a)localObject4).e(1);
      continue;
      label338:
      c();
      label342:
      return;
      label346:
      paramContext = null;
    }
  }
  
  public final void a(String paramString)
  {
    b(paramString);
    c();
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.b.put(paramString, paramJSONObject);
      this.e.set(true);
      c();
    }
  }
  
  public final void b()
  {
    new a((byte)0).start();
  }
  
  private final class a
    extends Thread
  {
    private a() {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 12	com/lantern/wifilocating/push/g/a/a$a:a	Lcom/lantern/wifilocating/push/g/a/a;
      //   4: invokestatic 25	com/lantern/wifilocating/push/g/a/a:a	(Lcom/lantern/wifilocating/push/g/a/a;)Ljava/lang/Object;
      //   7: astore_1
      //   8: aload_1
      //   9: monitorenter
      //   10: invokestatic 30	com/lantern/wifilocating/push/c:a	()Landroid/content/Context;
      //   13: invokestatic 35	com/lantern/wifilocating/push/util/i:a	(Landroid/content/Context;)Ljava/lang/String;
      //   16: astore_3
      //   17: aload_3
      //   18: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   21: ifne +103 -> 124
      //   24: new 43	org/json/JSONObject
      //   27: astore_2
      //   28: aload_2
      //   29: aload_3
      //   30: invokespecial 46	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   33: aload_2
      //   34: invokevirtual 50	org/json/JSONObject:keys	()Ljava/util/Iterator;
      //   37: astore_3
      //   38: aload_3
      //   39: invokeinterface 56 1 0
      //   44: ifeq +80 -> 124
      //   47: aload_3
      //   48: invokeinterface 60 1 0
      //   53: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   56: astore 5
      //   58: aload_2
      //   59: aload 5
      //   61: invokevirtual 70	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   64: astore 4
      //   66: aload 4
      //   68: ldc 72
      //   70: iconst_1
      //   71: invokevirtual 76	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
      //   74: pop
      //   75: aload_0
      //   76: getfield 12	com/lantern/wifilocating/push/g/a/a$a:a	Lcom/lantern/wifilocating/push/g/a/a;
      //   79: invokestatic 80	com/lantern/wifilocating/push/g/a/a:b	(Lcom/lantern/wifilocating/push/g/a/a;)Ljava/util/concurrent/ConcurrentHashMap;
      //   82: aload 5
      //   84: aload 4
      //   86: invokevirtual 85	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   89: pop
      //   90: goto -52 -> 38
      //   93: astore_2
      //   94: aload_2
      //   95: invokestatic 90	com/lantern/wifilocating/push/util/h:a	(Ljava/lang/Throwable;)V
      //   98: aload_0
      //   99: getfield 12	com/lantern/wifilocating/push/g/a/a$a:a	Lcom/lantern/wifilocating/push/g/a/a;
      //   102: invokestatic 80	com/lantern/wifilocating/push/g/a/a:b	(Lcom/lantern/wifilocating/push/g/a/a;)Ljava/util/concurrent/ConcurrentHashMap;
      //   105: invokevirtual 94	java/util/concurrent/ConcurrentHashMap:size	()I
      //   108: ifle +13 -> 121
      //   111: aload_0
      //   112: getfield 12	com/lantern/wifilocating/push/g/a/a$a:a	Lcom/lantern/wifilocating/push/g/a/a;
      //   115: invokestatic 30	com/lantern/wifilocating/push/c:a	()Landroid/content/Context;
      //   118: invokevirtual 97	com/lantern/wifilocating/push/g/a/a:a	(Landroid/content/Context;)V
      //   121: aload_1
      //   122: monitorexit
      //   123: return
      //   124: aload_0
      //   125: getfield 12	com/lantern/wifilocating/push/g/a/a$a:a	Lcom/lantern/wifilocating/push/g/a/a;
      //   128: invokestatic 80	com/lantern/wifilocating/push/g/a/a:b	(Lcom/lantern/wifilocating/push/g/a/a;)Ljava/util/concurrent/ConcurrentHashMap;
      //   131: invokevirtual 94	java/util/concurrent/ConcurrentHashMap:size	()I
      //   134: ifle -13 -> 121
      //   137: aload_0
      //   138: getfield 12	com/lantern/wifilocating/push/g/a/a$a:a	Lcom/lantern/wifilocating/push/g/a/a;
      //   141: invokestatic 30	com/lantern/wifilocating/push/c:a	()Landroid/content/Context;
      //   144: invokevirtual 97	com/lantern/wifilocating/push/g/a/a:a	(Landroid/content/Context;)V
      //   147: goto -26 -> 121
      //   150: astore_2
      //   151: aload_1
      //   152: monitorexit
      //   153: aload_2
      //   154: athrow
      //   155: astore_2
      //   156: aload_0
      //   157: getfield 12	com/lantern/wifilocating/push/g/a/a$a:a	Lcom/lantern/wifilocating/push/g/a/a;
      //   160: invokestatic 80	com/lantern/wifilocating/push/g/a/a:b	(Lcom/lantern/wifilocating/push/g/a/a;)Ljava/util/concurrent/ConcurrentHashMap;
      //   163: invokevirtual 94	java/util/concurrent/ConcurrentHashMap:size	()I
      //   166: ifle +13 -> 179
      //   169: aload_0
      //   170: getfield 12	com/lantern/wifilocating/push/g/a/a$a:a	Lcom/lantern/wifilocating/push/g/a/a;
      //   173: invokestatic 30	com/lantern/wifilocating/push/c:a	()Landroid/content/Context;
      //   176: invokevirtual 97	com/lantern/wifilocating/push/g/a/a:a	(Landroid/content/Context;)V
      //   179: aload_2
      //   180: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	181	0	this	a
      //   7	145	1	localObject1	Object
      //   27	32	2	localJSONObject1	JSONObject
      //   93	2	2	localException	Exception
      //   150	4	2	localObject2	Object
      //   155	25	2	localObject3	Object
      //   16	32	3	localObject4	Object
      //   64	21	4	localJSONObject2	JSONObject
      //   56	27	5	str	String
      // Exception table:
      //   from	to	target	type
      //   10	38	93	java/lang/Exception
      //   38	90	93	java/lang/Exception
      //   98	121	150	finally
      //   121	123	150	finally
      //   124	147	150	finally
      //   151	153	150	finally
      //   156	179	150	finally
      //   179	181	150	finally
      //   10	38	155	finally
      //   38	90	155	finally
      //   94	98	155	finally
    }
  }
  
  private final class b
    extends Thread
  {
    private b() {}
    
    public final void run()
    {
      a.c(a.this).set(false);
      for (;;)
      {
        synchronized (a.a(a.this))
        {
          try
          {
            Object localObject2 = new java/util/HashMap;
            ((HashMap)localObject2).<init>(a.b(a.this));
            if (((Map)localObject2).isEmpty()) {
              break label299;
            }
            Iterator localIterator = ((Map)localObject2).entrySet().iterator();
            localObject2 = new org/json/JSONObject;
            ((JSONObject)localObject2).<init>();
            if (!localIterator.hasNext()) {
              continue;
            }
            Object localObject4 = (Map.Entry)localIterator.next();
            String str1 = (String)((Map.Entry)localObject4).getKey();
            JSONObject localJSONObject = (JSONObject)((Map.Entry)localObject4).getValue();
            if (localJSONObject == null) {
              continue;
            }
            localObject4 = localJSONObject.optString("sequence");
            String str3 = localJSONObject.optString("sequenceType");
            String str2 = localJSONObject.optString("requestId");
            int i = localJSONObject.optInt("status");
            int j = localJSONObject.optInt("syt");
            long l = localJSONObject.optLong("exp");
            try
            {
              localJSONObject = new org/json/JSONObject;
              localJSONObject.<init>();
              localJSONObject.put("sequence", localObject4);
              localJSONObject.put("sequenceType", str3);
              localJSONObject.put("requestId", str2);
              localJSONObject.put("status", i);
              localJSONObject.put("syt", j);
              localJSONObject.put("exp", l);
              ((JSONObject)localObject2).put(str1, localJSONObject);
            }
            catch (Exception localException2)
            {
              h.a(localException2);
            }
            continue;
          }
          catch (Exception localException1)
          {
            h.a(localException1);
          }
          return;
          i.a(c.a(), localException1.toString());
        }
        label299:
        i.a(c.a(), "");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/g/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */