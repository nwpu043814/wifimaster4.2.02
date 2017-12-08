package com.lantern.feed.a;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import com.lantern.core.c;
import com.lantern.core.d.a.b;
import com.lantern.core.d.a.c;
import com.lantern.feed.R.string;
import com.lantern.feed.b.g;
import java.io.File;

public final class d
{
  private static String a;
  
  public static long a(g paramg, String paramString)
  {
    long l;
    if (paramg == null)
    {
      l = -1L;
      return l;
    }
    String str2 = com.lantern.feed.d.d.a(paramg.I(), paramg);
    Object localObject2;
    Object localObject1;
    String str1;
    if ((!TextUtils.isEmpty(str2)) && ((str2.startsWith("http")) || (str2.startsWith("https"))))
    {
      localObject2 = paramg.J();
      localObject1 = paramg.n(0);
      if (localObject1 != null)
      {
        str1 = ((com.lantern.feed.b.h)localObject1).w();
        label73:
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = com.bluefay.a.e.b(str2);
        }
        localObject2 = localObject1;
        if (!((String)localObject1).endsWith(".apk")) {
          localObject2 = (String)localObject1 + ".apk";
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new com/lantern/core/d/a$c;
        ((a.c)localObject1).<init>(Uri.parse(str2));
        ((a.c)localObject1).a(str1);
        ((a.c)localObject1).b("/WifiMasterKey/apk", (String)localObject2);
        ((a.c)localObject1).b(paramg.a());
        if (!TextUtils.isEmpty(b())) {
          ((a.c)localObject1).c(b());
        }
        l = new com.lantern.core.d.a(c.getAppContext()).a((a.c)localObject1);
        if (l <= 0L) {
          break label271;
        }
        Toast.makeText(c.getAppContext(), R.string.feed_download_start, 0).show();
        paramg.a(l);
        if (!TextUtils.isEmpty(paramString)) {
          break label261;
        }
        m.a().a(paramg);
      }
      catch (Exception paramg)
      {
        l = -1L;
      }
      str1 = "";
      break label73;
      break;
      label261:
      com.lantern.feed.channel.a.a.a().a(paramg);
      break;
      label271:
      Toast.makeText(c.getAppContext(), R.string.feed_download_failed, 0).show();
      break;
      l = -1L;
    }
  }
  
  public static void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
    localIntentFilter.addAction("android.intent.action.DOWNLOAD_STATUS_CHANGED");
    localIntentFilter.addAction("android.intent.action.DOWNLOAD_REMOVE");
    Object localObject = new e();
    c.getAppContext().registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addDataScheme("package");
    localObject = new f();
    c.getAppContext().registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
  }
  
  public static void a(long paramLong, String paramString)
  {
    new com.lantern.core.d.a(c.getAppContext()).b(new long[] { paramLong });
    if (TextUtils.isEmpty(paramString)) {
      m.a().a(paramLong);
    }
    for (;;)
    {
      return;
      com.lantern.feed.channel.a.a.a().a(paramLong);
    }
  }
  
  public static void a(g paramg)
  {
    int k = 4;
    int j = 1;
    if (paramg == null) {
      return;
    }
    Object localObject1;
    Cursor localCursor;
    label140:
    int i;
    if (paramg.D() > 0L)
    {
      localObject1 = new a.b();
      localCursor = new com.lantern.core.d.a(c.getAppContext()).a((a.b)localObject1);
      ((a.b)localObject1).a(new long[] { paramg.D() });
      if ((localCursor != null) && (localCursor.moveToFirst())) {
        switch (localCursor.getInt(localCursor.getColumnIndex("status")))
        {
        }
      }
      do
      {
        i = j;
        for (;;)
        {
          if (localCursor != null) {
            localCursor.close();
          }
          paramg.l(i);
          break;
          i = 3;
          continue;
          i = 2;
        }
        i = localCursor.getColumnIndex("local_uri");
      } while (i == -1);
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = localCursor.getString(i);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label578;
        }
        localObject2 = Uri.parse((String)localObject1);
        localObject1 = ((Uri)localObject2).getPath();
        File localFile = new java/io/File;
        localFile.<init>((String)localObject1);
        if (!localFile.exists()) {
          break label578;
        }
        paramg.a((Uri)localObject2);
        i = 4;
      }
      catch (Exception localException2) {}
      localCursor = c.getAppContext().getContentResolver().query(com.lantern.core.model.a.a, null, "description=?", new String[] { paramg.a() }, null);
      if ((localCursor != null) && (localCursor.moveToFirst())) {
        paramg.a(localCursor.getLong(localCursor.getColumnIndex("_id")));
      }
      switch (localCursor.getInt(localCursor.getColumnIndex("status")))
      {
      case 191: 
      case 197: 
      case 198: 
      case 199: 
      default: 
        i = 16;
        switch (i)
        {
        default: 
          i = 2;
        }
        break;
      case 190: 
        i = 1;
        break;
      case 192: 
        i = 2;
        break;
      case 193: 
      case 194: 
      case 195: 
      case 196: 
        i = 4;
        break;
      case 200: 
        i = 8;
        continue;
        i = 3;
        break;
        i = localCursor.getColumnIndex("_data");
        if (i != -1)
        {
          localObject1 = localCursor.getString(i);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            try
            {
              localObject2 = new java/io/File;
              ((File)localObject2).<init>((String)localObject1);
              localObject1 = Uri.parse(Uri.fromFile((File)localObject2).toString());
              localObject2 = new java/io/File;
              ((File)localObject2).<init>(((Uri)localObject1).getPath());
              if (!((File)localObject2).exists()) {
                break label573;
              }
              paramg.a((Uri)localObject1);
              i = k;
            }
            catch (Exception localException1)
            {
              com.bluefay.b.h.a(localException1);
            }
          }
        }
        i = j;
        break;
        break label140;
        label573:
        i = 1;
        continue;
        label578:
        i = 1;
      }
    }
  }
  
  public static boolean a(Uri paramUri)
  {
    boolean bool = false;
    com.bluefay.b.h.a("installApp aPath:" + paramUri.getPath(), new Object[0]);
    if (!new File(paramUri.getPath()).exists()) {
      Toast.makeText(c.getAppContext(), c.getAppContext().getString(R.string.feed_download_file_no_exist), 0).show();
    }
    for (;;)
    {
      return bool;
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setDataAndType(paramUri, "application/vnd.android.package-archive");
      localIntent.setFlags(268435456);
      com.bluefay.a.e.a(c.getAppContext(), localIntent);
      bool = true;
    }
  }
  
  private static String b()
  {
    Object localObject;
    if (!TextUtils.isEmpty(a)) {
      localObject = a;
    }
    for (;;)
    {
      return (String)localObject;
      try
      {
        localObject = new android/webkit/WebView;
        ((WebView)localObject).<init>(c.getAppContext());
        a = ((WebView)localObject).getSettings().getUserAgentString();
        ((WebView)localObject).destroy();
        localObject = a;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public static void b(long paramLong, String paramString)
  {
    new com.lantern.core.d.a(c.getAppContext()).c(new long[] { paramLong });
    if (TextUtils.isEmpty(paramString)) {
      m.a().b(paramLong);
    }
    for (;;)
    {
      return;
      com.lantern.feed.channel.a.a.a().b(paramLong);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */