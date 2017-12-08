package com.lantern.launcher.task;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;

public final class b
{
  private static b a;
  private SharedPreferences b = com.lantern.core.c.getAppContext().getSharedPreferences("KEY_UID", 0);
  
  public static b a()
  {
    try
    {
      if (a == null)
      {
        localb = new com/lantern/launcher/task/b;
        localb.<init>();
        a = localb;
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    paramArrayOfByte = new ByteArrayOutputStream();
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = localGZIPInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      paramArrayOfByte.write(arrayOfByte, 0, i);
    }
    localGZIPInputStream.close();
    arrayOfByte = paramArrayOfByte.toByteArray();
    paramArrayOfByte.flush();
    paramArrayOfByte.close();
    localByteArrayInputStream.close();
    return arrayOfByte;
  }
  
  public final void b()
  {
    new Thread(new c(this)).start();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/task/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */