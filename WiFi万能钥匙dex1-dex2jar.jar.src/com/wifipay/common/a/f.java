package com.wifipay.common.a;

import android.content.Context;
import android.content.res.Resources;
import java.lang.reflect.Field;

public class f
{
  private static Context a;
  
  public static int a(String paramString)
  {
    return a(paramString, "drawable");
  }
  
  private static int a(String paramString1, String paramString2)
  {
    String str = a();
    int i = a.getResources().getIdentifier(paramString1, paramString2, str);
    if (i > 0) {}
    for (;;)
    {
      return i;
      try
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        i = ((Integer)Class.forName(str + ".R$" + paramString2).getField(paramString1).get(null)).intValue();
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        i = -1;
      }
    }
  }
  
  private static String a()
  {
    return a.getPackageName();
  }
  
  public static String a(int paramInt)
  {
    return a.getString(paramInt);
  }
  
  public static String a(int paramInt, Object... paramVarArgs)
  {
    return a.getString(paramInt, paramVarArgs);
  }
  
  public static void a(Context paramContext)
  {
    a = paramContext.getApplicationContext();
  }
  
  public static int b(int paramInt)
  {
    return a.getResources().getColor(paramInt);
  }
  
  public static String[] c(int paramInt)
  {
    return a.getResources().getStringArray(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */