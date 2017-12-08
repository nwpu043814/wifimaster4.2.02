package com.lantern.mailbox.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.lantern.core.c;
import com.lantern.mailbox.R.color;
import java.io.ByteArrayOutputStream;

public final class b
{
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, float paramFloat)
  {
    int j = paramBitmap1.getWidth();
    int i = paramBitmap1.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(c.getAppContext().getResources().getColor(R.color.mailbox_avatar));
    localPaint.setStrokeWidth(2.0F);
    localCanvas.drawCircle(j / 2, i / 2, i / 2, localPaint);
    localCanvas.drawBitmap(a(paramBitmap1, true, paramFloat), 0.0F, 0.0F, localPaint);
    localCanvas.drawBitmap(a(paramBitmap2, false, paramFloat), 0.0F, 0.0F, localPaint);
    localPaint.setColor(-1);
    localCanvas.drawLine(j / 2, 0.0F, j / 2, i, localPaint);
    return localBitmap;
  }
  
  private static Bitmap a(Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    int i = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int m = (int)(i * paramFloat);
    int j = (int)(k * paramFloat);
    Bitmap localBitmap1 = Bitmap.createBitmap(i, k, Bitmap.Config.ARGB_8888);
    Bitmap localBitmap2 = Bitmap.createScaledBitmap(paramBitmap, m, j, true);
    RectF localRectF = new RectF(0.0F, 0.0F, i, k);
    Canvas localCanvas = new Canvas(localBitmap1);
    paramBitmap = new Paint();
    paramBitmap.setAntiAlias(true);
    if (paramBoolean)
    {
      paramFloat = 90.0F;
      localCanvas.drawArc(localRectF, paramFloat, 180.0F, true, paramBitmap);
      paramBitmap.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (paramFloat = -(m - i / 2) / 2;; paramFloat = i / 2 - (m - i / 2) / 2)
    {
      localCanvas.drawBitmap(localBitmap2, paramFloat, 0.0F, paramBitmap);
      return localBitmap1;
      paramFloat = -90.0F;
      break;
    }
  }
  
  public static byte[] a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramBitmap != null)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 0, localByteArrayOutputStream);
    }
    for (paramBitmap = localByteArrayOutputStream.toByteArray();; paramBitmap = null) {
      return paramBitmap;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */