package com.wifi.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.io.File;

public final class a
{
  public static int a(Context paramContext, String paramString)
  {
    int i = 0;
    try
    {
      int j = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      i = j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    return i;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {}
    for (;;)
    {
      return;
      paramString = new Intent();
      paramString.setAction("android.intent.action.VIEW");
      paramString.addCategory("android.intent.category.DEFAULT");
      paramString.setDataAndType(Uri.fromFile(localFile), "application/vnd.android.package-archive");
      paramContext.startActivity(paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */