package com.wifipay.wallet.cashier.a;

import android.content.Intent;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.cashier.ui.NewCardPayActivity;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.pay.NewResultResp;
import com.wifipay.wallet.prod.pay.NewResultResp.ResultObject;
import com.wifipay.wallet.prod.pay.PayService;
import com.wifipay.wallet.prod.paypassword.VerifyPayPwdResp;
import java.util.HashMap;

public class i
  extends a
{
  private SuperActivity e;
  private PayService f;
  
  public i(SuperActivity paramSuperActivity, StartPayParams paramStartPayParams, PayListener paramPayListener)
  {
    super(paramSuperActivity, paramStartPayParams, paramPayListener);
    this.e = paramSuperActivity;
  }
  
  private void a(VerifyPayPwdResp paramVerifyPayPwdResp)
  {
    if ((!com.wifipay.wallet.common.utils.f.a(paramVerifyPayPwdResp)) || (a(paramVerifyPayPwdResp))) {}
    for (;;)
    {
      return;
      if (ResponseCode.SUCCESS.getCode().equals(paramVerifyPayPwdResp.resultCode)) {
        b();
      } else {
        b(paramVerifyPayPwdResp.resultMessage);
      }
    }
  }
  
  public void a(NewResultResp paramNewResultResp)
  {
    if (a(paramNewResultResp)) {}
    for (;;)
    {
      return;
      if ((ResponseCode.SUCCESS.getCode().equals(paramNewResultResp.resultCode)) && (paramNewResultResp.resultObject != null))
      {
        this.b.additionalParams.put("orderId", paramNewResultResp.resultObject.orderId);
        if (g.a(paramNewResultResp.resultObject.payStatus, "NeedPaypwd")) {
          BackgroundExecutor.a(new l(this));
        } else if (!"Y".equalsIgnoreCase(paramNewResultResp.resultObject.needSendSms)) {
          a(-1, paramNewResultResp);
        }
      }
      else
      {
        b(paramNewResultResp.resultMessage);
      }
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    this.f = ((PayService)RpcService.getRpcProxy(PayService.class));
    if ((com.wifipay.wallet.common.utils.f.a(this.b.chosenCard)) && (this.b.chosenCard.getType().equals("NEW_CARD"))) {
      BackgroundExecutor.a(new j(this, paramString));
    }
    for (;;)
    {
      return;
      BackgroundExecutor.a(new k(this));
    }
  }
  
  public void b()
  {
    String str = this.e.getString(R.string.wifipay_new_card_title, new Object[] { com.wifipay.common.a.f.a(R.string.wifipay_btn_pay) });
    Intent localIntent = new Intent(this.e, NewCardPayActivity.class);
    localIntent.putExtra("pay_params", this.b);
    localIntent.putExtra("title", str);
    com.wifipay.wallet.common.info.a.a().a(new String[] { "pay_pwd", this.a });
    this.e.startActivity(localIntent);
    this.e.finish();
  }
  
  public void b(NewResultResp paramNewResultResp)
  {
    if (a(paramNewResultResp)) {}
    for (;;)
    {
      return;
      if (ResponseCode.SUCCESS.getCode().equals(paramNewResultResp.resultCode))
      {
        this.b.additionalParams.put("orderId", paramNewResultResp.resultObject.orderId);
        if (!"Y".equalsIgnoreCase(paramNewResultResp.resultObject.needSendSms)) {
          a(-1, paramNewResultResp);
        }
      }
      else
      {
        b(paramNewResultResp.resultMessage);
      }
    }
  }
  
  public NewResultResp c()
  {
    return this.f.newOrderCreate((String)this.b.additionalParams.get("memberId"), (String)this.b.additionalParams.get("amount"), this.b.chosenCard.agreementNo, this.b.chosenCard.paymentType, (String)this.b.additionalParams.get("notifyUrl"), (String)this.b.additionalParams.get("merchantOrderNo"), (String)this.b.additionalParams.get("orderName"), (String)this.b.additionalParams.get("merchantNo"), (String)this.b.additionalParams.get("merchantName"), this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */