package com.wifi.plugin.a;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public final class a
{
  public static void a(InputStream paramInputStream, File paramFile)
  {
    paramFile = new BufferedOutputStream(new FileOutputStream(paramFile));
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1)
      {
        paramFile.close();
        return;
      }
      paramFile.write(arrayOfByte, 0, i);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */