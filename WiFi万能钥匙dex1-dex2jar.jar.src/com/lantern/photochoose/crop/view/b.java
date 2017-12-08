package com.lantern.photochoose.crop.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class b
  extends GestureDetector.SimpleOnGestureListener
{
  b(ZoomableImageView paramZoomableImageView) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (ZoomableImageView.a(this.a) == true) {}
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (this.a.a() < 2.0F)
      {
        this.a.postDelayed(new ZoomableImageView.a(this.a, 2.0F, f1, f2), 16L);
        ZoomableImageView.a(this.a, true);
      }
      else if ((this.a.a() >= 2.0F) && (this.a.a() <= 4.0F))
      {
        this.a.postDelayed(new ZoomableImageView.a(this.a, 4.0F, f1, f2), 16L);
        ZoomableImageView.a(this.a, true);
      }
      else
      {
        this.a.postDelayed(new ZoomableImageView.a(this.a, ZoomableImageView.b(this.a), f1, f2), 16L);
        ZoomableImageView.a(this.a, true);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/photochoose/crop/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */