package com.lantern.notifaction.o2o;

import android.content.Context;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

public final class d
{
  public static void a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localObject = paramContext.getSystemService("statusbar");
        if (Build.VERSION.SDK_INT <= 16)
        {
          paramContext = localObject.getClass().getMethod("collapse", new Class[0]);
          paramContext.invoke(localObject, new Object[0]);
          return;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject;
        paramContext.printStackTrace();
        continue;
      }
      paramContext = localObject.getClass().getMethod("collapsePanels", new Class[0]);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/notifaction/o2o/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */