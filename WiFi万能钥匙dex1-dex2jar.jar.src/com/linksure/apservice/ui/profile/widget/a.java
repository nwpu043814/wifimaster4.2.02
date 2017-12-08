package com.linksure.apservice.ui.profile.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bluefay.a.e;
import com.linksure.apservice.R.string;
import com.linksure.apservice.a.b.b;
import com.linksure.apservice.a.b.d;

final class a
  implements DialogInterface.OnClickListener
{
  a(BottomDialog paramBottomDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.b(this.a.getActivity()).b(BottomDialog.a(this.a).k);
    b.a(this.a.getActivity()).a(BottomDialog.a(this.a).k, "", 0L);
    e.a(R.string.aps_history_clean_success);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */