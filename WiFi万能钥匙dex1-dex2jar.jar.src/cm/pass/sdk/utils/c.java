package cm.pass.sdk.utils;

import android.os.Build;

public class c
{
  public static int a(a parama)
  {
    int i;
    switch (c.1.a[parama.ordinal()])
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public static a a()
  {
    Object localObject = Build.BRAND;
    if (((String)localObject).equalsIgnoreCase("samsung")) {
      localObject = a.b;
    }
    for (;;)
    {
      return (a)localObject;
      if (((String)localObject).equalsIgnoreCase("Huawei")) {
        localObject = a.c;
      } else {
        localObject = a.a;
      }
    }
  }
  
  public static int b()
  {
    return a(a());
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */