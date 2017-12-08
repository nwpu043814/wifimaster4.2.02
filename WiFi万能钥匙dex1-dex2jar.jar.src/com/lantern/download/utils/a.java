package com.lantern.download.utils;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import com.bluefay.b.h;

final class a
  implements ExpandableListView.OnGroupClickListener
{
  a(PinnedExpandableListView paramPinnedExpandableListView) {}
  
  public final boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    h.a("group click state:%s", new Object[] { Integer.valueOf(PinnedExpandableListView.a(this.a).b(paramInt)) });
    if (PinnedExpandableListView.a(this.a).b(paramInt) == 0)
    {
      PinnedExpandableListView.a(this.a).b(paramInt, 1);
      paramExpandableListView.collapseGroup(paramInt);
    }
    for (;;)
    {
      paramExpandableListView.setSelectedGroup(paramInt);
      return true;
      if (PinnedExpandableListView.a(this.a).b(paramInt) == 1)
      {
        PinnedExpandableListView.a(this.a).b(paramInt, 0);
        paramExpandableListView.expandGroup(paramInt);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/download/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */