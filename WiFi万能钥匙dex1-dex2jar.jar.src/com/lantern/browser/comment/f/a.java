package com.lantern.browser.comment.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import java.io.File;
import java.io.FileInputStream;

public final class a
{
  private static final Paint a = new Paint(1);
  private static final Paint b;
  
  static
  {
    Paint localPaint = new Paint(1);
    b = localPaint;
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
  }
  
  public static Bitmap a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = new File(paramString);
    if (!((File)localObject2).exists()) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = new java/io/FileInputStream;
        paramString.<init>((File)localObject2);
        localObject2 = BitmapFactory.decodeStream(paramString);
        paramString = (String)localObject1;
        if (localObject2 != null)
        {
          int j = ((Bitmap)localObject2).getWidth();
          int k = ((Bitmap)localObject2).getHeight();
          if (j < k) {}
          for (int i = j;; i = k)
          {
            Object localObject3 = new android/graphics/RectF;
            ((RectF)localObject3).<init>();
            Object localObject4 = new android/graphics/RectF;
            ((RectF)localObject4).<init>();
            ((RectF)localObject3).set(0.0F, 0.0F, j, k);
            ((RectF)localObject4).set(0.0F, 0.0F, i, i);
            paramString = new android/graphics/Matrix;
            paramString.<init>();
            paramString.setRectToRect((RectF)localObject3, (RectF)localObject4, Matrix.ScaleToFit.FILL);
            localObject3 = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            localObject4 = new android/graphics/Canvas;
            ((Canvas)localObject4).<init>((Bitmap)localObject3);
            ((Canvas)localObject4).drawBitmap((Bitmap)localObject2, paramString, null);
            paramString = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            localObject2 = new android/graphics/Canvas;
            ((Canvas)localObject2).<init>(paramString);
            i /= 2;
            ((Canvas)localObject2).drawCircle(i, i, i, a);
            ((Canvas)localObject2).drawBitmap((Bitmap)localObject3, 0.0F, 0.0F, b);
            break;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramString = (String)localObject1;
      }
      catch (Throwable paramString)
      {
        System.gc();
        paramString = (String)localObject1;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */