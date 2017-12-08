package com.lantern.download.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import com.bluefay.b.h;
import java.util.HashMap;
import java.util.HashSet;

final class e
  implements ExpandableListView.OnChildClickListener
{
  e(DownloadFragment paramDownloadFragment) {}
  
  public final boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    paramLong = DownloadFragment.a(this.a).a(paramInt1, paramInt2).longValue();
    int i;
    if (DownloadFragment.e(this.a).getVisibility() == 0)
    {
      i = 1;
      h.a("id:" + paramLong, new Object[0]);
      if (i == 0) {
        break label222;
      }
      paramExpandableListView = (a.a)paramView.getTag();
      paramExpandableListView.a.toggle();
      if (!paramExpandableListView.a.isChecked()) {
        break label166;
      }
      DownloadFragment.c(this.a).add(Long.valueOf(paramLong));
      DownloadFragment.a(this.a).b().put(Long.valueOf(paramLong), Boolean.valueOf(true));
      label127:
      if (DownloadFragment.c(this.a).size() != DownloadFragment.f(this.a)) {
        break label208;
      }
      DownloadFragment.b(this.a).setChecked(true);
    }
    for (;;)
    {
      return false;
      i = 0;
      break;
      label166:
      DownloadFragment.c(this.a).remove(Long.valueOf(paramLong));
      DownloadFragment.a(this.a).b().put(Long.valueOf(paramLong), Boolean.valueOf(false));
      break label127;
      label208:
      DownloadFragment.b(this.a).setChecked(false);
      continue;
      label222:
      if (paramInt1 == 1) {
        DownloadFragment.a(this.a, paramInt2, paramLong);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/download/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */