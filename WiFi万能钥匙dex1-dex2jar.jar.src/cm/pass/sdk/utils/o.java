package cm.pass.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class o
{
  private static o a;
  
  public static o a()
  {
    if (a == null) {
      a = new o();
    }
    return a;
  }
  
  public String a(Context paramContext, String paramString)
  {
    return paramContext.getApplicationContext().getSharedPreferences("UMC_SDK_ACCOUNT", 0).getString(paramString, "");
  }
  
  public boolean a(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext().getSharedPreferences("UMC_SDK_SMS", 0).edit();
    paramContext.clear();
    return paramContext.commit();
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getApplicationContext().getSharedPreferences("UMC_SDK_ACCOUNT", 0).edit();
    paramContext.putInt(paramString, paramInt);
    return paramContext.commit();
  }
  
  public boolean a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getApplicationContext().getSharedPreferences("UMC_SDK_ACCOUNT", 0).edit();
    paramContext.putLong(paramString, paramLong);
    return paramContext.commit();
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getApplicationContext().getSharedPreferences("UMC_SDK_ACCOUNT", 0).edit();
    paramContext.putString(paramString1, paramString2);
    return paramContext.commit();
  }
  
  public int b(Context paramContext, String paramString, int paramInt)
  {
    return paramContext.getSharedPreferences("UMC_SDK_ACCOUNT", 0).getInt(paramString, paramInt);
  }
  
  public String b(Context paramContext, String paramString)
  {
    return paramContext.getApplicationContext().getSharedPreferences("UMC_SDK_SMS", 0).getString(paramString, "");
  }
  
  public boolean b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getApplicationContext().getSharedPreferences("UMC_SDK_SMS", 0).edit();
    paramContext.putLong(paramString, paramLong);
    return paramContext.commit();
  }
  
  public boolean b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getApplicationContext().getSharedPreferences("UMC_SDK_SMS", 0).edit();
    paramContext.putString(paramString1, paramString2);
    return paramContext.commit();
  }
  
  public long c(Context paramContext, String paramString)
  {
    return paramContext.getApplicationContext().getSharedPreferences("UMC_SDK_ACCOUNT", 0).getLong(paramString, 0L);
  }
  
  public long d(Context paramContext, String paramString)
  {
    return paramContext.getApplicationContext().getSharedPreferences("UMC_SDK_SMS", 0).getLong(paramString, 0L);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */