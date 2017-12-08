package com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders;

import android.view.View;
import android.view.View.OnClickListener;

class c
  implements View.OnClickListener
{
  c(a parama, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (a.d(this.b) != null)
    {
      long l = this.b.a.getHeaderId(this.a);
      a.d(this.b).a(paramView, this.a, l);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/se/emilsjolander/stickylistheaders/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */