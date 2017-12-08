package com.lantern.settings.ui;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bluefay.a.e;
import com.lantern.core.p;
import com.lantern.photochoose.b.g;
import com.lantern.settings.R.string;
import com.lantern.settings.widget.UserInfoHeaderPreference;
import org.json.JSONObject;

final class bp
  implements com.bluefay.b.a
{
  bp(bo parambo, String paramString) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    UserInfoFragment.a(this.b.a.b);
    if (paramInt == 1) {
      if (UserInfoFragment.w(this.b.a.c) == 1) {
        com.lantern.analytics.a.e().onEvent("cmtsasuc", "b");
      }
    }
    for (;;)
    {
      com.lantern.settings.b.a.a(this.a, this.b.a.a);
      e.a(R.string.settings_upload_avatar_success);
      p.k(UserInfoFragment.x(this.b.a.c), this.a);
      try
      {
        UserInfoFragment.y(this.b.a.c);
        paramString = g.a(this.b.a.a);
        UserInfoHeaderPreference localUserInfoHeaderPreference = UserInfoFragment.d(this.b.a.c);
        paramObject = new android/graphics/drawable/BitmapDrawable;
        ((BitmapDrawable)paramObject).<init>(paramString);
        localUserInfoHeaderPreference.a((Drawable)paramObject);
        for (;;)
        {
          return;
          if (UserInfoFragment.w(this.b.a.c) != 2) {
            break;
          }
          com.lantern.analytics.a.e().onEvent("cmtsasuc", "c");
          break;
          if ((paramObject != null) && ("O.OPEN.0004".equals(((JSONObject)paramObject).optString("retCd"))))
          {
            com.lantern.analytics.a.e().onEvent("avatofal");
            UserInfoFragment.p(this.b.a.c);
          }
          else
          {
            e.a(R.string.settings_upload_avatar_failed);
          }
        }
      }
      catch (Throwable paramString)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */