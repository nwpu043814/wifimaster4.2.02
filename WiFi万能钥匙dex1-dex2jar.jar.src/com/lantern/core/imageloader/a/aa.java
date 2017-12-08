package com.lantern.core.imageloader.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class aa
{
  static final Handler a = new ab(Looper.getMainLooper());
  static volatile aa b = null;
  final Context c;
  final p d;
  final j e;
  final ak f;
  final Map<Object, a> g;
  final Map<ImageView, o> h;
  final ReferenceQueue<Object> i;
  final Bitmap.Config j;
  boolean k;
  volatile boolean l;
  boolean m;
  private final c n;
  private final f o;
  private final b p;
  private final List<ai> q;
  
  aa(Context paramContext, p paramp, j paramj, c paramc, f paramf, List<ai> paramList, ak paramak, Bitmap.Config paramConfig, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramContext;
    this.d = paramp;
    this.e = paramj;
    this.n = paramc;
    this.o = paramf;
    this.j = paramConfig;
    if (paramList != null) {}
    for (int i1 = paramList.size();; i1 = 0)
    {
      paramj = new ArrayList(i1 + 7);
      paramj.add(new aj(paramContext));
      if (paramList != null) {
        paramj.addAll(paramList);
      }
      paramj.add(new m(paramContext));
      paramj.add(new w(paramContext));
      paramj.add(new n(paramContext));
      paramj.add(new b(paramContext));
      paramj.add(new s(paramContext));
      paramj.add(new z(paramp.d, paramak));
      this.q = Collections.unmodifiableList(paramj);
      this.f = paramak;
      this.g = new WeakHashMap();
      this.h = new WeakHashMap();
      this.k = paramBoolean1;
      this.l = paramBoolean2;
      this.i = new ReferenceQueue();
      this.p = new b(this.i, a);
      this.p.start();
      return;
    }
  }
  
  public static aa a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null)
      {
        a locala = new com/lantern/core/imageloader/a/aa$a;
        locala.<init>(paramContext);
        b = locala.a();
      }
      return b;
    }
    finally {}
  }
  
  private ah a(Uri paramUri)
  {
    return new ah(this, paramUri, 0);
  }
  
  private void a(Bitmap paramBitmap, d paramd, a parama)
  {
    if (parama.l) {}
    for (;;)
    {
      return;
      if (!parama.k) {
        this.g.remove(parama.c());
      }
      if (paramBitmap != null)
      {
        if (paramd == null) {
          throw new AssertionError("LoadedFrom cannot be null.");
        }
        parama.a(paramBitmap, paramd);
        if (this.l) {
          at.a("Main", "completed", parama.b.a(), "from " + paramd);
        }
      }
      else
      {
        parama.a();
        if (this.l) {
          at.a("Main", "errored", parama.b.a());
        }
      }
    }
  }
  
  private void c(Object paramObject)
  {
    at.a();
    a locala = (a)this.g.remove(paramObject);
    Object localObject;
    if (locala != null)
    {
      locala.b();
      localObject = this.d;
      ((p)localObject).i.sendMessage(((p)localObject).i.obtainMessage(2, locala));
    }
    if ((paramObject instanceof ImageView))
    {
      paramObject = (ImageView)paramObject;
      paramObject = (o)this.h.remove(paramObject);
      if (paramObject != null)
      {
        ((o)paramObject).a.c();
        ((o)paramObject).c = null;
        localObject = (ImageView)((o)paramObject).b.get();
        if (localObject != null)
        {
          localObject = ((ImageView)localObject).getViewTreeObserver();
          if (((ViewTreeObserver)localObject).isAlive()) {
            ((ViewTreeObserver)localObject).removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)paramObject);
          }
        }
      }
    }
  }
  
  final ag a(ag paramag)
  {
    ag localag = this.o.a(paramag);
    if (localag == null) {
      throw new IllegalStateException("Request transformer " + this.o.getClass().getCanonicalName() + " returned null for " + paramag);
    }
    return localag;
  }
  
  public final ah a(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Resource ID must not be zero.");
    }
    return new ah(this, null, paramInt);
  }
  
  public final ah a(File paramFile)
  {
    return a(Uri.fromFile(paramFile));
  }
  
  public final ah a(String paramString)
  {
    if (paramString == null) {}
    for (paramString = new ah(this, null, 0);; paramString = a(Uri.parse(paramString)))
    {
      return paramString;
      if (paramString.trim().length() == 0) {
        throw new IllegalArgumentException("Path must not be empty.");
      }
    }
  }
  
  public final void a()
  {
    this.e.c();
  }
  
  public final void a(ImageView paramImageView)
  {
    c(paramImageView);
  }
  
  final void a(ImageView paramImageView, o paramo)
  {
    if (this.h.containsKey(paramImageView)) {
      c(paramImageView);
    }
    this.h.put(paramImageView, paramo);
  }
  
  final void a(a parama)
  {
    Object localObject = parama.c();
    if ((localObject != null) && (this.g.get(localObject) != parama))
    {
      c(localObject);
      this.g.put(localObject, parama);
    }
    localObject = this.d;
    ((p)localObject).i.sendMessage(((p)localObject).i.obtainMessage(1, parama));
  }
  
  public final void a(an paraman)
  {
    c(paraman);
  }
  
  final void a(c paramc)
  {
    int i3 = 1;
    a locala = paramc.k;
    List localList = paramc.l;
    int i1;
    int i2;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i1 = 1;
      i2 = i3;
      if (locala == null)
      {
        if (i1 == 0) {
          break label57;
        }
        i2 = i3;
      }
      label47:
      if (i2 != 0) {
        break label62;
      }
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      label57:
      i2 = 0;
      break label47;
      label62:
      Object localObject = paramc.g.a;
      localObject = paramc.p;
      localObject = paramc.m;
      paramc = paramc.o;
      if (locala != null) {
        a((Bitmap)localObject, paramc, locala);
      }
      if (i1 != 0)
      {
        i2 = localList.size();
        for (i1 = 0; i1 < i2; i1++) {
          a((Bitmap)localObject, paramc, (a)localList.get(i1));
        }
      }
    }
  }
  
  public final void a(Object paramObject)
  {
    p localp = this.d;
    localp.i.sendMessage(localp.i.obtainMessage(11, paramObject));
  }
  
  final Bitmap b(String paramString)
  {
    paramString = this.e.a(paramString);
    if (paramString != null) {
      this.f.a();
    }
    for (;;)
    {
      return paramString;
      this.f.c.sendEmptyMessage(1);
    }
  }
  
  final List<ai> b()
  {
    return this.q;
  }
  
  final void b(a parama)
  {
    Bitmap localBitmap = null;
    if (x.a(parama.e)) {
      localBitmap = b(parama.i);
    }
    if (localBitmap != null)
    {
      a(localBitmap, d.a, parama);
      if (this.l) {
        at.a("Main", "completed", parama.b.a(), "from " + d.a);
      }
    }
    for (;;)
    {
      return;
      a(parama);
      if (this.l) {
        at.a("Main", "resumed", parama.b.a());
      }
    }
  }
  
  public final void b(Object paramObject)
  {
    p localp = this.d;
    localp.i.sendMessage(localp.i.obtainMessage(12, paramObject));
  }
  
  public static final class a
  {
    private final Context a;
    private r b;
    private ExecutorService c;
    private j d;
    private aa.c e;
    private aa.f f;
    private List<ai> g;
    private Bitmap.Config h;
    private boolean i;
    private boolean j;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new IllegalArgumentException("Context must not be null.");
      }
      this.a = paramContext.getApplicationContext();
    }
    
    public final aa a()
    {
      Context localContext = this.a;
      if (this.b == null) {
        this.b = at.a(localContext);
      }
      if (this.d == null) {
        this.d = new u(localContext);
      }
      if (this.c == null) {
        this.c = new af();
      }
      if (this.f == null) {
        this.f = aa.f.a;
      }
      ak localak = new ak(this.d);
      return new aa(localContext, new p(localContext, this.c, aa.a, this.b, this.d, localak), this.d, this.e, this.f, this.g, localak, this.h, this.i, this.j);
    }
  }
  
  private static final class b
    extends Thread
  {
    private final ReferenceQueue<Object> a;
    private final Handler b;
    
    b(ReferenceQueue<Object> paramReferenceQueue, Handler paramHandler)
    {
      this.a = paramReferenceQueue;
      this.b = paramHandler;
      setDaemon(true);
      setName("Picasso-refQueue");
    }
    
    public final void run()
    {
      Process.setThreadPriority(10);
      try
      {
        for (;;)
        {
          a.a locala = (a.a)this.a.remove(1000L);
          Message localMessage = this.b.obtainMessage();
          if (locala == null) {
            break;
          }
          localMessage.what = 3;
          localMessage.obj = locala.a;
          this.b.sendMessage(localMessage);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          return;
          localInterruptedException.recycle();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.b.post(new ac(this, localException));
        }
      }
    }
  }
  
  public static abstract interface c {}
  
  public static enum d
  {
    final int d;
    
    private d(int paramInt)
    {
      this.d = paramInt;
    }
  }
  
  public static enum e {}
  
  public static abstract interface f
  {
    public static final f a = new ad();
    
    public abstract ag a(ag paramag);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */