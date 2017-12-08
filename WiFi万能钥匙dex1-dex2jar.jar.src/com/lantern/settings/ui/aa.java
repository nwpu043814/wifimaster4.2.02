package com.lantern.settings.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import bluefay.preference.Preference;
import com.bluefay.b.a;
import com.lantern.photochoose.b.g;

final class aa
  implements a
{
  aa(MineFragment paramMineFragment, String paramString) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1) {}
    try
    {
      MineFragment.j(this.b);
      Bitmap localBitmap = g.a((Bitmap)paramObject);
      paramObject = MineFragment.g(this.b);
      paramString = new android/graphics/drawable/BitmapDrawable;
      paramString.<init>(localBitmap);
      ((Preference)paramObject).a(paramString);
      MineFragment.a(this.b, this.a);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        System.gc();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */