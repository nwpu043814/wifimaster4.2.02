package com.lantern.webox;

import android.content.Context;
import java.io.File;

public class c
{
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    paramContext = new File(paramContext + "/dbcache");
    if ((!paramContext.isDirectory()) || (!paramContext.exists())) {
      paramContext.mkdir();
    }
    return paramContext.getAbsolutePath();
  }
  
  public static String b(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    paramContext = new File(paramContext + "/appcache");
    if ((!paramContext.isDirectory()) || (!paramContext.exists())) {
      paramContext.mkdir();
    }
    return paramContext.getAbsolutePath();
  }
  
  public static String c(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    paramContext = new File(paramContext + "/geodb");
    if ((!paramContext.isDirectory()) || (!paramContext.exists())) {
      paramContext.mkdir();
    }
    return paramContext.getAbsolutePath();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */