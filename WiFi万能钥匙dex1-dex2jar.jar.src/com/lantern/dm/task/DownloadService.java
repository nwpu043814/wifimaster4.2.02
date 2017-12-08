package com.lantern.dm.task;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import com.bluefay.b.h;
import com.qihoo.util.StubApp1053578832;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadService
  extends Service
{
  private a a;
  private b b;
  private Map<Long, a> c = new HashMap();
  private ConcurrentHashMap<Long, a> d = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, Integer> e = new ConcurrentHashMap();
  private b f;
  private boolean g;
  private i h;
  
  static
  {
    StubApp1053578832.interface11(14);
  }
  
  private void a()
  {
    try
    {
      this.g = true;
      if (this.f == null)
      {
        b localb = new com/lantern/dm/task/DownloadService$b;
        localb.<init>(this);
        this.f = localb;
        this.h.a(this.f);
      }
      return;
    }
    finally {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    throw new UnsupportedOperationException("Cannot bind to Download Manager Service");
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.h == null) {
      this.h = new f(this);
    }
    this.a = new a();
    getContentResolver().registerContentObserver(com.lantern.core.model.a.b, true, this.a);
    this.b = new b(this, this.h);
    a();
  }
  
  public void onDestroy()
  {
    getContentResolver().unregisterContentObserver(this.a);
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    a();
    return paramInt1;
  }
  
  private final class a
    extends ContentObserver
  {
    public a()
    {
      super();
    }
    
    public final void onChange(boolean paramBoolean)
    {
      DownloadService.a(DownloadService.this);
    }
  }
  
  private final class b
    extends Thread
  {
    public b()
    {
      super();
    }
    
    public final void run()
    {
      Process.setThreadPriority(10);
      DownloadService.b(DownloadService.this);
      DownloadService.c(DownloadService.this);
      int i = 0;
      long l2 = Long.MAX_VALUE;
      for (;;)
      {
        synchronized (DownloadService.this)
        {
          if (DownloadService.d(DownloadService.this) != this)
          {
            IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
            localIllegalStateException.<init>("multiple UpdateThreads in DownloadService");
            throw localIllegalStateException;
          }
        }
        if (!DownloadService.e(DownloadService.this))
        {
          DownloadService.f(DownloadService.this);
          if (i == 0) {
            DownloadService.this.stopSelf();
          }
          if (l2 != Long.MAX_VALUE)
          {
            localObject5 = (AlarmManager)DownloadService.this.getSystemService("alarm");
            if (localObject5 != null) {
              break label144;
            }
            h.b("DownloadService", new Object[] { "couldn't get alarm manager" });
          }
          for (;;)
          {
            return;
            label144:
            localObject6 = new android/content/Intent;
            ((Intent)localObject6).<init>("android.intent.action.DOWNLOAD_WAKEUP");
            ((Intent)localObject6).setClassName(DownloadService.this.getPackageName(), DownloadReceiver.class.getName());
            ((AlarmManager)localObject5).set(0, l2 + DownloadService.h(DownloadService.this).a(), PendingIntent.getBroadcast(DownloadService.this, 0, (Intent)localObject6, 1073741824));
          }
        }
        DownloadService.g(DownloadService.this);
        long l4 = DownloadService.h(DownloadService.this).a();
        Object localObject6 = new HashSet(DownloadService.i(DownloadService.this).keySet());
        Object localObject5 = DownloadService.this.getContentResolver().query(com.lantern.core.model.a.b, null, null, null, null);
        if (localObject5 != null) {
          label799:
          for (;;)
          {
            try
            {
              a.a locala = new com/lantern/dm/task/a$a;
              locala.<init>((Cursor)localObject5);
              int k = ((Cursor)localObject5).getColumnIndexOrThrow("_id");
              ((Cursor)localObject5).moveToFirst();
              l2 = Long.MAX_VALUE;
              i = 0;
              if (!((Cursor)localObject5).isAfterLast())
              {
                long l1 = ((Cursor)localObject5).getLong(k);
                ((Set)localObject6).remove(Long.valueOf(l1));
                ??? = (a)DownloadService.i(DownloadService.this).get(Long.valueOf(l1));
                if (??? != null)
                {
                  DownloadService.a(DownloadService.this, locala, (a)???, l4);
                  if ((com.lantern.core.model.a.b(((a)???).j)) && (((a)???).h == 1))
                  {
                    j = 1;
                    if (j == 0) {
                      break label799;
                    }
                    i = 1;
                    if (!com.lantern.core.model.a.b(((a)???).j)) {
                      continue;
                    }
                    l1 = -1L;
                    if (l1 != 0L) {
                      continue;
                    }
                    j = 1;
                    l3 = l2;
                    ((Cursor)localObject5).moveToNext();
                    i = j;
                    l2 = l3;
                  }
                }
                else
                {
                  ??? = DownloadService.a(DownloadService.this, locala, l4);
                  continue;
                }
                j = 0;
                continue;
                if (((a)???).j != 194)
                {
                  l1 = 0L;
                  continue;
                }
                l1 = ((a)???).a(l4);
                if (l1 <= l4)
                {
                  l1 = 0L;
                  continue;
                }
                l1 -= l4;
                continue;
                j = i;
                long l3 = l2;
                if (l1 <= 0L) {
                  continue;
                }
                j = i;
                l3 = l2;
                if (l1 >= l2) {
                  continue;
                }
                j = i;
                l3 = l1;
                continue;
              }
              ((Cursor)localObject5).close();
              ??? = ((Set)localObject6).iterator();
              if (((Iterator)???).hasNext())
              {
                localObject5 = (Long)((Iterator)???).next();
                DownloadService.a(DownloadService.this, ((Long)localObject5).longValue());
                continue;
              }
              localObject3 = DownloadService.i(DownloadService.this).values().iterator();
            }
            finally
            {
              ((Cursor)localObject5).close();
            }
            do
            {
              j = i;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            } while (!((a)((Iterator)localObject3).next()).w);
            int j = 1;
            Object localObject3 = DownloadService.k(DownloadService.this);
            DownloadService.i(DownloadService.this).values();
            ((b)localObject3).a(DownloadService.j(DownloadService.this).values());
            localObject3 = DownloadService.i(DownloadService.this).values().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (a)((Iterator)localObject3).next();
              if (((a)localObject5).w) {
                e.a(DownloadService.this.getContentResolver(), ((a)localObject5).a, ((a)localObject5).e);
              }
            }
            i = j;
            break;
          }
        }
        l2 = Long.MAX_VALUE;
        i = 0;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/task/DownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */