package com.lantern.launcher.ui;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;

final class n
  implements ViewPager.OnPageChangeListener
{
  n(UserGuideFragment paramUserGuideFragment, PagerAdapter paramPagerAdapter) {}
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    UserGuideFragment.a(this.b, paramInt);
    if (paramInt == this.a.getCount() - 1)
    {
      if (UserGuideFragment.b(this.b) == null) {
        break label39;
      }
      UserGuideFragment.c(this.b);
    }
    for (;;)
    {
      return;
      label39:
      if (UserGuideFragment.d(this.b) != null) {
        UserGuideFragment.e(this.b);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */