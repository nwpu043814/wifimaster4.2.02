package com.wifipay.wallet.cashier.a;

import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.withdraw.WithdrawConfirmResp;
import com.wifipay.wallet.prod.withdraw.WithdrawService;
import java.util.HashMap;

public class z
  extends a
{
  public z(SuperActivity paramSuperActivity, StartPayParams paramStartPayParams, PayListener paramPayListener)
  {
    super(paramSuperActivity, paramStartPayParams, paramPayListener);
  }
  
  private void a(WithdrawConfirmResp paramWithdrawConfirmResp)
  {
    if (a(paramWithdrawConfirmResp)) {}
    for (;;)
    {
      return;
      this.c.d();
      if (ResponseCode.SUCCESS.getCode().equals(paramWithdrawConfirmResp.resultCode)) {
        a(-1, paramWithdrawConfirmResp);
      } else {
        c(paramWithdrawConfirmResp.resultMessage);
      }
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    paramString = (WithdrawService)RpcService.getRpcProxy(WithdrawService.class);
    if (((String)this.b.additionalParams.get("withdrawLabel")).equalsIgnoreCase("T0")) {
      BackgroundExecutor.a(new aa(this, paramString));
    }
    for (;;)
    {
      return;
      BackgroundExecutor.a(new ab(this, paramString));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */