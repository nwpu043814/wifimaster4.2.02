package c.a.a;

public final class q
{
  private byte[] a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public q(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.b = 0;
    this.c = this.a.length;
    this.d = -1;
    this.e = -1;
  }
  
  private void e(int paramInt)
  {
    if (paramInt > b()) {
      throw new db("end of input");
    }
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > this.a.length - this.b) {
      throw new IllegalArgumentException("cannot set active region past end of input");
    }
    this.c = (this.b + paramInt);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    e(paramInt2);
    System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, paramInt2);
    this.b += paramInt2;
  }
  
  public final int b()
  {
    return this.c - this.b;
  }
  
  public final void b(int paramInt)
  {
    if (paramInt > this.a.length) {
      throw new IllegalArgumentException("cannot set active region past end of input");
    }
    this.c = paramInt;
  }
  
  public final void c()
  {
    this.c = this.a.length;
  }
  
  public final void c(int paramInt)
  {
    if (paramInt >= this.a.length) {
      throw new IllegalArgumentException("cannot jump past end of input");
    }
    this.b = paramInt;
    this.c = this.a.length;
  }
  
  public final int d()
  {
    return this.c;
  }
  
  public final byte[] d(int paramInt)
  {
    e(paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(this.a, this.b, arrayOfByte, 0, paramInt);
    this.b += paramInt;
    return arrayOfByte;
  }
  
  public final void e()
  {
    this.d = this.b;
    this.e = this.c;
  }
  
  public final void f()
  {
    if (this.d < 0) {
      throw new IllegalStateException("no previous state");
    }
    this.b = this.d;
    this.c = this.e;
    this.d = -1;
    this.e = -1;
  }
  
  public final int g()
  {
    e(1);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public final int h()
  {
    e(2);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.a;
    int j = this.b;
    this.b = (j + 1);
    return ((i & 0xFF) << 8) + (arrayOfByte[j] & 0xFF);
  }
  
  public final long i()
  {
    e(4);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.a;
    int j = this.b;
    this.b = (j + 1);
    j = arrayOfByte[j];
    arrayOfByte = this.a;
    int k = this.b;
    this.b = (k + 1);
    k = arrayOfByte[k];
    arrayOfByte = this.a;
    int m = this.b;
    this.b = (m + 1);
    m = arrayOfByte[m];
    long l = i & 0xFF;
    return ((j & 0xFF) << 16) + (l << 24) + ((k & 0xFF) << 8) + (m & 0xFF);
  }
  
  public final byte[] j()
  {
    int i = b();
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.a, this.b, arrayOfByte, 0, i);
    this.b = (i + this.b);
    return arrayOfByte;
  }
  
  public final byte[] k()
  {
    e(1);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    return d(arrayOfByte[i] & 0xFF);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */