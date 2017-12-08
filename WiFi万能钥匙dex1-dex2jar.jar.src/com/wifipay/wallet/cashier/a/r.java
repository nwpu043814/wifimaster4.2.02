package com.wifipay.wallet.cashier.a;

import com.wifipay.common.a.g;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.prod.bandcard.dto.BindCardPreSignResp;
import com.wifipay.wallet.prod.bandcard.dto.BindCardPreSignResp.ResultObject;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.deposit.DepositOrderCreateResp;
import com.wifipay.wallet.prod.deposit.DepositOrderCreateResp.ResultObject;
import java.util.HashMap;

public class r
  extends a
{
  public r(SuperActivity paramSuperActivity, StartPayParams paramStartPayParams, PayListener paramPayListener)
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
        BackgroundExecutor.a(new t(this));
      }
      else
      {
        this.c.d();
        a(-1, paramDepositOrderCreateResp);
        c(paramDepositOrderCreateResp.resultMessage);
      }
    }
  }
  
  public void a(BindCardPreSignResp paramBindCardPreSignResp)
  {
    this.c.d();
    if (ResponseCode.SUCCESS.getCode().equals(paramBindCardPreSignResp.resultCode))
    {
      if ((paramBindCardPreSignResp.resultObject != null) && (!g.a(paramBindCardPreSignResp.resultObject.requestNo))) {
        this.b.additionalParams.put("requestNo", paramBindCardPreSignResp.resultObject.requestNo);
      }
      this.b.type = CashierType.DEPOSIT.getType();
      a();
    }
    for (;;)
    {
      return;
      this.c.a(paramBindCardPreSignResp.resultMessage);
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    this.c.c("");
    BackgroundExecutor.a(new s(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */