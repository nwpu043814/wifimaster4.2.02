package com.lantern.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bluefay.b.a;
import com.lantern.settings.R.string;
import java.io.File;

final class e
  implements a
{
  e(d paramd, File paramFile) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    int i = 1;
    AvatarViewFragment.f(this.b.a);
    if (paramInt == 1) {
      AvatarViewFragment.g(this.b.a).sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.a)));
    }
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0) {
        com.bluefay.a.e.a(this.b.a.getString(R.string.settings_tips_save_picture_success));
      }
      for (;;)
      {
        return;
        com.bluefay.a.e.a(this.b.a.getString(R.string.settings_tips_save_picture_failed));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */