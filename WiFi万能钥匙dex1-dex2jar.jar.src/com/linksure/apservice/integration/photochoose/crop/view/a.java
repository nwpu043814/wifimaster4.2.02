package com.linksure.apservice.integration.photochoose.crop.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class a
  extends GestureDetector.SimpleOnGestureListener
{
  a(CropZoomableImageView paramCropZoomableImageView) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (CropZoomableImageView.a(this.a) == true) {}
    for (;;)
    {
      return true;
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      if (this.a.c() < CropZoomableImageView.b(this.a))
      {
        this.a.postDelayed(new CropZoomableImageView.a(this.a, CropZoomableImageView.b(this.a), f2, f1), 16L);
        CropZoomableImageView.a(this.a, true);
      }
      else if ((this.a.c() >= CropZoomableImageView.b(this.a)) && (this.a.c() < CropZoomableImageView.c(this.a)))
      {
        this.a.postDelayed(new CropZoomableImageView.a(this.a, CropZoomableImageView.c(this.a), f2, f1), 16L);
        CropZoomableImageView.a(this.a, true);
      }
      else
      {
        this.a.postDelayed(new CropZoomableImageView.a(this.a, CropZoomableImageView.d(this.a), f2, f1), 16L);
        CropZoomableImageView.a(this.a, true);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/crop/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */