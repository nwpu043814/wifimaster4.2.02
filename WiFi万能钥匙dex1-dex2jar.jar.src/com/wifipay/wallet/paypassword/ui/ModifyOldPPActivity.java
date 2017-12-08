package com.wifipay.wallet.paypassword.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.dimen;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.paypassword.common.PreRetrievePP.onListener;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard.onPasswordChanged;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox.onCompletedListener;
import com.wifipay.wallet.prod.paypassword.PPService;
import com.wifipay.wallet.prod.paypassword.VerifyPayPwdResp;

public class ModifyOldPPActivity
  extends BaseActivity
  implements PreRetrievePP.onListener, WPSafeKeyboard.onPasswordChanged, WPSixInputBox.onCompletedListener
{
  private WPSixInputBox h;
  private WPSafeKeyboard i;
  private String j;
  
  static
  {
    StubApp1053578832.interface11(129);
  }
  
  private void e(String paramString)
  {
    a("", paramString, com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_i_know), new c(this), null, null);
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
        break label59;
      }
      paramVerifyPayPwdResp = new Intent(this, ModifyNewPPActivity.class);
      paramVerifyPayPwdResp.putExtra("old_pwd", this.j);
      startActivity(paramVerifyPayPwdResp);
      finish();
    }
    for (;;)
    {
      return;
      label59:
      e(paramVerifyPayPwdResp.resultMessage);
    }
  }
  
  protected void i()
  {
    ((PPService)RpcService.getBgRpcProxy(PPService.class)).verifyPayPwd(this.j, null);
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
      this.j = this.i.getPassword();
      i();
    }
    for (;;)
    {
      return;
      b(com.wifipay.common.a.f.a(R.string.wifipay_pwd_crypto_error));
      runOnUiThread(new b(this));
    }
  }
  
  public void onCompletedAdd()
  {
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.wifipay_activity_password_general);
    a(getResources().getString(R.string.wifipay_setting_text_alter_password));
    j();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/ModifyOldPPActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */