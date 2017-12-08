package com.lantern.wifilocating.push.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

public final class m
{
  private static Object a(Object paramObject, String paramString, Object... paramVarArgs)
  {
    Class localClass;
    Class[] arrayOfClass;
    int i;
    try
    {
      localClass = paramObject.getClass();
      arrayOfClass = new Class[3];
      i = 0;
      if (i < 3)
      {
        if ((paramVarArgs[i] instanceof Boolean)) {
          arrayOfClass[i] = Boolean.TYPE;
        }
        for (;;)
        {
          i++;
          break;
          if (!(paramVarArgs[i] instanceof Integer)) {
            break label69;
          }
          arrayOfClass[i] = Integer.TYPE;
        }
        return paramObject;
      }
    }
    catch (Exception paramObject)
    {
      h.a((Throwable)paramObject);
      paramObject = null;
    }
    for (;;)
    {
      label69:
      if ((paramVarArgs[i] instanceof Long))
      {
        arrayOfClass[i] = Long.TYPE;
        break;
      }
      if ((paramVarArgs[i] instanceof Context))
      {
        arrayOfClass[i] = Context.class;
        break;
      }
      arrayOfClass[i] = paramVarArgs[i].getClass();
      break;
      paramObject = localClass.getMethod(paramString, arrayOfClass).invoke(paramObject, paramVarArgs);
    }
  }
  
  public static final void a(AlarmManager paramAlarmManager, long paramLong, PendingIntent paramPendingIntent)
  {
    if (Build.VERSION.SDK_INT < 19) {
      paramAlarmManager.set(2, paramLong, paramPendingIntent);
    }
    for (;;)
    {
      return;
      a(paramAlarmManager, "setExact", new Object[] { Integer.valueOf(2), Long.valueOf(paramLong), paramPendingIntent });
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */