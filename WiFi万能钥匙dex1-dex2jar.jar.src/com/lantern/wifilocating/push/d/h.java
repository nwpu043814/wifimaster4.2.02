package com.lantern.wifilocating.push.d;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public final class h
  extends b
{
  public static String a(Map<String, String> paramMap, String paramString)
  {
    Object[] arrayOfObject = paramMap.keySet().toArray();
    Arrays.sort(arrayOfObject);
    StringBuffer localStringBuffer = new StringBuffer();
    int j = arrayOfObject.length;
    for (int i = 0; i < j; i++) {
      localStringBuffer.append((String)paramMap.get(arrayOfObject[i]));
    }
    localStringBuffer.append(paramString);
    return a(localStringBuffer.toString());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */