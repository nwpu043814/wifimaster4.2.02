package com.wifipay.wallet.cashier.a;

import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.paypassword.PPService;
import com.wifipay.wallet.prod.paypassword.SetPwdResp;

public class g
  extends a
{
  public g(SuperActivity paramSuperActivity, StartPayParams paramStartPayParams, PayListener paramPayListener)
  {
    super(paramSuperActivity, paramStartPayParams, paramPayListener);
  }
  
  public void a(SetPwdResp paramSetPwdResp)
  {
    this.c.d();
    if (ResponseCode.SUCCESS.getCode().equals(paramSetPwdResp.resultCode)) {
      a(-1, paramSetPwdResp);
    }
    for (;;)
    {
      return;
      c(paramSetPwdResp.resultMessage);
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    this.c.c("");
    BackgroundExecutor.a(new h(this, (PPService)RpcService.getRpcProxy(PPService.class)));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */