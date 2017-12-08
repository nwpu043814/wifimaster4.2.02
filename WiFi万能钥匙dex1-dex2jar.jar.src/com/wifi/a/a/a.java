package com.wifi.a.a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import bluefay.app.k.a;
import com.lantern.connect.R.string;
import com.lantern.core.c;
import com.lantern.core.config.AppStoreConf;
import com.lantern.core.config.d;
import com.lantern.core.p;
import java.io.File;

public final class a
{
  private Context a;
  private m b;
  private File c;
  private BroadcastReceiver d;
  private com.lantern.core.d.a e;
  private long f;
  private boolean g = false;
  private com.bluefay.b.a h = new e(this);
  private com.bluefay.b.a i = new f(this);
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  /* Error */
  private static int a(com.lantern.core.d.a parama, long paramLong)
  {
    // Byte code:
    //   0: new 46	com/lantern/core/d/a$b
    //   3: dup
    //   4: invokespecial 47	com/lantern/core/d/a$b:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: iconst_1
    //   12: newarray <illegal type>
    //   14: dup
    //   15: iconst_0
    //   16: lload_1
    //   17: lastore
    //   18: invokevirtual 50	com/lantern/core/d/a$b:a	([J)Lcom/lantern/core/d/a$b;
    //   21: pop
    //   22: aload_0
    //   23: aload 4
    //   25: invokevirtual 55	com/lantern/core/d/a:a	(Lcom/lantern/core/d/a$b;)Landroid/database/Cursor;
    //   28: astore_0
    //   29: aload_0
    //   30: ifnull +41 -> 71
    //   33: aload_0
    //   34: invokeinterface 61 1 0
    //   39: ifeq +26 -> 65
    //   42: aload_0
    //   43: aload_0
    //   44: ldc 63
    //   46: invokeinterface 67 2 0
    //   51: invokeinterface 71 2 0
    //   56: istore_3
    //   57: aload_0
    //   58: invokeinterface 74 1 0
    //   63: iload_3
    //   64: ireturn
    //   65: aload_0
    //   66: invokeinterface 74 1 0
    //   71: iconst_m1
    //   72: istore_3
    //   73: goto -10 -> 63
    //   76: astore 4
    //   78: aload_0
    //   79: invokeinterface 74 1 0
    //   84: aload 4
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	parama	com.lantern.core.d.a
    //   0	87	1	paramLong	long
    //   56	17	3	j	int
    //   7	17	4	localb	com.lantern.core.d.a.b
    //   76	9	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   33	57	76	finally
  }
  
  private void a(String paramString, int paramInt)
  {
    int j = 0;
    if ((this.a instanceof bluefay.app.b)) {
      j = 1;
    }
    if (j == 0) {}
    for (;;)
    {
      return;
      if (((bluefay.app.b)this.a).c())
      {
        com.bluefay.b.h.c("Activity is not running");
      }
      else
      {
        k.a locala = new k.a(this.a);
        locala.a(R.string.dialog_title_none_aps);
        locala.b(paramString);
        locala.a(R.string.btn_yes, new g(this, paramInt));
        locala.a(new h(this, paramInt));
        locala.b(R.string.btn_no, new i(this, paramInt));
        locala.d();
      }
    }
  }
  
  private void b()
  {
    if (this.d == null)
    {
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
      localIntentFilter.addAction("android.intent.action.DOWNLOAD_REMOVE");
      this.d = new b(this);
      this.a.registerReceiver(this.d, localIntentFilter);
    }
    this.e = new com.lantern.core.d.a(c.getAppContext());
  }
  
  private File c(m paramm)
  {
    String str = com.bluefay.b.b.d(paramm.b());
    Object localObject = com.bluefay.b.b.b(paramm.b());
    str = String.format("%s-%d.%s", new Object[] { str, Integer.valueOf(paramm.a()), localObject });
    localObject = new File(this.c, str);
    paramm = (m)localObject;
    if (!((File)localObject).exists()) {
      paramm = new File(this.c, str);
    }
    return paramm;
  }
  
  private String c()
  {
    String str = "n";
    if (com.bluefay.a.a.a(this.a)) {
      str = "w";
    }
    for (;;)
    {
      return str;
      if (com.bluefay.a.a.b(this.a)) {
        str = "g";
      }
    }
  }
  
  private static boolean d(m paramm)
  {
    boolean bool = true;
    String str = com.bluefay.b.i.a(new File(paramm.f()));
    if (str.equals(paramm.e().toUpperCase())) {}
    for (;;)
    {
      return bool;
      com.bluefay.b.h.b("file sign:%s expect:%s", new Object[] { str, paramm.e() });
      bool = false;
    }
  }
  
  public final void a()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        com.bluefay.a.e.a(R.string.map_download_no_sd);
      }
      for (;;)
      {
        return;
        if (this.c == null)
        {
          this.c = new File(c.getAppExternalRootDir(), "maps");
          if (!this.c.exists()) {
            this.c.mkdir();
          }
          b();
        }
        Object localObject = (AppStoreConf)d.a(this.a).a(AppStoreConf.class);
        this.b = new m();
        this.b.a(((AppStoreConf)localObject).h());
        this.b.b(((AppStoreConf)localObject).i());
        this.b.c(((AppStoreConf)localObject).k());
        this.b.a(((AppStoreConf)localObject).j());
        this.b.d(((AppStoreConf)localObject).l());
        j = com.wifi.a.b.a.a(this.a, this.b.c());
        if ((j > 0) && (j == this.b.a()))
        {
          Context localContext = this.a;
          localObject = this.b.c();
          String str = this.b.d();
          try
          {
            Intent localIntent = new android/content/Intent;
            localIntent.<init>();
            ComponentName localComponentName = new android/content/ComponentName;
            localComponentName.<init>((String)localObject, str);
            localIntent.setComponent(localComponentName);
            localIntent.addFlags(268435456);
            localIntent.setAction("android.intent.action.MAIN");
            localContext.startActivity(localIntent);
            com.lantern.analytics.a.e().onEvent("map_clickop");
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
        else
        {
          File localFile = c(this.b);
          this.b.e(localFile.getAbsolutePath());
          if ((localFile.exists()) && (d(this.b)))
          {
            com.wifi.a.b.a.b(this.a, this.b.f());
          }
          else
          {
            this.f = p.a("mapdownload", -1L);
            com.bluefay.b.h.a("download id =" + this.f, new Object[0]);
            if (this.e != null)
            {
              j = a(this.e, this.f);
              if (this.g)
              {
                if ((j != 190) || (j != 192))
                {
                  this.e.c(new long[] { this.f });
                  com.bluefay.a.e.a(R.string.map_download_downloading);
                }
              }
              else if (com.bluefay.a.a.a(this.a))
              {
                a(this.a.getString(R.string.map_dialog_download), 0);
                com.lantern.analytics.a.e().onEvent("map_w");
              }
              else if (com.bluefay.a.a.b(this.a))
              {
                a(this.a.getString(R.string.map_dialog_download_by_mobile_net), 1);
                com.lantern.analytics.a.e().onEvent("map_g");
              }
              else
              {
                com.bluefay.a.e.a(this.a.getString(R.string.key_query_failed));
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */