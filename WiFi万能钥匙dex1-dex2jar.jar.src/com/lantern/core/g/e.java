package com.lantern.core.g;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.lantern.core.R.string;

final class e
  implements DialogInterface.OnClickListener
{
  e(Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("android.intent.action.VIEW");
    paramDialogInterface.setData(Uri.parse(this.a.getString(R.string.launcher_lower_version_tip_download_url)));
    this.a.startActivity(paramDialogInterface);
    this.a.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */