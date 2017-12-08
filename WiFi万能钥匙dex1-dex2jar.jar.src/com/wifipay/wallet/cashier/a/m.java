package com.wifipay.wallet.cashier.a;

import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.deposit.DepositOrderCreateResp;
import com.wifipay.wallet.prod.deposit.DepositOrderCreateResp.ResultObject;
import java.util.HashMap;

public class m
  extends a
{
  public m(SuperActivity paramSuperActivity, StartPayParams paramStartPayParams, PayListener paramPayListener)
  {
    super(paramSuperActivity, paramStartPayParams, paramPayListener);
  }
  
  private void a(DepositOrderCreateResp paramDepositOrderCreateResp)
  {
    if (a(paramDepositOrderCreateResp)) {}
    for (;;)
    {
      return;
      if (ResponseCode.SUCCESS.getCode().equals(paramDepositOrderCreateResp.resultCode))
      {
        this.b.additionalParams.put("depositId", paramDepositOrderCreateResp.resultObject.depositId);
        this.c.d();
        a(-1, paramDepositOrderCreateResp);
      }
      else
      {
        this.c.d();
        c(paramDepositOrderCreateResp.resultMessage);
        a(-1, paramDepositOrderCreateResp);
      }
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    this.c.c("");
    BackgroundExecutor.a(new n(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */