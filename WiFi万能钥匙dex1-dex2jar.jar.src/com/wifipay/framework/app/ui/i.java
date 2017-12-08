package com.wifipay.framework.app.ui;

import com.wifipay.common.net.UnifyDispose;
import com.wifipay.framework.widget.WPAlertDialog.onPositiveListener;

class i
  implements WPAlertDialog.onPositiveListener
{
  i(SuperActivity paramSuperActivity, UnifyDispose paramUnifyDispose) {}
  
  public void onPositive()
  {
    SuperActivity.c(true);
    this.b.b(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/app/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */