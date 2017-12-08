package com.lantern.webox.c;

import com.bluefay.b.h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class a
{
  public static final String a = System.getProperty("line.separator");
  
  public static String a(InputStream paramInputStream)
  {
    StringBuffer localStringBuffer = new StringBuffer(300);
    BufferedReader localBufferedReader;
    try
    {
      localBufferedReader = new java/io/BufferedReader;
      InputStreamReader localInputStreamReader = new java/io/InputStreamReader;
      localInputStreamReader.<init>(paramInputStream, "utf-8");
      localBufferedReader.<init>(localInputStreamReader);
      for (;;)
      {
        paramInputStream = localBufferedReader.readLine();
        if (paramInputStream == null) {
          break;
        }
        localStringBuffer.append(paramInputStream).append(a);
      }
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      h.a(paramInputStream);
      paramInputStream = null;
    }
    for (;;)
    {
      localBufferedReader.close();
      paramInputStream = localStringBuffer.toString();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */