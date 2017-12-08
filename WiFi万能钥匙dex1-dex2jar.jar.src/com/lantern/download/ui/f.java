package com.lantern.download.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import bluefay.app.Fragment;
import com.lantern.dm.R.anim;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

final class f
  implements DialogInterface.OnClickListener
{
  f(DownloadFragment paramDownloadFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = DownloadFragment.c(this.a).iterator();
    while (paramDialogInterface.hasNext())
    {
      Long localLong = (Long)paramDialogInterface.next();
      DownloadFragment.g(this.a).a(new long[] { localLong.longValue() });
      DownloadFragment.a(this.a).b().remove(localLong);
    }
    DownloadFragment.a(this.a, Fragment.a, DownloadFragment.h(this.a));
    DownloadFragment.e(this.a).setVisibility(8);
    DownloadFragment.e(this.a).startAnimation(AnimationUtils.loadAnimation(DownloadFragment.i(this.a), R.anim.dm_footer_disappear));
    DownloadFragment.a(this.a).a(DownloadFragment.e(this.a).getVisibility());
    DownloadFragment.a(this.a).notifyDataSetChanged();
    DownloadFragment.c(this.a).clear();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/download/ui/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */