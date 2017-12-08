package com.a.a.a.a;

public final class c
{
  public static byte[] a(int paramInt)
  {
    int j = (byte)(paramInt % 256);
    paramInt >>= 8;
    int k = (byte)(paramInt % 256);
    paramInt >>= 8;
    int i = (byte)(paramInt % 256);
    return new byte[] { (byte)((paramInt >> 8) % 256), i, k, j };
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/a/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */