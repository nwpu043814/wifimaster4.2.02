package com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.widget.Checkable;

class d
  extends j
  implements Checkable
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean isChecked()
  {
    return ((Checkable)this.a).isChecked();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    ((Checkable)this.a).setChecked(paramBoolean);
  }
  
  public void toggle()
  {
    if (!isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/se/emilsjolander/stickylistheaders/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */