package com.lantern.dynamictab.e;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.lantern.core.c;

public final class f
{
  public static boolean a(String paramString)
  {
    PackageManager localPackageManager = c.getInstance().getPackageManager();
    new Intent().setPackage(paramString);
    if (localPackageManager.getLaunchIntentForPackage(paramString) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */