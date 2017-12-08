package com.lantern.core.imageloader.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

abstract class a<T>
{
  final aa a;
  final ag b;
  final WeakReference<T> c;
  final boolean d;
  final int e;
  final int f;
  final int g;
  final Drawable h;
  final String i;
  final Object j;
  boolean k;
  boolean l;
  
  a(aa paramaa, T paramT, ag paramag, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString, Object paramObject, boolean paramBoolean)
  {
    this.a = paramaa;
    this.b = paramag;
    if (paramT == null)
    {
      paramaa = null;
      this.c = paramaa;
      this.e = paramInt1;
      this.f = paramInt2;
      this.d = paramBoolean;
      this.g = paramInt3;
      this.h = paramDrawable;
      this.i = paramString;
      if (paramObject == null) {
        break label90;
      }
    }
    for (;;)
    {
      this.j = paramObject;
      return;
      paramaa = new a(this, paramT, paramaa.i);
      break;
      label90:
      paramObject = this;
    }
  }
  
  abstract void a();
  
  abstract void a(Bitmap paramBitmap, aa.d paramd);
  
  void b()
  {
    this.l = true;
  }
  
  final T c()
  {
    if (this.c == null) {}
    for (Object localObject = null;; localObject = this.c.get()) {
      return (T)localObject;
    }
  }
  
  static final class a<M>
    extends WeakReference<M>
  {
    final a a;
    
    public a(a parama, M paramM, ReferenceQueue<? super M> paramReferenceQueue)
    {
      super(paramReferenceQueue);
      this.a = parama;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */