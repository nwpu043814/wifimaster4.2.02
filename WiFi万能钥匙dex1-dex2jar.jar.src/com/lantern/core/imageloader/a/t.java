package com.lantern.core.imageloader.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

final class t
  extends a<ImageView>
{
  l m;
  
  t(aa paramaa, ImageView paramImageView, ag paramag, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString, Object paramObject, l paraml, boolean paramBoolean)
  {
    super(paramaa, paramImageView, paramag, paramInt1, paramInt2, paramInt3, paramDrawable, paramString, paramObject, paramBoolean);
    this.m = paraml;
  }
  
  public final void a()
  {
    ImageView localImageView = (ImageView)this.c.get();
    if (localImageView == null) {}
    label85:
    for (;;)
    {
      return;
      Drawable localDrawable = localImageView.getDrawable();
      if ((localDrawable instanceof AnimationDrawable)) {
        ((AnimationDrawable)localDrawable).stop();
      }
      if (this.g != 0) {
        localImageView.setImageResource(this.g);
      }
      for (;;)
      {
        if (this.m == null) {
          break label85;
        }
        this.m.b();
        break;
        if (this.h != null) {
          localImageView.setImageDrawable(this.h);
        }
      }
    }
  }
  
  public final void a(Bitmap paramBitmap, aa.d paramd)
  {
    if (paramBitmap == null) {
      throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] { this }));
    }
    ImageView localImageView = (ImageView)this.c.get();
    if (localImageView == null) {}
    for (;;)
    {
      return;
      Context localContext = this.a.c;
      boolean bool = this.a.k;
      ae.a(localImageView, localContext, paramBitmap, paramd, this.d, bool);
      if (this.m != null) {
        this.m.a();
      }
    }
  }
  
  final void b()
  {
    super.b();
    if (this.m != null) {
      this.m = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */