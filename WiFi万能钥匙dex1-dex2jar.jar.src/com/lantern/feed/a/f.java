package com.lantern.feed.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.lantern.feed.channel.a.a;

final class f
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      if ("android.intent.action.PACKAGE_ADDED".equals(paramIntent.getAction()))
      {
        paramContext = paramIntent.getData().getSchemeSpecificPart();
        m.a().a(paramContext);
        a.a().c(paramContext);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */