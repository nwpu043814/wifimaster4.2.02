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
import com.wifipay.common.a.f;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.a.e;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard.onPasswordChanged;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox.onCompletedListener;
import com.wifipay.wallet.prod.paypassword.PPService;
import com.wifipay.wallet.prod.paypassword.ResetPPConfirmResp;

public class ResetPPRepeatActivity
  extends BaseActivity
  implements View.OnClickListener, WPSafeKeyboard.onPasswordChanged, WPSixInputBox.onCompletedListener
{
  private Button h;
  private WPSixInputBox i;
  private WPSafeKeyboard j;
  private String k;
  private String l;
  private String m;
  
  static
  {
    StubApp1053578832.interface11(134);
  }
  
  private void j()
  {
    this.i = ((WPSixInputBox)findViewById(R.id.wifipay_pp_general_safe_edit));
    this.j = ((WPSafeKeyboard)findViewById(R.id.wifipay_pp_general_safe_keyboard));
    String str = f.a(R.string.wifipay_reset_pp_note_repeat);
    ((TextView)findViewById(R.id.wifipay_pp_general_note)).setText(str);
    this.h = ((Button)findViewById(R.id.wifipay_pp_general_btn_confirm));
    this.h.setVisibility(0);
    this.h.setOnClickListener(this);
    this.j.setListener(this);
    this.i.setListener(this);
    this.h.setEnabled(false);
  }
  
  private void k()
  {
    EventBus.getDefault().post(new e());
    finish();
  }
  
  public boolean a()
  {
    if ((!g.a(this.m)) && (g.a(CashierType.CALLAPPPAY.getType(), this.m))) {
      EventBus.getDefault().post(new com.wifipay.wallet.paypassword.widget.a());
    }
    return super.a();
  }
  
  public void addPassword()
  {
    this.i.c();
  }
  
  public void deletePassword(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.i.b();
    }
    for (;;)
    {
      this.h.setEnabled(false);
      return;
      this.i.a();
    }
  }
  
  @Subscribe
  public void handleResetPP(ResetPPConfirmResp paramResetPPConfirmResp)
  {
    d();
    if (ResponseCode.SUCCESS.getCode().equals(paramResetPPConfirmResp.resultCode))
    {
      b.a().c().setWalletState(3);
      if ((!g.a(this.m)) && (g.a(CashierType.CALLAPPPAY.getType(), this.m))) {
        EventBus.getDefault().post(new com.wifipay.wallet.paypassword.widget.a());
      }
      k();
    }
    for (;;)
    {
      return;
      a(paramResetPPConfirmResp.resultMessage);
      paramResetPPConfirmResp = new Intent(this, ResetPPActivity.class);
      if (!g.a(this.m)) {
        paramResetPPConfirmResp.putExtra("cashier_type", this.m);
      }
      paramResetPPConfirmResp.putExtra("result", this.k);
      startActivity(paramResetPPConfirmResp);
      finish();
    }
  }
  
  protected void i()
  {
    ((PPService)RpcService.getBgRpcProxy(PPService.class)).resetPPConfirmSecond(this.k, this.l, this.j.getPassword());
  }
  
  public void invokeKeyboard()
  {
    this.j.d();
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
      this.j.c();
    }
    this.h.setEnabled(paramBoolean);
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
    this.k = getIntent().getStringExtra("result");
    this.l = com.wifipay.wallet.common.info.a.a().b("pay_pwd");
    this.m = getIntent().getStringExtra("cashier_type");
    j();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!g.a(this.m)) && (g.a(CashierType.CALLAPPPAY.getType(), this.m))) {
      EventBus.getDefault().post(new com.wifipay.wallet.paypassword.widget.a());
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/ResetPPRepeatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */