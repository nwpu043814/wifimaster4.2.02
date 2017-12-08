package com.lantern.core.imageloader.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicInteger;

public final class ah
{
  private static final AtomicInteger a = new AtomicInteger();
  private final aa b;
  private final ag.a c;
  private boolean d;
  private boolean e;
  private boolean f = true;
  private int g;
  private int h;
  private int i;
  private int j;
  private Drawable k;
  private Drawable l;
  private Object m;
  
  ah()
  {
    this.b = null;
    this.c = new ag.a(null, 0, null);
  }
  
  ah(aa paramaa, Uri paramUri, int paramInt)
  {
    if (paramaa.m) {
      throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }
    this.b = paramaa;
    this.c = new ag.a(paramUri, paramInt, paramaa.j);
  }
  
  private ag a(long paramLong)
  {
    int n = a.getAndIncrement();
    ag localag2 = this.c.d();
    localag2.q = n;
    localag2.r = paramLong;
    boolean bool = this.b.l;
    if (bool) {
      at.a("Main", "created", localag2.b(), localag2.toString());
    }
    ag localag1 = this.b.a(localag2);
    if (localag1 != localag2)
    {
      localag1.q = n;
      localag1.r = paramLong;
      if (bool) {
        at.a("Main", "changed", localag1.a(), "into " + localag1);
      }
    }
    return localag1;
  }
  
  private Drawable e()
  {
    if (this.g != 0) {}
    for (Drawable localDrawable = this.b.c.getResources().getDrawable(this.g);; localDrawable = this.k) {
      return localDrawable;
    }
  }
  
  public final ah a()
  {
    this.e = true;
    return this;
  }
  
  public final ah a(int paramInt)
  {
    if (!this.f) {
      throw new IllegalStateException("Already explicitly declared as no placeholder.");
    }
    if (paramInt == 0) {
      throw new IllegalArgumentException("Placeholder image resource invalid.");
    }
    if (this.k != null) {
      throw new IllegalStateException("Placeholder image already set.");
    }
    this.g = paramInt;
    return this;
  }
  
  public final ah a(int paramInt1, int paramInt2)
  {
    this.c.a(paramInt1, paramInt2);
    return this;
  }
  
  public final ah a(Drawable paramDrawable)
  {
    if (!this.f) {
      throw new IllegalStateException("Already explicitly declared as no placeholder.");
    }
    if (this.g != 0) {
      throw new IllegalStateException("Placeholder image already set.");
    }
    this.k = paramDrawable;
    return this;
  }
  
  public final ah a(ap paramap)
  {
    this.c.a(paramap);
    return this;
  }
  
  public final ah a(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("Tag invalid.");
    }
    if (this.m != null) {
      throw new IllegalStateException("Tag already set.");
    }
    this.m = paramObject;
    return this;
  }
  
  public final void a(ImageView paramImageView)
  {
    a(paramImageView, null);
  }
  
  public final void a(ImageView paramImageView, l paraml)
  {
    long l1 = System.nanoTime();
    at.a();
    if (paramImageView == null) {
      throw new IllegalArgumentException("Target must not be null.");
    }
    if (!this.c.a())
    {
      this.b.a(paramImageView);
      if (this.f) {
        ae.a(paramImageView, e());
      }
    }
    for (;;)
    {
      return;
      if (this.e)
      {
        if (this.c.b()) {
          throw new IllegalStateException("Fit cannot be used with resize.");
        }
        int n = paramImageView.getWidth();
        int i1 = paramImageView.getHeight();
        if ((n == 0) || (i1 == 0))
        {
          if (this.f) {
            ae.a(paramImageView, e());
          }
          this.b.a(paramImageView, new o(this, paramImageView, paraml));
        }
        else
        {
          this.c.a(n, i1);
        }
      }
      else
      {
        ag localag = a(l1);
        String str = at.a(localag);
        if (x.a(this.i))
        {
          Bitmap localBitmap = this.b.b(str);
          if (localBitmap != null)
          {
            this.b.a(paramImageView);
            ae.a(paramImageView, this.b.c, localBitmap, aa.d.a, this.d, this.b.k);
            if (this.b.l) {
              at.a("Main", "completed", localag.b(), "from " + aa.d.a);
            }
            if (paraml == null) {
              continue;
            }
            paraml.a();
            continue;
          }
        }
        if (this.f) {
          ae.a(paramImageView, e());
        }
        paramImageView = new t(this.b, paramImageView, localag, this.i, this.j, this.h, this.l, str, this.m, paraml, this.d);
        this.b.a(paramImageView);
      }
    }
  }
  
  public final void a(an paraman)
  {
    long l1 = System.nanoTime();
    at.a();
    if (paraman == null) {
      throw new IllegalArgumentException("Target must not be null.");
    }
    if (this.e) {
      throw new IllegalStateException("Fit cannot be used with a Target.");
    }
    if (!this.c.a())
    {
      this.b.a(paraman);
      if (this.f) {
        e();
      }
    }
    for (;;)
    {
      return;
      ag localag = a(l1);
      Object localObject = at.a(localag);
      if (x.a(this.i))
      {
        Bitmap localBitmap = this.b.b((String)localObject);
        if (localBitmap != null)
        {
          this.b.a(paraman);
          localObject = aa.d.a;
          paraman.a(localBitmap);
          continue;
        }
      }
      if (this.f) {
        e();
      }
      paraman = new ao(this.b, paraman, localag, this.i, this.j, this.l, (String)localObject, this.m, this.h);
      this.b.a(paraman);
    }
  }
  
  final ah b()
  {
    this.e = false;
    return this;
  }
  
  final ah c()
  {
    this.m = null;
    return this;
  }
  
  public final ah d()
  {
    this.c.c();
    return this;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */