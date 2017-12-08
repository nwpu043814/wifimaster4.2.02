package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class EnvironmentCompat
{
  public static final String MEDIA_UNKNOWN = "unknown";
  private static final String TAG = "EnvironmentCompat";
  
  public static String getStorageState(File paramFile)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramFile = EnvironmentCompatKitKat.getStorageState(paramFile);
    }
    for (;;)
    {
      return paramFile;
      try
      {
        if (paramFile.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath())) {
          paramFile = Environment.getExternalStorageState();
        }
      }
      catch (IOException paramFile)
      {
        Log.w("EnvironmentCompat", "Failed to resolve canonical path: " + paramFile);
        paramFile = "unknown";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/os/EnvironmentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */