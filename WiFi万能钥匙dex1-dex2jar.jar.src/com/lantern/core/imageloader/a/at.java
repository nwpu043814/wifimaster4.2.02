package com.lantern.core.imageloader.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.System;
import com.bluefay.b.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

final class at
{
  static final StringBuilder a = new StringBuilder();
  
  static int a(Resources paramResources, ag paramag)
  {
    if ((paramag.b != 0) || (paramag.a == null)) {}
    String str;
    List localList;
    for (int i = paramag.b;; i = paramResources.getIdentifier((String)localList.get(1), paramag, str))
    {
      for (;;)
      {
        return i;
        str = paramag.a.getAuthority();
        if (str == null) {
          throw new FileNotFoundException("No package provided: " + paramag.a);
        }
        localList = paramag.a.getPathSegments();
        if ((localList == null) || (localList.isEmpty())) {
          throw new FileNotFoundException("No path segments: " + paramag.a);
        }
        if (localList.size() == 1) {
          try
          {
            i = Integer.parseInt((String)localList.get(0));
          }
          catch (NumberFormatException paramResources)
          {
            throw new FileNotFoundException("Last path segment is not a resource ID: " + paramag.a);
          }
        }
      }
      if (localList.size() != 2) {
        break;
      }
      paramag = (String)localList.get(0);
    }
    throw new FileNotFoundException("More than two path segments: " + paramag.a);
  }
  
  static int a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 12) {}
    for (int i = paramBitmap.getByteCount(); i < 0; i = paramBitmap.getRowBytes() * paramBitmap.getHeight()) {
      throw new IllegalStateException("Negative size: " + paramBitmap);
    }
    return i;
  }
  
  static long a(File paramFile)
  {
    try
    {
      StatFs localStatFs = new android/os/StatFs;
      localStatFs.<init>(paramFile.getAbsolutePath());
      l = localStatFs.getBlockCount();
      l = localStatFs.getBlockSize() * l / 50L;
      return Math.max(Math.min(l, 52428800L), 5242880L);
    }
    catch (IllegalArgumentException paramFile)
    {
      for (;;)
      {
        long l = 5242880L;
      }
    }
  }
  
  static Resources a(Context paramContext, ag paramag)
  {
    if ((paramag.b != 0) || (paramag.a == null)) {
      paramContext = paramContext.getResources();
    }
    for (;;)
    {
      return paramContext;
      String str = paramag.a.getAuthority();
      if (str == null) {
        throw new FileNotFoundException("No package provided: " + paramag.a);
      }
      try
      {
        paramContext = paramContext.getPackageManager().getResourcesForApplication(str);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        throw new FileNotFoundException("Unable to obtain resources for package: " + paramag.a);
      }
    }
  }
  
  static r a(Context paramContext)
  {
    return new aq(paramContext);
  }
  
  static <T> T a(Context paramContext, String paramString)
  {
    return (T)paramContext.getSystemService(paramString);
  }
  
  static <T> T a(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(paramString);
    }
    return paramT;
  }
  
  static String a(ag paramag)
  {
    StringBuilder localStringBuilder = a;
    if (paramag.c != null)
    {
      localStringBuilder.ensureCapacity(paramag.c.length() + 50);
      localStringBuilder.append(paramag.c);
      localStringBuilder.append('\n');
      if (paramag.j != 0.0F)
      {
        localStringBuilder.append("rotation:").append(paramag.j);
        if (paramag.m) {
          localStringBuilder.append('@').append(paramag.k).append('x').append(paramag.l);
        }
        localStringBuilder.append('\n');
      }
      if (paramag.c())
      {
        localStringBuilder.append("resize:").append(paramag.e).append('x').append(paramag.f);
        localStringBuilder.append('\n');
      }
      if (!paramag.g) {
        break label287;
      }
      localStringBuilder.append("centerCrop\n");
    }
    for (;;)
    {
      if (paramag.d == null) {
        break label305;
      }
      int j = paramag.d.size();
      for (int i = 0; i < j; i++)
      {
        localStringBuilder.append(((ap)paramag.d.get(i)).a());
        localStringBuilder.append('\n');
      }
      if (paramag.a != null)
      {
        String str = paramag.a.toString();
        localStringBuilder.ensureCapacity(str.length() + 50);
        localStringBuilder.append(str);
        break;
      }
      localStringBuilder.ensureCapacity(50);
      localStringBuilder.append(paramag.b);
      break;
      label287:
      if (paramag.h) {
        localStringBuilder.append("centerInside\n");
      }
    }
    label305:
    paramag = localStringBuilder.toString();
    a.setLength(0);
    return paramag;
  }
  
  static String a(c paramc)
  {
    return a(paramc, "");
  }
  
  static String a(c paramc, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    paramString = paramc.k;
    if (paramString != null) {
      localStringBuilder.append(paramString.b.a());
    }
    paramc = paramc.l;
    if (paramc != null)
    {
      int j = paramc.size();
      for (int i = 0; i < j; i++)
      {
        if ((i > 0) || (paramString != null)) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(((a)paramc.get(i)).b.a());
      }
    }
    return localStringBuilder.toString();
  }
  
  static void a()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalStateException("Method call should happen from the main thread.");
    }
  }
  
  static void a(Looper paramLooper)
  {
    paramLooper = new au(paramLooper);
    paramLooper.sendMessageDelayed(paramLooper.obtainMessage(), 1000L);
  }
  
  static void a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {}
    for (;;)
    {
      return;
      try
      {
        paramInputStream.close();
      }
      catch (IOException paramInputStream) {}
    }
  }
  
  static void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, "");
  }
  
  static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    h.a("Picasso " + String.format("%1$-11s %2$-12s %3$s %4$s", new Object[] { paramString1, paramString2, paramString3, paramString4 }), new Object[0]);
  }
  
  static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramString == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramString = paramString.split(" ", 2);
      if ("CACHE".equals(paramString[0]))
      {
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (paramString.length != 1)
        {
          bool1 = bool2;
          try
          {
            if ("CONDITIONAL_CACHE".equals(paramString[0]))
            {
              int i = Integer.parseInt(paramString[1]);
              bool1 = bool2;
              if (i == 304) {
                bool1 = true;
              }
            }
          }
          catch (NumberFormatException paramString)
          {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  static File b(Context paramContext)
  {
    paramContext = new File(paramContext.getApplicationContext().getCacheDir(), "picasso-cache");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext;
  }
  
  static boolean b(Context paramContext, String paramString)
  {
    if (paramContext.checkCallingOrSelfPermission(paramString) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static byte[] b(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  static int c(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    int j;
    if ((paramContext.getApplicationInfo().flags & 0x100000) != 0)
    {
      i = 1;
      j = localActivityManager.getMemoryClass();
      if ((i == 0) || (Build.VERSION.SDK_INT < 11)) {
        break label63;
      }
    }
    label63:
    for (int i = localActivityManager.getLargeMemoryClass();; i = j)
    {
      return i * 1048576 / 7;
      i = 0;
      break;
    }
  }
  
  static boolean c(InputStream paramInputStream)
  {
    boolean bool2 = false;
    byte[] arrayOfByte = new byte[12];
    boolean bool1 = bool2;
    if (paramInputStream.read(arrayOfByte, 0, 12) == 12)
    {
      bool1 = bool2;
      if ("RIFF".equals(new String(arrayOfByte, 0, 4, "US-ASCII")))
      {
        bool1 = bool2;
        if ("WEBP".equals(new String(arrayOfByte, 8, 4, "US-ASCII"))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  static boolean d(Context paramContext)
  {
    boolean bool = false;
    paramContext = paramContext.getContentResolver();
    try
    {
      int i = Settings.System.getInt(paramContext, "airplane_mode_on", 0);
      if (i != 0) {
        bool = true;
      }
    }
    catch (NullPointerException paramContext)
    {
      for (;;) {}
    }
    return bool;
  }
  
  private static final class a
    extends Thread
  {
    public a(Runnable paramRunnable)
    {
      super();
    }
    
    public final void run()
    {
      Process.setThreadPriority(10);
      super.run();
    }
  }
  
  static final class b
    implements ThreadFactory
  {
    public final Thread newThread(Runnable paramRunnable)
    {
      return new at.a(paramRunnable);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */