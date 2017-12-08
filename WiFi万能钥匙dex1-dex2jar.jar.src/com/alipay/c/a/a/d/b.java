package com.alipay.c.a.a.d;

import com.alipay.c.a.a.a.a;
import java.io.File;

public final class b
{
  public static String a(String paramString)
  {
    Object localObject1 = "";
    try
    {
      localObject2 = System.getProperty(paramString);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (a.a((String)localObject1)) {
      localObject2 = c.a(".SystemConfig" + File.separator + paramString);
    }
    return (String)localObject2;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */