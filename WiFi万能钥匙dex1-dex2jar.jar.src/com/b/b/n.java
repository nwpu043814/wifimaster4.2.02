package com.b.b;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

public final class n
{
  static final Charset a = Charset.forName("UTF-8");
  static final Charset b = Charset.forName("ISO-8859-1");
  public static final byte[] c;
  public static final ByteBuffer d;
  public static final g e = g.a(c);
  
  static
  {
    byte[] arrayOfByte = new byte[0];
    c = arrayOfByte;
    d = ByteBuffer.wrap(arrayOfByte);
  }
  
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    for (int i = paramInt2; i < paramInt2 + paramInt3; i++) {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
    }
    return paramInt1;
  }
  
  public static int a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1231;; i = 1237) {
      return i;
    }
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = a(i, paramArrayOfByte, 0, i);
    i = j;
    if (j == 0) {
      i = 1;
    }
    return i;
  }
  
  public static abstract interface a
  {
    public abstract int a();
  }
  
  public static abstract interface b<E>
    extends List<E>, RandomAccess
  {
    public abstract b<E> a(int paramInt);
    
    public abstract boolean a();
    
    public abstract void b();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */