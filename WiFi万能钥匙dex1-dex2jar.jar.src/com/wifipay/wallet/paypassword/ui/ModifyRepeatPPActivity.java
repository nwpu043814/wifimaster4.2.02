package com.wifipay.wallet.paypassword.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.dimen;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard.onPasswordChanged;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox.onCompletedListener;
import com.wifipay.wallet.prod.paypassword.ModifyPPResp;

public class ModifyRepeatPPActivity
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
    StubApp1053578832.interface11(130);
  }
  
  private void i()
  {
    this.k = getIntent().getStringExtra("old_pwd");
    this.l = getIntent().getStringExtra("new_pwd");
    this.h = ((WPSixInputBox)findViewById(R.id.wifipay_pp_general_safe_edit));
    this.i = ((WPSafeKeyboard)findViewById(R.id.wifipay_pp_general_safe_keyboard));
    String str = com.wifipay.common.a.f.a(R.string.wifipay_pp_note_repeat);
    TextView localTextView = (TextView)findViewById(R.id.wifipay_pp_general_note);
    localTextView.setPadding(0, getResources().getDimensionPixelSize(R.dimen.wifipay_xxh_space_23px), 0, 0);
    localTextView.setText(str);
    this.j = ((Button)findViewById(R.id.wifipay_pp_general_btn_confirm));
    this.j.setVisibility(0);
    this.j.setOnClickListener(this);
    this.h.setListener(this);
    this.i.setListener(this);
    this.j.setEnabled(false);
  }
  
  private void j()
  {
    BackgroundExecutor.a(new e(this));
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
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleSetModifyPP(ModifyPPResp paramModifyPPResp)
  {
    d();
    if (com.wifipay.wallet.common.utils.f.a(paramModifyPPResp))
    {
      if (!ResponseCode.SUCCESS.getCode().equals(paramModifyPPResp.resultCode)) {
        break label42;
      }
      a(com.wifipay.common.a.f.a(R.string.wifipay_modify_success));
      finish();
    }
    for (;;)
    {
      return;
      label42:
      a(paramModifyPPResp.resultMessage);
      paramModifyPPResp = new Intent(this, ModifyNewPPActivity.class);
      paramModifyPPResp.putExtra("old_pwd", this.k);
      startActivity(paramModifyPPResp);
      finish();
    }
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
      j();
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
    a(getResources().getString(R.string.wifipay_setting_text_alter_password));
    i();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/ModifyRepeatPPActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */