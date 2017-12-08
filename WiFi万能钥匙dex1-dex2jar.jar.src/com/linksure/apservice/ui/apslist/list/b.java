package com.linksure.apservice.ui.apslist.list;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.linksure.apservice.b.a;

final class b
  implements AdapterView.OnItemClickListener
{
  b(ApsListFragment paramApsListFragment) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.g.a((a)paramAdapterView.getAdapter().getItem(paramInt));
    com.linksure.apservice.utils.b.a("saadnacli", ((a)paramAdapterView.getAdapter().getItem(paramInt)).k);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/list/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */