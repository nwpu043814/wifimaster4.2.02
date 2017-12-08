package com.lantern.settings.ui;

import android.os.Handler;
import com.lantern.settings.R.string;
import com.lantern.settings.b.f;
import com.lantern.settings.widget.c.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class d
  implements c.a
{
  d(AvatarViewFragment paramAvatarViewFragment) {}
  
  public final void a()
  {
    AvatarViewFragment.a(this.a, this.a.getString(R.string.settings_tips_save_picture_ing));
    if (AvatarViewFragment.c(this.a) == null) {
      AvatarViewFragment.a(this.a, new SimpleDateFormat("yyyyMMdd_HHmmssSSS", Locale.getDefault()));
    }
    Object localObject1 = f.a();
    Object localObject2 = new File(((f)localObject1).b() + File.separator + "WifiMasterKey" + File.separator + "WiFiMasterPic");
    if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory())) {
      ((File)localObject2).mkdirs();
    }
    try
    {
      localObject1 = new java/io/File;
      Object localObject5 = new java/lang/StringBuilder;
      ((StringBuilder)localObject5).<init>("IMAGE_");
      Object localObject3 = AvatarViewFragment.c(this.a);
      Object localObject4 = new java/util/Date;
      ((Date)localObject4).<init>();
      ((File)localObject1).<init>((File)localObject2, ((SimpleDateFormat)localObject3).format((Date)localObject4) + ".jpg");
      localObject5 = AvatarViewFragment.d(this.a);
      localObject3 = AvatarViewFragment.e(this.a);
      localObject2 = ((File)localObject1).getAbsolutePath();
      localObject4 = new com/lantern/settings/ui/e;
      ((e)localObject4).<init>(this, (File)localObject1);
      com.lantern.settings.b.a.a((Handler)localObject5, (String)localObject3, (String)localObject2, (com.bluefay.b.a)localObject4);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.bluefay.a.e.a(this.a.getString(R.string.settings_tips_save_picture_failed));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */