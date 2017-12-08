package com.lantern.launcher.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

final class o
  implements View.OnClickListener
{
  o(UserGuideFragment paramUserGuideFragment) {}
  
  public final void onClick(View paramView)
  {
    paramView = UserGuideFragment.f(this.a).getResources().getString(2131363303);
    paramView = new Intent("wifi.intent.action.BROWSER", Uri.parse("file:///android_asset/html/" + paramView));
    paramView.setPackage(this.a.getActivity().getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showclose", true);
    localBundle.putBoolean("allowbannerad", false);
    paramView.putExtras(localBundle);
    this.a.startActivity(paramView);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */