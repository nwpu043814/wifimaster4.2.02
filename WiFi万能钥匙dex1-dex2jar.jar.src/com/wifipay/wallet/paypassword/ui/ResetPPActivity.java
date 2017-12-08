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
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard.onPasswordChanged;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox.onCompletedListener;

public class ResetPPActivity
  extends BaseActivity
  implements WPSafeKeyboard.onPasswordChanged, WPSixInputBox.onCompletedListener
{
  private WPSixInputBox h;
  private WPSafeKeyboard i;
  private String j;
  private String k;
  
  static
  {
    StubApp1053578832.interface11(133);
  }
  
  private void i()
  {
    this.h = ((WPSixInputBox)findViewById(R.id.wifipay_pp_general_safe_edit));
    this.i = ((WPSafeKeyboard)findViewById(R.id.wifipay_pp_general_safe_keyboard));
    String str = f.a(R.string.wifipay_reset_pp_note);
    ((TextView)findViewById(R.id.wifipay_pp_general_note)).setText(str);
    this.i.setListener(this);
    this.h.setListener(this);
  }
  
  public boolean a()
  {
    if ((!g.a(this.k)) && (g.a(CashierType.CALLAPPPAY.getType(), this.k))) {
      EventBus.getDefault().post(new com.wifipay.wallet.paypassword.widget.a());
    }
    return super.a();
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
      Intent localIntent = new Intent(this, ResetPPRepeatActivity.class);
      localIntent.putExtra("result", this.j);
      if (!g.a(this.k)) {
        localIntent.putExtra("cashier_type", this.k);
      }
      com.wifipay.wallet.common.info.a.a().a(new String[] { "pay_pwd", this.i.getPassword() });
      startActivity(localIntent);
      finish();
    }
    for (;;)
    {
      return;
      b(f.a(R.string.wifipay_pwd_crypto_error));
      runOnUiThread(new i(this));
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
    this.j = getIntent().getStringExtra("result");
    this.k = getIntent().getStringExtra("cashier_type");
    i();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!g.a(this.k)) && (g.a(CashierType.CALLAPPPAY.getType(), this.k))) {
      EventBus.getDefault().post(new com.wifipay.wallet.paypassword.widget.a());
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/ResetPPActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */