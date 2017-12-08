package com.linksure.apservice.ui.home.list;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

final class b
  implements View.OnClickListener
{
  b(a parama) {}
  
  public final void onClick(View paramView)
  {
    if (a.a(this.a) != null) {
      a.a(this.a).onClick(a.b(this.a), 0);
    }
    if (a.b(this.a) != null) {
      a.b(this.a).dismiss();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/list/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */