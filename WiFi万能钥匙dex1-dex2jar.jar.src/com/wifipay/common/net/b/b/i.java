package com.wifipay.common.net.b.b;

import java.io.ByteArrayOutputStream;

public class i
  extends ByteArrayOutputStream
{
  private final c a;
  
  public i(c paramc, int paramInt)
  {
    this.a = paramc;
    this.buf = this.a.a(Math.max(paramInt, 256));
  }
  
  private void a(int paramInt)
  {
    if (this.count + paramInt <= this.buf.length) {}
    for (;;)
    {
      return;
      byte[] arrayOfByte = this.a.a((this.count + paramInt) * 2);
      System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
      this.a.a(this.buf);
      this.buf = arrayOfByte;
    }
  }
  
  public void close()
  {
    this.a.a(this.buf);
    this.buf = null;
    super.close();
  }
  
  public void finalize()
  {
    this.a.a(this.buf);
  }
  
  public void write(int paramInt)
  {
    try
    {
      a(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */