package com.wifipay.wallet.cashier.a;

import com.wifipay.common.a.g;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.transfer.TransConfirm3Resp;
import java.util.HashMap;

public class x
  extends a
{
  private String e;
  
  public x(SuperActivity paramSuperActivity, StartPayParams paramStartPayParams, PayListener paramPayListener)
  {
    super(paramSuperActivity, paramStartPayParams, paramPayListener);
  }
  
  private void a(TransConfirm3Resp paramTransConfirm3Resp)
  {
    if (a(paramTransConfirm3Resp)) {}
    for (;;)
    {
      return;
      if (ResponseCode.SUCCESS.getCode().equals(paramTransConfirm3Resp.resultCode))
      {
        this.c.d();
        a(-1, paramTransConfirm3Resp);
      }
      else
      {
        this.c.d();
        c(paramTransConfirm3Resp.resultMessage);
        a(-1, paramTransConfirm3Resp);
      }
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    this.c.c("");
    this.e = ((String)this.b.additionalParams.get("bizType"));
    if (g.a(this.e)) {
      this.e = "UT001";
    }
    BackgroundExecutor.a(new y(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */