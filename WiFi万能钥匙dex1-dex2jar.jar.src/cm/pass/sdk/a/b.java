package cm.pass.sdk.a;

import android.util.Log;
import cm.pass.sdk.a.a.c;
import cm.pass.sdk.a.a.e;
import cm.pass.sdk.a.a.f;
import cm.pass.sdk.utils.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import org.xmlpull.v1.XmlPullParserException;

public class b
  implements a
{
  private final File a;
  private final File b;
  private final int c;
  private Map<String, Object> d;
  private int e = 0;
  private boolean f = false;
  private long g;
  private long h;
  private final Object i = new Object();
  
  b(File paramFile, int paramInt)
  {
    this.a = paramFile;
    this.b = a(paramFile);
    this.c = paramInt;
    this.f = false;
    this.d = null;
    c();
  }
  
  private static File a(File paramFile)
  {
    return new File(paramFile.getPath() + ".bak");
  }
  
  private void a(b paramb)
  {
    if (this.a.exists()) {
      if (!paramb.a) {
        paramb.a(true);
      }
    }
    for (;;)
    {
      return;
      if (!this.b.exists())
      {
        if (this.a.renameTo(this.b)) {
          break label99;
        }
        j.a("CustomSharePreferencesImpl", "Couldn't rename file " + this.a + " to backup file " + this.b);
        paramb.a(false);
        continue;
      }
      this.a.delete();
      try
      {
        label99:
        FileOutputStream localFileOutputStream = b(this.a);
        if (localFileOutputStream == null) {
          paramb.a(false);
        }
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        Log.w("CustomSharePreferencesImpl", "writeToFile: Got exception:", localXmlPullParserException);
        if ((this.a.exists()) && (!this.a.delete())) {
          j.a("CustomSharePreferencesImpl", "Couldn't clean up partially-written file " + this.a);
        }
        paramb.a(false);
        continue;
        f.a(paramb.b, localXmlPullParserException);
        c.a(localXmlPullParserException);
        localXmlPullParserException.close();
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          try
          {
            this.g = this.a.lastModified();
            this.h = this.a.length();
            this.b.delete();
            paramb.a(true);
            break;
          }
          finally {}
          localIOException = localIOException;
          Log.w("CustomSharePreferencesImpl", "writeToFile: Got exception:", localIOException);
        }
      }
    }
  }
  
  private void a(b paramb, Runnable paramRunnable)
  {
    int k = 1;
    paramb = new b.2(this, paramb, paramRunnable);
    int j;
    if (paramRunnable == null)
    {
      j = 1;
      if (j == 0) {
        break label65;
      }
    }
    label65:
    for (;;)
    {
      try
      {
        if (this.e == 1)
        {
          j = k;
          if (j == 0) {
            break label65;
          }
          paramb.run();
          return;
          j = 0;
          break;
        }
        j = 0;
        continue;
        e.a().execute(paramb);
      }
      finally {}
    }
  }
  
  private static FileOutputStream b(File paramFile)
  {
    try
    {
      FileOutputStream localFileOutputStream1 = new java/io/FileOutputStream;
      localFileOutputStream1.<init>(paramFile);
      paramFile = localFileOutputStream1;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        if (!paramFile.getParentFile().mkdir())
        {
          j.a("CustomSharePreferencesImpl", "Couldn't create directory for SharedPreferences file " + paramFile);
          paramFile = null;
        }
        else
        {
          try
          {
            FileOutputStream localFileOutputStream2 = new java/io/FileOutputStream;
            localFileOutputStream2.<init>(paramFile);
            paramFile = localFileOutputStream2;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            Log.e("CustomSharePreferencesImpl", "Couldn't create SharedPreferences file " + paramFile, localFileNotFoundException2);
            paramFile = null;
          }
        }
      }
    }
    return paramFile;
  }
  
  private void c()
  {
    try
    {
      this.f = false;
      new b.1(this, "SharedPreferencesImpl-load").start();
      return;
    }
    finally {}
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aconst_null
    //   3: astore 13
    //   5: aconst_null
    //   6: astore 14
    //   8: aload_0
    //   9: getfield 35	cm/pass/sdk/a/b:f	Z
    //   12: ifeq +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: getfield 44	cm/pass/sdk/a/b:b	Ljava/io/File;
    //   20: invokevirtual 82	java/io/File:exists	()Z
    //   23: ifeq +23 -> 46
    //   26: aload_0
    //   27: getfield 39	cm/pass/sdk/a/b:a	Ljava/io/File;
    //   30: invokevirtual 109	java/io/File:delete	()Z
    //   33: pop
    //   34: aload_0
    //   35: getfield 44	cm/pass/sdk/a/b:b	Ljava/io/File;
    //   38: aload_0
    //   39: getfield 39	cm/pass/sdk/a/b:a	Ljava/io/File;
    //   42: invokevirtual 91	java/io/File:renameTo	(Ljava/io/File;)Z
    //   45: pop
    //   46: aload_0
    //   47: getfield 39	cm/pass/sdk/a/b:a	Ljava/io/File;
    //   50: invokevirtual 82	java/io/File:exists	()Z
    //   53: ifeq +42 -> 95
    //   56: aload_0
    //   57: getfield 39	cm/pass/sdk/a/b:a	Ljava/io/File;
    //   60: invokevirtual 215	java/io/File:canRead	()Z
    //   63: ifeq +32 -> 95
    //   66: ldc 93
    //   68: new 55	java/lang/StringBuilder
    //   71: dup
    //   72: ldc -39
    //   74: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload_0
    //   78: getfield 39	cm/pass/sdk/a/b:a	Ljava/io/File;
    //   81: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: ldc -37
    //   86: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 221	cm/pass/sdk/utils/j:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: getfield 39	cm/pass/sdk/a/b:a	Ljava/io/File;
    //   99: invokevirtual 143	java/io/File:lastModified	()J
    //   102: lstore 4
    //   104: aload 13
    //   106: astore 10
    //   108: aload_0
    //   109: getfield 39	cm/pass/sdk/a/b:a	Ljava/io/File;
    //   112: invokevirtual 148	java/io/File:length	()J
    //   115: lstore 6
    //   117: lload 6
    //   119: lstore_2
    //   120: aload 13
    //   122: astore 10
    //   124: aload_0
    //   125: getfield 39	cm/pass/sdk/a/b:a	Ljava/io/File;
    //   128: invokevirtual 215	java/io/File:canRead	()Z
    //   131: istore_1
    //   132: lload 6
    //   134: lstore_2
    //   135: lload 4
    //   137: lstore 8
    //   139: aload 14
    //   141: astore 10
    //   143: iload_1
    //   144: ifeq +66 -> 210
    //   147: new 223	java/io/BufferedInputStream
    //   150: astore 11
    //   152: new 225	java/io/FileInputStream
    //   155: astore 10
    //   157: aload 10
    //   159: aload_0
    //   160: getfield 39	cm/pass/sdk/a/b:a	Ljava/io/File;
    //   163: invokespecial 226	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   166: aload 11
    //   168: aload 10
    //   170: sipush 16384
    //   173: invokespecial 229	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   176: aload 11
    //   178: astore 10
    //   180: aload 11
    //   182: invokestatic 232	cm/pass/sdk/a/a/f:a	(Ljava/io/InputStream;)Ljava/util/HashMap;
    //   185: astore 12
    //   187: lload 6
    //   189: lstore_2
    //   190: aload 12
    //   192: astore 10
    //   194: aload 11
    //   196: invokestatic 237	cm/pass/sdk/a/a/d:a	(Ljava/lang/AutoCloseable;)V
    //   199: aload 12
    //   201: astore 10
    //   203: lload 4
    //   205: lstore 8
    //   207: lload 6
    //   209: lstore_2
    //   210: aload_0
    //   211: iconst_1
    //   212: putfield 35	cm/pass/sdk/a/b:f	Z
    //   215: aload 10
    //   217: ifnull +198 -> 415
    //   220: aload_0
    //   221: aload 10
    //   223: putfield 48	cm/pass/sdk/a/b:d	Ljava/util/Map;
    //   226: aload_0
    //   227: lload 8
    //   229: putfield 145	cm/pass/sdk/a/b:g	J
    //   232: aload_0
    //   233: lload_2
    //   234: putfield 150	cm/pass/sdk/a/b:h	J
    //   237: aload_0
    //   238: invokevirtual 240	java/lang/Object:notifyAll	()V
    //   241: goto -226 -> 15
    //   244: astore 12
    //   246: aconst_null
    //   247: astore 11
    //   249: aload 11
    //   251: astore 10
    //   253: ldc 93
    //   255: ldc -14
    //   257: aload 12
    //   259: invokestatic 120	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   262: pop
    //   263: lload 6
    //   265: lstore_2
    //   266: aload 13
    //   268: astore 10
    //   270: aload 11
    //   272: invokestatic 237	cm/pass/sdk/a/a/d:a	(Ljava/lang/AutoCloseable;)V
    //   275: lload 6
    //   277: lstore_2
    //   278: lload 4
    //   280: lstore 8
    //   282: aload 14
    //   284: astore 10
    //   286: goto -76 -> 210
    //   289: astore 11
    //   291: lload 4
    //   293: lstore 8
    //   295: goto -85 -> 210
    //   298: astore 12
    //   300: aconst_null
    //   301: astore 11
    //   303: aload 11
    //   305: astore 10
    //   307: ldc 93
    //   309: ldc -14
    //   311: aload 12
    //   313: invokestatic 120	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   316: pop
    //   317: lload 6
    //   319: lstore_2
    //   320: aload 13
    //   322: astore 10
    //   324: aload 11
    //   326: invokestatic 237	cm/pass/sdk/a/a/d:a	(Ljava/lang/AutoCloseable;)V
    //   329: lload 6
    //   331: lstore_2
    //   332: lload 4
    //   334: lstore 8
    //   336: aload 14
    //   338: astore 10
    //   340: goto -130 -> 210
    //   343: astore 12
    //   345: aconst_null
    //   346: astore 11
    //   348: aload 11
    //   350: astore 10
    //   352: ldc 93
    //   354: ldc -14
    //   356: aload 12
    //   358: invokestatic 120	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   361: pop
    //   362: lload 6
    //   364: lstore_2
    //   365: aload 13
    //   367: astore 10
    //   369: aload 11
    //   371: invokestatic 237	cm/pass/sdk/a/a/d:a	(Ljava/lang/AutoCloseable;)V
    //   374: lload 6
    //   376: lstore_2
    //   377: lload 4
    //   379: lstore 8
    //   381: aload 14
    //   383: astore 10
    //   385: goto -175 -> 210
    //   388: astore 11
    //   390: aconst_null
    //   391: astore 12
    //   393: lload 6
    //   395: lstore_2
    //   396: aload 13
    //   398: astore 10
    //   400: aload 12
    //   402: invokestatic 237	cm/pass/sdk/a/a/d:a	(Ljava/lang/AutoCloseable;)V
    //   405: lload 6
    //   407: lstore_2
    //   408: aload 13
    //   410: astore 10
    //   412: aload 11
    //   414: athrow
    //   415: aload_0
    //   416: new 244	java/util/HashMap
    //   419: dup
    //   420: invokespecial 245	java/util/HashMap:<init>	()V
    //   423: putfield 48	cm/pass/sdk/a/b:d	Ljava/util/Map;
    //   426: goto -189 -> 237
    //   429: astore 10
    //   431: lconst_0
    //   432: lstore 8
    //   434: aload 14
    //   436: astore 10
    //   438: goto -228 -> 210
    //   441: astore 11
    //   443: aload 10
    //   445: astore 12
    //   447: goto -54 -> 393
    //   450: astore 12
    //   452: goto -104 -> 348
    //   455: astore 12
    //   457: goto -154 -> 303
    //   460: astore 12
    //   462: goto -213 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	b
    //   131	13	1	bool	boolean
    //   1	407	2	l1	long
    //   102	276	4	l2	long
    //   115	291	6	l3	long
    //   137	296	8	l4	long
    //   106	305	10	localObject1	Object
    //   429	1	10	localException1	Exception
    //   436	8	10	localObject2	Object
    //   150	121	11	localBufferedInputStream	java.io.BufferedInputStream
    //   289	1	11	localException2	Exception
    //   301	69	11	localAutoCloseable	AutoCloseable
    //   388	25	11	localObject3	Object
    //   441	1	11	localObject4	Object
    //   185	15	12	localHashMap	HashMap
    //   244	14	12	localXmlPullParserException1	XmlPullParserException
    //   298	14	12	localFileNotFoundException1	FileNotFoundException
    //   343	14	12	localIOException1	IOException
    //   391	55	12	localObject5	Object
    //   450	1	12	localIOException2	IOException
    //   455	1	12	localFileNotFoundException2	FileNotFoundException
    //   460	1	12	localXmlPullParserException2	XmlPullParserException
    //   3	406	13	localObject6	Object
    //   6	429	14	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   147	176	244	org/xmlpull/v1/XmlPullParserException
    //   108	117	289	java/lang/Exception
    //   124	132	289	java/lang/Exception
    //   194	199	289	java/lang/Exception
    //   270	275	289	java/lang/Exception
    //   324	329	289	java/lang/Exception
    //   369	374	289	java/lang/Exception
    //   400	405	289	java/lang/Exception
    //   412	415	289	java/lang/Exception
    //   147	176	298	java/io/FileNotFoundException
    //   147	176	343	java/io/IOException
    //   147	176	388	finally
    //   95	104	429	java/lang/Exception
    //   180	187	441	finally
    //   253	263	441	finally
    //   307	317	441	finally
    //   352	362	441	finally
    //   180	187	450	java/io/IOException
    //   180	187	455	java/io/FileNotFoundException
    //   180	187	460	org/xmlpull/v1/XmlPullParserException
  }
  
  /* Error */
  private boolean e()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 33	cm/pass/sdk/a/b:e	I
    //   10: ifle +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: monitorexit
    //   19: invokestatic 251	cm/pass/sdk/a/a/a:a	()Lcm/pass/sdk/a/a/a$a;
    //   22: invokeinterface 255 1 0
    //   27: aload_0
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 145	cm/pass/sdk/a/b:g	J
    //   33: aload_0
    //   34: getfield 39	cm/pass/sdk/a/b:a	Ljava/io/File;
    //   37: invokevirtual 143	java/io/File:lastModified	()J
    //   40: lcmp
    //   41: ifne +20 -> 61
    //   44: iload_2
    //   45: istore_1
    //   46: aload_0
    //   47: getfield 150	cm/pass/sdk/a/b:h	J
    //   50: aload_0
    //   51: getfield 39	cm/pass/sdk/a/b:a	Ljava/io/File;
    //   54: invokevirtual 148	java/io/File:length	()J
    //   57: lcmp
    //   58: ifeq +5 -> 63
    //   61: iconst_1
    //   62: istore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: goto -50 -> 15
    //   68: astore_3
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: athrow
    //   73: astore_3
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_3
    //   77: athrow
    //   78: astore_3
    //   79: iconst_1
    //   80: istore_1
    //   81: goto -66 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	b
    //   3	78	1	bool1	boolean
    //   1	44	2	bool2	boolean
    //   68	4	3	localObject1	Object
    //   73	4	3	localObject2	Object
    //   78	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   29	44	68	finally
    //   46	61	68	finally
    //   63	65	68	finally
    //   69	71	68	finally
    //   6	15	73	finally
    //   17	19	73	finally
    //   74	76	73	finally
    //   19	27	78	java/lang/Exception
  }
  
  private void f()
  {
    if (!this.f) {
      cm.pass.sdk.a.a.a.a().a();
    }
    while (!this.f) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public a.a a()
  {
    try
    {
      f();
      return new a();
    }
    finally {}
  }
  
  /* Error */
  public String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 263	cm/pass/sdk/a/b:f	()V
    //   6: aload_0
    //   7: getfield 48	cm/pass/sdk/a/b:d	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 272 2 0
    //   16: checkcast 274	java/lang/String
    //   19: astore_1
    //   20: aload_1
    //   21: ifnull +7 -> 28
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_2
    //   29: astore_1
    //   30: goto -6 -> 24
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	b
    //   0	38	1	paramString1	String
    //   0	38	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	20	33	finally
    //   24	26	33	finally
    //   34	36	33	finally
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 276	cm/pass/sdk/a/b:e	()Z
    //   6: ifne +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: invokespecial 50	cm/pass/sdk/a/b:c	()V
    //   16: aload_0
    //   17: monitorexit
    //   18: goto -7 -> 11
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	26	0	this	b
    //   21	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	21	finally
    //   12	18	21	finally
    //   22	24	21	finally
  }
  
  public final class a
    implements a.a
  {
    private final Map<String, Object> b = new HashMap();
    private boolean c = false;
    
    public a() {}
    
    private b.b b()
    {
      b.b localb1 = new b.b(null);
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        Object localObject5;
        synchronized (b.this)
        {
          Object localObject2;
          if (b.b(b.this) > 0)
          {
            localObject3 = b.this;
            localObject2 = new java/util/HashMap;
            ((HashMap)localObject2).<init>(b.c(b.this));
            b.a((b)localObject3, (Map)localObject2);
          }
          localb1.b = b.c(b.this);
          b.d(b.this);
          try
          {
            if (this.c)
            {
              if (!b.c(b.this).isEmpty())
              {
                localb1.a = true;
                b.c(b.this).clear();
              }
              this.c = false;
            }
            localObject2 = this.b.entrySet().iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject4 = (Map.Entry)((Iterator)localObject2).next();
            localObject3 = (String)((Map.Entry)localObject4).getKey();
            localObject5 = ((Map.Entry)localObject4).getValue();
            if ((localObject5 == this) || (localObject5 == null))
            {
              if (!b.c(b.this).containsKey(localObject3)) {
                continue;
              }
              b.c(b.this).remove(localObject3);
              localb1.a = true;
              continue;
              localb2 = finally;
            }
          }
          finally {}
        }
        if (b.c(b.this).containsKey(localObject3))
        {
          localObject4 = b.c(b.this).get(localObject3);
          if ((localObject4 != null) && (localObject4.equals(localObject5))) {}
        }
        else
        {
          b.c(b.this).put(localObject3, localObject5);
        }
      }
      this.b.clear();
      return localb2;
    }
    
    public final a.a a(String paramString1, String paramString2)
    {
      try
      {
        this.b.put(paramString1, paramString2);
        return this;
      }
      finally {}
    }
    
    public final boolean a()
    {
      b.b localb = b();
      b.a(b.this, localb, null);
      try
      {
        localb.c.await();
        bool = localb.d;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          boolean bool = false;
        }
      }
      return bool;
    }
  }
  
  private static class b
  {
    public boolean a;
    public Map<?, ?> b;
    public final CountDownLatch c = new CountDownLatch(1);
    public volatile boolean d = false;
    
    public void a(boolean paramBoolean)
    {
      this.d = paramBoolean;
      this.c.countDown();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */