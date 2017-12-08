package com.lantern.feed.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bluefay.a.e;
import com.lantern.feed.a.m;
import com.lantern.feed.channel.a.a;

final class ap
  implements DialogInterface.OnClickListener
{
  ap(an paraman, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent("android.intent.action.DIAL");
    paramDialogInterface.setData(Uri.parse("tel:" + this.a));
    e.a(this.b.getContext(), paramDialogInterface);
    if (TextUtils.isEmpty(this.b.l)) {
      m.a().a(9, this.b.k);
    }
    for (;;)
    {
      return;
      a.a().a(9, this.b.k);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */