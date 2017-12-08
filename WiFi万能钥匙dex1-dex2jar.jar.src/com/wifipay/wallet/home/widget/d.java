package com.wifipay.wallet.home.widget;

import android.view.View;
import android.view.View.OnClickListener;

class d
  implements View.OnClickListener
{
  d(BannerViewPager.MyViewPagerAdapter paramMyViewPagerAdapter) {}
  
  public void onClick(View paramView)
  {
    if (BannerViewPager.g(this.a.a) != null) {
      BannerViewPager.g(this.a.a).onItemClick(paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */