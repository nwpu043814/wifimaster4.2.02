package com.wifipay.wallet.authentication.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class a
{
  private static Bitmap a(int paramInt, Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  private static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int j = localOptions.outHeight;
    int i = localOptions.outWidth;
    if ((j > paramInt2) || (i > paramInt1))
    {
      int k = j / 2;
      int m = i / 2;
      i = 1;
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
    j = 1;
    localOptions.inSampleSize = j;
    localOptions.inJustDecodeBounds = false;
    paramInt2 = (int)Math.ceil(localOptions.outHeight / paramInt2);
    paramInt1 = (int)Math.ceil(localOptions.outWidth / paramInt1);
    if ((paramInt2 > 1) || (paramInt1 > 1)) {
      if (paramInt2 <= paramInt1) {
        break label168;
      }
    }
    label168:
    for (localOptions.inSampleSize = paramInt2;; localOptions.inSampleSize = paramInt1)
    {
      localOptions.inJustDecodeBounds = false;
      return BitmapFactory.decodeFile(paramString, localOptions);
    }
  }
  
  public static File a(File paramFile)
  {
    String str = paramFile.getAbsolutePath();
    int n = b(str);
    int j = a(str)[0];
    int k = a(str)[1];
    int i = j;
    if (j % 2 == 1) {
      i = j + 1;
    }
    j = k;
    if (k % 2 == 1) {
      j = k + 1;
    }
    int m;
    if (i > j)
    {
      m = j;
      if (i <= j) {
        break label147;
      }
    }
    File localFile;
    label147:
    for (k = i;; k = j)
    {
      d1 = m / k;
      if ((d1 > 1.0D) || (d1 <= 0.5625D)) {
        break label424;
      }
      if (k >= 1664) {
        break label209;
      }
      if (paramFile.length() / 1024L >= 150L) {
        break label154;
      }
      localFile = paramFile;
      return localFile;
      m = i;
      break;
    }
    label154:
    double d2 = k * m / Math.pow(1664.0D, 2.0D) * 150.0D;
    double d1 = d2;
    if (d2 < 60.0D) {
      d1 = 60.0D;
    }
    for (;;)
    {
      localFile = a(str, str, i, j, n, d1);
      break;
      label209:
      if ((k >= 1664) && (k < 4990))
      {
        i = m / 2;
        j = k / 2;
        d2 = i * j / Math.pow(2495.0D, 2.0D) * 300.0D;
        d1 = d2;
        if (d2 < 60.0D) {
          d1 = 60.0D;
        }
      }
      else if ((k >= 4990) && (k < 10240))
      {
        i = m / 4;
        j = k / 4;
        d2 = i * j / Math.pow(2560.0D, 2.0D) * 300.0D;
        d1 = d2;
        if (d2 < 100.0D) {
          d1 = 100.0D;
        }
      }
      else
      {
        if (k / 1280 == 0) {}
        for (i = 1;; i = k / 1280)
        {
          j = m / i;
          k /= i;
          d2 = j * k / Math.pow(2560.0D, 2.0D) * 300.0D;
          d1 = d2;
          if (d2 < 100.0D) {
            d1 = 100.0D;
          }
          i = j;
          j = k;
          break;
        }
        label424:
        if ((d1 <= 0.5625D) && (d1 > 0.5D))
        {
          if (k < 1280)
          {
            localFile = paramFile;
            if (paramFile.length() / 1024L < 200L) {
              break;
            }
          }
          if (k / 1280 == 0) {}
          for (i = 1;; i = k / 1280)
          {
            j = m / i;
            k /= i;
            d2 = j * k / 3686400.0D * 400.0D;
            d1 = d2;
            if (d2 < 100.0D) {
              d1 = 100.0D;
            }
            i = j;
            j = k;
            break;
          }
        }
        j = (int)Math.ceil(k / (1280.0D / d1));
        i = m / j;
        j = k / j;
        d2 = i * j / (1280.0D / d1 * 1280.0D) * 500.0D;
        d1 = d2;
        if (d2 < 100.0D) {
          d1 = 100.0D;
        }
      }
    }
  }
  
  private static File a(String paramString, Bitmap paramBitmap, long paramLong)
  {
    int i = 100;
    c.a(paramBitmap, "tangbitmap cannot be null");
    Object localObject = new File(paramString.substring(0, paramString.lastIndexOf("/")));
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
      while ((((ByteArrayOutputStream)localObject).toByteArray().length / 1024 > paramLong * 0.8D) && (i > 6))
      {
        ((ByteArrayOutputStream)localObject).reset();
        i -= 6;
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, (OutputStream)localObject);
      }
      paramBitmap.recycle();
      try
      {
        paramBitmap = new java/io/FileOutputStream;
        paramBitmap.<init>(paramString);
        paramBitmap.write(((ByteArrayOutputStream)localObject).toByteArray());
        paramBitmap.flush();
        paramBitmap.close();
        ((ByteArrayOutputStream)localObject).close();
        paramString = new File(paramString);
      }
      catch (IOException paramBitmap)
      {
        for (;;)
        {
          paramBitmap.printStackTrace();
        }
      }
    }
  }
  
  private static File a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return a(paramString2, a(paramInt3, a(paramString1, paramInt1, paramInt2)), paramLong);
  }
  
  private static int[] a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inSampleSize = 1;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new int[] { localOptions.outWidth, localOptions.outHeight };
  }
  
  private static int b(String paramString)
  {
    j = 0;
    for (;;)
    {
      try
      {
        ExifInterface localExifInterface = new android/media/ExifInterface;
        localExifInterface.<init>(paramString);
        int k = localExifInterface.getAttributeInt("Orientation", 1);
        i = j;
        switch (k)
        {
        default: 
          i = j;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        int i = j;
        continue;
      }
      return i;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/authentication/tools/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */