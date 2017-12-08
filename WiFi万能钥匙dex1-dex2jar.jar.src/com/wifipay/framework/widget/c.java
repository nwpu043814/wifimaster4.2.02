package com.wifipay.framework.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.wifipay.R.id;

class c
  implements View.OnClickListener
{
  c(WPAlertDialog paramWPAlertDialog) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.wifipay_alert_button1)
    {
      this.a.dismiss();
      if (WPAlertDialog.a(this.a) != null) {
        WPAlertDialog.a(this.a).onNegative();
      }
    }
    for (;;)
    {
      return;
      if (i == R.id.wifipay_alert_button2)
      {
        this.a.dismiss();
        if (WPAlertDialog.b(this.a) != null) {
          WPAlertDialog.b(this.a).onPositive();
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */