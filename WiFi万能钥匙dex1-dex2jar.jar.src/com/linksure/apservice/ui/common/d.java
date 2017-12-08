package com.linksure.apservice.ui.common;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.bluefay.a.e;
import com.lantern.core.c;
import com.lantern.core.o;
import com.linksure.apservice.a.b.f;

final class d
  implements View.OnClickListener
{
  d(a parama, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    this.a.dismiss();
    paramView = this.b;
    c.getServer().p();
    f.a(paramView.getApplication());
    Intent localIntent = new Intent("wifi.intent.action.ADD_ACCOUNT_MAIN");
    localIntent.setPackage(paramView.getPackageName());
    localIntent.putExtra("OON", "2");
    e.a(paramView, localIntent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */