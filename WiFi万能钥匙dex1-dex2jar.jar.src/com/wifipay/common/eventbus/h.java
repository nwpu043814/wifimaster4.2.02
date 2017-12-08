package com.wifipay.common.eventbus;

import android.os.Handler;
import android.os.Looper;

final class h
  extends Handler
{
  private final k a;
  private final int b;
  private final EventBus c;
  private boolean d;
  
  h(EventBus paramEventBus, Looper paramLooper, int paramInt)
  {
    super(paramLooper);
    this.c = paramEventBus;
    this.b = paramInt;
    this.a = new k();
  }
  
  final void a(p paramp, Object paramObject)
  {
    paramp = j.a(paramp, paramObject);
    try
    {
      this.a.a(paramp);
      if (!this.d)
      {
        this.d = true;
        if (!sendMessage(obtainMessage()))
        {
          paramp = new com/wifipay/common/eventbus/g;
          paramp.<init>("Could not send handler message");
          throw paramp;
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public final void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: invokestatic 63	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield 28	com/wifipay/common/eventbus/h:a	Lcom/wifipay/common/eventbus/k;
    //   8: invokevirtual 66	com/wifipay/common/eventbus/k:a	()Lcom/wifipay/common/eventbus/j;
    //   11: astore 4
    //   13: aload 4
    //   15: astore_1
    //   16: aload 4
    //   18: ifnonnull +32 -> 50
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 28	com/wifipay/common/eventbus/h:a	Lcom/wifipay/common/eventbus/k;
    //   27: invokevirtual 66	com/wifipay/common/eventbus/k:a	()Lcom/wifipay/common/eventbus/j;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull +16 -> 48
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 40	com/wifipay/common/eventbus/h:d	Z
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 40	com/wifipay/common/eventbus/h:d	Z
    //   47: return
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_0
    //   51: getfield 19	com/wifipay/common/eventbus/h:c	Lcom/wifipay/common/eventbus/EventBus;
    //   54: aload_1
    //   55: invokevirtual 69	com/wifipay/common/eventbus/EventBus:a	(Lcom/wifipay/common/eventbus/j;)V
    //   58: invokestatic 63	android/os/SystemClock:uptimeMillis	()J
    //   61: lload_2
    //   62: lsub
    //   63: aload_0
    //   64: getfield 21	com/wifipay/common/eventbus/h:b	I
    //   67: i2l
    //   68: lcmp
    //   69: iflt -65 -> 4
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 44	com/wifipay/common/eventbus/h:obtainMessage	()Landroid/os/Message;
    //   77: invokevirtual 48	com/wifipay/common/eventbus/h:sendMessage	(Landroid/os/Message;)Z
    //   80: ifne +28 -> 108
    //   83: new 50	com/wifipay/common/eventbus/g
    //   86: astore_1
    //   87: aload_1
    //   88: ldc 52
    //   90: invokespecial 55	com/wifipay/common/eventbus/g:<init>	(Ljava/lang/String;)V
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 40	com/wifipay/common/eventbus/h:d	Z
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: aload_0
    //   109: iconst_1
    //   110: putfield 40	com/wifipay/common/eventbus/h:d	Z
    //   113: goto -66 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	h
    //   0	116	1	paramMessage	android.os.Message
    //   3	59	2	l	long
    //   11	6	4	localj	j
    // Exception table:
    //   from	to	target	type
    //   0	4	95	finally
    //   4	13	95	finally
    //   21	23	95	finally
    //   50	95	95	finally
    //   106	108	95	finally
    //   23	31	103	finally
    //   35	42	103	finally
    //   48	50	103	finally
    //   104	106	103	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/eventbus/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */