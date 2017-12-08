package com.wifipay.wallet.cashier.b;

import android.content.res.Resources;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.common.a.g;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.paypassword.common.PreRetrievePP;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.pay.PayResultResp;
import com.wifipay.wallet.prod.pay.PayResultResp.ResultObject;
import java.util.HashMap;

public class i
  extends a
{
  public i(SuperActivity paramSuperActivity, PayListener paramPayListener)
  {
    super(paramSuperActivity, paramPayListener);
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.b.d();
    if (this.a == 2) {
      new PreRetrievePP(this.b, null, CashierType.CALLAPPPAY.getType()).a(this.b.getResources().getString(R.string.wifipay_found_pwd_title));
    }
    for (;;)
    {
      return;
      h();
    }
  }
  
  public void a(BaseResp paramBaseResp)
  {
    this.b.d();
    if (ResponseCode.SUCCESS.getCode().equals(paramBaseResp.resultCode)) {
      i();
    }
    for (;;)
    {
      return;
      this.b.a(paramBaseResp.resultMessage);
      this.b.finish();
    }
  }
  
  public void a(PayResultResp paramPayResultResp)
  {
    if (ResponseCode.SUCCESS.getCode().equals(paramPayResultResp.resultCode))
    {
      this.c.additionalParams.put("orderId", paramPayResultResp.resultObject.orderId);
      if ("Y".equalsIgnoreCase(paramPayResultResp.resultObject.needSendSms)) {
        BackgroundExecutor.a(new l(this, paramPayResultResp));
      }
    }
    for (;;)
    {
      return;
      this.b.a(paramPayResultResp.resultMessage);
      this.b.finish();
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    this.b.c(f.a(R.string.wifipay_progress_pay));
    String str = com.wifipay.wallet.common.info.a.a().b("pay_pwd");
    this.c.additionalParams.put("payPwd", str);
    this.c.additionalParams.put("mobile", paramString2);
    this.c.additionalParams.put("agreementNo", paramString1);
    this.c.additionalParams.put("paymentType", "CONVENIENCE");
    if ((!g.a(paramString1)) && (!g.a(paramString2)) && (!g.a(str))) {
      BackgroundExecutor.a(new k(this, str));
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
    BackgroundExecutor.a(new j(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */