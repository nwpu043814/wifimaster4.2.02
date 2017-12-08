package com.linksure.apservice.a.b;

import android.content.Context;

public final class b
{
  private static com.linksure.apservice.a.b.a.a.a a;
  
  public static a a(Context paramContext)
  {
    return new com.linksure.apservice.a.b.a.a(e(paramContext));
  }
  
  public static d b(Context paramContext)
  {
    return new com.linksure.apservice.a.b.a.b(e(paramContext));
  }
  
  public static e c(Context paramContext)
  {
    return new com.linksure.apservice.a.b.b.b(paramContext.getApplicationContext(), "aps_file_cache");
  }
  
  public static c d(Context paramContext)
  {
    return new com.linksure.apservice.a.b.b.a(paramContext);
  }
  
  public static com.linksure.apservice.a.b.a.a.a e(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        com.linksure.apservice.a.b.a.a.b localb = new com/linksure/apservice/a/b/a/a/b;
        localb.<init>();
        a = localb;
        localb.a(paramContext.getApplicationContext());
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */