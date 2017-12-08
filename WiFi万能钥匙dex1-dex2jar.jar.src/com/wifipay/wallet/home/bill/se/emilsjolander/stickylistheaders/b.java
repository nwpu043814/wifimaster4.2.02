package com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders;

import android.database.DataSetObserver;
import java.util.List;

class b
  extends DataSetObserver
{
  b(a parama) {}
  
  public void onChanged()
  {
    a.c(this.a);
  }
  
  public void onInvalidated()
  {
    a.a(this.a).clear();
    a.b(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/se/emilsjolander/stickylistheaders/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */