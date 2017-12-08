package com.wifipay.common.net.b;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class n
  implements u, Future
{
  private k a;
  private boolean b = false;
  private Object c;
  private Exception d;
  
  public static n a()
  {
    return new n();
  }
  
  private Object a(Long paramLong)
  {
    try
    {
      if (this.d != null)
      {
        paramLong = new java/util/concurrent/ExecutionException;
        paramLong.<init>(this.d);
        throw paramLong;
      }
    }
    finally {}
    if (this.b) {}
    for (paramLong = this.c;; paramLong = this.c)
    {
      return paramLong;
      if (paramLong == null) {
        wait(0L);
      }
      while (this.d != null)
      {
        paramLong = new java/util/concurrent/ExecutionException;
        paramLong.<init>(this.d);
        throw paramLong;
        if (paramLong.longValue() > 0L) {
          wait(paramLong.longValue());
        }
      }
      if (!this.b)
      {
        paramLong = new java/util/concurrent/TimeoutException;
        paramLong.<init>();
        throw paramLong;
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, Exception paramException)
  {
    try
    {
      this.d = paramException;
      notifyAll();
      notifyAll();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    try
    {
      this.b = true;
      this.c = paramObject;
      notifyAll();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(String paramString) {}
  
  /* Error */
  public boolean cancel(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 58	com/wifipay/common/net/b/n:a	Lcom/wifipay/common/net/b/k;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: invokevirtual 62	com/wifipay/common/net/b/n:isDone	()Z
    //   21: ifne -8 -> 13
    //   24: aload_0
    //   25: getfield 58	com/wifipay/common/net/b/n:a	Lcom/wifipay/common/net/b/k;
    //   28: invokevirtual 67	com/wifipay/common/net/b/k:g	()V
    //   31: iconst_1
    //   32: istore_1
    //   33: goto -20 -> 13
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	n
    //   0	41	1	paramBoolean	boolean
    //   8	2	2	localk	k
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	36	finally
    //   17	31	36	finally
  }
  
  public Object get()
  {
    try
    {
      Object localObject = a(null);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new AssertionError(localTimeoutException);
    }
  }
  
  public Object get(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit)));
  }
  
  public boolean isCancelled()
  {
    if (this.a == null) {}
    for (boolean bool = false;; bool = this.a.h()) {
      return bool;
    }
  }
  
  /* Error */
  public boolean isDone()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/wifipay/common/net/b/n:b	Z
    //   6: ifne +19 -> 25
    //   9: aload_0
    //   10: getfield 28	com/wifipay/common/net/b/n:d	Ljava/lang/Exception;
    //   13: ifnonnull +12 -> 25
    //   16: aload_0
    //   17: invokevirtual 97	com/wifipay/common/net/b/n:isCancelled	()Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +9 -> 31
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_1
    //   33: goto -6 -> 27
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	n
    //   20	13	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	36	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */