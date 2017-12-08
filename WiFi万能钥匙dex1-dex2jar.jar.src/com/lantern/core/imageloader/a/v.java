package com.lantern.core.imageloader.a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class v
  extends InputStream
{
  private final InputStream a;
  private long b;
  private long c;
  private long d;
  private long e = -1L;
  
  public v(InputStream paramInputStream)
  {
    this(paramInputStream, (byte)0);
  }
  
  private v(InputStream paramInputStream, byte paramByte)
  {
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      localObject = new BufferedInputStream(paramInputStream, 4096);
    }
    this.a = ((InputStream)localObject);
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    while (paramLong1 < paramLong2)
    {
      long l2 = this.a.skip(paramLong2 - paramLong1);
      long l1 = l2;
      if (l2 == 0L)
      {
        if (read() == -1) {
          break;
        }
        l1 = 1L;
      }
      paramLong1 += l1;
    }
  }
  
  /* Error */
  public final long a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/lantern/core/imageloader/a/v:b	J
    //   4: iload_1
    //   5: i2l
    //   6: ladd
    //   7: lstore_2
    //   8: aload_0
    //   9: getfield 51	com/lantern/core/imageloader/a/v:d	J
    //   12: lload_2
    //   13: lcmp
    //   14: ifge +65 -> 79
    //   17: aload_0
    //   18: getfield 53	com/lantern/core/imageloader/a/v:c	J
    //   21: aload_0
    //   22: getfield 49	com/lantern/core/imageloader/a/v:b	J
    //   25: lcmp
    //   26: ifge +58 -> 84
    //   29: aload_0
    //   30: getfield 49	com/lantern/core/imageloader/a/v:b	J
    //   33: aload_0
    //   34: getfield 51	com/lantern/core/imageloader/a/v:d	J
    //   37: lcmp
    //   38: ifgt +46 -> 84
    //   41: aload_0
    //   42: getfield 35	com/lantern/core/imageloader/a/v:a	Ljava/io/InputStream;
    //   45: invokevirtual 56	java/io/InputStream:reset	()V
    //   48: aload_0
    //   49: getfield 35	com/lantern/core/imageloader/a/v:a	Ljava/io/InputStream;
    //   52: lload_2
    //   53: aload_0
    //   54: getfield 53	com/lantern/core/imageloader/a/v:c	J
    //   57: lsub
    //   58: l2i
    //   59: invokevirtual 60	java/io/InputStream:mark	(I)V
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 53	com/lantern/core/imageloader/a/v:c	J
    //   67: aload_0
    //   68: getfield 49	com/lantern/core/imageloader/a/v:b	J
    //   71: invokespecial 62	com/lantern/core/imageloader/a/v:a	(JJ)V
    //   74: aload_0
    //   75: lload_2
    //   76: putfield 51	com/lantern/core/imageloader/a/v:d	J
    //   79: aload_0
    //   80: getfield 49	com/lantern/core/imageloader/a/v:b	J
    //   83: lreturn
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 49	com/lantern/core/imageloader/a/v:b	J
    //   89: putfield 53	com/lantern/core/imageloader/a/v:c	J
    //   92: aload_0
    //   93: getfield 35	com/lantern/core/imageloader/a/v:a	Ljava/io/InputStream;
    //   96: lload_2
    //   97: aload_0
    //   98: getfield 49	com/lantern/core/imageloader/a/v:b	J
    //   101: lsub
    //   102: l2i
    //   103: invokevirtual 60	java/io/InputStream:mark	(I)V
    //   106: goto -32 -> 74
    //   109: astore 4
    //   111: new 64	java/lang/IllegalStateException
    //   114: dup
    //   115: new 66	java/lang/StringBuilder
    //   118: dup
    //   119: ldc 68
    //   121: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload 4
    //   126: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokespecial 80	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	v
    //   0	136	1	paramInt	int
    //   7	90	2	l	long
    //   109	16	4	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   17	74	109	java/io/IOException
    //   74	79	109	java/io/IOException
    //   84	106	109	java/io/IOException
  }
  
  public final void a(long paramLong)
  {
    if ((this.b > this.d) || (paramLong < this.c)) {
      throw new IOException("Cannot reset");
    }
    this.a.reset();
    a(this.c, paramLong);
    this.b = paramLong;
  }
  
  public final int available()
  {
    return this.a.available();
  }
  
  public final void close()
  {
    this.a.close();
  }
  
  public final void mark(int paramInt)
  {
    this.e = a(paramInt);
  }
  
  public final boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  public final int read()
  {
    int i = this.a.read();
    if (i != -1) {
      this.b += 1L;
    }
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    int i = this.a.read(paramArrayOfByte);
    if (i != -1) {
      this.b += i;
    }
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      this.b += paramInt1;
    }
    return paramInt1;
  }
  
  public final void reset()
  {
    a(this.e);
  }
  
  public final long skip(long paramLong)
  {
    paramLong = this.a.skip(paramLong);
    this.b += paramLong;
    return paramLong;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */