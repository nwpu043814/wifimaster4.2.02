package com.linksure.apservice.ui.profile.widget;

import android.graphics.Matrix;

final class j
  implements g
{
  j(PhotoView paramPhotoView) {}
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    PhotoView.a(this.a, paramFloat1);
    if (PhotoView.a(this.a))
    {
      PhotoView.b(this.a, paramFloat1);
      PhotoView.b(this.a).postRotate(paramFloat1, paramFloat2, paramFloat3);
    }
    for (;;)
    {
      return;
      if (Math.abs(PhotoView.c(this.a)) >= PhotoView.d(this.a))
      {
        PhotoView.a(this.a, true);
        PhotoView.e(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */