package com.wifipay.wallet.cashier.a;

import android.content.Intent;
import com.wifipay.R.string;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.cashier.ui.SMSValidatorActivity;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.paypassword.common.PreRetrievePP;
import com.wifipay.wallet.paypassword.common.PreRetrievePP.onListener;
import com.wifipay.wallet.prod.core.model.StartPayParams;

public abstract class a
{
  protected String a;
  protected StartPayParams b;
  protected SuperActivity c;
  protected PayListener d;
  private PreRetrievePP.onListener e = new f(this);
  
  public a(SuperActivity paramSuperActivity, StartPayParams paramStartPayParams, PayListener paramPayListener)
  {
    this.c = paramSuperActivity;
    this.b = paramStartPayParams;
    this.d = paramPayListener;
  }
  
  private void b()
  {
    new PreRetrievePP(this.c, this.e).a();
  }
  
  private void d(String paramString)
  {
    this.c.a("", paramString, com.wifipay.common.a.f.a(R.string.wifipay_common_repeat), new b(this), com.wifipay.common.a.f.a(R.string.wifipay_forget_pay_pwd), new c(this));
  }
  
  private void e(String paramString)
  {
    this.c.a("", paramString, com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_i_know), new d(this), null, null);
  }
  
  protected void a()
  {
    Intent localIntent = new Intent(this.c, SMSValidatorActivity.class);
    localIntent.putExtra("pay_params", this.b);
    this.c.startActivity(localIntent);
    this.c.finish();
  }
  
  protected void a(int paramInt, BaseResp paramBaseResp)
  {
    if (com.wifipay.wallet.common.utils.f.a(this.d)) {
      this.d.payFinish(paramInt, paramBaseResp);
    }
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  protected boolean a(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if (ResponseCode.PAY_PWD_LOCKED.getCode().equals(paramBaseResp.resultCode))
    {
      this.c.d();
      e(paramBaseResp.resultMessage);
    }
    for (;;)
    {
      return bool;
      if (ResponseCode.PAY_PWD_ERROR.getCode().equals(paramBaseResp.resultCode))
      {
        this.c.d();
        d(paramBaseResp.resultMessage);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void b(String paramString)
  {
    this.c.d();
    this.c.a("", paramString, com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_i_know), new e(this), null, null);
  }
  
  protected void c(String paramString)
  {
    this.c.a(paramString);
    a(0, null);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */