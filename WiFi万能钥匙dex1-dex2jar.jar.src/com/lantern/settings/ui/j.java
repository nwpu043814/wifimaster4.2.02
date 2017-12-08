package com.lantern.settings.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

final class j
  implements View.OnLongClickListener
{
  j(DiagnoseActivity paramDiagnoseActivity) {}
  
  public final boolean onLongClick(View paramView)
  {
    DiagnoseActivity.a(this.a, ((TextView)paramView).getText().toString());
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */