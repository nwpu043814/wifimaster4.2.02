package com.wifipay.wallet.home.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.wifipay.framework.api.d;

class c
  implements View.OnTouchListener
{
  c(BannerViewPager paramBannerViewPager) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      this.a.getParent().requestDisallowInterceptTouchEvent(true);
      BannerViewPager.a(this.a, (int)paramMotionEvent.getX());
      BannerViewPager.c(this.a).a(null);
      bool1 = bool2;
      continue;
      BannerViewPager.c(this.a).a(null);
      bool1 = bool2;
      continue;
      BannerViewPager.c(this.a).a(null);
      if (paramMotionEvent.getX() - BannerViewPager.d(this.a) <= this.a.getWidth() / 3)
      {
        bool1 = bool2;
        if (paramMotionEvent.getX() - BannerViewPager.d(this.a) >= this.a.getWidth() / 3) {}
      }
      else
      {
        BannerViewPager.c(this.a).a(0, this.a.a);
        bool1 = bool2;
        continue;
        BannerViewPager.c(this.a).a(null);
        if (paramMotionEvent.getX() - BannerViewPager.d(this.a) <= this.a.getWidth() / 3)
        {
          bool1 = bool2;
          if (paramMotionEvent.getX() - BannerViewPager.d(this.a) >= this.a.getWidth() / 3) {}
        }
        else
        {
          BannerViewPager.c(this.a).a(0, this.a.a);
          bool1 = bool2;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */