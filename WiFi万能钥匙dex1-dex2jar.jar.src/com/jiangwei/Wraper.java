package com.jiangwei;

import android.content.Context;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Wraper
{
  public static void hookPMS(Context paramContext)
  {
    try
    {
      Object localObject2 = Class.forName("android.app.ActivityThread");
      Object localObject1 = ((Class)localObject2).getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      localObject2 = ((Class)localObject2).getDeclaredField("sPackageManager");
      ((Field)localObject2).setAccessible(true);
      Object localObject4 = ((Field)localObject2).get(localObject1);
      Class localClass = Class.forName("android.content.pm.IPackageManager");
      Object localObject3 = localClass.getClassLoader();
      PmsWraper localPmsWraper = new com/jiangwei/PmsWraper;
      localPmsWraper.<init>(localObject4);
      localObject3 = Proxy.newProxyInstance((ClassLoader)localObject3, new Class[] { localClass }, localPmsWraper);
      ((Field)localObject2).set(localObject1, localObject3);
      paramContext = paramContext.getPackageManager();
      localObject1 = paramContext.getClass().getDeclaredField("mPM");
      ((Field)localObject1).setAccessible(true);
      ((Field)localObject1).set(paramContext, localObject3);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/jiangwei/Wraper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */