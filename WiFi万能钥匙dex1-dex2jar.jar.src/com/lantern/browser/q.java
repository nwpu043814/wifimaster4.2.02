package com.lantern.browser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.bluefay.b.h;
import java.util.HashMap;

final class q
  extends BroadcastReceiver
{
  q(n paramn) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {
      break label11;
    }
    for (;;)
    {
      label11:
      return;
      if (!"android.intent.action.DOWNLOAD_REMOVE".equals(paramIntent.getAction())) {
        continue;
      }
      long l = paramIntent.getLongExtra("extra_download_id", 0L);
      paramContext = this.a.c(l);
      if (paramContext != null)
      {
        paramContext.a("NOT_DOWNLOAD");
        paramContext.a(0);
        n.a(paramContext);
        n.b(this.a).remove(Long.valueOf(l));
      }
      k localk = l.a().a(String.valueOf(l));
      if (localk == null) {
        break;
      }
      paramIntent = localk.d();
      h.a("ACTION_DOWNLOAD_REMOVE getPackageName:" + paramIntent, new Object[0]);
      String str = "NOT_DOWNLOAD";
      paramContext = str;
      if (!TextUtils.isEmpty(paramIntent)) {}
      try
      {
        paramIntent = n.c(this.a).getPackageManager().getPackageInfo(localk.d(), 0);
        paramContext = str;
        if (paramIntent != null) {
          paramContext = "INSTALLED";
        }
        if (localk.f().equals(paramContext)) {
          continue;
        }
        localk.f(paramContext);
        l.a().b(localk.a(), paramContext);
        n.a(localk);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramIntent = null;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */