package com.lantern.settings.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bluefay.b.a;
import com.lantern.photochoose.b.g;
import com.lantern.settings.widget.UserInfoHeaderPreference;

final class bi
  implements a
{
  bi(UserInfoFragment paramUserInfoFragment, String paramString) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1) {}
    try
    {
      UserInfoFragment.c(this.b);
      paramObject = g.a((Bitmap)paramObject);
      UserInfoHeaderPreference localUserInfoHeaderPreference = UserInfoFragment.d(this.b);
      paramString = new android/graphics/drawable/BitmapDrawable;
      paramString.<init>((Bitmap)paramObject);
      localUserInfoHeaderPreference.a(paramString);
      UserInfoFragment.a(this.b, this.a);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */