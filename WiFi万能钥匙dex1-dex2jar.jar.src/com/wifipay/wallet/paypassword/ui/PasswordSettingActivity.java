package com.wifipay.wallet.paypassword.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard.onPasswordChanged;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox.onCompletedListener;

public class PasswordSettingActivity
  extends BaseActivity
  implements WPSafeKeyboard.onPasswordChanged, WPSixInputBox.onCompletedListener
{
  private WPSixInputBox h;
  private WPSafeKeyboard i;
  private String j;
  
  static
  {
    StubApp1053578832.interface11(132);
  }
  
  private void i()
  {
    this.j = getIntent().getStringExtra("result");
    this.h = ((WPSixInputBox)findViewById(R.id.wifipay_pp_general_safe_edit));
    this.i = ((WPSafeKeyboard)findViewById(R.id.wifipay_pp_general_safe_keyboard));
    String str = f.a(R.string.wifipay_set_pp_note);
    ((TextView)findViewById(R.id.wifipay_pp_general_note)).setText(str);
    this.h.setListener(this);
    this.i.setListener(this);
  }
  
  private void j()
  {
    a(null, f.a(R.string.wifipay_alert_cancel_set_pp), f.a(R.string.wifipay_common_confirm), new h(this), f.a(R.string.wifipay_common_cancel), null);
  }
  
  private void k()
  {
    EventBus.getDefault().postSticky(new com.wifipay.wallet.a.g(this.i.getPassword()));
    EventBus.getDefault().post(new com.wifipay.wallet.paypassword.widget.a());
    finish();
  }
  
  public boolean a()
  {
    if (b.a().j() == 2) {
      j();
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
      return;
      this.h.a();
    }
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
      Intent localIntent = new Intent(this, PasswordRepeatActivity.class);
      localIntent.putExtra("result", this.j);
      com.wifipay.wallet.common.info.a.a().a(new String[] { "pay_pwd", this.i.getPassword() });
      startActivity(localIntent);
      finish();
    }
    for (;;)
    {
      return;
      b(f.a(R.string.wifipay_pwd_crypto_error));
      runOnUiThread(new g(this));
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
    a(getResources().getString(R.string.wifipay_set_pp_title));
    i();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (b.a().j() == 2)) {
      j();
    }
    for (boolean bool = true;; bool = super.onKeyDown(paramInt, paramKeyEvent))
    {
      return bool;
      k();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/PasswordSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */