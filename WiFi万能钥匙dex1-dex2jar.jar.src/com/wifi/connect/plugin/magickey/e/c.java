package com.wifi.connect.plugin.magickey.e;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.bluefay.b.h;
import java.lang.reflect.Method;

public final class c
{
  static boolean a = false;
  
  public static boolean a()
  {
    boolean bool;
    if (a)
    {
      bool = a;
      return bool;
    }
    String str = Build.MANUFACTURER;
    h.a("mSystemType" + str, new Object[0]);
    for (int i = 0;; i++) {
      if (i < 5)
      {
        if (str.startsWith(new String[] { "Xiaomi", "HUAWEI", "OPPO", "Meizu", "Hisense" }[i])) {
          a = true;
        }
      }
      else
      {
        h.a("mSystemType" + a, new Object[0]);
        bool = a;
        break;
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = b(paramContext);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = c(paramContext);
    }
    return bool1;
  }
  
  private static boolean b(Context paramContext)
  {
    bool1 = true;
    boolean bool2 = false;
    Object localObject = paramContext.getSystemService("statusbar");
    if (localObject == null)
    {
      bool1 = bool2;
      return bool1;
    }
    for (;;)
    {
      try
      {
        paramContext = Class.forName("android.app.StatusBarManager");
        if (Build.VERSION.SDK_INT <= 16)
        {
          paramContext = paramContext.getMethod("expand", new Class[0]);
          paramContext.setAccessible(true);
          paramContext.invoke(localObject, new Object[0]);
        }
      }
      catch (Exception paramContext)
      {
        h.a(paramContext);
        bool1 = false;
        continue;
      }
      paramContext = paramContext.getMethod("expandNotificationsPanel", new Class[0]);
    }
  }
  
  /* Error */
  private static boolean c(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: ldc 69
    //   7: invokevirtual 75	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnonnull +5 -> 17
    //   15: iload_1
    //   16: ireturn
    //   17: ldc 112
    //   19: invokestatic 83	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore_3
    //   23: iload_2
    //   24: istore_1
    //   25: aload_0
    //   26: ifnull +31 -> 57
    //   29: aload_3
    //   30: ldc 107
    //   32: iconst_0
    //   33: anewarray 79	java/lang/Class
    //   36: invokevirtual 95	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: astore_3
    //   40: aload_3
    //   41: iconst_1
    //   42: invokevirtual 101	java/lang/reflect/Method:setAccessible	(Z)V
    //   45: aload_3
    //   46: aload_0
    //   47: iconst_0
    //   48: anewarray 4	java/lang/Object
    //   51: invokevirtual 105	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: iload_2
    //   56: istore_1
    //   57: goto -42 -> 15
    //   60: astore_0
    //   61: aload_0
    //   62: invokestatic 110	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   65: iconst_0
    //   66: istore_1
    //   67: goto -10 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramContext	Context
    //   3	64	1	bool1	boolean
    //   1	55	2	bool2	boolean
    //   22	24	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	11	60	java/lang/Exception
    //   17	23	60	java/lang/Exception
    //   29	55	60	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */