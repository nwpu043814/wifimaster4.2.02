package com.linksure.apservice.a.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class c
{
  private static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt2) {
          break;
        }
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      BitmapFactory.Options localOptions = new android/graphics/BitmapFactory$Options;
      localOptions.<init>();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      localOptions.inSampleSize = a(localOptions, paramInt1, paramInt2);
      localOptions.inJustDecodeBounds = false;
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public static File a(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    File localFile = a(paramString);
    try
    {
      paramString = new java/io/FileOutputStream;
      paramString.<init>(localFile);
      for (;;)
      {
        try
        {
          paramString.write(paramByteArrayOutputStream.toByteArray());
          paramString.flush();
          if (paramString == null) {}
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          if (paramString == null) {
            continue;
          }
          try
          {
            paramString.close();
            paramByteArrayOutputStream.close();
          }
          catch (IOException paramByteArrayOutputStream)
          {
            paramByteArrayOutputStream.printStackTrace();
          }
          continue;
        }
        finally
        {
          if (paramString == null) {
            continue;
          }
          try
          {
            paramString.close();
            paramByteArrayOutputStream.close();
          }
          catch (IOException paramByteArrayOutputStream)
          {
            paramByteArrayOutputStream.printStackTrace();
            continue;
          }
          throw ((Throwable)localObject);
          paramByteArrayOutputStream = null;
          continue;
        }
        try
        {
          paramString.close();
          paramByteArrayOutputStream.close();
        }
        catch (IOException paramByteArrayOutputStream)
        {
          paramByteArrayOutputStream.printStackTrace();
        }
      }
      if ((localFile.exists()) && (localFile.length() > 0L))
      {
        paramByteArrayOutputStream = localFile;
        return paramByteArrayOutputStream;
      }
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private static File a(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists()) {
      localFile.delete();
    }
    try
    {
      localFile.createNewFile();
      return localFile;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */