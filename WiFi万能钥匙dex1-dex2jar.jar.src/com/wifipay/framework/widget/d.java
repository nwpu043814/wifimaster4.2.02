package com.wifipay.framework.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

class d
  implements View.OnClickListener
{
  d(WPCheckBox paramWPCheckBox) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    boolean bool;
    if (!WPCheckBox.a(this.a))
    {
      bool = true;
      WPCheckBox.a(paramView, bool);
      if (!WPCheckBox.a(this.a)) {
        break label87;
      }
    }
    label87:
    for (int i = WPCheckBox.b(this.a);; i = WPCheckBox.c(this.a))
    {
      WPCheckBox.d(this.a).setBackgroundResource(i);
      if (WPCheckBox.e(this.a) != null) {
        WPCheckBox.e(this.a).onChecked(WPCheckBox.a(this.a));
      }
      return;
      bool = false;
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */