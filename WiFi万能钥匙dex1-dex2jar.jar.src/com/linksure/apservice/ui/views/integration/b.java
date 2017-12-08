package com.linksure.apservice.ui.views.integration;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

final class b
  extends DataSetObserver
{
  b(CircleIndicator paramCircleIndicator) {}
  
  public final void onChanged()
  {
    super.onChanged();
    if (CircleIndicator.a(this.a) == null) {}
    int i;
    do
    {
      return;
      i = CircleIndicator.a(this.a).getAdapter().getCount();
    } while (i == this.a.getChildCount());
    if (CircleIndicator.b(this.a) < i) {
      CircleIndicator.a(this.a, CircleIndicator.a(this.a).getCurrentItem());
    }
    for (;;)
    {
      CircleIndicator.e(this.a);
      break;
      CircleIndicator.a(this.a, -1);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/integration/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */