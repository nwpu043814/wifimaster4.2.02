package com.lantern.wifitools.apgrade.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.bluefay.b.i;

public final class a
{
  private static String a = "WkapGradeFile";
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = i.a(paramString1 + paramString2);
    paramString1 = "";
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(a, 0);
    paramContext = paramString1;
    if (localSharedPreferences != null) {
      paramContext = localSharedPreferences.getString(paramString2, "");
    }
    return paramContext;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = i.a(paramString1 + paramString2);
    paramContext = paramContext.getSharedPreferences(a, 0);
    if (paramContext != null) {
      paramContext.edit().putString(paramString1, paramString3).commit();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */