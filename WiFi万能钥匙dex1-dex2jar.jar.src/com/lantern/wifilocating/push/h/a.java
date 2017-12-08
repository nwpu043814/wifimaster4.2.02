package com.lantern.wifilocating.push.h;

import android.text.TextUtils;

public final class a
{
  private String a;
  private double b;
  private String c;
  private double d;
  private String e;
  private String f;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.e = paramString1;
    this.a = paramString2;
    this.c = paramString3;
    this.b = a(paramString2);
    this.d = a(paramString3);
    this.f = paramString4;
  }
  
  private static double a(String paramString)
  {
    try
    {
      d1 = Double.parseDouble(paramString);
      return d1;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        double d1 = 360.0D;
      }
    }
  }
  
  private static String b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      paramString = paramString.split("\\.");
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = localObject2;
        if (paramString.length == 2)
        {
          localObject1 = localObject2;
          if (paramString[1] != null)
          {
            localObject1 = localObject2;
            if (paramString[1].length() > 6) {
              localObject1 = paramString[0] + "." + paramString[1].substring(0, 6);
            }
          }
        }
      }
    }
    return (String)localObject1;
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final String b()
  {
    return this.a;
  }
  
  public final String c()
  {
    return this.e;
  }
  
  public final String d()
  {
    return this.f;
  }
  
  public final boolean e()
  {
    boolean bool2 = false;
    String str = this.e;
    double d2 = this.b;
    double d1 = this.d;
    boolean bool1;
    if (TextUtils.isEmpty(str)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (d2 <= 180.0D)
      {
        bool1 = bool2;
        if (d2 >= -180.0D)
        {
          bool1 = bool2;
          if (d2 != Double.MIN_VALUE)
          {
            bool1 = bool2;
            if (d1 <= 90.0D)
            {
              bool1 = bool2;
              if (d1 >= -90.0D)
              {
                bool1 = bool2;
                if (d1 != Double.MIN_VALUE) {
                  if (d2 == 0.0D)
                  {
                    bool1 = bool2;
                    if (d1 == 0.0D) {}
                  }
                  else
                  {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void f()
  {
    String str = b(this.a);
    if (str != null) {
      this.a = str;
    }
    str = b(this.c);
    if (str != null) {
      this.c = str;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */