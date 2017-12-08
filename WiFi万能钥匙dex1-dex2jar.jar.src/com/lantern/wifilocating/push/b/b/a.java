package com.lantern.wifilocating.push.b.b;

import android.content.Context;
import android.os.PowerManager.WakeLock;
import com.lantern.wifilocating.push.f.a.a.a;
import com.lantern.wifilocating.push.f.f;
import com.lantern.wifilocating.push.util.h;
import com.lantern.wifilocating.push.util.j;
import org.json.JSONObject;

public class a
  extends d
  implements com.lantern.wifilocating.push.f.a.c
{
  protected PowerManager.WakeLock a;
  protected Object b = new Object();
  protected boolean c = false;
  private Object d = new Object();
  private int e = 0;
  private Runnable f = new b(this);
  private Runnable g = new c(this);
  
  public a(e parame)
  {
    super(parame);
    f.a(this);
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean)
  {
    try
    {
      f.a().b().removeCallbacks(paramRunnable);
      if (paramBoolean) {
        d();
      }
      return;
    }
    catch (Exception paramRunnable)
    {
      for (;;) {}
    }
  }
  
  public int a()
  {
    int i = 15000;
    Object localObject = com.lantern.wifilocating.push.c.a();
    if (localObject != null)
    {
      localObject = j.a((Context)localObject);
      if (localObject != null) {
        if (!((String)localObject).equals("WIFI")) {}
      }
    }
    for (;;)
    {
      return i;
      if (!((String)localObject).equals("4G")) {
        if (((String)localObject).equals("3G")) {
          i = 30000;
        } else if (((String)localObject).equals("2G")) {
          i = 60000;
        } else {
          i = 45000;
        }
      }
    }
  }
  
  /* Error */
  protected void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 29	com/lantern/wifilocating/push/b/b/a:b	Ljava/lang/Object;
    //   9: astore 5
    //   11: aload 5
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 31	com/lantern/wifilocating/push/b/b/a:c	Z
    //   18: iconst_1
    //   19: if_icmpne +15 -> 34
    //   22: aload 5
    //   24: monitorexit
    //   25: goto -21 -> 4
    //   28: astore_1
    //   29: aload 5
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    //   34: aload_0
    //   35: iconst_1
    //   36: putfield 31	com/lantern/wifilocating/push/b/b/a:c	Z
    //   39: aload_0
    //   40: invokevirtual 102	com/lantern/wifilocating/push/b/b/a:a	()I
    //   43: i2l
    //   44: lstore_3
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 42	com/lantern/wifilocating/push/b/b/a:f	Ljava/lang/Runnable;
    //   50: iconst_0
    //   51: invokespecial 104	com/lantern/wifilocating/push/b/b/a:a	(Ljava/lang/Runnable;Z)V
    //   54: aload_0
    //   55: getfield 42	com/lantern/wifilocating/push/b/b/a:f	Ljava/lang/Runnable;
    //   58: astore 6
    //   60: invokestatic 59	com/lantern/wifilocating/push/f/f:a	()Lcom/lantern/wifilocating/push/f/f;
    //   63: invokevirtual 62	com/lantern/wifilocating/push/f/f:b	()Lcom/lantern/wifilocating/push/f/c;
    //   66: aload 6
    //   68: aload_0
    //   69: invokevirtual 102	com/lantern/wifilocating/push/b/b/a:a	()I
    //   72: i2l
    //   73: invokevirtual 108	com/lantern/wifilocating/push/f/c:postDelayed	(Ljava/lang/Runnable;J)Z
    //   76: ifeq +117 -> 193
    //   79: lload_3
    //   80: lconst_0
    //   81: lcmp
    //   82: ifle +111 -> 193
    //   85: aload_0
    //   86: getfield 33	com/lantern/wifilocating/push/b/b/a:d	Ljava/lang/Object;
    //   89: astore 6
    //   91: aload 6
    //   93: monitorenter
    //   94: aload_0
    //   95: getfield 110	com/lantern/wifilocating/push/b/b/a:a	Landroid/os/PowerManager$WakeLock;
    //   98: ifnonnull +53 -> 151
    //   101: invokestatic 76	com/lantern/wifilocating/push/c:a	()Landroid/content/Context;
    //   104: ldc 112
    //   106: invokevirtual 118	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   109: checkcast 120	android/os/PowerManager
    //   112: astore 8
    //   114: new 122	java/lang/StringBuilder
    //   117: astore 7
    //   119: aload 7
    //   121: ldc 124
    //   123: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: aload_0
    //   127: aload 8
    //   129: iconst_1
    //   130: aload 7
    //   132: aload_0
    //   133: invokevirtual 131	java/lang/Object:getClass	()Ljava/lang/Class;
    //   136: invokevirtual 137	java/lang/Class:getName	()Ljava/lang/String;
    //   139: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokevirtual 148	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   148: putfield 110	com/lantern/wifilocating/push/b/b/a:a	Landroid/os/PowerManager$WakeLock;
    //   151: aload_0
    //   152: getfield 110	com/lantern/wifilocating/push/b/b/a:a	Landroid/os/PowerManager$WakeLock;
    //   155: ifnull +35 -> 190
    //   158: aload_0
    //   159: getfield 110	com/lantern/wifilocating/push/b/b/a:a	Landroid/os/PowerManager$WakeLock;
    //   162: invokevirtual 153	android/os/PowerManager$WakeLock:acquire	()V
    //   165: aload_0
    //   166: aload_0
    //   167: getfield 35	com/lantern/wifilocating/push/b/b/a:e	I
    //   170: iconst_1
    //   171: iadd
    //   172: putfield 35	com/lantern/wifilocating/push/b/b/a:e	I
    //   175: invokestatic 59	com/lantern/wifilocating/push/f/f:a	()Lcom/lantern/wifilocating/push/f/f;
    //   178: invokevirtual 62	com/lantern/wifilocating/push/f/f:b	()Lcom/lantern/wifilocating/push/f/c;
    //   181: aload_0
    //   182: getfield 47	com/lantern/wifilocating/push/b/b/a:g	Ljava/lang/Runnable;
    //   185: lload_3
    //   186: invokevirtual 108	com/lantern/wifilocating/push/f/c:postDelayed	(Ljava/lang/Runnable;J)Z
    //   189: pop
    //   190: aload 6
    //   192: monitorexit
    //   193: invokestatic 158	com/lantern/wifilocating/push/b/a/b:a	()Lcom/lantern/wifilocating/push/b/a/b;
    //   196: invokevirtual 161	com/lantern/wifilocating/push/b/a/b:b	()Lcom/lantern/wifilocating/push/b/c/a;
    //   199: aload_1
    //   200: invokevirtual 165	com/lantern/wifilocating/push/b/c/a:a	(Lorg/json/JSONObject;)V
    //   203: aload 5
    //   205: monitorexit
    //   206: goto -202 -> 4
    //   209: astore_1
    //   210: aload 6
    //   212: monitorexit
    //   213: aload_1
    //   214: athrow
    //   215: astore_1
    //   216: aload_1
    //   217: invokestatic 170	com/lantern/wifilocating/push/util/h:a	(Ljava/lang/Throwable;)V
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 42	com/lantern/wifilocating/push/b/b/a:f	Ljava/lang/Runnable;
    //   225: iconst_1
    //   226: invokespecial 104	com/lantern/wifilocating/push/b/b/a:a	(Ljava/lang/Runnable;Z)V
    //   229: new 172	com/lantern/wifilocating/push/f/a/a
    //   232: astore 6
    //   234: getstatic 176	com/lantern/wifilocating/push/f/a/a$a:f	I
    //   237: istore_2
    //   238: new 178	com/lantern/wifilocating/push/b/b/p
    //   241: astore_1
    //   242: aload_1
    //   243: aload_0
    //   244: invokevirtual 181	com/lantern/wifilocating/push/b/b/a:e	()Lcom/lantern/wifilocating/push/b/b/e;
    //   247: aconst_null
    //   248: invokespecial 184	com/lantern/wifilocating/push/b/b/p:<init>	(Lcom/lantern/wifilocating/push/b/b/e;Ljava/lang/Object;)V
    //   251: aload 6
    //   253: iload_2
    //   254: aload_1
    //   255: invokespecial 187	com/lantern/wifilocating/push/f/a/a:<init>	(ILjava/lang/Object;)V
    //   258: aload 6
    //   260: invokestatic 190	com/lantern/wifilocating/push/f/f:a	(Lcom/lantern/wifilocating/push/f/a/a;)V
    //   263: goto -60 -> 203
    //   266: astore 7
    //   268: goto -78 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	a
    //   0	271	1	paramJSONObject	JSONObject
    //   237	17	2	i	int
    //   44	142	3	l	long
    //   9	195	5	localObject1	Object
    //   117	14	7	localStringBuilder	StringBuilder
    //   266	1	7	localThrowable	Throwable
    //   112	16	8	localPowerManager	android.os.PowerManager
    // Exception table:
    //   from	to	target	type
    //   14	25	28	finally
    //   29	32	28	finally
    //   34	39	28	finally
    //   39	79	28	finally
    //   85	94	28	finally
    //   193	203	28	finally
    //   203	206	28	finally
    //   213	215	28	finally
    //   216	263	28	finally
    //   94	151	209	finally
    //   151	190	209	finally
    //   190	193	209	finally
    //   210	213	209	finally
    //   39	79	215	java/lang/Throwable
    //   85	94	215	java/lang/Throwable
    //   193	203	215	java/lang/Throwable
    //   213	215	215	java/lang/Throwable
    //   94	151	266	java/lang/Throwable
    //   151	190	266	java/lang/Throwable
  }
  
  public void b()
  {
    a(o.a(e()));
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    synchronized (this.b)
    {
      try
      {
        a(this.f, true);
        if (this.c)
        {
          this.c = false;
          com.lantern.wifilocating.push.f.a.a locala = new com/lantern/wifilocating/push/f/a/a;
          int i = a.a.e;
          p localp = new com/lantern/wifilocating/push/b/b/p;
          localp.<init>(e(), paramJSONObject);
          locala.<init>(i, localp);
          f.a(locala);
        }
        return;
      }
      catch (Throwable paramJSONObject)
      {
        for (;;)
        {
          h.a(paramJSONObject);
        }
      }
    }
  }
  
  public final void c()
  {
    synchronized (this.b)
    {
      try
      {
        this.c = false;
        a(this.f, true);
        com.lantern.wifilocating.push.f.a.a locala = new com/lantern/wifilocating/push/f/a/a;
        int i = a.a.f;
        p localp = new com/lantern/wifilocating/push/b/b/p;
        localp.<init>(e(), null);
        locala.<init>(i, localp);
        f.a(locala);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          h.a(localThrowable);
        }
      }
    }
  }
  
  /* Error */
  final void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/lantern/wifilocating/push/b/b/a:d	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 110	com/lantern/wifilocating/push/b/b/a:a	Landroid/os/PowerManager$WakeLock;
    //   11: ifnull +30 -> 41
    //   14: aload_0
    //   15: getfield 110	com/lantern/wifilocating/push/b/b/a:a	Landroid/os/PowerManager$WakeLock;
    //   18: invokevirtual 201	android/os/PowerManager$WakeLock:isHeld	()Z
    //   21: ifeq +20 -> 41
    //   24: aload_0
    //   25: getfield 110	com/lantern/wifilocating/push/b/b/a:a	Landroid/os/PowerManager$WakeLock;
    //   28: invokevirtual 204	android/os/PowerManager$WakeLock:release	()V
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 35	com/lantern/wifilocating/push/b/b/a:e	I
    //   36: iconst_1
    //   37: isub
    //   38: putfield 35	com/lantern/wifilocating/push/b/b/a:e	I
    //   41: aload_0
    //   42: getfield 35	com/lantern/wifilocating/push/b/b/a:e	I
    //   45: ifne +16 -> 61
    //   48: invokestatic 59	com/lantern/wifilocating/push/f/f:a	()Lcom/lantern/wifilocating/push/f/f;
    //   51: invokevirtual 62	com/lantern/wifilocating/push/f/f:b	()Lcom/lantern/wifilocating/push/f/c;
    //   54: aload_0
    //   55: getfield 47	com/lantern/wifilocating/push/b/b/a:g	Ljava/lang/Runnable;
    //   58: invokevirtual 68	com/lantern/wifilocating/push/f/c:removeCallbacks	(Ljava/lang/Runnable;)V
    //   61: aload_1
    //   62: monitorexit
    //   63: return
    //   64: astore_2
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 110	com/lantern/wifilocating/push/b/b/a:a	Landroid/os/PowerManager$WakeLock;
    //   70: aload_0
    //   71: getfield 35	com/lantern/wifilocating/push/b/b/a:e	I
    //   74: ifne -13 -> 61
    //   77: invokestatic 59	com/lantern/wifilocating/push/f/f:a	()Lcom/lantern/wifilocating/push/f/f;
    //   80: invokevirtual 62	com/lantern/wifilocating/push/f/f:b	()Lcom/lantern/wifilocating/push/f/c;
    //   83: aload_0
    //   84: getfield 47	com/lantern/wifilocating/push/b/b/a:g	Ljava/lang/Runnable;
    //   87: invokevirtual 68	com/lantern/wifilocating/push/f/c:removeCallbacks	(Ljava/lang/Runnable;)V
    //   90: goto -29 -> 61
    //   93: astore_2
    //   94: aload_1
    //   95: monitorexit
    //   96: aload_2
    //   97: athrow
    //   98: astore_2
    //   99: aload_0
    //   100: getfield 35	com/lantern/wifilocating/push/b/b/a:e	I
    //   103: ifne +16 -> 119
    //   106: invokestatic 59	com/lantern/wifilocating/push/f/f:a	()Lcom/lantern/wifilocating/push/f/f;
    //   109: invokevirtual 62	com/lantern/wifilocating/push/f/f:b	()Lcom/lantern/wifilocating/push/f/c;
    //   112: aload_0
    //   113: getfield 47	com/lantern/wifilocating/push/b/b/a:g	Ljava/lang/Runnable;
    //   116: invokevirtual 68	com/lantern/wifilocating/push/f/c:removeCallbacks	(Ljava/lang/Runnable;)V
    //   119: aload_2
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	a
    //   4	91	1	localObject1	Object
    //   64	1	2	localThrowable	Throwable
    //   93	4	2	localObject2	Object
    //   98	22	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	41	64	java/lang/Throwable
    //   41	61	93	finally
    //   61	63	93	finally
    //   70	90	93	finally
    //   94	96	93	finally
    //   99	119	93	finally
    //   119	121	93	finally
    //   7	41	98	finally
    //   65	70	98	finally
  }
  
  public void onEvent(com.lantern.wifilocating.push.f.a.a arg1)
  {
    int i = ???.a();
    if (i == a.a.n) {}
    for (;;)
    {
      synchronized (this.b)
      {
        try
        {
          this.c = false;
          a(this.f, true);
          return;
        }
        catch (Throwable localThrowable)
        {
          h.a(localThrowable);
          continue;
        }
      }
      if (i == a.a.i) {
        d();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */