package com.wifipay.common.net.b;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import java.util.concurrent.BlockingQueue;

public class i
  extends Thread
{
  private final BlockingQueue a;
  private final h b;
  private final s c;
  private volatile boolean d = false;
  
  public i(BlockingQueue paramBlockingQueue, h paramh, s params)
  {
    this.a = paramBlockingQueue;
    this.b = paramh;
    this.c = params;
  }
  
  private void a(k paramk)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      TrafficStats.setThreadStatsTag(paramk.c());
    }
  }
  
  private void a(k paramk, com.wifipay.common.net.b.a.h paramh)
  {
    paramh = paramk.a(paramh);
    this.c.a(paramk, paramh);
  }
  
  public void a()
  {
    this.d = true;
    interrupt();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 67	android/os/Process:setThreadPriority	(I)V
    //   5: invokestatic 73	android/os/SystemClock:elapsedRealtime	()J
    //   8: lstore_1
    //   9: aload_0
    //   10: getfield 21	com/wifipay/common/net/b/i:a	Ljava/util/concurrent/BlockingQueue;
    //   13: invokeinterface 79 1 0
    //   18: checkcast 35	com/wifipay/common/net/b/k
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 81
    //   25: invokevirtual 84	com/wifipay/common/net/b/k:b	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 25	com/wifipay/common/net/b/i:c	Lcom/wifipay/common/net/b/s;
    //   32: aload_3
    //   33: invokeinterface 86 2 0
    //   38: aload_3
    //   39: invokevirtual 90	com/wifipay/common/net/b/k:h	()Z
    //   42: ifeq +53 -> 95
    //   45: aload_3
    //   46: ldc 92
    //   48: invokevirtual 94	com/wifipay/common/net/b/k:c	(Ljava/lang/String;)V
    //   51: aload_0
    //   52: getfield 25	com/wifipay/common/net/b/i:c	Lcom/wifipay/common/net/b/s;
    //   55: aload_3
    //   56: invokeinterface 96 2 0
    //   61: goto -56 -> 5
    //   64: astore 4
    //   66: aload 4
    //   68: invokestatic 73	android/os/SystemClock:elapsedRealtime	()J
    //   71: lload_1
    //   72: lsub
    //   73: invokevirtual 99	com/wifipay/common/net/b/a/h:a	(J)V
    //   76: aload_0
    //   77: aload_3
    //   78: aload 4
    //   80: invokespecial 100	com/wifipay/common/net/b/i:a	(Lcom/wifipay/common/net/b/k;Lcom/wifipay/common/net/b/a/h;)V
    //   83: goto -78 -> 5
    //   86: astore_3
    //   87: aload_0
    //   88: getfield 19	com/wifipay/common/net/b/i:d	Z
    //   91: ifeq -86 -> 5
    //   94: return
    //   95: aload_0
    //   96: aload_3
    //   97: invokespecial 101	com/wifipay/common/net/b/i:a	(Lcom/wifipay/common/net/b/k;)V
    //   100: aload_0
    //   101: getfield 23	com/wifipay/common/net/b/i:b	Lcom/wifipay/common/net/b/h;
    //   104: aload_3
    //   105: invokeinterface 106 2 0
    //   110: astore 4
    //   112: aload_3
    //   113: ldc 108
    //   115: invokevirtual 84	com/wifipay/common/net/b/k:b	(Ljava/lang/String;)V
    //   118: aload 4
    //   120: getfield 111	com/wifipay/common/net/b/j:d	Z
    //   123: ifeq +76 -> 199
    //   126: aload_3
    //   127: invokevirtual 114	com/wifipay/common/net/b/k:w	()Z
    //   130: ifeq +69 -> 199
    //   133: aload_3
    //   134: ldc 116
    //   136: invokevirtual 94	com/wifipay/common/net/b/k:c	(Ljava/lang/String;)V
    //   139: goto -134 -> 5
    //   142: astore 4
    //   144: aload 4
    //   146: ldc 118
    //   148: iconst_1
    //   149: anewarray 120	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 4
    //   156: invokevirtual 124	java/lang/Exception:toString	()Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 129	com/wifipay/common/net/b/v:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: new 60	com/wifipay/common/net/b/a/h
    //   166: dup
    //   167: aload 4
    //   169: invokespecial 132	com/wifipay/common/net/b/a/h:<init>	(Ljava/lang/Throwable;)V
    //   172: astore 4
    //   174: aload 4
    //   176: invokestatic 73	android/os/SystemClock:elapsedRealtime	()J
    //   179: lload_1
    //   180: lsub
    //   181: invokevirtual 99	com/wifipay/common/net/b/a/h:a	(J)V
    //   184: aload_0
    //   185: getfield 25	com/wifipay/common/net/b/i:c	Lcom/wifipay/common/net/b/s;
    //   188: aload_3
    //   189: aload 4
    //   191: invokeinterface 52 3 0
    //   196: goto -191 -> 5
    //   199: aload_3
    //   200: aload 4
    //   202: invokevirtual 135	com/wifipay/common/net/b/k:a	(Lcom/wifipay/common/net/b/j;)Lcom/wifipay/common/net/b/r;
    //   205: astore 4
    //   207: aload_3
    //   208: ldc -119
    //   210: invokevirtual 84	com/wifipay/common/net/b/k:b	(Ljava/lang/String;)V
    //   213: aload_3
    //   214: invokevirtual 140	com/wifipay/common/net/b/k:v	()V
    //   217: aload_0
    //   218: getfield 25	com/wifipay/common/net/b/i:c	Lcom/wifipay/common/net/b/s;
    //   221: aload_3
    //   222: aload 4
    //   224: invokeinterface 143 3 0
    //   229: goto -224 -> 5
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	i
    //   8	172	1	l	long
    //   21	57	3	localk	k
    //   86	136	3	localInterruptedException	InterruptedException
    //   64	15	4	localh	com.wifipay.common.net.b.a.h
    //   110	9	4	localj	j
    //   142	26	4	localException	Exception
    //   172	51	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	61	64	com/wifipay/common/net/b/a/h
    //   95	139	64	com/wifipay/common/net/b/a/h
    //   199	229	64	com/wifipay/common/net/b/a/h
    //   9	22	86	java/lang/InterruptedException
    //   22	61	142	java/lang/Exception
    //   95	139	142	java/lang/Exception
    //   199	229	142	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */