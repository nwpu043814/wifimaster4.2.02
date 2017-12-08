package com.lantern.core.imageloader.a;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class ag
{
  private static final long t = TimeUnit.SECONDS.toNanos(5L);
  public final Uri a;
  public final int b;
  public final String c;
  public final List<ap> d;
  public final int e;
  public final int f;
  public final boolean g;
  public final boolean h;
  public final boolean i;
  public final float j;
  public final float k;
  public final float l;
  public final boolean m;
  public final boolean n;
  public final Bitmap.Config o;
  public final int p;
  int q;
  long r;
  int s;
  
  private ag(Uri paramUri, int paramInt1, String paramString, List<ap> paramList, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean4, boolean paramBoolean5, Bitmap.Config paramConfig, int paramInt4)
  {
    this.a = paramUri;
    this.b = paramInt1;
    this.c = paramString;
    if (paramList == null) {}
    for (this.d = null;; this.d = Collections.unmodifiableList(paramList))
    {
      this.e = paramInt2;
      this.f = paramInt3;
      this.g = paramBoolean1;
      this.h = paramBoolean2;
      this.i = paramBoolean3;
      this.j = paramFloat1;
      this.k = paramFloat2;
      this.l = paramFloat3;
      this.m = paramBoolean4;
      this.n = paramBoolean5;
      this.o = paramConfig;
      this.p = paramInt4;
      return;
    }
  }
  
  final String a()
  {
    long l1 = System.nanoTime() - this.r;
    if (l1 > t) {}
    for (String str = b() + '+' + TimeUnit.NANOSECONDS.toSeconds(l1) + 's';; str = b() + '+' + TimeUnit.NANOSECONDS.toMillis(l1) + "ms") {
      return str;
    }
  }
  
  final String b()
  {
    return "[R" + this.q + ']';
  }
  
  public final boolean c()
  {
    if ((this.e != 0) || (this.f != 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  final boolean d()
  {
    if ((c()) || (this.j != 0.0F)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  final boolean e()
  {
    if (this.d != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Request{");
    if (this.b > 0) {
      localStringBuilder.append(this.b);
    }
    while ((this.d != null) && (!this.d.isEmpty()))
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        ap localap = (ap)localIterator.next();
        localStringBuilder.append(' ').append(localap.a());
      }
      localStringBuilder.append(this.a);
    }
    if (this.c != null) {
      localStringBuilder.append(" stableKey(").append(this.c).append(')');
    }
    if (this.e > 0) {
      localStringBuilder.append(" resize(").append(this.e).append(',').append(this.f).append(')');
    }
    if (this.g) {
      localStringBuilder.append(" centerCrop");
    }
    if (this.h) {
      localStringBuilder.append(" centerInside");
    }
    if (this.j != 0.0F)
    {
      localStringBuilder.append(" rotation(").append(this.j);
      if (this.m) {
        localStringBuilder.append(" @ ").append(this.k).append(',').append(this.l);
      }
      localStringBuilder.append(')');
    }
    if (this.n) {
      localStringBuilder.append(" purgeable");
    }
    if (this.o != null) {
      localStringBuilder.append(' ').append(this.o);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    private Uri a;
    private int b;
    private String c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private float i;
    private float j;
    private float k;
    private boolean l;
    private boolean m;
    private List<ap> n;
    private Bitmap.Config o;
    private int p;
    
    a(Uri paramUri, int paramInt, Bitmap.Config paramConfig)
    {
      this.a = paramUri;
      this.b = paramInt;
      this.o = paramConfig;
    }
    
    public final a a(int paramInt1, int paramInt2)
    {
      if (paramInt1 < 0) {
        throw new IllegalArgumentException("Width must be positive number or 0.");
      }
      if (paramInt2 < 0) {
        throw new IllegalArgumentException("Height must be positive number or 0.");
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        throw new IllegalArgumentException("At least one dimension has to be positive number.");
      }
      this.d = paramInt1;
      this.e = paramInt2;
      return this;
    }
    
    public final a a(ap paramap)
    {
      if (paramap == null) {
        throw new IllegalArgumentException("Transformation must not be null.");
      }
      if (this.n == null) {
        this.n = new ArrayList(2);
      }
      this.n.add(paramap);
      return this;
    }
    
    final boolean a()
    {
      if ((this.a != null) || (this.b != 0)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    final boolean b()
    {
      if ((this.d != 0) || (this.e != 0)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final a c()
    {
      if (this.g) {
        throw new IllegalStateException("Center crop can not be used after calling centerInside");
      }
      this.f = true;
      return this;
    }
    
    public final ag d()
    {
      if ((this.g) && (this.f)) {
        throw new IllegalStateException("Center crop and center inside can not be used together.");
      }
      if ((this.f) && (this.d == 0) && (this.e == 0)) {
        throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
      }
      if ((this.g) && (this.d == 0) && (this.e == 0)) {
        throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
      }
      if (this.p == 0) {
        this.p = aa.e.b;
      }
      return new ag(this.a, this.b, this.c, this.n, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.o, this.p, (byte)0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */