package com.lantern.bindapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import com.bluefay.b.h;
import com.lantern.bindapp.ui.BindAppView;
import com.lantern.core.d.a.c;
import com.lantern.core.g;
import com.lantern.core.g.b.a;
import com.lantern.core.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class a
{
  private static ArrayList<com.lantern.bindapp.a.a> a;
  private static ArrayList<com.lantern.bindapp.a.a> b;
  private static boolean c;
  private static Handler d;
  private static com.bluefay.b.a e = new b();
  private static com.bluefay.d.b f = new c(new int[] { 128501 });
  
  public static void a()
  {
    f().sendEmptyMessage(1);
  }
  
  public static void a(Context paramContext)
  {
    if ((com.bluefay.a.a.a(paramContext)) || (com.bluefay.a.a.b(paramContext)))
    {
      h.a("get bind apps", new Object[0]);
      new com.lantern.bindapp.b.c(e).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
      com.lantern.analytics.a.e().onEvent("bndrd");
    }
    for (;;)
    {
      return;
      h.a("no network!", new Object[0]);
      com.lantern.analytics.a.e().onEvent("bndrdno1_0");
    }
  }
  
  public static void a(Context paramContext, com.lantern.bindapp.a.a parama)
  {
    if (a == null) {}
    for (;;)
    {
      return;
      parama = com.lantern.bindapp.c.a.a(a, parama);
      if (parama == null)
      {
        h.a("ensureDownloadItem no item", new Object[0]);
      }
      else
      {
        h.a("start process bind item,%s", new Object[] { parama });
        com.lantern.analytics.a.e().onEvent("bndapp2", parama.a);
        Object localObject1 = parama.b.toLowerCase() + ".apk";
        String str = Environment.DIRECTORY_DOWNLOADS;
        Object localObject3 = new File(Environment.getExternalStoragePublicDirectory(str), (String)localObject1);
        Object localObject2;
        if (((File)localObject3).exists())
        {
          localObject2 = g.a((File)localObject3);
          h.a("local apk file md5:%s", new Object[] { localObject2 });
          if ((localObject2 != null) && (((String)localObject2).equalsIgnoreCase(parama.f)) && (com.lantern.bindapp.c.a.a(((File)localObject3).getAbsolutePath())))
          {
            a((File)localObject3, parama, true);
            com.lantern.analytics.a.e().onEvent("bndapp400", parama.a);
          }
          else
          {
            ((File)localObject3).delete();
          }
        }
        else
        {
          com.lantern.analytics.a.e().onEvent("bndapp30", parama.a);
          localObject3 = new com.lantern.core.d.a(paramContext);
          if (parama.k > 0L)
          {
            ((com.lantern.core.d.a)localObject3).a(new long[] { parama.k });
            parama.k = -1L;
          }
          localObject2 = new a.c(Uri.parse(parama.e));
          ((a.c)localObject2).b(str, (String)localObject1);
          ((a.c)localObject2).a();
          ((a.c)localObject2).a(false);
          ((a.c)localObject2).b(false);
          long l = ((com.lantern.core.d.a)localObject3).a((a.c)localObject2);
          if (l != -1L)
          {
            parama.k = l;
            localObject1 = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
            paramContext.getApplicationContext().registerReceiver(new b(parama), (IntentFilter)localObject1);
            new com.lantern.bindapp.b.a(parama, "downloading").execute(new String[0]);
            f().sendEmptyMessage(3);
          }
        }
      }
    }
  }
  
  private static void a(File paramFile, com.lantern.bindapp.a.a parama, boolean paramBoolean)
  {
    h.a("startInstallBindApp " + parama.toString(), new Object[0]);
    if ((paramFile != null) && (paramFile.exists())) {}
    for (;;)
    {
      try
      {
        localObject1 = new android/content/Intent;
        ((Intent)localObject1).<init>("android.intent.action.VIEW");
        ((Intent)localObject1).setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
        ((Intent)localObject1).addFlags(268435456);
        if (paramBoolean)
        {
          paramFile = new android/os/Handler;
          paramFile.<init>(Looper.getMainLooper());
          Object localObject2 = new com/lantern/bindapp/e;
          ((e)localObject2).<init>((Intent)localObject1);
          paramFile.postDelayed((Runnable)localObject2, 2000L);
          paramFile = com.lantern.core.g.b.a();
          localObject2 = parama.b.toLowerCase();
          localObject1 = new com/lantern/bindapp/a$a;
          ((a)localObject1).<init>(parama);
          paramFile.a((String)localObject2, (b.a)localObject1);
          return;
        }
      }
      catch (Exception paramFile)
      {
        Object localObject1;
        h.a("bind app install exception", paramFile);
        continue;
      }
      com.lantern.core.c.getInstance().startActivity((Intent)localObject1);
    }
  }
  
  public static View b(Context paramContext)
  {
    int i = 2;
    c = true;
    if (a == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      Object localObject1 = a;
      if ((localObject1 == null) || (((List)localObject1).size() == 0))
      {
        com.lantern.analytics.a.e().onEvent("bndapp0_N");
        h.a("list is empty", new Object[0]);
      }
      label155:
      label195:
      label205:
      label210:
      label278:
      label477:
      for (;;)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label479;
        }
        h.a("no item", new Object[0]);
        paramContext = null;
        break;
        localObject2 = com.bluefay.d.a.getAppContext().getPackageName();
        int j = com.bluefay.a.d.b(com.bluefay.d.a.getAppContext(), (String)localObject2, "bind_app_cfg_type");
        boolean bool;
        if (j != 0)
        {
          localObject2 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("dhid", "");
          bool = p.i(paramContext);
          if ((!bool) || (TextUtils.isEmpty((CharSequence)localObject2))) {
            break label195;
          }
          h.a("upgrade from 3.0,so this is an upgrade,bind cfgType:%s", new Object[] { Integer.valueOf(2) });
          if (j != i) {
            break label205;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label210;
          }
          com.lantern.analytics.a.e().onEvent("bndapp0_C");
          h.a("type:%s", new Object[] { Integer.valueOf(j) });
          break;
          if (!bool) {
            break label155;
          }
          i = 1;
          break label155;
        }
        long l2 = p.a("bind_app_last_show_time", 0L);
        long l1 = p.a("bind_app_show_interval", 0L);
        if (System.currentTimeMillis() - l2 >= l1) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label278;
          }
          com.lantern.analytics.a.e().onEvent("bndapp0_T");
          h.a("timeInterval:%s", new Object[] { Long.valueOf(l1) });
          break;
        }
        localObject2 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label477;
          }
          localObject1 = (com.lantern.bindapp.a.a)((Iterator)localObject2).next();
          l1 = ((com.lantern.bindapp.a.a)localObject1).j;
          if ((l1 == 0L) || (l1 >= System.currentTimeMillis()))
          {
            if (!com.bluefay.a.b.a(paramContext, ((com.lantern.bindapp.a.a)localObject1).b))
            {
              if (new File(com.lantern.core.c.getAppCacheDir(), com.bluefay.b.b.c(((com.lantern.bindapp.a.a)localObject1).c)).exists()) {
                break;
              }
              h.a("image is not exist " + ((com.lantern.bindapp.a.a)localObject1).toString(), new Object[0]);
              continue;
            }
            com.lantern.analytics.a.e().onEvent("bndapp01", ((com.lantern.bindapp.a.a)localObject1).a);
            h.a("is isntalled:%s", new Object[] { ((com.lantern.bindapp.a.a)localObject1).b });
            continue;
          }
          com.lantern.analytics.a.e().onEvent("bndapp02", ((com.lantern.bindapp.a.a)localObject1).a);
          h.a("is expired " + ((com.lantern.bindapp.a.a)localObject1).toString(), new Object[0]);
        }
      }
      label479:
      h.a("item " + ((com.lantern.bindapp.a.a)localObject1).toString(), new Object[0]);
      paramContext = new BindAppView(paramContext);
      paramContext.a((com.lantern.bindapp.a.a)localObject1);
      String str = "bndapp1_" + ((com.lantern.bindapp.a.a)localObject1).a;
      Object localObject2 = new JSONObject();
      try
      {
        if (!((com.lantern.bindapp.a.a)localObject1).l) {
          ((JSONObject)localObject2).put("mtrl", "00");
        }
        for (;;)
        {
          com.lantern.analytics.a.e().onEvent(str, ((JSONObject)localObject2).toString());
          p.b("bind_app_last_show_time", System.currentTimeMillis());
          new com.lantern.bindapp.b.a((com.lantern.bindapp.a.a)localObject1, "show").execute(new String[0]);
          break;
          if ((b == null) || (b.size() <= 0)) {
            break label660;
          }
          ((JSONObject)localObject2).put("mtrl", "01");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(localException);
          continue;
          label660:
          ((JSONObject)localObject2).put("mtrl", "02");
        }
      }
    }
  }
  
  private static Handler f()
  {
    if (d == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("bindApp");
      localHandlerThread.start();
      d = new Handler(localHandlerThread.getLooper(), new d());
    }
    return d;
  }
  
  private static final class a
    implements b.a
  {
    com.lantern.bindapp.a.a a;
    
    a(com.lantern.bindapp.a.a parama)
    {
      this.a = parama;
    }
    
    public final void a()
    {
      String str = this.a.a;
      com.lantern.analytics.a.e().onEvent("bndapp41", str);
    }
  }
  
  private static final class b
    extends BroadcastReceiver
  {
    private com.lantern.bindapp.a.a a;
    
    b(com.lantern.bindapp.a.a parama)
    {
      this.a = parama;
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      com.lantern.bindapp.a.a locala;
      if (paramIntent.getLongExtra("extra_download_id", 0L) == this.a.k)
      {
        locala = com.lantern.bindapp.c.a.a(a.c(), this.a);
        if (locala != null) {
          break label36;
        }
      }
      label36:
      label499:
      for (;;)
      {
        return;
        paramIntent = new com.lantern.core.d.a(paramContext);
        Object localObject = new com.lantern.core.d.a.b();
        ((com.lantern.core.d.a.b)localObject).a(new long[] { locala.k });
        localCursor = paramIntent.a((com.lantern.core.d.a.b)localObject);
        if (localCursor != null) {}
        for (;;)
        {
          try
          {
            if (localCursor.moveToFirst())
            {
              i = localCursor.getInt(localCursor.getColumnIndex("status"));
              if (i != 8)
              {
                h.a("bind app download status:%s", new Object[] { Integer.valueOf(i) });
                if (localCursor == null) {
                  break;
                }
                localCursor.close();
                break;
              }
              h.a("bind app download finish!", new Object[0]);
              locala.k = -1L;
              paramContext.unregisterReceiver(this);
              paramContext = new com/lantern/bindapp/b/a;
              paramContext.<init>(locala, "downloaded");
              paramContext.execute(new String[0]);
              a.d().sendEmptyMessage(3);
              i = localCursor.getColumnIndex("_data");
              paramIntent = null;
              paramContext = null;
              if (i == -1) {}
            }
          }
          finally
          {
            int i;
            boolean bool;
            if (localCursor != null) {
              localCursor.close();
            }
          }
          try
          {
            localObject = Uri.parse(localCursor.getString(i)).getPath();
            paramContext = (Context)localObject;
            paramIntent = (Intent)localObject;
            if (((String)localObject).contains("/"))
            {
              paramIntent = (Intent)localObject;
              i = ((String)localObject).lastIndexOf('/') + 1;
              paramContext = (Context)localObject;
              if (i > 0)
              {
                paramIntent = (Intent)localObject;
                paramContext = ((String)localObject).substring(i);
              }
            }
          }
          catch (Exception paramContext)
          {
            paramContext = paramIntent;
          }
        }
        bool = TextUtils.isEmpty(paramContext);
        if (bool)
        {
          if (localCursor != null) {
            localCursor.close();
          }
        }
        else
        {
          h.a("bind app download successful,named: %s", new Object[] { paramContext });
          paramIntent = new java/io/File;
          paramIntent.<init>(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), paramContext);
          paramContext = locala.f;
          if (!TextUtils.isEmpty(paramContext))
          {
            localObject = g.a(paramIntent);
            h.a("server apk md5:%s", new Object[] { paramContext });
            h.a("download finish local apk file md5:%s", new Object[] { localObject });
            if (!paramContext.equalsIgnoreCase((String)localObject))
            {
              paramIntent = new java/lang/StringBuilder;
              paramIntent.<init>("the md5 verify failed;fileMd5:");
              h.c((String)localObject + "-----serverMd5:" + paramContext);
              if (localCursor != null) {
                localCursor.close();
              }
            }
            else
            {
              a.a(paramIntent, locala);
              com.lantern.analytics.a.e().onEvent("bndapp31", locala.a);
            }
          }
          else
          {
            for (;;)
            {
              if (localCursor == null) {
                break label499;
              }
              localCursor.close();
              break;
              if (com.lantern.bindapp.c.a.a(paramIntent.getAbsolutePath()))
              {
                a.a(paramIntent, locala);
                com.lantern.analytics.a.e().onEvent("bndapp31", locala.a);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/bindapp/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */