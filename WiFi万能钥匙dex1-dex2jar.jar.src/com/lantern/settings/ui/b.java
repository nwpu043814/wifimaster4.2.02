package com.lantern.settings.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bluefay.b.a;

final class b
  implements a
{
  b(AvatarViewFragment paramAvatarViewFragment, ImageView paramImageView) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1) {
      this.a.setImageBitmap((Bitmap)paramObject);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */