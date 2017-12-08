package com.wifipay.wallet.authentication.fragment;

import com.wifipay.R.string;
import com.wifipay.framework.widget.wheel.OnWheelScrollListener;
import com.wifipay.framework.widget.wheel.WPWheelView;
import com.wifipay.wallet.authentication.a;

class f
  implements OnWheelScrollListener
{
  f(UploadShowPhotoFragment paramUploadShowPhotoFragment) {}
  
  public void onScrollingFinished(WPWheelView paramWPWheelView)
  {
    int i = UploadShowPhotoFragment.f(this.a).getCurrentItem();
    int k = UploadShowPhotoFragment.g(this.a);
    int j = UploadShowPhotoFragment.h(this.a).getCurrentItem() + 1;
    if (UploadShowPhotoFragment.f(this.a).getCurrentItem() + UploadShowPhotoFragment.g(this.a) == UploadShowPhotoFragment.i(this.a))
    {
      paramWPWheelView = new a(this.a.c(), 1, 1, "%02d");
      paramWPWheelView.a(com.wifipay.common.a.f.a(R.string.wifipay_personal_month));
      UploadShowPhotoFragment.h(this.a).setViewAdapter(paramWPWheelView);
      UploadShowPhotoFragment.h(this.a).setCyclic(false);
      UploadShowPhotoFragment.h(this.a).setCurrentItem(0);
    }
    for (;;)
    {
      UploadShowPhotoFragment.a(this.a, i + k, j);
      return;
      paramWPWheelView = new a(this.a.c(), 1, 12, "%02d");
      paramWPWheelView.a(com.wifipay.common.a.f.a(R.string.wifipay_personal_month));
      UploadShowPhotoFragment.h(this.a).setViewAdapter(paramWPWheelView);
      UploadShowPhotoFragment.h(this.a).setCyclic(false);
      UploadShowPhotoFragment.h(this.a).setCurrentItem(j - 1);
    }
  }
  
  public void onScrollingStarted(WPWheelView paramWPWheelView) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/authentication/fragment/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */