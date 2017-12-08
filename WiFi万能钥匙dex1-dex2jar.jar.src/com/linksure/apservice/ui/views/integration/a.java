package com.linksure.apservice.ui.views.integration;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;

final class a
  implements ViewPager.OnPageChangeListener
{
  a(CircleIndicator paramCircleIndicator) {}
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    if ((CircleIndicator.a(this.a).getAdapter() == null) || (CircleIndicator.a(this.a).getAdapter().getCount() <= 0)) {}
    for (;;)
    {
      return;
      if (CircleIndicator.b(this.a) >= 0)
      {
        localView = this.a.getChildAt(CircleIndicator.b(this.a));
        if (localView != null) {
          localView.setBackgroundResource(CircleIndicator.c(this.a));
        }
      }
      View localView = this.a.getChildAt(paramInt);
      if (localView != null) {
        localView.setBackgroundResource(CircleIndicator.d(this.a));
      }
      CircleIndicator.a(this.a, paramInt);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/integration/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */