package com.wifipay.wallet.paypassword.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.a.g;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard.onPasswordChanged;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox.onCompletedListener;
import com.wifipay.wallet.prod.paypassword.PPService;
import com.wifipay.wallet.prod.paypassword.SetPwdResp;

public class PasswordRepeatActivity
  extends BaseActivity
  implements View.OnClickListener, WPSafeKeyboard.onPasswordChanged, WPSixInputBox.onCompletedListener
{
  private WPSixInputBox h;
  private WPSafeKeyboard i;
  private Button j;
  private String k;
  private String l;
  
  static
  {
    StubApp1053578832.interface11(131);
  }
  
  private void j()
  {
    this.k = com.wifipay.wallet.common.info.a.a().a("pay_pwd");
    this.h = ((WPSixInputBox)findViewById(R.id.wifipay_pp_general_safe_edit));
    this.i = ((WPSafeKeyboard)findViewById(R.id.wifipay_pp_general_safe_keyboard));
    String str = com.wifipay.common.a.f.a(R.string.wifipay_set_pp_note_repeat);
    ((TextView)findViewById(R.id.wifipay_pp_general_note)).setText(str);
    this.j = ((Button)findViewById(R.id.wifipay_pp_general_btn_confirm));
    this.j.setVisibility(0);
    this.h.setListener(this);
    this.i.setListener(this);
    this.j.setOnClickListener(this);
    this.j.setEnabled(false);
  }
  
  private void k()
  {
    EventBus.getDefault().postSticky(new g(this.i.getPassword()));
    EventBus.getDefault().post(new com.wifipay.wallet.paypassword.widget.a());
    finish();
  }
  
  private void l()
  {
    a(null, com.wifipay.common.a.f.a(R.string.wifipay_alert_cancel_set_pp), com.wifipay.common.a.f.a(R.string.wifipay_common_confirm), new f(this), com.wifipay.common.a.f.a(R.string.wifipay_common_cancel), null);
  }
  
  public boolean a()
  {
    if (b.a().j() == 2) {
      l();
    }
    for (boolean bool = true;; bool = super.a())
    {
      return bool;
      k();
    }
  }
  
  public void addPassword()
  {
    this.h.c();
  }
  
  public void deletePassword(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.h.b();
    }
    for (;;)
    {
      this.j.setEnabled(false);
      return;
      this.h.a();
    }
  }
  
  @Subscribe
  public void handleSet(SetPwdResp paramSetPwdResp)
  {
    d();
    if (ResponseCode.SUCCESS.getCode().equals(paramSetPwdResp.resultCode))
    {
      b.a().c().setWalletState(3);
      k();
    }
    for (;;)
    {
      return;
      a(paramSetPwdResp.resultMessage);
      paramSetPwdResp = new Intent(this, PasswordSettingActivity.class);
      paramSetPwdResp.putExtra("result", this.l);
      startActivity(paramSetPwdResp);
      finish();
    }
  }
  
  protected void i()
  {
    ((PPService)RpcService.getBgRpcProxy(PPService.class)).setPayPwdSecond(this.l, this.k, this.i.getPassword());
  }
  
  public void invokeKeyboard()
  {
    this.i.d();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_pp_general_btn_confirm)
    {
      c("");
      i();
    }
  }
  
  public void onCompleted(boolean paramBoolean)
  {
    d();
    if (paramBoolean) {
      this.i.c();
    }
    this.j.setEnabled(paramBoolean);
  }
  
  public void onCompletedAdd()
  {
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.wifipay_activity_password_general);
    a(getResources().getString(R.string.wifipay_set_pp_verify));
    j();
    this.k = com.wifipay.wallet.common.info.a.a().b("pay_pwd");
    this.l = getIntent().getStringExtra("result");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (b.a().j() == 2)) {
      l();
    }
    for (boolean bool = true;; bool = super.onKeyDown(paramInt, paramKeyEvent))
    {
      return bool;
      k();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/PasswordRepeatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */