package com.lantern.launcher;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.bluefay.b.h;
import com.bluefay.d.a;
import com.lantern.core.c;
import com.lantern.core.k;
import com.lantern.core.model.f;
import com.lantern.core.o;
import com.lantern.core.p;
import java.io.File;
import java.io.FileOutputStream;

public final class b
{
  private static int a(String paramString)
  {
    Runtime localRuntime = Runtime.getRuntime();
    try
    {
      paramString = localRuntime.exec(paramString);
      if (paramString == null) {
        break label22;
      }
      i = paramString.exitValue();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    return i;
  }
  
  private static String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("?");
    Object localObject1 = c.getInstance();
    Object localObject2 = c.getServer();
    localStringBuilder1.append("v=" + a.getVersionCode());
    localStringBuilder1.append("\\&appid=" + ((o)localObject2).k());
    localStringBuilder1.append("\\&chanid=" + k.l((Context)localObject1));
    localStringBuilder1.append("\\&lang=" + k.c());
    localObject2 = k.e((Context)localObject1);
    try
    {
      String str = p.j((Context)localObject1);
      StringBuilder localStringBuilder2 = new java/lang/StringBuilder;
      localStringBuilder2.<init>();
      localObject2 = k.c((Context)localObject1) + "," + (String)localObject2 + "," + str;
      h.a("ss:%s", new Object[] { localObject2 });
      localObject1 = com.lantern.core.g.n.a();
      localObject1 = com.lantern.core.n.a((String)localObject2, ((f)localObject1).b, ((f)localObject1).c);
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("\\&ss=");
      localStringBuilder1.append((String)localObject1);
      return localStringBuilder1.toString();
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static void a(Application paramApplication)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return;
    }
    String str = Environment.getDataDirectory() + "/data/" + paramApplication.getPackageName() + "/lib/libnative.so rpcx " + paramApplication.getPackageName();
    if (Build.VERSION.SDK_INT >= 17) {
      a(paramApplication, "am start -a android.intent.action.VIEW --user 0 -d http://wifi01.51y5.net/wifi/uninstall_form.php" + a());
    }
    for (;;)
    {
      a(str);
      break;
      a(paramApplication, "am start -a android.intent.action.VIEW -d http://wifi01.51y5.net/wifi/uninstall_form.php" + a());
    }
  }
  
  private static void a(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      paramContext = Environment.getDataDirectory() + "/data/" + paramContext.getPackageName() + "/rpc.cmd";
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("open file:");
      h.a(paramContext, new Object[0]);
      localObject = new java/io/FileOutputStream;
      File localFile = new java/io/File;
      localFile.<init>(paramContext);
      ((FileOutputStream)localObject).<init>(localFile);
      ((FileOutputStream)localObject).write(paramString.getBytes());
      ((FileOutputStream)localObject).close();
      paramContext = new java/lang/StringBuilder;
      paramContext.<init>("write cmd:(");
      h.a(paramString + ')', new Object[0]);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */