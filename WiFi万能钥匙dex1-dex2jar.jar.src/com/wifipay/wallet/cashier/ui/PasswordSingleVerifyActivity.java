package com.wifipay.wallet.cashier.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.dimen;
import com.wifipay.R.id;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.info.AppInfo;
import com.wifipay.wallet.common.info.a;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.paypassword.common.PreRetrievePP;
import com.wifipay.wallet.paypassword.common.PreRetrievePP.onListener;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard.onPasswordChanged;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox.onCompletedListener;
import com.wifipay.wallet.prod.paypassword.PPService;
import com.wifipay.wallet.prod.paypassword.VerifyPayPwdResp;

public class PasswordSingleVerifyActivity
  extends BaseActivity
  implements PreRetrievePP.onListener, WPSafeKeyboard.onPasswordChanged, WPSixInputBox.onCompletedListener
{
  private WPSixInputBox h;
  private WPSafeKeyboard i;
  
  static
  {
    StubApp1053578832.interface11(112);
  }
  
  private void e(String paramString)
  {
    a("", paramString, com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_i_know), new f(this), null, null);
  }
  
  private void f(String paramString)
  {
    a("", paramString, com.wifipay.common.a.f.a(R.string.wifipay_common_repeat), new g(this), com.wifipay.common.a.f.a(R.string.wifipay_forget_pwd), new h(this));
  }
  
  private void j()
  {
    this.h = ((WPSixInputBox)findViewById(R.id.wifipay_pp_general_safe_edit));
    this.i = ((WPSafeKeyboard)findViewById(R.id.wifipay_pp_general_safe_keyboard));
    String str = com.wifipay.common.a.f.a(R.string.wifipay_verify_pp_note);
    TextView localTextView = (TextView)findViewById(R.id.wifipay_pp_general_note);
    localTextView.setText(str);
    localTextView.setGravity(17);
    localTextView.setPadding(0, getResources().getDimensionPixelSize(R.dimen.wifipay_xxh_space_9px), 0, 0);
    this.h.setListener(this);
    this.i.setListener(this);
  }
  
  private void k()
  {
    if (getIntent().getBooleanExtra("save_ped", false)) {
      a.a().a(new String[] { "pay_pwd", this.i.getPassword() });
    }
    Intent localIntent = AppInfo.INSTANCE.getNextIntent();
    if (com.wifipay.wallet.common.utils.f.a(localIntent)) {
      startActivity(localIntent);
    }
    finish();
  }
  
  private void l()
  {
    this.i.deletePassword(true);
  }
  
  private void m()
  {
    new PreRetrievePP(this, this).a();
  }
  
  public void addPassword()
  {
    this.h.c();
  }
  
  public void afterCheck()
  {
    finish();
  }
  
  public void deletePassword(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.h.b();
    }
    for (;;)
    {
      return;
      this.h.a();
    }
  }
  
  @Subscribe
  public void handleVerifyPwd(VerifyPayPwdResp paramVerifyPayPwdResp)
  {
    d();
    if (com.wifipay.wallet.common.utils.f.a(paramVerifyPayPwdResp))
    {
      if (!ResponseCode.SUCCESS.getCode().equals(paramVerifyPayPwdResp.resultCode)) {
        break label32;
      }
      k();
    }
    for (;;)
    {
      return;
      label32:
      if (ResponseCode.PAY_PWD_LOCKED.getCode().equals(paramVerifyPayPwdResp.resultCode)) {
        e(paramVerifyPayPwdResp.resultMessage);
      } else {
        f(paramVerifyPayPwdResp.resultMessage);
      }
    }
  }
  
  protected void i()
  {
    ((PPService)RpcService.getBgRpcProxy(PPService.class)).verifyPayPwd(this.i.getPassword());
  }
  
  public void invokeKeyboard()
  {
    this.i.d();
  }
  
  public void onCompleted(boolean paramBoolean)
  {
    d();
    if (paramBoolean)
    {
      c("");
      i();
    }
    for (;;)
    {
      return;
      l();
      b(com.wifipay.common.a.f.a(R.string.wifipay_pwd_crypto_error));
    }
  }
  
  public void onCompletedAdd()
  {
    e();
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/ui/PasswordSingleVerifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */