package com.lantern.feed.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.feed.a.m;
import com.lantern.feed.b.g;
import com.lantern.feed.channel.a.a;

final class e
  implements View.OnClickListener
{
  e(d paramd) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = this.a.k.H();
    localObject = com.lantern.feed.d.d.a(this.a.d, (String)localObject);
    if (localObject != null)
    {
      com.bluefay.a.e.a(this.a.d, (Intent)localObject);
      if (TextUtils.isEmpty(this.a.l)) {
        m.a().a(10, this.a.k);
      }
    }
    for (;;)
    {
      return;
      a.a().a(10, this.a.k);
      continue;
      if (!TextUtils.isEmpty(this.a.k.I())) {
        d.a(this.a);
      } else {
        this.a.onClick(paramView);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */