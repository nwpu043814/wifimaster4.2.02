package com.alipay.c.a.a.d;

import android.os.Environment;
import com.alipay.c.a.a.a.b;
import java.io.File;

public final class c
{
  public static String a(String paramString)
  {
    try
    {
      if (a())
      {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath();
        File localFile = new java/io/File;
        localFile.<init>(str, paramString);
        if (localFile.exists())
        {
          paramString = b.a(str, paramString);
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  public static boolean a()
  {
    String str = Environment.getExternalStorageState();
    if ((str != null) && (str.length() > 0) && ((str.equals("mounted")) || (str.equals("mounted_ro"))) && (Environment.getExternalStorageDirectory() != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */