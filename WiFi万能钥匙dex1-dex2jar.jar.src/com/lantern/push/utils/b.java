package com.lantern.push.utils;

import android.os.Environment;
import java.io.File;

public final class b
{
  public static boolean a()
  {
    if (!Environment.getExternalStorageState().equals("mounted")) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static String b()
  {
    if (a()) {}
    for (String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";; str = Environment.getDataDirectory().getAbsolutePath() + "/data/") {
      return str;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */