package com.alipay.sdk.j;

public enum d
{
  public String p;
  private int q;
  
  private d(int paramInt1, String paramString1)
  {
    this.q = paramInt1;
    this.p = paramString1;
  }
  
  public static d a(int paramInt)
  {
    d[] arrayOfd = values();
    int i2 = arrayOfd.length;
    int i1 = 0;
    d locald;
    if (i1 < i2)
    {
      locald = arrayOfd[i1];
      if (locald.q != paramInt) {}
    }
    for (;;)
    {
      return locald;
      i1++;
      break;
      locald = o;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/j/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */