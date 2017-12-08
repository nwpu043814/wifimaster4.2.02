package com.lantern.core.imageloader.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

final class ao
  extends a<an>
{
  ao(aa paramaa, an paraman, ag paramag, int paramInt1, int paramInt2, Drawable paramDrawable, String paramString, Object paramObject, int paramInt3)
  {
    super(paramaa, paraman, paramag, paramInt1, paramInt2, paramInt3, paramDrawable, paramString, paramObject, false);
  }
  
  final void a()
  {
    an localan = (an)c();
    if (localan != null)
    {
      if (this.g == 0) {
        break label44;
      }
      this.a.c.getResources().getDrawable(this.g);
      localan.a();
    }
    for (;;)
    {
      return;
      label44:
      localan.a();
    }
  }
  
  final void a(Bitmap paramBitmap, aa.d paramd)
  {
    if (paramBitmap == null) {
      throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] { this }));
    }
    paramd = (an)c();
    if (paramd != null)
    {
      paramd.a(paramBitmap);
      if (paramBitmap.isRecycled()) {
        throw new IllegalStateException("Target callback must not recycle bitmap!");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */