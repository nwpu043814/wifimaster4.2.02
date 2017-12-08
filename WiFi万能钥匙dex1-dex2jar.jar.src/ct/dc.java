package ct;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.tencentmap.lbssdk.service.e.a;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class dc
  implements Thread.UncaughtExceptionHandler
{
  private static final String a = TencentLocation.class.getPackage().getName();
  private final Context b;
  private final String c;
  private final String d;
  private final Thread.UncaughtExceptionHandler e;
  
  private dc(Context paramContext, String paramString1, String paramString2)
  {
    this.b = paramContext;
    this.c = paramString1;
    this.d = paramString2;
    this.e = Thread.getDefaultUncaughtExceptionHandler();
  }
  
  private static String a(Context paramContext, Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      Object localObject1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      localObject2 = bi.a(paramContext).i();
      if (localObject2 != null)
      {
        str = ((bj)localObject2).d();
        if (localObject2 == null) {
          break label533;
        }
        localObject2 = ((bj)localObject2).e();
        localStringBuilder = new StringBuilder("SDK_V" + str + "_Errlog|");
        localStringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date())).append("|");
        localObject3 = (TelephonyManager)paramContext.getSystemService("phone");
        if (localObject3 == null) {
          break label563;
        }
        localObject3 = ((TelephonyManager)localObject3).getDeviceId();
        localStringBuilder.append((String)localObject3).append("|");
        localStringBuilder.append(str).append("|");
        localStringBuilder.append((String)localObject2).append("|");
        localStringBuilder.append(paramContext.getPackageName()).append("|");
        localStringBuilder.append(((PackageInfo)localObject1).versionName).append("|");
        localStringBuilder.append(((PackageInfo)localObject1).versionCode).append("|");
        localStringBuilder.append(Build.VERSION.RELEASE).append("|");
        localStringBuilder.append(Build.MODEL).append("|");
        localStringBuilder.append("android-").append(Build.VERSION.SDK_INT).append("|");
        localStringBuilder.append(paramThread.getName()).append("|");
        localStringBuilder.append("ExceptionClass:").append(paramThrowable.getClass()).append("|");
        localStringBuilder.append("ExceptionMessage:").append(paramThrowable.getMessage()).append("|");
        localStringBuilder.append("ExceptionDetails:");
        localObject1 = new StringWriter();
        paramThread = new PrintWriter((Writer)localObject1);
        paramThrowable.printStackTrace(paramThread);
        localObject1 = localObject1.toString().replaceAll("\r|\n", "__");
        paramThread.close();
        localStringBuilder.append((String)localObject1);
        if ((paramThrowable instanceof LinkageError))
        {
          localStringBuilder.append("|").append(Build.CPU_ABI).append(",").append(Build.CPU_ABI2).append("|");
          if (Build.VERSION.SDK_INT <= 8) {
            break label541;
          }
          paramThread = new File(paramContext.getApplicationInfo().nativeLibraryDir);
          if ((paramThread != null) && (paramThread.isDirectory())) {
            localStringBuilder.append(paramThread.getAbsolutePath()).append("|").append(Arrays.toString(paramThread.list()));
          }
          localStringBuilder.append("|");
          paramContext = new File(paramContext.getFilesDir(), "libtencentloc.so");
          if (!paramContext.exists()) {
            break label553;
          }
          localStringBuilder.append(paramContext.length());
        }
        return localStringBuilder.toString();
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        PackageInfo localPackageInfo = new PackageInfo();
        continue;
        String str = "None";
        continue;
        label533:
        Object localObject2 = "None";
        continue;
        label541:
        paramThread = paramContext.getDir("lib", 0);
        continue;
        label553:
        localStringBuilder.append(0);
        continue;
        label563:
        Object localObject3 = "";
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof dc))
    {
      File localFile = new File(paramContext.getDir("txsdklog", 0), "raw");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      Thread.setDefaultUncaughtExceptionHandler(new dc(paramContext, localFile.getAbsolutePath(), "http://moon.sinaapp.com/andr/uploadlog"));
    }
  }
  
  private boolean a(Throwable paramThrowable)
  {
    boolean bool2 = false;
    if (paramThrowable == null) {}
    for (boolean bool1 = bool2;; bool1 = true)
    {
      return bool1;
      if (bi.a(this.b).h().r) {
        break;
      }
    }
    label110:
    for (;;)
    {
      paramThrowable = paramThrowable.getCause();
      bool1 = bool2;
      if (paramThrowable == null) {
        break;
      }
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      int j = arrayOfStackTraceElement.length;
      for (int i = 0;; i++)
      {
        if (i >= j) {
          break label110;
        }
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        if (("TL".equals(localStackTraceElement.getFileName())) || (localStackTraceElement.getClassName().contains(a)))
        {
          bool1 = true;
          break;
        }
      }
    }
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str;
    if ((paramThrowable instanceof e.a))
    {
      if (!bi.a(this.b).a("so").b(bw.a)) {
        b.a.a("UNHANDLED_EXCEPTION", "PluginLoadSo load failed");
      }
    }
    else if (bi.a(this.b).h().s) {
      str = a(this.b, paramThread, paramThrowable);
    }
    try
    {
      Object localObject = new java/io/File;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      ((File)localObject).<init>(this.c + "/" + UUID.randomUUID());
      b.a.a(str, (File)localObject, Charset.defaultCharset());
      if (a(paramThrowable))
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss_", Locale.ENGLISH).format(new Date()) + (int)(Math.random() * 10000.0D);
        localObject = (String)localObject + ".stacktrace";
        str = a(this.b, paramThread, paramThrowable);
        if (this.d != null) {
          localObject = dd.a(bi.a(this.b), "http://lstest.map.qq.com/stat", str, this.c + "/" + (String)localObject);
        }
      }
      try
      {
        ((CountDownLatch)localObject).await(30L, TimeUnit.SECONDS);
        this.e.uncaughtException(paramThread, paramThrowable);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */