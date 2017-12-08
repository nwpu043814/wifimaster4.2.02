package com.lantern.wifilocating.push.util;

import android.content.Context;
import android.content.res.Resources;

public final class l
{
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getResources().getIdentifier(paramString, "layout", paramContext.getPackageName());
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
  }
  
  public static int c(Context paramContext, String paramString)
  {
    return paramContext.getResources().getIdentifier(paramString, "id", paramContext.getPackageName());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */