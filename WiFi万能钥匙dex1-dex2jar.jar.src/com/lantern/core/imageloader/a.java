package com.lantern.core.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;

public final class a
  extends d
{
  public final Bitmap a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      paramBitmap = null;
    }
    for (;;)
    {
      return paramBitmap;
      int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - i) / 2, (paramBitmap.getHeight() - i) / 2, i, i);
      if (localBitmap != paramBitmap) {
        paramBitmap.recycle();
      }
      paramBitmap = Bitmap.createBitmap(i, i, paramBitmap.getConfig());
      Canvas localCanvas = new Canvas(paramBitmap);
      Paint localPaint = new Paint();
      localPaint.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      localPaint.setAntiAlias(true);
      float f = i / 2.0F;
      localCanvas.drawCircle(f, f, f, localPaint);
      localBitmap.recycle();
    }
  }
  
  public final String a()
  {
    return "circle";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */