package com.linksure.apservice.ui.profile.widget;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

final class k
  implements ScaleGestureDetector.OnScaleGestureListener
{
  k(PhotoView paramPhotoView) {}
  
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/widget/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */