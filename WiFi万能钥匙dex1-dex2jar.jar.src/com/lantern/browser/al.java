package com.lantern.browser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bluefay.b.h;

final class al
  extends BroadcastReceiver
{
  al(WkBrowserJsInterface paramWkBrowserJsInterface) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    WkBrowserJsInterface.access$400(paramContext);
    paramContext = paramIntent.getStringExtra("auth_sdk_code");
    h.a("onReceive " + paramContext, new Object[0]);
    if (!TextUtils.isEmpty(WkBrowserJsInterface.access$500())) {
      WkBrowserJsInterface.access$700(WkBrowserJsInterface.access$600(), WkBrowserJsInterface.access$500(), new String[] { paramContext });
    }
    WkBrowserJsInterface.access$602(null);
    WkBrowserJsInterface.access$502(null);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */