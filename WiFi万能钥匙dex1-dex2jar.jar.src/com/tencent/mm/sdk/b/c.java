package com.tencent.mm.sdk.b;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class c<K, V>
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int size;
  private final LinkedHashMap<K, V> u;
  private int v;
  
  private void trimToSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.size < 0) || ((this.u.isEmpty()) && (this.size != 0)))
        {
          IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          localIllegalStateException.<init>(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
          throw localIllegalStateException;
        }
      }
      finally {}
      if ((this.size <= paramInt) || (this.u.isEmpty())) {
        return;
      }
      Map.Entry localEntry = (Map.Entry)this.u.entrySet().iterator().next();
      Object localObject2 = localEntry.getKey();
      localEntry.getValue();
      this.u.remove(localObject2);
      this.size -= 1;
      this.B += 1;
    }
  }
  
  public final boolean a(K paramK)
  {
    try
    {
      boolean bool = this.u.containsKey(paramK);
      return bool;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  /* Error */
  public final V get(K paramK)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 98	java/lang/NullPointerException
    //   7: dup
    //   8: ldc 100
    //   10: invokespecial 101	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 21	com/tencent/mm/sdk/b/c:u	Ljava/util/LinkedHashMap;
    //   20: aload_1
    //   21: invokevirtual 103	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +17 -> 43
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 105	com/tencent/mm/sdk/b/c:C	I
    //   34: iconst_1
    //   35: iadd
    //   36: putfield 105	com/tencent/mm/sdk/b/c:C	I
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: areturn
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 107	com/tencent/mm/sdk/b/c:D	I
    //   48: iconst_1
    //   49: iadd
    //   50: putfield 107	com/tencent/mm/sdk/b/c:D	I
    //   53: aload_0
    //   54: monitorexit
    //   55: aconst_null
    //   56: astore_1
    //   57: goto -16 -> 41
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	c
    //   0	65	1	paramK	K
    // Exception table:
    //   from	to	target	type
    //   16	25	60	finally
    //   29	41	60	finally
    //   43	55	60	finally
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.A += 1;
      this.size += 1;
      paramK = this.u.put(paramK, paramV);
      if (paramK != null) {
        this.size -= 1;
      }
      trimToSize(this.v);
      return paramK;
    }
    finally {}
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.C + this.D;
      if (j != 0) {
        i = this.C * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.v), Integer.valueOf(this.C), Integer.valueOf(this.D), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */