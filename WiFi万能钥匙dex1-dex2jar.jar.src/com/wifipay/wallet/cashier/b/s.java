package com.wifipay.wallet.cashier.b;

import android.content.Intent;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.deposit.ui.MoneyFailActivity;
import com.wifipay.wallet.deposit.ui.MoneySuccessActivity;
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.withdraw.WithdrawConfirmResp;
import com.wifipay.wallet.prod.withdraw.WithdrawConfirmResp.ResultObject;
import com.wifipay.wallet.prod.withdraw.WithdrawService;
import java.util.HashMap;

public class s
  extends a
{
  private String d = null;
  
  public s(SuperActivity paramSuperActivity, PayListener paramPayListener)
  {
    super(paramSuperActivity, paramPayListener);
  }
  
  private void a(WithdrawConfirmResp paramWithdrawConfirmResp)
  {
    this.b.d();
    Intent localIntent;
    if (ResponseCode.SUCCESS.getCode().equals(paramWithdrawConfirmResp.resultCode))
    {
      localIntent = new Intent(this.b, MoneySuccessActivity.class);
      localIntent.putExtra("extra_type", this.b.getString(R.string.wifipay_withdraw_title));
      localIntent.putExtra("extra_amoubt", (String)this.c.additionalParams.get("amount"));
      localIntent.putExtra("extra_bankcode", paramWithdrawConfirmResp.resultObject.cardNo);
      localIntent.putExtra("extra_bankname", paramWithdrawConfirmResp.resultObject.bankName);
      this.b.startActivity(localIntent);
    }
    for (;;)
    {
      return;
      localIntent = new Intent(this.b, MoneyFailActivity.class);
      localIntent.putExtra("extra_type", this.b.getString(R.string.wifipay_withdraw_title));
      localIntent.putExtra("reason", paramWithdrawConfirmResp.resultMessage);
      this.b.startActivity(localIntent);
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.b.d();
    h();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    this.b.c("");
    this.d = com.wifipay.wallet.common.info.a.a().b("pay_pwd");
    WithdrawService localWithdrawService = (WithdrawService)RpcService.getRpcProxy(WithdrawService.class);
    String str = (String)this.c.additionalParams.get("withdrawLabel");
    if ((!g.a(paramString1)) && (!g.a(paramString2)) && (!g.a(this.d))) {
      if (str.equalsIgnoreCase("T0")) {
        BackgroundExecutor.a(new u(this, localWithdrawService, paramString1));
      }
    }
    for (;;)
    {
      return;
      BackgroundExecutor.a(new v(this, localWithdrawService, paramString1));
      continue;
      this.b.finish();
    }
  }
  
  public void d()
  {
    c();
    if (!this.c.chosenCard.getType().equals("NEW_CARD"))
    {
      this.b.c("");
      BackgroundExecutor.a(new t(this));
    }
    for (;;)
    {
      return;
      f();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */