package com.lantern.settings.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.lantern.core.c;
import java.io.File;

public final class d
{
  public static long a(File paramFile)
  {
    long l1 = 0L;
    long l2;
    if (paramFile == null) {
      l2 = l1;
    }
    int j;
    int i;
    do
    {
      do
      {
        return l2;
        l2 = l1;
      } while (!paramFile.isDirectory());
      paramFile = paramFile.listFiles();
      j = paramFile.length;
      i = 0;
      l2 = l1;
    } while (i >= j);
    File localFile = paramFile[i];
    if (localFile.isFile()) {
      l2 = l1 + localFile.length();
    }
    for (;;)
    {
      i++;
      l1 = l2;
      break;
      l2 = l1;
      if (localFile.isDirectory()) {
        l2 = l1 + localFile.length() + a(localFile);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext.deleteDatabase("webview.db");
      paramContext.deleteDatabase("webviewCache.db");
      bool1 = b(paramContext.getCacheDir());
      if (bool1) {
        break label38;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        boolean bool1 = false;
        continue;
        label38:
        boolean bool2 = b(c.getAppCacheDir());
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (Build.VERSION.SDK_INT >= 8)
          {
            bool1 = bool2;
            if (Environment.getExternalStorageState().equals("mounted"))
            {
              b(paramContext.getExternalCacheDir());
              bool1 = bool2;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    bool = false;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        localFile = new java/io/File;
        localFile.<init>(paramString);
        if (localFile.isDirectory())
        {
          paramString = localFile.listFiles();
          int i = 0;
          if (i < paramString.length)
          {
            a(paramString[i].getAbsolutePath(), true);
            i++;
            continue;
          }
        }
        if (paramBoolean)
        {
          if (localFile.isDirectory()) {
            continue;
          }
          localFile.delete();
        }
        paramBoolean = true;
      }
      catch (Exception paramString)
      {
        File localFile;
        paramString.printStackTrace();
        paramBoolean = bool;
        continue;
      }
      return paramBoolean;
      if (localFile.listFiles().length == 0) {
        localFile.delete();
      }
    }
  }
  
  private static boolean b(File paramFile)
  {
    return a(paramFile.getPath(), false);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */