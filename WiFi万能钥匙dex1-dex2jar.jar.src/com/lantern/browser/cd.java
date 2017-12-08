package com.lantern.browser;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.DisplayMetrics;

public final class cd
{
  private static Bitmap a;
  
  public static Drawable a(Context paramContext, Bitmap paramBitmap)
  {
    Object localObject;
    if ((paramContext == null) || (paramBitmap == null)) {
      localObject = null;
    }
    for (;;)
    {
      return (Drawable)localObject;
      float f = paramContext.getResources().getDisplayMetrics().density;
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), paramBitmap);
      if (a == null) {
        a = BitmapFactory.decodeResource(paramContext.getResources(), R.drawable.framework_reddot);
      }
      Bitmap localBitmap = a;
      localObject = localBitmapDrawable;
      if (localBitmap != null)
      {
        localObject = new LayerDrawable(new Drawable[] { localBitmapDrawable, new BitmapDrawable(paramContext.getResources(), localBitmap) });
        ((LayerDrawable)localObject).setLayerInset(0, 0, 0, 0, 0);
        ((LayerDrawable)localObject).setLayerInset(1, (int)(paramBitmap.getWidth() - localBitmap.getWidth() - 4.0F * f), (int)(4.0F * f), (int)(4.0F * f), (int)(paramBitmap.getHeight() - localBitmap.getHeight() - 4.0F * f));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */