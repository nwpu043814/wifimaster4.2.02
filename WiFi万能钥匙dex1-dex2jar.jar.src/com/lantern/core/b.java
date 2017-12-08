package com.lantern.core;

import com.bluefay.b.h;
import com.lantern.core.config.ABTestConf;
import com.lantern.core.config.d;

public final class b
{
  public static String a()
  {
    String str2 = a("pb_cd", "C,C", c.getServer().g());
    String str1 = str2;
    if (!"B".equals(str2))
    {
      str1 = str2;
      if (!"C".equals(str2)) {
        if (!"D".equals(str2)) {
          break label49;
        }
      }
    }
    label49:
    for (str1 = str2;; str1 = "C") {
      return str1;
    }
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    String str = f.a().a(paramString1);
    Object localObject;
    if ((str == null) || (str.length() == 0))
    {
      localObject = (ABTestConf)d.a(c.getAppContext()).a(ABTestConf.class);
      if (localObject != null) {
        str = ((ABTestConf)localObject).a(paramString1);
      }
    }
    for (;;)
    {
      localObject = paramString2;
      if (str != null) {
        if (str.length() != 0) {
          break label141;
        }
      }
      label141:
      for (localObject = paramString2;; localObject = str)
      {
        h.a("%s:%s", new Object[] { paramString1, localObject });
        paramString1 = ((String)localObject).split(",");
        int j = paramString1.length;
        int i = Math.abs(paramString3.hashCode());
        h.a("mode:" + i % j, new Object[0]);
        return paramString1[(i % j)];
      }
    }
  }
  
  public static String b()
  {
    String str2 = a("pb_kk", "k,k", c.getServer().g());
    String str1 = str2;
    if (!"k".equals(str2)) {
      if (!"l".equals(str2)) {
        break label38;
      }
    }
    label38:
    for (str1 = str2;; str1 = "k") {
      return str1;
    }
  }
  
  public static String c()
  {
    Object localObject = c.getServer().g();
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      localObject = "C";
    }
    for (;;)
    {
      return (String)localObject;
      String str = a("nearbyap", "A,B,C", (String)localObject);
      localObject = str;
      if (!"A".equals(str))
      {
        localObject = str;
        if (!"B".equals(str))
        {
          localObject = str;
          if (!"C".equals(str)) {
            localObject = "C";
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */