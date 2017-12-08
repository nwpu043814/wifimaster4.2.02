package com.wifipay.wallet.authentication.tools;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class d
{
  public static int a(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(paramContext);
    return paramContext.widthPixels;
  }
  
  public static int b(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(paramContext);
    return paramContext.heightPixels;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/authentication/tools/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */