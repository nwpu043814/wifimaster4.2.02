package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import java.io.File;

public class ContextCompat
{
  private static final String DIR_ANDROID = "Android";
  private static final String DIR_CACHE = "cache";
  private static final String DIR_DATA = "data";
  private static final String DIR_FILES = "files";
  private static final String DIR_OBB = "obb";
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    String str;
    if (i < j)
    {
      str = paramVarArgs[i];
      if (paramFile == null) {
        paramFile = new File(str);
      }
    }
    for (;;)
    {
      i++;
      break;
      if (str != null)
      {
        paramFile = new File(paramFile, str);
        continue;
        return paramFile;
      }
    }
  }
  
  public static File[] getExternalCacheDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      paramContext = ContextCompatKitKat.getExternalCacheDirs(paramContext);
      return paramContext;
    }
    if (i >= 8) {}
    for (paramContext = ContextCompatFroyo.getExternalCacheDir(paramContext);; paramContext = buildPath(Environment.getExternalStorageDirectory(), new String[] { "Android", "data", paramContext.getPackageName(), "cache" }))
    {
      paramContext = new File[] { paramContext };
      break;
    }
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      paramContext = ContextCompatKitKat.getExternalFilesDirs(paramContext, paramString);
      return paramContext;
    }
    if (i >= 8) {}
    for (paramContext = ContextCompatFroyo.getExternalFilesDir(paramContext, paramString);; paramContext = buildPath(Environment.getExternalStorageDirectory(), new String[] { "Android", "data", paramContext.getPackageName(), "files", paramString }))
    {
      paramContext = new File[] { paramContext };
      break;
    }
  }
  
  public static File[] getObbDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      paramContext = ContextCompatKitKat.getObbDirs(paramContext);
      return paramContext;
    }
    if (i >= 11) {}
    for (paramContext = ContextCompatHoneycomb.getObbDir(paramContext);; paramContext = buildPath(Environment.getExternalStorageDirectory(), new String[] { "Android", "obb", paramContext.getPackageName() }))
    {
      paramContext = new File[] { paramContext };
      break;
    }
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    boolean bool = true;
    int i = Build.VERSION.SDK_INT;
    if (i >= 16) {
      ContextCompatJellybean.startActivities(paramContext, paramArrayOfIntent, paramBundle);
    }
    for (;;)
    {
      return bool;
      if (i >= 11) {
        ContextCompatHoneycomb.startActivities(paramContext, paramArrayOfIntent);
      } else {
        bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/content/ContextCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */