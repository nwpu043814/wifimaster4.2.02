package com.lantern.wifilocating.push.f;

import org.json.JSONArray;

public class a
{
  private static a a;
  private static long b = 0L;
  private a c = new a((byte)0);
  private boolean d = true;
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a locala = new com/lantern/wifilocating/push/f/a;
        locala.<init>();
        a = locala;
      }
      return a;
    }
    finally {}
  }
  
  private void a(String paramString, JSONArray paramJSONArray, int paramInt)
  {
    if (paramInt == 0) {
      com.lantern.wifilocating.push.a.a.c().b(paramString, paramJSONArray);
    }
    for (;;)
    {
      return;
      if (paramInt == 2)
      {
        com.lantern.wifilocating.push.a.a.c().a(paramString, paramJSONArray);
      }
      else
      {
        com.lantern.wifilocating.push.a.a.c().b(paramString, paramJSONArray);
        b();
      }
    }
  }
  
  public static void a(String paramString, JSONArray paramJSONArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      a().a(paramString, paramJSONArray, paramInt2);
    }
    for (;;)
    {
      return;
      a().a(paramString, paramJSONArray, 1);
    }
  }
  
  public final void b()
  {
    b localb = new b(this);
    f.a().a(localb);
  }
  
  private final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      if (a.a(a.this)) {
        a.a(a.this, false);
      }
      a.d();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */