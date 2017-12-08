package android.support.v4.content;

import android.content.Context;
import java.io.File;

class ContextCompatKitKat
{
  public static File[] getExternalCacheDirs(Context paramContext)
  {
    return paramContext.getExternalCacheDirs();
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    return paramContext.getExternalFilesDirs(paramString);
  }
  
  public static File[] getObbDirs(Context paramContext)
  {
    return paramContext.getObbDirs();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/content/ContextCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */