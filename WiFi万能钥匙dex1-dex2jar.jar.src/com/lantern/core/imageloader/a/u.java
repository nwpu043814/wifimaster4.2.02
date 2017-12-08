package com.lantern.core.imageloader.a;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class u
  implements j
{
  final LinkedHashMap<String, Bitmap> b;
  private final int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  private u(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max size must be positive.");
    }
    this.c = paramInt;
    this.b = new LinkedHashMap(0, 0.75F, true);
  }
  
  public u(Context paramContext)
  {
    this(at.c(paramContext));
  }
  
  private void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.d < 0) || ((this.b.isEmpty()) && (this.d != 0)))
        {
          IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          localIllegalStateException.<init>(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
          throw localIllegalStateException;
        }
      }
      finally {}
      if ((this.d <= paramInt) || (this.b.isEmpty())) {
        return;
      }
      Object localObject2 = (Map.Entry)this.b.entrySet().iterator().next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (Bitmap)((Map.Entry)localObject2).getValue();
      this.b.remove(str);
      this.d -= at.a((Bitmap)localObject2);
      this.f += 1;
    }
  }
  
  public final int a()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 120	java/lang/NullPointerException
    //   7: dup
    //   8: ldc 122
    //   10: invokespecial 123	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 38	com/lantern/core/imageloader/a/u:b	Ljava/util/LinkedHashMap;
    //   20: aload_1
    //   21: invokevirtual 126	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 107	android/graphics/Bitmap
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +17 -> 46
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 128	com/lantern/core/imageloader/a/u:g	I
    //   37: iconst_1
    //   38: iadd
    //   39: putfield 128	com/lantern/core/imageloader/a/u:g	I
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 130	com/lantern/core/imageloader/a/u:h	I
    //   51: iconst_1
    //   52: iadd
    //   53: putfield 130	com/lantern/core/imageloader/a/u:h	I
    //   56: aload_0
    //   57: monitorexit
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -16 -> 44
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	u
    //   0	68	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   16	28	63	finally
    //   32	44	63	finally
    //   46	58	63	finally
    //   64	66	63	finally
  }
  
  public final void a(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramBitmap == null)) {
      throw new NullPointerException("key == null || bitmap == null");
    }
    try
    {
      this.e += 1;
      this.d += at.a(paramBitmap);
      paramString = (Bitmap)this.b.put(paramString, paramBitmap);
      if (paramString != null) {
        this.d -= at.a(paramString);
      }
      a(this.c);
      return;
    }
    finally {}
  }
  
  public final int b()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void c()
  {
    try
    {
      a(-1);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */