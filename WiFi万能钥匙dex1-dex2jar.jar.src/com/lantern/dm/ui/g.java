package com.lantern.dm.ui;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

final class g
  implements ExpandableListView.OnChildClickListener
{
  g(DownloadFragment paramDownloadFragment) {}
  
  public final boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    if (DownloadFragment.i(this.a).getVisibility() == 8) {}
    for (int i = 1;; i = 0)
    {
      if ((paramInt1 == 1) && (i != 0) && (DownloadFragment.j(this.a)))
      {
        DownloadFragment.e(this.a).moveToPosition(paramInt2);
        DownloadFragment.a(this.a, DownloadFragment.e(this.a));
      }
      return false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */