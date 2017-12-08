package com.lantern.permission.ui;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.style;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a
{
  private static String a = "com.qihoo360.mobilesafe";
  private static String b = "cn.opda.a.phonoalbumshoushou";
  private static a g;
  private String[] c = { "Xiaomi", "samsung" };
  private String d;
  private String e;
  private boolean f = false;
  
  private static Intent a(ComponentName paramComponentName)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(paramComponentName);
    localIntent.setFlags(268435456);
    return localIntent;
  }
  
  public static a a()
  {
    if (g == null) {
      g = new a();
    }
    return g;
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 64	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: astore_2
    //   6: new 66	java/lang/StringBuilder
    //   9: astore_3
    //   10: aload_3
    //   11: ldc 68
    //   13: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_2
    //   17: aload_3
    //   18: aload_0
    //   19: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokevirtual 83	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   28: astore_2
    //   29: new 85	java/io/BufferedReader
    //   32: astore_0
    //   33: new 87	java/io/InputStreamReader
    //   36: astore_3
    //   37: aload_3
    //   38: aload_2
    //   39: invokevirtual 93	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   42: invokespecial 96	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   45: aload_0
    //   46: aload_3
    //   47: sipush 1024
    //   50: invokespecial 99	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   53: aload_0
    //   54: invokevirtual 102	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore_1
    //   58: aload_0
    //   59: invokevirtual 105	java/io/BufferedReader:close	()V
    //   62: aload_0
    //   63: invokevirtual 105	java/io/BufferedReader:close	()V
    //   66: aload_1
    //   67: astore_0
    //   68: aload_0
    //   69: areturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 105	java/io/BufferedReader:close	()V
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -15 -> 68
    //   86: astore_0
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 105	java/io/BufferedReader:close	()V
    //   95: aload_0
    //   96: athrow
    //   97: astore_0
    //   98: aload_1
    //   99: astore_0
    //   100: goto -32 -> 68
    //   103: astore_0
    //   104: goto -23 -> 81
    //   107: astore_1
    //   108: goto -13 -> 95
    //   111: astore_2
    //   112: aload_0
    //   113: astore_1
    //   114: aload_2
    //   115: astore_0
    //   116: goto -29 -> 87
    //   119: astore_1
    //   120: goto -47 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString	String
    //   1	98	1	str1	String
    //   107	1	1	localIOException1	java.io.IOException
    //   113	1	1	str2	String
    //   119	1	1	localIOException2	java.io.IOException
    //   5	34	2	localObject1	Object
    //   111	4	2	localObject2	Object
    //   9	38	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	70	java/io/IOException
    //   2	53	86	finally
    //   62	66	97	java/io/IOException
    //   77	81	103	java/io/IOException
    //   91	95	107	java/io/IOException
    //   53	62	111	finally
    //   53	62	119	java/io/IOException
  }
  
  private static int b(Context paramContext)
  {
    Object localObject;
    Class localClass;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localObject = paramContext.getSystemService("appops");
      localClass = localObject.getClass();
    }
    try
    {
      i = ((Integer)localClass.getDeclaredMethod("checkOp", new Class[] { String.class, Integer.TYPE, String.class }).invoke(localObject, new Object[] { "android:coarse_location", Integer.valueOf(Binder.getCallingUid()), paramContext.getPackageName() })).intValue();
      return i;
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        int i = -1;
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private static boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (!"".equals(paramString)) {
        break label22;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        label22:
        c.getAppContext().getPackageManager().getApplicationInfo(paramString, 8192);
        bool1 = true;
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        bool1 = bool2;
      }
    }
  }
  
  public static boolean c()
  {
    return b(b);
  }
  
  public static boolean d()
  {
    return b(a);
  }
  
  public final void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext);
    if (!TextUtils.isEmpty(this.e))
    {
      Dialog localDialog = new Dialog(paramContext, R.style.Dialog_Fullscreen);
      localObject = ((LayoutInflater)localObject).inflate(R.layout.settings_permission_check_xiaomi_mengceng_view, null);
      localDialog.setContentView((View)localObject);
      localDialog.setCancelable(true);
      localDialog.setCanceledOnTouchOutside(true);
      ((View)localObject).setOnClickListener(new b(this, localDialog, paramContext));
      localDialog.show();
    }
  }
  
  public final boolean b()
  {
    int i = Build.VERSION.SDK_INT;
    this.e = a("ro.miui.ui.version.name");
    String str = Build.MANUFACTURER;
    if (i >= 19)
    {
      i = 0;
      if (i < this.c.length) {
        if (str.startsWith(this.c[i]))
        {
          this.d = this.c[i];
          if (b(c.getAppContext()) != 1) {
            break label94;
          }
        }
      }
    }
    label94:
    for (boolean bool = true;; bool = false)
    {
      h.b("isLimitBySys:%s", new Object[] { Boolean.valueOf(bool) });
      return bool;
      i++;
      break;
    }
  }
  
  public final String e()
  {
    return this.e;
  }
  
  public final boolean f()
  {
    return this.f;
  }
  
  public final void g()
  {
    this.f = false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/permission/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */