package com.lantern.settings.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;

final class ao
  implements View.OnClickListener
{
  ao(MoreFragment paramMoreFragment, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    a.e().onEvent("invcli_4");
    this.a.dismiss();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */