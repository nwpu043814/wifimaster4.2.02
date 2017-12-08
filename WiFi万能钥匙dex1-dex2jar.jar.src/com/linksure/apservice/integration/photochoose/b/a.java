package com.linksure.apservice.integration.photochoose.b;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public final class a
{
  private static final Executor a = Executors.newFixedThreadPool(10);
  private static a i;
  private LruCache<String, Bitmap> b;
  private LinkedList<a> c;
  private volatile Semaphore d;
  private Handler e;
  private Thread f;
  private Handler g;
  private volatile Semaphore h = new Semaphore(0);
  private int j;
  
  private a()
  {
    if (this.b != null) {}
    try
    {
      if (this.b != null) {
        this.b.evictAll();
      }
      this.b = new e(this, (int)Runtime.getRuntime().maxMemory() / 8);
      this.e = new b(this);
      this.f = new c(this);
      this.f.start();
      this.c = new LinkedList();
      this.d = new Semaphore(10);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private Bitmap a(String paramString)
  {
    return (Bitmap)this.b.get(paramString);
  }
  
  public static a a()
  {
    try
    {
      if (i == null)
      {
        locala = new com/linksure/apservice/integration/photochoose/b/a;
        locala.<init>();
        i = locala;
      }
      a locala = i;
      return locala;
    }
    finally {}
  }
  
  /* Error */
  private void a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 146	com/linksure/apservice/integration/photochoose/b/a:g	Landroid/os/Handler;
    //   6: ifnonnull +10 -> 16
    //   9: aload_0
    //   10: getfield 51	com/linksure/apservice/integration/photochoose/b/a:h	Ljava/util/concurrent/Semaphore;
    //   13: invokevirtual 157	java/util/concurrent/Semaphore:acquire	()V
    //   16: aload_0
    //   17: getfield 95	com/linksure/apservice/integration/photochoose/b/a:c	Ljava/util/LinkedList;
    //   20: aload_1
    //   21: invokevirtual 161	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   24: pop
    //   25: aload_0
    //   26: getfield 146	com/linksure/apservice/integration/photochoose/b/a:g	Landroid/os/Handler;
    //   29: iconst_0
    //   30: invokevirtual 167	android/os/Handler:sendEmptyMessage	(I)Z
    //   33: pop
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_2
    //   43: goto -27 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	a
    //   0	46	1	parama	a
    //   42	1	2	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	16	37	finally
    //   16	34	37	finally
    //   2	16	42	java/lang/InterruptedException
  }
  
  private a c()
  {
    try
    {
      a locala = (a)this.c.removeLast();
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(String paramString, ImageView paramImageView, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramImageView == null)) {
      throw new IllegalArgumentException("args may not be null");
    }
    this.j = paramInt;
    paramImageView.setTag(paramString);
    Bitmap localBitmap = a(paramString);
    if (localBitmap == null) {
      a(new a(paramString, paramImageView));
    }
    for (;;)
    {
      return;
      b localb = new b((byte)0);
      localb.a = localBitmap;
      localb.b = paramImageView;
      localb.c = paramString;
      paramString = Message.obtain();
      paramString.obj = localb;
      this.e.sendMessage(paramString);
    }
  }
  
  public final class a
    extends AsyncTask<Integer, Object, Bitmap>
  {
    private final String b;
    private final WeakReference<ImageView> c;
    
    public a(String paramString, ImageView paramImageView)
    {
      if ((paramImageView == null) || (paramString == null)) {
        throw new IllegalArgumentException("args may not be null");
      }
      this.b = paramString;
      this.c = new WeakReference(paramImageView);
    }
  }
  
  private final class b
  {
    Bitmap a;
    ImageView b;
    String c;
    
    private b() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */