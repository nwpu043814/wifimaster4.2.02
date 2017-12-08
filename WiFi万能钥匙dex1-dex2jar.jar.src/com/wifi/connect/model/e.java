package com.wifi.connect.model;

public final class e
{
  private String a;
  private int b;
  
  public e(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.a = str;
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.b = i;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof e)) {
      if ((((e)paramObject).a.equals(this.a)) && (((e)paramObject).b == this.b)) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = super.equals(paramObject);
    }
  }
  
  public final int hashCode()
  {
    return this.a.hashCode() + this.b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */