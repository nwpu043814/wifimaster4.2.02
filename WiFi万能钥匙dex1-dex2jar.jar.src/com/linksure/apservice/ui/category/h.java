package com.linksure.apservice.ui.category;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.linksure.apservice.b.c;
import com.linksure.apservice.utils.b;

final class h
  implements AdapterView.OnItemClickListener
{
  h(CategoryFragment paramCategoryFragment) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (c)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView.g) {
      this.a.a(paramAdapterView);
    }
    for (;;)
    {
      b.a("salsnacli", paramAdapterView.a);
      return;
      this.a.b(paramAdapterView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */