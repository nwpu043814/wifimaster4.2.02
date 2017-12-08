package com.lantern.favorite.widget;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

final class d
  implements ScaleGestureDetector.OnScaleGestureListener
{
  d(PhotoView paramPhotoView) {}
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((Float.isNaN(f)) || (Float.isInfinite(f))) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      PhotoView.c(this.a, f);
      PhotoView.b(this.a).postScale(f, f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      PhotoView.f(this.a);
    }
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */