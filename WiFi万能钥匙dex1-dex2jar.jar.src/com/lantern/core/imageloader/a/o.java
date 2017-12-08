package com.lantern.core.imageloader.a;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

final class o
  implements ViewTreeObserver.OnPreDrawListener
{
  final ah a;
  final WeakReference<ImageView> b;
  l c;
  
  o(ah paramah, ImageView paramImageView, l paraml)
  {
    this.a = paramah;
    this.b = new WeakReference(paramImageView);
    this.c = paraml;
    paramImageView.getViewTreeObserver().addOnPreDrawListener(this);
  }
  
  public final boolean onPreDraw()
  {
    ImageView localImageView = (ImageView)this.b.get();
    if (localImageView == null) {}
    for (;;)
    {
      return true;
      ViewTreeObserver localViewTreeObserver = localImageView.getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
      {
        int j = localImageView.getWidth();
        int i = localImageView.getHeight();
        if ((j > 0) && (i > 0))
        {
          localViewTreeObserver.removeOnPreDrawListener(this);
          this.a.b().a(j, i).a(localImageView, this.c);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */