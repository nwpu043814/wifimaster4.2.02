package com.tencent.wxop.stat;

public enum d
{
  int aI;
  
  private d(int paramInt)
  {
    this.aI = paramInt;
  }
  
  public static d a(int paramInt)
  {
    d[] arrayOfd = values();
    int j = arrayOfd.length;
    int i = 0;
    d locald;
    if (i < j)
    {
      locald = arrayOfd[i];
      if (paramInt != locald.aI) {}
    }
    for (;;)
    {
      return locald;
      i++;
      break;
      locald = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */