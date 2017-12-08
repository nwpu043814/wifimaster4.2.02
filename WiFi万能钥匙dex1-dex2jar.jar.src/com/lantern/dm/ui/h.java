package com.lantern.dm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import bluefay.app.Fragment;
import com.lantern.core.d.a;
import com.lantern.dm.utils.WkListView;
import java.util.Iterator;
import java.util.Set;

final class h
  implements DialogInterface.OnClickListener
{
  h(DownloadFragment paramDownloadFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = DownloadFragment.c(this.a).iterator();
    while (paramDialogInterface.hasNext())
    {
      DownloadFragment.k(this.a).a(new long[] { ((Long)paramDialogInterface.next()).longValue() });
      paramDialogInterface.remove();
    }
    DownloadFragment.a(this.a, Fragment.a, DownloadFragment.l(this.a));
    DownloadFragment.i(this.a).setVisibility(8);
    DownloadFragment.m(this.a).a(false);
    ((BaseAdapter)DownloadFragment.f(this.a).getAdapter()).notifyDataSetChanged();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */