package com.lantern.d;

import com.bluefay.b.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class a
{
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    paramOutputStream = new GZIPOutputStream(paramOutputStream);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    paramOutputStream.finish();
    paramOutputStream.close();
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramArrayOfByte, localByteArrayOutputStream);
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    GZIPInputStream localGZIPInputStream;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new java/io/ByteArrayInputStream;
      localByteArrayInputStream.<init>(paramArrayOfByte);
      localGZIPInputStream = new java/util/zip/GZIPInputStream;
      localGZIPInputStream.<init>(localByteArrayInputStream);
      paramArrayOfByte = new byte['Ѐ'];
      localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      for (;;)
      {
        int i = localGZIPInputStream.read(paramArrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
      }
      h.a(localException1);
    }
    catch (Exception localException1)
    {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        localGZIPInputStream.close();
        localException1.close();
      }
      catch (Exception localException2) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */