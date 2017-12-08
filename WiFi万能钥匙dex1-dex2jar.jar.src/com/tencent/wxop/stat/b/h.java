package com.tencent.wxop.stat.b;

public class h
{
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      cH = bool;
      return;
    }
  }
  
  public static byte[] d(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    j localj = new j(new byte[i * 3 / 4]);
    if (!localj.a(paramArrayOfByte, i)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localj.g == localj.cI.length) {
      paramArrayOfByte = localj.cI;
    }
    for (;;)
    {
      return paramArrayOfByte;
      paramArrayOfByte = new byte[localj.g];
      System.arraycopy(localj.cI, 0, paramArrayOfByte, 0, localj.g);
    }
  }
  
  public static byte[] e(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    k localk = new k();
    int j = k / 3 * 4;
    int i;
    int m;
    if (localk.ba)
    {
      i = j;
      if (k % 3 > 0) {
        i = j + 4;
      }
      j = i;
      if (localk.bb)
      {
        j = i;
        if (k > 0)
        {
          m = (k - 1) / 57;
          if (!localk.cP) {
            break label171;
          }
        }
      }
    }
    label171:
    for (j = 2;; j = 1)
    {
      j = i + j * (m + 1);
      localk.cI = new byte[j];
      localk.a(paramArrayOfByte, k);
      if ((cH) || (localk.g == j)) {
        break label176;
      }
      throw new AssertionError();
      i = j;
      switch (k % 3)
      {
      case 0: 
      default: 
        i = j;
        break;
      case 1: 
        i = j + 2;
        break;
      case 2: 
        i = j + 3;
        break;
      }
    }
    label176:
    return localk.cI;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */