package com.wifipay.wallet.cashier.a;

import com.wifipay.common.a.g;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.prod.bandcard.dto.BindCardPreSignResp;
import com.wifipay.wallet.prod.bandcard.dto.BindCardPreSignResp.ResultObject;
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.pay.NewResultResp;
import com.wifipay.wallet.prod.pay.NewResultResp.ResultObject;
import com.wifipay.wallet.prod.pay.PayService;
import java.util.HashMap;

public class o
  extends a
{
  private PayService e;
  
  public o(SuperActivity paramSuperActivity, StartPayParams paramStartPayParams, PayListener paramPayListener)
  {
    super(paramSuperActivity, paramStartPayParams, paramPayListener);
  }
  
  public void a(BindCardPreSignResp paramBindCardPreSignResp)
  {
    this.c.d();
    if (ResponseCode.SUCCESS.getCode().equals(paramBindCardPreSignResp.resultCode))
    {
      this.b.additionalParams.put("payPwd", this.a);
      this.b.additionalParams.put("paymentType", "CONVENIENCE");
      this.b.additionalParams.put("mobile", this.b.additionalParams.get("mobile"));
      if ((paramBindCardPreSignResp.resultObject != null) && (!g.a(paramBindCardPreSignResp.resultObject.requestNo))) {
        this.b.additionalParams.put("requestNo", paramBindCardPreSignResp.resultObject.requestNo);
      }
      this.b.type = CashierType.CALLAPPPAY.getType();
      a();
    }
    for (;;)
    {
      return;
      this.c.a(paramBindCardPreSignResp.resultMessage);
    }
  }
  
  public void a(NewResultResp paramNewResultResp)
  {
    if (ResponseCode.SUCCESS.getCode().equals(paramNewResultResp.resultCode))
    {
      this.b.additionalParams.put("orderId", paramNewResultResp.resultObject.orderId);
      this.b.additionalParams.put("pwd", this.a);
      if ("Y".equalsIgnoreCase(paramNewResultResp.resultObject.needSendSms)) {
        BackgroundExecutor.a(new q(this));
      }
    }
    for (;;)
    {
      return;
      this.c.a(paramNewResultResp.resultMessage);
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    this.c.c("");
    BackgroundExecutor.a(new p(this));
  }
  
  public NewResultResp b()
  {
    return this.e.newOrderCreate((String)this.b.additionalParams.get("memberId"), (String)this.b.additionalParams.get("amount"), this.b.chosenCard.agreementNo, this.b.chosenCard.paymentType, (String)this.b.additionalParams.get("notifyUrl"), (String)this.b.additionalParams.get("merchantOrderNo"), (String)this.b.additionalParams.get("orderName"), (String)this.b.additionalParams.get("merchantNo"), (String)this.b.additionalParams.get("merchantName"), this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */