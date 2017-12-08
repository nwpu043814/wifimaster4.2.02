package com.wifipay.common.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class b
{
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */