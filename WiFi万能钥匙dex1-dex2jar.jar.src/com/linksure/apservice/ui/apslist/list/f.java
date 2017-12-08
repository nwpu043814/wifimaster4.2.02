package com.linksure.apservice.ui.apslist.list;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.linksure.apservice.b.a;

final class f
  implements View.OnClickListener
{
  f(ApsListFragment paramApsListFragment, Dialog paramDialog, a parama) {}
  
  public final void onClick(View paramView)
  {
    this.a.dismiss();
    ApsListFragment.a(this.c, ApsListFragment.a(this.c, this.b));
    ApsListFragment.c(this.c).show();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/list/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */