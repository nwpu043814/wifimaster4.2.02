package com.lantern.dm.ui;

import android.database.Cursor;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.lantern.dm.utils.WkListView;
import java.util.Set;

final class c
  implements CompoundButton.OnCheckedChangeListener
{
  c(DownloadFragment paramDownloadFragment) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!DownloadFragment.a(this.a)) {
      DownloadFragment.b(this.a);
    }
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        DownloadFragment.c(this.a).clear();
        DownloadFragment.d(this.a).moveToFirst();
        long l;
        while (!DownloadFragment.d(this.a).isAfterLast())
        {
          l = DownloadFragment.d(this.a).getLong(DownloadFragment.d(this.a).getColumnIndexOrThrow("_id"));
          DownloadFragment.c(this.a).add(Long.valueOf(l));
          DownloadFragment.d(this.a).moveToNext();
        }
        DownloadFragment.e(this.a).moveToFirst();
        while (!DownloadFragment.e(this.a).isAfterLast())
        {
          l = DownloadFragment.e(this.a).getLong(DownloadFragment.e(this.a).getColumnIndexOrThrow("_id"));
          DownloadFragment.c(this.a).add(Long.valueOf(l));
          DownloadFragment.e(this.a).moveToNext();
        }
      }
      DownloadFragment.c(this.a).clear();
      ((BaseAdapter)DownloadFragment.f(this.a).getAdapter()).notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */