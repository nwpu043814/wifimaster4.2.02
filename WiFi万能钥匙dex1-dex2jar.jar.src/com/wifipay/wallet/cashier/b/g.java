package com.wifipay.wallet.cashier.b;

import android.content.Intent;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.cashier.ui.SMSValidatorActivity;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import java.util.HashMap;

public class g
  extends a
{
  public g(SuperActivity paramSuperActivity, PayListener paramPayListener)
  {
    super(paramSuperActivity, paramPayListener);
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.b.d();
    if (paramInt == 3) {}
    for (boolean bool = true;; bool = false)
    {
      if ((CashierType.SETPWD.getType().equals(this.c.bindcardsource)) || (paramInt == 2))
      {
        this.c.additionalParams.put("needSetPayPwd", "Y");
        bool = false;
      }
      paramString = new Intent(this.b, SMSValidatorActivity.class);
      paramString.putExtra("pay_params", this.c);
      paramString.putExtra("has_digit_pwd", bool);
      a(paramString);
      return;
    }
  }
  
  public void d()
  {
    c();
    this.b.c("");
    BackgroundExecutor.a(new h(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */