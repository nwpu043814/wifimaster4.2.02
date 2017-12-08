package com.analysis.model;

import android.content.Context;
import android.content.SharedPreferences;

public final class n
{
  private static final String a = "sp_general_config";
  
  private static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("sp_general_config", 0);
  }
  
  private static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramString, 0);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */