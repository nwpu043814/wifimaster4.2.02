package com.wifipay.wallet.home.ui;

import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.home.bean.Banner;
import java.util.Comparator;

class j
  implements Comparator<Banner>
{
  j(HomeActivity paramHomeActivity) {}
  
  public int a(Banner paramBanner1, Banner paramBanner2)
  {
    if ((f.a(paramBanner1.order)) && (f.a(paramBanner2.order))) {}
    for (int i = Integer.valueOf(paramBanner1.order).intValue() - Integer.valueOf(paramBanner2.order).intValue();; i = -1) {
      return i;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */