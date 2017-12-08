package com.wifipay.wallet.wifiactivity.fragment;

import android.widget.Button;
import com.wifipay.framework.api.b;
import com.wifipay.framework.widget.WPCheckBox.OnCheckListener;

class a
  implements WPCheckBox.OnCheckListener
{
  a(WifiActivityCardDetailFragment paramWifiActivityCardDetailFragment) {}
  
  public void onChecked(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      WifiActivityCardDetailFragment.a(this.a).setEnabled(false);
      WifiActivityCardDetailFragment.b(this.a).a();
    }
    for (;;)
    {
      return;
      WifiActivityCardDetailFragment.c(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/wifiactivity/fragment/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */