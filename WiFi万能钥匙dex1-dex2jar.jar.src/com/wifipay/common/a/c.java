package com.wifipay.common.a;

import java.io.FileReader;
import java.io.Reader;

public class c
{
  public static String a(Reader paramReader)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    char[] arrayOfChar = new char['က'];
    for (int i = paramReader.read(arrayOfChar); i >= 0; i = paramReader.read(arrayOfChar)) {
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    paramString = new FileReader(paramString);
    String str = a(paramString);
    paramString.close();
    return str;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */