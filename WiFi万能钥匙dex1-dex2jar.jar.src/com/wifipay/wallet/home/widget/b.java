package com.wifipay.wallet.home.widget;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.wifipay.framework.api.d;
import java.util.List;

class b
  implements ViewPager.OnPageChangeListener
{
  private BannerViewPager.a b;
  
  b(BannerViewPager paramBannerViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (BannerViewPager.a(this.a).size() > 1)
    {
      if (this.b != null) {
        break label58;
      }
      this.b = new BannerViewPager.a(this.a, paramInt);
    }
    for (;;)
    {
      BannerViewPager.b(this.a).a(this.b, 300L);
      return;
      label58:
      this.b.a(paramInt);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */