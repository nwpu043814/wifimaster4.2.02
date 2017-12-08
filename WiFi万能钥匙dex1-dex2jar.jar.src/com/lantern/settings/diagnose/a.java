package com.lantern.settings.diagnose;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.bluefay.b.h;
import com.lantern.core.p;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class a
{
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      p.c("dinosag_dg_t", System.currentTimeMillis());
    }
    for (;;)
    {
      return;
      p.c("dinosag_dg_t", 0L);
    }
  }
  
  public static boolean a()
  {
    long l1 = System.currentTimeMillis();
    String str = com.bluefay.d.a.getAppContext().getPackageName();
    long l2 = com.bluefay.d.a.getAppContext().getSharedPreferences(str, 4).getLong("dinosag_dg_t", 0L);
    if ((l1 - l2 <= 6000000L) && (l1 - l2 > 0L)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b()
  {
    boolean bool = false;
    if (!Environment.getExternalStorageState().equals("mounted")) {}
    for (;;)
    {
      return bool;
      Object localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      try
      {
        Object localObject2 = new java/text/SimpleDateFormat;
        ((SimpleDateFormat)localObject2).<init>("yyyyMMdd_HHmmSS");
        String str = ((SimpleDateFormat)localObject2).format(Calendar.getInstance().getTime());
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("wifikey_");
        str = str + ".wk";
        localObject2 = new java/io/File;
        ((File)localObject2).<init>((File)localObject1, str);
        h.a(1);
        localObject1 = new java/io/FileOutputStream;
        ((FileOutputStream)localObject1).<init>((File)localObject2);
        h.a(2, (OutputStream)localObject1);
        h.a("-----diagnose mode enabled-----", new Object[0]);
        bool = true;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        h.a(localFileNotFoundException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/diagnose/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */