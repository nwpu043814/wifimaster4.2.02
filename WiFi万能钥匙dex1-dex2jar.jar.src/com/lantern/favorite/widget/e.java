package com.lantern.favorite.widget;

import android.view.View.OnClickListener;

final class e
  implements Runnable
{
  e(PhotoView paramPhotoView) {}
  
  public final void run()
  {
    if (PhotoView.g(this.a) != null) {
      PhotoView.g(this.a).onClick(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */