package com.alipay.c.a.a.a.a;

import com.alipay.c.a.a.a.a;
import java.security.MessageDigest;

public final class b
{
  public static String a(String paramString)
  {
    localObject1 = null;
    int i = 0;
    for (;;)
    {
      try
      {
        if (!a.a(paramString)) {
          continue;
        }
        paramString = (String)localObject1;
      }
      catch (Exception paramString)
      {
        Object localObject2;
        paramString = (String)localObject1;
        continue;
      }
      return paramString;
      localObject2 = MessageDigest.getInstance("SHA-1");
      ((MessageDigest)localObject2).update(paramString.getBytes("UTF-8"));
      localObject2 = ((MessageDigest)localObject2).digest();
      paramString = new java/lang/StringBuilder;
      paramString.<init>();
      if (i < localObject2.length)
      {
        paramString.append(String.format("%02x", new Object[] { Byte.valueOf(localObject2[i]) }));
        i++;
      }
      else
      {
        paramString = paramString.toString();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */