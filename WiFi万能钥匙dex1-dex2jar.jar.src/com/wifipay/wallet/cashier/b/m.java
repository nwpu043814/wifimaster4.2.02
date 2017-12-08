package com.wifipay.wallet.cashier.b;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.common.a.g;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.cashier.ui.NewCardPayActivity;
import com.wifipay.wallet.cashier.ui.PasswordSingleVerifyActivity;
import com.wifipay.wallet.common.info.AppInfo;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.paypassword.common.PreRetrievePP;
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.deposit.DepositOrderCreateResp;
import com.wifipay.wallet.prod.deposit.DepositOrderCreateResp.ResultObject;
import com.wifipay.wallet.prod.deposit.DepositOrderSendCodeResp;
import java.util.HashMap;

public class m
  extends a
{
  public m(SuperActivity paramSuperActivity, PayListener paramPayListener)
  {
    super(paramSuperActivity, paramPayListener);
  }
  
  private void a(DepositOrderCreateResp paramDepositOrderCreateResp)
  {
    if (ResponseCode.SUCCESS.getCode().equals(paramDepositOrderCreateResp.resultCode))
    {
      this.c.additionalParams.put("depositId", paramDepositOrderCreateResp.resultObject.depositId);
      BackgroundExecutor.a(new p(this));
    }
    for (;;)
    {
      return;
      this.b.d();
      this.b.b(paramDepositOrderCreateResp.resultMessage);
    }
  }
  
  private void a(DepositOrderSendCodeResp paramDepositOrderSendCodeResp)
  {
    this.b.d();
    if (ResponseCode.SUCCESS.getCode().equals(paramDepositOrderSendCodeResp.resultCode)) {
      i();
    }
    for (;;)
    {
      return;
      this.b.b(paramDepositOrderSendCodeResp.resultMessage);
    }
  }
  
  private void k()
  {
    BackgroundExecutor.a(new n(this));
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.b.d();
    if (paramInt == 2) {
      new PreRetrievePP(this.b, null).a(this.b.getResources().getString(R.string.wifipay_found_pwd_title));
    }
    for (;;)
    {
      return;
      if (!this.c.chosenCard.getType().equals("NEW_CARD"))
      {
        localObject = this.c.chosenCard.agreementNo;
        if (g.a(this.c.chosenCard.mobile) == true) {}
        for (paramString = this.c.chosenCard.instMobile;; paramString = this.c.chosenCard.mobile)
        {
          this.c.additionalParams.put("agreementNo", localObject);
          this.c.additionalParams.put("mobile", paramString);
          h();
          break;
        }
      }
      paramString = this.b.getString(R.string.wifipay_new_card_title, new Object[] { f.a(R.string.wifipay_deposit_title) });
      Object localObject = new Intent();
      ((Intent)localObject).setComponent(new ComponentName(this.b.getPackageName(), NewCardPayActivity.class.getName()));
      ((Intent)localObject).putExtra("pay_params", this.c);
      ((Intent)localObject).putExtra("title", paramString);
      AppInfo.INSTANCE.setNextIntent((Intent)localObject);
      localObject = new Intent(this.b, PasswordSingleVerifyActivity.class);
      ((Intent)localObject).putExtra("save_ped", true);
      ((Intent)localObject).putExtra("title", paramString);
      this.b.startActivity((Intent)localObject);
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    this.b.c("");
    this.c.additionalParams.put("agreementNo", paramString1);
    this.c.additionalParams.put("mobile", paramString2);
    String str = com.wifipay.wallet.common.info.a.a().b("pay_pwd");
    if ((!g.a(paramString1)) && (!g.a(paramString2)) && (!g.a(str))) {
      BackgroundExecutor.a(new o(this, str, paramString1));
    }
    for (;;)
    {
      return;
      this.b.finish();
    }
  }
  
  public void d()
  {
    c();
    this.b.c("");
    k();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */