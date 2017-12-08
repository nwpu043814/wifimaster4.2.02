package com.wifipay.wallet.cashier.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.color;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.common.logging.Logger;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.a.e;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.CountDown;
import com.wifipay.wallet.common.utils.CountDown.OnCountDownListener;
import com.wifipay.wallet.paypassword.ui.PasswordSettingActivity;
import com.wifipay.wallet.paypassword.ui.ResetPPActivity;
import com.wifipay.wallet.prod.bandcard.BindCardService;
import com.wifipay.wallet.prod.bandcard.dto.BindCardDoSignResp;
import com.wifipay.wallet.prod.bandcard.dto.BindCardDoSignResp.ResultObject;
import com.wifipay.wallet.prod.bandcard.dto.BindCardPreSignResp;
import com.wifipay.wallet.prod.bandcard.dto.BindCardPreSignResp.ResultObject;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.deposit.DepositOrderConfirmResp;
import com.wifipay.wallet.prod.deposit.DepositOrderCreateResp;
import com.wifipay.wallet.prod.deposit.DepositOrderSendCodeResp;
import com.wifipay.wallet.prod.deposit.DepositService;
import com.wifipay.wallet.prod.pay.NewResultResp;
import com.wifipay.wallet.prod.pay.PayResultResp;
import com.wifipay.wallet.prod.pay.PayService;
import com.wifipay.wallet.prod.paypassword.PPService;
import com.wifipay.wallet.prod.paypassword.ResetPPSmsResp;
import com.wifipay.wallet.prod.paypassword.ResetPPSmsResp.ResultObject;
import com.wifipay.wallet.prod.transfer.TransConfirm3Resp;
import com.wifipay.wallet.prod.transfer.TransferService;
import java.util.HashMap;
import java.util.Map;

public class SMSValidatorActivity
  extends BaseActivity
  implements View.OnClickListener, CountDown.OnCountDownListener
{
  private TextView h;
  private EditText i;
  private CountDown j;
  private HashMap<String, String> k;
  private String l;
  private String m;
  private BindCardDoSignResp n;
  private String o;
  
  static
  {
    StubApp1053578832.interface11(113);
  }
  
  private void a(int paramInt, BaseResp paramBaseResp)
  {
    EventBus.getDefault().postSticky(new com.wifipay.wallet.a.d(this.l, paramInt, paramBaseResp));
    EventBus.getDefault().post(new e());
    finish();
  }
  
  private void a(String paramString, BindCardDoSignResp paramBindCardDoSignResp)
  {
    if (CashierType.BINDCARD.getType().equals(paramString))
    {
      b(paramBindCardDoSignResp);
      return;
    }
    EventBus localEventBus = EventBus.getDefault();
    if (CashierType.WITHDRAW.getType().equals(paramString)) {}
    for (paramBindCardDoSignResp = paramBindCardDoSignResp.resultObject.bankAccountId;; paramBindCardDoSignResp = paramBindCardDoSignResp.resultObject.agreementNo)
    {
      localEventBus.postSticky(new com.wifipay.wallet.a.b(paramString, paramBindCardDoSignResp, (String)this.k.get("mobile")));
      b(null);
      break;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!this.l.equals(CashierType.BINDCARD.getType())) {}
    for (;;)
    {
      return;
      HashMap localHashMap = new HashMap();
      localHashMap.put("verifyCode", this.i.getText().toString());
      com.wifipay.wallet.common.utils.a.a(this, getClass().getSimpleName(), paramString1, paramString2, localHashMap);
    }
  }
  
  private boolean a(BaseResp paramBaseResp)
  {
    d();
    if ((ResponseCode.HPS_VALIDCODE_ERROR.getCode().equals(paramBaseResp.resultCode)) || (ResponseCode.MAS_CODE_8.getCode().equals(paramBaseResp.resultCode)) || (ResponseCode.MAS_CODE_17.getCode().equals(paramBaseResp.resultCode)))
    {
      b(paramBaseResp.resultMessage);
      EventBus.getDefault().removeChildEvent(paramBaseResp);
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private void b(BaseResp paramBaseResp)
  {
    a(-1, paramBaseResp);
  }
  
  private void e(int paramInt)
  {
    String str = this.o.replace("[count]", String.valueOf(paramInt));
    this.h.setText(str);
  }
  
  private void i()
  {
    this.o = com.wifipay.common.a.f.a(R.string.wifipay_verify_code_get_again);
    this.i = ((EditText)findViewById(R.id.wifipay_sms_verify_code));
    this.h = ((TextView)findViewById(R.id.wifipay_sms_btn_get_code));
    Object localObject = (TextView)findViewById(R.id.wifipay_unverification_code);
    ((TextView)findViewById(R.id.wifipay_sms_validator_phone)).setText(getString(R.string.wifipay_validator_phone_sms, new Object[] { j(), com.wifipay.wallet.common.utils.d.k((String)this.k.get("mobile")) }));
    Button localButton = (Button)findViewById(R.id.wifipay_sms_submit);
    this.h.setOnClickListener(this);
    ((TextView)localObject).setOnClickListener(this);
    localButton.setOnClickListener(this);
    localObject = new com.wifipay.framework.api.b();
    com.wifipay.framework.api.b localb = new com.wifipay.framework.api.b();
    ((com.wifipay.framework.api.b)localObject).a(this.h);
    localb.a(this.i);
    localb.a(localButton);
    o();
  }
  
  private String j()
  {
    String str1 = "";
    if (TextUtils.equals(this.l, CashierType.DEPOSIT.getType())) {
      str1 = getString(R.string.wifipay_deposit_title);
    }
    for (;;)
    {
      Logger.w("SMSValidatorActivity == %s", new Object[] { this.l });
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = getString(R.string.wifipay_unknown_type);
      }
      return str2;
      if (TextUtils.equals(this.l, CashierType.TRANSFER.getType())) {
        str1 = getString(R.string.wifipay_transfer_title);
      } else if (TextUtils.equals(this.l, CashierType.WITHDRAW.getType())) {
        str1 = getString(R.string.wifipay_withdraw_title);
      } else if (TextUtils.equals(this.l, CashierType.CALLAPPPAY.getType())) {
        str1 = getString(R.string.wifipay_callpay_title);
      } else if (TextUtils.equals(this.l, CashierType.BINDCARD.getType())) {
        str1 = getString(R.string.wifipay_bindcard_title);
      }
    }
  }
  
  private void k()
  {
    StartPayParams localStartPayParams = (StartPayParams)getIntent().getSerializableExtra("pay_params");
    if (com.wifipay.wallet.common.utils.f.a(localStartPayParams))
    {
      this.k = localStartPayParams.additionalParams;
      this.l = localStartPayParams.type;
      this.m = localStartPayParams.bindcardsource;
      Logger.v("zhao SMSValidatorActivity mBindCardSource == %s ", new Object[] { this.m });
      return;
    }
    throw new IllegalArgumentException("SMSValidatorActivity pay params null!");
  }
  
  private void l()
  {
    c("");
    Logger.v("zhao SMSValidatorActivity mCashierType == %s ", new Object[] { this.l });
    if (this.l.equals(CashierType.BINDCARD.getType())) {
      ((BindCardService)RpcService.getBgRpcProxy(BindCardService.class)).doSign((String)this.k.get("requestNo"), this.i.getText().toString(), (String)this.k.get("trueName"), (String)this.k.get("certNo"), (String)this.k.get("needSetPayPwd"));
    }
    for (;;)
    {
      return;
      if (this.l.equals(CashierType.DEPOSIT.getType())) {
        ((DepositService)RpcService.getBgRpcProxy(DepositService.class)).newDepositConfirm((String)this.k.get("depositId"), (String)this.k.get("requestNo"), this.i.getText().toString(), (String)this.k.get("certNo"), (String)this.k.get("trueName"), (String)this.k.get("mobile"), (String)this.k.get("payPwd"));
      } else if (this.l.equals(CashierType.TRANSFER.getType())) {
        ((TransferService)RpcService.getBgRpcProxy(TransferService.class)).newOrderConfirmTrans((String)this.k.get("orderId"), this.i.getText().toString(), (String)this.k.get("certNo"), (String)this.k.get("trueName"), (String)this.k.get("requestNo"), (String)this.k.get("mobile"), (String)this.k.get("payPwd"), (String)this.k.get("payeeLoginName"));
      } else if (this.l.equals(CashierType.CALLAPPPAY.getType())) {
        ((PayService)RpcService.getBgRpcProxy(PayService.class)).newOrderPay((String)this.k.get("memberId"), (String)this.k.get("merchantNo"), (String)this.k.get("merchantOrderNo"), (String)this.k.get("amount"), this.i.getText().toString(), (String)this.k.get("requestNo"), (String)this.k.get("trueName"), (String)this.k.get("certNo"), (String)this.k.get("paymentType"), (String)this.k.get("notifyUrl"), (String)this.k.get("payPwd"), (String)this.k.get("orderId"), (String)this.k.get("mobile"));
      } else if (this.l.equals(CashierType.RETRIEVEPASSWORD.getType())) {
        ((PPService)RpcService.getBgRpcProxy(PPService.class)).resetPPVerifyCode((String)this.k.get("requestNo"), (String)this.k.get("mobile"), this.i.getText().toString());
      }
    }
  }
  
  private void m()
  {
    if ((this.l.equals(CashierType.BINDCARD.getType())) || (this.l.equals(CashierType.DEPOSIT.getType())) || (this.l.equals(CashierType.TRANSFER.getType())) || (this.l.equals(CashierType.CALLAPPPAY.getType()))) {
      ((BindCardService)RpcService.getBgRpcProxy(BindCardService.class)).preSign((String)this.k.get("bankCode"), (String)this.k.get("cardNo"), (String)this.k.get("cardType"), (String)this.k.get("trueName"), (String)this.k.get("certNo"), (String)this.k.get("cvv2"), (String)this.k.get("validDate"), (String)this.k.get("mobile"));
    }
    for (;;)
    {
      a("重新获取验证码", "");
      return;
      if (this.l.equals(CashierType.RETRIEVEPASSWORD.getType())) {
        ((PPService)RpcService.getBgRpcProxy(PPService.class)).resetPPPre((String)this.k.get("agreementNo"), (String)this.k.get("certNo"), (String)this.k.get("cardNo"), (String)this.k.get("cvv2"), (String)this.k.get("validDate"), (String)this.k.get("mobile"));
      }
    }
  }
  
  private void n()
  {
    a(0, null);
  }
  
  private void o()
  {
    e(60);
    this.j = new CountDown(60);
    this.j.a(this);
    this.j.a(1000);
    this.h.setEnabled(false);
    this.h.setTextColor(getResources().getColor(R.color.wifipay_color_86c8fe));
  }
  
  private void p()
  {
    Object localObject = getResources().getString(R.string.wifipay_unreceived_auth_code);
    TextView localTextView = (TextView)LayoutInflater.from(this).inflate(R.layout.wifipay_unverification_code, null);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new URLSpan("tel:4007208888"), ((SpannableString)localObject).length() - 11, ((SpannableString)localObject).length() - 1, 33);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(getResources().getColor(R.color.wifipay_color_0285f0)), ((SpannableString)localObject).length() - 11, ((SpannableString)localObject).length() - 1, 33);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setText((CharSequence)localObject);
    a("收不到验证码", "知道了", null, localTextView);
  }
  
  public boolean a()
  {
    a("返回", "");
    return super.a();
  }
  
  @Subscribe
  public void handleDepositConfrim(DepositOrderConfirmResp paramDepositOrderConfirmResp)
  {
    if (!a(paramDepositOrderConfirmResp)) {}
    for (;;)
    {
      return;
      b(paramDepositOrderConfirmResp);
    }
  }
  
  @Subscribe
  public void handleDepositConfrim(DepositOrderCreateResp paramDepositOrderCreateResp)
  {
    if (!a(paramDepositOrderCreateResp)) {}
    for (;;)
    {
      return;
      b(paramDepositOrderCreateResp);
    }
  }
  
  @Subscribe
  public void handleDepositSendCode(DepositOrderSendCodeResp paramDepositOrderSendCodeResp)
  {
    if (!a(paramDepositOrderSendCodeResp)) {}
    for (;;)
    {
      return;
      if (!ResponseCode.SUCCESS.getCode().equals(paramDepositOrderSendCodeResp.resultCode))
      {
        this.j.a();
        onCountDownFinished();
      }
    }
  }
  
  @Subscribe
  public void handleDoSign(BindCardDoSignResp paramBindCardDoSignResp)
  {
    if (!a(paramBindCardDoSignResp)) {}
    for (;;)
    {
      return;
      if (ResponseCode.SUCCESS.getCode().equals(paramBindCardDoSignResp.resultCode))
      {
        if (com.wifipay.common.a.g.a(this.m)) {
          this.m = CashierType.BINDCARD.getType();
        }
        if ((!getIntent().getBooleanExtra("has_digit_pwd", false)) && (!com.wifipay.common.a.g.a(paramBindCardDoSignResp.resultObject.setPayPwdRequestNo)))
        {
          this.n = paramBindCardDoSignResp;
          Intent localIntent = new Intent(this, PasswordSettingActivity.class);
          localIntent.putExtra("result", paramBindCardDoSignResp.resultObject.setPayPwdRequestNo);
          startActivity(localIntent);
        }
        else
        {
          a(this.m, paramBindCardDoSignResp);
        }
      }
      else
      {
        a(paramBindCardDoSignResp.resultMessage);
        n();
      }
    }
  }
  
  @Subscribe
  public void handleNewOrderPay(NewResultResp paramNewResultResp)
  {
    if (!a(paramNewResultResp)) {}
    for (;;)
    {
      return;
      if (!ResponseCode.SUCCESS.getCode().equals(paramNewResultResp.resultCode)) {
        a(paramNewResultResp.resultMessage);
      }
      b(paramNewResultResp);
    }
  }
  
  @Subscribe
  public void handleOrderPay(PayResultResp paramPayResultResp)
  {
    if (!a(paramPayResultResp)) {}
    for (;;)
    {
      return;
      if (!ResponseCode.SUCCESS.getCode().equals(paramPayResultResp.resultCode)) {
        a(paramPayResultResp.resultMessage);
      }
      b(paramPayResultResp);
    }
  }
  
  @Subscribe
  public void handlePreCheck(BaseResp paramBaseResp)
  {
    a(paramBaseResp);
    a("下一步", paramBaseResp.resultMessage);
  }
  
  @Subscribe
  public void handlePreSign(BindCardPreSignResp paramBindCardPreSignResp)
  {
    if (!a(paramBindCardPreSignResp)) {}
    for (;;)
    {
      return;
      if (ResponseCode.SUCCESS.getCode().equals(paramBindCardPreSignResp.resultCode))
      {
        if (paramBindCardPreSignResp.resultObject != null) {
          this.k.put("requestNo", paramBindCardPreSignResp.resultObject.requestNo);
        }
      }
      else {
        b(paramBindCardPreSignResp.resultMessage);
      }
    }
  }
  
  @Subscribe
  public void handleResetPP(ResetPPSmsResp paramResetPPSmsResp)
  {
    d();
    if (ResponseCode.SUCCESS.getCode().equals(paramResetPPSmsResp.resultCode))
    {
      Intent localIntent = new Intent(this, ResetPPActivity.class);
      localIntent.putExtra("result", paramResetPPSmsResp.resultObject.requestNo);
      startActivity(localIntent);
      finish();
    }
    for (;;)
    {
      return;
      b(paramResetPPSmsResp.resultMessage);
    }
  }
  
  @Subscribe(sticky=true, threadMode=ThreadMode.MAIN)
  public void handleSetPPEvent(com.wifipay.wallet.a.g paramg)
  {
    Logger.v("zhao SetPPEvent == %s", new Object[] { this.m });
    if (!CashierType.BINDCARD.getType().equals(this.m)) {
      com.wifipay.wallet.common.info.a.a().a(new String[] { "pay_pwd", paramg.a });
    }
    a(this.m, this.n);
  }
  
  @Subscribe
  public void handleTrans3WithSms(TransConfirm3Resp paramTransConfirm3Resp)
  {
    if (!a(paramTransConfirm3Resp)) {}
    for (;;)
    {
      return;
      b(paramTransConfirm3Resp);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_sms_btn_get_code)
    {
      m();
      o();
    }
    if (paramView.getId() == R.id.wifipay_unverification_code) {
      p();
    }
    if (paramView.getId() == R.id.wifipay_sms_submit) {
      l();
    }
  }
  
  public void onCountDownFinished()
  {
    this.h.setEnabled(true);
    this.h.setTextColor(getResources().getColor(R.color.wifipay_color_0285f0));
    this.h.setText(R.string.wifipay_verify_code_gain);
  }
  
  public void onCountDownRun(int paramInt1, int paramInt2)
  {
    e(paramInt2);
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.j != null) {
      this.j.a();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      a("返回", "");
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/ui/SMSValidatorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */