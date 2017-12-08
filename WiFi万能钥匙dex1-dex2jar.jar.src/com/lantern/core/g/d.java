package com.lantern.core.g;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import bluefay.app.k.a;
import com.bluefay.a.b;
import com.lantern.core.R.string;

public final class d
{
  public static boolean a(Activity paramActivity)
  {
    boolean bool = true;
    Object localObject;
    if (Build.VERSION.SDK_INT < 14) {
      if (b.a(paramActivity, "com.linksure.wifilocating"))
      {
        localObject = paramActivity.getPackageManager().getLaunchIntentForPackage("com.linksure.wifilocating");
        if (localObject != null)
        {
          ((Intent)localObject).setFlags(268435456);
          com.bluefay.a.e.a(paramActivity, (Intent)localObject);
        }
        paramActivity.finish();
      }
    }
    for (;;)
    {
      return bool;
      localObject = new k.a(paramActivity);
      ((k.a)localObject).a(paramActivity.getString(R.string.launcher_lower_version_tip_title));
      ((k.a)localObject).b(String.format(paramActivity.getString(R.string.launcher_lower_version_tip_content), new Object[] { Build.VERSION.RELEASE }));
      ((k.a)localObject).a(17039370, new e(paramActivity));
      ((k.a)localObject).a(new f(paramActivity));
      ((k.a)localObject).d();
      continue;
      bool = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */