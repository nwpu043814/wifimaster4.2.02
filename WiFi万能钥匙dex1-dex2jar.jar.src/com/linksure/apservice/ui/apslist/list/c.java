package com.linksure.apservice.ui.apslist.list;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.linksure.apservice.b.a;

final class c
  implements AdapterView.OnItemLongClickListener
{
  c(ApsListFragment paramApsListFragment) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.g.b((a)paramAdapterView.getAdapter().getItem(paramInt));
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/list/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */