package com.linksure.apservice.ui.profile.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;

final class h
  implements DialogInterface.OnClickListener
{
  h(ProfileFragment paramProfileFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ProfileFragment.c(this.a).getText().toString()));
    paramDialogInterface.setFlags(268435456);
    this.a.startActivity(paramDialogInterface);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/detail/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */