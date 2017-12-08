package com.lantern.traffic.statistics.b;

public enum b
{
  private int c = 1;
  private String d;
  
  private b(int paramInt, String paramString)
  {
    this.d = paramInt;
  }
  
  public static b a(int paramInt)
  {
    b[] arrayOfb = values();
    int i;
    b localb;
    if (arrayOfb != null)
    {
      int j = arrayOfb.length;
      i = 0;
      if (i < j)
      {
        localb = arrayOfb[i];
        if (paramInt != localb.c) {}
      }
    }
    for (;;)
    {
      return localb;
      i++;
      break;
      localb = a;
    }
  }
  
  public final int a()
  {
    return this.c;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/statistics/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */