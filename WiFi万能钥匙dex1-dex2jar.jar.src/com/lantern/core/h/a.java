package com.lantern.core.h;

import com.b.b.o;
import com.bluefay.b.h;
import com.c.d.a.a.a.b.a;
import com.lantern.core.model.e;

public final class a
  extends e
{
  private int a = -1;
  private byte[] b;
  
  public a(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramArrayOfByte;
    if (this.a == -1) {}
    try
    {
      paramArrayOfByte = b.a.a(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        a(paramArrayOfByte.l());
        b(paramArrayOfByte.m());
      }
      return;
    }
    catch (o paramArrayOfByte)
    {
      for (;;)
      {
        h.a(paramArrayOfByte);
        a("-2");
        b("InvalidProtocolBufferException");
      }
    }
  }
  
  public final boolean c()
  {
    if (this.a == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final byte[] g()
  {
    return this.b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */