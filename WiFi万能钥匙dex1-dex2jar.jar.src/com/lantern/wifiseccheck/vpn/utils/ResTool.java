package com.lantern.wifiseccheck.vpn.utils;

import android.content.Context;
import android.content.res.Resources;

public class ResTool
{
  public static int getAnimId(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "anim", paramContext.getPackageName());
  }
  
  public static int getAttrId(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "attr", paramContext.getPackageName());
  }
  
  public static int getColorId(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "color", paramContext.getPackageName());
  }
  
  public static int getDrawableId(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
  }
  
  public static int getLayoutId(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "layout", paramContext.getPackageName());
  }
  
  public static int getStringId(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
  }
  
  public static int getStyleId(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "style", paramContext.getPackageName());
  }
  
  public static int getStyleableId(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "styleable", paramContext.getPackageName());
  }
  
  public static int getViewId(String paramString, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString, "id", paramContext.getPackageName());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/utils/ResTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */