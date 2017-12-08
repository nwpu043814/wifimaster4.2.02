package com.wifipay.wallet.paypassword.common;

import android.content.Intent;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.paypassword.ui.ModifyOldPPActivity;
import com.wifipay.wallet.prod.paypassword.QueryDigitPwdResp;

public class a
{
  private BaseActivity a;
  
  public a(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  private void a(int paramInt, String paramString)
  {
    com.wifipay.wallet.common.info.b.a().c().setWalletState(paramInt);
    if (paramInt == 3)
    {
      paramString = new Intent(this.a, ModifyOldPPActivity.class);
      this.a.startActivity(paramString);
    }
    for (;;)
    {
      return;
      if (paramInt == 2) {
        c();
      }
    }
  }
  
  private void a(QueryDigitPwdResp paramQueryDigitPwdResp)
  {
    this.a.d();
    String str = paramQueryDigitPwdResp.resultCode;
    int i;
    if (ResponseCode.ACCOUNT_NOT_EXISTS.getCode().equals(str)) {
      i = 1;
    }
    for (;;)
    {
      if (i == -1) {
        this.a.a(paramQueryDigitPwdResp.resultMessage);
      }
      for (;;)
      {
        return;
        if (ResponseCode.NO_DIGIT_PWD.getCode().equals(str))
        {
          i = 2;
          break;
        }
        if (!ResponseCode.SUCCESS.getCode().equals(str)) {
          break label92;
        }
        i = 3;
        break;
        a(i, paramQueryDigitPwdResp.resultMessage);
      }
      label92:
      i = -1;
    }
  }
  
  private void b()
  {
    int i = com.wifipay.wallet.common.info.b.a().j();
    if (i == -1)
    {
      this.a.c("");
      BackgroundExecutor.a(new b(this));
    }
    for (;;)
    {
      return;
      a(i, "");
    }
  }
  
  private void c()
  {
    this.a.a(f.a(R.string.wifipay_alert_text_set_pay_pwd), f.a(R.string.wifipay_alert_btn_set_pay_pwd), new c(this));
  }
  
  private void d()
  {
    new PreRetrievePP(this.a, null).a();
  }
  
  public void a()
  {
    b();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/common/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */