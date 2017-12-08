package com.wifipay.wallet.home.ui;

import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.home.bean.SubApp;
import java.util.Comparator;

class i
  implements Comparator<SubApp>
{
  i(HomeActivity paramHomeActivity) {}
  
  public int a(SubApp paramSubApp1, SubApp paramSubApp2)
  {
    if ((f.a(paramSubApp1.order)) && (f.a(paramSubApp2.order))) {}
    for (int i = Integer.valueOf(paramSubApp1.order).intValue() - Integer.valueOf(paramSubApp2.order).intValue();; i = -1) {
      return i;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */