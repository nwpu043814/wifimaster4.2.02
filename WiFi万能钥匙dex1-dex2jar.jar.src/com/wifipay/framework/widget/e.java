package com.wifipay.framework.widget;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;

class e
  implements View.OnFocusChangeListener
{
  e(WPClearEditText paramWPClearEditText) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    paramView = this.a;
    if ((paramBoolean) && (this.a.isEnabled()) && (this.a.getText().length() > 0)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramView.a(true, paramBoolean);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */