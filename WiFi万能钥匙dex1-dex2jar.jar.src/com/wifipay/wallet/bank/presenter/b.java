package com.wifipay.wallet.bank.presenter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.wifipay.wallet.prod.core.model.BankCard;
import java.util.ArrayList;

class b
  implements AdapterView.OnItemClickListener
{
  b(a parama) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((a.a(this.a) != null) && (a.a(this.a).size() > paramInt)) {
      a.a(this.a, (BankCard)a.a(this.a).get(paramInt));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/bank/presenter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */