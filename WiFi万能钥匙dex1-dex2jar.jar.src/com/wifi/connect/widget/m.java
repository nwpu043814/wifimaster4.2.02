package com.wifi.connect.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import com.lantern.connect.R.id;
import com.wifi.connect.model.AccessPoint;

final class m
  implements DialogInterface.OnClickListener
{
  m(l paraml) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool1;
    boolean bool2;
    if ((paramInt == -1) && (l.a(this.a) != null))
    {
      bool1 = ((CheckBox)l.b(this.a).findViewById(R.id.backup_password)).isChecked();
      bool2 = ((CheckBox)l.b(this.a).findViewById(R.id.share_password)).isChecked();
      l.d(this.a).a(l.c(this.a).c());
      l.d(this.a).d(l.c(this.a).b());
      if (l.e(this.a) != null) {
        ((InputMethodManager)l.e(this.a).getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
      }
      if (!l.f(this.a)) {
        break label177;
      }
      l.a(this.a).a(2, true, false, bool1, l.g(this.a), l.d(this.a));
    }
    for (;;)
    {
      return;
      label177:
      l.a(this.a).a(1, bool2, l.h(this.a), bool1, l.g(this.a), l.d(this.a));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */