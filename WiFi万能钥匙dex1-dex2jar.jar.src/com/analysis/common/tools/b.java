package com.analysis.common.tools;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.util.UUID;

public final class b
{
  private static String a = null;
  private static final String b = "INSTALLATION-" + UUID.nameUUIDFromBytes("androidkit".getBytes());
  
  private static String a()
  {
    String str3 = "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
    try
    {
      String str1 = Build.class.getField("SERIAL").get(null).toString();
      UUID localUUID = new java/util/UUID;
      localUUID.<init>(str3.hashCode(), str1.hashCode());
      str1 = localUUID.toString();
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = new UUID(str3.hashCode(), "serial".hashCode()).toString();
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      File localFile;
      if (a == null)
      {
        localFile = new java/io/File;
        localFile.<init>(paramContext.getFilesDir(), b);
      }
      try
      {
        if (!localFile.exists())
        {
          FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
          localFileOutputStream.<init>(localFile);
          localObject = UUID.nameUUIDFromBytes(Settings.Secure.getString(paramContext.getContentResolver(), "android_id").getBytes()).toString();
          paramContext = (Context)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramContext = a();
          }
          localFileOutputStream.write(paramContext.getBytes());
          localFileOutputStream.close();
        }
        Object localObject = new java/io/RandomAccessFile;
        ((RandomAccessFile)localObject).<init>(localFile, "r");
        paramContext = new byte[(int)((RandomAccessFile)localObject).length()];
        ((RandomAccessFile)localObject).readFully(paramContext);
        ((RandomAccessFile)localObject).close();
        localObject = new java/lang/String;
        ((String)localObject).<init>(paramContext);
        a = (String)localObject;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private static String a(File paramFile)
  {
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
    paramFile = new byte[(int)localRandomAccessFile.length()];
    localRandomAccessFile.readFully(paramFile);
    localRandomAccessFile.close();
    return new String(paramFile);
  }
  
  private static void a(Context paramContext, File paramFile)
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    paramFile = UUID.nameUUIDFromBytes(Settings.Secure.getString(paramContext.getContentResolver(), "android_id").getBytes()).toString();
    paramContext = paramFile;
    if (TextUtils.isEmpty(paramFile)) {
      paramContext = a();
    }
    localFileOutputStream.write(paramContext.getBytes());
    localFileOutputStream.close();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/tools/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */