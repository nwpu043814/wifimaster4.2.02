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

final class bd
  implements View.OnClickListener
{
  bd(ba paramba) {}
  
  public final void onClick(View paramView)
  {
    String str = this.a.k.e(2);
    if (d.a(str))
    {
      paramView = new Intent("wifi.intent.action.BROWSER");
      paramView.setData(Uri.parse(d.a(str, this.a.k)));
      paramView.putExtra("src", "feed");
      paramView.putExtra("title", this.a.k.d(2));
      paramView.setPackage(this.a.d.getPackageName());
      paramView.addFlags(268435456);
      e.a(this.a.d, paramView);
    }
    if (TextUtils.isEmpty(this.a.l)) {
      m.a().a(3, 2, this.a.k);
    }
    for (;;)
    {
      return;
      a.a().a(3, 2, this.a.k);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */