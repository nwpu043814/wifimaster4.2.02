package com.wifipay.common.net.b;

import android.os.SystemClock;
import com.wifipay.common.logging.Logger;
import java.util.ArrayList;
import java.util.List;

class w
{
  public static final boolean a = ;
  private final List b = new ArrayList();
  private boolean c = false;
  
  private long a()
  {
    if (this.b.size() == 0) {}
    for (long l = 0L;; l = ((x)this.b.get(this.b.size() - 1)).c - l)
    {
      return l;
      l = ((x)this.b.get(0)).c;
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 30	com/wifipay/common/net/b/w:c	Z
    //   7: aload_0
    //   8: invokespecial 49	com/wifipay/common/net/b/w:a	()J
    //   11: lstore 4
    //   13: lload 4
    //   15: lconst_0
    //   16: lcmp
    //   17: ifgt +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 28	com/wifipay/common/net/b/w:b	Ljava/util/List;
    //   27: iconst_0
    //   28: invokeinterface 41 2 0
    //   33: checkcast 43	com/wifipay/common/net/b/x
    //   36: getfield 46	com/wifipay/common/net/b/x:c	J
    //   39: lstore_2
    //   40: ldc 51
    //   42: iconst_2
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: lload 4
    //   50: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: aload_1
    //   57: aastore
    //   58: invokestatic 62	com/wifipay/common/net/b/v:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 28	com/wifipay/common/net/b/w:b	Ljava/util/List;
    //   65: invokeinterface 66 1 0
    //   70: astore 6
    //   72: aload 6
    //   74: invokeinterface 71 1 0
    //   79: ifeq -59 -> 20
    //   82: aload 6
    //   84: invokeinterface 75 1 0
    //   89: checkcast 43	com/wifipay/common/net/b/x
    //   92: astore_1
    //   93: aload_1
    //   94: getfield 46	com/wifipay/common/net/b/x:c	J
    //   97: lstore 4
    //   99: ldc 77
    //   101: iconst_3
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: lload 4
    //   109: lload_2
    //   110: lsub
    //   111: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload_1
    //   118: getfield 79	com/wifipay/common/net/b/x:b	J
    //   121: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: aastore
    //   125: dup
    //   126: iconst_2
    //   127: aload_1
    //   128: getfield 82	com/wifipay/common/net/b/x:a	Ljava/lang/String;
    //   131: aastore
    //   132: invokestatic 62	com/wifipay/common/net/b/v:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: lload 4
    //   137: lstore_2
    //   138: goto -66 -> 72
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	w
    //   0	146	1	paramString	String
    //   39	99	2	l1	long
    //   11	125	4	l2	long
    //   70	13	6	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	141	finally
    //   23	72	141	finally
    //   72	135	141	finally
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      if (this.c)
      {
        paramString = new java/lang/IllegalStateException;
        paramString.<init>("Marker added to finished log");
        throw paramString;
      }
    }
    finally {}
    List localList = this.b;
    x localx = new com/wifipay/common/net/b/x;
    localx.<init>(paramString, paramLong, SystemClock.elapsedRealtime());
    localList.add(localx);
  }
  
  protected void finalize()
  {
    if (!this.c)
    {
      a("Request on the loose");
      v.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */