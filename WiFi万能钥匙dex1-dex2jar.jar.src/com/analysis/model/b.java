package com.analysis.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;

public final class b
{
  private static final String a = "upload_state";
  private static final String b = "app_version_code";
  
  public static a a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("sp_general_config", 0);
    int i = localSharedPreferences.getInt("app_version_code", 0);
    a locala;
    Object localObject;
    if ((!localSharedPreferences.getBoolean("upload_state", false)) || (com.analysis.common.c.b(paramContext) != i))
    {
      locala = new a();
      i = Build.VERSION.SDK_INT;
      if (i == Integer.MIN_VALUE)
      {
        localObject = com.analysis.common.tools.c.a();
        locala.g = ((String)localObject);
        locala.h = Build.BRAND;
        locala.i = Build.MODEL;
        locala.j = com.analysis.common.c.j(paramContext);
        locala.k = com.analysis.common.c.c(paramContext);
        locala.l = com.analysis.common.c.k(paramContext);
        locala.m = com.analysis.common.c.d(paramContext);
        locala.n = com.analysis.common.c.e(paramContext);
        locala.o = com.analysis.common.c.f(paramContext);
        locala.p = com.analysis.common.c.g(paramContext);
        locala.q = localSharedPreferences.getString("login_name", "null");
        locala.r = localSharedPreferences.getString("app_1d", "null");
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putInt("app_version_code", com.analysis.common.c.b(paramContext));
        ((SharedPreferences.Editor)localObject).putBoolean("upload_state", true);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    for (paramContext = locala;; paramContext = null)
    {
      return paramContext;
      localObject = String.valueOf(i);
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */