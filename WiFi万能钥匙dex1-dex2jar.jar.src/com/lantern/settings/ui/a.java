package com.lantern.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.lantern.settings.R.string;

final class a
  implements com.bluefay.b.a
{
  a(AboutFragment paramAboutFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    paramString = AboutFragment.a(this.a).getResources().getString(R.string.settings_web_protocal_name);
    paramObject = new Intent("wifi.intent.action.BROWSER", Uri.parse("file:///android_asset/html/" + paramString));
    ((Intent)paramObject).setPackage(AboutFragment.b(this.a).getPackageName());
    paramString = new Bundle();
    paramString.putBoolean("showclose", true);
    paramString.putBoolean("allowbannerad", false);
    ((Intent)paramObject).putExtras(paramString);
    this.a.startActivity((Intent)paramObject);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */