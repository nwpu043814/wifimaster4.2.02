package com.wifipay.wallet.cashier.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.prod.core.model.StartPayParams;

public class NewCardPayActivity
  extends BaseActivity
{
  private StartPayParams h;
  
  static
  {
    StubApp1053578832.interface11(110);
  }
  
  public boolean a()
  {
    if ((CashierType.CALLAPPPAY.getType().equals(this.h.type)) || (CashierType.NEWCARDPAY.getType().equals(this.h.type)))
    {
      Intent localIntent = new Intent(this, PasswordActivity.class);
      this.h.type = CashierType.CALLAPPPAY.getType();
      localIntent.putExtra("pay_params", this.h);
      startActivity(localIntent);
      finish();
    }
    return super.a();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    c(f()).onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && ((CashierType.CALLAPPPAY.getType().equals(this.h.type)) || (CashierType.NEWCARDPAY.getType().equals(this.h.type))))
    {
      Intent localIntent = new Intent(this, PasswordActivity.class);
      this.h.type = CashierType.CALLAPPPAY.getType();
      localIntent.putExtra("pay_params", this.h);
      startActivity(localIntent);
      finish();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/ui/NewCardPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */