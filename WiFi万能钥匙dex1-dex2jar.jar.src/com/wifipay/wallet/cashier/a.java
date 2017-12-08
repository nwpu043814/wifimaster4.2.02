package com.wifipay.wallet.cashier;

import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.a.o;
import com.wifipay.wallet.cashier.a.r;
import com.wifipay.wallet.cashier.a.u;
import com.wifipay.wallet.cashier.a.x;
import com.wifipay.wallet.cashier.a.z;
import com.wifipay.wallet.cashier.b.q;
import com.wifipay.wallet.cashier.b.s;
import com.wifipay.wallet.prod.core.model.StartPayParams;

public class a
{
  public static com.wifipay.wallet.cashier.a.a a(SuperActivity paramSuperActivity, StartPayParams paramStartPayParams, PayListener paramPayListener)
  {
    if (paramStartPayParams.type.equals(CashierType.BINDCARD.getType())) {
      paramSuperActivity = new com.wifipay.wallet.cashier.a.g(paramSuperActivity, null, paramPayListener);
    }
    for (;;)
    {
      return paramSuperActivity;
      if (paramStartPayParams.type.equals(CashierType.DEPOSIT.getType())) {
        paramSuperActivity = new com.wifipay.wallet.cashier.a.m(paramSuperActivity, paramStartPayParams, paramPayListener);
      } else if (paramStartPayParams.type.equals(CashierType.TRANSFER.getType())) {
        paramSuperActivity = new x(paramSuperActivity, paramStartPayParams, paramPayListener);
      } else if (paramStartPayParams.type.equals(CashierType.WITHDRAW.getType())) {
        paramSuperActivity = new z(paramSuperActivity, paramStartPayParams, paramPayListener);
      } else if (paramStartPayParams.type.equals(CashierType.CALLAPPPAY.getType())) {
        paramSuperActivity = new com.wifipay.wallet.cashier.a.i(paramSuperActivity, paramStartPayParams, paramPayListener);
      } else if (paramStartPayParams.type.equals(CashierType.NEWCARDPAY.getType())) {
        paramSuperActivity = new o(paramSuperActivity, paramStartPayParams, paramPayListener);
      } else if (paramStartPayParams.type.equals(CashierType.NEWDEPOSITPAY.getType())) {
        paramSuperActivity = new r(paramSuperActivity, paramStartPayParams, paramPayListener);
      } else if (paramStartPayParams.type.equals(CashierType.NEWTRANSFERPAY.getType())) {
        paramSuperActivity = new u(paramSuperActivity, paramStartPayParams, paramPayListener);
      } else {
        paramSuperActivity = null;
      }
    }
  }
  
  public static com.wifipay.wallet.cashier.b.a a(String paramString, SuperActivity paramSuperActivity, PayListener paramPayListener)
  {
    Object localObject = null;
    if (CashierType.BINDCARD.getType().equals(paramString)) {
      localObject = new com.wifipay.wallet.cashier.b.g(paramSuperActivity, paramPayListener);
    }
    for (;;)
    {
      return (com.wifipay.wallet.cashier.b.a)localObject;
      if (CashierType.WITHDRAW.getType().equals(paramString)) {
        localObject = new s(paramSuperActivity, paramPayListener);
      } else if (CashierType.TRANSFER.getType().equals(paramString)) {
        localObject = new q(paramSuperActivity, paramPayListener);
      } else if (CashierType.DEPOSIT.getType().equals(paramString)) {
        localObject = new com.wifipay.wallet.cashier.b.m(paramSuperActivity, paramPayListener);
      } else if (CashierType.CALLAPPPAY.getType().equals(paramString)) {
        localObject = new com.wifipay.wallet.cashier.b.i(paramSuperActivity, paramPayListener);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */