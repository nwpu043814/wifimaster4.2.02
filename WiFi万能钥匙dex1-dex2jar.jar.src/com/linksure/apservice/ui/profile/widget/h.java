package com.linksure.apservice.ui.profile.widget;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.lantern.core.imageloader.a.an;
import com.linksure.apservice.R.drawable;

final class h
  implements an
{
  h(PhotoDialog paramPhotoDialog, PhotoView paramPhotoView) {}
  
  public final void a()
  {
    this.a.setImageResource(R.drawable.aps_avatar120);
  }
  
  public final void a(Bitmap paramBitmap)
  {
    try
    {
      int j = paramBitmap.getWidth();
      int i = paramBitmap.getHeight();
      Matrix localMatrix = new android/graphics/Matrix;
      localMatrix.<init>();
      localMatrix.postScale(2.0F, 2.0F);
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, j, i, localMatrix, false);
      this.a.setImageBitmap(paramBitmap);
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        this.a.setImageResource(R.drawable.aps_avatar120);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */