package com.lantern.wifilocating.push.h;

public enum d
{
  private String c;
  
  private d(String paramString)
  {
    this.c = paramString;
  }
  
  public static d a(int paramInt)
  {
    Object localObject = String.valueOf(paramInt);
    if ("0".equals(localObject)) {
      localObject = a;
    }
    for (;;)
    {
      return (d)localObject;
      if ("1".equals(localObject)) {
        localObject = b;
      } else {
        localObject = null;
      }
    }
  }
  
  public final String a()
  {
    return this.c;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */