package com.lantern.favorite.ui;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.lantern.core.imageloader.f;
import com.lantern.favorite.widget.PhotoView;

final class e
  implements f
{
  e(FavoriteDetails paramFavoriteDetails) {}
  
  public final void a() {}
  
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
      FavoriteDetails.a(this.a).setImageBitmap(paramBitmap);
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        paramBitmap.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */