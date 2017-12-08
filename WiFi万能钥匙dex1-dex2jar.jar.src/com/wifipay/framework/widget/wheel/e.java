package com.wifipay.framework.widget.wheel;

import android.database.DataSetObserver;

class e
  extends DataSetObserver
{
  e(WPWheelView paramWPWheelView) {}
  
  public void onChanged()
  {
    this.a.a(false);
  }
  
  public void onInvalidated()
  {
    this.a.a(true);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/wheel/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */