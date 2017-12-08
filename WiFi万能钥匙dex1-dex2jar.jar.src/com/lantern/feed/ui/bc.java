package com.lantern.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.bluefay.a.e;
import com.lantern.feed.a.m;
import com.lantern.feed.b.g;
import com.lantern.feed.channel.a.a;
import com.lantern.feed.d.d;

final class bc
  implements View.OnClickListener
{
  bc(ba paramba) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a.k.e(1);
    if (d.a(paramView))
    {
      Intent localIntent = new Intent("wifi.intent.action.BROWSER");
      localIntent.setData(Uri.parse(d.a(paramView, this.a.k)));
      localIntent.putExtra("src", "feed");
      localIntent.putExtra("title", this.a.k.d(1));
      localIntent.setPackage(this.a.d.getPackageName());
      localIntent.addFlags(268435456);
      e.a(this.a.d, localIntent);
    }
    if (TextUtils.isEmpty(this.a.l)) {
      m.a().a(3, 1, this.a.k);
    }
    for (;;)
    {
      return;
      a.a().a(3, 1, this.a.k);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */