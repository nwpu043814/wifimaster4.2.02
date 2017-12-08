package com.wifipay.wallet.paypassword.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard.onPasswordChanged;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox.onCompletedListener;

public class ModifyNewPPActivity
  extends BaseActivity
  implements WPSafeKeyboard.onPasswordChanged, WPSixInputBox.onCompletedListener
{
  private WPSixInputBox h;
  private WPSafeKeyboard i;
  private String j;
  
  static
  {
    StubApp1053578832.interface11(128);
  }
  
  private void i()
  {
    this.j = getIntent().getStringExtra("old_pwd");
    this.h = ((WPSixInputBox)findViewById(R.id.wifipay_pp_general_safe_edit));
    this.i = ((WPSafeKeyboard)findViewById(R.id.wifipay_pp_general_safe_keyboard));
    String str = f.a(R.string.wifipay_modify_new_pp_note);
    ((TextView)findViewById(R.id.wifipay_pp_general_note)).setText(str);
    this.h.setListener(this);
    this.i.setListener(this);
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
      c("");
      Intent localIntent = new Intent(this, ModifyRepeatPPActivity.class);
      localIntent.putExtra("new_pwd", this.i.getPassword());
      localIntent.putExtra("old_pwd", this.j);
      startActivity(localIntent);
      finish();
    }
    for (;;)
    {
      return;
      b(f.a(R.string.wifipay_pwd_crypto_error));
      runOnUiThread(new a(this));
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
    i();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/ModifyNewPPActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */