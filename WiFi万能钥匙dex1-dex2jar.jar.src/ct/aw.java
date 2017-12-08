package ct;

import android.text.TextUtils;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class aw
{
  public static int a = -1;
  public static int b = -1;
  private static int c = 20000;
  private static ThreadPoolExecutor d;
  
  /* Error */
  public static av a(ArrayList paramArrayList, String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 34	java/util/concurrent/CountDownLatch
    //   3: dup
    //   4: iconst_1
    //   5: invokespecial 38	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   8: astore 5
    //   10: new 12	ct/aw$c
    //   13: dup
    //   14: iconst_0
    //   15: invokespecial 41	ct/aw$c:<init>	(B)V
    //   18: astore 6
    //   20: new 43	ct/av
    //   23: dup
    //   24: invokespecial 45	ct/av:<init>	()V
    //   27: astore 4
    //   29: getstatic 47	ct/aw:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   32: ifnonnull +57 -> 89
    //   35: new 49	java/util/concurrent/ThreadPoolExecutor
    //   38: astore 8
    //   40: getstatic 55	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   43: astore 7
    //   45: new 57	java/util/concurrent/LinkedBlockingQueue
    //   48: astore 9
    //   50: aload 9
    //   52: iconst_5
    //   53: invokespecial 58	java/util/concurrent/LinkedBlockingQueue:<init>	(I)V
    //   56: new 6	ct/aw$a
    //   59: astore 10
    //   61: aload 10
    //   63: ldc 60
    //   65: invokespecial 63	ct/aw$a:<init>	(Ljava/lang/String;)V
    //   68: aload 8
    //   70: iconst_3
    //   71: iconst_5
    //   72: ldc2_w 64
    //   75: aload 7
    //   77: aload 9
    //   79: aload 10
    //   81: invokespecial 68	java/util/concurrent/ThreadPoolExecutor:<init>	(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   84: aload 8
    //   86: putstatic 47	ct/aw:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   89: aload_0
    //   90: aload_1
    //   91: invokestatic 71	ct/aw:a	(Ljava/util/ArrayList;Ljava/lang/String;)Ljava/util/List;
    //   94: invokeinterface 77 1 0
    //   99: astore_1
    //   100: aload_1
    //   101: invokeinterface 83 1 0
    //   106: ifeq +42 -> 148
    //   109: aload_1
    //   110: invokeinterface 87 1 0
    //   115: checkcast 43	ct/av
    //   118: astore 7
    //   120: new 9	ct/aw$b
    //   123: astore_0
    //   124: aload_0
    //   125: aload 5
    //   127: aload 6
    //   129: aload 7
    //   131: invokespecial 90	ct/aw$b:<init>	(Ljava/util/concurrent/CountDownLatch;Lct/aw$c;Lct/av;)V
    //   134: getstatic 47	ct/aw:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   137: aload_0
    //   138: invokevirtual 94	java/util/concurrent/ThreadPoolExecutor:execute	(Ljava/lang/Runnable;)V
    //   141: goto -41 -> 100
    //   144: astore_0
    //   145: aload 4
    //   147: areturn
    //   148: iload_2
    //   149: iflt +12 -> 161
    //   152: iload_2
    //   153: istore_3
    //   154: iload_2
    //   155: getstatic 24	ct/aw:c	I
    //   158: if_icmple +7 -> 165
    //   161: getstatic 24	ct/aw:c	I
    //   164: istore_3
    //   165: aload 5
    //   167: iload_3
    //   168: i2l
    //   169: getstatic 55	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   172: invokevirtual 98	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   175: ifeq +23 -> 198
    //   178: aload 6
    //   180: getfield 101	ct/aw$c:b	Lct/av;
    //   183: astore_0
    //   184: aload_0
    //   185: astore 4
    //   187: goto -42 -> 145
    //   190: astore_0
    //   191: goto -46 -> 145
    //   194: astore_0
    //   195: goto -50 -> 145
    //   198: aload 4
    //   200: astore_0
    //   201: goto -17 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramArrayList	ArrayList
    //   0	204	1	paramString	String
    //   0	204	2	paramInt	int
    //   153	15	3	i	int
    //   27	172	4	localObject1	Object
    //   8	158	5	localCountDownLatch	CountDownLatch
    //   18	161	6	localc	c
    //   43	87	7	localObject2	Object
    //   38	47	8	localThreadPoolExecutor	ThreadPoolExecutor
    //   48	30	9	localLinkedBlockingQueue	java.util.concurrent.LinkedBlockingQueue
    //   59	21	10	locala	a
    // Exception table:
    //   from	to	target	type
    //   29	89	144	java/util/concurrent/RejectedExecutionException
    //   89	100	144	java/util/concurrent/RejectedExecutionException
    //   100	141	144	java/util/concurrent/RejectedExecutionException
    //   154	161	144	java/util/concurrent/RejectedExecutionException
    //   161	165	144	java/util/concurrent/RejectedExecutionException
    //   165	184	144	java/util/concurrent/RejectedExecutionException
    //   29	89	190	java/lang/Throwable
    //   89	100	190	java/lang/Throwable
    //   100	141	190	java/lang/Throwable
    //   154	161	190	java/lang/Throwable
    //   161	165	190	java/lang/Throwable
    //   165	184	190	java/lang/Throwable
    //   29	89	194	java/lang/InterruptedException
    //   89	100	194	java/lang/InterruptedException
    //   100	141	194	java/lang/InterruptedException
    //   154	161	194	java/lang/InterruptedException
    //   161	165	194	java/lang/InterruptedException
    //   165	184	194	java/lang/InterruptedException
  }
  
  public static Socket a(ArrayList paramArrayList, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() > 0) {
        break label19;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (Socket)localObject1;
      label19:
      paramArrayList = a(paramArrayList, "", paramInt);
      localObject1 = localObject2;
      if (paramArrayList != null)
      {
        bb.a("ParallelResolver", "getFastSocket end.");
        localObject1 = paramArrayList.c;
      }
    }
  }
  
  private static List a(ArrayList paramArrayList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      paramArrayList = (s)localIterator.next();
      av localav = new av();
      localav.f = paramArrayList;
      localArrayList.add(localav);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramArrayList = new av();
      paramArrayList.b = paramString;
      localArrayList.add(paramArrayList);
    }
    return localArrayList;
  }
  
  public static void a()
  {
    if (d != null)
    {
      d.shutdownNow();
      d = null;
    }
  }
  
  static final class a
    implements ThreadFactory
  {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    
    a(String paramString)
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.b = ((ThreadGroup)localObject);
        this.d = (paramString + "-" + a.getAndIncrement() + "-thread-");
        return;
      }
    }
    
    public final Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      if (paramRunnable.getPriority() != 5) {
        paramRunnable.setPriority(5);
      }
      return paramRunnable;
    }
  }
  
  static final class b
    implements Runnable
  {
    private CountDownLatch a = null;
    private aw.c b = null;
    private av c = null;
    
    public b(CountDownLatch paramCountDownLatch, aw.c paramc, av paramav)
    {
      this.a = paramCountDownLatch;
      this.b = paramc;
      this.c = paramav;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 8
      //   3: aload_0
      //   4: getfield 25	ct/aw$b:c	Lct/av;
      //   7: astore 10
      //   9: new 35	java/lang/StringBuilder
      //   12: astore 9
      //   14: aload 9
      //   16: ldc 37
      //   18: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   21: ldc 42
      //   23: aload 9
      //   25: invokestatic 48	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   28: invokevirtual 52	java/lang/Thread:getName	()Ljava/lang/String;
      //   31: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   34: ldc 58
      //   36: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   39: invokestatic 48	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   42: invokevirtual 62	java/lang/Thread:isDaemon	()Z
      //   45: invokevirtual 65	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   48: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   51: invokestatic 73	ct/bb:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   54: invokestatic 79	android/os/SystemClock:elapsedRealtime	()J
      //   57: lstore 6
      //   59: aload 10
      //   61: getfield 84	ct/av:b	Ljava/lang/String;
      //   64: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   67: istore_1
      //   68: iload_1
      //   69: ifne +398 -> 467
      //   72: aload 10
      //   74: getfield 84	ct/av:b	Ljava/lang/String;
      //   77: invokestatic 96	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
      //   80: astore 9
      //   82: aload 9
      //   84: astore 8
      //   86: aload 10
      //   88: invokestatic 79	android/os/SystemClock:elapsedRealtime	()J
      //   91: lload 6
      //   93: lsub
      //   94: l2i
      //   95: putfield 100	ct/av:d	I
      //   98: new 102	java/net/InetSocketAddress
      //   101: astore 9
      //   103: aload 9
      //   105: aload 8
      //   107: aload 10
      //   109: getfield 106	ct/av:f	Lct/s;
      //   112: getfield 110	ct/s:b	I
      //   115: invokespecial 113	java/net/InetSocketAddress:<init>	(Ljava/net/InetAddress;I)V
      //   118: aload 9
      //   120: astore 8
      //   122: new 35	java/lang/StringBuilder
      //   125: astore 9
      //   127: aload 9
      //   129: ldc 115
      //   131: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   134: ldc 42
      //   136: aload 9
      //   138: aload 10
      //   140: getfield 106	ct/av:f	Lct/s;
      //   143: getfield 117	ct/s:a	Ljava/lang/String;
      //   146: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   149: ldc 119
      //   151: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   154: aload 10
      //   156: getfield 106	ct/av:f	Lct/s;
      //   159: getfield 110	ct/s:b	I
      //   162: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   165: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   168: invokestatic 124	ct/bb:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   171: new 126	java/net/Socket
      //   174: astore 9
      //   176: aload 9
      //   178: invokespecial 127	java/net/Socket:<init>	()V
      //   181: lconst_0
      //   182: lstore_2
      //   183: invokestatic 79	android/os/SystemClock:elapsedRealtime	()J
      //   186: lstore 4
      //   188: lload 4
      //   190: lstore_2
      //   191: aload 10
      //   193: invokestatic 132	ct/b$a:b	()Lct/b$a;
      //   196: getfield 135	ct/b$a:b	Lct/e;
      //   199: getfield 139	ct/e:a	I
      //   202: putfield 140	ct/av:a	I
      //   205: lload 4
      //   207: lstore_2
      //   208: aload 9
      //   210: aload 8
      //   212: aload 10
      //   214: getfield 140	ct/av:a	I
      //   217: invokevirtual 144	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
      //   220: lload 4
      //   222: lstore_2
      //   223: aload 9
      //   225: invokevirtual 147	java/net/Socket:isConnected	()Z
      //   228: ifeq +39 -> 267
      //   231: lload 4
      //   233: lstore_2
      //   234: aload 9
      //   236: invokevirtual 150	java/net/Socket:isClosed	()Z
      //   239: ifne +28 -> 267
      //   242: lload 4
      //   244: lstore_2
      //   245: aload 10
      //   247: aload 9
      //   249: putfield 153	ct/av:c	Ljava/net/Socket;
      //   252: lload 4
      //   254: lstore_2
      //   255: aload 10
      //   257: invokestatic 79	android/os/SystemClock:elapsedRealtime	()J
      //   260: lload 4
      //   262: lsub
      //   263: l2i
      //   264: putfield 156	ct/av:e	I
      //   267: invokestatic 79	android/os/SystemClock:elapsedRealtime	()J
      //   270: lstore_2
      //   271: new 35	java/lang/StringBuilder
      //   274: astore 8
      //   276: aload 8
      //   278: ldc -98
      //   280: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   283: ldc 42
      //   285: aload 8
      //   287: aload 10
      //   289: getfield 106	ct/av:f	Lct/s;
      //   292: getfield 117	ct/s:a	Ljava/lang/String;
      //   295: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   298: ldc 119
      //   300: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   303: aload 10
      //   305: getfield 106	ct/av:f	Lct/s;
      //   308: getfield 110	ct/s:b	I
      //   311: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   314: ldc -96
      //   316: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   319: aload 10
      //   321: getfield 153	ct/av:c	Ljava/net/Socket;
      //   324: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   327: ldc -91
      //   329: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   332: lload_2
      //   333: lload 6
      //   335: lsub
      //   336: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   339: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   342: invokestatic 124	ct/bb:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   345: aload_0
      //   346: getfield 25	ct/aw$b:c	Lct/av;
      //   349: getfield 100	ct/av:d	I
      //   352: putstatic 169	ct/aw:a	I
      //   355: aload_0
      //   356: getfield 25	ct/aw$b:c	Lct/av;
      //   359: getfield 156	ct/av:e	I
      //   362: putstatic 170	ct/aw:b	I
      //   365: aload_0
      //   366: getfield 23	ct/aw$b:b	Lct/aw$c;
      //   369: astore 8
      //   371: aload_0
      //   372: getfield 25	ct/aw$b:c	Lct/av;
      //   375: astore 9
      //   377: aload 9
      //   379: ifnull +38 -> 417
      //   382: aload 8
      //   384: getfield 175	ct/aw$c:a	Ljava/util/concurrent/locks/Lock;
      //   387: invokeinterface 180 1 0
      //   392: aload 8
      //   394: getfield 182	ct/aw$c:b	Lct/av;
      //   397: ifnonnull +147 -> 544
      //   400: aload 8
      //   402: aload 9
      //   404: putfield 182	ct/aw$c:b	Lct/av;
      //   407: aload 8
      //   409: getfield 175	ct/aw$c:a	Ljava/util/concurrent/locks/Lock;
      //   412: invokeinterface 185 1 0
      //   417: aload_0
      //   418: getfield 21	ct/aw$b:a	Ljava/util/concurrent/CountDownLatch;
      //   421: invokevirtual 190	java/util/concurrent/CountDownLatch:countDown	()V
      //   424: return
      //   425: astore 9
      //   427: aload 9
      //   429: invokevirtual 194	java/lang/Object:getClass	()Ljava/lang/Class;
      //   432: invokevirtual 199	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   435: pop
      //   436: new 35	java/lang/StringBuilder
      //   439: astore 9
      //   441: aload 9
      //   443: ldc -55
      //   445: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   448: aload 9
      //   450: aload 10
      //   452: getfield 84	ct/av:b	Ljava/lang/String;
      //   455: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   458: pop
      //   459: goto -373 -> 86
      //   462: astore 8
      //   464: goto -40 -> 424
      //   467: new 102	java/net/InetSocketAddress
      //   470: astore 8
      //   472: aload 8
      //   474: aload 10
      //   476: getfield 106	ct/av:f	Lct/s;
      //   479: getfield 117	ct/s:a	Ljava/lang/String;
      //   482: aload 10
      //   484: getfield 106	ct/av:f	Lct/s;
      //   487: getfield 110	ct/s:b	I
      //   490: invokespecial 204	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
      //   493: aload 10
      //   495: iconst_0
      //   496: putfield 100	ct/av:d	I
      //   499: goto -377 -> 122
      //   502: astore 8
      //   504: aload 8
      //   506: invokevirtual 207	java/lang/Exception:printStackTrace	()V
      //   509: aload 8
      //   511: invokevirtual 194	java/lang/Object:getClass	()Ljava/lang/Class;
      //   514: invokevirtual 199	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   517: pop
      //   518: aload 8
      //   520: invokestatic 212	ct/bc:a	(Ljava/lang/Exception;)Ljava/lang/String;
      //   523: pop
      //   524: aload 10
      //   526: invokestatic 79	android/os/SystemClock:elapsedRealtime	()J
      //   529: lload_2
      //   530: lsub
      //   531: l2i
      //   532: putfield 156	ct/av:e	I
      //   535: aload 10
      //   537: aconst_null
      //   538: putfield 153	ct/av:c	Ljava/net/Socket;
      //   541: goto -274 -> 267
      //   544: aload 9
      //   546: getfield 153	ct/av:c	Ljava/net/Socket;
      //   549: invokevirtual 215	java/net/Socket:close	()V
      //   552: goto -145 -> 407
      //   555: astore 9
      //   557: aload 9
      //   559: invokevirtual 216	java/io/IOException:printStackTrace	()V
      //   562: goto -155 -> 407
      //   565: astore 9
      //   567: aload 8
      //   569: getfield 175	ct/aw$c:a	Ljava/util/concurrent/locks/Lock;
      //   572: invokeinterface 185 1 0
      //   577: aload 9
      //   579: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	580	0	this	b
      //   67	2	1	bool	boolean
      //   182	348	2	l1	long
      //   186	75	4	l2	long
      //   57	277	6	l3	long
      //   1	407	8	localObject1	Object
      //   462	1	8	localThrowable	Throwable
      //   470	3	8	localInetSocketAddress	java.net.InetSocketAddress
      //   502	66	8	localException1	Exception
      //   12	391	9	localObject2	Object
      //   425	3	9	localException2	Exception
      //   439	106	9	localStringBuilder	StringBuilder
      //   555	3	9	localIOException	java.io.IOException
      //   565	13	9	localObject3	Object
      //   7	529	10	localav	av
      // Exception table:
      //   from	to	target	type
      //   72	82	425	java/lang/Exception
      //   3	68	462	java/lang/Throwable
      //   72	82	462	java/lang/Throwable
      //   86	118	462	java/lang/Throwable
      //   122	181	462	java/lang/Throwable
      //   183	188	462	java/lang/Throwable
      //   191	205	462	java/lang/Throwable
      //   208	220	462	java/lang/Throwable
      //   223	231	462	java/lang/Throwable
      //   234	242	462	java/lang/Throwable
      //   245	252	462	java/lang/Throwable
      //   255	267	462	java/lang/Throwable
      //   267	377	462	java/lang/Throwable
      //   382	392	462	java/lang/Throwable
      //   407	417	462	java/lang/Throwable
      //   417	424	462	java/lang/Throwable
      //   427	459	462	java/lang/Throwable
      //   467	499	462	java/lang/Throwable
      //   504	541	462	java/lang/Throwable
      //   567	580	462	java/lang/Throwable
      //   183	188	502	java/lang/Exception
      //   191	205	502	java/lang/Exception
      //   208	220	502	java/lang/Exception
      //   223	231	502	java/lang/Exception
      //   234	242	502	java/lang/Exception
      //   245	252	502	java/lang/Exception
      //   255	267	502	java/lang/Exception
      //   544	552	555	java/io/IOException
      //   392	407	565	finally
      //   544	552	565	finally
      //   557	562	565	finally
    }
  }
  
  static final class c
  {
    Lock a = new ReentrantLock();
    av b = null;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */