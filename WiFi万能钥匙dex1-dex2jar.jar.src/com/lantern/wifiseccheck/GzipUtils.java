package com.lantern.wifiseccheck;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtils
{
  private static final String TAG = "SecCheckHttpApi";
  private static GzipUtils mGzipUtils = new GzipUtils();
  
  public static GzipUtils getInstance()
  {
    return mGzipUtils;
  }
  
  public void compressByte(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    paramOutputStream = new GZIPOutputStream(paramOutputStream);
    paramOutputStream.write(paramArrayOfByte);
    paramOutputStream.finish();
    paramOutputStream.flush();
    paramOutputStream.close();
  }
  
  public void compressString(OutputStream paramOutputStream, String paramString)
  {
    paramOutputStream = new GZIPOutputStream(paramOutputStream);
    paramOutputStream.write(paramString.getBytes("UTF-8"));
    paramOutputStream.finish();
    paramOutputStream.flush();
    paramOutputStream.close();
  }
  
  public byte[] gZip(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
        localByteArrayOutputStream.<init>();
        GZIPOutputStream localGZIPOutputStream = new java/util/zip/GZIPOutputStream;
        localGZIPOutputStream.<init>(localByteArrayOutputStream);
        localGZIPOutputStream.write(paramArrayOfByte);
        localGZIPOutputStream.finish();
        localGZIPOutputStream.close();
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localByteArrayOutputStream.close();
          return paramArrayOfByte;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
        localException1 = localException1;
        paramArrayOfByte = null;
      }
    }
  }
  
  public byte[] toByteArray(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public byte[] unGZip(byte[] paramArrayOfByte)
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
      localException1.printStackTrace();
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
  
  public String uncompress(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null) {
      if (paramString.length() != 0) {
        break label17;
      }
    }
    for (localObject = paramString;; localObject = ((ByteArrayOutputStream)localObject).toString("utf-8"))
    {
      return (String)localObject;
      label17:
      localObject = new ByteArrayOutputStream();
      paramString = new GZIPInputStream(new ByteArrayInputStream(paramString.getBytes("UTF-8")));
      byte[] arrayOfByte = new byte['Ā'];
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i < 0) {
          break;
        }
        ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i);
      }
    }
  }
  
  public byte[] uncompress(InputStream paramInputStream)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      try
      {
        GZIPInputStream localGZIPInputStream = new java/util/zip/GZIPInputStream;
        localGZIPInputStream.<init>(paramInputStream);
        byte[] arrayOfByte = new byte['Ā'];
        for (;;)
        {
          int i = localGZIPInputStream.read(arrayOfByte);
          paramInputStream = localByteArrayOutputStream;
          if (i <= 0) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        localIOException2.printStackTrace();
      }
      catch (IOException localIOException2)
      {
        paramInputStream = localByteArrayOutputStream;
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        paramInputStream = null;
        IOException localIOException3 = localIOException1;
      }
    }
    LogUtils.d("SecCheckHttpApi", localIOException2.toString());
    return paramInputStream.toByteArray();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/GzipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */