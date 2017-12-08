package com.lantern.wifilocating.push.b.a;

import com.lantern.wifilocating.push.b.d.c;

public class f
{
  private static f a;
  
  public static f a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        f localf = new com/lantern/wifilocating/push/b/a/f;
        localf.<init>();
        a = localf;
      }
      return a;
    }
    finally {}
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    new Thread(new c(new g(this), paramBoolean, paramInt)).start();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */