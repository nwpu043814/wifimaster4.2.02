package com.lantern.settings.ui;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.lantern.analytics.a;
import com.lantern.settings.R.string;
import com.snda.wifilocating.wxapi.WkWeiXinUtil;

final class an
  implements AdapterView.OnItemClickListener
{
  an(MoreFragment paramMoreFragment, Dialog paramDialog) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0)
    {
      a.e().onEvent("invcli_1");
      if (!WkWeiXinUtil.isWXAppInstalledAndSupported())
      {
        Toast.makeText(MoreFragment.o(this.b), this.b.getString(R.string.settings_hotspot_activity_not_support_prompt), 0).show();
        this.a.dismiss();
      }
    }
    for (;;)
    {
      return;
      WkWeiXinUtil.sentToWeiXinCircle(0, this.b.getString(R.string.settings_more_sendto_content));
      break;
      if (paramInt == 1)
      {
        a.e().onEvent("invcli_2");
        if (!WkWeiXinUtil.isWXAppInstalledAndSupported()) {
          Toast.makeText(MoreFragment.p(this.b), this.b.getString(R.string.settings_hotspot_activity_not_support_prompt), 0).show();
        }
        for (;;)
        {
          this.a.dismiss();
          break;
          WkWeiXinUtil.sentToWeiXinCircle(1, this.b.getString(R.string.settings_more_sendto_content));
        }
      }
      if (paramInt == 2)
      {
        a.e().onEvent("invcli_3");
        MoreFragment.q(this.b);
        this.a.dismiss();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */