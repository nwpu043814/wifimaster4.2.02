package com.linksure.apservice.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public final class j
{
  public static int a(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(paramContext);
    return paramContext.widthPixels;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int b(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(paramContext);
    return paramContext.heightPixels;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */