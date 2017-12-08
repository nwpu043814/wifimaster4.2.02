package com.linksure.apservice.ui.category;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;
import com.linksure.apservice.b.b;

final class g
  implements AdapterView.OnItemClickListener
{
  g(CategoryFragment paramCategoryFragment) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = CategoryFragment.f(this.a).a(paramInt);
    if (!CategoryFragment.g(this.a).equals(paramAdapterView.a))
    {
      CategoryFragment.h(this.a);
      CategoryFragment.a(this.a, paramAdapterView.a);
      CategoryFragment.i(this.a).setVisibility(0);
      CategoryFragment.e(this.a).a(CategoryFragment.g(this.a), CategoryFragment.j(this.a));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */