package com.bluefay.a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.bluefay.b.h;
import com.bluefay.d.a;
import com.bluefay.framework.R.string;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class e
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    h.a("scale = " + f, new Object[0]);
    return (int)(f * paramFloat + 0.5F);
  }
  
  public static Object a(Object paramObject, Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramObject = paramClass.get(paramObject);
      return paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      for (;;)
      {
        ((NoSuchFieldException)paramObject).printStackTrace();
        paramObject = null;
      }
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        ((IllegalAccessException)paramObject).printStackTrace();
      }
    }
    catch (IllegalArgumentException paramObject)
    {
      for (;;)
      {
        ((IllegalArgumentException)paramObject).printStackTrace();
      }
    }
  }
  
  public static Object a(Object paramObject, String paramString)
  {
    try
    {
      paramString = paramObject.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      return paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      for (;;)
      {
        ((NoSuchFieldException)paramObject).printStackTrace();
        paramObject = null;
      }
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        ((IllegalAccessException)paramObject).printStackTrace();
      }
    }
    catch (IllegalArgumentException paramObject)
    {
      for (;;)
      {
        ((IllegalArgumentException)paramObject).printStackTrace();
      }
    }
  }
  
  public static Object a(Object paramObject, String paramString, Object... paramVarArgs)
  {
    Class localClass = paramObject.getClass();
    Class[] arrayOfClass = new Class[1];
    int i = 0;
    if (i <= 0)
    {
      if ((paramVarArgs[0] instanceof Boolean)) {
        arrayOfClass[0] = Boolean.TYPE;
      }
      for (;;)
      {
        i++;
        break;
        if ((paramVarArgs[0] instanceof Integer)) {
          arrayOfClass[0] = Integer.TYPE;
        } else if ((paramVarArgs[0] instanceof Long)) {
          arrayOfClass[0] = Long.TYPE;
        } else if ((paramVarArgs[0] instanceof Context)) {
          arrayOfClass[0] = Context.class;
        } else {
          arrayOfClass[0] = paramVarArgs[0].getClass();
        }
      }
    }
    try
    {
      paramObject = localClass.getMethod(paramString, arrayOfClass).invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (SecurityException paramObject)
    {
      for (;;)
      {
        ((SecurityException)paramObject).printStackTrace();
        paramObject = null;
      }
    }
    catch (NoSuchMethodException paramObject)
    {
      for (;;)
      {
        ((NoSuchMethodException)paramObject).printStackTrace();
      }
    }
    catch (IllegalArgumentException paramObject)
    {
      for (;;)
      {
        ((IllegalArgumentException)paramObject).printStackTrace();
      }
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        ((IllegalAccessException)paramObject).printStackTrace();
      }
    }
    catch (InvocationTargetException paramObject)
    {
      for (;;)
      {
        ((InvocationTargetException)paramObject).printStackTrace();
      }
    }
  }
  
  public static Object a(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString1 = Class.forName(paramString1).getField(paramString2).get(null);
      return paramString1;
    }
    catch (NoSuchFieldException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        paramString1 = (String)localObject;
      }
    }
    catch (IllegalAccessException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        paramString1 = (String)localObject;
      }
    }
    catch (IllegalArgumentException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        paramString1 = (String)localObject;
      }
    }
    catch (ClassNotFoundException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        paramString1 = (String)localObject;
      }
    }
  }
  
  public static Object a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int i = 0;
    try
    {
      paramString1 = Class.forName(paramString1);
      if (paramString1 == null)
      {
        paramString1 = null;
        return paramString1;
      }
    }
    catch (ClassNotFoundException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        paramString1 = null;
      }
    }
    if (paramVarArgs.length == 0) {}
    for (;;)
    {
      try
      {
        paramString1 = paramString1.getMethod(paramString2, new Class[0]).invoke(null, new Object[0]);
      }
      catch (IllegalArgumentException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = null;
      }
      catch (IllegalAccessException paramString1)
      {
        paramString1.printStackTrace();
        continue;
      }
      catch (InvocationTargetException paramString1)
      {
        paramString1.printStackTrace();
        continue;
      }
      catch (SecurityException paramString1)
      {
        paramString1.printStackTrace();
        continue;
      }
      catch (NoSuchMethodException paramString1)
      {
        paramString1.printStackTrace();
        continue;
      }
      Class[] arrayOfClass = new Class[paramVarArgs.length];
      if (i < paramVarArgs.length)
      {
        if ((paramVarArgs[i] instanceof Boolean)) {
          arrayOfClass[i] = Boolean.TYPE;
        }
        for (;;)
        {
          i++;
          break;
          if ((paramVarArgs[i] instanceof Integer)) {
            arrayOfClass[i] = Integer.TYPE;
          } else if ((paramVarArgs[i] instanceof Long)) {
            arrayOfClass[i] = Long.TYPE;
          } else if ((paramVarArgs[i] instanceof Context)) {
            arrayOfClass[i] = Context.class;
          } else {
            arrayOfClass[i] = paramVarArgs[i].getClass();
          }
        }
      }
      try
      {
        paramString1 = paramString1.getMethod(paramString2, arrayOfClass).invoke(null, paramVarArgs);
      }
      catch (SecurityException paramString1)
      {
        paramString1.printStackTrace();
      }
      catch (NoSuchMethodException paramString1)
      {
        paramString1.printStackTrace();
      }
      catch (IllegalArgumentException paramString1)
      {
        paramString1.printStackTrace();
      }
      catch (IllegalAccessException paramString1)
      {
        paramString1.printStackTrace();
      }
      catch (InvocationTargetException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static void a(int paramInt)
  {
    Toast.makeText(a.getAppContext(), paramInt, 0).show();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      for (;;)
      {
        h.c(paramIntent.getMessage());
        a(paramContext, R.string.framework_activity_not_found);
      }
    }
    catch (SecurityException paramIntent)
    {
      for (;;)
      {
        h.c(paramIntent.getMessage());
        a(paramContext, R.string.framework_activity_security);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Toast.makeText(paramContext, paramString, 0).show();
  }
  
  public static void a(String paramString)
  {
    Toast.makeText(a.getAppContext(), paramString, 0).show();
  }
  
  private static Bundle b(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramString, 128);
      if (paramContext == null) {
        break label28;
      }
      paramContext = paramContext.metaData;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        label28:
        paramContext = null;
      }
    }
    return paramContext;
  }
  
  public static String b(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
        paramString = ((MessageDigest)localObject).digest();
        if (paramString != null) {
          continue;
        }
        paramString = "";
      }
      catch (NoSuchAlgorithmException paramString)
      {
        Object localObject;
        int k;
        int j;
        int m;
        int n;
        paramString.printStackTrace();
        paramString = "";
        continue;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      return paramString;
      k = paramString.length;
      localObject = new char[k * 2];
      j = 0;
      if (i < k + 0)
      {
        m = paramString[i];
        n = j + 1;
        localObject[j] = a[(m >>> 4 & 0xF)];
        j = n + 1;
        localObject[n] = a[(m & 0xF)];
        i++;
      }
      else
      {
        paramString = new String((char[])localObject);
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.getType() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnectedOrConnecting())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static Bundle d(Context paramContext)
  {
    return b(paramContext, paramContext.getPackageName());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */