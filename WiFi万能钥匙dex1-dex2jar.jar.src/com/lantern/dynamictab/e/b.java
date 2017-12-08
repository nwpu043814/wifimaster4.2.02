package com.lantern.dynamictab.e;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import com.lantern.dynamictab.b.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private static b d;
  public e a;
  public long b;
  private Context c;
  private com.lantern.dynamictab.b.a e;
  private int[] f = { 128400, 128700 };
  private long g = 0L;
  private long h = 0L;
  private com.bluefay.d.b i = new c(this, this.f);
  
  private b(Context paramContext)
  {
    this.c = paramContext;
    this.a = new e(paramContext);
    paramContext = new IntentFilter("com.snda.dynamic.friends.thirdpart.msg");
    this.c.registerReceiver(new com.lantern.dynamictab.c.a(), paramContext);
    paramContext = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.c.registerReceiver(new com.lantern.dynamictab.c.b(), paramContext);
    paramContext = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
    paramContext.addDataScheme("package");
    this.c.registerReceiver(new com.lantern.dynamictab.c.c(), paramContext);
    com.lantern.core.c.addListener(this.i);
    this.e = a.b();
    b();
  }
  
  public static b a()
  {
    if (d == null) {
      throw new RuntimeException("FriendsConfigManager has not been initialled");
    }
    return d;
  }
  
  public static void a(Context paramContext)
  {
    if (d != null) {}
    for (;;)
    {
      return;
      d = new b(paramContext);
    }
  }
  
  /* Error */
  public final void a(android.os.Bundle paramBundle, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +27 -> 28
    //   4: aload_1
    //   5: ldc 109
    //   7: invokevirtual 115	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   10: ifeq +18 -> 28
    //   13: aload_1
    //   14: ldc 109
    //   16: invokevirtual 118	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   19: ifeq +9 -> 28
    //   22: ldc 120
    //   24: invokestatic 124	com/lantern/core/h:b	(Ljava/lang/String;)V
    //   27: return
    //   28: aload_0
    //   29: getfield 92	com/lantern/dynamictab/e/b:e	Lcom/lantern/dynamictab/b/a;
    //   32: ifnull -5 -> 27
    //   35: aload_0
    //   36: getfield 92	com/lantern/dynamictab/e/b:e	Lcom/lantern/dynamictab/b/a;
    //   39: getfield 129	com/lantern/dynamictab/b/a:a	Ljava/util/ArrayList;
    //   42: ifnull -15 -> 27
    //   45: aload_0
    //   46: getfield 92	com/lantern/dynamictab/e/b:e	Lcom/lantern/dynamictab/b/a;
    //   49: getfield 132	com/lantern/dynamictab/b/a:c	Ljava/lang/String;
    //   52: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne -28 -> 27
    //   58: aload_0
    //   59: getfield 92	com/lantern/dynamictab/e/b:e	Lcom/lantern/dynamictab/b/a;
    //   62: getfield 129	com/lantern/dynamictab/b/a:a	Ljava/util/ArrayList;
    //   65: invokevirtual 144	java/util/ArrayList:size	()I
    //   68: ifle +310 -> 378
    //   71: iconst_0
    //   72: istore 4
    //   74: iconst_0
    //   75: istore_3
    //   76: iconst_0
    //   77: istore 6
    //   79: iload 4
    //   81: aload_0
    //   82: getfield 92	com/lantern/dynamictab/e/b:e	Lcom/lantern/dynamictab/b/a;
    //   85: getfield 129	com/lantern/dynamictab/b/a:a	Ljava/util/ArrayList;
    //   88: invokevirtual 144	java/util/ArrayList:size	()I
    //   91: if_icmpge +87 -> 178
    //   94: aload_0
    //   95: getfield 92	com/lantern/dynamictab/e/b:e	Lcom/lantern/dynamictab/b/a;
    //   98: getfield 129	com/lantern/dynamictab/b/a:a	Ljava/util/ArrayList;
    //   101: iload 4
    //   103: invokevirtual 148	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   106: checkcast 150	com/lantern/dynamictab/b/a$a
    //   109: astore 8
    //   111: aload 8
    //   113: getfield 152	com/lantern/dynamictab/b/a$a:a	Ljava/lang/String;
    //   116: invokestatic 156	com/lantern/dynamictab/e/f:a	(Ljava/lang/String;)Z
    //   119: istore 7
    //   121: iload_3
    //   122: istore 5
    //   124: iload 7
    //   126: ifeq +19 -> 145
    //   129: iload_3
    //   130: aload_0
    //   131: getfield 48	com/lantern/dynamictab/e/b:a	Lcom/lantern/dynamictab/e/e;
    //   134: aload 8
    //   136: getfield 152	com/lantern/dynamictab/b/a$a:a	Ljava/lang/String;
    //   139: invokevirtual 159	com/lantern/dynamictab/e/e:a	(Ljava/lang/String;)I
    //   142: iadd
    //   143: istore 5
    //   145: iload 6
    //   147: ifeq +12 -> 159
    //   150: iinc 4 1
    //   153: iload 5
    //   155: istore_3
    //   156: goto -77 -> 79
    //   159: aload_0
    //   160: getfield 48	com/lantern/dynamictab/e/b:a	Lcom/lantern/dynamictab/e/e;
    //   163: aload 8
    //   165: getfield 152	com/lantern/dynamictab/b/a$a:a	Ljava/lang/String;
    //   168: iload 7
    //   170: invokevirtual 162	com/lantern/dynamictab/e/e:a	(Ljava/lang/String;Z)Z
    //   173: istore 6
    //   175: goto -25 -> 150
    //   178: iload_3
    //   179: ifgt +8 -> 187
    //   182: iload 6
    //   184: ifeq +39 -> 223
    //   187: ldc -92
    //   189: astore 9
    //   191: iload_3
    //   192: istore 4
    //   194: iload_3
    //   195: ifne +14 -> 209
    //   198: iload_3
    //   199: istore 4
    //   201: iload 6
    //   203: ifeq +6 -> 209
    //   206: iconst_m1
    //   207: istore 4
    //   209: iload_2
    //   210: ifeq +20 -> 230
    //   213: iload 4
    //   215: ldc 120
    //   217: invokestatic 167	com/lantern/core/h:a	(ILjava/lang/String;)V
    //   220: goto -193 -> 27
    //   223: ldc -87
    //   225: astore 9
    //   227: goto -36 -> 191
    //   230: aload_0
    //   231: getfield 92	com/lantern/dynamictab/e/b:e	Lcom/lantern/dynamictab/b/a;
    //   234: getfield 132	com/lantern/dynamictab/b/a:c	Ljava/lang/String;
    //   237: astore 10
    //   239: getstatic 175	com/lantern/dynamictab/R$drawable:launcher_btn_friends	I
    //   242: istore_3
    //   243: aload_0
    //   244: getfield 92	com/lantern/dynamictab/e/b:e	Lcom/lantern/dynamictab/b/a;
    //   247: getfield 177	com/lantern/dynamictab/b/a:b	I
    //   250: istore 5
    //   252: new 179	org/json/JSONObject
    //   255: astore 8
    //   257: aload 8
    //   259: invokespecial 180	org/json/JSONObject:<init>	()V
    //   262: aload 8
    //   264: ldc -74
    //   266: aload 10
    //   268: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   271: pop
    //   272: aload 8
    //   274: ldc -68
    //   276: iload_3
    //   277: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   280: pop
    //   281: aload 8
    //   283: ldc -63
    //   285: iload 5
    //   287: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload 8
    //   293: ldc -61
    //   295: ldc 120
    //   297: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   300: pop
    //   301: aload 8
    //   303: ldc -59
    //   305: ldc -57
    //   307: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   310: pop
    //   311: aload 8
    //   313: ldc -55
    //   315: aload 9
    //   317: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   320: pop
    //   321: invokestatic 207	android/os/Message:obtain	()Landroid/os/Message;
    //   324: astore 9
    //   326: aload 9
    //   328: ldc -48
    //   330: putfield 211	android/os/Message:what	I
    //   333: aload 9
    //   335: aload_1
    //   336: invokevirtual 215	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   339: aload 9
    //   341: aload 8
    //   343: putfield 219	android/os/Message:obj	Ljava/lang/Object;
    //   346: aload 9
    //   348: invokestatic 223	com/lantern/core/c:dispatch	(Landroid/os/Message;)V
    //   351: iload 4
    //   353: ldc 120
    //   355: invokestatic 167	com/lantern/core/h:a	(ILjava/lang/String;)V
    //   358: aload_0
    //   359: invokevirtual 225	com/lantern/dynamictab/e/b:d	()V
    //   362: goto -335 -> 27
    //   365: astore 9
    //   367: aconst_null
    //   368: astore 8
    //   370: aload 9
    //   372: invokevirtual 228	org/json/JSONException:printStackTrace	()V
    //   375: goto -54 -> 321
    //   378: ldc 120
    //   380: invokestatic 124	com/lantern/core/h:b	(Ljava/lang/String;)V
    //   383: goto -356 -> 27
    //   386: astore 9
    //   388: goto -18 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	b
    //   0	391	1	paramBundle	android.os.Bundle
    //   0	391	2	paramBoolean	boolean
    //   75	202	3	j	int
    //   72	280	4	k	int
    //   122	164	5	m	int
    //   77	125	6	bool1	boolean
    //   119	50	7	bool2	boolean
    //   109	260	8	localObject1	Object
    //   189	158	9	localObject2	Object
    //   365	6	9	localJSONException1	org.json.JSONException
    //   386	1	9	localJSONException2	org.json.JSONException
    //   237	30	10	str	String
    // Exception table:
    //   from	to	target	type
    //   252	262	365	org/json/JSONException
    //   262	321	386	org/json/JSONException
  }
  
  public final void a(com.lantern.dynamictab.b.a parama)
  {
    this.e = parama;
  }
  
  public final boolean a(String paramString)
  {
    if ((this.e != null) && (this.e.a != null) && (this.e.a.size() > 0))
    {
      Iterator localIterator = this.e.a.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((a.a)localIterator.next()).a.equals(paramString));
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final String b(String paramString)
  {
    a.a locala;
    if ((this.e != null) && (this.e.a != null) && (this.e.a.size() > 0))
    {
      Iterator localIterator = this.e.a.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locala = (a.a)localIterator.next();
      } while (!locala.a.equals(paramString));
    }
    for (paramString = locala.b;; paramString = null) {
      return paramString;
    }
  }
  
  public final void b()
  {
    long l = System.currentTimeMillis();
    if ((l - this.b > 3600000L) && (l - this.g > 10000L))
    {
      new com.lantern.dynamictab.d.a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      this.g = l;
    }
  }
  
  public final a.a c(String paramString)
  {
    if ((this.e == null) || (this.e.a == null) || (this.e.a.size() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      Iterator localIterator = this.e.a.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          a.a locala = (a.a)localIterator.next();
          if (locala.a.equals(paramString))
          {
            paramString = locala;
            break;
          }
        }
      }
      paramString = null;
    }
  }
  
  public final com.lantern.dynamictab.b.a c()
  {
    return this.e;
  }
  
  public final void d()
  {
    long l = System.currentTimeMillis();
    if (l - this.h > 10000L)
    {
      this.h = l;
      if ((this.e != null) && (this.e.a != null) && (this.e.a.size() > 0))
      {
        Iterator localIterator = this.e.a.iterator();
        while (localIterator.hasNext())
        {
          a.a locala = (a.a)localIterator.next();
          Intent localIntent = new Intent();
          localIntent.setPackage(locala.a);
          localIntent.setAction("com.snda.dynamic.friends.thirdpart.service");
          try
          {
            this.c.startService(localIntent);
          }
          catch (Exception localException) {}
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */