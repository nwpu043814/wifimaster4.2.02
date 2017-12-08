package c.a.a;

public final class s
{
  private byte[] a = new byte[32];
  private int b = 0;
  private int c = -1;
  
  private s() {}
  
  public s(byte paramByte)
  {
    this();
  }
  
  private static void a(long paramLong, int paramInt)
  {
    if ((paramLong < 0L) || (paramLong > 1L << paramInt)) {
      throw new IllegalArgumentException(paramLong + " out of range for " + paramInt + " bit value");
    }
  }
  
  private void d(int paramInt)
  {
    if (this.a.length - this.b >= paramInt) {}
    for (;;)
    {
      return;
      int j = this.a.length * 2;
      int i = j;
      if (j < this.b + paramInt) {
        i = this.b + paramInt;
      }
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
      this.a = arrayOfByte;
    }
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > this.b) {
      throw new IllegalArgumentException("cannot jump past end of data");
    }
    this.b = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, 16);
    if (paramInt2 > this.b - 2) {
      throw new IllegalArgumentException("cannot write past end of data");
    }
    this.a[paramInt2] = ((byte)(paramInt1 >>> 8 & 0xFF));
    this.a[(paramInt2 + 1)] = ((byte)(paramInt1 & 0xFF));
  }
  
  public final void a(long paramLong)
  {
    a(paramLong, 32);
    d(4);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    d(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
    this.b += paramInt2;
  }
  
  public final void b(int paramInt)
  {
    a(paramInt, 8);
    d(1);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
  
  public final void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 255) {
      throw new IllegalArgumentException("Invalid counted string");
    }
    d(paramArrayOfByte.length + 1);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramArrayOfByte.length & 0xFF));
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final byte[] b()
  {
    byte[] arrayOfByte = new byte[this.b];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    return arrayOfByte;
  }
  
  public final void c(int paramInt)
  {
    a(paramInt, 16);
    d(2);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */