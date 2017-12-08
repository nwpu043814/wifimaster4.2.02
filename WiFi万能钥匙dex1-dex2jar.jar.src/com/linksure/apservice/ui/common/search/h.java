package com.linksure.apservice.ui.common.search;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.linksure.apservice.b.a;
import com.linksure.apservice.utils.b;

final class h
  implements AdapterView.OnItemClickListener
{
  h(SearchFragment paramSearchFragment) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    SearchFragment.a(this.a, (a)paramAdapterView.getAdapter().getItem(paramInt));
    b.a("sasrnacli", ((a)paramAdapterView.getAdapter().getItem(paramInt)).k);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/search/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */