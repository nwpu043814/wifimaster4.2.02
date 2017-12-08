package com.linksure.apservice.ui.views.integration;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class c
  extends GestureDetector.SimpleOnGestureListener
{
  c(ClipZoomImageView paramClipZoomImageView) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (ClipZoomImageView.a(this.a) == true) {}
    for (;;)
    {
      return true;
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      if (this.a.a() < ClipZoomImageView.b())
      {
        this.a.postDelayed(new ClipZoomImageView.a(this.a, ClipZoomImageView.b(), f2, f1), 16L);
        ClipZoomImageView.a(this.a, true);
      }
      else
      {
        this.a.postDelayed(new ClipZoomImageView.a(this.a, ClipZoomImageView.b(this.a), f2, f1), 16L);
        ClipZoomImageView.a(this.a, true);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/integration/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */