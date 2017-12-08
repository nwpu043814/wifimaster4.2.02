package com.lantern.download.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.lantern.dm.R.id;
import java.util.HashSet;

final class d
  implements View.OnClickListener
{
  d(DownloadFragment paramDownloadFragment) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == R.id.load_checkbox_select) {
      if (DownloadFragment.b(this.a).isChecked())
      {
        DownloadFragment.a(this.a, DownloadFragment.a(this.a).b(), true);
        DownloadFragment.a(this.a).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      return;
      DownloadFragment.a(this.a, DownloadFragment.a(this.a).b(), false);
      break;
      if ((paramView.getId() == R.id.load_deselect_all) && (!DownloadFragment.c(this.a).isEmpty())) {
        DownloadFragment.d(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/download/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */