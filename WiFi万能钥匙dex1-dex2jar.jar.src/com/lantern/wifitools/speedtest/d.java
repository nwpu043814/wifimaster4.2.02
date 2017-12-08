package com.lantern.wifitools.speedtest;

import android.os.Handler;
import android.os.Message;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.wifitools.examination.r;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public final class d
{
  private long a;
  private boolean b;
  private Handler c;
  private Timer d;
  private long e;
  private int f;
  private long g;
  private long h;
  
  public d(Handler paramHandler)
  {
    this.c = paramHandler;
  }
  
  public final void a()
  {
    this.a = 0L;
    this.b = false;
    this.f = 0;
    this.h = 0L;
    new a((byte)0).start();
  }
  
  private final class a
    extends Thread
  {
    private URL b;
    
    private a() {}
    
    public final void run()
    {
      try
      {
        Object localObject1 = r.a(c.getInstance());
        Object localObject2 = new java/net/URL;
        ((URL)localObject2).<init>((String)localObject1);
        this.b = ((URL)localObject2);
        d.a(d.this);
        localObject1 = d.this;
        localObject2 = new java/util/Timer;
        ((Timer)localObject2).<init>();
        d.a((d)localObject1, (Timer)localObject2);
        localObject1 = d.b(d.this);
        localObject2 = new com/lantern/wifitools/speedtest/d$b;
        ((d.b)localObject2).<init>(d.this, (byte)0);
        ((Timer)localObject1).schedule((TimerTask)localObject2, 2900L, 1000L);
        d.a(d.this, System.currentTimeMillis());
        localObject1 = (HttpURLConnection)this.b.openConnection();
        ((HttpURLConnection)localObject1).setRequestMethod("GET");
        ((HttpURLConnection)localObject1).setRequestProperty("Range", "bytes=0-");
        localObject2 = ((HttpURLConnection)localObject1).getInputStream();
        localObject1 = new byte['Ѐ'];
        d.a(d.this, (int)(System.currentTimeMillis() - d.c(d.this)));
        do
        {
          int i = ((InputStream)localObject2).read((byte[])localObject1);
          if (i <= 0) {
            break;
          }
          d.b(d.this, i);
        } while (!d.d(d.this));
        ((InputStream)localObject2).close();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(localException);
        }
      }
    }
  }
  
  private final class b
    extends TimerTask
  {
    private b() {}
    
    public final void run()
    {
      if (d.e(d.this) > 7L) {
        d.f(d.this);
      }
      long l1;
      Message localMessage;
      if (!d.d(d.this))
      {
        l1 = d.g(d.this) - d.h(d.this);
        d.c(d.this, d.g(d.this));
        localMessage = new Message();
        localMessage.what = 0;
        if (d.i(d.this) == 1L)
        {
          localMessage.arg1 = ((int)l1 * 10 / 29);
          localMessage.arg2 = d.j(d.this);
          d.k(d.this).sendMessage(localMessage);
        }
      }
      for (;;)
      {
        return;
        localMessage.arg1 = ((int)l1);
        break;
        localMessage = new Message();
        localMessage.what = 1;
        long l2 = System.currentTimeMillis();
        l1 = d.c(d.this);
        localMessage.arg1 = ((int)(d.g(d.this) / (l2 - l1)) * 1000);
        d.k(d.this).sendMessage(localMessage);
        cancel();
        d.b(d.this).cancel();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/speedtest/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */